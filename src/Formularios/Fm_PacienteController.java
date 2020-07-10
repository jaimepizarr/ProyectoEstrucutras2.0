package Formularios;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Fm_PacienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nombrePaciente;

    @FXML
    private TextField apellidoPaciente;

    @FXML
    private TextField edadPaciente;

    @FXML
    private ComboBox<String> generoPaciente;

    @FXML
    private ComboBox<?> sintomaPaciente;

    @FXML
    private Button guardar;

    @FXML
    void initialize() {
        ObservableList<String > genero;
        assert nombrePaciente != null : "fx:id=\"nombrePaciente\" was not injected: check your FXML file 'fm_Paciente.fxml'.";
        assert apellidoPaciente != null : "fx:id=\"apellidoPaciente\" was not injected: check your FXML file 'fm_Paciente.fxml'.";
        assert edadPaciente != null : "fx:id=\"edadPaciente\" was not injected: check your FXML file 'fm_Paciente.fxml'.";
        assert generoPaciente != null : "fx:id=\"generoPaciente\" was not injected: check your FXML file 'fm_Paciente.fxml'.";
        assert sintomaPaciente != null : "fx:id=\"sintomaPaciente\" was not injected: check your FXML file 'fm_Paciente.fxml'.";
        assert guardar != null : "fx:id=\"guardar\" was not injected: check your FXML file 'fm_Paciente.fxml'.";
        genero = FXCollections.observableArrayList();
        genero.add("Mujer");
        genero.add("Hombre");
        
        generoPaciente.setItems(genero);
    }
 
}