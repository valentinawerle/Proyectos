public class Arbol {

    //Atributos
    private String nombre;
    private Nodo raiz;
    private int contador;

    //Constructor
    public Arbol(String nombre) {
        this.setNombre(nombre);
        setRaiz(null);
        cambiarLargo(0);

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //Metodo que devuelve el contador
    public int largo() {
        return contador;
    }

    //Metodo que cambia el largo
    public void cambiarLargo(int contador) {
        this.contador = contador;
    }

    //Metodo que destruye el arbol
    public void destruir() {
        setRaiz(null);
        cambiarLargo(0);
    }

    public String padre(Nodo nodo1) {
        Nodo aux = nodo1.getPadre();

        // Si el nodo padre es nulo, el nodo1 es la raíz.
        if (aux == null) {
            return " NODO_RAIZ";
        } else {
            // Si el nodo padre no es nulo, se devuelve la representación del padre.
            return "Padre:" + aux;
        }
    }


    public String hijoIzquierdo(Nodo nodo1) {
        Nodo aux = nodo1.getHijoIzquierda();

        // Si el nodo hijo izquierdo es nulo, el nodo1 es la raíz del subárbol.
        if (aux == null) {
            return " NODO_RAIZ";
        } else {
            // Si el nodo hijo izquierdo no es nulo, se devuelve su representación.
            return "Hijo izquierdo:" + aux;
            // Dependiendo de la implementación de la clase 'Nodo', esto puede mostrar la referencia del objeto 'aux'.
        }
    }


    public String hijoDerecho(Nodo nodo1) {
        Nodo aux = nodo1.getHijoDerecha();
        if(aux == null) {
            return " NODO_RAIZ";
        } else {
            return  "Hijo derecho:" + aux;
        }
    }

    //Metodo que devuelve la raiz
    public String raiz() {
        if(raiz == null) {
            return " NODO_NULO";
        } else {
            return  "Raiz:" +raiz.getElemento();
        }
    }

    public void insertarHijoDerecha(Nodo nodo1, Nodo nodo2) {
        // Verifica si el nodo1 ya tiene un hijo derecho.
        if (nodo1.getHijoDerecha() != null) {
            // Si no tiene un hijo derecho, se establece nodo2 como su hijo derecho.
            nodo1.setHijoDerecha(nodo2);
            System.out.println("Hijo derecho insertado");
        } else {
            System.out.println("Hijo derecho ya existe");
        }
    }


    public void insertarHijoIzquierda(Nodo nodo1, Nodo nodo2) {
        if(nodo1.getHijoIzquierda() != null) {
            nodo1.setHijoIzquierda(nodo2);
            System.out.println("Hijo izquierdo insertado");

        } else {
            System.out.println("Hijo izquierdo ya existe");
        }
    }

    public void podarHijoDerecha(Nodo nodo1) {
        nodo1.setHijoDerecha(null); // Se establece el hijo derecho como nulo.
        System.out.println("Nodo borrado");
    }

    public void podarHijoIzquierda(Nodo nodo1) {
        nodo1.setHijoIzquierda(null);
        System.out.println("Nodo borrado");
    }



}
