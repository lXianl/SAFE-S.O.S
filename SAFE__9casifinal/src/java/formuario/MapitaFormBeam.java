/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logica.Datos;
import logica.ServicioDatos;
import logica.Triaje;
import modelo.Usuario;

/**
 *
 * @author diyam
 */
@ManagedBean
@ViewScoped
public class MapitaFormBeam implements Serializable {

    private Usuario usuLogin = new Usuario();
    private List<Datos> Datos = new ArrayList<Datos>();

    public List<Datos> getDatos() {
        return Datos;
    }

    public MapitaFormBeam() {
        this.usuLogin = (Usuario) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("u1");
        if (this.usuLogin == null) {
            this.usuLogin = new Usuario(0, "No Se encontro Usuario", "", "", "");
        }

        Datos.add(new Datos("1", "471", "punto"));
        Datos.add(new Datos("2", "487", "punto"));
        Datos.add(new Datos("3", "506", "punto"));
        Datos.add(new Datos("4", "536", "punto"));
        Datos.add(new Datos("5", "543", "punto"));
        Datos.add(new Datos("6", "574", "punto"));
        Datos.add(new Datos("7", "598", "punto"));
        Datos.add(new Datos("8", "623", "punto"));
        Datos.add(new Datos("9", "671", "punto"));
        Datos.add(new Datos("10", "557", "punto"));
        Datos.add(new Datos("11", "513", "punto"));
        Datos.add(new Datos("12", "488", "punto"));
        Datos.add(new Datos("13", "454", "punto"));
        Datos.add(new Datos("14", "433", "punto"));
        Datos.add(new Datos("15", "425", "punto"));
        Datos.add(new Datos("16", "396", "punto"));
        Datos.add(new Datos("17", "377", "punto"));
        Datos.add(new Datos("18", "351", "punto"));
        Datos.add(new Datos("19", "439", "punto"));
        Datos.add(new Datos("20", "621", "punto"));
        Datos.add(new Datos("21", "593", "punto"));
        Datos.add(new Datos("22", "630", "punto"));
        Datos.add(new Datos("23", "668", "punto"));
        Datos.add(new Datos("24", "705", "punto"));
        Datos.add(new Datos("25", "731", "punto"));
        Datos.add(new Datos("26", "505", "punto"));
        Datos.add(new Datos("27", "535", "punto"));
        Datos.add(new Datos("28", "653", "punto"));
        Datos.add(new Datos("29", "465", "punto"));
        Datos.add(new Datos("30", "432", "punto"));
        Datos.add(new Datos("31", "393", "punto"));
        Datos.add(new Datos("32", "358", "punto"));
        Datos.add(new Datos("33", "324", "punto"));
        Datos.add(new Datos("34", "283", "punto"));
        Datos.add(new Datos("35", "505", "punto"));
        Datos.add(new Datos("36", "207", "punto"));
        Datos.add(new Datos("37", "171", "punto"));
        Datos.add(new Datos("38", "458", "punto"));
        Datos.add(new Datos("39", "436", "punto"));
        Datos.add(new Datos("40", "407", "punto"));
        Datos.add(new Datos("41", "400", "punto"));
        Datos.add(new Datos("42", "370", "punto"));
        Datos.add(new Datos("43", "332", "punto"));
        Datos.add(new Datos("44", "279", "punto"));
        Datos.add(new Datos("45", "74", "punto"));
        Datos.add(new Datos("46", "576", "punto"));
        Datos.add(new Datos("47", "1", "punto"));
        Datos.add(new Datos("48", "121", "punto"));
        Datos.add(new Datos("49", "201", "punto"));
        Datos.add(new Datos("50", "272", "punto"));
        Datos.add(new Datos("51", "130", "punto"));
        Datos.add(new Datos("52", "209", "punto"));
        Datos.add(new Datos("53", "281", "punto"));
        Datos.add(new Datos("54", "372", "punto"));
        Datos.add(new Datos("55", "298", "punto"));
        Datos.add(new Datos("56", "226", "punto"));
        Datos.add(new Datos("57", "259", "punto"));
        Datos.add(new Datos("58", "305", "punto"));
        Datos.add(new Datos("59", "344", "punto"));
        Datos.add(new Datos("60", "377", "punto"));
        Datos.add(new Datos("61", "336", "punto"));
        Datos.add(new Datos("62", "268", "punto"));
        Datos.add(new Datos("63", "359", "punto"));
        Datos.add(new Datos("64", "292", "punto"));
        Datos.add(new Datos("65", "323", "punto"));
        Datos.add(new Datos("66", "375", "punto"));
        Datos.add(new Datos("67", "413", "punto"));
        Datos.add(new Datos("68", "450", "punto"));
        Datos.add(new Datos("69", "365", "punto"));
        Datos.add(new Datos("70", "453", "punto"));
        Datos.add(new Datos("71", "415", "punto"));
        Datos.add(new Datos("72", "324", "punto"));
        Datos.add(new Datos("73", "357", "punto"));
        Datos.add(new Datos("74", "446", "punto"));
        Datos.add(new Datos("75", "382", "punto"));
        Datos.add(new Datos("76", "470", "punto"));
        Datos.add(new Datos("77", "684", "punto"));

    }

}
