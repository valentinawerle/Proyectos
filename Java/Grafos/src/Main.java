import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cantNodos = -1;
        Adyacencia A1= null;
        String opcionMenu = "0";


        while(opcionMenu != "8"){

            System.out.println("\nIngrese lo que desea hacer:\n" +
                    "1- Cargar matriz de Adyacencia\n" +
                    "2- imprimir matriz de Adyacencia\n" +
                    "3- Buscar conecciones por nodo\n" +
                    "4- Borrar la Matriz Cargada\n" +
                    "5- Eliminar/modificar una coneccion\n" +
                    "6- Eliminar Nodo\n" +
                    "7- Agregar Nodo\n" +
                    "8- salir");
            opcionMenu = scanner.next();

            switch (opcionMenu) {
                case "1":
                    boolean inputCantNodo = false; // Variable para verificar si la cantidad de nodos es válida
                    boolean inputValor;
                    while(!inputCantNodo) {
                        System.out.println("Ingrese la cantidad de Nodos que tiene la Matriz que intenta cargar");
                        try { // Se intenta convertir el valor ingresado a un número entero
                            cantNodos = scanner.nextInt(); // Se ingresa el valor
                            if (cantNodos > 0) { // Si el valor es mayor que 0
                                inputCantNodo = true; // Se acepta la entrada si es un número entero mayor que 0
                            } else { // Si el valor es menor o igual que 0
                                System.out.println("Error: El número debe ser mayor que 0.");
                            } // Se acepta la entrada si no hay excepción
                        } catch (Exception e) { // Si el valor no es un número entero
                            System.out.println("Error: Debe ingresar un número entero.");
                            scanner.next(); // Limpiar el buffer del Scanner
                        }

                    }
                    A1 = new Adyacencia(cantNodos);
                    System.out.println("Carguemos los valores de tu tabla de Adyacencia");
                    String valor;

                    for (int x = 1; x <= cantNodos; x++) {
                        for (int y = 1; y <= cantNodos; y++) {
                            if (!A1.existe(x - 1, y - 1)) {
                                System.out.println("Ingrese el Valor de  la posicion: [" + y + "]/[" + x + "]");
                                inputValor = false;
                                    while(!inputValor) { //Mientras no se haya ingresado un valor válido
                                        valor = scanner.next(); //Se ingresa el valor
                                        if (valor.length() <= 6) { //Si el valor tiene un máximo de 6 caracteres
                                            inputValor = true;  //Se acepta el valor
                                            if (x != y) { //Si no es la diagonal principal
                                                A1.cargar(valor, x - 1, y - 1); //Carga el valor en la posicion [x]/[y]
                                                A1.cargar(valor, y - 1, x - 1); //Carga el valor en la posicion [y]/[x]
                                            } else { //Si es la diagonal principal
                                                A1.cargar(valor, x - 1, y - 1); //Carga el valor en la posicion [x]/[y]
                                            }
                                        } else {
                                            System.out.println("Error: El valor debe tener un máximo de 6 caracteres.");
                                        }
                                    }
                                A1.imprimir();
                                }
                            }
                        }

                    break;
                case "2":
                    if (A1.existeMatriz()) {
                        A1.imprimir();
                    } else {
                        System.out.println("La matriz no se ha inicializado.");
                    }
                    break;
                case "3":
                    if (A1.existeMatriz()) {
                        int nodoBusqueda = -1;
                        boolean inputNodoBusqueda = false; // Variable para verificar si el nodoBusqueda es válido
                        while(!inputNodoBusqueda) { // Mientras no se haya ingresado un valor válido
                            System.out.println("Ingrese el nodo del cual desea buscar sus conexiones");
                            try { // Se intenta convertir el valor ingresado a un número entero
                                nodoBusqueda = scanner.nextInt(); // Se ingresa el valor
                                if (nodoBusqueda > 0 && nodoBusqueda <= cantNodos) { // Si el valor está entre 1 y la cantidad de nodos
                                    inputNodoBusqueda = true; // Se acepta la entrada si es un número entero mayor que 0
                                } else {
                                    System.out.println("Error: El número debe estar en los parametros establecidoa anteriormente.");
                                } // Se acepta la entrada si no hay excepción
                            } catch (Exception e) {
                                System.out.println("Error: Debe ingresar un número entero.");
                                scanner.next(); // Limpiar el buffer del Scanner
                            }
                        }
                        A1.BuscadorConexiones(nodoBusqueda);
                    } else {
                        System.out.println("La matriz no se ha inicializado.");
                    }
                    break;
                case "4":
                    if (A1.existeMatriz()) {
                        A1.vaciar();
                        System.out.println("Matriz eliminada.");
                    } else {
                        System.out.println("La matriz no se ha inicializado.");
                    }
                    break;
                case "5":
                    if (A1.existeMatriz()) { //Si la matriz existe
                        int x;
                        int y;
                        // ingreso de coordenadas para la modificacion
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
                case "6":
                    if (A1.existeMatriz()) {
                        int nodoAeliminar;
                        System.out.println("Ingrese el nodo que desea eliminar:");
                        nodoAeliminar = scanner.nextInt(); //Se ingresa el nodo a eliminar
                        A1.eliminarNodo(nodoAeliminar - 1); // Se resta 1 porque los índices de la matriz empiezan en 0
                    } else {
                        System.out.println("La matriz no se ha inicializado.");
                    }
                    break;

                case "7":
                    if (A1.existeMatriz()) {

                        A1.AgregarNodo(); //Se agrega un nodo a la matriz
                        cantNodos = A1.getTamanio(); //Se obtiene el tamaño de la matriz
                        for (int x = 1; x <= cantNodos; x++) {  //Se itera sobre las filas de la matriz
                            if (!A1.existe(x - 1, cantNodos - 1)) { //Si no existe el nodo en la fila
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

                case "8":
                    System.out.println("Saludos!");
                    break;

                default:
                    System.out.println("Ingrese un valor válido");
                    break;
            }


        }

    }
}
