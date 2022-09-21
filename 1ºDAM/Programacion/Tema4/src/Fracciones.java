
public class Fracciones {
	int num;
	int den;
	
	public Fracciones () {
		this.num = 0;
		this.den = 0;
	}
	
	public Fracciones (int num, int den) {
		this.num = num;
		this.den = den;
	}
	
	public void setNum (int num) {
		this.num = num;
	}
	
	public void setDen( int den) {
		this.den = den;
	}
	
	public int getNum () {
		return num;
	}
	
	public int getDen () {
		return den;
	}
	
	public int mcd(){
	     int u = Math.abs(num);                                                                                       
	     int v = Math.abs(den);
	     if(v == 0){
	          return u;
	     }
	     int r;
	     while(v != 0){
	          r = u % v;
	          u = v;
	          v = r;
	     }
	     return u;
	}
			
	public int suma (int num1, int den1, int num2, int den2) {
		
		int mcd1 = mcd(num1, num2);
		num1 = num1 / mcd1;
		den1 = den1 / mcd1;
		int mcd2 = mcd(num2, den2);
		num2 = num2 / mcd2;
		den2 = den2 / mcd2;
		
		if(den1 != den2) {
			System.out.println("Las fracciones no se pueden sumar.");
		} else {
			int num3 = num1 + num2;
		}
	}
	
	public int resta (int a, int b, int x, int y) {
		int resta = 0;
		if (b == y) {
			resta = a - x;
			return resta;
		} else {
			System.out.println("Las fracciones deben tener el mismo denominador.");
			return b;
		}
	}
	
	public int multiplicación (int a, int b, int x, int y) {
		
	}
}