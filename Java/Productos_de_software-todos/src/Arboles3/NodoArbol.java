package Arboles3;


class NodoArbol {
    int dato;
    NodoArbol izquierda;
    NodoArbol derecha;

    public NodoArbol(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}