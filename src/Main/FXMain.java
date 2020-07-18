/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import FXMLControllers.RegistrosController;
import Resources.CloseAlert;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class FXMain extends Application {
    
    /**
     *
     * @param primaryStage
     * @throws IOException
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Stage anotherStage = new Stage();
        
        loadFXML("/FXMLFiles/SistemaPrincipal.fxml",primaryStage);
        loadFXML("/FXMLFiles/Registros.fxml",anotherStage);
        primaryStage.setOnCloseRequest(e->{
            Optional<ButtonType> result = CloseAlert.confirmation();
            if(result.get()==ButtonType.OK){
                RegistrosController registros = RegistrosController.getInstance();
                registros.serializarListas();
                System.exit(0);
            }else{
                e.consume();
            }
        });
    }
    
    public void loadFXML(String source,Stage stage){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource(source));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
