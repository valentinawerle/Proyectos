package ArbolBusqueda;

import java.util.ArrayList;

public class ArbolB {
	
	private String nombre;
	private Nodo raiz;
	private int contador;
	private ArrayList<Integer> inOrden;
	private ArrayList<Integer> preOrden;
	private ArrayList<Integer> postOrden;
	
	
	//crea un arbol binario vacio
	public ArbolB(String nombre) {
		this.setNombre(nombre);
		raiz = null;
		setContador(0);
		postOrden = new ArrayList<Integer>();
		preOrden = new ArrayList<Integer>();
		inOrden = new ArrayList<Integer>();
	}
	
	public Nodo getRaiz() {
		return raiz;
	}
	
	public boolean arbolVacio() {
		//si el contador esta vacio devuelve true
		if(raiz == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void reiniciarListas() {
		postOrden.clear();
		preOrden.clear();
		inOrden.clear();
	}
	
	
	
	public ArrayList<Integer> recorridoIn() {
		inOrdenR(raiz);
		return inOrden;
	}
	
	public ArrayList<Integer> recorridoPost() {
		postOrdenR(raiz);
		return postOrden;
	}
	public ArrayList<Integer> recorridoPre() {
		preOrdenR(raiz);
		return preOrden;
	}
	
	
	
	//inserta un nuevo elemento
	public void  insertar( int dato) {
		reiniciarListas();
		Nodo nuevoNodo = new Nodo( dato);  //crea un nuevo nodo.
		
		if (raiz == null) { //si la raiz es nula el nuevo nodo se vuelve la raiz.
			raiz = nuevoNodo;
			setContador(getContador() + 1); //incrementa el contador.
			
		} else {
			Nodo auxiliar = raiz;
			Nodo padre;
			while(true) {
				padre =auxiliar;
				
				if (dato < auxiliar.getDato()) { //si el dato es mayor va a la izquierda.
					auxiliar = auxiliar.getHijoIzq();
					if (auxiliar == null ) {  //si el auxiliar esta vacio se agrega el nodo.
						padre.setHijoIzq(nuevoNodo);
						setContador(getContador() + 1); //incrementa el contador.
						break;
					}  
					
				} else if(dato > auxiliar.getDato()) { //si el dato es mayor va a la derecha.
					auxiliar = auxiliar.getHijoDer();
					if (auxiliar == null ) { //si el auxiliar esta vacio se agrega el nodo.
						padre.setHijoDer(nuevoNodo);
						setContador(getContador() + 1); //incrementa el contador.
						break;
					}
				} else if (dato == auxiliar.getDato()) { //si el dato ya exite no lo agrega.
					break;
				}
				
			}
		}
	}
	
	
	public boolean buscar(int dato) {
		Nodo auxiliar = raiz;
		if(auxiliar == null) {
			return false;
		}else {
			while(auxiliar.getDato() != dato) {
				if (dato < auxiliar.getDato()) {
					auxiliar = auxiliar.getHijoIzq();
				
				} else if(dato > auxiliar.getDato()) {
					auxiliar = auxiliar.getHijoDer();
				
				} 
			
				if (auxiliar == null) {
					return false;
				}	
			}
			return true;
		}
		
	}
	
	

	public void inOrdenR(Nodo nodo) {
		
		if (nodo != null) {
			inOrdenR(nodo.getHijoIzq());
			inOrden.add(nodo.getDato());
			inOrdenR(nodo.getHijoDer());
		}
	}
	
	public void preOrdenR(Nodo nodo) {
		if(nodo != null) {
			preOrden.add(nodo.getDato());
			preOrdenR(nodo.getHijoIzq());
			preOrdenR(nodo.getHijoDer());
		}
	}
	
	
	public void postOrdenR(Nodo nodo) {
		if(nodo != null) {
			postOrdenR(nodo.getHijoIzq());
			postOrdenR(nodo.getHijoDer());
			postOrden.add(nodo.getDato());
		}
	}
	
	
	
	public boolean eliminar(int dato) {
		Nodo aux = raiz;
		Nodo padre = raiz;
		boolean hijoIzq = true;
		
		while(aux.getDato() != dato) {
			padre = aux;
			if(dato < aux.getDato()) {
				aux = aux.getHijoIzq();
				hijoIzq = true;
			}else {
				hijoIzq = false;
				aux = aux.getHijoDer();
			}
			
			if(aux == null) {
				return false;
			}
		}
		reiniciarListas();
		setContador(getContador() - 1);
		
		if(aux.getHijoDer() == null && aux.getHijoIzq() == null) {
			if (aux == raiz) {
				raiz = null;
			} else if( hijoIzq) {
				padre.setHijoIzq(null);
			} else {
				padre.setHijoDer(null);
			}
			
			
			
		} else if(aux.getHijoDer() == null) {
			if (aux == raiz) {
				raiz = aux.getHijoIzq();
			} else if( hijoIzq) {
				padre.setHijoIzq(aux.getHijoIzq());
			} else {
				padre.setHijoDer(aux.getHijoIzq());
				
			}
			
		} else if(aux.getHijoIzq() == null) {
			if (aux == raiz) {
				raiz = aux.getHijoDer();
			} else if( hijoIzq) {
				padre.setHijoIzq(aux.getHijoDer());
			} else {
				padre.setHijoDer(aux.getHijoIzq());
				
			}
		} else {
			Nodo reemplazo = obtenerReemplazo(aux);
			
			if (aux == raiz) {
				raiz = reemplazo;
			} else if( hijoIzq) {
				padre.setHijoIzq(reemplazo);
			} else {
				padre.setHijoDer(reemplazo);
				
			}
			reemplazo.setHijoIzq(aux.getHijoIzq());
		}
		
		return true;
		
	}
	
	public Nodo obtenerReemplazo(Nodo nodo) {
		Nodo reemplazarPadre = nodo;
		Nodo reemplazo = nodo;
		Nodo aux = nodo.getHijoDer();
		while(aux != null) {
			reemplazarPadre = reemplazo;
			reemplazo  =aux;
			aux = aux.getHijoIzq();
		}
		
		if(reemplazo != nodo.getHijoDer()) {
			reemplazarPadre.setHijoIzq(reemplazo.getHijoDer());
			reemplazo.setHijoDer(nodo.getHijoDer());
		}
		
		return reemplazo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	

}
