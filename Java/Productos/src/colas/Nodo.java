package colas;

public class Nodo {
	private String elemento;  // Variable que almacena el elemento del nodo
    private Nodo apuntador;  // Variable que apunta al siguiente nodo

    public Nodo(String elemento) {  // Constructor de la clase Nodo que recibe un elemento
        this.setElemento(elemento);  // Establece el elemento del nodo
        setApuntador(null);  // Establece el apuntador como null (sin apuntar a otro nodo)
    }

    public Nodo getApuntador() {  // Método para obtener el apuntador del nodo
        return apuntador;
    }

    public void setApuntador(Nodo apuntador) {  // Método para establecer el apuntador del nodo
        this.apuntador = apuntador;
    }

    public String getElemento() {  // Método para obtener el elemento del nodo
        return elemento;
    }

    public void setElemento(String elemento) {  // Método para establecer el elemento del nodo
        this.elemento = elemento;
    }

}




