import java.util.ArrayList;
import java.util.Scanner;

public class JavierLoureiroP4PRO {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String select;
		boolean exit = false;
		ArrayList<Piso> pisos = new ArrayList<Piso>();
		pisos.add(new Piso("Vigo","Pi i Margal", 50, 6, 'A', 36203, 42, 0, 250, false, true));
		pisos.add(new Piso("Madrid","Gran Via", 152, 10, 'C', 28001, 160, 0, 1500, false, true));
		pisos.add(new Piso("Pontevedra", "Xan Guillermo", 14, 4, 'D', 36107, 70, 0, 350, false, true));
		pisos.add(new Piso("A Coruña", "Conde Sanchez", 50, 12, 'B', 15001, 62, 0, 320, false, true));
		pisos.add(new Piso("Santiago de Compostela", "Rua Horreo", 18, 14, 'K', 15706, 130, 0, 1200, false, true));
		pisos.add(new Piso("Vigo", "Zamora", 20, 4, 'C', 36203, 50, 120000, 0, true, false));
		pisos.add(new Piso("Barcelona", "Gaudi", 62, 9, 'H', 18001, 74, 360000, 0, true, false));
		pisos.add(new Piso("Zaragoza", "Fidel Castro", 69, 7, 'G', 50001, 51, 160000, 0, true, false));
		pisos.add(new Piso("Vilagarcia de Arousa", "Farlopa", 74, 5, 'B', 36600, 40, 80000, 0, true, false));
		pisos.add(new Piso("Ferrol", "Hermanos Dominguez", 42, 10, 'L', 15401, 74, 110000, 0, true, false));
		Agencia agencia = new Agencia("agencia", pisos);
		do {
			System.out.println("Bienvenido agencia inmobiliaria, seleccione una opción: " + "\n1/Añadir nuevo piso."
					+ "\n2/Modificar un piso." + "\n3/Listar pisos existentes."
					+ "\n4/Listar pisos por rango de precios." + "\n5/Listar pisos por rango de tamaño."
					+ "\n6/Eliminar piso de la lista." + "\n0/Salir del programa.");
			select = scan.nextLine();
			switch (select) {
			case "1":
				agencia.añadirPiso();
				break;
			case "2":
				agencia.modificarPiso();
				break;
			case "3":
				agencia.listarPisos();
				break;
			case "4":
				agencia.rangoPrecio();
				break;
			case "5":
				agencia.rangoTamaño();
				break;
			case "6":
				agencia.eliminarPiso();
				break;
			case "0":
				System.out.println("Cerrando el programa.");
				exit = true;
				break;
			default:
				System.out.println("Seleccione una opción válida.");
			}
		} while (exit != true);
	}
}