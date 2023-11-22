package ListasNodo;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada(0);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Localizar un elemento.");
            System.out.println("2. Insertar un elemento.");
          
            System.out.println("3. Eliminar un elemento.");
            System.out.println("4. Ordenar los elementos.");
            System.out.println("5. Girar la lista.");
            System.out.println("6. Unir varias listas.");
            System.out.println("7. Dividir en sublistas.");
            System.out.println("8. Mostrar la lista.");
            System.out.println("9. Salir.");
            
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
            case 1:
                // Opción 1: Localizar un elemento en la lista.
                System.out.print("Ingrese el elemento a buscar: ");
                int elementoBuscar = scanner.nextInt();
                lista.localizar(elementoBuscar); // Llama al método localizar.
                break;
            case 2:
                // Insertar un elemento en la lista en un índice especificado.
                System.out.print("Ingrese el elemento a insertar: ");
                int elementoInsertar = scanner.nextInt();
                System.out.print("Ingrese el indice donde desea insertar el elemento: ");
                int indiceInsertar = scanner.nextInt();
                lista.insertarEnIndice(elementoInsertar, indiceInsertar);
                System.out.println("Elemento insertado en el índice " + indiceInsertar + ".");
                break;


                case 3:
                	 //  Eliminar un elemento de la lista.
                    System.out.print("Ingrese el elemento a eliminar: ");
                    int elementoEliminar = scanner.nextInt();
                    lista.eliminar(elementoEliminar);
                    System.out.println("Elemento eliminado.");
                    break;
                case 4:
                	   //  Ordenar los elementos de la lista.
                    lista.ordenar();
                    System.out.println("Lista ordenada.");
                    break;
                case 5:
                	 //  Crear una copia de la lista.
                    ListaEnlazada copia = lista.copiar();
                    System.out.print("Copia de la lista: ");
                    copia.mostrar();
                    break;
                case 6:
                    // Unir la lista actual con otra lista.
                    ListaEnlazada lista2 = new ListaEnlazada(0);
                    System.out.print("Ingrese elementos para la segunda lista (separados por espacios): ");
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    String elementosLista2 = scanner.nextLine();
                    String[] elementosArray = elementosLista2.split(" ");
                    for (String elemento : elementosArray) {
                        lista2.insertarEnIndice(Integer.parseInt(elemento), 0);  // Insertar al inicio de la segunda lista
                    }
                    lista.unir(lista2);
                    System.out.println("Listas unidas.");
                    break;

                case 7: //Dividir la lista en sublistas.
                    System.out.print("Ingrese el número de sublistas: ");
                    int numSublistas = scanner.nextInt();
                    ListaEnlazada[] sublistas = lista.dividir(numSublistas);
                    for (int i = 0; i < numSublistas; i++) {
                        System.out.print("Sublista " + (i + 1) + ": ");
                        sublistas[i].mostrar();
                    }
                    break;
                case 8:  //  Mostrar la lista actual
                    lista.mostrar();
                    break;
     
                case 9:
                    System.out.println("¡Adios!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
               

            }
            
        }
    }
}