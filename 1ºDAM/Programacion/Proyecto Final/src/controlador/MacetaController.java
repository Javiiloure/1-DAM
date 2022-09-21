package controlador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import modelo.Maceta;
import modelo.Maceta.Color;
import modelo.Maceta.Material;
import vista.Main;
public class MacetaController {
	
	public static void aņadirMaceta(int stock, double precio, int alto_cm, int diametro_cm, String color_string, String material_string, boolean exterior) throws SQLException {
		ArticuloController.aņadirArticulo(stock, precio);
		Maceta.Color color = Color.valueOf(color_string);
		Maceta.Material material = Material.valueOf(material_string);
		Statement s = Main.conexion.getConection().createStatement();
		String query = "SELECT codigo_articulo FROM articulo ORDER BY codigo_articulo DESC LIMIT 1";
		ResultSet rs = s.executeQuery(query);
		rs.next();
		int codigo_maceta = rs.getInt(1);
		PreparedStatement ps = Main.conexion.getConection().prepareStatement("insert into maceta (codigo_maceta, alto_cm, diametro_cm, color, material, exterior) values(?,?,?,?,?,?);");
		ps.setInt(1, codigo_maceta);
		ps.setInt(2, alto_cm);
		ps.setInt(3, diametro_cm);
		ps.setString(4, color_string);
		ps.setString(5,  material_string);
		ps.setBoolean(6, exterior);
		ps.execute();
		ps.close();
		Maceta maceta = new Maceta(codigo_maceta, stock , precio, alto_cm, diametro_cm, color, material, exterior);
		ArticuloController.macetas.add(maceta);
	}
	
	public static void borrarMaceta(int codigo_maceta) throws SQLException {
		Statement s = Main.conexion.getConection().createStatement();
		String query = "DELETE FROM maceta WHERE codigo_maceta = " + codigo_maceta + ";";
		s.executeUpdate(query);
		s.close();
	}
	
	public static void modificarAltura (int alto_cm, int codigo_maceta) throws SQLException {
		PreparedStatement ps = Main.conexion.getConection().prepareStatement("update maceta set alto_cm = ? where codigo_maceta = ?");
		ps.setInt(1, alto_cm);
		ps.setInt(2, codigo_maceta);
		ps.execute();
		ps.close();
		for(int i = 0; i < ArticuloController.macetas.size(); i++) {
			if(ArticuloController.macetas.get(i).getCodigo_articulo() == codigo_maceta) {
				ArticuloController.macetas.get(i).setAlto_cm(alto_cm);
				break;
			}
		}
	}
	
	public static void modificarDiametro(int diametro_cm, int codigo_maceta) throws SQLException {
		PreparedStatement ps = Main.conexion.getConection().prepareStatement("update maceta set diametro_cm = ? where codigo_maceta = ?");
		ps.setInt(1, diametro_cm);
		ps.setInt(2, codigo_maceta);
		ps.execute();
		ps.close();
		for(int i = 0; i < ArticuloController.macetas.size(); i++) {
			if(ArticuloController.macetas.get(i).getCodigo_articulo() == codigo_maceta) {
				ArticuloController.macetas.get(i).setAncho_cm(diametro_cm);
				break;
			}
		}
	}
	
	public static void modificarColor(String color_string, int codigo_maceta) throws SQLException{
		PreparedStatement ps = Main.conexion.getConection().prepareStatement("update maceta set color = ? where codigo_maceta = ?");
		ps.setString(1, color_string);
		ps.setInt(2, codigo_maceta);
		ps.execute();
		ps.close();
		for(int i = 0; i < ArticuloController.macetas.size(); i++) {
			if(ArticuloController.macetas.get(i).getCodigo_articulo() == codigo_maceta) {
				ArticuloController.macetas.get(i).setColor(Maceta.Color.valueOf(color_string));
				break;
			}
		}
	}
		
	public static void modificarMaterial(String material, int codigo_maceta) throws SQLException {
		PreparedStatement ps = Main.conexion.getConection().prepareStatement("update maceta set material = ? where codigo_maceta = ?");
		ps.setString(1, material);
		ps.setInt(2, codigo_maceta);
		ps.execute();
		ps.close();
		for (int i = 0; i < ArticuloController.macetas.size(); i++) {
			if(ArticuloController.macetas.get(i).getCodigo_articulo() == codigo_maceta) {
				ArticuloController.macetas.get(i).setMaterial(Maceta.Material.valueOf(material));
				break;
			}
		}
	}
	
	public static void modificarExterior(boolean exterior, int codigo_maceta) throws SQLException{
		PreparedStatement ps = Main.conexion.getConection().prepareStatement("update maceta set exterior = ? here codigo_maceta = ?");
		ps.setBoolean(1, exterior);
		ps.setInt(2, codigo_maceta);
		ps.execute();
		ps.close();
		for(int i = 0; i < ArticuloController.macetas.size(); i++) {
			if(ArticuloController.macetas.get(i).getCodigo_articulo() == codigo_maceta) {
				ArticuloController.macetas.get(i).setExterior(exterior);
			}
		}
		
	}
}
