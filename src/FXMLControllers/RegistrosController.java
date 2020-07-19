/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLControllers;

import FileManagers.PuestoFileReader;
import FileManagers.MedicoFileReader;
import FileManagers.LectorArchivos;
import FileManagers.ClassSerializer;
import ComponentesSistema.GeneradorTurnos;
import ComponentesSistema.Medico;
import ComponentesSistema.Paciente;
import ComponentesSistema.Puesto;
import ComponentesSistema.Sintoma;
import ComponentesSistema.Turno;
import FileManagers.SintomasFileReader;
import Resources.Alerts;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class RegistrosController implements Initializable {

    //Instancia Pagina Principal
    private SitemaPrincipalController principal;

    //FUNCIONALIDAD COMBOBOX
    private ObservableList<String> Lgenero;
    private ObservableList<String> LEspecialidad;
    private LinkedList<Sintoma> LSintomas;
    private LinkedList<Medico> LMedico;  //AGREGAR INFORMACION
    private LinkedList<Puesto> LPuesto; // AGREGAR INFORMACION
    private LectorArchivos reader;

    @FXML
    private ComboBox<String> cmbGenero;
    @FXML
    private ComboBox<String> cmbEspecialidad;
    @FXML
    private ComboBox<Sintoma> cmbSintomas;
    @FXML
    private ComboBox<Medico> cmbMedicoresponsable;
    @FXML
    private ComboBox<Puesto> cmbPuesto;

    //TEXT FIELDS
    @FXML
    private TextField txtNumeroPuesto;
    @FXML
    private TextField txtNombreDoctor;
    @FXML
    private TextField txtApellidoDoctor;
    @FXML
    private TextField txtNombrePaciente;
    @FXML
    private TextField txtApellidoPaciente;
    @FXML
    private TextField txtEdad;

    // GUARDAR INFORMACION
    @FXML
    private Button btnGuardarDoctor;
    @FXML
    private Button btnGuardarPaciente;
    @FXML
    private Button btnGuardarPuesto;

    public SitemaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(SitemaPrincipalController principal) {
        this.principal = principal;
    }
    
    
    /**
     * Constructor, Inicializa la instancia de la ventana principal
     */
    public RegistrosController() {
        llenarListas();
    }

    /**
     * Llena las listas
     */
    public void llenarListas() {
        reader = new MedicoFileReader();
        System.out.println("Medicos ser");
        LMedico = reader.LeerArchivo("medicos.ser");
        System.out.println("Puestos Ser");
        reader = new PuestoFileReader();
        LPuesto = reader.LeerArchivo("puestos.ser");
        System.out.println("Sintomas.txt");
        reader = new SintomasFileReader();
        LSintomas = reader.LeerArchivo("sintomas.txt");
    }

    /**
     * Method for set Items to combobox.
     */
    private void loadData() {
        cmbGenero.getItems().setAll(new String[]{"MASCULINO", "FEMENINO"});
        cmbEspecialidad.getItems().setAll(new String[]{"Medicina General", "Alergología", "Cardiología", "Angiología", "Cirugía General", "Dermatología", "Endocrinología", "Ecografía", "Hematología"});
        cmbSintomas.getItems().setAll(LSintomas);
        actualizarListaDoctores();
        cmbPuesto.getItems().setAll(LPuesto);
    }

    /**
     * Method for save Doctor data.
     */
    @FXML
    void guardarDoctor(ActionEvent event) {
        Medico medico = new Medico(txtNombreDoctor.getText(),
                txtApellidoDoctor.getText(),
                cmbEspecialidad.getValue());
        LMedico.add(medico);
        cmbMedicoresponsable.getItems().setAll(LMedico);
        txtNombreDoctor.setText("");
        txtApellidoDoctor.setText("");
        cmbEspecialidad.setValue(null);
    }

    /**
     * Method for save Paciente data.
     */
    @FXML
    void guardarPaciente(ActionEvent event) {
        Paciente p = new Paciente(txtNombrePaciente.getText(),
                txtApellidoPaciente.getText(),
                cmbGenero.getValue(),
                Integer.parseInt(txtEdad.getText()),
                cmbSintomas.getValue()
        );
        p.guardarPaciente();
        Turno t = GeneradorTurnos.generarTurnoConPaciente(p);

        vaciarInputsPacientes();
        principal.getTurnos().offer(t);
        principal.asignarPuestoATurno();
    }

    public void vaciarInputsPacientes() {
        txtNombrePaciente.setText("");
        txtApellidoPaciente.setText("");
        cmbEspecialidad.setValue("");
        cmbSintomas.setValue(null);
        txtEdad.setText("");
    }

    /**
     * Method for save Puesto data.
     */
    @FXML
    void guardarPuesto(ActionEvent event) {
        Puesto puesto = new Puesto(txtNumeroPuesto.getText(), cmbMedicoresponsable.getValue());
        cmbMedicoresponsable.getValue().setPuesto(puesto);
        principal.getPuestosLibres().add(puesto);
        LPuesto.add(puesto);
        loadData();
        txtNumeroPuesto.setText("");
        cmbMedicoresponsable.setValue(null);
    }

    /**
     * Method to update Doctors List
     */
    private void actualizarListaDoctores() {
        ListIterator<Medico> lit = LMedico.listIterator();
        while (lit.hasNext()) {
            if (lit.next().getPuesto() != null) {
                System.out.println("F");
                lit.remove();
            }
        }
        cmbMedicoresponsable.getItems().setAll(LMedico);
    }
    
    @FXML
    void eliminarPuesto(){
        Optional<ButtonType> result = Alerts.confirmPuestoDelete();
        if(result.get()==ButtonType.OK){
            Puesto puesto = cmbPuesto.getValue();
            Medico med = puesto.getMedico();
            med.setPuesto(null);
            LPuesto.remove(puesto);
            LMedico.add(med);
            loadData();
            
        }
        
    }

    //FUNCIONALIDAD MENU REGISTROS.
    @FXML
    private Button btnRegistroPaciente, btnRegistroDoctor, btnCrearPuesto, btnEliminarPuesto;
    @FXML
    private AnchorPane hRegistroPaciente, hEliminarPuesto, hCrearPuesto, hRegistroDoctores;

    /**
     * Method for set visibility to AnchorPane.
     */
    @FXML
    private void handleButtonAction(Event event) {

        if (event.getTarget() == btnRegistroPaciente) {
            hRegistroPaciente.setVisible(true);
            hRegistroDoctores.setVisible(false);
            hCrearPuesto.setVisible(false);
            hEliminarPuesto.setVisible(false);

        }
        if (event.getTarget() == btnRegistroDoctor) {
            hRegistroPaciente.setVisible(false);
            hRegistroDoctores.setVisible(true);
            hCrearPuesto.setVisible(false);
            hEliminarPuesto.setVisible(false);

        }
        if (event.getTarget() == btnCrearPuesto) {
            hRegistroPaciente.setVisible(false);
            hRegistroDoctores.setVisible(false);
            hCrearPuesto.setVisible(true);
            hEliminarPuesto.setVisible(false);

        }
        if (event.getTarget() == btnEliminarPuesto) {
            hRegistroPaciente.setVisible(false);
            hRegistroDoctores.setVisible(false);
            hCrearPuesto.setVisible(false);
            hEliminarPuesto.setVisible(true);

        }
    }

    /**
     *
     * @param url
     * @param rb
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        cmbSintomas.setEditable(false);
    }

    public void serializarListas() {
        ClassSerializer.guardarObjeto("medicos.ser", LMedico);
        ClassSerializer.guardarObjeto("puestos.ser", LPuesto);
    }

}
