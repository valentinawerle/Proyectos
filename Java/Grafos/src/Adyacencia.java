import java.util.ArrayList;

public class Adyacencia {

    //Atributos
    private String [][] matriz;
    private int tamanio;

    public int getTamanio() {
        return tamanio;
    }

    //Constructor
    public Adyacencia (int tamanio){

        matriz = new String [tamanio][tamanio];
        this.tamanio = tamanio;
    }


    public void cargar (String valor, int x, int y){  //x = fila, y = columna

        if(!existe(x,y)){
            matriz[x][y] = valor;
        }else{
            System.out.println("Ya existe un valor en esa posicion");

        }

    }

    public boolean existe(int x, int y){
        if(matriz[x][y] == null){
            return false;
        }else {
            return true;
        }
    }
    public void imprimir() {
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                System.out.print("+-------"); // Línea horizontal de separación
            }
            System.out.println("+");

            for (int j = 0; j < tamanio; j++) {
                System.out.printf("| %6s", matriz[i][j]); // Valor con separador vertical y ancho mínimo de 3 caracteres
            }
            System.out.println("|");
        }

        for (int j = 0; j < tamanio; j++) {
            System.out.print("+-------"); // Línea horizontal de separación en la parte inferior
        }
        System.out.println("+");
    }

    public void BuscadorConexiones(int nodoFila) {
        int fila = nodoFila - 1; // Se resta 1 porque los índices de la matriz empiezan en 0

        if (fila != -1) { // Verifica si el nodoFila existe en la matriz
            ArrayList<Integer> conecciones = new ArrayList<>(); // Crea una lista para almacenar las conexiones (números de columna)
            ArrayList<String> conectores = new ArrayList<>(); // Crea una lista para almacenar los conectores

            for (int j = 0; j < tamanio; j++) { // Itera sobre las columnas de la fila dada en la matriz
                String elemento = matriz[fila][j]; // Obtiene el elemento en la posición fila, columna
                if (elemento != null && !elemento.startsWith("0")) { // Verifica si el elemento no es nulo y comienza con "e"
                    conecciones.add(j + 1); // Agrega el número de columna (más 1, ya que los índices comienzan en 0)
                    conectores.add(elemento); // Agrega el elemento (conector) a la lista de conectores
                }
            }

            // Imprimir los elementos encontrados
            if (!conecciones.isEmpty()) { // Verifica si se encontraron conexiones
                System.out.println("Con quien está conectado el nodo " + nodoFila + ":\n");
                for (int i = 0; i < conecciones.size(); i++) { // Itera sobre la lista de conexiones
                    System.out.println("Con el nodo: " + conecciones.get(i) + " Mediante el conector: " + conectores.get(i));
                }
            } else {
                System.out.println("No se encontraron conexiones con otros nodos desde el nodo " + nodoFila);
            }
        } else {
            System.out.println("El nodo " + nodoFila + " no existe en la matriz.");
        }
    }

    public void vaciar() {
        matriz = null; // Asigna null a la matriz
    }

    public void modificar(int x, int y, String valor) {
        if (x >= 0 && x < tamanio && y >= 0 && y < tamanio) {
            matriz[x][y] = valor;
            matriz[y][x] = valor;
            imprimir();
        } else {
            System.out.println("Coordenadas fuera de rango. No se puede modificar la celda.");
        }
    }

    public void eliminarNodo(int indiceNodo) {
        if (indiceNodo >= 0 && indiceNodo < tamanio) {
            // Eliminar la fila del nodo
            for (int i = indiceNodo; i < tamanio - 1; i++) {
                for (int j = 0; j < tamanio; j++) {
                    matriz[i][j] = matriz[i + 1][j];
                }
            }

            // Eliminar la columna del nodo
            for (int i = 0; i < tamanio; i++) {
                for (int j = indiceNodo; j < tamanio - 1; j++) {
                    matriz[i][j] = matriz[i][j + 1];
                }
            }

            // Actualizar la lista de nodos
            tamanio--;
            System.out.println("Nodo eliminado con exito");
        } else {
            System.out.println("Índice de nodo fuera de rango. No se puede eliminar el nodo.");
        }
        imprimir();

    }

    public void AgregarNodo() {
        String [][] matrizAux = new String [tamanio + 1][tamanio + 1];
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                matrizAux[i][j] = matriz[i][j];
            }
        }
        matriz = matrizAux;
        tamanio++;
        System.out.println("Nodo agregado con exito");
        imprimir();
    }


    public boolean existeMatriz() {
        if (matriz == null) {
            return false;
        } else {
            return true;
        }


    }


}
