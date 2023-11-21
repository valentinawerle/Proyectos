public class Arbol {

    private String nombre;
    private Nodo raiz;
    private int contador;

    public Arbol(String nombre) {
        this.nombre = nombre;
        this.raiz = null;
        this.contador = 0;
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

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int largo() {
        return this.contador;
    }

    public void cambiarLargo(int largo) {
        this.contador = largo;
    }

    public void destruir() {
        this.raiz = null;
        this.contador = 0;
    }

    public String padre(Nodo nodo1) {
            Nodo aux = nodo1.getPadre();
            if (aux == null) {
                return " NODO_RAIZ";
            } else {
                return "Padre:" + aux;
            }
        }

    public String hijoDerecho(Nodo nodo1){
            Nodo aux = nodo1.getHijoDerecha();
            if (aux == null) {
                return " NODO_RAIZ";
            } else {
                return "Hijo Derecho:" + aux;

            }
        }

    public String hijoIzquierdo(Nodo nodo1){
            Nodo aux = nodo1.getHijoIzquierda();
            if (aux == null) {
                return " NODO_RAIZ";
            } else {
                return "Hijo Izquierdo:" + aux;
            }
        }


    public String raiz() {
         if raiz == null) {
            return " NODO_NULO";
         } else {
        return  "Raiz:" +raiz.getElemento();
                    }
                    }

    public void insertarHijoDerecha(Nodo nodo1, Nodo nodo2) {
        if(nodo1.getHijoDerecha() != null) {
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









    


            }












