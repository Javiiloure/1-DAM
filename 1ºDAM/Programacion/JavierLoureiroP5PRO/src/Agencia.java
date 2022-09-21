import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {

	private ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();
	private String nombre;
	public Scanner scan = new Scanner(System.in);

	public Agencia(String nombre) {
		this.nombre = nombre;
	}

	public Agencia(String nombre, ArrayList<Inmueble> Inmuebles) {
		this.nombre = nombre;
		this.inmuebles = Inmuebles;
	}

	public ArrayList<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(ArrayList<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void nuevo_inmueble() {

		Direccion direccion;
		int n_habitaciones = 1;
		int m2 = 0;
		boolean garaje = false;
		boolean alquiler = false;
		boolean venta = false;
		double precio_venta = 0;
		double precio_alquiler = 0;
		boolean exit = true;
		int select = 0;

		System.out.println("Ha seleccionado a�adir un inmueble");
		direccion = nuevaDireccion();
		do {
			System.out.println("Introduzca el tama�o(m2):");
			m2 = scan.nextInt();
			if (m2 < 0) {
				System.out.println("El tama�o debe ser positivo");
				exit = false;
			} else {
				exit = true;
			}
		} while (exit != true);
		exit = false;
		do {
			System.out.println("Dispone de garaje?" + "\n1/Garaje disponible" + "\n2/Garaje no disponible");
			select = scan.nextInt();
			switch (select) {
			case 1:
				garaje = true;
				exit = true;
				break;
			case 2:
				garaje = false;
				exit = true;
				break;
			default:
				System.out.println("Seleccione una opci�n v�lida.");
			}
		} while (exit != true);
		exit = false;
		do {
			System.out.println("Seleccione el tipo de contrato disponible:" + "\n1/Venta" + "\n2/Alquiler" + "\n3/Ambos");
			select = scan.nextInt();
			switch (select) {
			case 1:
				venta = true;
				System.out.println("Introduzca el precio de venta:");
				precio_venta = scan.nextDouble();
				while (precio_venta < 0) {
					System.out.println("El precio debe ser positivo" + "\nIntroduzca el precio de venta.");
					precio_venta = scan.nextDouble();
				}
				exit = true;
				break;
			case 2:
				alquiler = true;
				System.out.println("Introduzca el precio de alquiler:");
				precio_alquiler = scan.nextDouble();
				while (precio_alquiler < 0) {
					System.out.println("El precio debe ser positivo" + "\nIntroduzca el precio de alquiler:");
					precio_alquiler = scan.nextDouble();
				}
				exit = true;
				break;
			case 3:
				venta = true;
				alquiler = true;
				System.out.println("Introduzca el precio de venta:");
				precio_venta = scan.nextDouble();
				while (precio_venta < 0) {
					System.out.println("El precio debe ser positivo" + "\nIntroduzca el precio de venta.");
					precio_venta = scan.nextDouble();
				}
				System.out.println("Introduzca el precio de alquiler:");
				precio_alquiler = scan.nextDouble();
				while (precio_alquiler < 0) {
					System.out.println("El precio debe ser positivo" + "\nIntroduzca el precio de alquiler:");
					precio_alquiler = scan.nextDouble();
				}
				exit = true;
				break;
			default:
				System.out.println("Seleccione una opci�n v�lida.");
			}
		} while (exit != true);
		exit = false;
		do {
			System.out.println("Seleccione el tipo de inmueble: " + "\n1/Casa" + "\n2/Piso");
			select = scan.nextInt();
			if (select != 1 && select != 2) {
				System.out.println("Seleccione una opci�n v�lida");
			} else {
				exit = true;
			}
		} while (exit != true);
		exit = false;
		switch (select) {
		case 1:
			boolean jardin = false;
			boolean piscina = false;
			do {
				System.out.println("Introduzca el numero de habitaciones: ");
				n_habitaciones = scan.nextInt();
				if (n_habitaciones < 0) {
					System.out.println("Introduzca un numero positivo");
					exit = false;
				} else {
					exit = true;
				}
			} while (exit != true);
			do {
				System.out.println("La casa dispone de jardin?" + "\n1/Jardin disponible" + "\n2/Jardin no disponible");
				select = scan.nextInt();
				switch (select) {
				case 1:
					jardin = true;
					exit = true;
					break;
				case 2:
					jardin = false;
					exit = true;
					break;
				default:
					System.out.println("Seleccione una opci�n v�lida.");
				}
			} while (exit != true);
			exit = false;
			do {
				System.out.println(
						"La casa dispone de piscina?" + "\n1/Piscina disponible" + "\n2/Piscina no disponible");
				select = scan.nextInt();
				switch (select) {
				case 1:
					piscina = true;
					exit = true;
					break;
				case 2:
					piscina = false;
					exit = true;
					break;
				default:
					System.out.println("Seleccione una opci�n v�lida.");
				}
			} while (exit != true);
			scan.nextLine();
			inmuebles.add(new Casa(direccion, n_habitaciones, m2, precio_alquiler, precio_venta, garaje, alquiler,
					venta, jardin, piscina));
			break;
		case 2:
			boolean estudio = false;
			int n_piso = 0;
			String letra = "AA";
			System.out.println("Introduzca el numero de piso: ");
			n_piso = scan.nextInt();
			do {
				System.out.println("Introduzca la letra:");
				letra = scan.next();
				if (letra.length() > 1) {
					System.out.println("Introduzca solo un caracter.");
				}
			} while (letra.length() != 1);
			System.out.println("Es un estudio?" + "\n1/Si" + "\n2/No");
			select = scan.nextInt();
			switch (select) {
			case 1:
				estudio = true;
				break;
			case 2:
				estudio = false;
				do {
					System.out.println("Introduzca el numero de habitaciones: ");
					n_habitaciones = scan.nextInt();
					if (n_habitaciones < 0) {
						System.out.println("Introduzca un numero positivo");
					} else {
						exit = true;
					}
				} while (exit != true);
				inmuebles.add(new Piso(direccion, n_habitaciones, m2, precio_venta, precio_alquiler, garaje, alquiler,
						venta, n_piso, letra, estudio));
				System.out.println("El inmueble se ha a�adido correctamente.");
			}
		}
	}

	public void modificar_inmueble() {
		int id;
		Direccion direccion;
		int n_habitaciones;
		int tama�o;
		int n_piso;
		String letra;
		double precio_venta = -1;
		double precio_alquiler = -1;
		boolean id_correcto = false;
		int i;
		int select;
		boolean exit = false;
		do {
			id = -1;
			while (id < 0) {
				System.out.println("Introduzca el id del inmueble a modificar: ");
				id = scan.nextInt();
				if (id < 0) {
					System.out.println("El id debe ser positivo.");
				}
			}
			for (i = 0; i < inmuebles.size(); i++) {
				if (inmuebles.get(i).id == id) {
					id_correcto = true;
					break;
				}
			}
			if (id_correcto == false) {
				System.out.println("El id del piso no ha sido encontrado");
			}
		} while (id_correcto != true);
		
		if (inmuebles.get(i) instanceof Piso) {
			Piso piso = (Piso)inmuebles.get(i);
			do {
				System.out.println(
						"Seleccione un apartado a modificar:\n" + "1/Direccion\n" + "2/Numero de habitaciones\n"
								+ "3/Tama�o\n" + "4/Alquiler-Venta\n" + "5/Precio\n" + "6/Disponibilidad de garaje\n"
								+ "7/Numero de piso\n" + "8/Letra\n" + "9/Estudio\n" + "0/Volver al menu principal");
				select = scan.nextInt();
				switch (select) {
				case 1:
					direccion = nuevaDireccion();
					inmuebles.get(i).setDireccion(direccion);
					break;
				case 2:
					System.out.println("Introduzca el numero de habitaciones:");
					n_habitaciones = scan.nextInt();
					inmuebles.get(i).setN_habitaciones(n_habitaciones);
					break;
				case 3:
					System.out.println("Introduzca el tama�o");
					tama�o = scan.nextInt();
					inmuebles.get(i).setM2(tama�o);
					break;
				case 4:
					exit = false;
					do {
						System.out.println("Seleccione una opci�n:\n" + "1/Disponible para venta\n"
								+ "2/Disponible para alquiler\n" + "3/Disponible para ambos");
						select = scan.nextInt();
						switch (select) {
						case 1:
							inmuebles.get(i).setAlquiler(false);
							inmuebles.get(i).setVenta(true);
							System.out.println("Introduce el precio de venta");
							precio_venta = scan.nextDouble();
							inmuebles.get(i).setPrecio_venta(precio_venta);
							exit = true;
							break;
						case 2:
							inmuebles.get(i).setAlquiler(true);
							System.out.println("Introduce el precio de alquiler:");
							precio_alquiler = scan.nextDouble();
							inmuebles.get(i).setPrecio_alquiler(precio_alquiler);
							inmuebles.get(i).setVenta(false);
							exit = true;
							break;
						case 3:
							inmuebles.get(i).setAlquiler(true);
							System.out.println("Introduce el precio de alquiler:");
							precio_alquiler = scan.nextDouble();
							inmuebles.get(i).setPrecio_alquiler(precio_alquiler);
							inmuebles.get(i).setVenta(true);
							System.out.println("Introduce el precio de venta");
							precio_venta = scan.nextDouble();
							inmuebles.get(i).setPrecio_venta(precio_venta);
							exit = true;
							break;
						default:
							System.out.println("Seleccione una opci�n valida.");
						}
					} while (exit != true);
					exit = false;
					break;
				case 5:
					if (inmuebles.get(i).getAlquiler() == true) {
						System.out.println("Introduce el precio de alquiler:");
						precio_alquiler = scan.nextDouble();
						inmuebles.get(i).setPrecio_alquiler(precio_alquiler);
					}
					if (inmuebles.get(i).getVenta() == true) {
						System.out.println("Introduce el precio de venta");
						precio_venta = scan.nextDouble();
						inmuebles.get(i).setPrecio_venta(precio_venta);
					}
					break;
				case 6:
					exit = false;
					do {
						System.out.println("Seleccione la disponibilidad de garaje" + "\n1/Garaje disponible"
								+ "\n2/Garaje no disponible");
						select = scan.nextInt();
						switch (select) {
						case 1:
							inmuebles.get(i).setGaraje(true);
							exit = true;
							break;
						case 2:
							inmuebles.get(i).setGaraje(false);
							exit = true;
							break;
						default:
							System.out.println("Seleccione una opci�n v�lida");
						}
					} while (exit != true);
					exit = false;
					break;
				case 7:
					exit = false;
					do { 
						System.out.println("Introduca el numero del piso.");
						n_piso = scan.nextInt();
						if (n_piso < 0) {
							System.out.println("El piso debe ser positivo");
						} else {
							piso.setN_piso(n_piso);
							exit = true;
						}
					} while (exit != true);
					exit = false;
				case 8:
					exit = false;
					do {
						System.out.println("Introduzca la letra: ");
						letra = scan.next();
						if(letra.length() > 1)  {
							System.out.println("Introduzca un solo caracter.");
						} else {
						 piso.setLetra(letra);
						 exit = true;
						}
					}while (exit != true);
					exit = false;
				case 9:
					exit = false;
					do {
						System.out.println("Es un estudio:\n1/Si\n2/No");
						select = scan.nextInt();
						if (select == 1) {
							piso.setEstudio(true);
							piso.setN_habitaciones(1);
							exit = true;
						} else if (select == 2){
							piso.setEstudio(false);
							exit = true;
						} else {
							System.out.println("Seleccione una opcion v�lida.\n");
						}
					} while (exit != true);
					exit = false;
					break;
				case 0:
					exit = true;
				}
			} while (exit != true);
		} else if (inmuebles.get(i) instanceof Casa) {
			Casa casa = (Casa)inmuebles.get(i);
			do {
				System.out.println(
						"\nSeleccione un apartado a modificar:\n" + "1/Direccion\n" + "2/Numero de habitaciones\n"
								+ "3/Tama�o\n" + "4/Alquiler-Venta\n" + "5/Precio\n" + "6/Disponibilidad de garaje\n"
								+ "7/Jardin\n" + "8/Piscina\n" + "0/Volver al men� principal");
				select = scan.nextInt();
				switch (select) {
				case 1:
					direccion = nuevaDireccion();
					inmuebles.get(i).setDireccion(direccion);
					break;
				case 2:
					System.out.println("Introduzca el numero de habitaciones:");
					n_habitaciones = scan.nextInt();
					inmuebles.get(i).setN_habitaciones(n_habitaciones);
					break;
				case 3:
					System.out.println("Introduzca el tama�o");
					tama�o = scan.nextInt();
					inmuebles.get(i).setM2(tama�o);
					break;
				case 4:
					exit = false;
					do {
						System.out.println("Seleccione una opci�n:\n" + "1/Disponible para venta\n"
								+ "2/Disponible para alquiler\n" + "3/Disponible para ambos");
						select = scan.nextInt();
						switch (select) {
						case 1:
							inmuebles.get(i).setAlquiler(false);
							inmuebles.get(i).setVenta(true);
							System.out.println("Introduce el precio de venta");
							precio_venta = scan.nextDouble();
							inmuebles.get(i).setPrecio_venta(precio_venta);
							exit = true;
							break;
						case 2:
							inmuebles.get(i).setAlquiler(true);
							System.out.println("Introduce el precio de alquiler:");
							precio_alquiler = scan.nextDouble();
							inmuebles.get(i).setPrecio_alquiler(precio_alquiler);
							inmuebles.get(i).setVenta(false);
							exit = true;
							break;
						case 3:
							inmuebles.get(i).setAlquiler(true);
							System.out.println("Introduce el precio de alquiler:");
							precio_alquiler = scan.nextDouble();
							inmuebles.get(i).setPrecio_alquiler(precio_alquiler);
							inmuebles.get(i).setVenta(true);
							System.out.println("Introduce el precio de venta");
							precio_venta = scan.nextDouble();
							inmuebles.get(i).setPrecio_venta(precio_venta);
							exit = true;
							break;
						default:
							System.out.println("Seleccione una opci�n valida.");
						}
					} while (exit != true);
					exit = false;
					break;
				case 5:
					if (inmuebles.get(i).getAlquiler() == true) {
						System.out.println("Introduce el precio de alquiler:");
						precio_alquiler = scan.nextDouble();
						inmuebles.get(i).setPrecio_alquiler(precio_alquiler);
					}
					if (inmuebles.get(i).getVenta() == true) {
						System.out.println("Introduce el precio de venta");
						precio_venta = scan.nextDouble();
						inmuebles.get(i).setPrecio_venta(precio_venta);
					}
					break;
				case 6:
					exit = false;
					do {
						System.out.println("Seleccione la disponibilidad de garaje" + "\n1/Garaje disponible"
								+ "\n2/Garaje no disponible");
						select = scan.nextInt();
						switch (select) {
						case 1:
							inmuebles.get(i).setGaraje(true);
							exit = true;
							break;
						case 2:
							inmuebles.get(i).setGaraje(false);
							exit = true;
							break;
						default:
							System.out.println("Seleccione una opci�n v�lida");
						}
					} while (exit != true);
					exit = false;
					break;
				case 7:
					exit = false;
					do {
						System.out.println("Disponibilidad de jardin :\n1/Jardin disponible\n2/Jardin no disponible");
						select = scan.nextInt();
						if(select == 1) {
							casa.setJardin(true);
							exit = true;
						} else if (select == 2) {
							casa.setJardin(false);
							exit = true;
						} else {
							System.out.println("Seleccine una opcion v�lida.");
						}
					} while (exit != true);
					exit = false;
					break;
				case 8:
					exit = false;
					do {
						System.out.println("Disponibilidad de piscina :\n1/Piscina disponible\n2/Piscina no disponible");
						select = scan.nextInt();
						if(select == 1) {
							casa.setPiscina(true);
							exit = true;
						} else if (select == 2) {
							casa.setPiscina(false);
							exit = true;
						} else {
							System.out.println("Seleccine una opcion v�lida.");
						}
					} while (exit != true);
					exit = false;
					break;
				case 0:
					exit = true;
				}
			} while (exit != true);
		}
	}
	
	public void listarInmuebles() {
		for (int i = 0; i < inmuebles.size(); i++) {
			System.out.println(inmuebles.get(i).toString());
		}
	}
	
	public void rangoPrecio() {
		String select;
		boolean exit = false;
		double precio_min = 0;
		double precio_max = 0;
		boolean precio_correcto = false;
		do {
			System.out.println("\nSeleccione una opci�n:" + "\n1/Listar por precio de venta"
					+ "\n2/Listar por precio de alquiler" + "\n0/Volver al men� principal");
			select = scan.nextLine();
			switch (select) {
			case "1":
				do {
					precio_correcto = false;
					while (precio_correcto == false) {
						System.out.println("Introduzca un precio m�nimo:");
						precio_min = Double.parseDouble(scan.nextLine());
						if (precio_min < 0) {
							System.out.println("El precio debe ser positivo.");
						} else {
							precio_correcto = true;
						}
					}
					precio_correcto = false;
					while (precio_correcto == false) {
						System.out.println("Introduzca un precio m�ximo:");
						precio_max = Double.parseDouble(scan.nextLine());
						if (precio_max < 0) {
							System.out.println("El precio debe ser positivo.");
						} else {
							precio_correcto = true;
						}
					}
					if (precio_min > precio_max) {
						System.out.println("El precio m�nimo no puede ser mayor que el precio m�ximo");
						precio_correcto = false;
					}
				} while (precio_correcto != true);
				for (int i = 0; i < inmuebles.size(); i++) {
					if (precio_min <= inmuebles.get(i).getPrecio_venta() && inmuebles.get(i).getPrecio_venta() <= precio_max) {
						System.out.println(inmuebles.get(i).toString());
					}
				}
				break;
			case "2":
				do {
					precio_correcto = false;
					while (precio_correcto == false) {
						System.out.println("Introduzca un precio m�nimo:");
						precio_min = Double.parseDouble(scan.nextLine());
						if (precio_min < 0) {
							System.out.println("El precio debe ser positivo.");
						} else {
							precio_correcto = true;
						}
					}
					precio_correcto = false;
					while (precio_correcto == false) {
						System.out.println("Introduzca un precio m�ximo:");
						precio_max = Double.parseDouble(scan.nextLine());
						if (precio_max < 0) {
							System.out.println("El precio debe ser positivo.");
						} else {
							precio_correcto = true;
						}
					}
					if (precio_min > precio_max) {
						System.out.println("El precio m�nimo no puede ser mayor que el precio m�ximo");
						precio_correcto = false;
					}
				} while (precio_correcto != true);
				for (int i = 0; i < inmuebles.size(); i++) {
					if (precio_min <= inmuebles.get(i).getPrecio_alquiler()
							&& inmuebles.get(i).getPrecio_alquiler() <= precio_max) {
						System.out.println(inmuebles.get(i).toString());
					}
				}
				break;
			case "0":
				exit = true;
				break;
			default:
				System.out.println("Seleccione una opci�n v�lida.");
			}
		} while (exit != true);
	}
	
	public void rangoTama�o() {
		boolean tama�o_correcto = false;
		int tama�o_minimo = 0;
		int tama�o_maximo = 0;
		do {
			while (tama�o_correcto == false) {
				System.out.println("Introduzca el tama�o m�nimo:");
				tama�o_minimo = Integer.parseInt(scan.nextLine());
				if (tama�o_minimo < 0) {
					System.out.println("El tama�o no puede ser negativo.");
				} else {
					tama�o_correcto = true;
				}
			}
			tama�o_correcto = false;
			while (tama�o_correcto == false) {
				System.out.println("Introduzca el tama�o m�ximo.");
				tama�o_maximo = Integer.parseInt(scan.nextLine());
				if (tama�o_maximo < 0) {
					System.out.println("El tama�o no puede ser negativo.");
				} else {
					tama�o_correcto = true;
				}
			}
			if (tama�o_minimo > tama�o_maximo) {
				System.out.println("El tama�o minimo no puede ser mayor que el tama�o maximo");
				tama�o_correcto = false;
			}
		} while (tama�o_correcto != true);
		for (int i = 0; i < inmuebles.size(); i++) {
			if (inmuebles.get(i).getM2() >= tama�o_minimo && inmuebles.get(i).getM2() <= tama�o_maximo) {
				System.out.println(inmuebles.get(i).toString());
			}
		}
	}

	public void eliminarInmueble() {
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
			for (i = 0; i <= inmuebles.size(); i++) {
				if (inmuebles.get(i).getId() == id) {
					inmuebles.remove(i);
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
						"Seleccione una opci�n" + "\n1/Volver a introducir un id." + "\n2/Volver al menu principal.");
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
					System.out.println("Seleccione una opci�n v�lida.");
				}
			} while (opcion_correcta != true);
		} while (exit != true);
	}
	
	public Direccion nuevaDireccion() {

		Direccion direccion;
		Direccion.tipo_vias via = Direccion.TIPO_POR_DEFECTO;
		String nombre_via;
		int CP;
		int numero;
		boolean exit = true;
		int select;

		do {
			System.out.println("Seleccione un tipo de via:\n" + "1/Calle\n" + "2/Avenida\n" + "3/Plaza\n" + "4/Camino\n"
					+ "5/Carretera\n" + "6/Paseo");
			select = scan.nextInt();
			switch (select) {
			case 1:
				via = Direccion.tipo_vias.Calle;
				exit = true;
				break;
			case 2:
				via = Direccion.tipo_vias.Avenida;
				exit = true;
				break;
			case 3:
				via = Direccion.tipo_vias.Plaza;
				exit = true;
				break;
			case 4:
				via = Direccion.tipo_vias.Camino;
				exit = true;
				break;
			case 5:
				via = Direccion.tipo_vias.Carretera;
				exit = true;
				break;
			case 6:
				via = Direccion.tipo_vias.Paseo;
				exit = true;
				break;
			default:
				System.out.println("Seleccione una opcion v�lida");
				exit = false;
			}
		} while (exit != true);
		scan.nextLine();
		System.out.println("Introduzca el nombre de la via:");
		nombre_via = scan.nextLine();
		exit = true;
		do {
			System.out.println("Introduzca el numero:");
			numero = scan.nextInt();
			if (numero < 0) {
				exit = false;
				System.out.println("El numero debe ser positivo.");
			}
		} while (exit != true);

		exit = true;
		do {
			System.out.println("Introduzca el codigo postal");
			CP = scan.nextInt();
			if (CP < 0) {
				exit = false;
				System.out.println("El codigo postal debe ser positivo");
			}
		} while (exit != true);
		direccion = new Direccion(via, nombre_via, numero, CP);
		return direccion;
	}
}
