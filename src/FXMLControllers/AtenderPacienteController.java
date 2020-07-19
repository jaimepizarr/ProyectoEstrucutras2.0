/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLControllers;

import ComponentesSistema.Paciente;
import ComponentesSistema.Turno;
import ComponentesSistema.TurnoPuesto;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class AtenderPacienteController implements Initializable {

    private SitemaPrincipalController principal;

    public SitemaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(SitemaPrincipalController principal) {
        this.principal = principal;
    }

    //COMBO BOX
    @FXML
    private ComboBox<?> cmbPuesto;

    //TEXT FIELD - AREA
    @FXML
    private TextField txtNombrePaciente;

    @FXML
    private TextField txtApellidoPaciente;

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
        TurnoPuesto deleteElement = SitemaPrincipalController.getInstance().tbTurnoPuesto.getSelectionModel().getSelectedItem();
        SitemaPrincipalController.getInstance().tbTurnoPuesto.getItems().remove(deleteElement);
        SitemaPrincipalController.getInstance().tbTurnoPuesto.refresh();
        SitemaPrincipalController.getInstance().puestosLibres.offer(deleteElement.getPuesto());
        guardarDatos();
        vaciarInputsAtenderPaciente();
        
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

    public TextField getTxtNombrePaciente() {
        return txtNombrePaciente;
    }

    public void setTxtNombrePaciente(TextField txtNombrePaciente) {
        this.txtNombrePaciente = txtNombrePaciente;
    }

    public TextField getTxtSintoma() {
        return txtSintoma;
    }

    public void setTxtSintoma(TextField txtSintoma) {
        this.txtSintoma = txtSintoma;
    }

    public TextField getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(TextField txtEdad) {
        this.txtEdad = txtEdad;
    }

    public TextField getTxtGenero() {
        return txtGenero;
    }

    public void setTxtGenero(TextField txtGenero) {
        this.txtGenero = txtGenero;
    }

    public TextField getTxtApellidoPaciente() {
        return txtApellidoPaciente;
    }

    public void setTxtApellidoPaciente(TextField txtApellidoPaciente) {
        this.txtApellidoPaciente = txtApellidoPaciente;
    }

    /**
     * Method for save Receta & Diagnostico data.
     */
    public void guardarDatos() {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("receta.diagnostico.txt", true))) {
            bw.write(txtNombrePaciente.getText() + txtApellidoPaciente.getText() + "|" + txtAreaReceta.getText()
                    + "|" + txtAreaDiagnostico.getText() + "\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void vaciarInputsAtenderPaciente() {
        txtNombrePaciente.setText("");
        txtApellidoPaciente.setText("");
        txtGenero.setText("");
        txtEdad.setText("");
        txtSintoma.setText("");
        txtAreaReceta.setText("");
        txtAreaDiagnostico.setText("");

    }
    
    public void fillInData(Paciente patient){
            this.getTxtEdad().setText(String.valueOf(patient.getEdad()));
            this.getTxtGenero().setText(patient.getGenero());
            this.getTxtSintoma().setText(patient.getSintoma().getNombre());
            this.getTxtNombrePaciente().setText(patient.getNombre());
            this .getTxtApellidoPaciente().setText(patient.getApellido());   
    }

}
