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
public class VentanaAtencion {
    private Turno turno;
    private Receta receta;
    private Diagnostico diagnostico;

    public VentanaAtencion(Turno turno, Receta receta, Diagnostico diagnostico) {
        this.turno = turno;
        this.receta = receta;
        this.diagnostico = diagnostico;
    }

   public void registrarDiagnostico(Diagnostico dig){}
   public void registrarReceta(Receta rt){}
    
    
}
