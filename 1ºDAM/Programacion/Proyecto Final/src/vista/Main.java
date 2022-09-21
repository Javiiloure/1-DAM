package vista;

import bbdd.BDConnection;
import modelo.ErroresXml;

import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	public static BDConnection conexion = new BDConnection();

	public static void main(String[] args) {

		String select;
		boolean exit = false;
		conexion.startConnection();
		ErroresXml xmlErrores = new ErroresXml();

		try {
			do {
				System.out.println("Seleccione una opción: \n1/Gestión de floristería \n2/Cerrar el programa");
				select = scan.nextLine();
				switch (select) {
				case "1":
					// throw new IOException("error de prueba");
					ArticuloVista.gestionArticulos();
					break;
				case "2":
					exit = true;
					xmlErrores.crearErrXml();
					break;
				default:
					System.out.println("Seleccione una opción válida.");
				}
			} while (exit != true);
		} catch (IOException e) {
			xmlErrores.escribirErr(e);
			xmlErrores.crearErrXml();
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			xmlErrores.escribirErr(e);
			xmlErrores.crearErrXml();
			System.out.println(e.getMessage());
		}
		conexion.endConnection();
	}
}
