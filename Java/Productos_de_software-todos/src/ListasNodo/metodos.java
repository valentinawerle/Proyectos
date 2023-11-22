package ListasNodo;

/**
*Clase Nodo:
Constructor de Nodo (con dato predeterminado):

El constructor public Nodo() se utiliza para crear un nodo con un 
valor predeterminado de 0.
Se inicializa el campo dato del nodo con el valor predeterminado.
El campo siguiente se establece en null ya que es un nuevo nodo 
sin referencia al siguiente nodo.
Constructor de Nodo (con dato específico):

El constructor public Nodo(int dato) se utiliza para crear un nodo con un 
valor específico.
Se inicializa el campo dato del nodo con el valor proporcionado como argumento.
El campo siguiente se establece en null ya que es un nuevo nodo sin referencia 
al siguiente nodo.
Clase ListaEnlazada:
Constructor de ListaEnlazada:

El constructor public ListaEnlazada() se utiliza para inicializar una nueva 
lista enlazada.
El campo inicio se establece en null porque inicialmente la lista está vacía.
Método estaVacia():

Este método verifica si la lista enlazada está vacía.
Comprueba si el campo inicio es null. Si es así, la lista está vacía y devuelve 
true, de lo contrario, devuelve false.
Método insertar(int dato):

Este método permite insertar un nuevo nodo con un valor específico al final de 
la lista enlazada.
Si la lista está vacía, crea un nuevo nodo y lo establece como el inicio.
Si la lista no está vacía, recorre la lista hasta encontrar el último nodo y 
agrega el nuevo nodo como el siguiente del último nodo.
Método mostrar():

Muestra todos los elementos de la lista enlazada en orden secuencial.
Recorre la lista desde el inicio hasta el último nodo, imprimiendo el valor de 
cada nodo y avanzando al siguiente nodo hasta llegar a null.
Método eliminar(int dato):

Este método permite eliminar un nodo con un valor específico de la lista.
Verifica si la lista está vacía o si el nodo a eliminar es el primero.
Si el nodo a eliminar no es el primero, recorre la lista hasta encontrar el nodo 
anterior al nodo a eliminar y ajusta los enlaces para omitir el nodo.
Método ordenar():

Ordena los elementos de la lista enlazada en orden ascendente utilizando el 
algoritmo de ordenación de burbuja.
Compara elementos adyacentes y los intercambia si están en el orden incorrecto. 
Repite esto hasta que la lista esté ordenada.

Método copiar():

Crea una nueva lista enlazada y copia todos los elementos de la lista actual a 
la nueva lista.
Recorre la lista actual y agrega cada elemento a la nueva lista.
Método unir(ListaEnlazada otraLista):

Permite unir la lista actual con otra lista proporcionada como argumento.
Encuentra el último nodo en la lista actual y conecta su campo siguiente al 
inicio de la otra lista.
Método dividir(int numSublistas):

Divide la lista en un número especificado de sublistas aproximadamente del mismo 
tamaño.
Crea un arreglo de sublistas, luego recorre la lista original y agrega cada 
elemento a una sublista diferente, distribuyéndolos de manera uniforme.
*/

