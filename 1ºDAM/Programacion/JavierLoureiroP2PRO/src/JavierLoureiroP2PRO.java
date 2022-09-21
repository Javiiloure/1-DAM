import java.util.Scanner;

public class JavierLoureiroP2PRO {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		char select;
		boolean exit = false;
		do {
			System.out.println("Men� principal, seleccione una opci�n: " + "\n1/Contador de d�as" + "\n2/Combinatorio"
					+ "\n3/N�meros perfectos" + "\n0/Salir del programa");
			select = scan.next().charAt(0);
			switch (select) {
			case '1':
				int a�o;
				String mes;
				int dias;
				System.out.println("Ha elegido contador de d�as.");
				System.out.println("Introduzca el a�o: ");
				a�o = scan.nextInt();
				System.out.println("Introduca el mes:");
				mes = scan.next();
				mes = mes.toLowerCase();
				dias = dias_mes(a�o, mes);
				System.out.println("tiene " + dias + " dias");
				break;
			case '2':
				int comb;
				int m;
				int n;
				boolean exit2 = false;
				System.out.println("Ha elegido Combinatorio.");
				do {
					System.out.println("Introduzca el mayor n�mero: ");
					m = scan.nextInt();
					System.out.println("Introduzca el menor n�mero: ");
					n = scan.nextInt();
					if (m < 0 || n < 0) {
						System.out.println("Introduzca n�meros positivos");
						exit2 = false;
					} else if (n > m) {
						System.out.println("Introduzca los n�meros de mayor a menor.");
						exit2 = false;
					} else {
						exit2 = true;
					}
				} while (exit2 != true);
				comb = combinatorio(m, n);
				System.out.println("El combinatorio de " + m + " y de " + n + " es " + comb);
				break;
			case '3':
				int x;
				int y;
				boolean perfecto;
				boolean exit3;
				System.out.println("Ha elegido N�meros perfectos.");
				do {
					System.out.println("Introduzca mayor n�mero:");
					x = scan.nextInt();
					System.out.println("Introduzca el menor n�mero:");
					y = scan.nextInt();
					if(y > x) {
						System.out.println("Introduzca los n�meros en el orden correcto.");
						exit3 = false;
					} else if(x < 0 || y < 0) {
						System.out.println("Los n�meros deben ser positivos.");
						exit3 = false;
					} else {
						exit3 = true;
					}
				}while (exit3 != true	);
				System.out.println("Los n�meros perfectos comprendidos entre " + y + " y " + x + " son:");
				for(int i = y; i < x; i++) {
					perfecto = perfecto(i);
					if(perfecto == true) {
						System.out.println(i);
					}
				}
				break;
			case '0':
				System.out.println("Cerrando el programa.");
				exit = true;
				break;
			default:
				System.out.println("Elija una opci�n v�lida");
			}
		} while (exit != true);
		scan.close();
	}

	public static int dias_mes(int a�o, String mes) {
		int dias = 0;
		boolean bisiesto;
		boolean exit = true;
		do {
			switch (mes) {
			case "1":
			case "enero":
			case "3":
			case "marzo":
			case "5":
			case "mayo":
			case "7":
			case "julio":
			case "8":
			case "agosto":
			case "10":
			case "octubre":
			case "12":
			case "diciembre":
				dias = 31;
				break;
			case "2":
			case "febrero":
				bisiesto = bisiesto(a�o);
				if (bisiesto == false) {
					dias = 28;
				} else {
					dias = 29;
				}
				exit = true;
				break;
			case "4":
			case "abril":
			case "6":
			case "junio":
			case "9":
			case "septiembre":
			case "11":
			case "noviembre":
				dias = 30;
				exit = true;
				break;
			default:
				exit = false;
				System.out.println("Opci�n no v�lida");
				System.out.println("Introduzca el a�o :");
				a�o = scan.nextInt();
				System.out.println("Introduzca el mes ");
				mes = scan.next();
				mes = mes.toLowerCase();
			}
		} while (exit != true);
		
		System.out.println("El mes " + mes + " del a�o " + a�o);
		return dias;
	}

	public static boolean bisiesto(int a) {
		boolean x;
		if ((a % 4 == 0) && ((a % 100 != 0) || (a % 400 == 0))) {
			x = true;
		} else {
			x = false;
		}
		return x;
	}

	public static int combinatorio(int m, int n) { 
		int comb;
		comb = (factorial(m)) / ((factorial(n) * factorial(m - n)));
		return comb;
	}

	public static int factorial(int a) {
		int suma = 1;
		for (int i = 1; i <= a; i++) {
			suma = suma * i;
		}
		a = suma;
		return a;
	}

	public static boolean perfecto(int x) {
		int suma= 0;
		boolean perfecto;
		for(int i = 1; i < x; i++) {
			if(x % i == 0) {
				suma = suma + i;
			}
		}
		if(suma == x){
			perfecto = true;
		}
		else {
			perfecto = false;
		}
		return perfecto;
	}
}