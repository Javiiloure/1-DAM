import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Tema6 {
	static Scanner scan = new Scanner(System.in);
	//Ejercicio 1
	/*
	public static void main(String[] args) {
		String ruta = "C:/Users/javie/Desktop/Programacion/Tema6/Prueba.txt";
		String contenido = "Esto es una prueba";
		File archivo = new File(ruta);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
				fw = new FileWriter(ruta, true);
				fw.write(contenido);
				fw.flush();
			}
			fr = new FileReader(ruta);
			br = new BufferedReader(fr);
			String cadena = br.readLine();
			cadena = cadena.replaceAll(" ", "");
			System.out.println(cadena);
		} catch (EOFException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	*/
	
	/*
	// Ejercicio 2
	public static void main(String[] args) {
		String ruta;
		String contenido;
		ruta = JOptionPane.showInputDialog("Introduzca la ruta del archivo:");
		contenido = JOptionPane.showInputDialog("Introduzca el texto:");
		mostrarContenido(contenido);
		escribirArchivo(ruta, contenido);
	}

	public static void mostrarContenido(String contenido) {
		String aux = "";
		for (int i = 0; i < contenido.length(); i++) {
			if (Character.isLowerCase(contenido.charAt(i))) {
				aux += Character.toUpperCase(contenido.charAt(i));
			} else if (Character.isUpperCase(contenido.charAt(i))) {
				aux += Character.toLowerCase(contenido.charAt(i));
			} else {
				aux += contenido.charAt(i);
			}
		}
		System.out.println(aux);
	}

	public static void escribirArchivo(String ruta, String contenido) {
		File archivo = new File(ruta);
		FileWriter fw = null;
		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
				fw = new FileWriter(ruta, true);
				fw.write(contenido);
				fw.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				} else {
					System.out.println("Archivo guardado.");
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	*/
	
	/*
	//Ejercicio 3
	public static void main(String[] args) {
		String ruta;
		String contenido;
		File archivo;
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;

		System.out.println("Introduzca la ruta del fichero: ");
		ruta = scan.nextLine();
		archivo = new File(ruta);
		contenido = JOptionPane.showInputDialog("Introduzca el contenido del archivo: ");
		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
				System.out.println("Archivo creado correctamente");
			}
			fw = new FileWriter(ruta, true);
			fw.write(contenido);
			fw.flush();
			System.out.println("Archivo modificado correctamente.");
			contenido = "";
			fr = new FileReader(ruta);
			br = new BufferedReader(fr);
			while ((contenido = br.readLine()) != null) {
				System.out.println(contenido);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				if(fw != null) {
					fw.close();
				}
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	*/
	
	/*
	//Ejercicio4
	public static void main(String[] args) {
		try {
			String ruta = args[0];
			try {
				File archivo = new File(ruta);
				FileReader fr = new FileReader(ruta);
				BufferedReader br = new BufferedReader(fr);
				if (archivo.exists()) {
					System.out.println("El archivo ya estaba creado.");
					int palabras = 0;
					String linea;
					while ((linea = br.readLine()) != null) {
						for (int i = 0; i < linea.length(); i++) {
							if (i == 0) {
								if (linea.charAt(i) != ' ') {
									palabras++;
								}
							} else {
								if (linea.charAt(i - 1) == ' ') {
									if (linea.charAt(i) != ' ') {
										palabras++;
									}
								}
							}
						}
					}
					System.out.println("El archivo contiene " + palabras + " palabras.");
					br.close();
				} else {
					System.out.println("El archivo no existe.");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No existen argumentos");
		}
	}
	*/
	 
	/*
	//Ejercicio 5
	public static void main(String[] args) {
		
		String origen = JOptionPane.showInputDialog("Escribe la ruta original: "); 
		String destino = JOptionPane.showInputDialog("Escriba la ruta de destino: ");
	
		try  {
			FileInputStream fis = new FileInputStream(origen);
			FileOutputStream fos = new FileOutputStream(destino);
			byte bytes[] = new byte[fis.available()];
			fis.read(bytes);
			fos.write(bytes);
			fis.close();
			fos.close();
		}
		catch(IOException e) {
			System.err.println(e.getMessage());
		}
		catch(Exception e)  {
			System.err.println(e.getMessage());
		}
	}
	*/
	
	/*
	// Ejercicio 6
	public static void main(String[] args) {
		int cantidad = 0;
		boolean exit = false;
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream("Prueba.txt"));
			DataInputStream in = new DataInputStream(new FileInputStream("Prueba.txt"));
			while (exit != true) {
			System.out.println("Introduzca la cantidad de numeros a a�adir: ");
			cantidad = scan.nextInt();
			if (cantidad > 0) {
				exit = true;
			}
			escribirArchivo(cantidad, out);
			leerArchivo(in);
			}
		}
		catch(FileNotFoundException e){
			System.err.println("El archivo no se ha encontrado o no existe.");
		}
	}
	
	public static void escribirArchivo(int cantidad, DataOutputStream out) {
		int numero;
		try {
			for (int i = 0; i < cantidad; i++) {
				numero = (int) (Math.random() * 100 + 0);
				out.writeInt(numero);
			}
		} catch (IOException e) {
			System.out.println("Error de E/S.");
		}
	}

	public static void leerArchivo(DataInputStream in) {
		try {
			while(true) {
				System.out.println(in.readInt());
			}
		}
		catch (IOException e){
			System.out.println("Fin del archivo");
		}
	}
	*/
	
	//Ejercicio7
	public static void main(String [] args) {
		String matricula;
		String marca;
		double deposito;
		String modelo;
		System.out.println("Introduzca la matricula del vehiculo:");
		matricula = scan.nextLine();
		System.out.println("Introduzca la marca del vehiculo: ");
		marca = scan.nextLine();
		System.out.println("Introduzca el tama�o del deposito: ");
		deposito = Double.parseDouble(scan.nextLine());
		System.out.println("Introduzca el modelo del vehiculo: ");
		scan.nextLine();
		modelo = scan.nextLine();
		guardarVehiculo(matricula, marca, deposito, modelo);
		leerArchivo();
	}
	
	public static void guardarVehiculo(String matricula, String marca, double deposito, String modelo ) {
		File archivo = new File("Prueba.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		String linea = matricula + " " + marca + " " + deposito + " " + modelo;
		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fw = new FileWriter(archivo, true);
			bw = new BufferedWriter(fw);
			bw.write(linea);
			bw.flush();
		} catch (IOException e) {
			System.out.println("Error de E/S");
		}
		finally {
			try {
				if(fw != null) {
					fw.close();
				}
			}
			catch(IOException e) {
				System.err.println("Error E/S.");
			}
		}
	}

	public static void leerArchivo() {
		String contenido = "";
		String matricula;
		String marca;
		String deposito;
		String modelo;
		int aux = 0;
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("Prueba.txt"));
			while(true) {
				JOptionPane.showMessageDialog(null, "El vehiculo tiene una matricula " + matricula + ", su marca es " + marca
						+ ", el tama�o del deposito " + deposito + " y el modelo " + modelo);
			}
		}
		catch(FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
		
	}
}	