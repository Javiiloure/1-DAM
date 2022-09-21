
public class Persona {
	
	String nombre;
	String direccion;
	int codigoPostal;
	String ciudad;
	Fecha fechaNacimiento;
	
	public Persona() {
		this.nombre = "";
		this.direccion = "";
		this.codigoPostal = 0;
		this.ciudad = "";
		this.fechaNacimiento = new Fecha();
	}
	
	public Persona(String nombre, String direccion, int codigoPostal, String ciudad, int dia, int mes, int año) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.fechaNacimiento = new Fecha(dia, mes, año);
	}
	
	public String getnombre() {
		return this.ciudad;
	}
	
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getdireccion() {
		return this.direccion;
	}
	
	public void setdireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public int getcodigoPostal() {
		return this.codigoPostal;
	}
	
	public void setcodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public String getciudad() {
		return this.ciudad;
	}
	
	public void setciudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public Fecha getfechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public void setfechaNacimiento(Fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
