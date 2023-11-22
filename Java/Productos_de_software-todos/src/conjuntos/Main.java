package conjuntos;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);  // Crea un objeto Scanner para leer entrada del teclado
		boolean ingreso = true;  // Variable booleana que indica si el usuario sigue ingresando opciones
		int opcionMenu = 0;  // Variable para almacenar la opción del menú seleccionada por el usuario
		OpeCon listaC = new OpeCon();  // Crea un objeto OpeCon para operaciones con conjuntos

		
		while(ingreso) {
			System.out.println("----------------Bienvenido---------------");
			System.out.println("1- Crear un conjunto");
			System.out.println("2- Añadir un elemento al conjunto");
			System.out.println("3- Eliminar elemento del conjunto");
			System.out.println("4- Ver la cantidad de elementos del conjunto");
			System.out.println("5- Ver si existe un elemento");
			System.out.println("6- Vaciar el conjunto");
			System.out.println("7- Ver si el conjunto esta vacio");
			System.out.println("8- Imprimir conjunto");
			System.out.println("9- Comparar un elemento en 2 conjuntos");
			System.out.println("10- Salir");
			opcionMenu = Integer.parseInt(teclado.nextLine());
			
			switch(opcionMenu) {
			
			case 1:
				System.out.println("Ingresa el nombre del conjunto: ");
				String nombre = teclado.nextLine();
				System.out.println("Ingresa el tamaño del conjunto: ");
				int tamaño = Integer.parseInt(teclado.nextLine());
				Conjunto conjuntito = new Conjunto(nombre, tamaño);
				listaC.agregarConjunto(conjuntito);
				break;
				
			case 2:
				System.out.println("Ingresa el nombre del conjunto: ");
				String nombre2 = teclado.nextLine();
				if(listaC.conjuntoExiste(nombre2)== true) {
					System.out.println("Ingresa el elemento que quieres añadir: ");
					int elemento2 = Integer.parseInt(teclado.nextLine());
					listaC.agregarElemento(nombre2, elemento2);
				} else {
					System.out.println("EL NOMBRE DEL CONJUNTO NO EXISTE");
				}
				break;
				
			case 3:
				System.out.println("Ingresa el nombre del conjunto: ");
				String nombre3 = teclado.nextLine();
				if(listaC.conjuntoExiste(nombre3)== true) {
					System.out.println("Ingresa el elemento que quieres eliminar: ");
					int elemento3 = Integer.parseInt(teclado.nextLine());
					listaC.eliminarElemento(nombre3, elemento3);
				} else {
					System.out.println("EL NOMBRE DEL CONJUNTO NO EXISTE");
				}
				break;
				
			case 4:
				System.out.println("Ingresa el nombre del conjunto: ");
				String nombre4 = teclado.nextLine();
				if(listaC.conjuntoExiste(nombre4)== true) {
					listaC.cantidadElementos(nombre4);
				} else {
					System.out.println("EL NOMBRE DEL CONJUNTO NO EXISTE");
				}
				break;
				
			case 5:
				System.out.println("Ingresa el elemento que quieres buscar: ");
				int elemento5 = Integer.parseInt(teclado.nextLine());
				listaC.elementoExiste(elemento5);
				break;
				
			case 6:
				System.out.println("Ingresa el nombre del conjunto: ");
				String nombre6 = teclado.nextLine();
				if(listaC.conjuntoExiste(nombre6)== true) {
					listaC.vaciarConjunto(nombre6);
				} else {
					System.out.println("EL NOMBRE DEL CONJUNTO NO EXISTE");
				}
				break;
				
			case 7:
				System.out.println("Ingresa el nombre del conjunto: ");
				String nombre7 = teclado.nextLine();
				if(listaC.conjuntoExiste(nombre7)== true) {
					listaC.vacio(nombre7);	
				} else {
					System.out.println("EL NOMBRE DEL CONJUNTO NO EXISTE");
				}
				break;
				
			case 8:
				System.out.println("Ingresa el nombre del conjunto: ");
				String nombre8 = teclado.nextLine();
				if(listaC.conjuntoExiste(nombre8)== true) {
					listaC.imprimirConjunto(nombre8);	
				} else {
					System.out.println("EL NOMBRE DEL CONJUNTO NO EXISTE");
				}
				break;
				
			case 9:
				System.out.println("Ingresa el nombre del conjunto: ");
				String nombreC1 = teclado.nextLine();
				if(listaC.conjuntoExiste(nombreC1)== true) {
					System.out.println("Ingresa el nombre del conjunto: ");
					String nombreC2 = teclado.nextLine();
					if(listaC.conjuntoExiste(nombreC2)== true) {
						System.out.println("Ingresa el elemento que quieres buscar: ");
						int elemento9 = Integer.parseInt(teclado.nextLine());
						listaC.elementoConjuntosExiste(nombreC1, nombreC2, elemento9);
					} else {
						System.out.println("EL NOMBRE DEL CONJUNTO NO EXISTE");
					}
					
				} else {
					System.out.println("EL NOMBRE DEL CONJUNTO NO EXISTE");
				}
				break;
				
			case 10:
				System.out.println("ADIOS.....");
				ingreso = false;
				break;
				
			}
			
		}
	}

}
