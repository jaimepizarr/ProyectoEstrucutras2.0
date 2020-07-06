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
public class Receta {
    private Integer idReceta;
    private String contenido;

    public Receta(Integer idReceta, String contenido) {
        this.idReceta = idReceta;
        this.contenido = contenido;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
    
}
