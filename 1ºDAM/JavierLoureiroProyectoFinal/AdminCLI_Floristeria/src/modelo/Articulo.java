package modelo;

public class Articulo {
	private int codigo_articulo;
	private int stock;
	private double precio;

	public Articulo(int codigo_articulo, int stock, double precio) {
		this.codigo_articulo = codigo_articulo;
		this.stock = stock;
		this.precio = precio;
	}

	public Articulo() {
		this.codigo_articulo = 0;
		this.stock = 0;
		this.precio = 0;
	}

	public int getCodigo_articulo() {
		return codigo_articulo;
	}

	public void setCodigo_articulo(int codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return " codigo de articulo: " + codigo_articulo + " stock: " + stock + " precio: " + precio;
	}

}
