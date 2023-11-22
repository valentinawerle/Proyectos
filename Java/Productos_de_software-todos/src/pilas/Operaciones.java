package pilas;

import java.util.HashMap;
import java.util.Map;

public class Operaciones {
	private Map <String , PilaEstatica> pilasEstaticas;
	private Map <String, PilaDinamica> pilasDinamicas;
	
	public Operaciones() {
		pilasDinamicas = new HashMap<>();
		pilasEstaticas = new HashMap<>();
	}
	
	
	public void agregarPilaEstatica(PilaEstatica pila) {
        String nombre = pila.getNombre();
        pilasEstaticas.put(nombre, pila);
        System.out.println("Pila estatica " + nombre + " creada");
    }
	
	public void agregarPilaDinamica(PilaDinamica pila) {
        String nombre = pila.getNombre();
        pilasDinamicas.put(nombre, pila);
        System.out.println("Pila dinamica " + nombre + " creada");
    }
	
	
	public void apilarEstatica(String nombre, int elemento) {
		PilaEstatica pila = pilasEstaticas.get(nombre);
		pila.apilarElemento(elemento);
	}
	
	public void apilarDinamica(String nombre, int elemento) {
		PilaDinamica pila = pilasDinamicas.get(nombre);
		pila.apilarElemento(elemento);
	}
	
	public void desapilarEstatica(String nombre, int elemento) {
		PilaEstatica pila = pilasEstaticas.get(nombre);
		pila.desapilarElemento(elemento);
	}
	
	public void desapilarDinamica(String nombre, int elemento) {
		PilaDinamica pila = pilasDinamicas.get(nombre);
		pila.desapilarElemento(elemento);
	}
	
	public void desapilarTopeDinamica(String nombre) {
		PilaDinamica pila = pilasDinamicas.get(nombre);
		pila.desapilarTope();
	}
	
	public void desapilarTopeEstatica(String nombre) {
		PilaEstatica pila = pilasEstaticas.get(nombre);
		pila.desapilarTope();
	}
	
	
	public void topePilaEstatica(String nombre) {
		PilaEstatica pila = pilasEstaticas.get(nombre);
		System.out.println(pila.topePila());
	}
	
	public void topePilaDinamica(String nombre) {
		PilaDinamica pila = pilasDinamicas.get(nombre);
		System.out.println(pila.topePila());
	}
	
	public void pilaEstaticaVacia(String nombre) {
		PilaEstatica pila = pilasEstaticas.get(nombre);
		if (pila.pilaVacia() == true) {
			System.out.println("La pila esta vacia.");
		} else {
			System.out.println("La pila no esta vacia.");
		}
	}
	
	public void pilaDinamicaVacia(String nombre) {
		PilaDinamica pila = pilasDinamicas.get(nombre);
		if (pila.pilaVacia() == true) {
			System.out.println("La pila esta vacia.");
		} else {
			System.out.println("La pila no esta vacia.");
		}
	}
	
	public void pilaLlena(String nombre) {
		PilaEstatica pila = pilasEstaticas.get(nombre);
		if (pila.pilaLlena() == true) {
			System.out.println("La pila esta llena.");
		} else {
			System.out.println("La pila no esta llena.");
		}
	}
	
	public void buscar(int elemento) {
		boolean estatica = false;
		boolean dinamica = false;
		for(PilaDinamica pilaDin : pilasDinamicas.values()) { 
            if(pilaDin.buscarElemento(elemento) == true) {
				estatica = true;
			}
        }
		for(PilaEstatica pilaEst : pilasEstaticas.values()) {
			if(pilaEst.buscarElemento(elemento) == true) {
				estatica = true;
			}
        }
		if(estatica == true && dinamica == true) {
			System.out.println("El elemento " + elemento + " esta en ambas pilas.");
		} else if(estatica == true && dinamica == false) {
			System.out.println("El elemento " + elemento + " esta en la pila estatica.");
		} else if(estatica == false && dinamica == true) {
			System.out.println("El elemento " + elemento + " esta en la pila dinamica");
		} else if(estatica == dinamica == false) {
			System.out.println("El elemento " + elemento + " no esta en ninguna pila.");

		}
	}
	
	public void imprimir() {
		System.out.println("---------PILA DINAMICA---------");
		for(PilaDinamica pilaDin : pilasDinamicas.values()) { 
			System.out.println("-----"+pilaDin.getNombre()+"-----");
			System.out.println(pilaDin.imprimir());
            
        }
		System.out.println("-------------------------------");
		System.out.println("---------PILA ESTATICA---------");
		for(PilaEstatica pilaEst : pilasEstaticas.values()) {
			System.out.println("-------------------------------");
			System.out.println("-----"+pilaEst.getNombre()+"-----");
			System.out.println(pilaEst.imprimir());
        }
	}
	
	public boolean existeDinamica(String nombre) {
		return pilasDinamicas.containsKey(nombre);
	}
	
	public boolean existeEstatica(String nombre) {
		return pilasEstaticas.containsKey(nombre);
	}
	
	
	
	


}

