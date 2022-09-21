import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class NetLogger {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String usuario = "";
		int select;
		boolean exit = false;
		while (exit != true) {
			System.out.println("Bienvenido a registro de conexiones, seleccione una opci�n:"
					+ "\n1/Acceder con el usuario del sistema" + "\n2/Acceder creando un nuevo usuario");
			select = scan.nextInt();
			switch (select) {
			case 1:
				usuario = System.getProperty("user.name");
				System.out.println("Accediendo con el usuario del sistema " + usuario);
				exit = true;
				break;
			case 2:
				System.out.println("Introduzca el nuevo usuario: ");
				scan.nextLine();
				usuario = scan.nextLine();
				System.out.println("Accediendo con el usuario " + usuario);
				exit = true;
				break;
			default:
				System.out.println("Opci�n no v�lida.");
			}
		}
		try {
			comprobarEstructura(usuario);
			File err = new File("err.log");
			FileWriter fw = new FileWriter(err, true);
			BufferedWriter bw = new BufferedWriter(fw);
			List<String> comando_netStat = leerResultadoNetStat();
			int ultimo_netstat = getNumeroUltimoNetStat();
			String netStat = "netstat_" + Integer.toString(ultimo_netstat);
			registrarFechaHora(usuario);
			escribirNetStatLog(netStat, comando_netStat);
			bw.close();
		} catch (FileNotFoundException e) {
			escribirEnErrLog(e.getMessage());
		} catch (IOException e) {
			System.err.println("Error de E/S: " + e.getMessage());
			 escribirEnErrLog(e.getMessage());
		}
	}

	public static void comprobarEstructura(String usuario) throws IOException {
		File actividad = new File("actividad");
		File net = new File("net");
		File log = new File("actividad/" + usuario + ".log");
		File err = new File("err.log");
		String usr_name = System.getProperty("user.name");
		File usr = new File("actividad/" + usr_name + ".log");
		File netstat = new File("net/netstat_1.log");

		if (!err.exists()) {
			err.createNewFile();
		}
		if (!actividad.exists()) {
			actividad.mkdir();
			log.createNewFile();
			usr.createNewFile();
		} else {
			if (!log.exists())
				log.createNewFile();
			if (!usr.exists())
				usr.createNewFile();
		}
		if (!net.exists()) {
			net.mkdir();
			netstat.createNewFile();
		} else {
			if (!netstat.exists())
				netstat.createNewFile();
		}
	}

	public static void registrarFechaHora(String usuario) throws IOException {
		File usr = new File("actividad/" + usuario + ".log");
		FileWriter fw = new FileWriter(usr, true);
		BufferedWriter bw = new BufferedWriter(fw);
		if (usr.length() == 0) {
			bw.write("Inicio de sesion: " + getTimeStamp());
			bw.flush();
		} else {
			bw.newLine();
			bw.write("Incio de sesion: " + getTimeStamp());
			bw.flush();
		}
		bw.close();
	}

	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String datetime = formatter.format(date);
		return datetime;
	}

	public static int getNumeroUltimoNetStat() {
		int x = 0;
		File carpeta = new File("net");
		File[] lista = carpeta.listFiles();
		x = lista.length;
		return x;
	}

	public static void escribirNetStatLog(String fichero, List<String> netstat)
			throws FileNotFoundException, IOException {
		File archivo = new File("net/" + fichero + ".log");
		FileWriter fw = new FileWriter(archivo, true);
		BufferedWriter bw = new BufferedWriter(fw);
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		int aux = (int) br.lines().count();
		if (leerNetStatLog(fichero).size() == 0) {
			bw.write(getTimeStamp());
		} else {
			bw.newLine();
			bw.write(getTimeStamp());
		}
		for (int i = 0; i < netstat.size(); i++) {
			if (netstat.get(i) == null)
				break;
			if (199 == aux) {
				archivo = new File("net/netstat_" + Integer.toString(getNumeroUltimoNetStat() + 1) + ".log");
				fw = new FileWriter(archivo, true);
				br.close();
				bw = new BufferedWriter(fw);
				archivo.createNewFile();
				aux = 0;
			} else {
				bw.newLine();
			}
			System.out.println(netstat.get(i));
			bw.write(netstat.get(i));
			bw.flush();
			aux++;
		}
		br.close();
		bw.close();
	}

	public static List<String> leerNetStatLog(String fichero) throws FileNotFoundException, IOException {
		List<String> netStat = new ArrayList<String>();
		File file = new File("net/" + fichero + ".log");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		for (int i = 0; i < br.lines().count(); i++) {
			netStat.add(br.readLine());
		}
		br.close();
		return netStat;
	}

	public static List<String> leerResultadoNetStat() throws IOException {
		List<String> netStat = new ArrayList<String>();
		Process p = Runtime.getRuntime().exec("netstat /a");
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		while (br.readLine() != null) {
			netStat.add(br.readLine());
		}
		return netStat;
	}

	public static void escribirEnErrLog(String mensaje) {
		File err = new File("err.log");
		try {
			FileWriter fw = new FileWriter(err, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(getTimeStamp() + " " + mensaje);
			bw.close();
		} catch (IOException e) {
			System.err.println("Error de E/S: " +  e.getMessage());
		}
	}
}