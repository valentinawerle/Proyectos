package colas;  

public class Coland {  

    private Nodo cabeza;  // Declara una variable de instancia 'cabeza' de tipo Nodo
    private Nodo ultimo;  // Declara una variable de instancia 'ultimo' de tipo Nodo
    private int contador;  // Declara una variable de instancia 'contador' de tipo entero

    public Coland() {  
        cabeza = null;  // Inicializa 'cabeza' como null
        ultimo = null;  // Inicializa 'ultimo' como null
        contador = 0;  // Inicializa 'contador' como 0
    }

    public void enfilar(Nodo nodo) {  // Método para encolar un nodo
        contador++;  // Incrementa el contador
        if (contador == 1) {  // Si es el primer elemento encolado
            cabeza = nodo;  // Establece el nodo como la cabeza
            System.out.println("Primer elemento enfilado");  // Imprime un mensaje indicando que es el primer elemento enfilado
        }
        nodo.setApuntador(ultimo);  // Establece el apuntador del nodo al último elemento
        ultimo = nodo;  // Establece el nodo como el último elemento
        System.out.println("Elemento enfilado");  // Imprime un mensaje indicando que un elemento ha sido enfilado
    }

    public void sacar() {  // Método para sacar un elemento de la cola
        Nodo aux = ultimo;  // Crea un nodo auxiliar apuntando al último
        int i = contador;  // Inicializa un contador 'i' con el valor del contador de elementos

        if (estaVacia()) {  // Si la cola está vacía
            System.out.println("La cola está vacía");  // Imprime un mensaje indicando que la cola está vacía
        } else if (contador == 1) {  // Si hay un solo elemento en la cola
            vaciar();  // Vacía la cola
            System.out.println("La cola se ha quedado vacía");  // Imprime un mensaje indicando que la cola está vacía
        } else {  // Si hay más de un elemento en la cola
            while (i > 0 || aux != cabeza) {  // Itera hasta llegar al primer elemento o hasta que 'i' sea 0
                if (aux.getApuntador() == cabeza) {  // Si el apuntador del nodo auxiliar apunta a la cabeza
                    aux.setApuntador(null);  // Establece el apuntador del nodo auxiliar como null
                    cabeza = aux;  // Establece el nodo auxiliar como la nueva cabeza
                    System.out.println("Elemento sacado");  // Imprime un mensaje indicando que un elemento ha sido sacado
                    contador--;  // Decrementa el contador de elementos
                    break;  // Sale del bucle
                } else {
                    aux = aux.getApuntador();  // Avanza al siguiente nodo
                    i--;  // Decrementa 'i'
                }
            }
        }
    }

    public boolean estaVacia() {  // Método que devuelve true si la cola está vacía, false en caso contrario
        return contador == 0;
    }

    public void vaciar() {  // Método para vaciar la cola
        cabeza = null;  // Establece la cabeza como null
        ultimo = null;  // Establece el último como null
        contador = 0;  // Reinicia el contador de elementos
    }

    public long largo() {  // Método que devuelve el número de elementos en la cola
        return contador;
    }

    public String verPrimero() {  // Método que devuelve el primer elemento de la cola
        return cabeza.getElemento();
    }

    public String verUltimo() {  // Método que devuelve el último elemento de la cola
        return ultimo.getElemento();
    }

    public String imprimir() {  // Método para imprimir la cola
        String cola = "";  // Inicializa una cadena vacía para representar la cola
        Nodo aux = ultimo;  // Crea un nodo auxiliar apuntando al último elemento
        int i = contador;  // Inicializa un contador 'i' con el valor del contador de elementos

        while (i > 0) {  // Itera hasta llegar al primer elemento
            cola = " - " + aux.getElemento() + cola;  // Concatena el elemento actual a la representación de la cola
            aux = aux.getApuntador();  // Avanza al siguiente nodo
            i--;  // Decrementa 'i'
        }

        return "Cola ( " + cola + " )";  // Retorna la representación de la cola como una cadena
    }
}

