package Arboles3;
import javax.swing.JTextArea;

class ArbolBinario {
    private NodoArbol raiz;

    //Constructor
    public ArbolBinario() {
        this.raiz = null;
    }

    //Método para insertar un dato en el árbol
    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    private NodoArbol insertarRec(NodoArbol raiz, int dato) {
        if (raiz == null) { //Si el árbol está vacío, se crea un nuevo nodo
            raiz = new NodoArbol(dato);
            return raiz;
        }

        if (dato < raiz.dato) //Si el dato es menor al dato de la raíz, se inserta a la izquierda
            raiz.izquierda = insertarRec(raiz.izquierda, dato);
        else if (dato > raiz.dato) //Si el dato es mayor al dato de la raíz, se inserta a la derecha
            raiz.derecha = insertarRec(raiz.derecha, dato);

        return raiz;
    }

    //Método para recorrer el árbol en preorden
    public void preorden(JTextArea resultArea) {
        preordenRec(raiz, resultArea);
    }

    private void preordenRec(NodoArbol raiz, JTextArea resultArea) {
        if (raiz != null) { //Si la raíz no es nula, se imprime el dato y se recorre el árbol
            resultArea.append(raiz.dato + " "); //Se imprime el dato de la raíz
            preordenRec(raiz.izquierda, resultArea); //Se recorre el subárbol izquierdo
            preordenRec(raiz.derecha, resultArea); //Se recorre el subárbol derecho
        }
    }

    public void inorden(JTextArea resultArea) { //Método para recorrer el árbol en inorden
        inordenRec(raiz, resultArea);
    }

    private void inordenRec(NodoArbol raiz, JTextArea resultArea) {
        if (raiz != null) { //Si la raíz no es nula, se recorre el árbol
            inordenRec(raiz.izquierda, resultArea); //Se recorre el subárbol izquierdo
            resultArea.append(raiz.dato + " "); //Se imprime el dato de la raíz
            inordenRec(raiz.derecha, resultArea); //Se recorre el subárbol derecho
        }
    }

    public void postorden(JTextArea resultArea) { //Método para recorrer el árbol en postorden
        postordenRec(raiz, resultArea);
    }

    private void postordenRec(NodoArbol raiz, JTextArea resultArea) {
        if (raiz != null) { //Si la raíz no es nula, se recorre el árbol
            postordenRec(raiz.izquierda, resultArea); //Se recorre el subárbol izquierdo
            postordenRec(raiz.derecha, resultArea); //Se recorre el subárbol derecho
            resultArea.append(raiz.dato + " "); //Se imprime el dato de la raíz
        }
    }
    public NodoArbol buscar(int dato) { //Método para buscar un dato en el árbol
        return buscarRec(raiz, dato);
    }

    private NodoArbol buscarRec(NodoArbol raiz, int dato) {
        if (raiz == null || raiz.dato == dato) //Si la raíz es nula o el dato de la raíz es igual al dato buscado, se retorna la raíz
            return raiz;

        if (dato < raiz.dato) //Si el dato es menor al dato de la raíz, se busca en el subárbol izquierdo
            return buscarRec(raiz.izquierda, dato);

        return buscarRec(raiz.derecha, dato); //Si el dato es mayor al dato de la raíz, se busca en el subárbol derecho
    }
    public void eliminarNodo(int valor) { //Método para eliminar un nodo del árbol
        raiz = eliminarNodoRec(raiz, valor);
    }

    private NodoArbol eliminarNodoRec(NodoArbol nodo, int valor) {
        if (nodo == null) //Si el árbol está vacío, se retorna nulo
            return nodo;

        if (valor < nodo.dato)
            nodo.izquierda = eliminarNodoRec(nodo.izquierda, valor);
        else if (valor > nodo.dato)
            nodo.derecha = eliminarNodoRec(nodo.derecha, valor);
        else {
            if (nodo.izquierda == null)
                return nodo.derecha;
            else if (nodo.derecha == null)
                return nodo.izquierda;

            NodoArbol nodoMinValor = encontrarNodoMinValor(nodo.derecha); //Se busca el nodo con el valor mínimo en el subárbol derecho
            nodo.dato = nodoMinValor.dato; //Se reemplaza el valor del nodo a eliminar con el valor mínimo encontrado
            nodo.derecha = eliminarNodoRec(nodo.derecha, nodoMinValor.dato); //Se elimina el nodo con el valor mínimo encontrado
        }
        return nodo;
    }
    public NodoArbol eliminarNodo(NodoArbol raiz, int dato) {
        // Caso base: si la raíz es nula, no hay nada que eliminar, se devuelve la raíz actual
        if (raiz == null)
            return raiz;

        // Compara el dato a eliminar con el valor de la raíz actual
        if (dato < raiz.dato) {
            // Si el dato es menor, se llama recursivamente a eliminarNodo en el subárbol izquierdo
            raiz.izquierda = eliminarNodo(raiz.izquierda, dato);
        } else if (dato > raiz.dato) {
            // Si el dato es mayor, se llama recursivamente a eliminarNodo en el subárbol derecho
            raiz.derecha = eliminarNodo(raiz.derecha, dato);
        } else {
            // Si el dato coincide con el valor de la raíz actual, se procede a la eliminación del nodo

            // Caso 1: si la raíz no tiene hijo izquierdo, devuelve su hijo derecho (si existe)
            if (raiz.izquierda == null)
                return raiz.derecha;
                // Caso 2: si la raíz no tiene hijo derecho, devuelve su hijo izquierdo (si existe)
            else if (raiz.derecha == null)
                return raiz.izquierda;

            // Caso 3: si la raíz tiene ambos hijos
            // Encuentra el nodo con el valor mínimo en el subárbol derecho de la raíz
            NodoArbol nodoMinValor = encontrarNodoMinValor(raiz.derecha);
            // Reemplaza el valor de la raíz con el valor mínimo encontrado
            raiz.dato = nodoMinValor.dato;
            // Elimina recursivamente el nodo con el valor mínimo del subárbol derecho
            raiz.derecha = eliminarNodo(raiz.derecha, nodoMinValor.dato);
        }
        // Devuelve la raíz actualizada después de la eliminación o sin cambios si no se eliminó ningún nodo
        return raiz;
    }

    // Método auxiliar para encontrar el nodo con el valor mínimo en un subárbol


    private NodoArbol encontrarNodoMinValor(NodoArbol nodo) {
        while (nodo.izquierda != null)
            nodo = nodo.izquierda;
        return nodo;
    }
}