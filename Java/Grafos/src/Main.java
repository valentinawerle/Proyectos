import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cantNodos;
        Adyacencia A1= null;
        int opcionMenu = 0;

        while(opcionMenu != 99){

            System.out.println("\nIngrese lo que desea hacer:\n" +
                    "1- Cargar matriz de Adyacencia\n" +
                    "2- imprimir matriz de Adyacencia\n" +
                    "3- Buscar conecciones por nodo\n" +
                    "4- Borrar la Matriz Cargada\n" +
                    "5- Eliminar/modificar una coneccion\n" +
                    "6- Eliminar Nodo\n" +
                    "7- Agregar Nodo\n" +
                    "8- salir");
            opcionMenu = scanner.nextInt();

            switch (opcionMenu) {
                case 1:

                    System.out.println("Ingrese la cantidad de Nodos que tiene la Matriz que intenta cargar");
                    cantNodos = scanner.nextInt();
                    

                    A1 = new Adyacencia(cantNodos);
                    System.out.println("Carguemos los valores de tu tabla de Adyacencia");
                    String valor;

                    for (int x = 1; x <= cantNodos; x++) {
                        for (int y = 1; y <= cantNodos; y++) {
                            if (!A1.existe(x - 1, y - 1)) {
                                System.out.println("Ingrese el Valor de  la posicion: [" + y + "]/[" + x + "]");
                                valor = scanner.next();
                                if(x != y){ //Si no es la diagonal principal
                                    A1.cargar(valor, x - 1, y - 1); //Carga el valor en la posicion [x]/[y]
                                    A1.cargar(valor, y - 1, x - 1); //Carga el valor en la posicion [y]/[x]
                                }else{ //Si es la diagonal principal
                                    A1.cargar(valor, x - 1, y - 1); //Carga el valor en la posicion [x]/[y]
                                }
                                A1.imprimir();
                                }
                            }
                        }

                    break;
                case 2:
                    if (A1.existeMatriz()) {
                        A1.imprimir();
                    } else {
                        System.out.println("La matriz no se ha inicializado.");
                    }
                    break;
                case 3:
                    if (A1.existeMatriz()) {
                        int nodoBusqueda;
                        System.out.println("Ingrese el nodo del cual desea buscar sus conexiones");
                        nodoBusqueda = scanner.nextInt();
                        A1.BuscadorConexiones(nodoBusqueda);
                    } else {
                        System.out.println("La matriz no se ha inicializado.");
                    }
                    break;
                case 4:
                    if (A1.existeMatriz()) {
                        A1.vaciar();
                        System.out.println("Matriz eliminada.");
                    } else {
                        System.out.println("La matriz no se ha inicializado.");
                    }
                    break;
                case 5:
                    if (A1.existeMatriz()) {
                        int x;
                        int y;
                        String modi = null;
                        System.out.println("Ingrese las coordenadas que desea modificar\nX:");
                        x = scanner.nextInt();
                        System.out.println("Y:");
                        y = scanner.nextInt();
                        System.out.println("Por qué desea modificarlo? (si desea eliminarlo ingrese null)");
                        modi = scanner.next();
                        A1.modificar(y - 1, x - 1, modi);
                    } else {
                        System.out.println("La matriz no se ha inicializado.");
                    }
                    break;
                case 6:
                    if (A1.existeMatriz()) {
                        int nodoAeliminar;
                        System.out.println("Ingrese el nodo que desea eliminar:");
                        nodoAeliminar = scanner.nextInt();
                        A1.eliminarNodo(nodoAeliminar - 1);
                    } else {
                        System.out.println("La matriz no se ha inicializado.");
                    }
                    break;

                case 7:
                    if (A1.existeMatriz()) {

                        A1.AgregarNodo();
                        cantNodos = A1.getTamanio();
                        for (int x = 1; x <= cantNodos; x++) {
                            if (!A1.existe(x - 1, cantNodos - 1)) {
                                System.out.println("Ingrese el Valor de  la posicion: [" + x + "]/[" + cantNodos + "]");
                                valor = scanner.next();
                                if(x != cantNodos){
                                    A1.cargar(valor, x - 1, cantNodos - 1);
                                    A1.cargar(valor, cantNodos - 1, x - 1);
                                }else{
                                    A1.cargar(valor, x - 1, cantNodos - 1);
                                }
                                A1.imprimir();
                            }
                        }



                    } else {
                        System.out.println("La matriz no se ha inicializado.");
                    }
                    break;

                case 8:
                    System.out.println("Saludos!");
                    break;
                default:
                    System.out.println("Ingrese un valor válido");
                    break;
            }


        }

    }
}
