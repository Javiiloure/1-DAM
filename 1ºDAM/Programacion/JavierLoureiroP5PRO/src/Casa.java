
public class Casa extends Inmueble {

	public boolean jardin;
	public boolean piscina;
	
	public Casa() {
		super();
		this.jardin = false;
		this.piscina = false;
	}

	public Casa(Direccion direccion,int n_habitaciones, int m2, double precio_venta, double precio_alquiler, boolean garaje, boolean alquiler, boolean venta, boolean jardin, boolean piscina) {
		super(direccion, n_habitaciones, m2, precio_venta, precio_alquiler, garaje, alquiler, venta);
		this.jardin = jardin;
		this.piscina = piscina;
	}

	public boolean getJardin() {
		return jardin;
	}

	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}

	public boolean getPiscina() {
		return piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}
	
	@Override
	public String toString() {
		return "\nId: " + super.id + " -- Casa" + "\nDireccion: " + super.direccion.toString() + " " + direccion.getCP() + "\nNumero de habitaciones: " + super.n_habitaciones 
				+ "\nTama�o: " + super.m2 + "\nDisponibilidad de garaje: " + super.garaje + "\nDisponibilidad de alquiler: " + super.alquiler
				+ "\nDisponibilidad de venta: " + super.venta + "\nPrecio de alquiler: " + super.precio_alquiler + "\nPrecio de venta: " + super.precio_venta + 
				"\nJardin: " + this.jardin + "\nPiscina: " + this.piscina;
	}

}
