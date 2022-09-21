package MainPackage;
/* //Ejercicio1

import java.util.Scanner;
public class Tema1 {
	public static void main(String[] args) {
				
				Scanner scan = new Scanner(System.in); //Crea un escaner para leer datos por teclado
				System.out.print("Introduzca los grados Fahrenheit: ");
				float far = scan.nextFloat();
				scan.close(); //Cuando el escaner no se use mas se cierra
				float cel = (5f/9f) * (far-32f);
				System.out.println("Grados celsius: " + cel);
			}
		}
*/


/* //Ejercicio2

import java.util.Scanner;
public class Tema1 {

	public static void main(String[] args) {
		
		double pi = 3.141592;
		float radio;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca el valor del radio: ");
		radio = scan.nextFloat();
		scan.close();
		
		double area = 4*pi*Math.pow(radio, 2);
		System.out.println("El valor del area es: " + area);
		
		double volumen = (4*pi*Math.pow(radio, 3))/3;
		System.out.println("El valor del volumen es: " + volumen);
	}
}
*/

/*  //Ejercicio3
import java.util.Scanner;
public class Tema1	{

	public static void main(String[] args) {
		
		int nota=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el valor de la nota(entero):");
		nota = scan.nextInt();
		
		while(nota > 10||nota<0){
			System.out.println("Introduce una nota válida");
			nota = scan.nextInt();
			}
		scan.close();
		
		switch(nota){
			case 0:
			case 1: 
			case 2: 
			case 3: 
			case 4: 
				System.out.println("Insuficiente");
				break;
			case 5:
				System.out.println("Suficiente");
				break;
			case 6:
				System.out.println("Bien");
				break;
			case 7:
			case 8:
				System.out.println("Notable");
				break;
			case 9:
			case 10:
				System.out.println("Sobresaliente");
				break;
		}	
	}
}
*/

/*
import java.util.Scanner;
 

public class Tema1 {

	public static void main(String[] args) {
		
		char carac;
		int x = 0;
		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;

		Scanner scan = new Scanner(System.in);
		
		for (x = 0; x < 20; x++) {
			
			System.out.println("Introduzca un carácter: ");
			carac = scan.next().charAt(0);
			carac = Character.toLowerCase(carac);
			
			switch (carac) {
				case 'a':
					a++;
					break;
				case 'e':
					e++;
					break;
				case 'i':
					i++;
					break;
				case 'o':
					o++;
					break;
				case 'u':
					u++;
					break;
			}
		}
		scan.close();
		
		System.out.println("El caracter a se repite " + a + " veces");
		System.out.println("El caracter e se repite " + e + " veces");
		System.out.println("El caracter i se repite " + i + " veces");
		System.out.println("El caracter o se repite " + o + " veces");
		System.out.println("El caracter u se repite " + u + " veces");
	}
}
*/

/* //Ejercicio5

import java.util.Scanner;

public class Tema1 {

	public static void main(String[] args) {
		char op;
		int x;
		int y;
		int z;
		boolean fin = false;

		Scanner scan = new Scanner(System.in);
		
		while(fin == false) {
		
		System.out.println("Introduzca el primer número entero: ");
		x = scan.nextInt();
		System.out.println("Introduzca la operación");
		op = scan.next().charAt(0);
		System.out.println("Introduzca el segundo número entero: ");
		y = scan.nextInt();

		switch (op) {

			case '+':
				z = x + y;
				System.out.println("El resultado es: " + z);
				fin = true;
				break;
			case '-':
				z = x - y;
				System.out.println("El resultado es: " + z);
				fin = true;
				break;
			case '*':
				z = x * y;
				System.out.println("El resultado es: " + z);
				fin = true;
				break;
			case '/':
				z = x / y;
				System.out.println("El resultado es: " + z);
				fin = true;
				break;
			case '%':
				z = x % y;
				System.out.println("El resultado es: " + z);
				fin = true;
				break;
			default:
				System.out.println("La operación no es válida");
				fin = false;
			}
		}
		scan.close();
	}
}
*/

/*//Ejercicio6
import java.util.Scanner;

public class Tema1 {

	public static void main(String[] args) {
		double suma = 0;
		double x = 0;
		double promedio = 0;
		int i = 0;
		
		Scanner scan = new Scanner(System.in);

		for (i = 0; i < 20; i++) {
			
			System.out.println("Introduzca un número: ");
			x = scan.nextDouble();
			suma = suma + x;
		}
		scan.close();

		promedio = suma / 20;
		System.out.println("El promedio es: " + promedio);
	}
}
*/

