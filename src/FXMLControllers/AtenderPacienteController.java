/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class AtenderPacienteController implements Initializable {

    //COMBO BOX
    @FXML
    private ComboBox<?> cmbPuesto;

    //TEXT FIELD - AREA
    @FXML
    private TextField txtNombrePaciente;

    @FXML
    private TextField txtSintoma;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextArea txtAreaReceta;

    @FXML
    private TextArea txtAreaDiagnostico;

    //GUARDAR ATENCION
    @FXML
    private Button btnGuardar;

    /**
     * Method for saving patient atencion data.
     */
    @FXML
    void guardarAtencion(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
