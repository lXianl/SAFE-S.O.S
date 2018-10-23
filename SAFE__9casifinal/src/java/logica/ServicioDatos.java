/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

 
@ManagedBean(name = "serDatos")
@ApplicationScoped
public class ServicioDatos {
    
    private final static String[] vertice;
     
    private final static String[] distancia;
     
    static {
        vertice = new String[10];
        vertice[0] = "1";
        vertice[1] = "2";
        vertice[2] = "3";
        vertice[3] = "Red";
        vertice[4] = "Blue";
        vertice[5] = "Orange";
        vertice[6] = "Silver";
        vertice[7] = "Yellow";
        vertice[8] = "Brown";
        vertice[9] = "Maroon";
         
        distancia = new String[10];
        distancia[0] = "distancia mas corta = 471";
        distancia[1] = "distancia mas corta = 471";
        distancia[2] = "distancia mas corta = 471";
        distancia[3] = "distancia mas corta = 471";
        distancia[4] = "distancia mas corta = 471";
        distancia[5] = "Fiat";
        distancia[6] = "Volkswagen";
        distancia[7] = "Honda";
        distancia[8] = "Jaguar";
        distancia[9] = "Ford";
    }
     
//    public List<Datos> createCars(int size) {
//        List<Datos> list = new ArrayList<Datos>();
//        for(int i = 0 ; i < size ; i++) {
//            list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
//        }
//         
//        return list;
//    }
//    public List<String> getBrands() {
//        return Arrays.asList(brands);
//    }
//    

}
