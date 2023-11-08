
public class Tabla {

    private Elemento tabla[];
    private int tamanio;


    public Tabla(int size){
        this.tamanio = size;
        this.tabla = new Elemento[size];
        for(int i = 0; i < size; i++){
            this.tabla[i] = null;
        }
    }


    public int hash(Elemento elemento1){
        int clave = elemento1.getDni();
        return clave % tamanio;
    }


    public void insertar(Elemento elemento1, int posicion){

        if (tabla[posicion] == null) {
            tabla[posicion] = elemento1;
        } else {

            int nuevaPosicion = encontrarNuevaPosicion(posicion);
            if (nuevaPosicion != -1) {
                tabla[nuevaPosicion] = elemento1;
            } else {

                Elemento actual = tabla[posicion];
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(elemento1);
            }
        }
    }

    public int encontrarNuevaPosicion(int posicion) {
        for (int i = 0; i < tamanio; i++) {
            int nuevaPosicion = (posicion + i) % tamanio;
            if (tabla[nuevaPosicion] == null) {
                return nuevaPosicion;
            }
        }
        return -1;
    }

    public boolean eliminar(int clave) {
        try {
            if (clave < 0) {
                throw new Exception("El dni no puede ser negativo");
            }

            for (int i = 0; i < tabla.length; i++) {

                Elemento actual = tabla[i];
                Elemento anterior = null;
                while (actual != null) {
                    if (actual.getDni() == clave) {
                        if (anterior != null) {

                            anterior.setSiguiente(actual.getSiguiente());
                        } else {
                            tabla[i] = actual.getSiguiente();
                        }
                        return true;
                    }

                    anterior = actual;
                    actual = actual.getSiguiente();
                }
            }
        } catch (Exception elemento1){
            System.out.println(elemento1.getMessage());
        }
        return false;
    }

    public int buscar(int clave){
        try{
            if(clave < 0){
                throw new Exception("El dni no puede ser negativo");
            }

            for (int i = 0; i < tabla.length; i++) {
                Elemento actual = tabla[i];
                while (actual != null) {
                    if (actual.getDni() == clave) {
                        if(actual == tabla[i]){
                            System.out.println("El elemento esta en el primer nivel de la tabla");
                        } else {
                            System.out.println("El elemento se encuentra en un nodo");
                        }

                        return i;
                    }
                    actual = actual.getSiguiente();
                }
            }
        } catch (Exception elemento1){
            System.out.println(elemento1.getMessage());
        }
        return -1;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanio; i++) {
            sb.append(i).append(": ");
            if (tabla[i] != null) {
                sb.append(tabla[i].toString());
            } else {
                sb.append("vacio");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}