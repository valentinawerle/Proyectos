package ArbolBusqueda;

import java.util.HashMap;
import java.util.Map;

public class Bosque {
	
	private Map <String, ArbolB> arboles;
	
	public Bosque() {
		arboles = new HashMap<>();
	}
	
	public void insertarArbol(String nombre) {
		ArbolB nuevo = new ArbolB(nombre);
        arboles.put(nombre, nuevo);  
    }
	
	public void eliminarArbol(String borrar) {
        arboles.remove(borrar);
    }
	
	public void agregarDato(String nombre, int dato) {
		ArbolB arbolito = arboles.get(nombre);
		arbolito.insertar(dato);
    }
	
	public void eliminarDato(String nombre, int dato) {
		ArbolB arbolito = arboles.get(nombre);
		arbolito.eliminar(dato);
    }
	
	public boolean buscarDato(String nombre, int dato) {
		ArbolB arbolito = arboles.get(nombre);
		return arbolito.buscar(dato);
    }
	
	public boolean vacio(String nombre) {
		ArbolB arbolito = arboles.get(nombre);
		return arbolito.arbolVacio();
    }
	
	
	public boolean existe(String nombre) {
		return arboles.containsKey(nombre);
	}
	
	public String imprimirIn(String nombre) {
		ArbolB arbolito = arboles.get(nombre);
		String lista = "  In-Orden  "+ "\n";
		for (int dato : arbolito.recorridoIn()) {
            lista = lista + dato + "\n" ;
        }
		
		return lista;
    }
	
	public String imprimirPre(String nombre) {
		ArbolB arbolito = arboles.get(nombre);
		String lista = "  Pre-Orden  "+ "\n";
		
		for (int dato : arbolito.recorridoPre()) {
            lista = lista + dato + "\n" ;
        }
		
		return lista;
    }
	
	public String imprimirPost(String nombre) {
		ArbolB arbolito = arboles.get(nombre);
		String lista = "  Post-Orden  "+ "\n";
		for (int dato : arbolito.recorridoPost()) {
            lista = lista + dato + "\n" ;
        }
		
		return lista;
    }
	
	public String imprimirArboles() {
		String lista = "-------- ARBOLES --------" + "\n";
		
		
		for (String codigo : arboles.keySet()) {
            lista = lista + codigo + "\n" ;
        }
		
		return lista;
	}
	
	


}