/* //Ejercicio7
import java.util.Scanner;

public class Tema1 {

	public static void main(String[] args) {

		int x = 0;
		int fact = 1;
		boolean neg = false; // Declaro un boolean para comprobar si x es negativo

		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un número: ");
		x = scan.nextInt();
		scan.close();

		if (x < 0) { // Aqui se hace la comprobación
			neg = true;
			x = x * -1;
		}

		for (int i = x; i > 1; i--) { // Igualamos i a x, y a cada vuelta le restamos una unidad para despues
										// multiplicarlo por el total

			fact = fact * i;
		}

		if (neg == false) {
			System.out.println("El factorial de " + x + " es: " + fact);
		} else if (neg == true) {
			System.out.println("No se puede calcular el facorial de un número negativo"); // Si x es negativo saca este
																							// mensaje por pantalla
			System.out.println("El factorial de " + x + " es: " + fact); // Y saco por pantalla el factorial del
																			// positivo
		}
	}
}
*/

/* //Ejercicio8
import java.util.Scanner;

public class Tema1 {

	public static void main(String[] args) {

		int x = 0;
		int i = 0;
		int resto = 0;
		int suma = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un número: ");
		x = scan.nextInt();
		scan.close();

		for (i = 0; i <= x; i++) {

			resto = i % 2;

			if (resto != 0) {
				suma = suma + i;
			}
		}
		System.out.println("El sumatorio es: " + suma);
	}
}
*/

/* //Ejercicio8b
import java.util.Scanner;

public class Tema1 {

	public static void main(String[] args) {

		int x;
		int suma = 0;
		int resto;

		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un número: ");
		x = scan.nextInt();
		scan.close();

		for (int i = 0; i < 2 * x; i++) {

			resto = i % 2;
			if (resto != 0) {
				suma = suma + i;
			}
		}
		System.out.println("La suma es:" + suma);
	}
}
*/

/* //Ejercicio9
public class Tema1 {
	public static void main(String[] args) {

		int i = 1;
		int suma = 0;

		for (i = 1; i < 500; i++) {

			int resto = 0;
			int resto2 = 0;
			
			resto = i % 5;
			resto2 = i % 7;

			if (resto + resto2 == 0) {
				suma = suma + i;
			}
		}
		System.out.println("La suma es: " + suma);
	}
}
*/

/* //Ejercicio10
import java.util.Scanner;

public class Tema1 {
	public static void main(String[] args) {
		
		int x;
		String texto;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduzca un texto");
		texto = scan.nextLine();
		scan.close();
		
		x = texto.length();
		
		if(x <= 280) {
			System.out.println("Twiteable");
		}
		else {
			System.out.println("No twiteable");
		}
	}
}
*/

/* //Ejercicio11
import java.util.Scanner;

public class Tema1{

	public static void main(String[] args) {

		int min = 0;
		int hor = 0;
		int dia = 0;
		int i = 0;
		int aux;

		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Introduzca una cantidad de minutos");
			i = scan.nextInt();
			if (i < 0)
				System.out.println("Introduza un número positivo");
		} while (i < 0);
		scan.close();

		for (aux = 0; aux < i; aux++) {
			min++;
			if (min == 60) {
				hor++;
				min = min - 60;
			}
			if (hor == 24) {
				dia++;
				hor = hor - 24;
			}
		}
		System.out.println(dia + " dias " + hor + " horas " + min + " minutos ");
	}
}
*/

/* //Ejercicio12
import java.util.Scanner;

public class Tema1 {

	public static void main(String[] args) {

		int num, par = 0;
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {

			System.out.println("Introduzca un número: ");
			num = scan.nextInt();

			if (num % 2 == 0) {
				par++;
			}
		}
		scan.close();

		switch (par) {
		case 0:
			System.out.println("Todos son impares");
			break;
		case 1:
			System.out.println("2 son impares y 1 es par");
			break;
		case 2:
			System.out.println("1 es impar y 2 son pares");
			break;
		case 3:
			System.out.println("Todos son pares");
			break;
		}
	}
}
*/

