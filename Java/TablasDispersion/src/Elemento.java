
public class Elemento {

    // Atributos
    private int dni;
    private String nombre, apellido;
    private Elemento siguiente;

    // Constructor
    public Elemento(String nombre, String apellido, int dni){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    // Getters y Setters
    public int getDni() { return dni; }
    public Elemento getSiguiente() { return siguiente; }
    public void setSiguiente(Elemento siguiente) { this.siguiente = siguiente; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(nombre).append(" ").append(apellido).append(", DNI: ").append(dni).append(")");
        if (siguiente != null) {
            sb.append(" -> ").append(siguiente);
        }
        return sb.toString();
    }
}