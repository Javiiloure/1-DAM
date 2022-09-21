
public class Piso {
	private static int idActual = 1;

	int id;
	Direccion direccion;
	int m2;
	double precio_venta;
	double precio_alquiler;
	boolean venta;
	boolean alquiler;

	public Piso() {
		this.id = idActual++;
		this.direccion = new Direccion ("", "", 0, 0,' ', 0);
		this.m2 = 0;
		this.precio_venta = 0;
		this.precio_alquiler = 0;
		this.alquiler = false;
		this.venta = false;
	}

	public Piso(String ciudad, String via, int numero, int piso, char letra, int cp, int m2, double precio_venta, double precio_alquiler, boolean venta,
			boolean alquiler) {
		this.direccion = new Direccion(ciudad, via, numero, piso, letra, cp);
		this.m2 = m2;
		this.precio_venta = precio_venta;
		this.precio_alquiler = precio_alquiler;
		this.venta = venta;
		this.alquiler = alquiler;
		this.id = idActual++;
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

	public void setDireccion(String ciudad, String via, int numero, int piso, char letra, int cp) {
		this.direccion = new Direccion(ciudad, via, numero, piso, letra, cp);
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
		this.precio_venta = precio_venta;
	}

	public double getPrecio_alquiler() {
		return precio_alquiler;
	}

	public void setPrecio_alquiler(double precio_alquiler) {
		this.precio_alquiler = precio_alquiler;
	}

	public boolean getVenta() {
		return venta;
	}

	public void setVenta(boolean venta) {
		this.venta = venta;
	}

	public boolean getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(boolean alquiler) {
		this.alquiler = alquiler;
	}

	@Override
	public String toString() {
		if (venta == true && alquiler == false) {
			return "id: " + id + "\nDireccion: " + direccion.toString() + "\nTama�o:" + m2 + "\nVenta: Disponible"
					+ "\nPrecio venta: " + precio_venta + "\nAlquiler: No disponible \n";
		}
		if (venta == false && alquiler == true) {
			return "id: " + id + "\nDireccion: " + direccion.toString() + "\nTama�o: " + m2 + "\nVenta: No disponible"
					+ "\nAlquier: Disponible" + "\nPrecio alquiler: " + precio_alquiler + "\n";
		}
		if (venta == true && alquiler == true) {
			return "id: " + id + "\nDireccion: " + direccion.toString() + "\nTama�o: " + m2 + "\nVenta: Disponible"
					+ "\nPrecio venta: " + precio_venta + "\nAlquier: Disponible" + "\nPrecio alquiler: "
					+ precio_alquiler + "\n";
		}
		return "El piso debe estar en alquiler o en venta";
	}

//	@Override
//	public int hashCode() {
//	    int hash = 7;
//	    hash = 31 * hash + (direccion == null ? 0 : direccion.hashCode());
//	    hash = 31 * hash + (int) precio;
//	    hash = 31 * hash + (int) m2;
//	    return hash;
//	}
}
