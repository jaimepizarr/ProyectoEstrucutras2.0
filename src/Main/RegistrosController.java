/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.event.MouseEvent;
import java.net.URL;
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
    @FXML
    private ComboBox<String> cmbGenero;

    /**
     * Method for set Itemns to cmbGenero.
     */
    private void loadData() {
        cmbGenero.getItems().setAll(new String[]{"MASCULINO", "FEMENINO"});
    }
    @FXML
    private ComboBox<String> cmbPuesto;

    @FXML
    private ComboBox<String> cmbSintomas;
    @FXML
    private ComboBox<String> cmbMedicoresponsable;
    @FXML
    private ComboBox<String> cmbEspecialidad;

    
    
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

    }

    /**
     * Method for save Paciente data.
     */
    @FXML
    void guardarPaciente(ActionEvent event) {
        //Codigo para guardar paciente
        SitemaPrincipalController principal = SitemaPrincipalController.getInstance();

    }

    /**
     * Method for save Puesto data.
     */
    @FXML
    void guardarPuesto(ActionEvent event) {

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
