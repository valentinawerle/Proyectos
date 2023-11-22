package ConjuntosTAD;

import java.util.Arrays;

public abstract class Conjunto {

    private int n; //tamaño
    private int contador; //contador de elementos
    private int[] conjunto; //array de elementos


    public Conjunto(int n) { //constructor
        this.n = n; //asigna el tamaño

        if (n > 0) { //verifica si el tamaño es valido
            conjunto = new int[n]; //inicializa el array con el tamaño puesto
            contador = 0; //inicializa el contador en 0
            System.out.println("Conjunto creado");
        } else {
            System.out.println("Conjunto no creado, tamaño invalido");
        }

    }

    public boolean ConjuntoVacio() { // metodo que verifica si el conjunto esta vacio
        if (contador == 0) {
            return true;
        } else {
            return false;
        }
    }


    public void AgregarElemento(int elemento) { //metodo que agrega un elemento al conjunto
        // Verificar si el elemento ya está en el conjunto
        boolean elementoExiste = false; //inicializa la variable en false
        for (int i = 0; i < contador; i++) { //recorre el array
            if (conjunto[i] == elemento) { //si el elemento esta en el array
                elementoExiste = true; //cambia la variable a true
                break;
            }
        }
        // Si el elemento no existe, agregarlo al conjunto
        if (!elementoExiste) { //si el elemento no esta en el array
            if (contador < n) { //si el contador es menor al tamaño del array
                conjunto[contador] = elemento; //agrega el elemento al array
                contador++; //aumenta el contador
                System.out.println("Elemento agregado");
            } else {
                System.out.println("No se puede agregar el elemento, conjunto lleno");
            }
        } else {
            System.out.println("No se puede agregar el elemento, ya existe en el conjunto");
        }
    }

    public void EliminarElemento(int elemento) {
        // Buscar el elemento en el conjunto
        int posicion = -1; //inicializa la variable en -1
        for (int i = 0; i < contador; i++) { //recorre el array
            if (conjunto[i] == elemento) { //si el elemento esta en el array
                posicion = i; //guarda la posicion del elemento
                break;
            }
        }
        if (posicion != -1) { //si el elemento esta en el array
            // Mover el último elemento al lugar del elemento a eliminar
            conjunto[posicion] = conjunto[contador - 1]; //cambia el elemento a eliminar por el ultimo elemento
            contador--; //disminuye el contador
            System.out.println("Elemento eliminado");
        } else {
            System.out.println("El elemento no existe en el conjunto");
        }
    }

    public void MostrarElementos() { //metodo que muestra los elementos del conjunto
        System.out.println(Arrays.toString(conjunto));
    }

    public void VaciarConjunto() { //metodo que vacia el conjunto
        contador = 0;
        System.out.println("Conjunto vaciado");
    }

    public boolean Busqueda(int elemento) { //metodo que busca un elemento en el conjunto
        boolean elementoExiste = false;
        for (int i = 0; i < contador; i++) { //recorre el array
            if (conjunto[i] == elemento) { //si el elemento esta en el array
                elementoExiste = true; //cambia la variable a true
                break;
            }
        }
        return elementoExiste;

    }



    public void ImprimirContador() { //metodo que imprime el contador
        System.out.println("\nLos elementos en el conjunto son:");
        for (int i = 0; i < contador; i++) {
           if (i == 0) {System.out.println(conjunto[i]);}
           else {System.out.println("\b" + conjunto[i]);}
        }
    }


  //getters y setters

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int[] getConjunto() {
        return conjunto;
    }

    public void setConjunto(int[] conjunto) {
        this.conjunto = conjunto;
    }


}