package modelo;

public class Planta extends Articulo{
	private String nombre_planta;
	private String nombre_cientifico;
	private boolean flor;
	private String caracteristicas_regadio;
	
	public Planta() {
		super();
		this.nombre_planta = "";
		this.nombre_cientifico = "";
		this.flor = false;
		this.caracteristicas_regadio = "";
	}
	
	public Planta(int codigo_articulo,  String nombre_planta, String nombre_cientifico, boolean flor, String caracteristicas_regadio, int stock, double precio) {
		super(codigo_articulo, stock, precio);
		this.nombre_planta = nombre_planta;
		this.nombre_cientifico = nombre_cientifico;
		this.flor = flor;
		this.caracteristicas_regadio = caracteristicas_regadio;
	}

	public String getNombre_planta() {
		return nombre_planta;
	}

	public void setNombre_planta(String nombre_planta) {
		this.nombre_planta = nombre_planta;
	}

	public String getNombre_cientifico() {
		return nombre_cientifico;
	}

	public void setNombre_cientifico(String nombre_cientifico) {
		this.nombre_cientifico = nombre_cientifico;
	}

	public boolean isFlor() {
		return flor;
	}

	public void setFlor(boolean flor) {
		this.flor = flor;
	}

	public String getCaracteristicas_regadio() {
		return caracteristicas_regadio;
	}

	public void setCaracteristicas_regadio(String caracteristicas_regadio) {
		this.caracteristicas_regadio = caracteristicas_regadio;
	}

	@Override
	public String toString() {
		return  nombre_planta + super.toString()  + " nombre_cientifico: " + nombre_cientifico
				+ " Riego: " + caracteristicas_regadio;
	}
}