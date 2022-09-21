package controlador;
import modelo.Planta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import vista.Main;
public class PlantaController  {
	
	public static void añadirPlanta(int stock, double precio, String nombre_planta, String nombre_cientifico,boolean flor, String caracteristicas_regadio) throws SQLException {
		ArticuloController.añadirArticulo(stock, precio);
		Statement s = Main.conexion.getConection().createStatement();
		String query = "SELECT codigo_articulo FROM articulo ORDER BY codigo_articulo DESC LIMIT 1";
		ResultSet rs = s.executeQuery(query);
		rs.next();
		int codigo_planta = rs.getInt(1);
		PreparedStatement ps = Main.conexion.getConection().prepareStatement("insert into planta(codigo_planta, nombre_planta, nombre_cientifico, flor, caracteristicas_regadio) values (?,?,?,?,?)");
		ps.setInt(1, codigo_planta);
		ps.setString(2, nombre_planta);
		ps.setString(3, nombre_cientifico);
		ps.setBoolean(4, flor);
		ps.setString(5, caracteristicas_regadio);
		ps.executeUpdate();
		ps.close();
		Planta planta = new Planta(codigo_planta, nombre_planta, nombre_cientifico, flor, caracteristicas_regadio, stock, precio);
		ArticuloController.plantas.add(planta);
	}
	
	public static void modificarNombre(String nombre_planta, int codigo_planta) throws SQLException {
		PreparedStatement ps = Main.conexion.getConection().prepareStatement("update planta set nombre_planta = ? where codigo_planta = ?");
		ps.setString(1, nombre_planta);
		ps.setInt(2, codigo_planta);
		ps.execute();
		ps.close();
		for(int i = 0; i < ArticuloController.plantas.size(); i++) {
			if(ArticuloController.plantas.get(i).getCodigo_articulo() == codigo_planta) {
				ArticuloController.plantas.get(i).setNombre_planta(nombre_planta);
				break;
			} else {
				System.out.println("El codigo del articulo no ha sido encontrado.");
			}
		}
	}
	
	public static void modificarNombreCientifico(String nombre_cientifico, int codigo_planta) throws SQLException{
		PreparedStatement ps = Main.conexion.getConection().prepareStatement("update planta set nombre_cientifico = ? where codigo_planta = ?");
		ps.setString(1, nombre_cientifico);
		ps.setInt(2, codigo_planta);
		ps.execute();
		ps.close();
		for(int i = 0; i < ArticuloController.plantas.size(); i++) {
			if(ArticuloController.plantas.get(i).getCodigo_articulo() == codigo_planta) {
				ArticuloController.plantas.get(i).setNombre_cientifico(nombre_cientifico);
			}
		}
	}
	
	public static void modificarFlor(boolean flor, int codigo_planta) throws SQLException {
		PreparedStatement ps = Main.conexion.getConection().prepareStatement("update planta set flor = ? where codigo_planta = ?");
		ps.setBoolean(1, flor);
		ps.setInt(2, codigo_planta);
		ps.execute();
		ps.close();
		for(int i = 0; i < ArticuloController.plantas.size(); i++) {
			if(ArticuloController.plantas.get(i).getCodigo_articulo() == codigo_planta) {
				ArticuloController.plantas.get(i).setFlor(flor);
			}
		}
	}
	
	public static void modificarCaracteristicasRegadio(String caracteristicas_regadio, int codigo_planta) throws SQLException {
		PreparedStatement ps = Main.conexion.getConection().prepareStatement("update planta set caracteristicas_regadio = ? where codigo_planta = ?");
		ps.setString(1, caracteristicas_regadio);
		ps.setInt(2, codigo_planta);
		ps.close();
		ps.execute();
		for(int i = 0; i < ArticuloController.plantas.size(); i++ ) {
			if(ArticuloController.plantas.get(i).getCodigo_articulo() == codigo_planta) {
				ArticuloController.plantas.get(i).setCaracteristicas_regadio(caracteristicas_regadio);
			}
		}
 	}
	
	public static void borrarPlanta(int codigo_planta) throws SQLException {
		Statement s = Main.conexion.getConection().createStatement();
		String query = "DELETE FROM planta WHERE codigo_planta = " + codigo_planta + ";";
		s.executeUpdate(query);
		s.close();
	}
}
