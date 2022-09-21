import java.util.Scanner;
import java.util.Random;

public class JavierLoureiroP3PRO {
		public static void main(String[] args) {
		String select;
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Menú principal, seleccione una opción: \n" + "1/ Buscador de elemento en vector \n"
					+ "2/ Punto silla \n" + "3/ Nombre y Apellidos \n" + "0/ Salir del programa");
			select = scan.next();
			switch (select) {
			case "1":
				int tamaño_vector;
				int vector[];
				int elemento;
				int posicion;
				System.out.println("Ha seleccionado búsqueda de elemento.");
				do {
					System.out.println("Introduzca el número de elementos del vector: ");
					tamaño_vector = scan.nextInt();
					if (tamaño_vector <= 0) {
						System.out.println("El tamaño debe ser mayor que 0");
					}
				}while (tamaño_vector <= 0);
				vector = new int[tamaño_vector];
				do {
					System.out.println("Introduzca el elemento a buscar(0-100): ");
					elemento = scan.nextInt();
					if (elemento < 0 || elemento > 100){
						System.out.println("El valor debe estar comprendido entre 0 y 100");
					}
				} while(elemento < 0 || elemento > 100);
				posicion = busqueda_elemento(vector, elemento);
				System.out.println("La primera posición del elemento en el vector es " + posicion);
				exit = false;
				break;
			case "2":
				int tamaño_matriz;
				int matriz[][];
				int fila;
				int columna;
				boolean punto_silla;
				boolean salida = false;
				int select2;
				do {
					System.out.println("Ha selecionado punto silla.");
					do { 
						System.out.println("Introduzca el numero de elementos por filas y columnas de la matriz:");
						tamaño_matriz = scan.nextInt();
						if (tamaño_matriz < 1) {
							System.out.println("El tamaño de la matriz debe ser mayor que 1");
						}
					} while(tamaño_matriz < 1);
					matriz = new int[tamaño_matriz][tamaño_matriz];
					do {
						System.out.println("Introduzca la fila del elemento a comprobar: ");
						fila = scan.nextInt();
						if (fila < 0) {
							System.out.println("El número debe ser positivo");
						} 
						if (fila > tamaño_matriz) {
							System.out.println("La fila debe ser menor que el tamaño de la matriz");
						}
					} while (fila < 0 || fila > tamaño_matriz);
					fila = fila - 1;
					do {
						System.out.println("Introduzca la columna del elemento a comprobar");
						columna = scan.nextInt();
						if (columna < 0) {
							System.out.println("El número debe ser positivo");
						}
						if (columna > tamaño_matriz) {
							System.out.println("La columna debe ser menor que el tamaño de la matriz");
						}
					} while (columna < 0 || columna > tamaño_matriz);
					columna = columna - 1;
					punto_silla = punto_silla(matriz, fila, columna, tamaño_matriz);
					if (punto_silla == true) {
						System.out.println("\nEl elemento " + matriz[fila][columna] + " situado en la fila " + (fila + 1) + " y en la columna " + (columna + 1) + " es punto silla.");
					} else {
						System.out.println("\nEl elemento " + matriz[fila][columna] + " situado en la fila " + (fila + 1) + " y en la columna " + (columna + 1) + "  no es punto silla.");
					}
					do {
						System.out.println("Indique la siguiente acción: \n1/Repetir punto silla \n2/Volver al menú");
						select2 = scan.nextInt();
						if (select2 < 1 || select2 > 2) {
							System.out.println("Elija una opción válida.");
						}
					} while (select2 <= 1 && select2 >= 2);
					if (select2 == 2) {
						salida = true;
					}
				} while (salida != true);
				exit = false;
				break;
			case "3":
				System.out.println("Ha seleccionado Nombre y Apellidos.");
				nombre_apellidos();
				exit = false;
				break;
			default:
				System.out.println("Opción no válida.");
				exit = false;
				break;
			case "0":
				System.out.println("Cerrando el programa.");
				exit = true;
			}
		} while (exit != true);
		scan.close();
	}

	public static int busqueda_elemento(int vector[], int elemento) {
		int posicion = -1;
		Random rdn = new Random();
		for (int i = 0; i < vector.length; i++) {
			vector[i] = rdn.nextInt(100 - 1);
		}
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] == elemento) {
				posicion = i;
				break;
			}
		}
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]);
		}
		return posicion;
	}

	public static boolean punto_silla(int matriz[][], int x, int y, int tamaño) {
		boolean punto_silla = true;
		Random rdn = new Random();
		for (int i = 0; i < tamaño; i++) {
			System.out.println();
			for (int o = 0; o < tamaño; o++) {
				matriz[i][o] = rdn.nextInt(100 - 1);
				System.out.print(matriz[i][o] + " ");
			}
		}
		//while (punto_silla == true) {
			for (int i = 0; i < tamaño; i++) {
				if (matriz[i][y] > matriz[x][y]) {
					punto_silla = false;
					break;
				}
			}
			if (punto_silla == false) return punto_silla;
			//	break;
			for (int i = 0; i < tamaño; i++) {
				if (matriz[x][i] < matriz[x][y]) {
					punto_silla = false;
					break;
				}
			}
		//}
		return punto_silla;
	}
	public static void nombre_apellidos () {
		String x;
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca el nombre:");
		x = scan.nextLine();
		String aux = x.trim();
		String [] separador;
		separador = aux.split(" ", 3);
		
		if (separador.length == 2) {
			System.out.println(separador[1] + " " + separador[0].charAt(0) + ".");
		}
		if (separador.length == 3) {
			System.out.println(separador[2] + " " + separador[0].charAt(0) + "." + separador[1]);
		}
	}
}