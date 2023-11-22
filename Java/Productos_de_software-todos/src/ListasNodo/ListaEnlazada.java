package ListasNodo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase que representa una lista enlazada.
class ListaEnlazada extends Nodo{
    private Nodo inicio; // Puntero al primer nodo de la lista.
    // Constructor de la lista enlazada, inicializa la lista como vacía.
    public ListaEnlazada(int dato) {
    	super(dato);
        this.setInicio(null);
    }
 // Método para localizar un elemento y mostrar todos los índices donde se encuentra.
    public void localizar(int valor) {
        if (estaVacia()) {
            System.out.println("La lista esta vacia.");  // Imprime un mensaje si la lista está vacía
            return;
        }

        List<Integer> indices = new ArrayList<>();  // Lista para almacenar los índices donde se encuentra el valor
        Nodo actual = inicio;  // Nodo actual apunta al inicio de la lista
        int indice = 0;  // Variable para almacenar el índice actual

        // Itera sobre la lista enlazada
        while (actual != null) {
            if (actual.dato == valor) {
                indices.add(indice);  // Si el valor actual es igual al valor buscado, se agrega el índice a la lista
            }
            actual = actual.siguiente;  // Avanza al siguiente nodo
            indice++;  // Incrementa el índice
        }

        if (indices.isEmpty()) {
            System.out.println("El valor no se encuentra en la lista.");  // Imprime un mensaje si no se encuentra el valor
        } else {
            System.out.print("El valor " + valor + " se encuentra en los índices: ");
            for (int i = 0; i < indices.size(); i++) {
                if (i > 0) {
                    System.out.print(", ");  // Imprime una coma para separar los índices
                }
                System.out.print(indices.get(i));  // Imprime el índice
            }
            System.out.println();  // Nueva línea para finalizar la impresión de índices
        }
    }

 // Método para verificar si la lista está vacía.
    public boolean estaVacia() {
        return getInicio() == null;  // Retorna true si el inicio de la lista es null, es decir, la lista está vacía
    }
//insertar
    public void insertarEnIndice(int dato, int indice) {
        Nodo nuevoNodo = new Nodo(dato);  // Crea un nuevo nodo con el dato proporcionado

        if (indice < 0) {
            System.out.println("Indice no válido. No se pudo insertar.");  // Imprime un mensaje si el índice no es válido
            return;
        }

        if (indice == 0) {
            // Insertar al inicio de la lista.
            nuevoNodo.siguiente = inicio;  // El siguiente del nuevo nodo apunta al nodo que actualmente está al inicio de la lista
            inicio = nuevoNodo;  // El nuevo nodo se convierte en el inicio de la lista
        } else {
            Nodo actual = inicio;  // Nodo actual apunta al inicio de la lista
            int contador = 0;  // Variable para contar el índice actual

            // Avanzar al nodo anterior al índice de inserción.
            while (actual != null && contador < indice - 1) {
                actual = actual.siguiente;  // Avanza al siguiente nodo
                contador++;  // Incrementa el contador del índice
            }

            if (actual == null) {
                System.out.println("Indice fuera de rango. No se pudo insertar.");  // Imprime un mensaje si el índice está fuera de rango
            } else {
                // Insertar el nuevo nodo después del nodo actual.
                nuevoNodo.siguiente = actual.siguiente;  // El siguiente del nuevo nodo apunta al siguiente del nodo actual
                actual.siguiente = nuevoNodo;  // El siguiente del nodo actual apunta al nuevo nodo
            }
        }
    }


