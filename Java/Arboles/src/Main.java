import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionMenu = 0;

        while (opcionMenu != 6 ){

            System.out.println("MENU:" +
                    "\n1. Crear arbol" +
                    "\n2. Insertar nodo" +
                    "\n3. Eliminar nodo" +
                    "\n4. Buscar nodo" +
                    "\n5. Recorrer arbol" +
                    "\n6. Salir" +
                    "\n\nSeleccione una opcion:" );


            opcionMenu = scanner.nextInt();

            switch (opcionMenu){
                case 1:

                    System.out.println("Ingrese el nombre del arbol:");
                    String nombreArbol = scanner.next();

                    Arbol arbol = new Arbol(nombreArbol);
                    System.out.println("Arbol creado");


                    break;
                case 2:

                    System.out.println("Ingrese el nombre del arbol:");
                    String nombreArbol2 = scanner.next();

                    System.out.println("Ingrese el elemento del nodo:");
                    int elemento = scanner.nextInt();

                    System.out.println("Ingrese el elemento del nodo padre:");
                    int elementoPadre = scanner.nextInt();

                    System.out.println("Ingrese la posicion del nodo:");
                    String posicion = scanner.next();

                    System.out.println("Ingrese el nivel del nodo:");
                    int nivel = scanner.nextInt();



                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;


            }


        }




    }

}
