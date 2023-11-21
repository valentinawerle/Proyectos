import java.util.Scanner;
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
            raiz.izquierdo = insertarRec(raiz.izquierdo, dato);
        else if (dato > raiz.dato)
            raiz.derecho = insertarRec(raiz.derecho, dato);

        return raiz;
    }

    public void recorridoInorden() {
        recorridoInordenRec(raiz);
    }

    private void recorridoInordenRec(NodoArbol raiz) {
        if (raiz != null) {
            recorridoInordenRec(raiz.izquierdo);
            System.out.print(raiz.dato + " ");
            recorridoInordenRec(raiz.derecho);
        }
    }

    public void recorridoPreorden() {
        recorridoPreordenRec(raiz);
    }

    private void recorridoPreordenRec(NodoArbol raiz) {
        if (raiz != null) {
            System.out.print(raiz.dato + " ");
            recorridoPreordenRec(raiz.izquierdo);
            recorridoPreordenRec(raiz.derecho);
        }
    }

    public void recorridoPostorden() {
        recorridoPostordenRec(raiz);
    }

    private void recorridoPostordenRec(NodoArbol raiz) {
        if (raiz != null) {
            recorridoPostordenRec(raiz.izquierdo);
            recorridoPostordenRec(raiz.derecho);
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
            return buscarRec(raiz.izquierdo, dato);

        return buscarRec(raiz.derecho, dato);
    }
}