package Arboles3;

import Arboles3.NodoArbol;

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