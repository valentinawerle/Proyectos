package ConjuntosTAD;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conjunto c1 = null;
        Conjunto c2 = null;
        int opcionMenu;

        do {
            System.out.println("Seleccione una opción: ");
            System.out.println("1) Metodos Conjunto 1");
            System.out.println("2) Metodos Conjunto 2");
            System.out.println("3) Metodos compartidos");
            System.out.println("4) Salir");

            opcionMenu = scanner.nextInt();

            switch (opcionMenu) {
                case 1:
                    int opcionC1;
                    do {
                        System.out.println("Seleccione una opción: ");
                        System.out.println("1) Crear conjunto");
                        System.out.println("2) Agregar elemento");
                        System.out.println("3) Eliminar elemento");
                        System.out.println("4) Chequear si esta el elemento ");
                        System.out.println("5) Verificar si esta vacio");
                        System.out.println("6) Vaciar conjunto");
                        System.out.println("7) Imprimir conjunto");
                        System.out.println("8) Salir");

                        opcionC1 = scanner.nextInt();

                        switch (opcionC1) {
                            case 1:
                                System.out.println("Ingrese el tamaño del conjunto");
                                int tamanio = scanner.nextInt();
                                c1 = new ClaseHija(tamanio);
                                break;
                            case 2:
                                System.out.println("Ingrese el elemento a agregar");
                                int elemento = scanner.nextInt();
                                c1.AgregarElemento(elemento);
                                break;
                            case 3:
                                System.out.println("Ingrese el elemento a eliminar");
                                int elementoEliminar = scanner.nextInt();
                                c1.EliminarElemento(elementoEliminar);
                                break;
                            case 4:
                                boolean elementoEncontrado = false;
                                System.out.println("Ingrese el elemento a buscar");
                                int elementoBuscar = scanner.nextInt();
                                elementoEncontrado = c1.Busqueda(elementoBuscar);
                                if (elementoEncontrado == true) {
                                    System.out.println("El elemento " + elementoBuscar + " existe en el conjunto");
                                } else {
                                    System.out.println("El elemento " + elementoBuscar + " no existe en el conjunto");
                                }
                                break;
                            case 5:
                                boolean conjuntoVacio = c1.ConjuntoVacio();
                                if (conjuntoVacio == true) {
                                    System.out.println("El conjunto esta vacio");
                                } else {
                                    System.out.println("El conjunto no esta vacio");
                                }
                                break;
                            case 6:
                                c1.VaciarConjunto();
                                break;
                            case 7:
                                c1.ImprimirContador();
                                break;
                            case 8:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción inválida");
                                break;
                        }



                    } while (opcionC1 != 8);
                    break;

                case 2:
                    int opcionC2;
                    do {
                        System.out.println("Seleccione una opción: ");
                        System.out.println("1) Crear conjunto");
                        System.out.println("2) Agregar elemento");
                        System.out.println("3) Eliminar elemento");
                        System.out.println("4) Chequear si esta el elemento ");
                        System.out.println("5) Verificar si esta vacio");
                        System.out.println("6) Vaciar conjunto");
                        System.out.println("7) Imprimir conjunto");
                        System.out.println("8) Salir");

                        opcionC2 = scanner.nextInt();

                        switch (opcionC2) {
                            case 1:
                                System.out.println("Ingrese el tamaño del conjunto");
                                int tamanio = scanner.nextInt();
                                c2 = new ClaseHija(tamanio);
                                break;
                            case 2:
                                System.out.println("Ingrese el elemento a agregar");
                                int elemento = scanner.nextInt();
                                c2.AgregarElemento(elemento);
                                break;
                            case 3:
                                System.out.println("Ingrese el elemento a eliminar");
                                int elementoEliminar = scanner.nextInt();
                                c2.EliminarElemento(elementoEliminar);
                                break;
                            case 4:
                                boolean elementoEncontrado = false;
                                System.out.println("Ingrese el elemento a buscar");
                                int elementoBuscar = scanner.nextInt();
                                elementoEncontrado = c2.Busqueda(elementoBuscar);
                                if (elementoEncontrado == true) {
                                    System.out.println("El elemento " + elementoBuscar + " existe en el conjunto");
                                } else {
                                    System.out.println("El elemento " + elementoBuscar + " no existe en el conjunto");
                                }
                                break;
                            case 5:
                                boolean conjuntoVacio = c2.ConjuntoVacio();
                                if (conjuntoVacio == true) {
                                    System.out.println("El conjunto esta vacio");
                                } else {
                                    System.out.println("El conjunto no esta vacio");
                                }
                                break;
                            case 6:
                                c2.VaciarConjunto();
                                break;
                            case 7:
                                c2.ImprimirContador();
                                break;
                            case 8:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción inválida");
                                break;
                        }


                    } while (opcionC2 != 8);
                    break;


                case 3:
                    int opcionC3;

                    do {
                        System.out.println("Seleccione una opción: ");
                        System.out.println("1) buscar un elemento en ambos conjuntos");
                        System.out.println("2) Union");
                        System.out.println("3) Interseccion");
                        System.out.println("4) Salir");

                        opcionC3 = scanner.nextInt();
                        switch (opcionC3) {
                            case 1:
                                int opcionBuscar;
                                do {
                                    int numBuscar;
                                    System.out.println("Escriba el número que desea buscar en ambos conjuntos");
                                    numBuscar = scanner.nextInt();

                                    String estaEnAmbosConjuntos = Interseccion(c1, c2, numBuscar);
                                    System.out.println(Interseccion(c1, c2, numBuscar));

                                    System.out.println("Desea buscar un nuevo número? \n 1) si \n 2) no \n");
                                    opcionBuscar = scanner.nextInt();
                                } while (opcionBuscar != 2);
                            break;

                            case 2:
                                if (c1 != null && c2 != null) {
                                    Conjunto conjuntoUnion = UnionConjuntos(c1, c2);
                                    System.out.println("Unión de los conjuntos:");
                                    conjuntoUnion.MostrarElementos();
                                } else {
                                    System.out.println("Debe crear ambos conjuntos antes de realizar la unión.");
                                }
                                break;

                            case 3:
                                if (c1 != null && c2 != null) {
                                    Conjunto conjuntoInterseccion = InterseccionConjuntos(c1, c2);
                                    System.out.println("Intersección de los conjuntos:");
                                    conjuntoInterseccion.MostrarElementos();
                                } else {
                                    System.out.println("Debe crear ambos conjuntos antes de realizar la intersección.");
                                }
                                break;
                        }



                    } while (opcionC3 != 4);
                    break;


                    case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcionMenu != 4);
    }

    // Método para verificar la intersección de dos conjuntos
    public static String Interseccion(Conjunto c1, Conjunto c2, int numero) {
        boolean existeEnC1 = c1 != null && c1.Busqueda(numero);
        boolean existeEnC2 = c2 != null && c2.Busqueda(numero);

         if(existeEnC1 == true && existeEnC2 == true){
             return "existe en ambos conjuntos";
         } else if (existeEnC1 && existeEnC2 == false) {
             return "existe en el conjunto 1";
         } else if (existeEnC1 == false && existeEnC2) {
             return "existe en el conjunto 2";
         } else {
             return "no existe en ninguno de los conjuntos";
         }
    }

    public static Conjunto InterseccionConjuntos(Conjunto c1, Conjunto c2) {
        Conjunto conjuntoInterseccion = new ClaseHija(Math.min(c1.getN(), c2.getN()));

        for (int i = 0; i < c1.getContador(); i++) {
            int elemento = c1.getConjunto()[i];
            if (c2.Busqueda(elemento)) {
                conjuntoInterseccion.AgregarElemento(elemento);
            }
        }

        return conjuntoInterseccion;
    }
    public static Conjunto UnionConjuntos(Conjunto c1, Conjunto c2) {
        int tamanoUnion = c1.getN() + c2.getN();
        Conjunto conjuntoUnion = new ClaseHija(tamanoUnion);

        for (int i = 0; i < c1.getContador(); i++) {
            conjuntoUnion.AgregarElemento(c1.getConjunto()[i]);
        }

        for (int i = 0; i < c2.getContador(); i++) {
            conjuntoUnion.AgregarElemento(c2.getConjunto()[i]);
        }

        return conjuntoUnion;
    }



}


