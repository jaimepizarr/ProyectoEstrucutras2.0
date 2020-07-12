/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    @SuppressWarnings("empty-statement")
    public void start(Stage primaryStage) {
        try{
            System.out.println("F el trabajo");
      FXMLLoader loader = new FXMLLoader(new File("test.fxml").toURI().toURL());
        Parent root = loader.load();
 
        Scene scene = new Scene (root);
        primaryStage.setScene(scene);
        primaryStage.show();
        }catch(IOException e){
;
        
        
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
