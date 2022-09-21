package Ejer1;
public class Lavadora extends Electrodomestico {
	private int carga;
	public static final int CARGA_POR_DEFECTO = 5;

	public Lavadora() {
		super();
		this.carga = CARGA_POR_DEFECTO;
	}

	public Lavadora(double precio_base, int peso) {
		super(precio_base, peso);
		this.carga = CARGA_POR_DEFECTO;
	}

	public Lavadora(double precio_base, String color, char consumo, int peso, int carga) {
		super(precio_base, color, consumo, peso);
		this.carga = carga;
	}
	
	public int getCarga() {
		return carga;
	}
	
	public void setCarga(int carga) {
		this.carga = carga;
	}
	
	public double precioFinal() {
		double precio_final = super.precioFinal();
		if (carga > 30) {
			precio_final += 50;
		}
		return precio_final;
	}
}
