package Listas;

import java.util.LinkedList;

public class ListaTot {
	private String nombre;
	private LinkedList<Integer> lista;
	
	
	public ListaTot(String nombre) {
		lista = new LinkedList<Integer>();
		this.nombre = nombre;
	}
	
	// Método para localizar posiciones de un número en la lista.
	public String localizar(int numero) {
	    String posiciones = "Posiciones: ";
	    if (lista.contains(numero)) {
	        // Itera sobre la lista para encontrar todas las posiciones donde aparece el número.
	        for (int i = 0; i < lista.size(); i++) {
	            if (lista.get(i) == numero) {
	                posiciones += " | " + i + " | ";
	            }
	        }
	    } else {
	        posiciones = " No se encuentra.";
	    }
	    return posiciones;
	}
	
	
	
	public void insertar(int numero) {
		lista.add(numero);
		System.out.println("Elemento agregado.");
	}
	
	public void eliminar(int numero) {
		lista.remove(numero);
		
	}
	
	
	public boolean desordenada() {
		boolean desorden = false;  // Variable para rastrear si la lista está desordenada
		for (int i = 0; i < lista.size(); i++) {
		    System.out.println(lista.get(i));  // Imprime el elemento actual en la posición i
		    for (int j = 1 + i; j < lista.size(); j++) {
		        System.out.println(lista.get(j));  // Imprime el elemento en la siguiente posición j
		        if (lista.get(i) > lista.get(j)) {  // Comprueba si el elemento actual es mayor que el siguiente
		            System.out.println("aqui");  // Imprime un mensaje indicando que hay un elemento mayor en la lista
		            desorden = true;  // La lista está desordenada
		        }
		    }
		}
		return desorden;
	}
	
	// Método para ordenar la lista utilizando el algoritmo de la burbuja
	public void ordenar() {
	    int burbuja = 0;
	    while (desordenada()) {  // Mientras la lista esté desordenada
	        for (int i = 0; i < lista.size(); i++) {
	            System.out.println(lista.get(i));  // Imprime el elemento actual en la posición i
	            burbuja = lista.get(i);  // Guarda el valor actual en una variable de burbuja
	            for (int j = 1 + i; j < lista.size(); j++) {
	                System.out.println(lista.get(j));  // Imprime el elemento en la siguiente posición j
	                if (lista.get(i) > lista.get(j)) {  // Comprueba si el elemento actual es mayor que el siguiente
	                    System.out.println("aqui");  // Imprime un mensaje indicando que hay un elemento mayor en la lista
	                    int nodo1 = lista.get(j);  // Guarda el elemento siguiente en una variable temporal
	                    int nodo2 = lista.get(i);  // Guarda el elemento actual en la siguiente posición
	                    lista.set(i, nodo1);  // Intercambia los elementos en la lista
	                    lista.set(j, nodo2);
	                }
	            }
	        }
	    }
	}

	// Método para imprimir la lista
	public void imprimir() {
	    System.out.println("----------" + nombre + "----------");
	    for (int i = 0; i < lista.size(); i++) {
	        System.out.println ("Posicion"+(i + 1) + "°- " + lista.get(i));  // Imprime cada elemento con su posición
	    }
	}

	// Método para obtener el nombre de la lista
	public String getNombre() {
	    return nombre;
	}

	// Método para establecer el nombre de la lista
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	// Método para obtener el tamaño de la lista
	public int tamaño() {
	    return lista.size();
	}

	// Método para obtener un elemento de la lista por su posición
	public int elemento(int posicion) {
	    return lista.get(posicion);
	}

	// Método para unir dos listas
	public void unir(ListaTot lista2) {
	    for (int i = 0; i < lista2.tamaño(); i++) {
	        lista.addLast(lista2.elemento(i));  // Añade cada elemento de la lista2 al final de la lista actual
	    }
	}

	// Método para dividir la lista en dos sublistas
	public void dividir(ListaTot subLista1, ListaTot subLista2) {
	    int contador = (lista.size() / 2);
	    
	    // Asigna la primera mitad de la lista a subLista1
	    for (int i = 0; i < contador; i++) {
	        subLista1.insertar(lista.get(i));
	    }
	    
	    // Asigna la segunda mitad de la lista a subLista2
	    for (int i = contador; i < lista.size(); i++) {
	        subLista2.insertar(lista.get(i));
	    }
	}
}