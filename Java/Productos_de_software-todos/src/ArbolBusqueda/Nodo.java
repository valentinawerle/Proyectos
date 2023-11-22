package ArbolBusqueda;

public class Nodo {
	
	private int dato;
	private Nodo hijoIzq;
	private Nodo hijoDer;
	
	
	public Nodo(int dato) {
		this.setDato(dato);
		setHijoIzq(null);
		setHijoDer(null);	
		
	}


	public Nodo getHijoIzq() {
		return hijoIzq;
	}


	public void setHijoIzq(Nodo hijoIzq) {
		this.hijoIzq = hijoIzq;
	}


	public Nodo getHijoDer() {
		return hijoDer;
	}


	public void setHijoDer(Nodo hijoDer) {
		this.hijoDer = hijoDer;
	}


	public int getDato() {
		return dato;
	}


	public void setDato(int dato) {
		this.dato = dato;
	}
	
	
	public String toString() {
		return "El dato del nodo  es " + dato ;
	}

}
