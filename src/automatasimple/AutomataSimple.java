package automatasimple;

/*
 * @author https://github.com/Stormlocc (yo)
*/

//:::::::::::::::::::::::::::CLASE LISTA RECURSIVA::::::::::::::::::::::::::::::::::
class ListaRec{
    //:::::::::::::Atributos:::::::::::::::::::::
    private Object elemento;
    private ListaRec sublista;
    //:::::::::::::Constructores::::::::::::::::::::
    public ListaRec(){
        this.elemento = null;
        this.sublista = null;
    }
    public ListaRec(Object elemento, ListaRec sublista){
        this.elemento = elemento;
        this.sublista = sublista;
    }
    //:::::::::::::::::Getters:::::::::::::
    public Object getElemento(){
        return elemento;
    }
    public ListaRec getSublista(){
        return sublista;
    }
    //::::::::::::::::::::::::::Métodos::::::::::::::::::::
    //Determinar si la lista está vacía
    public boolean estaVacia(){
        return elemento == null && sublista == null;
    }
    //Agregar un elemento a la lista
    public void Agregar(Object O){
        if(estaVacia()){
            elemento = O;
            sublista = new ListaRec();
        }
        else
            sublista.Agregar(O);
    }
    //Determinar si un elemento existe en la lista
    public boolean Existe(Object O){
        if(estaVacia())
            return false;
        else
            return elemento.toString().equals(O.toString()) ?
                                     true : sublista.Existe(O);                         
    }
    //Obtener elemento Iesimo
    public Object obtenerIesimo(int i){
        if(i <= 1)
            return i == 1 ? elemento:null;
        else
            return sublista.obtenerIesimo(i-1);          
    }    
    //Obtener Nodo
    public Nodo obtenerNodo(Object O){
        if(estaVacia())
            return null;
        else
            return elemento.toString().equals(O.toString()) ?
                     (Nodo)elemento : sublista.obtenerNodo(O);
    }
    //Mostrar Lista
    public void mostrarLista(){
        if(!estaVacia()){
            System.out.print(elemento + " ");
            sublista.mostrarLista();
        }
        else
            System.out.println();
    }
    //Mostrar elementos como Nodos
    public void verNodos(){
        if(!estaVacia()){
            ((Nodo)elemento).mostrarNodo();
            sublista.verNodos();
        }
        else
            System.out.println();
    }    
}

//:::::::::::::::::::::::::CLASE NODO::::::::::::::::::::::::::::::::::::::::::::::
class Nodo{
  
    //:::::::::::Atributos:::::::::::::::::::
    private Object clave;
    private Object pop;
    private Object push;
    private ListaRec estados;
    //:::::::::::Constructores::::::::::::::::::
    public Nodo(Object clave, Object pop, Object push){
        this.clave = clave;
        this.estados = new ListaRec();
        this.pop = pop;
        this.push = push;     
    }
    public Nodo(){
        this.clave = null;
        this.estados = null;
    }
    public Nodo(Object clave){
        this.clave = clave;
        this.estados = new ListaRec();
    }
    //:::::::::::::::::::::::Getters::::::::::::::::::::
    public Object getClave(){
        return clave;
    }
    public ListaRec getEstados(){
        return estados;
    }
    public Object getPop(){
        return pop;
    }
    public Object getPush(){
        return push;
    }
    //::::::::::::::::::::::Métodos:::::::::::::::::::::::::
    //Mostrar nodo
    public void mostrarNodo(){
        String datosNodo = clave.toString() + " "+ pop.toString() + " " + push.toString();
        System.out.print(datosNodo +" -> ");
        estados.mostrarLista();    
    }
    @Override
    public String toString(){
        return clave.toString();
    }       
}
//:::::::::::::::::::::::::CLASE PILA::::::::::::::::::::::::::::::::
class CPila{

