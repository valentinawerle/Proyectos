package pilas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		boolean ingreso = true;
		int opcionMenuPrincipal = 0;
		int opcionMenuEstatica = 0;
		int opcionMenuDinamica = 0;
		int opcionMenuOperaciones = 0;
		
	
		PilaEstatica pilaEst = null ;
		PilaDinamica pilaDin = null;
		Operaciones listas = new Operaciones();
		while (ingreso) {
			System.out.println("----- MENU PRINCIPAL -----");
			System.out.println("1- Menu pila estatica.");
			System.out.println("2- Menu pila dinamica.");
			System.out.println("3- Otras operaciones.");
			System.out.println("4- Salir.");

			opcionMenuPrincipal = Integer.parseInt(teclado.nextLine());
			
			switch (opcionMenuPrincipal){
			
			case 1:
				boolean menuPilaEstatica = true;
				while(menuPilaEstatica) {
					System.out.println("----- MENU PILA ESTATICA -----");
					System.out.println("1- Crear pila.");
					System.out.println("2- Apilar elemento.");
					System.out.println("3- Desapilar tope.");
					System.out.println("4- Desapilar elemento.");
					System.out.println("5- Tope de la pila.");	
					System.out.println("6- Pila llena.");
					System.out.println("7- Pila vacia.");
					System.out.println("8- Salir.");
					
					opcionMenuEstatica = Integer.parseInt(teclado.nextLine());
					
					switch(opcionMenuEstatica) {
					case 1:
						System.out.println("Ingresa el nombre de la pila:");
						String nombre = teclado.nextLine();
						System.out.println("Ingresa el tamaÃ±o de la pila:");
						int tamaño = Integer.parseInt(teclado.nextLine());
							
						pilaEst = new PilaEstatica(nombre,tamaño);
						listas.agregarPilaEstatica(pilaEst);				
						break;
					
					case 2:
						System.out.println("Ingresa el nombre de la pila que quieres apilar:");
						String nombre2 = teclado.nextLine();
						
						if(listas.existeEstatica(nombre2) == true) {
							System.out.println("Ingresa el elemento que quieres apilar:");
							int elemento = Integer.parseInt(teclado.nextLine());
							listas.apilarEstatica(nombre2 , elemento);
						} else {
							System.out.println("El nombre de la pila no existe");
						}
						
						break;
					
					case 3:
						System.out.println("Ingresa el nombre de la pila que quieres desapilar:");
						String nombre3 = teclado.nextLine();
						if(listas.existeEstatica(nombre3) == true) {
							listas.desapilarTopeEstatica(nombre3);
						} else {
							System.out.println("El nombre de la pila no existe");
						}
	
						break;
						
						
					case 4:
						System.out.println("Ingresa el nombre de la pila que quieres desapilar:");
						String nombre4 = teclado.nextLine();
						if(listas.existeEstatica(nombre4) == true) {
							System.out.println("Ingresa el elemento que quieres desapilar:");
							int elemento4 = Integer.parseInt(teclado.nextLine());
							listas.desapilarEstatica(nombre4, elemento4);
						} else {
							System.out.println("El nombre de la pila no existe");
						}
	
						break;
						
						
					case 5:
						System.out.println("Ingresa el nombre de la pila de la que quieres saber el tope:");
						String nombre5 = teclado.nextLine();
						if(listas.existeEstatica(nombre5) == true) {
							listas.topePilaEstatica(nombre5);
						} else {
							System.out.println("El nombre de la pila no existe");
						}
						
						break;
						
					case 6:
						System.out.println("Ingresa el nombre de la pila de la que quieres saber el tope:");
						String nombre6 = teclado.nextLine();
						if(listas.existeEstatica(nombre6) == true) {
							listas.pilaLlena(nombre6);
						} else {
							System.out.println("El nombre de la pila no existe");
						}
						
						break;
						
					case 7:
						System.out.println("Ingresa el nombre de la pila:");
						String nombre7 = teclado.nextLine();
						if(listas.existeEstatica(nombre7) == true) {
							listas.pilaEstaticaVacia(nombre7);
						} else {
							System.out.println("El nombre de la pila no existe");
						}
						
						break;
					
					case 8:
						System.out.println("Volviendo al menu principal.......");
						menuPilaEstatica = false;
						break;
					}
				}
				break;
				
			case 2:
				boolean menuPilaDinamica = true;
				while(menuPilaDinamica) {
					System.out.println("----- MENU PILA DINAMICA -----");
					System.out.println("1- Crear pila.");
					System.out.println("2- Apilar elemento.");
					System.out.println("3- Desapilar tope.");
					System.out.println("4- Desapilar elemento.");
					System.out.println("5- Tope de la pila.");
					System.out.println("6- Pila vacia.");
					System.out.println("7- Salir.");
					
					opcionMenuDinamica = Integer.parseInt(teclado.nextLine());
					
					switch(opcionMenuDinamica) {
					
					case 1:
						System.out.println("Ingresa el nombre de la pila:");
						String nombre = teclado.nextLine();
						pilaDin = new PilaDinamica(nombre);
						listas.agregarPilaDinamica(pilaDin);
						break;
						
					case 2:
						System.out.println("Ingresa el nombre de la pila que quieres apilar:");
						String nombre2 = teclado.nextLine();
						
						if(listas.existeDinamica(nombre2) == true) {
							System.out.println("Ingresa el elemento que quieres apilar:");
							int elemento = Integer.parseInt(teclado.nextLine());
							listas.apilarDinamica(nombre2, elemento);
						} else {
							System.out.println("El nombre de la pila no existe");
						}	
						break;
						
					case 3:
						System.out.println("Ingresa el nombre de la pila que quieres desapilar:");
						String nombre3 = teclado.nextLine();
						if(listas.existeDinamica(nombre3) == true) {
							listas.desapilarTopeDinamica(nombre3);
						} else {
							System.out.println("El nombre de la pila no existe");
						}	
						break;
					
						
					case 4:
						System.out.println("Ingresa el nombre de la pila que quieres desapilar:");
						String nombre4 = teclado.nextLine();
						if(listas.existeDinamica(nombre4) == true) {
							System.out.println("Ingresa el elemento que quieres desapilar:");
							int elemento4 = Integer.parseInt(teclado.nextLine());
							listas.desapilarDinamica(nombre4, elemento4);
						} else {
							System.out.println("El nombre de la pila no existe");
						}	
						break;
						
					case 5:
						System.out.println("Ingresa el nombre de la pila de la que quieres saber el tope:");
						String nombre5 = teclado.nextLine();
						if(listas.existeDinamica(nombre5) == true) {
							listas.topePilaDinamica(nombre5);
						} else {
							System.out.println("El nombre de la pila no existe");
						}
						break;
						
					case 6:
						System.out.println("Ingresa el nombre de la pila de la que quieres saber el tope:");
						String nombre6 = teclado.nextLine();
						if(listas.existeDinamica(nombre6) == true) {
							listas.pilaDinamicaVacia(nombre6);
						} else {
							System.out.println("El nombre de la pila no existe");
						}	
						break;
						
					case 7:
						System.out.println("Volviendo al menu principal.......");
						menuPilaDinamica = false;
						break;
					}
				}
				break;
				
			case 3:
				boolean operaciones = true;
				while(operaciones) {
					System.out.println("----- OTRAS OPERACIONES -----");
					System.out.println("1- Buscar elemento.");
					System.out.println("2- Mostrar pilas.");
					System.out.println("3- Salir.");

					
					opcionMenuOperaciones = Integer.parseInt(teclado.nextLine());
					
					switch(opcionMenuOperaciones) {
					
					case 1:
						System.out.println("Ingresa el elemento que quieres buscar:");
						int elemento = Integer.parseInt(teclado.nextLine());
							
						listas.buscar(elemento);
						break;
						
					case 2:
						listas.imprimir();
						break;
					
					case 3:
						System.out.println("Volviendo al menu principal.......");
						operaciones = false;
						break;
					}

				}
				break;
				
			case 4:
				System.out.println("Adios........");
				ingreso = false;
				break;
			
			
			}
			
			
			
			
			
			
			
		}
		

	}

}
