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
public class GeneradorTurnos {
    
    public static Turno generarTurnoConPaciente(Paciente p){
        Sintoma s = p.getSintoma();
        int cant = 0;
        String letra = "";
        switch(s.getPrioridad()){
            case 0:
                cant = ContadorTurnos.getCantA();
                letra = "A";
            case 1:
                cant = ContadorTurnos.getCantB();
                letra = "B";
            case 2:
                cant = ContadorTurnos.getCantC();
                letra = "C";
            case 3:
                cant = ContadorTurnos.getCantD();
                letra = "D";
            case 4:
                cant = ContadorTurnos.getCantE();
                letra = "E";
        }
        String nTurno = letra + cant;
        return new Turno(p,nTurno);
                
    }
}
