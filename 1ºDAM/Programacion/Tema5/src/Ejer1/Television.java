package Ejer1;
public class Television extends Electrodomestico {
	
	private double resolucion;
	private boolean sintonizador_TDT;
	public static final double RESOLUCION_POR_DEFECTO = 20;
	public static final boolean SINTONIZADOR_POR_DEFECTO = false;
	
	public Television() {
		super();
		this.resolucion = RESOLUCION_POR_DEFECTO;
		this.sintonizador_TDT = SINTONIZADOR_POR_DEFECTO;
	}
	
	public Television (double precio_base, int peso) {
		super(precio_base, peso);
		this.resolucion = RESOLUCION_POR_DEFECTO;
		this.sintonizador_TDT = SINTONIZADOR_POR_DEFECTO;
	}
	
	public Television(double precio_base, String color, char consumo, int peso, double resolucion, boolean sintonizador_TDT) {
		super(precio_base, color, consumo, peso);
		this.resolucion = resolucion;
		this.sintonizador_TDT = sintonizador_TDT;
	}
	
	public double getResolucion() {
		return resolucion;
	}
	
	public boolean getSintonizador_TDT() {
		return sintonizador_TDT;
	}
	
	public void setResolucion(double resolucion) {
		this.resolucion = resolucion;
	}
	
	public void setSintonizador_TDT(boolean sintonizador_TDT) {
		this.sintonizador_TDT = sintonizador_TDT;
	}
	
	public double precioFinal() {
		double precio_final = super.precioFinal();
		if(resolucion > 40) {
			precio_final = precio_final * 30 / 100;
		}
		
		if (sintonizador_TDT == true) {
			precio_final += 50;
		}
		return precio_final;
	}
}
