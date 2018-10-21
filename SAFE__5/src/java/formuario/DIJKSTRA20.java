
package formuario;


import java.io.*;

import java.util.*;



public class DIJKSTRA20 {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
int E , origen, destino , peso , inicial, V;
        Scanner sc = new Scanner( System.in );      //para lectura de datos
//        System.out.print("Ingrese el numero de vertices: ");
//        V = sc.nextInt();
//        System.out.print("Ingrese el numero de aristas: ");
//        E = sc.nextInt();
        
        File mnodos = new File ("Ponderaciones.txt");
        File longinodos = new File ("Longitudes.txt");
        FileReader reader = new FileReader(mnodos);
        BufferedReader leer = new BufferedReader(reader);
        
        V = Integer.parseInt(leer.readLine());
        E = Integer.parseInt(leer.readLine());
        Arista arist = new Arista();
        DijkstraFormBean Algoritmo = new DijkstraFormBean(V);
        for( int i = 0 ; i < E ; ++i ){
            String linea = leer.readLine();
            String[] nums = linea.split(" ");
            origen = Integer.parseInt(nums[0]);
            destino = Integer.parseInt(nums[1]);
            peso = Integer.parseInt(nums[2]);
//            for (String num : nums){
//            origen = sc.nextInt(); destino = sc.nextInt(); peso = sc.nextInt();
            Algoritmo.addEdge(origen, destino, peso, false);
            arist.AgregarListaArista(origen, destino, peso, String.valueOf(i));
            
        }
        
        reader.close();
        FileReader lector = new FileReader(longinodos);
        BufferedReader dobleread = new BufferedReader(lector);
        Nodo nods = new Nodo();
        String num, longitud,latitud;
        for( int i = 0 ; i < 77 ; ++i ){
            String linea = dobleread.readLine();
            String[] row = linea.split(" ");
            num = (row[0]);
            latitud = (row[1]);
            longitud = (row[2]);
            nods.AgregarListaNodos(latitud,longitud,num);
            
            
        }
        
//        System.out.print("Ingrese el vertice inicial: ");
//        inicial = sc.nextInt();       
        Algoritmo.dijkstra(78);
        Algoritmo.printShortestPath();
        }    
    }



    
    
    
    
    

