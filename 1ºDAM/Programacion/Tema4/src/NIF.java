import java.util.Scanner;

public class NIF {
	private int dni;
	private char letra;
	
	private final static char array[] LETRAS = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'}
	
	public NIF () {
		this.dni = 0;
		this.letra = calcularLetra(this.dni);
	}
	
	public NIF (int dni) {
		this.dni = dni;
		this.letra = calcularLetra(this.dni);
		
	}
	public void setdni(int dni) {
		this.dni = dni;
		this.letra = calcularLetra(this.dni);
		if(this.letra != letra) {
			System.out.println();
		}
	}
	
	public int getdni() {
		return this.dni;
	}
	
	public char getletra() {
		return this.letra;
	}
	
	public String toString() {
		return getdni() + "-" + getletra();
	}
	
	public static NIF leer(Scanner scan) {
		System.out.println("Introduzca los n�meros del dni: 0");
		int nums = Integer.parseInt(scan.nextLine());
		char letra = calcularLetra(nums);
		return new NIF(nums);
	}
	
	private static char calcularLetra(int num) {
		return LETRAS[num % 23];
	}
 }
