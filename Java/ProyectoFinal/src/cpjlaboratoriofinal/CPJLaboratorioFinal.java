package cpjlaboratoriofinal;

import java.util.Scanner;

public class CPJLaboratorioFinal {

    public static void main(String[] args) {
        CPJLaboratorioFinal cpj = new CPJLaboratorioFinal();
        cpj.iniciar();


        Scanner scanner = new Scanner(System.in);
        int opcion;
        String nombreArchivo;
        String nombrePelicula;

        System.out.println("Elija una opcion: \n"
                + "1. Iniciar catalogo peliculas\n"
                + "2. Agregar pelicula\n"
                + "3. Listar peliculas\n"
                + "4. Buscar pelicula\n"
                + "0. Salir");

        opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                if (nombreArchivo == null) {
                    System.out.println("Ingrese el nombre del archivo a crear");
                    nombreArchivo = scanner.nextLine();
                    System.out.println("El archivo se ha creado exitosamente");
                } else {
                    System.out.println("El archivo ya existe");
                }

                break;
            case 2:
                System.out.println("Ingrese el nombre de una pelicula a agregar");
                nombrePelicula = scanner.nextLine();
                System.out.println("Se ha escrito correctamente en el archivo");

                break;
            case 3:
                System.out.println("Ingrese el nombre del archivo a crear");
                nombreArchivo = scanner.nextLine();
                break;
            case 4:
                System.out.println("Ingrese el nombre del archivo a crear");
                nombreArchivo = scanner.nextLine();
                break;
            case 0:
                System.out.println("Hasta pronto!");
                break;
            default:
                System.out.println("Opcion no reconocida");
                break;
        }
    }

    private void iniciar() {
    }
}