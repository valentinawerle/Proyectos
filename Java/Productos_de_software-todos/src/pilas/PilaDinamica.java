package pilas;

import java.util.ArrayList;

public class PilaDinamica {

	private String nombre;
	private ArrayList<Integer> pila;
	private int contador;
	
	public PilaDinamica(String nombre) {
		this.setNombre(nombre);
		contador = -1;
		pila = new ArrayList<Integer>();
	}
	
	public void apilarElemento(int elemento) {
		pila.add(elemento);
		contador++;
	}
	
	public int desapilar() { //Esta linea declara un metodo publico llamado desapilar que devuelve un valor entero.
		if (!pilaVacia()) { //Aqui se inicia un bloque condicional if, que verifica si la pila no esta vacia.
            int elemento = pila.get(contador); //En esta linea, se obtiene el elemento en la posicion actual del contador en la pila. El contador probablemente es una variable que rastrea la posicion actual en la pila.
            pila.set(contador, 0); //el elemento que acabamos de obtener se establece en 0 en la pila. 
            contador--; //Despues de desapilar el elemento, el contador se decrementa para apuntar a la posicion anterior en la pila.
            System.out.println("Elemento desapilado");
            return elemento;
        } else {
            System.out.println("La pila esta vacia.");
            return -1; //En caso de que la pila esta vacia, se devuelve -1 para indicar un valor especial que suele usarse como indicador de error o de que no se pudo realizar la operacion de desapilado.
        }
	}
	
	public void desapilarElemento(int elemento) {
	    // Se crea una nueva instancia de la clase PilaDinamica y se la llama "pilaTemporal".
	    PilaDinamica pilaTemporal = new PilaDinamica("pila");

	    // Se inicia un bucle while que se ejecutara mientras la pila actual (la que llama a esta funcion)
	    // no este vacia.
	    while (!pilaVacia()) {
	        // Se desapila un elemento de la pila actual y se almacena en la variable "elementoActual".
	        int elementoActual = desapilar();

	        // Se compara el elemento desapilado con el elemento que se paso como argumento a la funcion.
	        // Si no son iguales, se apila el elemento desapilado en la pila temporal.
	        if (elementoActual != elemento) {
	            pilaTemporal.apilarElemento(elementoActual);
	        }
	    }

	    // Despues de haber procesado todos los elementos de la pila actual, se ejecuta otro bucle while
	    // para devolver los elementos a la pila actual desde la pila temporal.
	    while (!pilaTemporal.pilaVacia()) {
	        apilarElemento(pilaTemporal.desapilar());
	    }
	}

	
	

	public void desapilarTope() {
		if (!pilaVacia()) { // Verifica si la pila no está vacía
			pila.set(contador, 0);// Establece el elemento en la posición 'contador' a 0
		    contador--;  // Decrementa el contador
            System.out.println("Tope desapilado.");

		} else {
            System.out.println("La pila esta vacia");

		}
		
	}

	
	public int topePila() {
		if (pilaVacia() == true) {
			return 0;
		}
		return pila.get(contador);
	}
	
	// Método para verificar si la pila está vacía
	public boolean pilaVacia() {
	    if (pila.size() == 0) {  // Comprueba si el tamaño de la pila es 0, indicando que está vacía
	        return true;  // La pila está vacía
	    }
	    return false;  // La pila no está vacía
	}

	
	public String imprimir() {
		String impresion = "";	//Aqui se declara una variable llamada impresion de tipo String e inicializa con una cadena vacia. 
		for( int i = 0 ; i < pila.size(); i++) { //La linea contiene una cadena que describe el elemento en la posicion actual del bucle. (i + 1) se utiliza para mostrar el numero de elemento basado en el indice
			impresion += "Elemento " + (i+1) + " : "+pila.get(i) + "\n" ;
		}
		return impresion;
	}	
	
	
	// Método para buscar un elemento en la pila
	public boolean buscarElemento(int elemento) {
	    boolean encontrado = false;  // Variable para rastrear si se ha encontrado el elemento
	    for (int i = 0; i <= contador; i++) {  // Itera a través de la pila hasta la posición 'contador'
	        if (pila.get(i) == elemento) {  // Compara el elemento en la posición actual con el elemento buscado
	            encontrado = true;  // Marca como encontrado si el elemento coincide
	            break;  // Sale del bucle al encontrar el elemento
	        }
	    }
        
        return encontrado;   
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
