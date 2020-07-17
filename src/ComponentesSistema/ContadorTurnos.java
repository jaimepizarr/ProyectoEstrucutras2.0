/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentesSistema;

/**
 *Llevar un conteo de la cantidad de turnos segun la prioridad
 * @author PC
 */
public class ContadorTurnos {
    private static int cantA; //prioridad 0 
    private static int cantB; //prioridad 1
    private static int cantC; //prioridad 2
    private static int cantD; //prioridad 3
    private static int cantE; //prioridad 4

    public static int getCantA() {
        return cantA;
    }

    public static void setCantA(int cantA) {
        ContadorTurnos.cantA = cantA;
    }

    public static int getCantB() {
        return cantB;
    }

    public static void setCantB(int cantB) {
        ContadorTurnos.cantB = cantB;
    }

    public static int getCantC() {
        return cantC;
    }

    public static void setCantC(int cantC) {
        ContadorTurnos.cantC = cantC;
    }

    public static int getCantD() {
        return cantD;
    }

    public static void setCantD(int cantD) {
        ContadorTurnos.cantD = cantD;
    }

    public static int getCantE() {
        return cantE;
    }

    public static void setCantE(int cantE) {
        ContadorTurnos.cantE = cantE;
    }
    
    
    
}