 // Método para mostrar los elementos de la lista.
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La lista está vacia.");  // Imprime un mensaje si la lista está vacía
            return;
        }
        
        Nodo temp = getInicio();  // Nodo temporal apunta al inicio de la lista
        
        while (temp != null) {
            System.out.print(temp.dato + " -> ");  // Imprime el dato del nodo actual y una flecha
            temp = temp.siguiente;  // Avanza al siguiente nodo
        }
        
        System.out.println("null");  // Imprime "null" para indicar el final de la lista
    }

 // Método para eliminar un elemento de la lista.
    public void eliminar(int dato) {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");  // Imprime un mensaje si la lista está vacía
            return;
        }

        if (getInicio().dato == dato) {
            setInicio(getInicio().siguiente);  // Establece el inicio de la lista como el siguiente nodo al actual inicio
            return;
        }

        Nodo temp = getInicio();  // Nodo temporal apunta al inicio de la lista
        while (temp.siguiente != null && temp.siguiente.dato != dato) {
            temp = temp.siguiente;  // Avanza al siguiente nodo hasta encontrar el dato o llegar al final de la lista
        }

        if (temp.siguiente != null) {
            temp.siguiente = temp.siguiente.siguiente;  // Elimina el nodo que contiene el dato al enlazar el nodo actual con el siguiente del siguiente nodo
        } else {
            System.out.println("El elemento no se encuentra en la lista.");  // Imprime un mensaje si el elemento no se encuentra en la lista
        }
    }

 // Método para ordenar la lista en orden.
    public void ordenar() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");  // Imprime un mensaje si la lista está vacía
            return;
        }

        boolean intercambio;
        do {
            intercambio = false;  // Inicializa la variable de intercambio en falso

            Nodo actual = getInicio();  // Nodo actual apunta al inicio de la lista
            Nodo siguiente = getInicio().siguiente;  // Nodo siguiente apunta al nodo siguiente al inicio

            // Itera sobre la lista y realiza el intercambio si es necesario
            while (siguiente != null) {
                if (actual.dato > siguiente.dato) {
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    intercambio = true;  // Indica que se realizó un intercambio
                }
                actual = siguiente;  // Avanza al siguiente nodo
                siguiente = siguiente.siguiente;  // Avanza al siguiente nodo
            }
        } while (intercambio);  // Repite el proceso hasta que no se realice ningún intercambio
    }

 // Método para crear una copia de la lista actual.
    public ListaEnlazada copiar() {
        // Crear una nueva instancia de ListaEnlazada para almacenar la copia
        ListaEnlazada copia = new ListaEnlazada(dato);

        // Verificar si la lista actual no está vacía
        if (!estaVacia()) {
            // Inicializar un nodo temporal para iterar sobre la lista actual desde el inicio
            Nodo temp = getInicio();

            while (temp != null) {
                // Insertar el dato del nodo actual en la lista de copia
                copia.insertarEnIndice(temp.dato, 0); // Aquí ajustamos el llamado al método
                temp = temp.siguiente;  // Mover al siguiente nodo
            }

        }

        // Devolver la lista copiada
        return copia;
    }

 // Método para unir la lista actual con otra lista.
 // Recorre la lista actual y agrega cada elemento a la nueva lista.
    public void unir(ListaEnlazada otraLista) {
     // Verificar si la otra lista es nula o está vacía
     if (otraLista == null || otraLista.estaVacia()) {
         return;  // No hay nada que unir, así que salimos del método
     }

     // Inicializar un nodo temporal para recorrer la lista actual hasta el último nodo
     Nodo temp = getInicio();

  // Iterar hasta llegar al último nodo de la lista
     while (temp.siguiente != null) {
         temp = temp.siguiente;  // Avanzar al siguiente nodo
     }


     // Una vez en el último nodo de la lista actual, enlazarlo con el inicio de la otra lista
     temp.siguiente = otraLista.getInicio();
 }

 // Método para dividir la lista en sublistas.
    public ListaEnlazada[] dividir(int numSublistas) {
        // Verificar si la lista está vacía
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return null;  // Si está vacía, regresamos null
        }

        // Crear un arreglo para almacenar las sublistas
        ListaEnlazada[] sublistas = new ListaEnlazada[numSublistas];

        // Inicializar cada sublista en el arreglo
        for (int i = 0; i < numSublistas; i++) {
            sublistas[i] = new ListaEnlazada(dato);
        }

        int index = 0;
        Nodo temp = getInicio();

     // Iterar sobre la lista original
        while (temp != null) {
            // Insertar el dato en la sublista correspondiente (según el índice)
            sublistas[index % numSublistas].insertarEnIndice(temp.dato, 0); // Aquí ajustamos el llamado al método
            temp = temp.siguiente;  // Mover al siguiente nodo
            index++;
        }
        // Devolver el arreglo de sublistas
        return sublistas;
    }


 // Método para obtener el nodo de inicio de la lista.
    public Nodo getInicio() {
        return inicio;  // Devuelve el nodo de inicio de la lista.
    }

    // Método para establecer el nodo de inicio de la lista.
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;  // Establece el nodo de inicio de la lista con el proporcionado.
    }

}
