package Ejer1;

public class Electrodomestico {
	protected double precio_base;

	public static enum colores {
		blanco, negro, rojo, azul, gris
	};

	protected colores color;

	public static enum consumo_energetico {
		A, B, C, D, E, F
	};

	protected consumo_energetico consumo;
	protected int peso;
	protected static final colores COLOR_POR_DEFECTO = colores.blanco;
	protected static final consumo_energetico CONSUMO_POR_DEFECTO = consumo_energetico.F;
	protected static final double PRECIO_POR_DEFECTO = 100.00;
	protected static final int PESO_POR_DEFECTO = 5;
	public Electrodomestico() {
		this.precio_base = PRECIO_POR_DEFECTO;
		this.color = COLOR_POR_DEFECTO;
		this.consumo = CONSUMO_POR_DEFECTO;
		this.peso = PESO_POR_DEFECTO;
	}

	public Electrodomestico(double precio_base, int peso) {
		this.precio_base = precio_base;
		this.color = COLOR_POR_DEFECTO;
		this.consumo = CONSUMO_POR_DEFECTO;
		this.peso = peso;
	}

	public Electrodomestico(double precio_base, String color, char consumo, int peso) {
		this.precio_base = precio_base;
		comprobarColor(color);
		comprobarConsumoEnergetico(consumo);
		this.peso = peso;
	}

	public double getPrecio_base() {
		return precio_base;
	}

	public void setPrecio_base(double precio_base) {
		this.precio_base = precio_base;
	}

	public colores getColor() {
		return color;
	}

	public void setColor(String color) {
		comprobarColor(color);
	}

	public consumo_energetico getConsumo() {
		return consumo;
	}

	public void setConsumo(char consumo) {
		comprobarConsumoEnergetico(consumo);
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void comprobarConsumoEnergetico(char letra) {
		letra = Character.toUpperCase(letra);
		switch (letra) {
		case 'A':
			this.consumo = consumo_energetico.A;
			break;
		case 'B':
			this.consumo = consumo_energetico.B;
			break;
		case 'C':
			this.consumo = consumo_energetico.C;
			break;
		case 'D':
			this.consumo = consumo_energetico.D;
			break;
		case 'E':
			this.consumo = consumo_energetico.E;
			break;
		case 'F':
			this.consumo = consumo_energetico.F;
			break;
		default:
			System.out.println("Consumo incorrecto, se asignar� el consumo por defecto");
			this.consumo = CONSUMO_POR_DEFECTO;
		}
	}

	public void comprobarColor(String color) {
		color = color.toLowerCase();
		switch (color) {
		case "blanco":
			this.color = colores.rojo;
			break;
		case "negro":
			this.color = colores.negro;
			break;
		case "rojo":
			this.color = colores.rojo;
			break;
		case "azul":
			this.color = colores.azul;
			break;
		case "gris":
			this.color = colores.gris;
			break;
		default:
			System.out.println("Color introducido erroneo, se asignar� el color por defecto.");
			this.color = COLOR_POR_DEFECTO;
		}
	}

	public double precioFinal() {
		double precio_final = this.precio_base;
		switch (consumo) {
		case A:
			precio_final += 100.00;
			break;
		case B:
			precio_final += 80.00;
			break;
		case C:
			precio_final += 60.00;
			break;
		case D:
			precio_final += 50.00;
			break;
		case E:
			precio_final += 30.00;
			break;
		case F:
			precio_final += 10.00;
			break;
		}
		if (peso > 0 && peso <= 19) {
			precio_final += 10.00;
		} else if (peso >= 20 && peso <= 49) {
			precio_final += 50.00;
		} else if (peso >= 50 && peso <= 79) {
			precio_final += 80.00;
		} else {
			precio_final += 100.00;
		}
		return precio_final;
	}
}
