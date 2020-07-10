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
    private String turno;
    private int puesto;

    public TurnoPuesto(String turno, int puesto) {
        this.turno = turno;
        this.puesto = puesto;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "TurnoPuesto{" + "turno=" + turno + ", puesto=" + puesto + '}';
    }
    
    
    
}
