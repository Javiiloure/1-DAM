
public class Contador {
	int cont;
	
	public Contador () {
		this.cont = 0;
	}
	
	public Contador (int cont) {
		this.cont = cont;
		if (cont < 0) {
			this.cont = 0;
		}
	}
	
	public void setCont (int cont) {
		this.cont = cont;
	}
	
	public int getCont () {
		return cont;
	}
	
	public void incrementar () {
		setCont(getCont()+1);
	}
	
	public int decrementar () {
		setCont(getCont()-1);
		if (this.cont < 0) {
			this.cont = 0;
		}
		return cont;
	}
}