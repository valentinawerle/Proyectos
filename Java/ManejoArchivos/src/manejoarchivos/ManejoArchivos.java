package manejoarchivos;

import java.io.*;

public class ManejoArchivos {

    public static void crearArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("El archivo se ha creado correctamente");

        } catch (FileNotFoundException ex) {
           ex.printStackTrace(System.out);
        }
    }

    public static void escribirArchivo(String nombreArchivo, String contenido){
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha escrito el archivo");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public static void agregarArchivo(String nombreArchivo, String contenido){
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true)); // FileWriter escribe en el archivo
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha agregado informacion al archivo");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);

        }
    }

    public static void leerArchivo(String nombreArchivo){
        var archivo = new File(nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(archivo)); // FileReader lee el archivo // BufferedReader lee linea por linea
            var lectura = entrada.readLine(); // readLine lee la primera linea
            while(lectura != null){ // mientras no sea null
                System.out.println("lectura = " + lectura); // imprime la linea
                lectura = entrada.readLine(); // readLine lee la siguiente linea
            }
            entrada.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
