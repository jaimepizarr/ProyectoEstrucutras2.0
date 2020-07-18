/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentesSistema;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Paciente implements Serializable{
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;
    private Sintoma sintoma;

    public Paciente(String nombre, String apellido, String genero, int edad, Sintoma sintoma) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.sintoma = sintoma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", edad=" + edad + ", sintoma=" + sintoma + '}';
    }
    
    public void guardarPaciente(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pacientes.ser"));
            oos.writeObject(this);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    



public void AlmacenarDatos(){}


}

