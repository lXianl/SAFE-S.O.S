
package dijkstra.pkg2.pkg0;

import java.util.*;



public class Algoritmo {
    private final int MAX = 10005;  //maximo numero de vértices
    private final int INF = 1<<30;  //definimos un valor grande que represente la distancia infinita inicial, basta conque sea superior al maximo valor del peso en alguna de las aristas
    private List <Arista> aris = new ArrayList<>(); //definimos la lista de aristas
    private int distancia[ ] = new int[ MAX ];          //distancia[ u ] distancia de vértice inicial a vértice con ID = u
    private boolean visitado[ ] = new boolean[ MAX ];   //para vértices visitados
    private PriorityQueue< Nodo > ListaPrioridad = new PriorityQueue<Nodo>(); //priority queue propia de Java, usamos el comparador definido para que el de menor valor este en el tope
    private int V;                                      //numero de vertices
    private int previo[] = new int[ MAX ];              //para la impresion de caminos
    private boolean dijkstraEjecutado;
    private List< List< Nodo > > ady = new ArrayList< List< Nodo > >(); //lista de adyacencia
    private int numArista ;
    Algoritmo (int V){
        this.V=V;
        this.V = V;
        for( int i = 0 ; i <= V ; ++i ) 
            ady.add(new ArrayList<Nodo>()) ; //inicializamos lista de adyacencia
        dijkstraEjecutado = false;
    }
    private void inicializar(){
        for( int i = 0 ; i <= V ; ++i ){
            distancia[ i ] = INF;  //inicializamos todas las distancias con valor infinito
            visitado[ i ] = false; //inicializamos todos los vértices como no visitados
            previo[ i ] = -1;      //inicializamos el previo del vertice i con -1
        }        
    }
    //Paso de relajacion
    private void comparacion( int actual , int adyacente , int peso ){
        //Si la distancia del origen al vertice actual + peso de su arista es menor a la distancia del origen al vertice adyacente
        if( distancia[ actual ] + peso < distancia[ adyacente ] ){
            distancia[ adyacente ] = distancia[ actual ] + peso;  //relajamos el vertice actualizando la distancia
            previo[ adyacente ] = actual;                         //a su vez actualizamos el vertice previo
            ListaPrioridad.add( new Nodo( adyacente , distancia[ adyacente ] ) ); //agregamos adyacente a la cola de prioridad
        }
    }
    void dijkstra( int inicial ){
        inicializar(); //inicializamos nuestros arreglos
        ListaPrioridad.add( new Nodo( inicial , 0 ) ); //Insertamos el vértice inicial en la Cola de Prioridad
        distancia[ inicial ] = 0;      //Este paso es importante, inicializamos la distancia del inicial como 0
        int actual , adyacente , peso;
        while( !ListaPrioridad.isEmpty() ){                   //Mientras cola no este vacia
            actual = ListaPrioridad.element().first;            //Obtenemos de la cola el nodo con menor peso, en un comienzo será el inicial
            ListaPrioridad.remove();                           //Sacamos el elemento de la cola
            if( visitado[ actual ] ) continue; //Si el vértice actual ya fue visitado entonces sigo sacando elementos de la cola
            visitado[ actual ] = true;         //Marco como visitado el vértice actual

            for( int i = 0 ; i < ady.get( actual ).size() ; ++i ){ //reviso sus adyacentes del vertice actual
                adyacente = ady.get( actual ).get( i ).first;   //id del vertice adyacente
                peso = ady.get( actual ).get( i ).second;        //peso de la arista que une actual con adyacente ( actual , adyacente )
                if( !visitado[ adyacente ] ){        //si el vertice adyacente no fue visitado
                   comparacion(actual , adyacente , peso ); //realizamos el paso de relajacion
                }
            }
        }
    }
    void agregarArista( int origen , int destino , int peso , boolean dirigido ){
        ady.get( origen ).add( new Nodo( destino , peso  ) );    //si la arista es dirigida usar true
        if( !dirigido )
            ady.get( destino ).add( new Nodo( origen , peso  ) ); //si la arista no es dirigida usar false
            String m= String.valueOf(numArista);
            numArista++;
            aris.add(new Arista(origen, destino,m , peso));
    }
    void imprimirCamino(){
        if( !dijkstraEjecutado ){
            System.out.println("Es necesario ejecutar el algoritmo de Dijkstra antes de poder imprimir el camino mas corto");
            return;
        }
        Scanner sc = new Scanner( System.in );      //para lectura de datos por consola, con el fin de probar
        System.out.println("\n**************Impresion de camino mas corto**************");
        int destino =1;
        while (destino !=0){
        System.out.printf("Ingrese vertice destino,si desea eliminar una arista marque :-1, de lo contarrio marque 0: ");
        int inicial = sc.nextInt();
        if (inicial == -1){
            System.out.println("Ingrese por favor el origen de la conexion ");
            int origen=sc.nextInt();
            System.out.println("Ingrese por favor el destino de la conexion");
            destino=sc.nextInt();
            //deleteEdge(1, origen, destino);
        } 
        else{
        destino = sc.nextInt();
        imprimirDestino( destino );}
        System.out.printf("\n");}
    }
    void imprimirDestino( int destino ){
        if( previo[ destino ] != -1 )    //si aun poseo un vertice previo
            imprimirDestino( previo[ destino ] );  //usamos recursividad para seguir explorando
        System.out.printf("%d " , destino );        //terminada la recursion imprimo los vertices recorridos
    }
    public int obtenerNumeroVertices() {
        return V;
    }
}
