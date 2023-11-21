
public class Nodo {

    //Atributos
    private int elemento;
    private Nodo padre;
    private Nodo hijoIzquierda;
    private Nodo hijoDerecha;
    private Nodo hermano;

    //Constructor
    public Nodo(int elemento) {
        this.setElemento(elemento);
        setPadre(null);
        setHermano(null);
        setHijoIzquierda(null);
        setHijoDerecha(null);

    }

    //Getters y setters
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

    public Nodo getHermano() {
        return hermano;
    }

    public void setHermano(Nodo hermano) {
        this.hermano = hermano;
    }

}