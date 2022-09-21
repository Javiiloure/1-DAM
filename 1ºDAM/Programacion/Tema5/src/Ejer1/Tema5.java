package  Ejer1;
public class Tema5 {

	public static void main(String[] args) {
		ejercicio1();
	}
	
	public static void ejercicio1() {
		
		double precio_electrodomesticos = 0;
		double precio_lavadoras = 0;
		double precio_televisiones = 0;

		Electrodomestico [] Electrodomesticos = new Electrodomestico[10];
		Electrodomesticos [0] = new Electrodomestico();
		Electrodomesticos [1] = new Lavadora();
		Electrodomesticos [2] = new Television();
		Electrodomesticos [3] = new Electrodomestico(370.99, 50);
		Electrodomesticos [4] = new Lavadora(490.99, 450);
		Electrodomesticos [5] = new Television(280.90, 30);
		Electrodomesticos [6] = new Electrodomestico(430.99, "rojo", 'C', 120);
		Electrodomesticos [7] = new Lavadora(399.99, "blanco", 'A', 420, 50);
		Electrodomesticos [8] = new Television(199.99, "negro", 'D', 30, 32, false);
		Electrodomesticos [9] = new Electrodomestico(320.99, "azul", 'B', 70);
		
		for(int i = 0; i < Electrodomesticos.length; i++) {
			if(Electrodomesticos[i] instanceof Electrodomestico) {
				precio_electrodomesticos += Electrodomesticos[i].precioFinal();
			}
			if(Electrodomesticos[i] instanceof Lavadora) {
				precio_lavadoras += Electrodomesticos[i].precioFinal();
			}
			if(Electrodomesticos[i] instanceof Television) {
				precio_televisiones += Electrodomesticos[i].precioFinal();
			}
		}
		System.out.println("La suma de los electrodomesticos es: " + precio_electrodomesticos);
		System.out.println("La suma de las lavadoras es: " + precio_lavadoras);
		System.out.println("La suma de las televisiones es : " + precio_televisiones);
	}
}