
package dijkstra.pkg2.pkg0;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import javafx.scene.Node;


public class DIJKSTRA {
    
    
    
    private final int MAX = 10005;  //maximo numero de vértices
    private final int INF = 1<<30;  //definimos un valor grande que represente la distancia infinita inicial, basta conque sea superior al maximo valor del peso en alguna de las aristas
    
    private List <Arista> aris = new ArrayList<>();
    private List< List< Nodo > > ady = new ArrayList< List< Nodo > >(); //lista de adyacencia
    private int distancia[ ] = new int[ MAX ];          //distancia[ u ] distancia de vértice inicial a vértice con ID = u
    private boolean visitado[ ] = new boolean[ MAX ];   //para vértices visitados
    private PriorityQueue< Nodo > Q = new PriorityQueue<Nodo>(); //priority queue propia de Java, usamos el comparador definido para que el de menor valor este en el tope
    private int V;                                      //numero de vertices
    private int previo[] = new int[ MAX ];              //para la impresion de caminos
    private boolean dijkstraEjecutado;
    private int numArista = 1;
    DIJKSTRA(int V){
        this.V = V;
        for( int i = 0 ; i <= V ; ++i ) 
            ady.add(new ArrayList<Nodo>()) ; //inicializamos lista de adyacencia
        dijkstraEjecutado = false;
    }
    private void init(){
        for( int i = 0 ; i <= V ; ++i ){
            distancia[ i ] = INF;  //inicializamos todas las distancias con valor infinito
            visitado[ i ] = false; //inicializamos todos los vértices como no visitados
            previo[ i ] = -1;      //inicializamos el previo del vertice i con -1
        }
    }

    //Paso de relajacion
    private void relajacion( int actual , int adyacente , int peso ){
        //Si la distancia del origen al vertice actual + peso de su arista es menor a la distancia del origen al vertice adyacente
        if( distancia[ actual ] + peso < distancia[ adyacente ] ){
            distancia[ adyacente ] = distancia[ actual ] + peso;  //relajamos el vertice actualizando la distancia
            previo[ adyacente ] = actual;                         //a su vez actualizamos el vertice previo
            Q.add( new Nodo( adyacente , distancia[ adyacente ] ) ); //agregamos adyacente a la cola de prioridad
        }
    }

    void dijkstra( int inicial ){
        init(); //inicializamos nuestros arreglos
        Q.add( new Nodo( inicial , 0 ) ); //Insertamos el vértice inicial en la Cola de Prioridad
        distancia[ inicial ] = 0;      //Este paso es importante, inicializamos la distancia del inicial como 0
        int actual , adyacente , peso;
        while( !Q.isEmpty() ){                   //Mientras cola no este vacia
            actual = Q.element().first;            //Obtengo de la cola el nodo con menor peso, en un comienzo será el inicial
            Q.remove();                           //Sacamos el elemento de la cola
            if( visitado[ actual ] ) continue; //Si el vértice actual ya fue visitado entonces sigo sacando elementos de la cola
            visitado[ actual ] = true;         //Marco como visitado el vértice actual

            for( int i = 0 ; i < ady.get( actual ).size() ; ++i ){ //reviso sus adyacentes del vertice actual
                adyacente = ady.get( actual ).get( i ).first;   //id del vertice adyacente
                peso = ady.get( actual ).get( i ).second;        //peso de la arista que une actual con adyacente ( actual , adyacente )
                if( !visitado[ adyacente ] ){        //si el vertice adyacente no fue visitado
                    relajacion( actual , adyacente , peso ); //realizamos el paso de relajacion
                }
            }
        }

        System.out.printf( "Distancias mas cortas iniciando en vertice %d\n" , inicial );
        for( int i = 1 ; i <= V ; ++i ){
            System.out.printf("Vertice %d , distancia mas corta = %d\n" , i , distancia[ i ] );
        }
        dijkstraEjecutado = true;
    }
    
    void addEdge( int origen , int destino , int peso , boolean dirigido ){
        ady.get( origen ).add( new Nodo( destino , peso  ) );    //si la arista es dirigida usar true
        if( !dirigido )
            ady.get( destino ).add( new Nodo( origen , peso  ) ); //si la arista no es dirigida usar false
            String m= String.valueOf(numArista);
            numArista++;
            aris.add(new Arista(origen, destino,m , peso));
    }
    