    //::::::::::: Atributos :::::::::::::::::::
    private Object aElemento;
    private CPila aSubPila;
    private int npila;
    //:::::::::::: Constructores :::::::::::::::::::
    public CPila()
    {
        this.aElemento = null;
        this.aSubPila = null;
        this.npila = 0;
    }
    public CPila(Object pElemento, CPila pSubPila)
    {
        this.aElemento = pElemento;
        this.aSubPila = pSubPila;
    }
    //:::::::::::::::::::::::Getters::::::::::::::::
    public Object getElemento(){
        return aElemento;
    }
    public CPila getSubPila(){
        return aSubPila;
    }
    //::::::::::::::::::: Metodos ::::::::::::::::::
    public boolean EstaVacia(){
        return ((aElemento == null) && (aSubPila == null));
    }
    //Mostrar elemento
    public Object Cima(){
        return aElemento;
    }
    //Apilar
    public void Push(Object pElemento){
        aSubPila = new CPila(aElemento, aSubPila);
        aElemento = pElemento;
        npila++;
    }
    //Desapilar
    public void Pop(){
        if (!EstaVacia()){
            aElemento = getSubPila().aElemento;
            aSubPila = getSubPila().aSubPila;
            npila--;
        }
    }
    public int NPila(){
        return npila;
    }
    public void MostrarPila(){
        if(! EstaVacia()){
            System.out.print(aElemento + " ");
            aSubPila.MostrarPila();
        }
        System.out.println();
    }
    public void LimpiarPila(){
        while (!EstaVacia()){
            Pop();
        }
    }
}
  
//:::::::::::::::::::::::::::::::CLASE GRAFO::::::::::::::::::::::::::::::::::
class Grafo{
    //:::::::::::::::::Atributos:::::::::::::::::::::
    private Object vertice;
    private ListaRec lista;  //Contiene objetos de tipo Nodo
    private Grafo subgrafo;
    //::::::::::::::::::::Constructores::::::::::::::::::
    public Grafo(){
        this.lista = null;
        this.vertice = null;
        this.subgrafo = null;
    }
    public Grafo(Object vertice, ListaRec lista, Grafo subgrafo){
        this.vertice = vertice;
        this.lista = lista;
        this.subgrafo = subgrafo;
    }
    //::::::::::::::::::::::::Getters:::::::::::::::::::::::
    public Object getVertice(){
        return vertice;
    }
    public ListaRec getLista(){
        return lista;
    }
    public Grafo getSubgrafo(){
        return subgrafo;
    }
    
    //:::::::::::::::::::::::::Setters::::::::::::::::::::::
    public void setVertice(Object vertice){
        this.vertice = vertice;
    }
    public void setLista(ListaRec lista){
        this.lista = lista;
    }
    public void setSubgrafo(Grafo subgrafo){
        this.subgrafo = subgrafo;
    }
    
    //:::::::::::::::::::::::::::Métodos:::::::::::::::::::::
    //Determinar si el grafo está vacío
    public boolean estaVacio(){
        return vertice == null;
    }
    //Determinar si un vertice ya existe
    public boolean existeVertice(Object V){
        if(estaVacio())
            return false;
        else
            return vertice.toString().equals(V.toString()) ?
                             true : subgrafo.existeVertice(V);
    }
    //Agregar vértice
    private void agregVert(Object V){
        if(estaVacio()){
            vertice = V;
            lista = new ListaRec();
            subgrafo = new Grafo();
        }
        else
            subgrafo.agregVert(V);
    }
    public void agregarVertice(Object V){
        if(!existeVertice(V))
            agregVert(V);
    }
    //Agregar arco
    public void agregarArco(Object Vo, Object Vd, Object clave, Object pop, Object push){
        if(!estaVacio()){
            if(vertice.toString().equals(Vo.toString())){
                if(lista.Existe(clave))
                    lista.obtenerNodo(clave).getEstados().Agregar(Vd);
                else{
                    lista.Agregar(new Nodo(clave,pop,push));
                    lista.obtenerNodo(clave).getEstados().Agregar(Vd);
                }        
            }
            else
                subgrafo.agregarArco(Vo, Vd, clave, pop, push);  
        }
        else
            System.out.println("No se agregó el arco");    
    }
    //Mostrar grafo
    public void MostrarGrafo(){
        if(!estaVacio()){
            System.out.println("Vertice: " + vertice);
            lista.verNodos();
            subgrafo.MostrarGrafo();       
        }
        else
            System.out.println();
    }
}


public class AutomataSimple {

