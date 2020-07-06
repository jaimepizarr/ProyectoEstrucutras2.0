/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentesSistema;

/**
 *
 * @author USUARIO
 */
public class Paciente {
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
    
    
    



public void AlmacenarDatos(){}


}

