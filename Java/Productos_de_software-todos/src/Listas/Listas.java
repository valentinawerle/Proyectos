package Listas;


import java.util.HashMap;
import java.util.Map;

import pilas.PilaEstatica;

import java.util.HashMap;
import java.util.Map;

public class Listas {
    private Map<String, ListaTot> listasL;  // Mapa que almacena listas

    public Listas() {
        listasL = new HashMap<>();  // Inicializa el mapa de listas
    }

    // Inserta una lista en el mapa
    public void insertarLista(ListaTot lista) {
        String nombre = lista.getNombre();
        listasL.put(nombre, lista);
        System.out.println("Lista " + nombre + " creada");
    }

    // Elimina una lista del mapa
    public void eliminarLista(ListaTot lista) {
        String nombre = lista.getNombre();
        listasL.remove(nombre);
        System.out.println("Lista " + nombre + " eliminada");
    }

    // Agrega un elemento a una lista
    public void agregarElemento(String nombre, int elemento) {
        ListaTot lista = listasL.get(nombre);
        lista.insertar(elemento);
    }

    // Saca un elemento de una lista
    public void sacarElemento(String nombre, int elemento) {
        ListaTot lista = listasL.get(nombre);
        lista.eliminar(elemento);
    }

    // Localiza un elemento en las listas y devuelve su posición
    public String localizarElemento(int elemento) {
        String localizar = "";
        for (ListaTot lista : listasL.values()) {
            if (!lista.localizar(elemento).equals(" No se encuentra.")) {
                localizar += lista.getNombre() + lista.localizar(elemento) + "\n";
            }
        }
        if (localizar.equals("")) {
            localizar = "No se encuentra.";
        }
        return localizar;
    }

    // Ordena una lista
    public void ordenarLista(String nombre) {
        ListaTot lista = listasL.get(nombre);
        lista.ordenar();
    }

    // Verifica si una lista existe en el mapa
    public boolean existe(String nombre) {
        return listasL.containsKey(nombre);
    }

    // Imprime una lista
    public void imprimirLista(String nombre) {
        ListaTot lista = listasL.get(nombre);
        lista.imprimir();
    }

    // Crea una copia de una lista
    public void hacerCopia(String nombre, String nombreCopia) {
        ListaTot lista = listasL.get(nombre);
        ListaTot copia = new ListaTot(nombreCopia);
        copia = lista;
        insertarLista(copia);
        System.out.println("Copia de la lista " + nombre + " creada.");
    }

    // Une dos listas y crea una nueva
    public void unirListas(String nombre1, String nombre2, String nuevo) {
        ListaTot lista1 = listasL.get(nombre1);
        ListaTot lista2 = listasL.get(nombre2);

        lista1.unir(lista2);
        listasL.remove(lista2);
        lista1.setNombre(nuevo);
    }

    // Divide una lista en dos sublistas
    public void dividirLista(String nombre, String nombre1, String nombre2) {
        ListaTot lista = listasL.get(nombre);
        ListaTot subLista1 = new ListaTot(nombre1);
        ListaTot subLista2 = new ListaTot(nombre2);
        lista.dividir(subLista1, subLista2);
    }
}
