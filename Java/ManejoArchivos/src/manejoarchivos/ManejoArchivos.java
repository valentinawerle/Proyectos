package manejoarchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
}
