/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formuario;

import java.util.ArrayList;
import java.util.List;

class Nodo implements Comparable<Nodo> {

    int first, second;
    static String latitud, longitud, num;
    List<Nodo> ListaNodos = new ArrayList<>();

    Nodo(int d, int p, String m, String n) {                          //constructor
        this.first = d;
        this.second = p;
        this.latitud = m;
        this.longitud = n;
    }

    Nodo(int l, int k) {
        this.first = l;
        this.second = k;
    }

    Nodo(String Latitud, String Longitud, String numero) {

        this.latitud = Latitud;
        this.longitud = Longitud;
        this.num = numero;
    }

    Nodo() {

    }

    public int compareTo(Nodo other) {              //es necesario definir un comparador para el correcto funcionamiento de la cola de prioridad
        if (second > other.second) {
            return 1;
        }
        if (second == other.second) {
            return 0;
        }
        return -1;
    }

    public void AgregarListaNodos(String q, String w, String e) {
        ListaNodos.add(new Nodo(q, w, e));
    }
}
