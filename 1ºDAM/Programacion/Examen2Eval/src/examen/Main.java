package examen;

import java.util.ArrayList;

public class Main {

	static ArrayList<Audiovisual> peliculasYseries;

	public static void main(String[] args) {
		// Parte 1:
		System.out.println("Comienza la parte 1: ");
		System.out.println(eliminaEspaciosDuplicados("Esto  es una   prueba  para ver  si   funciona       el m�todo  "));

		System.out.println("Termina la parte 1. ");

		System.out.println("=============================================================================");

		// Parte 2:
		System.out.println("Comienza la parte 2: ");
		int matriz[][] = {{45,56,44},{34,67,25},{77,11,12},{13,13,97},{32,32,86}};
		
		System.out.println(muestraMatriz(matriz));
		matriz = ordenInversoMatriz(matriz);
		System.out.println(muestraMatriz(matriz));


		System.out.println("Termina la parte 2. ");

		System.out.println("=============================================================================");
		// Parte 3:
		System.out.println("Comienza la parte 3: ");
		peliculasYseries = new ArrayList<Audiovisual>();
		Serie[] series = Serie.generadorSeries();
		Pelicula[] peliculas = Pelicula.generarPeliculas();

		for (Serie s : series) {
			peliculasYseries.add(s);
		}

		for (Pelicula p : peliculas) {
			peliculasYseries.add(p);
		}

	//	mostrartodo();

	//	System.out.println("La pelicula m�s larga es: " + peliculaMasLarga().toString());

	//	System.out.println("La serie m�s corta es: " + serieMasCorta().toString());

		System.out.println("Las peliculas y series del siglo XX son: " + sigloXX());

		System.out.println("Termina la parte 3. ");

	}



	// Implementar el siguiente m�todo qu� recibe una String c�mo par�metro y debe
	// devolverla sin los espacios duplicados.
	private static String eliminaEspaciosDuplicados(String string) {
		String x;
		x = string.replaceAll(" +", " ");
		return x;
	}
	
	/*Implementar el siguiente m�todo que debe reordenar los elementos de una matriz de mayor a menor, siguiendo el siguiente orden 0,0 menor, 0,1, el siguiente, 0,2, el siguiente,
	* y as� sucesivamente hasta que el elemento N,M sea el menor de todos y el 0,0 el mayor de todos
	* */
	private static int[][] ordenInversoMatriz(int[][] matriz) {
		int menor = matriz[0][0];
		int [][] aux = matriz;
		int x_aux = 0;
		int y_aux = 0;
		
		for(int x = 0; x < matriz.length; x++) {
			for (int y = 0; y < matriz[0].length; y++) {
				if(matriz[x][y] < menor) {
					menor = matriz[x][y];
					aux[x_aux][y_aux] = menor;
					x_aux++;
					y_aux++;
				}
			}
		}
		
		return aux;
	}

	/*
	 * Implementar un m�todo que muestre las matrices por pantalla de forma que se vea cada fila en una fila con todos sus elementos y separe dichos elementos por comas y los meta dentro
	 * de corchetes, y separe tambi�n las filas con saltos de l�nea. 
	 * 
	 * Adem�s debe introducir un salto de l�nea antes y despu�s del muestreo
	 * */
	private static String muestraMatriz(int[][] matriz) {
		String string = "";
		System.out.println();
		for (int x = 0; x < matriz.length; x++) {
			for (int y = 0; y < matriz[0].length; y ++) {
				string += "[" + String.valueOf(matriz[x][y]) + "],";
			}
			string += "\n";
		}
		System.out.println();
		return string;
	}

	// Implementar los siguientes m�todos para conseguir un resultado correcto:

	private static String sigloXX() {
		for (int i = 0; i < peliculasYseries.size(); i++) {
			if(peliculasYseries.get(i).getAnhoPubli() < 2000) {
				peliculasYseries.get(i).toString();
			}
		}
		return null;
	}

	/*private static Serie serieMasCorta() {
		int aux = 0;
		for (int i = 0; i < peliculasYseries.size(); i++) {
			aux = Serie.duracionTotal();
		}
		return null;
	}*/

	/*private static Pelicula peliculaMasLarga() {
		Pelicula aux;
		int duracion;
		int mayor_duracion = 0;
		for (int i = 0; i < peliculasYseries.size(); i++) {
			if (peliculasYseries.get(i) instanceof Pelicula) {
				duracion = peliculasYseries.get(i).duracionTotal();
				if(mayor_duracion < duracion) {
					mayor_duracion = duracion;
					aux = peliculasYseries.get(i);
				}
			}
		}
		return aux;
	}*/

	/*private static void mostrartodo() {
		for (int i = 0; i < peliculasYseries.size(); i++) {
				if (peliculasYseries.get(i) instanceof Pelicula) {
					
				}
		}*/
	}

