package testpackage;
import org.junit.jupiter.api.Test;

import MainPackage.Tema2;

import static org.junit.Assert.*;

class Tema2Test {
/*
	@Test
	void intercambiocambiotest() {
		int a = 4;
		int b = 7;
		Tema2.intercambio(a, b);
		assertEquals(a, Tema2.siete);
		assertEquals(b, Tema2.cuatro);		
	}
*/
	@Test
	void mayorDeTrestest() {
		int a = 9;
		int b = 4;
		int c = 7;
		int mayor;
		mayor = Tema2.mayorDeTres(a, b, c);
		assertEquals(mayor, a);
}

	@Test
	void  factorialtest() {
		int actual = 5;
		int esperado = 120;
		actual = Tema2.factorial(actual);
		assertEquals(esperado, actual);
	}

	@Test
	void calcE() {

	}

	@Test
	void recuentotest() {
		char caracter = 'a';
		String cadena = "ahfbrvdgchkdankvfnkenjkdcbhkakfvnj.a";
		int repeticiones = 3;
		int x;
		x = Tema2.recuento(caracter, cadena);
		assertEquals(repeticiones, x);
	}
	
	@Test
	void inversiontest() {
		int x = 123456789;
		int esperado = 987654321;
		x = Tema2.inversión(x);
		assertEquals(x , esperado);
	}
	
	@Test
	void amigostest() {
		int a = 220;
		int b = 284;
		boolean toret;
		boolean esperado = true;
		toret = Tema2.amigos(a, b);
		assertEquals(esperado, toret);
	}
	
	@Test
	void perfectotest() {
		int x = 6;
		boolean toret;
		boolean esperado = true;
		toret = Tema2.perfecto(x);
		assertEquals(toret, esperado);
	}

/*
	@Test
	void registrotest() {
		
	}
*/
}