package ListasNodo;

//Clase que representa un nodo en la lista enlazada.
public class Nodo {
	
    public int dato;               // Valor almacenado en el nodo.
    public Nodo siguiente;        // Referencia al siguiente nodo en la lista.
    
 // Constructor para inicializar un nodo con un dato específico.
    public Nodo(int dato) {
        this.dato = dato;  // Establece el dato del nodo con el proporcionado.
        this.siguiente = null;  // Establece el siguiente nodo como nulo inicialmente.
    }

    

}