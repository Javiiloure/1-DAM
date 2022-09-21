package Ejer5;
public class Bebida {
	
	private static int idActual = 1;

	public int id;
	public int litros;
	public double precio;
	public String marca;
	
	public Bebida() {
		this.id = idActual++;
		this.litros = 0;
		this.precio = 0;
		this.marca = "";
	}
	
	public Bebida(int id, int litros, double precio, String marca) {
		this.id = idActual++;
		this.litros = litros;
		this.precio = precio;
		this.marca = marca;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLitros() {
		return litros;
	}
	public void setLitros(int litros) {
		this.litros = litros;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}