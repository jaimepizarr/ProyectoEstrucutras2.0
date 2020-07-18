/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReaders;

import ComponentesSistema.Medico;
import ComponentesSistema.Sintoma;
import java.io.BufferedReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author PC
 */
public class SintomasFileReader extends LectorArchivos {
    /**
     * Method to read the sintoma file.
     *
     * @return ObsevableList
     */
    @Override
    public ObservableList LeerArchivo(String s) {
        ObservableList<Sintoma> lista = FXCollections.observableArrayList();
        try ( BufferedReader br = new BufferedReader(new java.io.FileReader(s))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split("\\|");
                String nombre = data[0];
                int prioridad = Integer.parseInt(data[1]);
                Sintoma sintoma = new Sintoma(nombre,prioridad);
                lista.add(sintoma);

            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        return lista;
    }
    
}
