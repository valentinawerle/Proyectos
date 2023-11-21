
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner scanner = new Scanner(System.in);

        // Obtener valores a insertar
        System.out.print("Ingrese los valores separados por espacios para insertar en el árbol: ");
        String[] valores = scanner.nextLine().split(" ");

        // Insertar valores en el árbol
        for (String valor : valores) {
            try {
                int dato = Integer.parseInt(valor);
                arbol.insertar(dato);
            } catch (NumberFormatException e) {
                System.out.println("Valor no válido: " + valor);
            }
        }

        // Realizar recorridos
        System.out.println("Recorrido en inorden:");
        arbol.recorridoInorden();
        System.out.println();

        System.out.println("Recorrido en preorden:");
        arbol.recorridoPreorden();
        System.out.println();

        System.out.println("Recorrido en postorden:");
        arbol.recorridoPostorden();
        System.out.println();

        // Buscar un valor
        System.out.print("Ingrese un valor para buscar en el árbol: ");
        int datoBuscado = scanner.nextInt();
        NodoArbol resultadoBusqueda = arbol.buscar(datoBuscado);
        if (resultadoBusqueda != null)
            System.out.println("El nodo " + datoBuscado + " fue encontrado en el árbol.");
        else
            System.out.println("El nodo " + datoBuscado + " no fue encontrado en el árbol.");
    }
}