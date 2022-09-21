package Ejer5;

public class Almacen {
	private Bebida[][] estanteria;

	public Almacen() {
		estanteria = new Bebida[5][5];
	}

	public Almacen(int filas, int columnas) {
		estanteria = new Bebida[filas][columnas];
	}

	public double calcularPrecio() {
		double precio = 0;
		for (int x = 0; x < estanteria.length; x++) {
			for (int y = 0; y < estanteria[0].length; y++) {
				precio += estanteria[x][y].precio;
			}
		}
		return precio;
	}

	public double precioMarca(String marca) {
		double precio = 0;
		for (int x = 0; x < estanteria.length; x++) {
			for (int y = 0; y < estanteria[0].length; y++) {
				if (estanteria[x][y].marca == marca) {
					precio += estanteria[x][y].precio;
				}
			}
		}
		return precio;
	}

	public double precioEstanteria(int y) {
		double precio = 0;
		for (int x = 0; x < estanteria.length; x++) {
			precio += estanteria[x][y].precio;
		}
		return precio;
	}

	public void agregarProducto(int id, int litros, double precio, String marca) {		//Agua o Azucarada?
		int x;
		int y;
		for (x = 0; x < estanteria.length; x++) {
			for (y = 0; y < estanteria[0].length; y++) {
				if (id == estanteria[x][y].id) {
					System.out.println("Identificador repetido, no se a�adira el producto");
					break;
				}
				if (estanteria[x][y] == null) {
					estanteria[x][y] = new Bebida(id, litros, precio, marca);
				}
			}
			if (id == estanteria[x][y].id) {
				break;
			}
		}
	}
}