/*//Ejercicio13
import java.util.Scanner;

public class Tema1 {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introuzca el primer número ");
		a = scan.nextInt();
		System.out.println("Introduzca el segundo número");
		b = scan.nextInt();
		scan.close();
		
		if(a == 0 && b == 0) {
			System.out.println("El resultado es nulo");
		}
		else if(a < 0 && b < 0 || a > 0 && b > 0) {
			System.out.println("El resultado es positivo");
		}
		else if(a < 0 && b > 0 || a > 0 && b < 0){
			System.out.println("El resultado es negativo");
		}
	}
}
*/

/* //Ejericcio14
import java.util.Scanner;

public class Tema1 {

	public static void main(String[] args) {

		int x;
		int y;
		int sum = 0;

		Scanner scan = new Scanner(System.in);

		do {
			System.out.println("Introduzca la base");
			x = scan.nextInt();
			System.out.println("Introduzca el exponente");
			y = scan.nextInt();
			if(x < 0 || y < 0) {
				System.out.println("Los números deben ser positivos");
			}
		} while (x < 0 || y < 0);
		scan.close();

		if (y != 0) {
			sum = x;
			for (int i = 1; i < y; i++) {
				sum = sum * x;
				System.out.println("El resultado es " + sum);
			}

		} else {
			System.out.println("El resultado es 1");
		}
	}
}
*/

/* //Ejercicio15
import java.util.Scanner;

public class Tema1 {

	public static void main(String[] args) {

		float max = 0;
		float min = 0;
		float aux;

		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un número");
		aux = scan.nextFloat();

		for (int i = 0; i < 19; i++) {

			System.out.println("Introduzca un número");
			aux = scan.nextFloat();

			if (aux < min) {
				min = aux;
			} else if (aux > max) {
				max = aux;
			}
		}
		scan.close();
		System.out.println("El valor mínimo es " + min + " y el valor máximo es " + max);
	}
}
*/

/* //Ejercicio16
import java.util.Scanner;
public class Ejercicio16 {

	public static void main(String[] args) {
		
		int x = 0;
		Scanner scan = new Scanner(System.in);
		
		while(x < 1 || x > 9){
			
			System.out.println("Introduce un número del 1 al 9");
			x = scan.nextInt();
		}
		scan.close();
		if(x == 1 || x == 3 || x == 5 || x == 7 || x == 9) {
			
			System.out.println("El número " + x + " es primo");
			
		}
		else {
			System.out.println("El número " + x + " no es primo");
		}
	}
}
*/

/* //Ejercicio17
import java.util.Scanner;
public class Ejercicio17 {

	public static void main(String[] args) {
		
		int x;
		int mayor;
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un número: ");
		x = scan.nextInt();
		mayor = x;
		do {
			System.out.println("Introduzca un número mayor que el anterior: ");
			System.out.println("Presione 0 para salir:");
			x = scan.nextInt();
			if(x > mayor) {
				mayor = x;
				System.out.println("El nuevo mayor es " + mayor);
			}
			else if(x < mayor && x != 0) {
				System.out.println("El número introducido no es mayor que " + mayor);
			}
		}while(x != 0);
		scan.close();
		System.out.println("El mayor número es " + mayor);
	}
}
*/

/* //Ejercicio18
import java.util.Scanner;
public class Tema1 {
	public static void main(String[] args) {
		
		int x = 0;
		int resto = 0;
		int sum = 0;
		int sum2 = 0;
		int impar = 0;
		int par = 0;
		float media = 0;
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			System.out.println("Introduce un número:");
			x = scan.nextInt();
			resto = x % 2;
			
			if(resto == 0) {
				sum = sum + x;
				par++;
			}
			else {
				impar++;
				sum2 = sum2  + x;
				media = sum2 / impar;
			}
		}
		scan.close();
		
		System.out.println("Hay " + par + " números pares y su suma es " + sum);
		System.out.println("Hay " + impar + " números impares y su media es " + media);
	}

}
*/

/* //Ejercicio20
import java.util.Scanner;
public class Tema1 {

	public static void main(String[] args) {
		
		int x;
		int resto;
		int suma = 0;
		int z;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduzca un número");
		x = scan.nextInt();
		scan.close();
		String y = Integer.toString(x);
		z = y.length();
		
		for(int i = 0; i < z; i++) {
			resto =	x % 10;
			if(resto % 2 == 0){
				suma = suma + resto;
			}
			x = x / 10;
		}
		System.out.println("La suma de los dígitos pares es " + suma);
	}
}
*/