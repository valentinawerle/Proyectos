package pilas;

public class PilaEstatica {
	
	private String nombre;
	private int[] pila;
	private int[] desapilar;
	private int tamaño;
	private int contador;
	private int descontador;
	
	public PilaEstatica( String nombre, int tamaño) {
		this.setNombre(nombre);
		this.tamaño = tamaño;
		pila = new int[tamaño];
		contador = -1;
		
	}
	
	public void apilarElemento(int elemento) {
		if (contador < tamaño - 1) {  //verifica si la variable contador es menor que tamaño - 1. Esto se utiliza para comprobar si la pila no estÃ¡ llena. Si contador es menor que tamaño - 1, significa que aÃºn hay espacio en la pila para apilar mÃ¡s elementos.
            contador++; //Si la condiciÃ³n anterior se cumple (es decir, la pila no estÃ¡ llena), se incrementa la variable contador en 1.
            pila[contador] = elemento; // se asigna el valor del argumento elemento al elemento en la posiciÃ³n contador de la matriz pila. Esto efectivamente apila el elemento en la pila.
            System.out.println("Elemento apilado: " + elemento);
        } else {
            System.out.println("La pila estÃ¡ llena.");
        }
	}
	
	public int desapilar() {
	    // Comprueba si la pila no estÃ¡ vacÃ­a
	    if (!pilaVacia()) {
	        // Obtiene el elemento en la posiciÃ³n actual del contador
	        int elemento = pila[contador];
	        
	        // Asigna 0 a la posiciÃ³n actual del contador para eliminar el elemento de la pila
	        pila[contador] = 0;
	        
	        // Decrementa el contador para apuntar al siguiente elemento en la pila
	        contador--;

	        // Imprime un mensaje indicando que se ha desapilado un elemento
	        System.out.println("Elemento desapilado");

	        // Devuelve el elemento que se ha desapilado
	        return elemento;
	    } else {
	        // Si la pila estÃ¡ vacÃ­a, imprime un mensaje indicando que la pila estÃ¡ vacÃ­a
	        System.out.println("La pila estÃ¡ vacÃ­a.");
	        
	        // Devuelve -1 para indicar que no se pudo desapilar ningÃºn elemento
	        return -1;
	    }
	}

	public void desapilarElemento(int elemento) {
		PilaEstatica pilaTemporal = new PilaEstatica("pila" ,tamaño);
        while (!pilaVacia()) {
            int elementoActual = desapilar();
            if (elementoActual != elemento) {
                pilaTemporal.apilarElemento(elementoActual);
            }
        }

        while (!pilaTemporal.pilaVacia()) {
            apilarElemento(pilaTemporal.desapilar());
        }
	}
	
	public void desapilarTope() {
		if (!pilaVacia()) {
			pila[contador] = 0;
		    contador --;
            System.out.println("Tope desapilado.");

		} else {
            System.out.println("La pila esta vacia");

		}
		
	}
	
	
	public int topePila() {
		return pila[contador];
	}
	
	public boolean pilaVacia() {
		if(contador == -1) {
			return true;
		}
		return false;
	}
	
	public boolean pilaLlena() {
		if(contador +1 == tamaño) {
			return true;
		}
		return false;
	}
	
	public String imprimir() {
	    // DeclaraciÃ³n de una variable de tipo String llamada "impresion" que se inicializa como una cadena vacÃ­a.
	    String impresion = "";

	    // Comprueba si la pila no estÃ¡ vacÃ­a utilizando el mÃ©todo "pilaVacia()".
	    if (!pilaVacia()) {
	        // Inicia un bucle "for" que recorrerÃ¡ desde 0 hasta el tamaño de la pila.
	        for (int i = 0; i < tamaño; i++) {
	            // Agrega a la cadena "impresion" informaciÃ³n sobre el elemento en la posiciÃ³n "i" de la pila.
	            impresion += "Elemento " + (i+1) + " : "+ pila[i] + "\n";
	        }
	    } else {
	        // Si la pila estÃ¡ vacÃ­a, asigna un mensaje indicando que la pila estÃ¡ vacÃ­a a la variable "impresion".
	        impresion = "la pila esta vacia";
	    }

	    // Devuelve la cadena "impresion" que contiene la representaciÃ³n de la pila o un mensaje de pila vacÃ­a.
	    return impresion;
	}

	
	public boolean buscarElemento(int elemento) {
	    // Declara una variable booleana llamada "encontrado" e inicializa con "false"
	    boolean encontrado = false;
	    // Inicia un bucle "for" que iterarÃ¡ desde i=0 hasta contador (inclusive)
	    for (int i = 0; i <= contador; i++) {
	        // Comprueba si el elemento en la posiciÃ³n actual de la pila es igual al "elemento" buscado
	        if (pila[i] == elemento) {
	            // Si se encuentra el elemento, cambia el valor de "encontrado" a "true"
	            encontrado = true;
	            // Sale del bucle "for" porque ya se encontrÃ³ el elemento
	            break;
	        }
	    }
	    // Devuelve el valor de "encontrado" como resultado de la funciÃ³n
	    return encontrado;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
