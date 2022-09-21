import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {
	ArrayList<Piso> pisos = new ArrayList<Piso>();
	String nombre;
	public Scanner scan = new Scanner(System.in);

	public Agencia() {
		this.nombre = "";
	}

	public Agencia(String nombre) {
		this.nombre = nombre;
	}

	public Agencia(String nombre, ArrayList<Piso> pisos) {
		this.nombre = nombre;
		this.pisos = pisos;
	}

	public ArrayList<Piso> getPisos() {
		return pisos;
	}

	public void setPisos(ArrayList<Piso> pisos) {
		this.pisos = pisos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void añadirPiso() {
		String ciudad;
		String via;
		int numero = -1;
		int piso = -1;
		char letra;
		int cp;
		int m2;
		double precio_venta = 0;
		double precio_alquiler = 0;
		boolean venta = false;
		boolean alquiler = false;
		boolean exit = false;
		String select;
		System.out.println("Ha elegido añadir un nuevo piso.");
		System.out.println("Introduzca la ciudad:");
		ciudad = scan.nextLine();
		System.out.println("Introduzca la calle/via:");
		via = scan.nextLine();
		do {
			System.out.println("Introduzca el numero:");
			numero = Integer.parseInt(scan.nextLine());
			if (numero < 0) {
				System.out.println("El numero debe ser positivo.");
			}
		} while (numero < 0);
		do {
			System.out.println("Introduzca el piso:");
			piso = Integer.parseInt(scan.nextLine());
			if (piso < 0) {
				System.out.println("El piso debe ser positivo.");
			}
		} while (piso < 0);
		System.out.println("Introduzca la letra:");
		letra = scan.next().charAt(0);
		do {
			System.out.println("Introduzca el codigo postal");
			cp = Integer.parseInt(scan.nextLine());
			if (cp < 0) {
				System.out.println("El codigo postal debe ser positivo.");
			}
		} while (cp < 0);
		do {
			System.out.println("Introduzca el tamaño(m2):");
			m2 = Integer.parseInt(scan.nextLine());
			if (m2 < 0) {
				System.out.println("El tamaño debe ser un numero positivo.");
			} else {
				exit = true;
			}
		} while (exit != true);
		exit = false;
		do {
			System.out.println("Seleccione el tipo de piso" + "\n1/Venta" + "\n2/Alquiler" + "\n3/Ambos");
			select = scan.nextLine();
			switch (select) {
			case "1":
				venta = true;
				do {
					System.out.println("Introduzca el precio de venta:");
					precio_venta = Double.parseDouble(scan.nextLine());
					if (precio_venta < 0) {
						System.out.println("El precio debe ser positivo.");
					} else {
						exit = true;
					}
				} while (exit != true);
				break;
			case "2":
				alquiler = true;
				do {
					System.out.println("Introduzca el precio de alquiler:");
					precio_alquiler = Double.parseDouble(scan.nextLine());
					if (precio_alquiler < 0) {
						System.out.println("El precio debe ser positivo.");
					} else {
						exit = true;
					}
				} while (exit != true);
				break;
			case "3":
				venta = true;
				alquiler = true;
				do {
					System.out.println("Introduzca el precio de venta:");
					precio_venta = Double.parseDouble(scan.nextLine());
					System.out.println("Introduzca el precio de alquiler:");
					precio_alquiler = Double.parseDouble(scan.nextLine());
					if (precio_venta < 0 || precio_alquiler < 0) {
						System.out.println("Los precios deben ser positivos.");
					} else {
						exit = true;
					}
				} while (exit != true);
				break;
			default:
				System.out.println("Seleccione una opción válida.");
			}
		} while (exit != true);
		pisos.add(new Piso(ciudad, via, numero, piso, letra, cp, m2, precio_venta, precio_alquiler, venta, alquiler));
	}

	public void modificarPiso() {
		int id;
		int i;
		boolean exit = false;
		String select;
		System.out.println("Ha elegido modificar un piso.");
		do {
			System.out.println("Introduzca el id del piso a modificar.");
			id = scan.nextInt();
			for (i = 0; i < pisos.size(); i++) {
				if (pisos.get(i).id == id) {
					exit = true;
					break;
				}
			}
			if (exit == false) {
				System.out.println("No se ha encontrado el id introducido.");
			}
		} while (exit != true);
		exit = false;
		do {
			System.out.println("Seleccione un apartado a modificar:" + "\n1/Direccion" + "\n2/Tamaño"
					+ "\n3/Venta-Alquiler" + "\n4/Precio" + "\n0/Volver al menu principal.");
			select = scan.next();
			switch (select) {
			case "1":
				String ciudad;
				String via;
				int numero = -1;
				int piso;
				char letra;
				int cp = -1;
				System.out.println("Introduzca la ciudad:");
				ciudad = scan.nextLine();
				System.out.println("Introduzca la calle/via:");
				via = scan.nextLine();
				do {
					System.out.println("Introduzca el número:");
					numero = Integer.parseInt(scan.nextLine());
					if (numero < 0) {
						System.out.println("El numero no puede ser negativo.");
					}
				} while (numero < 0);
				System.out.println("Introduzca el piso:");
				piso = Integer.parseInt(scan.nextLine());
				System.out.println("Introduzca la letra:");
				letra = scan.next().charAt(0);
				do {
					System.out.println("Introduzca el codigo postal:");
					cp = Integer.parseInt(scan.nextLine());
					if (cp < 0) {
						System.out.println("El codigo postal no puede ser negativo.");
					}
				} while (cp < 0);

				pisos.get(i).setDireccion(ciudad, via, numero, piso, letra, cp);
				break;
			case "2":
				int m2;
				boolean exit2 = false;
				do {
					System.out.println("Introduzca el nuevo tamaño:");
					m2 = scan.nextInt();
					if (m2 < 0) {
						System.out.println("El tamaño debe ser positivo");
					} else {
						exit2 = true;
					}
				} while (exit2 != true);
				pisos.get(i).setM2(m2);
				break;
			case "3":
				boolean venta = false;
				boolean alquiler = false;
				boolean exit4 = false;
				String select2;
				do {
					System.out
							.println("Introduzca el nuevo tipo de piso:" + "\n1/Venta" + "\n2/Alquiler" + "\n3/Ambos");
					select2 = scan.next();
					switch (select2) {
					case "1":
						venta = true;
						alquiler = false;
						exit4 = true;
						break;
					case "2":
						venta = false;
						alquiler = true;
						exit4 = true;
						break;
					case "3":
						venta = true;
						alquiler = true;
						exit4 = true;
						break;
					default:
						System.out.println("Seleccione una opción válida.");
						exit4 = false;
					}
				} while (exit4 != true);
				pisos.get(i).setVenta(venta);
				pisos.get(i).setAlquiler(alquiler);
				break;
			case "4":
				boolean es_venta = pisos.get(i).getVenta();
				boolean es_alquiler = pisos.get(i).getAlquiler();
				double precio_venta = 0;
				double precio_alquiler = 0;
				boolean exit5 = false;
				do {
					if (es_venta == true) {
					}
					System.out.println("Introduzca el nuevo precio de venta:");
					precio_venta = Double.parseDouble(scan.nextLine());
					if (precio_venta < 0) {
						System.out.println("El precio debe ser positivo.");
					} else {
						exit5 = true;
					}
					if (es_alquiler == true) {
						System.out.println("Introduzca el nuevo precio de alquiler:");
						precio_alquiler = Double.parseDouble(scan.nextLine());
						if (precio_alquiler < 0) {
							System.out.println("El precio debe ser positivo.");
							exit5 = false;
						}
					}
				} while (exit5 != true);
				pisos.get(i).setPrecio_venta(precio_venta);
				pisos.get(i).setPrecio_alquiler(precio_alquiler);
				break;
			case "0":
				exit = true;
				break;
			default:
				System.out.println("Seleccione una opción válida.");
			}
		} while (exit != true);
	}

	public void listarPisos() {
		for (int i = 0; i < pisos.size(); i++) {
			System.out.println(pisos.get(i).toString());
		}
	}

	public void rangoPrecio() {
		String select;
		boolean exit = false;
		double precio_min = 0;
		double precio_max = 0;
		boolean precio_correcto = false;
		do {
			System.out.println("Seleccione una opción:" + "\n1/Listar por precio de venta"
					+ "\n2/Listar por precio de alquiler" + "\n0/Volver al menú principal");
			select = scan.nextLine();
			switch (select) {
			case "1":
				do {
					precio_correcto = false;
					while (precio_correcto == false) {
						System.out.println("Introduzca un precio mínimo:");
						precio_min = Double.parseDouble(scan.nextLine());
						if (precio_min < 0) {
							System.out.println("El precio debe ser positivo.");
						} else {
							precio_correcto = true;
						}
					}
					precio_correcto = false;
					while (precio_correcto == false) {
						System.out.println("Introduzca un precio máximo:");
						precio_max = Double.parseDouble(scan.nextLine());
						if (precio_max < 0) {
							System.out.println("El precio debe ser positivo.");
						} else {
							precio_correcto = true;
						}
					}
					if (precio_min > precio_max) {
						System.out.println("El precio mínimo no puede ser mayor que el precio máximo");
						precio_correcto = false;
					}
				} while (precio_correcto != true);
				for (int i = 0; i < pisos.size(); i++) {
					if (precio_min <= pisos.get(i).getPrecio_venta() && pisos.get(i).getPrecio_venta() <= precio_max) {
						System.out.println(pisos.get(i).toString());
					}
				}
				break;
			case "2":
				do {
					precio_correcto = false;
					while (precio_correcto == false) {
						System.out.println("Introduzca un precio mínimo:");
						precio_min = Double.parseDouble(scan.nextLine());
						if (precio_min < 0) {
							System.out.println("El precio debe ser positivo.");
						} else {
							precio_correcto = true;
						}
					}
					precio_correcto = false;
					while (precio_correcto == false) {
						System.out.println("Introduzca un precio máximo:");
						precio_max = Double.parseDouble(scan.nextLine());
						if (precio_max < 0) {
							System.out.println("El precio debe ser positivo.");
						} else {
							precio_correcto = true;
						}
					}
					if (precio_min > precio_max) {
						System.out.println("El precio mínimo no puede ser mayor que el precio máximo");
						precio_correcto = false;
					}
				} while (precio_correcto != true);
				for (int i = 0; i < pisos.size(); i++) {
					if (precio_min <= pisos.get(i).getPrecio_alquiler()
							&& pisos.get(i).getPrecio_alquiler() <= precio_max) {
						System.out.println(pisos.get(i).toString());
					}
				}
				break;
			case "0":
				exit = true;
				break;
			default:
				System.out.println("Seleccione una opción válida.");
			}
		} while (exit != true);
	}

	public void rangoTamaño() {
		boolean tamaño_correcto = false;
		int tamaño_minimo = 0;
		int tamaño_maximo = 0;
		do {
			while (tamaño_correcto == false) {
				System.out.println("Introduzca el tamaño mínimo:");
				tamaño_minimo = Integer.parseInt(scan.nextLine());
				if (tamaño_minimo < 0) {
					System.out.println("El tamaño no puede ser negativo.");
				} else {
					tamaño_correcto = true;
				}
			}
			tamaño_correcto = false;
			while (tamaño_correcto == false) {
				System.out.println("Introduzca el tamaño máximo.");
				tamaño_maximo = Integer.parseInt(scan.nextLine());
				if (tamaño_maximo < 0) {
					System.out.println("El tamaño no puede ser negativo.");
				} else {
					tamaño_correcto = true;
				}
			}
			if (tamaño_minimo > tamaño_maximo) {
				System.out.println("El tamaño minimo no puede ser mayor que el tamaño maximo");
				tamaño_correcto = false;
			}
		} while (tamaño_correcto != true);
		for (int i = 0; i < pisos.size(); i++) {
			if (pisos.get(i).getM2() > tamaño_minimo && pisos.get(i).getM2() < tamaño_maximo) {
				System.out.println(pisos.get(i).toString());
			}
		}
	}

	public void eliminarPiso() {
		int id;
		int i;
		boolean id_correcto = false;
		boolean exit = false;
		boolean opcion_correcta = false;
		boolean piso_encontrado = false;
		String select;
		do {
			do {
				System.out.println("Introduzca el id del piso a eliminar.");
				id = Integer.parseInt(scan.nextLine());
				if (id < 0) {
					System.out.println("El id no puede ser negativo.");
				} else {
					id_correcto = true;
				}
			} while (id_correcto != true);
			for (i = 0; i <= pisos.size(); i++) {
				if (pisos.get(i).getId() == id) {
					pisos.remove(i);
					System.out.println("El piso ha sido eliminado correctamente.");
					piso_encontrado = true;
					break;
				}
			}
			if (piso_encontrado == false) {
				System.out.println("El id del piso no ha sido encontrado.");
			}
			do {
				System.out.println(
						"Seleccione una opción" + "\n1/Volver a introducir un id." + "\n2/Volver al menu principal.");
				select = scan.nextLine();
				switch (select) {
				case "1":
					opcion_correcta = true;
					break;
				case "2":
					opcion_correcta = true;
					exit = true;
					break;
				default:
					System.out.println("Seleccione una opción válida.");
				}
			} while (opcion_correcta != true);
		} while (exit != true);
	}
}
