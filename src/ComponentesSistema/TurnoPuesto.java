/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentesSistema;

/**
 *
 * @author PC
 */
public class TurnoPuesto {
    private Turno turno;
    private Puesto puesto;

    public TurnoPuesto(Turno turno, Puesto puesto) {
        this.turno = turno;
        this.puesto = puesto;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "TurnoPuesto{" + "turno=" + turno + ", puesto=" + puesto + '}';
    }
    
    
    
}
