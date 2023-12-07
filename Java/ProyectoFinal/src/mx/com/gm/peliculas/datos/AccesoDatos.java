package mx.com.gm.peliculas.datos;

public interface AccesoDatos {

    public abstract boolean existe(String nombreArchivo);

    public abstract void escribir(String nombreArchivo, String contenido, boolean anexar);

    public abstract String leer(String nombreArchivo);

    public abstract void crear(String nombreArchivo);

    public abstract void borrar(String nombreArchivo);


}
