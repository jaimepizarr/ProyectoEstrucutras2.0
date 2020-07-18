/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReaders;

import ComponentesSistema.Medico;
import java.io.BufferedReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author PC
 */
public class MedicoFileReader implements FileReader {

    @Override
    public ObservableList LeerArchivo(String s) {
        ObservableList<Medico> lista = FXCollections.observableArrayList();
        try ( BufferedReader br = new BufferedReader(new java.io.FileReader(s))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split("\\|");
                String nombre = data[1];
                String apellido = data[2];
                String especialidad = data[3];
                Medico medico = new Medico(nombre, apellido, especialidad);
                lista.add(medico);

            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        return lista;
    }
   
}
