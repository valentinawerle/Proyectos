package test;

import java.util.*;

public class TestColecciones {

    public static void main(String[] args) {
        List<String> miLista = new ArrayList<>();
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Viernes");

        //lista: permite elementos repetidos y tiene orden de inserción
        imprimir(miLista);

        Set<String> miSet = new HashSet<>();
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        miSet.add("Viernes");

        //set: no permite elementos repetidos y no tiene orden de inserción
        imprimir(miSet);

        Map<String, String> miMapa = new HashMap<>(); //no se puede repetir la llave
        miMapa.put("valor1", "Juan"); //key, value
        miMapa.put("valor2", "Karla");
        miMapa.put("valor3", "Rosario");

        String elemento = miMapa.get("valor1"); //get(key)
        System.out.println("elemento = " + elemento);

        imprimir(miMapa.keySet()); //imprime las llaves
        imprimir(miMapa.values()); //imprime los valores
    }

    public static void imprimir(Collection<?> coleccion) {
        for (Object elemento : coleccion) {
            System.out.println("elemento = " + elemento);
        }
    }
}
