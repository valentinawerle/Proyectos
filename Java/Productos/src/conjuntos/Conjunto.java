package conjuntos;

public class Conjunto {
	private String nombre;
	private int[] numeros;
	private int contador;
	
	// Constructor para inicializar un conjunto con un nombre y un número específico de espacios
	public Conjunto(String nombre, int espacios) {
	    this.nombre = nombre;  // Asigna el nombre proporcionado al conjunto
	    numeros = new int[espacios];  // Crea un arreglo de enteros con la cantidad de espacios especificada
	    this.contador = 0;  // Inicializa el contador de elementos en el conjunto a cero
	    System.out.println("CONJUNTO CREADO");  // Muestra un mensaje indicando que el conjunto ha sido creado
	}

	
	// Método para añadir un número al conjunto
	public void añadir(int numero) {
	    int i = 0;

	    // Verifica si el contador es menor que la longitud del arreglo de números
	    if (contador != numeros.length) {
	        // Busca si el número ya existe en el conjunto
	        while (i < numeros.length) {
	            if (numeros[i] == numero) {
	                System.out.println("EL ELEMENTO " + numero + " YA EXISTE");
	                break;  // Si el número ya existe, se detiene la búsqueda
	            } else {
	                i++;
	            }
	        }
	        // Si el número no existe, se agrega al conjunto
	        numeros[contador] = numero;
	        contador++;
	        System.out.println("ELEMENTO " + numero + " AÑADIDO");

	    } else {
	        System.out.println("LA LISTA ESTÁ LLENA");  // El conjunto está lleno
	    }
	}

	
	public void eliminar(int numero) {
		int i =0;
		// Busca el número en el conjunto
		while (i < numeros.length) {
			 // Si encuentra el número, lo elimina y actualiza el contador
			if(numeros[i] == numero) {
				numeros[i] = 0;
				contador-=-1;
				System.out.println("ELEMENTO "+ numero+" ELIMINADO");
			} else {
				i++;
			}
		}
		System.out.println("EL ELEMENTO "+ numero+"  NO EXISTE");
	}
	
	// Método para verificar si el conjunto está vacío
	public void conjuntoVacio() {
	    if (contador != 0) {
	        System.out.println("CONJUNTO NO VACÍO");
	    } else {
	        System.out.println("CONJUNTO VACÍO");
	    }
	}

	// Método para obtener el número de elementos en el conjunto
	public int numeroElementos() {
	    return contador;  // Devuelve el contador que representa el número de elementos en el conjunto
	}

	
	// Método para verificar si un número existe en el conjunto
	public String existe(int numero) {
	    int i = 0;
	    String existencia = "NO EXISTE";

	    // Busca el número en el conjunto
	    while (i < numeros.length && existencia.equals("NO EXISTE")) {
	        if (numero == numeros[i]) {
	            existencia = "EXISTE";
	        } else {
	            i++;
	        }
	    }

	    return existencia;  // Devuelve "EXISTE" si el número está en el conjunto, "NO EXISTE" si no está
	}

	// Método para obtener el nombre del conjunto
	public String getNombre() {
	    return nombre;  // Devuelve el nombre del conjunto
	}

	// Método para establecer el nombre del conjunto
	public void setNombre(String nombre) {
	    this.nombre = nombre;  // Establece el nombre del conjunto con el proporcionado
	}

	// Método para vaciar el conjunto
	public void vaciar() {
	    for (int i = 0; i < contador; i++) {
	        numeros[i] = 0;  // Establece cada posición del conjunto a 0
	    }
	    contador = 0;  // Reinicia el contador de elementos a 0
	}

	// Método para imprimir el contenido del conjunto
	public String imprimir() {
	    String impresion = "";
	    for (int i = 0; i < contador; i++) {
	        // Concatena la posición y el elemento en una cadena para la impresión
	        impresion += "POSICION: " + i + " , ELEMENTO: " + numeros[i] + "\n";
	    }
	    return impresion;  // Devuelve la cadena con la impresión del contenido del conjunto
	}

	
	

}
