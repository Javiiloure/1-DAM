import java.util.Scanner;
public class JavierLoureiroP1PRO {
	public static void main(String[] args) {
		char select = '0';
		Scanner scan = new Scanner(System.in);
		boolean exit = false;
		 do{
			System.out.println("Men� principal, elija una opci�n:");
			System.out.println("1: N�meros perfecos");
			System.out.println("2: Comparaci�n de n�meros");
			System.out.println("0: Cerrar el programa");
			select = scan.next().charAt(0);
			if(select == '1') {
				exit = true;
			}
			else if(select == '2') {
				exit = true;
			}
			else if(select == '0') {
				exit = true;
			}
			if(exit == false) {
			System.out.println("Opci�n no v�lida");	
			}	
		 }while (exit == false);
		
		switch (select) {
		case '1':
			System.out.println("Ha elegido N�meros perfectos");
			int x;
			int suma = 0;
			int y;
			System.out.println("Introduzca un n�mero");
			System.out.println("Pulse 0 para salir");
			x = scan.nextInt();
			if(x < 0) {
				System.out.println("El numero introducido es negativo, se tratara como positivo.");
				x = x * -1;
			}
			if(x == 0) {
				System.out.println("Cerrando el programa");
				break;
			}
			y = x / 2;
			for (int i = 1; i <= y; i++) {
				if (x % i == 0) {
					suma = suma + i;
				}
			}
			if (suma == x) {
				System.out.println("El n�mero " + x + " es perfecto");
			} else {
				System.out.println("El n�mero " + x + " no es perfecto");
			}
			break;
		case '2':
			System.out.println("Ha elegido comparaci�n de n�meros");
			int a;
			int b;
			System.out.println("Introduzca un n�mero positivo");
			System.out.println("Pulse 0 para salir");
			a = scan.nextInt();
			b = a;
			while (a < 0) {
				System.out.println("El n�mero introducido debe ser positivo");
				System.out.println("Introduzca un n�mero positivo");
				System.out.println("Pulse 0 para salir");
				a = scan.nextInt();
			}
			 while (a != 0){
				System.out.println("Introduzca un n�mero");
				System.out.println("Pulse 0 para salir");
				a = scan.nextInt();
				if (a == 0) {
					break;
				}
				if (a < 0) {
					System.out.println("El n�mero debe ser positivo");
				} else if (a < b) {
					System.out.println("El n�mero es menor que el anterior");
					b = a;
				} else if (a > b) {
					System.out.println("El n�mero es mayor que el anterior");
					b = a;
				} else if (a == b) {
					System.out.println("El n�mero es igual al anterior");
				}
			}
		case '0':
			System.out.println("Cerrando el programa.");
		}
		scan.close();
	}
}