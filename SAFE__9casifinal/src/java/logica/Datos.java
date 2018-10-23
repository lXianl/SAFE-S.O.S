/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;

/**
 *
 * @author diyam
 */
public class Datos implements Serializable{
    
    private  String vertice;
    private  String distancia;
    private String imagen;

    public Datos(String vertice, String distancia, String imagen) {
        this.vertice = vertice;
        this.distancia = distancia;
        this.imagen = imagen;
    }

    public String getVertice() {
        return vertice;
    }

    public void setVertice(String vertice) {
        this.vertice = vertice;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

   
    
    
}
