public class Nodo {

    private int elemento;
    private Nodo padre;
    private Nodo hijoIzquierda;
    private Nodo hijoDerecha;


    public Nodo(int elemento) {
        this.elemento = elemento;
        this.padre = null;
        this.hijoIzquierda = null;
        this.hijoDerecha = null;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Nodo getHijoIzquierda() {
        return hijoIzquierda;
    }

    public void setHijoIzquierda(Nodo hijoIzquierda) {
        this.hijoIzquierda = hijoIzquierda;
    }

    public Nodo getHijoDerecha() {
        return hijoDerecha;
    }

    public void setHijoDerecha(Nodo hijoDerecha) {
        this.hijoDerecha = hijoDerecha;
    }
}
