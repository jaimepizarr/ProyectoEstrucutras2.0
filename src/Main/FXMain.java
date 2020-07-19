/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import FXMLControllers.RegistrosController;
import FXMLControllers.SitemaPrincipalController;
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
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFiles/SistemaPrincipal.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene (root);
        primaryStage.setScene(scene);
        primaryStage.show();
        SitemaPrincipalController pController = loader.getController();
        
        System.out.println(pController);
        
        primaryStage.setOnCloseRequest(e->{
                Optional<ButtonType> result = CloseAlert.confirmation();
                if(result.get()==ButtonType.OK){
                    pController.getrController().serializarListas();
                    System.exit(0);

                }else{
                    e.consume();
                }
            });
    }
    
    
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
