package colas;  

import java.util.Scanner;  

public class Main { 

    public static void main(String[] args) {  

        Scanner teclado = new Scanner(System.in);  // Crea un objeto Scanner para entrada de teclado
        boolean ingreso = true;  // Variable booleana para controlar la ejecución del bucle
        int opcionMenu = 0;  // Variable para almacenar la opción del menú
        COLALKL cola1 = new COLALKL();  // Crea un objeto de la clase COLALKL

        while (ingreso) {  // Bucle que se ejecuta mientras 'ingreso' es true

            // Menú de opciones
            System.out.println("----------------Bienvenido---------------");
            System.out.println("1- Enfilar un elemento a la cola");
            System.out.println("2- Sacar elemento de la cola");
            System.out.println("3- Ver el largo de la cola");
            System.out.println("4- Ver el primer elemento de la cola");
            System.out.println("5- Ver el último elemento de la cola");
            System.out.println("6- Vaciar la cola");
            System.out.println("7- Ver si la cola está vacía");
            System.out.println("8- Salir");
            opcionMenu = Integer.parseInt(teclado.nextLine());  // Lee la opción del usuario

            switch (opcionMenu) {  // Evalúa la opción del usuario

                case 1:  // Opción 1: Enfilar un elemento a la cola
                    System.out.println("Ingresa el elemento que quieres enfilar: ");
                    String elemento = teclado.nextLine();
                    cola1.enfilar(elemento);
                    break;

                case 2:  // Opción 2: Sacar elemento de la cola
                    cola1.sacar();
                    break;

                case 3:  // Opción 3: Ver el largo de la cola
                    System.out.println("El largo de la cola es: " + cola1.largo());
                    break;

                case 4:  // Opción 4: Ver el primer elemento de la cola
                    System.out.println("El primer elemento de la cola es: " + cola1.verPrimero());
                    break;

                case 5:  // Opción 5: Ver el último elemento de la cola
                    System.out.println("El último elemento de la cola es: " + cola1.verUltimo());
                    break;

                case 6:  // Opción 6: Vaciar la cola
                    cola1.vaciar();
                    break;

                case 7:  // Opción 7: Ver si la cola está vacía
                    if (cola1.estaVacia()) {
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println("La cola no está vacía.");
                    }
                    break;

                case 8:  // Opción 8: Salir
                    System.out.println("Adiós");
                    ingreso = false;  // Establece 'ingreso' como false para salir del bucle
                    break;
            }
        }
    }
}
