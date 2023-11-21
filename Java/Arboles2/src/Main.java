
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner scanner = new Scanner(System.in);
        boolean creado = false;

        while (true) {
            System.out.println();
            System.out.println("---------------------------");
            System.out.println("MENU DEL ARBOL ABB");
            System.out.println("---------------------------");
            System.out.println("[1] Crear arbol");
            System.out.println("[2] Agregar Hoja");
            System.out.println("[3] Buscar Elemento");
            System.out.println("[4] Mostrar Preorden");
            System.out.println("[5] Mostrar Inorden");
            System.out.println("[6] Mostrar Postorden");
            System.out.println("[7] Eliminar Nodo");
            System.out.println("[0] Salir");
            System.out.println();

            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "0":
                    System.exit(0);
                    break;

                case "1":
                    if (!creado) {
                        System.out.print("Ingrese el valor de la raiz principal: ");
                        int valorRaiz = scanner.nextInt();
                        arbol.insertar(valorRaiz);
                        creado = true;
                    } else {
                        System.out.println("¡El arbol ya ha sido creado!");
                    }
                    break;

                case "2":
                    if (!creado) {
                        System.out.println("¡Primero crea el arbol!");
                    } else {
                        System.out.print("Ingrese el valor de la hoja a agregar: ");
                        int valorHoja = scanner.nextInt();
                        arbol.insertar(valorHoja);
                    }
                    break;

                case "3":
                    if (!creado) {
                        System.out.println("¡Primero crea el arbol!");
                    } else {
                        System.out.print("Ingrese un valor para buscar en el arbol: ");
                        int valorBusqueda = scanner.nextInt();
                        NodoArbol resultadoBusqueda = arbol.buscar(valorBusqueda);
                        if (resultadoBusqueda != null)
                            System.out.println("El nodo " + valorBusqueda + " fue encontrado en el arbol.");
                        else
                            System.out.println("El nodo " + valorBusqueda + " no fue encontrado en el arbol.");
                    }
                    break;

                case "4":
                    if (!creado) {
                        System.out.println("¡Primero crea el arbol!");
                    } else {
                        System.out.println("Recorrido en preorden:");
                        arbol.preorden();
                    }
                    break;

                case "5":
                    if (!creado) {
                        System.out.println("¡Primero crea el arbol!");
                    } else {
                        System.out.println("Recorrido en inorden:");
                        arbol.inorden();
                    }
                    break;

                case "6":
                    if (!creado) {
                        System.out.println("¡Primero crea el arbol!");
                    } else {
                        System.out.println("Recorrido en postorden:");
                        arbol.postorden();
                    }
                    break;

                case "7":
                    if (!creado) {
                        System.out.println("¡Primero crea el arbol!");
                    } else {
                        System.out.print("Ingrese el valor del nodo a eliminar: ");
                        int valorEliminar = scanner.nextInt();
                        arbol.eliminarNodo(valorEliminar);
                        System.out.println("Nodo con valor " + valorEliminar + " eliminado.");
                    }
                    break;


                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }

            scanner.nextLine();  //enter Consume el salto de línea

        }
    }
}