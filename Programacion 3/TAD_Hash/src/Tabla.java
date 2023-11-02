
public class Tabla {
    // ATRIBUTOS
    private Elemento tabla[];
    private int size;

    // CONSTRUCTOR
    public Tabla(int size){
        this.size = size;
        this.tabla = new Elemento[size];
        for(int i = 0; i < size; i++){
            this.tabla[i] = null;
        }
    }

    // HASH GENERADOR DE POSICION
    public int hash(Elemento e){
        int clave = e.getDni(); // USAR DNI COMO CLAVE
        return clave % size; // DEVUELVE LA POSICION
    }

    // METODOS
    public void insertar(Elemento e, int posicion){
        // SI NO HAY NADA EN ESA POSICION AGREGAR EL ELEMENTO AHI
        if (tabla[posicion] == null) {
            tabla[posicion] = e;
        } else {
            // ENCONTRAR NUEVA POSICION Y GUARDAR EN ESA POSICION
            int nuevaPosicion = encontrarNuevaPosicion(posicion);
            if (nuevaPosicion != -1) {
                tabla[nuevaPosicion] = e;
            } else {
                // ASIGNAR EN LA POSICION PASADA POR PARAMETRO EL POINTER AL NUEVO ELEMENTO Y TRATARLO COMO NODO
                Elemento actual = tabla[posicion];
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(e);
            }
        }
    }

    public int encontrarNuevaPosicion(int posicion) {
        // RECORRER LA LISTA BUSCANDO POSICION VACIA
        for (int i = 0; i < size; i++) {
            int nuevaPosicion = (posicion + i) % size;
            if (tabla[nuevaPosicion] == null) {
                return nuevaPosicion;
            }
        }
        return -1; // DEVOLVER -1 SI NO ENCONTRO NINGUNA POSICION VACIA
    }

    public boolean eliminar(int clave) {
        try {
            if (clave < 0) {
                throw new Exception("EL DNI NO PUEDE SER NEGATIVO");
            }
            // ELEMENTO EN PRIMER NIVEL DE TABLA
            for (int i = 0; i < tabla.length; i++) {
                // TRACKERS
                Elemento actual = tabla[i];
                Elemento anterior = null;
                while (actual != null) {
                    if (actual.getDni() == clave) {
                        if (anterior != null) {
                            // ELIMINAR EL NODO
                            anterior.setSiguiente(actual.getSiguiente());
                        } else {
                            tabla[i] = actual.getSiguiente();
                        }
                        return true;
                    }
                    // ACTUALIZAR PARA SIGUIENTE VUELTA
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int buscar(int clave){
        try{
            if(clave < 0){
                throw new Exception("EL DNI NO PUEDE SER NEGATIVO");
            }
            // ELEMENTO EN PRIMER NIVEL DE TABLA
            for (int i = 0; i < tabla.length; i++) {
                Elemento actual = tabla[i];
                while (actual != null) {
                    if (actual.getDni() == clave) {
                        if(actual == tabla[i]){
                            System.out.println("EL ELEMENTO SE ENCUENTRA EN EL PRIMER NIVEL DE LA TABLA");
                        } else {
                            System.out.println("EL ELEMENTO SE ENCUENTRA EN UN NODO");
                        }
                        // DEVOLVER LA POSICION DONDE SE ENCUENTRA
                        return i;
                    }
                    actual = actual.getSiguiente();
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    // TOSTRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(i).append(": ");
            if (tabla[i] != null) {
                sb.append(tabla[i].toString());
            } else {
                sb.append("VACIO");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}