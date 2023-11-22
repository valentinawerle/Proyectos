package conjuntos;

import java.util.HashMap;
import java.util.Map;

//import pilas.PilaEstatica;


public class OpeCon {  // Define la clase OpeCon

    private Map<String, Conjunto> listaCon;  // Mapa para almacenar conjuntos por nombre

    public OpeCon() {  // Constructor de la clase OpeCon
        listaCon = new HashMap<>();  // Inicializa el mapa para almacenar conjuntos
    }

    public void agregarConjunto(Conjunto conjunto) {  // Método para agregar un conjunto
        String nombre = conjunto.getNombre();
        listaCon.put(nombre, conjunto);  // Almacena el conjunto en el mapa por su nombre
    }

    public void eliminarConjunto(Conjunto conjunto) {  // Método para eliminar un conjunto
        String nombre = conjunto.getNombre();
        listaCon.remove(nombre);  // Elimina el conjunto del mapa por su nombre
    }

    public void agregarElemento(String nombre, int elemento) {  // Método para agregar un elemento a un conjunto
        Conjunto con1 = listaCon.get(nombre);
        con1.añadir(elemento);  // Agrega el elemento al conjunto correspondiente
    }

    public void eliminarElemento(String nombre, int elemento) {  // Método para eliminar un elemento de un conjunto
        Conjunto con1 = listaCon.get(nombre);
        con1.eliminar(elemento);  // Elimina el elemento del conjunto correspondiente
    }

    public void vacio(String nombre) {  // Método para verificar si un conjunto está vacío
        Conjunto con1 = listaCon.get(nombre);
        con1.conjuntoVacio();  // Verifica si el conjunto está vacío
    }

    public void vaciarConjunto(String nombre) {  // Método para vaciar un conjunto
        Conjunto con1 = listaCon.get(nombre);
        con1.vaciar();  // Vacía el conjunto
    }

    public void cantidadElementos(String nombre) {  // Método para obtener la cantidad de elementos en un conjunto
        Conjunto con1 = listaCon.get(nombre);
        System.out.println("EL CONJUNTO " + nombre + " TIENE " + con1.numeroElementos() + " ELEMENTOS.");
    }

    public void elementoExiste(int elemento) {  // Método para verificar si un elemento existe en algún conjunto
        String conjuntos = "";
        for (Conjunto con1 : listaCon.values()) {  // Itera sobre los conjuntos
            if (con1.existe(elemento).equals("EXISTE")) {  // Verifica si el elemento existe en el conjunto
                conjuntos += " (" + con1.getNombre() + ") "; // Concatena el nombre del conjunto obtenido a través del método getNombre() 
            }
        }
        if (conjuntos.equals("")) { // Si no se encontró el elemento en ningún conjunto, imprime un mensaje indicando que no existe.
            System.out.println("EL ELEMENTO NO EXISTE EN NINGÚN CONJUNTO.");
        } else {
            System.out.println("EL ELEMENTO " + elemento + " EXISTE EN LOS CONJUNTOS: " + conjuntos);
        }
    }

    public void elementoConjuntosExiste(String nombre1, String nombre2, int elemento) {
        // Obtener los conjuntos C1 y C2 por sus nombres desde la lista de conjuntos.
        Conjunto C1 = listaCon.get(nombre1);
        Conjunto C2 = listaCon.get(nombre2);

        // Verificar la existencia del elemento en cada conjunto y mostrar mensajes apropiados.
        if (C1.existe(elemento).equals("EXISTE") && C2.existe(elemento).equals("EXISTE")) {
            System.out.println("EL ELEMENTO EXISTE EN AMBOS CONJUNTOS.");
        } else if (C1.existe(elemento).equals("EXISTE") && C2.existe(elemento).equals("NO EXISTE")) {
            System.out.println("EL ELEMENTO " + elemento + " EXISTE EN EL CONJUNTO " + nombre1);
        } else if (C1.existe(elemento).equals("NO EXISTE") && C2.existe(elemento).equals("EXISTE")) {
            System.out.println("EL ELEMENTO " + elemento + " EXISTE EN EL CONJUNTO " + nombre2);
        } else {
            System.out.println("EL ELEMENTO NO EXISTE EN NINGÚN CONJUNTO.");
        }
    }


 // Método para verificar si un conjunto existe
    public boolean conjuntoExiste(String nombre) {
        // Verifica si el conjunto está en la lista de conjuntos basado en su nombre.
        return listaCon.containsKey(nombre);
    }

    // Método para imprimir un conjunto
    public void imprimirConjunto(String nombre) {
        // Obtiene el conjunto por su nombre desde la lista de conjuntos.
        Conjunto con1 = listaCon.get(nombre);

        // Imprime el nombre del conjunto y su contenido.
        System.out.println("----------" + nombre + "----------");
        System.out.println(con1.imprimir());
    }

}
