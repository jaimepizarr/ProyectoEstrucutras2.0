/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{
        AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("fm_Paciente.fxml"));
        Scene scene = new Scene (root);
        primaryStage.setScene(scene);
        primaryStage.show();
        }catch(Exception e){
        e.printStackTrace();;
        
        
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
