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
public class Triaje implements Serializable {
   
    private String descripcion;
    private String color;
    private String imagen;

    public Triaje(String descripcion, String color, String imagen) {
        this.descripcion = descripcion;
        this.color = color;
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getColor() {
        return color;
    }

    public String getImagen() {
        return imagen;
    }
    

}
