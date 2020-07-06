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
public class Medico {
    private String nombre;
    private String apellido;
    private String especialidad;

    public Medico(String nombre, String apellido, String especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medico{" + "nombre=" + nombre + ", apellido=" + apellido + ", especialidad=" + especialidad + '}';
    }
    
    
    public void AlmacenarDatos(){}
    
    
    
}
