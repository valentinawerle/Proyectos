package cubo;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		boolean creado = false;
		String cargar = "si";
		String modificar = "si";
		String anular = "si";
		String buscarValor = "si";
	
		int columnas = 0;
		int filas = 0;
		int profundidad = 0;
		System.out.println("Bienvenido, ingrese los valores para crear un cubo");

		while (creado == false) {
			System.out.println("Ingrese el numero de columnas del cubo:");
			columnas = Integer.parseInt(teclado.nextLine());
			System.out.println("Ingrese el numero de filas del cubo:");
			filas = Integer.parseInt(teclado.nextLine());
			System.out.println("Ingrese el numero de profundidad del cubo:");
			profundidad = Integer.parseInt(teclado.nextLine());
			
			if (columnas > 0 && filas > 0 && profundidad > 0 ) {
				creado = true;
				
				
			}else {
				System.out.println("el numero de columnas, filas y profundidad debe ser mayor a cero");
				System.out.println("Ingrese los valores nuevamente");

			}

		}
		Cubo cubo1 = new Cubo(columnas, filas, profundidad);
		System.out.println("¡CUBO CREADO!");
		System.out.println("");

		
		
		boolean ingreso = true;
		int opcionMenu = 0;
		while(ingreso == true) {
			System.out.println("----------------MENU---------------");
			System.out.println("1- Cargar elemento");
			System.out.println("2- Modificar elemento");
			System.out.println("3- Anular elemento");
			System.out.println("4- Recargar cubo");
			System.out.println("5- Nulos");
			System.out.println("6- Buscar valor");
			System.out.println("7- Sumatoria de las caras");
			System.out.println("8- Ver elementos");
			System.out.println("9- Salir");

			System.out.println("INGRESE UNA OPCION:");
			opcionMenu = Integer.parseInt(teclado.nextLine());
			
			switch(opcionMenu) {
			
			case 1:
				
				while(cargar == "si") {
					int numeroCargar = 0;
					int x = 0;
					int y = 0;
					int z = 0;
					boolean coordenadas = false;
					boolean numero = false;
					while (numero == false) {
						System.out.println("Ingrese el numero que quiere cargar");
						numeroCargar = Integer.parseInt(teclado.nextLine());
						if (numeroCargar != 0 ) {
							numero = true;
						}else {
							System.out.println("el numero que quiere cargar debe ser mayor a cero ");
							System.out.println("Ingrese los valores nuevamente");
						}
					}
					
					while (coordenadas == false) {
						System.out.println("Ingrese el numero de columnas del cubo:");
						x = Integer.parseInt(teclado.nextLine());
						System.out.println("Ingrese el numero de filas del cubo:");
						y = Integer.parseInt(teclado.nextLine());
						System.out.println("Ingrese el numero de profundidad del cubo:");
						z = Integer.parseInt(teclado.nextLine());
						if (x < columnas && y <filas && z < profundidad ) {
							coordenadas = true;	
						}else {
							System.out.println("las coordenadas no existen");
							System.out.println("Ingrese los valores nuevamente");
						}
					}
					
					if (cubo1.cargar(x, y, z, numeroCargar)== true) {
						cubo1.cargar(x, y, z, numeroCargar);
					} else {
						System.out.println("La posicion en la que desea cargar el numero ya esta ocupada");
					}
					
					System.out.println("Desea seguir cargando numeros? si/no");
					cargar = teclado.nextLine();
				}
				break;
			
			case 2:
				while(modificar == "si") {
					boolean numero = false;
					int numeroModificar = 0;
					int x = 0;
					int y = 0;
					int z = 0;
					boolean coordenadas = false;
					
					while (numero == false) {
						System.out.println("Ingrese el numero que quiere cargar");
						numeroModificar  = Integer.parseInt(teclado.nextLine());
						if (numeroModificar  != 0 ) {
							numero = true;
						}else {
							System.out.println("el numero que quiere modificar debe ser mayor a cero ");
							System.out.println("Ingrese el valor nuevamente");
						}
					}
					
					while (coordenadas == false) {
						System.out.println("Ingrese el numero de columnas del cubo:");
						x = Integer.parseInt(teclado.nextLine());
						System.out.println("Ingrese el numero de filas del cubo:");
						y = Integer.parseInt(teclado.nextLine());
						System.out.println("Ingrese el numero de profundidad del cubo:");
						z = Integer.parseInt(teclado.nextLine());
						if (x < columnas && y <filas && z < profundidad ) {
							coordenadas = true;	
						}else {
							System.out.println("las coordenadas no existen");
							System.out.println("Ingrese los valores nuevamente");
						}
					}
					
					if (cubo1.modificar(x, y, z, numeroModificar )== true) {
						cubo1.modificar(x, y, z, numeroModificar );
					} else {
						System.out.println("La posicion en la que desea modificar esta vacia");
					}
					
					System.out.println("Desea seguir modificando numeros? si/no");
					modificar = teclado.nextLine();
					
				}
				break;
				
			case 3:
				while(anular == "si") {
					int x = 0;
					int y = 0;
					int z = 0;
					boolean coordenadas = false;
					
					while (coordenadas == false) {
						System.out.println("Ingrese el numero de la columna del cubo:");
						x = Integer.parseInt(teclado.nextLine());
						System.out.println("Ingrese el numero de la fila del cubo:");
						y = Integer.parseInt(teclado.nextLine());
						System.out.println("Ingrese el numero de la profundidad del cubo:");
						z = Integer.parseInt(teclado.nextLine());
						if (x < columnas && y < filas && z < profundidad ) {
							coordenadas = true;	
						}else {
							System.out.println("las coordenadas no existen");
							System.out.println("Ingrese los valores nuevamente");
						}
					}
					cubo1.anular(x, y, z);
					System.out.println("Numero anulado");
					System.out.println("Desea seguir anulando numeros? si/no");
					anular = teclado.nextLine();
				}
				break;
				
			case 4:
				cubo1.alea();
				System.out.println("Se recargaron todos los elementos del cubo");
				break;
				
			case 5:
				System.out.println("Coordenadas vacias:");
				ArrayList<String> nulos = cubo1.nulos();
				int j;
			    for (j=0; j < nulos.size(); j++) {
					System.out.println("Coordenada:"  +nulos.get(j));
			    }
			    break;

			case 6:
				System.out.println("Se recargaron todos los elementos del cubo");
				while(buscarValor== "si") {
					int x = 0;
					int y = 0;
					int z = 0;
					int valor = 0;
					boolean coordenadas = false;
					
					while (coordenadas == false) {
						System.out.println("Ingrese el numero de la columna del cubo:");
						x = Integer.parseInt(teclado.nextLine());
						System.out.println("Ingrese el numero de la fila del cubo:");
						y = Integer.parseInt(teclado.nextLine());
						System.out.println("Ingrese el numero de la profundidad del cubo:");
						z = Integer.parseInt(teclado.nextLine());
						if (x <= columnas && y <= filas && z <= profundidad ) {
							coordenadas = true;	
						}else {
							System.out.println("las coordenadas no existen");
							System.out.println("Ingrese los valores nuevamente");
						}
					}
					valor = cubo1.buscarValor(x, y, z); 
					System.out.println("El valor que busca es: "+ valor);
					System.out.println("--------------------------------------");

					System.out.println("Desea seguir buscando el valor? si/no");
					buscarValor = teclado.nextLine();
					
				}
				break;
				
				
			case 7:
				System.out.println("Sumatoria de cada cara:");
			    int[] caras = cubo1.sumatoria();
			    int cara = 1;
			    for (int i=0; i < caras.length; i++) {
					System.out.println("Cara" + cara +": "+caras[i]);
					cara++;
			    }
			    break;
			    
			case 8:
				cubo1.imprimir();
				break;
				
			case 9:
				System.out.println("Adios....");
				ingreso = false;
				break;
			
			}
		}
		
	}

}
