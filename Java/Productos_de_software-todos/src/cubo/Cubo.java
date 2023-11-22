package cubo;
import java.util.ArrayList;
import java.util.Random;

public class Cubo {
    private Random rand1;  // Generador de números aleatorios
    private int[][][] cubito;  // Arreglo tridimensional para representar el cubo
    private Random rand;  // Generador de números aleatorios
    private int columna;  // Número de columnas en el cubo
    private int fila;  // Número de filas en el cubo
    private int profundidad;  // Número de profundidades en el cubo
    private int valor;  // Valor de un elemento en el cubo
    
    private ArrayList<String> nulos;  // Lista de elementos nulos
    private int[] caras;  // Arreglo para almacenar las caras del cubo

	
    public Cubo(int columna, int fila, int profundidad) {
        // Inicializa la lista de elementos nulos y el arreglo de caras
        nulos = new ArrayList<String>();
        caras = new int[profundidad];

        // Asigna los valores de columnas, filas y profundidad
        this.columna = columna;
        this.fila = fila;
        this.profundidad = profundidad;

        // Inicializa el valor (no se utiliza aquí, es posible que sea un error)
        this.valor = valor;

        // Crea el arreglo tridimensional para representar el cubo e inicializa con números aleatorios
        cubito = new int[columna][fila][profundidad];
        Random rand = new Random();

        for (int x = 0; x < columna; x++) {
            for (int y = 0; y < fila; y++) {
                for (int z = 0; z < profundidad; z++) {
                    // Asigna valores aleatorios entre 1 y 20 a las posiciones del cubo
                    cubito[x][y][z] = rand.nextInt(20) + 1;
                }
            }
        }
    }

	
 // Método para asignar valores aleatorios al cubo
    public void alea() {
        for (int i = 0; i < columna; i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k < profundidad; k++) {
                    // Asigna valores aleatorios entre 1 y 10 a las posiciones del cubo
                    cubito[i][j][k] = rand.nextInt(10) + 1;
                }
            }
        }
    }

	
    public void anular(int x, int y, int z) {
        // Establece el valor en la posición (x, y, z) a 0
        cubito[x][y][z] = 0;
    }

    public boolean cargar(int a, int b, int c, int numero) {
        // Si la posición (a, b, c) está vacía (valor 0), carga el número y devuelve verdadero
        if (cubito[a][b][c] == 0) {
            cubito[a][b][c] = numero;
            return true;
        }
        return false;
    }

    public boolean modificar(int a, int b, int c, int numero) {
        // Si la posición (a, b, c) no está vacía (valor no es 0), modifica el número y devuelve verdadero
        if (cubito[a][b][c] != 0) {
            cubito[a][b][c] = numero;
            return true;
        }
        return false;
    }

    public ArrayList<String> nulos() {
        // Encuentra las posiciones con valor 0 y las almacena en la lista 'nulos'
        for (int i = 0; i < columna; i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k < profundidad; k++) {
                    if (cubito[i][j][k] == 0) {
                        nulos.add("(" + i + "," + j + "," + k + ")");
                    }
                }
            }
        }
        return nulos;
    }

    public int[] sumatoria() {
        // Calcula la suma de cada cara del cubo y almacena los resultados en el arreglo 'caras'
        int cara = 0;
        for (int i = 0; i < profundidad; i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k < columna; k++) {
                    caras[cara] += cubito[k][j][i];
                }
            }
            cara++;
        }
        return caras;
    }

    public int buscarValor(int a, int b, int c) {
        // Devuelve el valor en la posición (a, b, c) del cubo
        return cubito[a][b][c];
    }

    public void imprimir() {
        // Imprime la posición y el valor de cada elemento en el cubo
        for (int x = 0; x < columna; x++) {
            for (int y = 0; y < fila; y++) {
                for (int z = 0; z < profundidad; z++) {
                    System.out.println("Posicion: (" + x + "," + y + "," + z + "); Valor: " + cubito[x][y][z]);
                }
            }
        }
    }
}