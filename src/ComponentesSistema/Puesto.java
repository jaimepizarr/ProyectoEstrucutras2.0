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
public class Puesto {
    private String numero;
    private Medico medico;
   

    public Puesto(String numero, Medico medico) {
        this.numero = numero;
        this.medico = medico;
        
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    
    public void almacenarDatos(){}

    @Override
    public String toString() {
        return numero;
    }
      
    
    
    
    
}
