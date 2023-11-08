

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {




        Scanner scanner = new Scanner(System.in);
        Tabla t = null;

        int opcion;

        boolean creado = false;
        do {
            System.out.println("Ingrese una opcion: \n" +
                    "1. Crear tabla \n" +
                    "2. Insertar elemento \n" +
                    "3. Eliminar elemento \n" +
                    "4. Buscar elemento \n" +
                    "5. Imprimir tabla \n" +
                    "6. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    if (!creado) {
                        System.out.println("Ingrese el tamaño de la tabla (potencia de 10): ");
                        int sizeT1 = scanner.nextInt();
                        while(!esPotenciaDeDiez(sizeT1)){
                            System.out.println("El tamaño debe ser una potencia de 10");
                            sizeT1 = scanner.nextInt();
                        }
                        t = new Tabla(sizeT1);
                        creado = true;
                    } else {
                        System.out.println("Conjunto creado");
                    }
                    break;
                case 2:
                    if(creado){
                        System.out.println("Ingresar elemento: ");
                        System.out.println("Nombre: ");
                        String nombre = scanner.next();
                        System.out.println("Apellido: ");
                        String apellido = scanner.next();
                        System.out.println("Dni: ");
                        int dni = scanner.nextInt();
                        Elemento e = new Elemento(nombre, apellido, dni);
                        System.out.println(t.hash(e));
                        t.insertar(e, t.hash(e));
                    } else {
                        System.out.println("No se puede insertar un elemento en una tabla no creada ");
                    }

                    break;
                case 3:
                    if(creado){
                        System.out.println("Ingresar el dni del elemento a eliminar: ");
                        int dniAEliminar = scanner.nextInt();
                        if(t.eliminar(dniAEliminar)){
                            System.out.println("Elemento eliminado");
                        } else {
                            System.out.println("No se ha encontrado el elemento a eliminar");
                        }
                    } else {
                        System.out.println("No se puede eliminar un elemento en una tabla no creada");
                    }
                    break;
                case 4:
                    if(creado){
                        System.out.println("Ingresar el dni del elemento a buscar: ");
                        int dniABuscar = scanner.nextInt();
                        int posicionABuscar = t.buscar(dniABuscar);
                        if(posicionABuscar!= -1){
                            System.out.println("Posicion " + posicionABuscar);
                        } else {
                            System.out.println("No se ha encontrado el elemento a buscar");
                        }
                    } else {
                        System.out.println("No se puede buscar un elemento en una tabla no creada");
                    }

                    break;
                case 5:
                    if(creado) {
                        System.out.println(t);
                    } else{
                        System.out.println("No se puede imprimir, la tabla no existe");
                    }
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
                    break;
            }
        } while (opcion != 6);
    }

    public static boolean esPotenciaDeDiez(int numero) {

        double logBaseDiez = Math.log10(numero);
        return logBaseDiez == (int) logBaseDiez;
    }
}