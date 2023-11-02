
/***
 CONSIGNA
 - Crear un TAD Tabla Hash. Las primitivas deben ser: Insertar, Eliminar, Buscar.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        new InterfazGrafica();

        // INICIALIZACION DE SCANNER
        Scanner scanner = new Scanner(System.in);
        Tabla t = null;
        // OPCION MENU PRIMER CONJUNTO
        int opcion;
        // VALIDADOR
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
                case 1: // CREAR CONJUNTO
                    if (!creado) {
                        System.out.println("INGRESAR EL SIZE DE LA TABLA (POTENCIA DE 10): ");
                        int sizeT1 = scanner.nextInt();
                        while(!esPotenciaDeDiez(sizeT1)){
                            System.out.println("DEBE SER UNA POTENCIA DE 10. VOLVER A INGRESAR: ");
                            sizeT1 = scanner.nextInt();
                        }
                        t = new Tabla(sizeT1);
                        creado = true;
                    } else {
                        System.out.println("CONJUNTO YA CREADO!");
                    }
                    break;
                case 2: // INGRESAR ELEMENTO A TABLA
                    if(creado){
                        System.out.println("INGRESAR ELEMENTO A AÑADIR: ");
                        System.out.println("NOMBRE: ");
                        String nombre = scanner.next();
                        System.out.println("APELLIDO: ");
                        String apellido = scanner.next();
                        System.out.println("DNI: ");
                        int dni = scanner.nextInt();
                        Elemento e = new Elemento(nombre, apellido, dni);
                        System.out.println(t.hash(e));
                        t.insertar(e, t.hash(e));
                    } else {
                        System.out.println("NO SE PUEDE INGRESAR ELEMENTO A UNA TABLA NO CREADA");
                    }

                    break;
                case 3: // ELIMINAR ELEMENTO DE LA TABLA
                    if(creado){
                        System.out.println("INGRESAR EL DNI DEL ELEMENTO A ELIMINAR: ");
                        int dniAEliminar = scanner.nextInt();
                        if(t.eliminar(dniAEliminar)){
                            System.out.println("ELEMENTO ELIMINADO");
                        } else {
                            System.out.println("NO EXISTE EL ELEMENTO A ELIMINAR");
                        }
                    } else {
                        System.out.println("NO SE PUEDE ELIMINAR UN ELEMENTO DE UNA TABLA NO CREADA");
                    }
                    break;
                case 4: // BUSCAR ELEMENTO
                    if(creado){
                        System.out.println("INGRESAR EL DNI DEL ELEMENTO A BUSCAR: ");
                        int dniABuscar = scanner.nextInt();
                        int posicionABuscar = t.buscar(dniABuscar);
                        if(posicionABuscar!= -1){
                            System.out.println("POSICION: " + posicionABuscar);
                        } else {
                            System.out.println("NO SE HA ENCONTRADO EL ELEMENTO");
                        }
                    } else {
                        System.out.println("NO SE PUEDE BUSCAR UN ELEMENTO EN UNA TABLA NO CREADA");
                    }

                    break;
                case 5: // IMPRIMIR TABLA
                    if(creado) {
                        System.out.println(t);
                    } else{
                        System.out.println("NO SE PUEDE IMPRIMIR UNA TABLA QUE NO ESTA CREADA");
                    }
                    break;
                case 6: // SALIR AL MENU PRINCIPAL
                    System.out.println("DE VUELTA AL MENU PRINCIPAL");
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
                    break;
            }
        } while (opcion != 6);
    }

    public static boolean esPotenciaDeDiez(int numero) {
        // SI LOG EN BASE DE 10 EN UN INT ENTONCES ES POTENCIA DE 10
        double logBaseDiez = Math.log10(numero);
        return logBaseDiez == (int) logBaseDiez;
    }
}