    //Función para obtener siguiente estado a partir de una letra, se apilara pp y ps
    public static Object nextEst(Object letter, Grafo graph, CPila pila, Object Ea){
        if(graph.estaVacio())
            return null;
        else{
            if(graph.getVertice().toString().equals(Ea.toString())){
                if(graph.getLista().Existe(letter)&&(procsarPil(pila, graph.getLista().obtenerNodo(letter)))){
                    //Se proceso la pila ahora regresar el estado siguiente
                    return graph.getLista().obtenerNodo(letter).getEstados().obtenerIesimo(1);
                }
                else
                    return null;
            }
            else
                return nextEst(letter, graph.getSubgrafo(), pila, Ea);       
        }
    }
    
    public static boolean procsarPil(CPila pila, Nodo nod){
        System.out.print(nod.getClave());
        //Si quiere despilar y la pila esta facia retonar fasle
        if(pila.EstaVacia() && nod.getPop().toString() != "l"){
            System.out.print(" (se acabo la pila, error pop )");
            return false;
        }
        else{
            //Desapilar "l"= lamda
            if (nod.getPop().toString() != "l"){
                System.out.print("(pop: " + nod.getPop() + " -");//este pop tal vez deberia msotrar la cima
                pila.Pop();
            }else{ System.out.print("(pop: _ -");}
            //Apilar
            if (nod.getPush().toString() != "l"){
                System.out.print(" push: " + nod.getPush() + " )");
                pila.Push(nod.getPush());
            }else{ System.out.print(" push: _ )");}
            return true;
        }
    }

    //Función para validar una cadena
    public static boolean validarCad(Object[] word, Grafo graph, CPila pila, Object Ei, Object Ef){
        Object estadoActual = Ei;
        System.out.println(">>" + estadoActual );
        for(Object letter:word){
            if(estadoActual == null){
                System.out.println();
                return false;
            }          
            else{
                estadoActual = nextEst(letter, graph, pila, estadoActual);
                System.out.print("-> " + estadoActual);
            }
            System.out.println();
        }
        System.out.println();
        return (estadoActual == Ef && pila.EstaVacia() );
    }
    //Función para mostrar una lista
    public static void mostrarLista(Object[] lista){
        for(Object O:lista){
            System.out.print(O.toString() + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        //:::::::::::::Crear grafo:::::::::::::::
        Grafo graf = new Grafo();
        CPila pila = new CPila();
        pila.Push("z");
        //Agregar vértices
        graf.agregarVertice("q0");
        graf.agregarVertice("q1");
        graf.agregarVertice("q2");
        graf.agregarVertice("q3");
        //Agregar arcos     ("l") = vacio
        graf.agregarArco("q0", "q1", "l", "z", "z");        //Iniciando automata
        graf.agregarArco("q1", "q1", "a", "l", "a");
        graf.agregarArco("q1", "q2", "b", "a", "l");
        graf.agregarArco("q2", "q2", "b", "a", "l");        
        graf.agregarArco("q2", "q3", "l", "z", "l");        //Terminando automata
        //Declarar Cadenas
        String[] cad1 = {"l", "a", "a", "a", "a", "b", "b", "b", "b", "l"};
        String[] cad2 = {"l", "a", "a" , "b", "b", "b", "l"};
        
        //Mostrar grafo
        System.out.println(":::::::::::::GRAFO DE AUTÓMATA:::::::::::");
        graf.MostrarGrafo();

        //Validar cadenas
        System.out.println(":::::::::::::VALIDAR CARDENAS:::::::::::");
        //Cadena 1
        System.out.print("Cadena 1: ");
        mostrarLista(cad1);
        if(validarCad(cad1, graf, pila, "q0", "q3")){
            System.out.println("Cadena Válida");
        }
        else
            System.out.println("Cadena no válida");
        System.out.println();
        pila.LimpiarPila();
        pila.Push("z");
        //Cadena 2
        System.out.print("Cadena 2: ");
        mostrarLista(cad2);
        if(validarCad(cad2, graf, pila, "q0", "q3")){
            //graf.getPila().MostrarPila();   
            //System.out.println(graf.getPila().getSubPila().getElemento());
            System.out.println("Cadena Válida");
        }
        else
            System.out.println("Cadena no válida");
        System.out.println();

    }
}
