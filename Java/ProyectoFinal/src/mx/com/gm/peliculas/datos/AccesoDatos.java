package mx.com.gm.peliculas.datos;

public interface AccesoDatos {

    public abstract boolean existe(String nombreRecurso);

    public abstract void escribir(String nombreRecurso, String contenido, boolean anexar);

    public abstract String leer(String nombreRecurso);

    public abstract void crear(String nombreRecurso);

    public abstract void borrar(String nombreRecurso);


}
