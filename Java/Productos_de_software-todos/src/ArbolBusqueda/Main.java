package ArbolBusqueda;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
			
			Scanner teclado = new Scanner(System.in);
			boolean ingreso = true;
			int opcionMenu = 0;
			Bosque bosque1 = new Bosque();
			
						
			while(ingreso) {
				System.out.println("----------------Bienvenido---------------");
				System.out.println("1- Crear arbol");
				System.out.println("2- Destruir arbol");
				System.out.println("3- Insertar ");
				System.out.println("4- Podar ");
				System.out.println("5- Vacio");
				System.out.println("6- Lista arboles");
				System.out.println("7- Recorrido in-orden");
				System.out.println("8- Recorrido post-orden");
				System.out.println("9- Recorrido pre-orden");
				System.out.println("10- Salir");
				opcionMenu = Integer.parseInt(teclado.nextLine());
				
				switch(opcionMenu) {
				
				case 1:
					System.out.println("Ingresa el nombre del arbol que quiere crear:");
					String nombre = teclado.nextLine();
					if(bosque1.existe(nombre) == false) {
						bosque1.insertarArbol(nombre);
						System.out.println("Arbol creado.");
					}else {
						System.out.println("El arbol ya existe");
					}
					break;
					
				case 2:
					System.out.println("Ingresa el nombre del arbol que quiere destruir:");
					String nombre2 = teclado.nextLine();
					if(bosque1.existe(nombre2) == true) {
						bosque1.eliminarArbol(nombre2);
						System.out.println("Arbol eliminado.");
					}else {
						System.out.println("El arbol no existe");
					}
					break;
					
				case 3:
					System.out.println("Ingresa el nombre del arbol:");
					String nombre3 = teclado.nextLine();
					if(bosque1.existe(nombre3) == true) {
						System.out.println("Ingresa el dato que quieres insertar:");
						int dato3 = Integer.parseInt(teclado.nextLine());
							if(bosque1.buscarDato(nombre3, dato3) == false) {
								bosque1.agregarDato(nombre3, dato3);
								System.out.println("Dato ingresado.");
							}else {
								System.out.println("El dato ingresado ya existe.");
							}
						
					}else {
						System.out.println("El arbol no existe");
					}
					break;
				
					
				case 4:
					System.out.println("Ingresa el nombre del arbol:");
					String nombre4 = teclado.nextLine();
					if(bosque1.existe(nombre4) == true) {
						System.out.println("Ingresa el dato que quieres podar:");
						int padre4 = Integer.parseInt(teclado.nextLine());
							if(bosque1.buscarDato(nombre4, padre4) == true) {
								bosque1.eliminarDato(nombre4, padre4);
								System.out.println("Dato eliminado.");
							}else {
								System.out.println("El dato no existe.");
							}
					}else {
						System.out.println("El arbol no existe");
					}
					break;
					
					
				case 5:
					System.out.println("Ingresa el nombre del arbol que quieres ver si esta vacio:");
					String nombre5 = teclado.nextLine();
					if(bosque1.existe(nombre5) == true) {
						if(bosque1.vacio(nombre5) == true) {
							System.out.println("El arbol esta vacio");
						}else {
							System.out.println("El arbol no esta vacio");
						}
					}else {
						System.out.println("El arbol no existe");
					}
					break;
					
				case 6:
					System.out.println(bosque1.imprimirArboles());
					break;
					
				
					
				case 7:
					System.out.println("Ingresa el nombre del arbol:");
					String nombre7 = teclado.nextLine();
					if(bosque1.existe(nombre7) == true) {
						System.out.println(bosque1.imprimirIn(nombre7));
						
					}else {
						System.out.println("El arbol no existe");
					}
					break;
					
				case 8:
					System.out.println("Ingresa el nombre del arbol:");
					String nombre8 = teclado.nextLine();
					if(bosque1.existe(nombre8) == true) {
						System.out.println(bosque1.imprimirPost(nombre8));
						
					}else {
						System.out.println("El arbol no existe");
					}
					break;
					
				case 9:
					System.out.println("Ingresa el nombre del arbol:");
					String nombre9 = teclado.nextLine();
					if(bosque1.existe(nombre9) == true) {
						System.out.println(bosque1.imprimirPre(nombre9));
						
					}else {
						System.out.println("El arbol no existe");
					}
					break;
	
					
				case 10:
					System.out.println("adios");
					ingreso = false;
					break;
				}
				
			}
			
			
		}

}
