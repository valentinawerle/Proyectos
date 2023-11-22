package colas;  

import java.util.LinkedList;  // Importa la clase LinkedList del paquete java.util

public class COLALKL {  

    private LinkedList<String> cola;  // Declara una variable de instancia 'cola' de tipo LinkedList que almacena Strings

    public COLALKL() {  // Constructor de la clase COLALKL
        cola = new LinkedList<String>();  // Inicializa la variable 'cola' como una nueva LinkedList de Strings
    }

    public boolean estaVacia() {  // Método que devuelve true si la cola está vacía, false en caso contrario
        return cola.isEmpty();
    }

    public void vaciar() {  // Método para vaciar la cola
        cola.clear();  // Limpia la cola, eliminando todos los elementos
        System.out.println("La cola se ha vaciado");  // Imprime un mensaje indicando que la cola se ha vaciado
    }

    public long largo() {  // Método que devuelve el número de elementos en la cola
        return cola.size();
    }

    public String verPrimero() {  // Método que devuelve el primer elemento de la cola
        return cola.getFirst();
    }

    public String verUltimo() {  // Método que devuelve el último elemento de la cola
        return cola.getLast();
    }

    public void sacar() {  // Método para eliminar el primer elemento de la cola
        cola.removeFirst();  // Elimina el primer elemento de la cola
        System.out.println("Se sacó un elemento");  // Imprime un mensaje indicando que se ha sacado un elemento
    }

    public void enfilar(String elemento) {  // Método para agregar un elemento al final de la cola
        cola.addLast(elemento);  // Agrega 'elemento' al final de la cola
        System.out.println("Elemento enfilado");  // Imprime un mensaje indicando que se ha enfilado un elemento
    }
}

