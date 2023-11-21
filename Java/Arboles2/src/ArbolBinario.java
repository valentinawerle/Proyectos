class ArbolBinario {
    private NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    private NodoArbol insertarRec(NodoArbol raiz, int dato) {
        if (raiz == null) {
            raiz = new NodoArbol(dato);
            return raiz;
        }

        if (dato < raiz.dato)
            raiz.izquierda = insertarRec(raiz.izquierda, dato);
        else if (dato > raiz.dato)
            raiz.derecha = insertarRec(raiz.derecha, dato);

        return raiz;
    }

    public void inorden() {
        inordenRec(raiz);
    }

    private void inordenRec(NodoArbol raiz) {
        if (raiz != null) {
            inordenRec(raiz.izquierda);
            System.out.print(raiz.dato + " ");
            inordenRec(raiz.derecha);
        }
    }

    public void preorden() {
        preordenRec(raiz);
    }

    private void preordenRec(NodoArbol raiz) {
        if (raiz != null) {
            System.out.print(raiz.dato + " ");
            preordenRec(raiz.izquierda);
            preordenRec(raiz.derecha);
        }
    }

    public void postorden() {
        postordenRec(raiz);
    }

    private void postordenRec(NodoArbol raiz) {
        if (raiz != null) {
            postordenRec(raiz.izquierda);
            postordenRec(raiz.derecha);
            System.out.print(raiz.dato + " ");
        }
    }

    public NodoArbol buscar(int dato) {
        return buscarRec(raiz, dato);
    }

    private NodoArbol buscarRec(NodoArbol raiz, int dato) {
        if (raiz == null || raiz.dato == dato)
            return raiz;

        if (dato < raiz.dato)
            return buscarRec(raiz.izquierda, dato);

        return buscarRec(raiz.derecha, dato);
    }
    public void eliminarNodo(int valor) {
        raiz = eliminarNodoRec(raiz, valor);
    }

    private NodoArbol eliminarNodoRec(NodoArbol nodo, int valor) {
        if (nodo == null)
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

            NodoArbol nodoMinValor = encontrarNodoMinValor(nodo.derecha);
            nodo.dato = nodoMinValor.dato;
            nodo.derecha = eliminarNodoRec(nodo.derecha, nodoMinValor.dato);
        }
        return nodo;
    }
    public NodoArbol eliminarNodo(NodoArbol raiz, int dato) {
        if (raiz == null)
            return raiz;

        if (dato < raiz.dato)
            raiz.izquierda = eliminarNodo(raiz.izquierda, dato);
        else if (dato > raiz.dato)
            raiz.derecha = eliminarNodo(raiz.derecha, dato);
        else {
            if (raiz.izquierda == null)
                return raiz.derecha;
            else if (raiz.derecha == null)
                return raiz.izquierda;

            NodoArbol nodoMinValor = encontrarNodoMinValor(raiz.derecha);
            raiz.dato = nodoMinValor.dato;
            raiz.derecha = eliminarNodo(raiz.derecha, nodoMinValor.dato);
        }
        return raiz;
    }

    private NodoArbol encontrarNodoMinValor(NodoArbol nodo) {
        while (nodo.izquierda != null)
            nodo = nodo.izquierda;
        return nodo;
    }
}