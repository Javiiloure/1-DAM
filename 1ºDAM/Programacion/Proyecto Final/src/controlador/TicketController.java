package controlador;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vista.Main;
public class TicketController {

	public static void resumenTickets() throws SQLException {
		Statement s = Main.conexion.getConection().createStatement();
		String query = "select t.codigo_ticket, t.fecha_hora, ta.articulo, ta.unidades from ticket t "
				+ "join ticket_articulo ta on t.codigo_ticket = ta.ticket order by t.fecha_hora desc";
		ResultSet rs = s.executeQuery(query);
		while(rs.next()) {
			System.out.println("Codigo ticket: " + rs.getInt(1) + " Fecha/Hora:" + rs.getString(2) + 
					" Codigo articulo: " + rs.getInt(3) + " Unidades: " + rs.getInt(4));
		}
	}
	
	public static void articulosMasVendidos() throws SQLException {
		Statement s = Main.conexion.getConection().createStatement();
		String query = "select ta.articulo, (select sum(ta.unidades) from ticket_articulo ta where ta.articulo = a.codigo_articulo) as unidades_totales from articulo a join ticket_articulo ta"
				+ " on a.codigo_articulo = ta.articulo order by unidades desc limit 5";
		ResultSet rs = s.executeQuery(query);
		while(rs.next()) {
			System.out.println("Articulo: " + rs.getInt(1) + " unidades totales: " + rs.getInt(2));
		}
	}
}
