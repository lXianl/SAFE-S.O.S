
package formuario;

import java.util.ArrayList;
import java.util.List;

public class Arista {
    private int nodo1,nodo2;
    private String  num;
    private int peso;
    List<Arista> ListaAristas = new ArrayList<>();

    Arista() {
        
    }
    public int getNodo1() {
        return nodo1;
    }

    public int getNodo2() {
        return nodo2;
    }

    public String getNum() {
        return num;
    }    

    public Arista(int nodo1, int nodo2, String num, int peso) {
        this.nodo1 = nodo1;
        this.nodo2 = nodo2;
        this.num = num;
        this.peso = peso;
    }
    public void AgregarListaArista(int nodo1,int nodo2,int peso, String num){
            ListaAristas.add(new Arista(nodo1,nodo2,num,peso));
        }

    

    
        
    
    
    
     
}
