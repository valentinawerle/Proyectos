package Arboles3;

import Arboles3.NodoArbol;

import javax.swing.JTextArea;

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

    public void preorden(JTextArea resultArea) {
        preordenRec(raiz, resultArea);
    }

    private void preordenRec(NodoArbol raiz, JTextArea resultArea) {
        if (raiz != null) {
            resultArea.append(raiz.dato + " ");
            preordenRec(raiz.izquierda, resultArea);
            preordenRec(raiz.derecha, resultArea);
        }
    }

    public void inorden(JTextArea resultArea) {
        inordenRec(raiz, resultArea);
    }

    private void inordenRec(NodoArbol raiz, JTextArea resultArea) {
        if (raiz != null) {
            inordenRec(raiz.izquierda, resultArea);
            resultArea.append(raiz.dato + " ");
            inordenRec(raiz.derecha, resultArea);
        }
    }

    public void postorden(JTextArea resultArea) {
        postordenRec(raiz, resultArea);
    }

    private void postordenRec(NodoArbol raiz, JTextArea resultArea) {
        if (raiz != null) {
            postordenRec(raiz.izquierda, resultArea);
            postordenRec(raiz.derecha, resultArea);
            resultArea.append(raiz.dato + " ");
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