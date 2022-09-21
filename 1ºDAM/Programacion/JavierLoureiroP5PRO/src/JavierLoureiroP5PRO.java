import java.util.ArrayList;
import java.util.Scanner;
public class JavierLoureiroP5PRO {
	public static void main(String args[]) {
		Scanner scan = new Scanner (System.in);
		String select;
		boolean exit = false;
		ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();
		inmuebles.add(new Casa(new Direccion(Direccion.tipo_vias.Carretera, "de Soutomaior", 9, 25204), 5, 132, 200000, 0, true, false, true, true, true));
		inmuebles.add(new Piso(new Direccion(Direccion.tipo_vias.Avenida, "de las Palmeras", 76, 88104), 3, 105, 130000, 750, true, true, true, 7, "K", false));
		inmuebles.add(new Piso(new Direccion(Direccion.tipo_vias.Plaza, "Mayor", 8, 13201), 2, 72, 105000, 0, true, false, true, 2, "D", false));
		inmuebles.add(new Casa(new Direccion(Direccion.tipo_vias.Carretera, "do Morrazo", 15, 77526), 2, 70, 120000, 0, false, false, true, true, false));
		inmuebles.add(new Casa(new Direccion(Direccion.tipo_vias.Paseo, "del agua", 3, 54802), 4, 109, 170000, 0, true, false, true, true, true));
		inmuebles.add(new Piso(new Direccion(Direccion.tipo_vias.Calle, "Gran Via", 105, 31907), 1, 39, 0, 350, false, true, false, 4, "B", true));
		inmuebles.add(new Casa(new Direccion(Direccion.tipo_vias.Calle, "Joquin Bermudez", 97, 65309), 2, 76, 0, 520, false, true, false, false, false));
		inmuebles.add(new Casa(new Direccion(Direccion.tipo_vias.Camino, "das Meigas", 14, 76404), 3, 95, 150000, 600, true, true, true, true, false));
		inmuebles.add(new Piso(new Direccion(Direccion.tipo_vias.Avenida, "de Florida", 35, 48201), 1, 42, 0, 370, false, false, true, 3, "C", true));
		inmuebles.add(new Piso(new Direccion(Direccion.tipo_vias.Calle, "Barcelona", 57, 36203), 3, 94, 120000, 0, true, false, true, 1, "A", false));
		Agencia Agencia = new Agencia ("Agencia", inmuebles);
		
		do {
			System.out.println("\nBienvenido a Agencia Inmobiliaria, seleccione una opci�n: ");
			System.out.println("1/A�adir un nuevo inmueble a la lista");
			System.out.println("2/Modificar un inmueble existente");
			System.out.println("3/Listar inmuebles disponibles");
			System.out.println("4/Listar dentro de un rango de precio");
			System.out.println("5/Listar dentro de un rango de tama�o");
			System.out.println("6/Eliminar un inmueble de la lista");
			System.out.println("0/Cerrar el programa");
			select = scan.nextLine();
			switch(select) {
			case"1": 
				Agencia.nuevo_inmueble();
				break;
			case"2":
				Agencia.modificar_inmueble();
				break;
			case"3":
				Agencia.listarInmuebles();
				break;
			case"4":
				Agencia.rangoPrecio();
				break;
			case"5":
				Agencia.rangoTama�o();
				break;
			case"6":
				Agencia.eliminarInmueble();
				break;
			case"0":
				exit = true;
				break;
			default:
				System.out.println("Seleccione una opci�n v�lida.");
			}
	} while (exit != true);
		System.out.println("Cerrando el programa.");
		scan.close();
	}
}