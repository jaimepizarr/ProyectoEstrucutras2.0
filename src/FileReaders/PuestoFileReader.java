/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReaders;

import ComponentesSistema.Medico;
import ComponentesSistema.Puesto;
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
 * @author USUARIO
 */
public class PuestoFileReader extends LectorArchivos {
    /**
     * Method to read the puesto file.
     *
     * @return ObsevableList
     */
    @Override
    public LinkedList LeerArchivo(String s) {
        LinkedList<Puesto> lista = new LinkedList<>();
        try  {
            File f = new File("puestos.ser");
            if(f.exists()){
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                Object nuevo = ois.readObject();
                if(nuevo!=null){
                    System.out.println("YEA");
                    lista = (LinkedList<Puesto>) nuevo;
                }
                ois.close();
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PuestoFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
