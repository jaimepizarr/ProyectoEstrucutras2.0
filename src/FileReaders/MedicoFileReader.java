/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReaders;

import ComponentesSistema.Medico;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author PC
 */
public class MedicoFileReader extends LectorArchivos {
    /**
     * Method to read the medico file.
     *
     * @return ObsevableList
     */
    @Override
    public ObservableList LeerArchivo(String s) {
        ObservableList<Medico> lista = FXCollections.observableArrayList();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("medicos.ser"));
            Object nuevo = ois.readObject();
            while(nuevo!= null){
                if(nuevo instanceof Medico){
                    lista.add((Medico)nuevo);
                }
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicoFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
   
}
