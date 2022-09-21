package Ejer5;

public class Agua extends Bebida {
	private String origen;
		
	public Agua() {
		super();
		this.origen = "";
	}
	
	public Agua(String origen) {
		super();
		this.origen = origen;
	}
	
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
}