    void printShortestPath() throws IOException{
        if( !dijkstraEjecutado ){
            System.out.println("Es necesario ejecutar el algoritmo de Dijkstra antes de poder imprimir el camino mas corto");
            return;
        }
        Scanner sc = new Scanner( System.in );      //para lectura de datos por consola, con el fin de probar
        System.out.println("\n**************Impresion de camino mas corto**************");
        int destino =1;
        while (destino !=0){
        System.out.printf("Ingrese vertice destino, si quiere eliminar una arista marque -1; de lo contarrio marque 0: ");        
        int matker = sc.nextInt();
        if (matker==-1){
            try{
            System.out.println("Porfavor ingrese el destino:");
            int destiny = sc.nextInt();
            System.out.println("Porfavor ingrese el origen:");
            int origin = sc.nextInt();
            System.out.println("Porfavor ingrese el peso:");
            int pex = sc.nextInt();
            deleteEdge(origin, destiny, pex);
                System.out.println("La arista se eliminó de manera correcta");
                dijkstra(1);
            }
            catch(Exception e){
                e.printStackTrace();
                System.out.println("la arista no fue eliminada intentelo de nuevo");
            }
        }
        else{
        destino=matker;
        print( destino );
        System.out.printf("\n");}
                    }
        }        
        
    //Impresion del camino mas corto desde el vertice inicial y final ingresados
    void print( int destino ){
        if( previo[ destino ] != -1 )    //si aun poseo un vertice previo
            print( previo[ destino ] );  //usamos recursividad para seguir explorando
        System.out.printf("%d " , destino );        //terminada la recursion imprimo los vertices recorridos
    }

    public int getNumberOfVertices() {
        return V;
    }

    public void setNumberOfVertices(int numeroDeVertices) {
        V = numeroDeVertices;
    }
    
    public void deleteEdge(int origen,int destino,int peso) throws FileNotFoundException, IOException {
        int num,pex;
        for( int i = 0 ; i < ady.get( destino ).size() ; ++i ){
            num= ady.get(destino).get(i).first;
            pex = ady.get(destino).get(i).second;
            if (num==origen && pex==peso){
                ady.get(destino).get(i).second=INF;
                ady.get(origen).get(i).second=INF;
                System.out.println(ady.get(destino).get(i).second);
            }
        }



//        Nodo m =new Nodo(origen,peso);
//        Nodo s = new Nodo(peso, origen );
//        if (dijkstraEjecutado){
//            int l =ady.get(destino).indexOf(m);
//            int k = ady.get(destino).indexOf(s);
//            if (l!= -1){
//            ady.remove(ady.get(destino).get(l));}
//            else if (k!= -1)
//            {
//              ady.remove(ady.get(destino).get(l));  
//            }
//            dijkstra(1);
//            printShortestPath();}     
                        
           
//            int E,nodo1,nodo2,pesox;
//           
//           File mnodos2 = new File ("Ponderaciones2.txt");
//           FileReader reader = new FileReader(mnodos2);
//           FileWriter writer = new FileWriter(mnodos2);
//           BufferedReader leer = new BufferedReader(reader);
//           BufferedWriter escritor = new BufferedWriter(writer);
//           E = Integer.parseInt(leer.readLine());
//           for( int i = 0 ; i < E ; ++i ){
//            String linea = leer.readLine();
//            String[] nums = linea.split(" ");
//            nodo1 = Integer.parseInt(nums[0]);
//            nodo2 = Integer.parseInt(nums[1]);
//            pesox = Integer.parseInt(nums[2]);
//            if (((nodo1!=destino && nodo2!=origen)||(nodo1 != origen && nodo2!=destino))&& pesox!=peso){
////            for (String num : nums){
////            origen = sc.nextInt(); destino = sc.nextInt(); peso = sc.nextInt();
//            addEdge(nodo1, nodo2, pesox, false);}
//            else{
//                escritor.
//        }             
//        
//        }
    }}

