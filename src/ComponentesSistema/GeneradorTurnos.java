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
                ContadorTurnos.setCantA(cant+1);
                break;
            case 1:
                cant = ContadorTurnos.getCantB();
                letra = "B";
                ContadorTurnos.setCantB(cant+1);
                break;
            case 2:
                cant = ContadorTurnos.getCantC();
                letra = "C";
                ContadorTurnos.setCantC(cant+1);
                break;
            case 3:
                cant = ContadorTurnos.getCantD();
                letra = "D";
                ContadorTurnos.setCantD(cant+1);
                break;
            case 4:
                cant = ContadorTurnos.getCantE();
                letra = "E";
                ContadorTurnos.setCantE(cant+1);
                break;
        }
        String nTurno = letra + cant;
        return new Turno(p,nTurno);
                
    }
}
