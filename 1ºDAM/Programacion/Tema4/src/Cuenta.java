import java.util.Scanner;

public class Cuenta {
	static Scanner scan = new Scanner(System.in);
	String nombre;
	String num_cuenta;
	double tipo_interes;
	double saldo;

	public Cuenta() {
		this.nombre = "";
		this.num_cuenta = "";
		this.tipo_interes = 0;
		this.saldo = 0;
	}

	public Cuenta(String nombre, String num_cuenta, double tipo_interes, double saldo) {
		this.nombre = nombre;
		this.num_cuenta = num_cuenta;
		this.tipo_interes = tipo_interes;
		this.saldo = saldo;
	}

	public String getnombre() {
		return nombre;
	}
	
	public void setnombre(String nombre) {
		this.nombre = nombre;
		}
	
	public String num_cuenta () {
		return num_cuenta;
	}
	
	public void setnum_cuenta (String num_cuenta) {
		this.num_cuenta = num_cuenta;
	}
	
	public double gettipo_interes () {
		return tipo_interes;
	}
	
	public void settipo_interes (double tipo_interes) {
		this.tipo_interes = tipo_interes;
	}
	
	public double getSaldo () {
		return saldo;
	}
	
	public void setSaldo (double saldo) {
		this.saldo = saldo;
	}
	
	public boolean ingreso (double ingreso) {
		if(ingreso < 0) {
			System.out.println("La cantidad debe ser positiva.");
			return false;
		} else {
			setSaldo(ingreso + getSaldo());
			return true;
		}
	}
	public boolean reintegro (double retiro) {
		if(retiro > saldo) {
			System.out.println("El retiro debe ser menor que la cantidad de dinero en la cuenta.");
			return false;
		}
		else {
			setSaldo(getSaldo() - retiro);
			return true;
		}
	}
	public void transferencia (Cuenta destino, double importe) {
		if (getSaldo() < importe) {
			System.out.println("El importe a trenferir es mayor que el saldo de la cuenta.");
		} else {
			setSaldo(getSaldo() - importe);
			destino.setSaldo(destino.getSaldo() + importe);
		}
	}
}

