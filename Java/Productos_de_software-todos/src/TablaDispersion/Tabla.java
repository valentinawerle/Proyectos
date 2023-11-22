package TablaDispersion;
public class Tabla {

    //Atributos
    private Elemento tabla[];
    private int tamanio;

    //Constructor
    public Tabla(int size){
        this.tamanio = size;
        this.tabla = new Elemento[size];
        for(int i = 0; i < size; i++){
            this.tabla[i] = null;
        }
    }

    public int hash(Elemento elemento1){ //Funcion hash
        int clave = elemento1.getDni();
        return clave % tamanio; //Retorna la posicion en la que se debe insertar el elemento
    }


    public void insertar(Elemento elemento1, int posicion){ //Metodo para insertar un elemento en la tabla

        if (tabla[posicion] == null) {
            tabla[posicion] = elemento1;
        } else {

            int nuevaPosicion = encontrarNuevaPosicion(posicion); //Si la posicion esta ocupada, busca una nueva posicion
            if (nuevaPosicion != -1) {
                tabla[nuevaPosicion] = elemento1;
            } else {

                Elemento actual = tabla[posicion]; //Si no encuentra una nueva posicion, inserta el elemento en la ultima posicion de la lista
                while (actual.getSiguiente() != null) { //Si la lista no esta vacia, recorre la lista hasta llegar al ultimo elemento
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(elemento1); //Inserta el elemento en la ultima posicion de la lista
            }
        }
    }

    public int encontrarNuevaPosicion(int posicion) { //Metodo para encontrar una nueva posicion en caso de que la posicion inicial este ocupada
        for (int i = 0; i < tamanio; i++) {
            int nuevaPosicion = (posicion + i) % tamanio;
            if (tabla[nuevaPosicion] == null) {
                return nuevaPosicion;
            }
        }
        return -1;
    }

    public boolean eliminar(int clave) { //Metodo para eliminar un elemento de la tabla
        try {
            if (clave < 0) {
                throw new Exception("El dni no puede ser negativo");
            }

            for (int i = 0; i < tabla.length; i++) { //Recorre la tabla

                Elemento actual = tabla[i]; //Obtiene el elemento actual en la posicion 'i' de la tabla
                Elemento anterior = null;
                while (actual != null) {
                    if (actual.getDni() == clave) { //Verifica si el DNI del elemento actual coincide con la clave buscada
                        if (anterior != null) {

                            anterior.setSiguiente(actual.getSiguiente());
                        } else {
                            tabla[i] = actual.getSiguiente();
                        }
                        return true;
                    }

                    anterior = actual; // Guarda el elemento actual como el elemento anterior para el siguiente ciclo
                    actual = actual.getSiguiente(); // Avanza al siguiente elemento de la estructura asociada a esa posicion de la tabla
                }
            }
        } catch (Exception elemento1){
            System.out.println(elemento1.getMessage());
        }
        return false;
    }

    public int buscar(int clave) { // Método para buscar un elemento en la tabla
        try {
            if (clave < 0) { // Verifica si la clave es negativa
                throw new Exception("El dni no puede ser negativo"); // Lanza una excepción si la clave es negativa
            }

            for (int i = 0; i < tabla.length; i++) { // Recorre la tabla hash
                Elemento actual = tabla[i]; // Obtiene el elemento actual en la posición 'i' de la tabla
                while (actual != null) {
                    if (actual.getDni() == clave) { // Verifica si el DNI del elemento actual coincide con la clave buscada
                        if (actual == tabla[i]) { // Comprueba si el elemento está en el primer nivel de la tabla
                            System.out.println("El elemento está en el primer nivel de la tabla");
                        } else {
                            System.out.println("El elemento se encuentra en un nodo"); // Indica que el elemento está en un nodo asociado a esa posición de la tabla
                        }
                        return i; // Devuelve el índice de la tabla donde se encontró el elemento
                    }
                    actual = actual.getSiguiente(); // Avanza al siguiente elemento de la estructura asociada a esa posición de la tabla
                }
            }
        } catch (Exception elemento1) { // Captura la excepción si la clave es negativa
            System.out.println(elemento1.getMessage()); // Imprime el mensaje de la excepción
        }
        return -1; // Devuelve -1 si no se encuentra el elemento en la tabla hash
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