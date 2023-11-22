package Listas;


import java.util.Scanner;

//import pilas.Operaciones;
//import pilas.PilaDinamica;
//import pilas.PilaEstatica;

public class MainTot {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		boolean ingreso = true;
		int opcionMenuPrincipal = 0;
		int opcionMenuEstatica = 0;
		int opcionMenuDinamica = 0;
		int opcionMenuOperaciones = 0;
		
	
		ListaTot listaNueva = null ;
		//PilaDinamica pilaDin = null;
		Listas listas1 = new Listas();
		while (ingreso) {
			System.out.println("----- MENU PRINCIPAL -----");
			System.out.println("1- Crear lista.");
			System.out.println("2- Agregar elemento.");
			System.out.println("3- Eliminar elemento.");
			System.out.println("4- Localizar elemento.");
			System.out.println("5- Ordenar lista.");
			System.out.println("6- Imprimir lista.");
			System.out.println("7- Copiar lista.");
			System.out.println("8- Unir listas.");
			System.out.println("9- Dividir en sublistas.");
			System.out.println("10- Salir.");
			opcionMenuPrincipal = Integer.parseInt(teclado.nextLine());
			
			switch (opcionMenuPrincipal){
			
			case 1:
				System.out.println("Ingresa el nombre de la lista que quiere crear:");
				String nombre = teclado.nextLine();
				listaNueva = new ListaTot(nombre);
				listas1.insertarLista(listaNueva);
				break;
				
			case 2:
				System.out.println("Ingresa el nombre de la lista a la que quieres agregar un elemento:");
				String nombre2 = teclado.nextLine();
				
				if(listas1.existe(nombre2) == true) {
					System.out.println("Ingresa el elemento que quieres agregar:");
					int elemento = Integer.parseInt(teclado.nextLine());
					listas1.agregarElemento(nombre2, elemento);
				} else {
					System.out.println("El nombre de la lista no existe");
				}
				
				break;
				
			case 3:
				System.out.println("Ingresa el nombre de la lista a la que quieres sacar un elemento:");
				String nombre3 = teclado.nextLine();
				
				if(listas1.existe(nombre3) == true) {
					System.out.println("Ingresa el elemento que quieres sacar:");
					int elemento = Integer.parseInt(teclado.nextLine());
					listas1.sacarElemento(nombre3, elemento);
				} else {
					System.out.println("El nombre de la lista no existe");
				}
				break;
				
			case 4:
				System.out.println("Ingresa el elemento que quieres buscar:");
				int elemento = Integer.parseInt(teclado.nextLine());
				System.out.println(listas1.localizarElemento(elemento));
				break;
				
			case 5:
				System.out.println("Ingresa el nombre de la lista a la que quieres ordenar:");
				String nombre5 = teclado.nextLine();
				
				if(listas1.existe(nombre5) == true) {
					listas1.ordenarLista(nombre5);
					System.out.println("Â¡Lista ordenada!");
					listas1.imprimirLista(nombre5);
				} else {
					System.out.println("El nombre de la lista no existe");
				}
				break;
				
			case 6:
				System.out.println("Ingresa el nombre de la lista a la que quieres imprimir:");
				String nombre6 = teclado.nextLine();
				
				if(listas1.existe(nombre6) == true) {
					listas1.imprimirLista(nombre6);
				} else {
					System.out.println("El nombre de la lista no existe");
				}
				break;
		
			case 7:
				System.out.println("Ingresa el nombre de la lista a la que quieres hacer una copia:");
				String nombre7 = teclado.nextLine();
				
				if(listas1.existe(nombre7) == true) {
					System.out.println("Ingrese el nombre que quiere para la copia: ");
					String nombreCopia = teclado.nextLine();
					listas1.hacerCopia(nombre7 , nombreCopia);
				} else {
					System.out.println("El nombre de la lista no existe");
				}
				break;
				
			case 8:
				System.out.println("Ingresa el nombre de la primer lista:");
				String nombreLista1 = teclado.nextLine();
				
				
				
				if(listas1.existe(nombreLista1) == true ) {
					System.out.println("Ingresa el nombre de la primer lista:");
					String nombreLista2 = teclado.nextLine();
					
					if(listas1.existe(nombreLista2) == true) {
						System.out.println("Ingresa el nombre para la nueva lista:");
						String union = teclado.nextLine();
						listas1.unirListas(nombreLista1, nombreLista2, union);
						listas1.imprimirLista(union);
					}else {
						System.out.println("El nombre de la segunda lista no existe");
					}	
				} else {
					System.out.println("El nombre de la primer lista no existe");
				}
				
				break;
			
			case 9:
				System.out.println("Ingresa el nombre de la lista que quiere dividir:");
				String nombre9 = teclado.nextLine();
				
				if(listas1.existe(nombre9) == true) {
					System.out.println("Ingresa el nombre de la primera sublista:");
					String nombreSub1 = teclado.nextLine();
					System.out.println("Ingresa el nombre de la segunda sublista:");
					String nombreSub2 = teclado.nextLine();
					listas1.dividirLista(nombre9, nombreSub1, nombreSub2);
					listas1.imprimirLista(nombreSub1);
					listas1.imprimirLista(nombreSub2);
				} else {
					System.out.println("El nombre de la lista no existe");
				}
				
				break;
				
			case 10:
				System.out.println("Adios........");
				ingreso = false;
				break;
			
			}
			
			
			
			
			
			
			
		}
		


	}

}
