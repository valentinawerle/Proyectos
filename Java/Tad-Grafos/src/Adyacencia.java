import java.util.ArrayList;

public class Adyacencia {
    private String [][] matriz;
    private int tamanio;
    public Adyacencia (int tamanio){

        matriz = new String [tamanio][tamanio];
        this.tamanio = tamanio;
    }

    public void cargar (String valor, int x, int y){

        if(!existe(x,y)){
            matriz[x][y] = valor;

        }
        else{

        }

    }

    public boolean existe(int x, int y){
        if(matriz[x][y] == null){
            return false;
        }
        return true;
    }
    public void imprimir() {
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                System.out.print("+----"); // Línea horizontal de separación
            }
            System.out.println("+");

            for (int j = 0; j < tamanio; j++) {
                System.out.printf("| %3s", matriz[i][j]); // Valor con separador vertical y ancho mínimo de 3 caracteres
            }
            System.out.println("|");
        }

        for (int j = 0; j < tamanio; j++) {
            System.out.print("+----"); // Línea horizontal de separación en la parte inferior
        }
        System.out.println("+");
    }

    public void BuscadorConexiones(int nodoFila){
        int fila = nodoFila - 1;

        if (fila != -1) {
            ArrayList<Integer> conecciones = new ArrayList<>();
            ArrayList<String> conectores = new ArrayList<>();

            for (int j = 0; j < tamanio; j++) {
                String elemento = matriz[fila][j];
                if (elemento != null && elemento.startsWith("e")) {
                    conecciones.add(j + 1);
                    conectores.add(elemento);
                }
            }

            // Imprimir los elementos encontrados
            if (!conecciones.isEmpty()) {
                System.out.println("Con quien esta conectado el nodo " + nodoFila + ":\n");
                for (int i = 0; i< conecciones.size(); i++ ) {
                    System.out.println("Con el nodo: " + conecciones.get(i) + " Mediante el conector: " + conectores.get(i) );
                }
            } else {
                System.out.println("No se encontraron conecciones con otros nodos " + nodoFila);
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

    public boolean existeMatriz() {
        if (matriz == null) {
            return false;
        } else {
            return true;
        }


    }


}
