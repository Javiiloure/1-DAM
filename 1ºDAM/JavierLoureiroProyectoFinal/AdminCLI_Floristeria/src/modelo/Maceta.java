package modelo;

public class Maceta extends Articulo {
	private int alto_cm;
	private int diametro_cm;
	private boolean exterior;
	private Color color;
	private Material material;
	public enum Color {
		Blanco, Negro, Gris, Verde, Rojo, Azul, Marron, Amarillo, Violeta, Naranja
	}
	public enum Material {
		Plastico, Arcilla, Piedra, Madera, Cemento, Fibrocemento
	}
	
	public Maceta(int codigo_articulo, int stock, double precio, int alto_cm, int diametro_cm, Color color, Material material, boolean exterior) {
		super(codigo_articulo, stock, precio);
		this.alto_cm = alto_cm;
		this.diametro_cm = diametro_cm;
		this.exterior = exterior;
		this.color = color;
		this.material = material;
	}
	
	public Maceta() {
		super();
		this.alto_cm = 0;
		this.diametro_cm = 0;
		this.color = Color.Blanco;
		this.material = Material.Plastico;
	}

	public int getAlto_cm() {
		return alto_cm;
	}

	public void setAlto_cm(int alto_cm) {
		this.alto_cm = alto_cm;
	}

	public int getAncho_cm() {
		return diametro_cm;
	}

	public void setAncho_cm(int ancho_cm) {
		this.diametro_cm = ancho_cm;
	}

	public boolean isExterior() {
		return exterior;
	}

	public void setExterior(boolean exterior) {
		this.exterior = exterior;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public String toString() {
		if(exterior == true) {
			return "Maceta " + super.toString() + " Altura: " + alto_cm + "cm" + " diametro:" + diametro_cm + "cm" +" maceta de exterior"  + " color:"
				+ color + " material: " + material;
		} else {
			return "Maceta " + super.toString() + " Altura: " + alto_cm + "cm" + " diametro:" + diametro_cm + "cm" +" maceta de interior"  + " color:"
					+ color + " material: " + material;
		}
		
	}
}
