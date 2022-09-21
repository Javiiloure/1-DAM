interface Impuestos {
	public double impuestosVenta(double precio);
	public double impuestosAlquiler(double precio);
	public static final int IVA = 10;
	public static final int ITP = 8;
}

public abstract class Inmueble implements Impuestos {

	public static int idActual = 1;
	public int id;
	public Direccion direccion;
	public int n_habitaciones;
	public int m2;
	public boolean garaje;
	public boolean alquiler;
	public boolean venta;
	public double precio_venta;
	public double precio_alquiler;

	public Inmueble() {
		this.id = 0;
		this.direccion = new Direccion();
		this.n_habitaciones = 0;
		this.m2 = 0;
		this.precio_venta = 0;
		this.precio_alquiler = 0;
		this.garaje = false;
		this.alquiler = false;
		this.venta = false;
	}

	public Inmueble(Direccion direccion, int n_habitaciones, int m2, double precio_venta, double precio_alquiler,
			boolean garaje, boolean alquiler, boolean venta) {
		this.id = idActual++;
		this.direccion = direccion;
		this.n_habitaciones = n_habitaciones;
		this.m2 = m2;
		this.precio_venta = impuestosVenta(precio_venta);
		this.precio_alquiler = impuestosAlquiler(precio_alquiler);
		this.garaje = garaje;
		this.alquiler = alquiler;
		this.venta = venta;
	}

	public boolean getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(boolean alquiler) {
		this.alquiler = alquiler;
		if (alquiler == false) {
			this.precio_alquiler = 0;
		}
	}

	public boolean getVenta() {
		return venta;
	}

	public void setVenta(boolean venta) {
		this.venta = venta;
		if (venta == false) {
			this.precio_venta = 0;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public int getN_habitaciones() {
		return n_habitaciones;
	}

	public void setN_habitaciones(int n_habitaciones) {
		this.n_habitaciones = n_habitaciones;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = impuestosVenta(precio_venta);
	}

	public double getPrecio_alquiler() {
		return precio_alquiler;
	}

	public void setPrecio_alquiler(double precio_alquiler) {
		this.precio_alquiler = impuestosAlquiler(precio_alquiler);
	}

	public boolean isGaraje() {
		return garaje;
	}

	public void setGaraje(boolean garaje) {
		this.garaje = garaje;
	}

	@Override
	public String toString() {
		if (this instanceof Piso) {
			Piso piso = (Piso) this;
			return piso.toString();
		} else {
			Casa casa = (Casa) this;
			return casa.toString();

		}
	}

	// Implementacion de los metodos de la interfaz

	public double impuestosVenta(double precio) {
		double precio_final = 0;
		precio_final = precio + ((precio * IVA) / 100) + ((precio * ITP) / 100);
		return precio_final;
	}

	public double impuestosAlquiler(double precio) {
		double precio_final;
		precio_final = precio + ((precio * ITP) / 100);
		return precio_final;
	}
}
