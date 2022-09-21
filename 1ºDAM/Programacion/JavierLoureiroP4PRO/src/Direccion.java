
public class Direccion {
	private String ciudad;
	private String via;
	private int numero;
	private int piso;
	private char letra;
	private int cp;
	
	public Direccion (String ciudad, String via, int numero, int piso, char letra, int cp) {
		this.ciudad = ciudad;
		this.via = via;
		this.numero = numero;
		this.piso = piso;
		this.letra = letra;
		this.cp = cp;
	}
	
	public Direccion () {
		this.ciudad = "";
		this.via = "";
		this.numero = 0;
		this.piso = 0;
		this.cp = 0;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getVia() {
		return via;
	}
	
	public void setVia(String via) {
		this.via = via;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getPiso() {
		return piso;
	}
	
	public void setPiso(int piso) {
		this.piso = piso;
	}
	
	public char getLetra() {
		return letra;
	}
	
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	public int getCp() {
		return cp;
	}
	
	public void setCp(int cp) {
		this.cp = cp;
	}
	
	@Override
	public String toString() {
		return ciudad + " calle " + via + " nº" + numero + " " + piso + letra + " Cp: " + cp;
	}
}
