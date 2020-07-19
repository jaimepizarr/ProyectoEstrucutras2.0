/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReaders;

import ComponentesSistema.Medico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
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
    public LinkedList LeerArchivo(String s) {
        LinkedList<Medico> lista = new LinkedList<>();
        try {
            File f = new File("puestos.ser");
            if(f.exists()){
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("medicos.ser"));      
                Object nuevo = ois.readObject();
                if(nuevo!=null) System.out.println("HEY");
                lista = (LinkedList<Medico>) nuevo;
                System.out.println(lista);
                ois.close();
            }
            
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Medico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
        return lista;
    }
   
}
