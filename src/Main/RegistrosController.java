/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    //FUNCIONALIDAD COMBOBOX
    ObservableList<String> Lgenero;
    ObservableList<String> LEspecialidad;
    ObservableList<String> LSintomas = leerArchivo("sintomas.txt");
    ObservableList<String> LMedico = leerArchivo("medico.txt");  //AGREGAR INFORMACION
    ObservableList<String> LPuesto = leerArchivo("puesto.txt"); // AGREGAR INFORMACION
    @FXML
    private ComboBox<String> cmbGenero;
    @FXML
    private ComboBox<String> cmbEspecialidad;
    @FXML
    private ComboBox<String> cmbSintomas;
    @FXML
    private ComboBox<String> cmbMedicoresponsable;
    @FXML
    private ComboBox<String> cmbPuesto;

    /**
     * Method for set Itemns to combobox.
     */
    private void loadData() {
        cmbGenero.getItems().setAll(new String[]{"MASCULINO", "FEMENINO"});
        cmbEspecialidad.getItems().setAll(new String[]{"Medicina General", "Alergología", "Cardiología", "Angiología", "Cirugía General", "Dermatología", "Endocrinología", "Ecografía", "Hematología"});
        cmbSintomas.getItems().setAll(LSintomas);
        cmbMedicoresponsable.getItems().setAll(LMedico);
        cmbPuesto.getItems().setAll(LPuesto);
    }

    /**
     * Method for read data.
     *
     * @return ObsevableList<String>
     */
    private ObservableList<String> leerArchivo(String archivo) {
        ObservableList<String> lista = FXCollections.observableArrayList();
        try ( BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split("\\|");
                if (archivo.equals("sintomas.txt") || archivo.equals("puesto.txt")) { //Puesto y sintoma tendra la informacion requerida en la misma posicion
                    String sintoma_puesto = data[0];
                    lista.add(sintoma_puesto);
                }
                if (archivo.equals("medico.txt")) {
                    String NombreAp = data[0] + data[1];
                    lista.add(NombreAp);

                }
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        return lista;

    }

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

    /**
     * Method for save Doctor data.
     */
    @FXML
    void guardarDoctor(ActionEvent event) {
        if (event.getTarget() == btnGuardarDoctor) {
            FileWriter writer = null;
            try {
                BufferedReader br = new BufferedReader(new FileReader("medico.txt"));
                String ruta = "medico.txt"; //ruta del archivo que se va a leer
                writer = new FileWriter(ruta);
                if (br.readLine() != null) {
                    writer.write(txtNombreDoctor.getText() + "|" + txtApellidoDoctor.getText() + "|" + cmbEspecialidad.getValue() + "\n");
                } else {
                    writer.append(txtNombreDoctor.getText() + "|" + txtApellidoDoctor.getText() + "|" + cmbEspecialidad.getValue() + "\n");
                }
                writer.close();
            } catch (IOException ex) {
                System.out.println("Archivo no encontrado");
            }

            txtNombreDoctor.setText("");
            txtApellidoDoctor.setText("");
            cmbEspecialidad.setValue("");
        }

    }

    /**
     * Method for save Paciente data.
     */
    @FXML
    void guardarPaciente(ActionEvent event) {
        if (event.getTarget() == btnGuardarPaciente) {
            FileWriter writer = null;
            try {
                BufferedReader br = new BufferedReader(new FileReader("paciente.txt"));
                String ruta = "paciente.txt"; //ruta del archivo que se va a leer
                writer = new FileWriter(ruta);
                if (br.readLine() != null) {
                    writer.write(txtNombrePaciente.getText() + "|" + txtApellidoPaciente.getText() + "|" + cmbGenero.getValue() + "|" + txtEdad.getText() + "|" + cmbSintomas.getValue() + "\n");
                } else {
                    writer.append(txtNombrePaciente.getText() + "|" + txtApellidoPaciente.getText() + "|" + cmbGenero.getValue() + "|" + txtEdad.getText() + "|" + cmbSintomas.getValue() + "\n");
                }
                writer.close();
            } catch (IOException ex) {
                System.out.println("Archivo no encontrado");
            }

            txtNombrePaciente.setText("");
            txtApellidoPaciente.setText("");
            cmbEspecialidad.setValue("");
            cmbSintomas.setValue("");
            txtEdad.setText("");
        }
        SitemaPrincipalController principal = SitemaPrincipalController.getInstance();

    }

    /**
     * Method for save Puesto data.
     */
    @FXML
    void guardarPuesto(ActionEvent event) {
        if (event.getTarget() == btnGuardarPuesto) {
            FileWriter writer = null;
            try {
                BufferedReader br = new BufferedReader(new FileReader("puesto.txt"));
                String ruta = "puesto.txt"; //ruta del archivo que se va a leer
                writer = new FileWriter(ruta);
                if (br.readLine() != null) {
                    writer.write(txtNumeroPuesto.getText() + "|" + cmbMedicoresponsable.getValue() + "\n");
                } else {
                   writer.write(txtNumeroPuesto.getText() + "|" + cmbMedicoresponsable.getValue() + "\n");
                }
                writer.close();
            } catch (IOException ex) {
                System.out.println("Archivo no encontrado");
            }

            txtNumeroPuesto.setText("");
            cmbMedicoresponsable.setValue("");
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
    }

}
