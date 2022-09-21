package MainPackage;
import java.util.Scanner;
public class Tema2 {

	public static int cuatro = 4, siete = 7;
	public static String nick, pass;
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

	}

	// Ejercicio 1
	public static void intercambio(int x, int y) {
		int aux;
		System.out.println("Valor 1 = " + x);
		System.out.println("Valor 2 = " + y);
		aux = x;
		x = y;
		y = aux;
		System.out.println("Valor 1 = " + x);
		System.out.println("Valor 2 = " + y);
	}

	// Ejercicio 2
	public static int mayorDeTres(int a, int b, int c) {
		if (a >= b && a >= c) {
			return a;
		} else if (b >= c && b >= a) {
			return b;
		} else {
			return c;
		}
	}

	// Ejercicio 3
	public static int factorial(int x) {
		int fact;
		if (x == 0) {
			fact = x;
		} else {
			fact = 1;
		}
		for (int i = 1; i <= x; i++) {
			fact *= i; // fact = fact * i;
		}
		return fact;
	}

	public static double calcE(int precision) {
		double e = 1.0d;
		for (int i = precision; i > 0; i--) {
			e += (i / factorial(i));
		}
		return e;
	}

	// Ejercicio4
	public static int recuento(char a, String b) {
		int cont = 0;
		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '.') {
				return cont;
			}
			if (b.charAt(i) == a) {
				cont++;
			}
		}
		return cont;
	}

	// Ejercicio5

	public static int inversión(int a) {
		int resto;
		int b = 0;
		while (a > 0) {
			resto = a % 10;
			b = b * 10 + resto;
			a /= 10;
		}
		return b;
	}

	// Ejercicio6

	public static boolean amigos(int x, int y) {
		int sumx = 0, sumy = 0;
		for(int i = 1; i < x; i++) {
			if (x % i == 0) {
				sumx += i;
			}
		}
		if(sumx == y) {
			for(int i = 1; i < y; i++) {
				if (y % i == 0){
					sumy += i;
				}
			}
			if(sumy == x){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	// Ejercicio7
		
	public static boolean perfecto(int x) {
		boolean toret = false;
		x = Math.abs(x);
		int sum = 0;
		for(int i = 1; i < x; i++) {
			if( x % i == 0) {
				sum += i;
			}
		}
		if(sum == x) {
			toret = true; //return true
		}
		return toret; //return false en caso de no pasar por el if
	}
	
	// Ejercicio8
	
	public static boolean registro() {
		String passRepeat;
		System.out.println("Introduzca su nickname:");
		nick = scan.next();
		System.out.println("Introduzca una contraseña:");
		pass = scan.next();
		System.out.println("Repita la contraseña:");
		passRepeat = scan.next();
		if(pass.equals(passRepeat)) {
			return true;
		}
		System.out.println("Las contraseñas no coinciden.");
		return false;
	}
}

/*
 * //Ejercicio10 import java.util.Scanner; public class Tema2 {
 * 
 * public static void main (String[] args ) { int x; int area = 0; int per = 0;
 * Scanner scan = new Scanner(System.in);
 * System.out.println("Calculador de área y perímetro, seleccione una opción:" +
 * "/n 1/Circunferencia" + "/n 2/Rectángulo" + "/n 3/Cuadrado" +
 * "/n 4/Triángulo equilátero"); x = scan.nextInt(); scan.close(); switch(x) {
 * case'1': circunferencia(area, per); System.out.println("El perímetro es " +
 * per + " y el area es " + area); break; case'2': rectangulo(); break; case'3':
 * cuadrado(); break; case'4': triangulo(); } }
 * 
 * public static double circunferencia(double area, double per) { double radio;
 * Scanner scan = new Scanner(System.in);
 * System.out.println("Introduzca el radio de la circunferencia:"); radio =
 * scan.nextDouble(); scan.close();
 * 
 * per = 2 * Math.PI * radio; area = Math.PI * Math.pow(radio, 2);
 * System.out.println("El perímetro es " + per + " y el area es " + area);
 * return per; }
 * 
 * public static void rectangulo() {
 * 
 * }
 * 
 * public static void cuadrado() {
 * 
 * }
 * 
 * public static void triangulo() {
 * 
 * } }
 */