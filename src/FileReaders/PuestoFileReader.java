/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReaders;

import ComponentesSistema.Medico;
import ComponentesSistema.Puesto;
import java.io.BufferedReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author USUARIO
 */
public class PuestoFileReader implements FileReader {
    /**
     * Method to read the puesto file.
     *
     * @return ObsevableList
     */
    @Override
    public ObservableList LeerArchivo(String s) {
        ObservableList<Puesto> lista = FXCollections.observableArrayList();
        try ( BufferedReader br = new BufferedReader(new java.io.FileReader(s))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split("\\|");
                String numero = data[1];
                Medico medico = new Medico(data[2], data[3], data[4]);
                String especialidad = data[3];
                Puesto puesto = new Puesto(numero, medico);
                lista.add(puesto);

            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        return lista;
    }

}
