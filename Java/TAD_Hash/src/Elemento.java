
public class Elemento {
    // ATRIBUTOS
    private int dni;
    private String nombre, apellido;
    private Elemento siguiente; // ATRIBUTO SIGUIENTE PARA QUE SE COMPORTE COMO UN NODO

    // CONSTRUCTOR
    public Elemento(String nombre, String apellido, int dni){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    // GETTERS & SETTERS
    public int getDni() { return dni; }
    public Elemento getSiguiente() { return siguiente; }
    public void setSiguiente(Elemento siguiente) { this.siguiente = siguiente; }

    // TOSTRING
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