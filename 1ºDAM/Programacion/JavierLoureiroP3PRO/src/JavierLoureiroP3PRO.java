import java.util.Scanner;
import java.util.Random;

public class JavierLoureiroP3PRO {
		public static void main(String[] args) {
		String select;
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Men� principal, seleccione una opci�n: \n" + "1/ Buscador de elemento en vector \n"
					+ "2/ Punto silla \n" + "3/ Nombre y Apellidos \n" + "0/ Salir del programa");
			select = scan.next();
			switch (select) {
			case "1":
				int tama�o_vector;
				int vector[];
				int elemento;
				int posicion;
				System.out.println("Ha seleccionado b�squeda de elemento.");
				do {
					System.out.println("Introduzca el n�mero de elementos del vector: ");
					tama�o_vector = scan.nextInt();
					if (tama�o_vector <= 0) {
						System.out.println("El tama�o debe ser mayor que 0");
					}
				}while (tama�o_vector <= 0);
				vector = new int[tama�o_vector];
				do {
					System.out.println("Introduzca el elemento a buscar(0-100): ");
					elemento = scan.nextInt();
					if (elemento < 0 || elemento > 100){
						System.out.println("El valor debe estar comprendido entre 0 y 100");
					}
				} while(elemento < 0 || elemento > 100);
				posicion = busqueda_elemento(vector, elemento);
				System.out.println("La primera posici�n del elemento en el vector es " + posicion);
				exit = false;
				break;
			case "2":
				int tama�o_matriz;
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
						tama�o_matriz = scan.nextInt();
						if (tama�o_matriz < 1) {
							System.out.println("El tama�o de la matriz debe ser mayor que 1");
						}
					} while(tama�o_matriz < 1);
					matriz = new int[tama�o_matriz][tama�o_matriz];
					do {
						System.out.println("Introduzca la fila del elemento a comprobar: ");
						fila = scan.nextInt();
						if (fila < 0) {
							System.out.println("El n�mero debe ser positivo");
						} 
						if (fila > tama�o_matriz) {
							System.out.println("La fila debe ser menor que el tama�o de la matriz");
						}
					} while (fila < 0 || fila > tama�o_matriz);
					fila = fila - 1;
					do {
						System.out.println("Introduzca la columna del elemento a comprobar");
						columna = scan.nextInt();
						if (columna < 0) {
							System.out.println("El n�mero debe ser positivo");
						}
						if (columna > tama�o_matriz) {
							System.out.println("La columna debe ser menor que el tama�o de la matriz");
						}
					} while (columna < 0 || columna > tama�o_matriz);
					columna = columna - 1;
					punto_silla = punto_silla(matriz, fila, columna, tama�o_matriz);
					if (punto_silla == true) {
						System.out.println("\nEl elemento " + matriz[fila][columna] + " situado en la fila " + (fila + 1) + " y en la columna " + (columna + 1) + " es punto silla.");
					} else {
						System.out.println("\nEl elemento " + matriz[fila][columna] + " situado en la fila " + (fila + 1) + " y en la columna " + (columna + 1) + "  no es punto silla.");
					}
					do {
						System.out.println("Indique la siguiente acci�n: \n1/Repetir punto silla \n2/Volver al men�");
						select2 = scan.nextInt();
						if (select2 < 1 || select2 > 2) {
							System.out.println("Elija una opci�n v�lida.");
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
				System.out.println("Opci�n no v�lida.");
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

	public static boolean punto_silla(int matriz[][], int x, int y, int tama�o) {
		boolean punto_silla = true;
		Random rdn = new Random();
		for (int i = 0; i < tama�o; i++) {
			System.out.println();
			for (int o = 0; o < tama�o; o++) {
				matriz[i][o] = rdn.nextInt(100 - 1);
				System.out.print(matriz[i][o] + " ");
			}
		}
		//while (punto_silla == true) {
			for (int i = 0; i < tama�o; i++) {
				if (matriz[i][y] > matriz[x][y]) {
					punto_silla = false;
					break;
				}
			}
			if (punto_silla == false) return punto_silla;
			//	break;
			for (int i = 0; i < tama�o; i++) {
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