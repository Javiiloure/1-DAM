package Ejer5;

public class Azucarada extends Bebida {
	
	public int porcentaje_azucar;
	public boolean promocion;
	
	public Azucarada() {
		super();
		this.porcentaje_azucar = 0;
		this.promocion = false;
	}
	
	public Azucarada(int porcentaje_azucar, boolean promocion) {
		super();
		this.porcentaje_azucar = porcentaje_azucar;
		if (promocion == true) {
			this.promocion = promocion;
			double precio = (super.getPrecio() * 10) / 100; //Duda dani precio o double precio
			super.setPrecio(precio);
		} else {
			this.promocion = false;
		}
	}
	
	public int getPorcentaje_azucar() {
		return porcentaje_azucar;
	}
	public void setPorcentaje_azucar(int porcentaje_azucar) {
		this.porcentaje_azucar = porcentaje_azucar;
	}
	public boolean isPromocion() {
		return promocion;
	}
	public void setPromocion(boolean promocion) {
		this.promocion = promocion;
	}
	
}
