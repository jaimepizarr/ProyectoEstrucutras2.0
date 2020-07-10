/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentesSistema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author USUARIO
 */
public class Sintoma {
    private String nombre;
    private int prioridad;

    public Sintoma(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    public static LinkedList<Sintoma> leerArchivo(String txt){
        LinkedList<Sintoma> sintomas = new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(txt))){
            String line;
            while((line = br.readLine())!= null){
                String[] partes = line.strip().split("\\|");
                Sintoma s = new Sintoma(partes[0],Integer.parseInt(partes[1]));
                sintomas.add(s);
            }
        }catch(IOException ex){
            
        }
        return sintomas;
    }

    @Override
    public String toString() {
        return "Sintoma{" + "nombre=" + nombre + ", prioridad=" + prioridad + '}';
    }
    
    
    
}


