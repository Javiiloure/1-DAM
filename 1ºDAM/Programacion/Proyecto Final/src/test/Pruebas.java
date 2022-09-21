package test;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import controlador.MacetaController;
import controlador.PlantaController;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vista.Main;

public class Pruebas {
	@Test
	void añadirPlantaTest() throws SQLException {
		int stock = 1;
		double precio = 1.99;
		String nombre_planta = "Planta";
		String nombre_cientifico = "Plantus";
		boolean flor = false;
		String caracteristicas_regadio = "No se riega";

		Main.conexion.startConnection();
		PlantaController.añadirPlanta(stock, precio, nombre_planta, nombre_cientifico, flor, caracteristicas_regadio);

		Statement s = Main.conexion.getConection().createStatement();
		String query = "select p.*, a.stock, a.precio from planta p join articulo a on p.codigo_planta = a.codigo_articulo order by codigo_planta desc limit 1";
		ResultSet rs = s.executeQuery(query);

		rs.next();
		assertEquals(stock, rs.getInt(6));
		assertEquals(precio, rs.getDouble(7), 0);
		assertEquals(nombre_planta, rs.getString(2));
		assertEquals(nombre_cientifico, rs.getString(3));
		assertEquals(flor, rs.getBoolean(4));
		assertEquals(caracteristicas_regadio, rs.getString(5));
	}

	@Test
	void añadirMacetaTest() throws SQLException {
		int stock = 5;
		double precio = 5.99;
		int alto_cm = 20;
		int diametro_cm = 20;
		String color = "Blanco";
		String material = "Cemento";
		boolean exterior = false;

		Main.conexion.startConnection();
		MacetaController.añadirMaceta(stock, precio, alto_cm, diametro_cm, color, material, exterior);

		Statement s = Main.conexion.getConection().createStatement();
		String query = "select m.*, a.stock, a.precio from maceta m join articulo a on m.codigo_maceta = a.codigo_articulo order by codigo_maceta desc limit 1";
		ResultSet rs = s.executeQuery(query);

		rs.next();
		assertEquals(stock, rs.getInt(7));
		assertEquals(precio, rs.getDouble(8), 0);
		assertEquals(alto_cm, rs.getInt(2));
		assertEquals(diametro_cm, rs.getInt(3));
		assertEquals(color, rs.getString(4));
		assertEquals(material, rs.getString(5));
		assertEquals(exterior, rs.getBoolean(6));
		// Main.conexion.endConnection();
	}

	@Test
	void borrarPlantaTest() throws SQLException {
		int codigo_planta = 9;
		PlantaController.borrarPlanta(codigo_planta);
		Statement s = Main.conexion.getConection().createStatement();
		String query = "select codigo_planta from planta";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			assertNotEquals(codigo_planta, rs.getInt(1));
		}
	}

	@Test
	void borrarMacetaTest() throws SQLException {
		int codigo_maceta = 13;
		MacetaController.borrarMaceta(codigo_maceta);
		Statement s = Main.conexion.getConection().createStatement();
		String query = "select codigo_maceta from maceta";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			assertNotEquals(codigo_maceta, rs.getInt(1));
		}
	}
}
