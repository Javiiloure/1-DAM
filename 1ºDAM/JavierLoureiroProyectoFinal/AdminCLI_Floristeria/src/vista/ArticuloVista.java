package vista;

import java.util.Scanner;
import controlador.ArticuloController;
import controlador.MacetaController;
import controlador.PlantaController;
import controlador.TicketController;

import java.io.IOException;
import java.sql.SQLException;

public class ArticuloVista {
	private static Scanner scan = new Scanner(System.in);

	public static void gestionArticulos() throws IOException, SQLException {
		String select;
		boolean exit = false;
		do {
			ArticuloController.getArticulos();
			System.out.println("Bienvenido a Floristería, seleccione una opción: \n" + "1/Añadir nuevos articulos \n"
					+ "2/Borrar articulos existentes \n" + "3/Modificar articulos existentes \n"
					+ "4/Listar los articulos \n" + "5/Ver resumen de los tickets \n"
					+ "6/Ver resumen de los articulos más vendidos \n" + "0/Volver al menu principal");
			select = scan.nextLine();
			switch (select) {
			case "1":
				añadirArticulo();
				break;
			case "2":
				borrarArticulo();
				break;
			case "3":
				modificarArticulo();
				break;
			case "4":
				ArticuloController.listarArticulos();
				break;
			case "5":
				TicketController.resumenTickets();
				break;
			case "6":
				TicketController.articulosMasVendidos();
				break;
			case "0":
				System.out.println("Volviendo al menú principal");
				exit = true;
				break;
			default:
				System.out.println("Seleccione una opción válida");
			}
		} while (exit != true);
	}

	public static void añadirArticulo() throws SQLException {
		String select;
		boolean exit = false;
		int stock = 0;
		double precio = 0;
		do {
			System.out.println("Seleccione el tipo de articulo" + "\n1/Planta" + "\n2/Maceta");
			select = scan.nextLine();
			switch (select) {
			case "1":
				String nombre_planta = "";
				String nombre_cientifico = "";
				boolean flor = false;
				String caracteristicas_regadio = "";
				System.out.println("Introduzca el nombre de la planta: ");
				nombre_planta = scan.nextLine();
				System.out.println("Introduzca el nombre cientifico: ");
				nombre_cientifico = scan.nextLine();
				while (exit != true) {
					System.out.println("Indique si es o no una flor:" + "\n1/Es una flor " + "\n2/No es un a flor");
					select = scan.nextLine();
					switch (select) {
					case "1":
						exit = true;
						flor = true;
						break;
					case "2":
						exit = true;
						flor = false;
						break;
					default:
						System.out.println("Seleccione una opcion valida.");
					}
				}
				exit = false;
				while (exit != true) {
					System.out.println("Introduzca las características de regadío(100 char max):");
					caracteristicas_regadio = scan.nextLine();
					if (caracteristicas_regadio.length() > 100) {
						System.out
								.println("Se ha excedido la longitud permitida, introduzca una descripción más corta.");
					} else {
						exit = true;
					}
				}
				exit = false;
				while (exit != true) {
					System.out.println("Introduzca el stock del articulo");
					stock = Integer.parseInt(scan.nextLine());
					if (stock < 0) {
						System.out.println("El stock no puede ser negativo");
					} else {
						exit = true;
					}
				}
				exit = false;
				while (exit != true) {
					System.out.println("Intorduzca el precio del articulo");
					precio = Double.parseDouble(scan.nextLine());
					if (precio < 0) {
						System.out.println("El precio no puede ser negativo");
					} else {
						exit = true;
					}
				}
				exit = false;
				while (exit != true) {
					System.out.println("Añadir siguiente articulo:" + "\nNombre de la planta: " + nombre_planta
							+ " Nombre cientifico: " + nombre_cientifico + " Caracteristicas de regadio: "
							+ caracteristicas_regadio + " Stock: " + stock + " Precio: " + precio
							+ "\n1/Confirmar operacion \n2/Cancelar");
					select = scan.nextLine();
					switch (select) {
					case "1":
						PlantaController.añadirPlanta(stock, precio, nombre_planta, nombre_cientifico, flor,
								caracteristicas_regadio);
						System.out.println("Articulo añadido correctamente.");
						exit = true;
						break;
					case "2":
						System.out.println("Operacion cancelada");
						exit = true;
						break;
					default:
						System.out.println("Seleccione una opcion valida.");
					}
				}
				break;
			case "2":
				int alto_cm = 0;
				int diametro_cm = 0;
				String color = "";
				String material = "";
				boolean exterior = false;
				while (exit != true) {
					System.out.println("Introduzca la altura en cm:");
					alto_cm = Integer.parseInt(scan.nextLine());
					if (alto_cm < 0) {
						System.out.println("La altura no puede ser negativa");
					} else {
						exit = true;
					}
				}
				exit = false;
				while (exit != true) {
					System.out.println("Introduzca el diametro en cm:");
					diametro_cm = Integer.parseInt(scan.nextLine());
					if (diametro_cm < 0) {
						System.out.println("El diametro no puede ser negativo.");
					} else {
						exit = true;
					}
				}
				exit = false;
				while (exit != true) {
					System.out.println("Selecccione un color para la maceta:" + "\n1/Blanco" + "\n2/Negro" + "\n3/Gris"
							+ "\n4/Verde" + "\n5/Rojo" + "\n6/Azul" + "\n7/Amarillo" + "\n8/Violeta" + "\n9/Naranja");
					select = scan.nextLine();
					switch (select) {
					case "1":
						color = "Blanco";
						exit = true;
						break;
					case "2":
						color = "Negro";
						exit = true;
						break;
					case "3":
						color = "Gris";
						exit = true;
						break;
					case "4":
						color = "Verde";
						exit = true;
						break;
					case "5":
						color = "Rojo";
						exit = true;
						break;
					case "6":
						color = "Azul";
						exit = true;
						break;
					case "7":
						color = "Amarillo";
						exit = true;
						break;
					case "8":
						color = "Violeta";
						exit = true;
						break;
					case "9":
						color = "Naranja";
						exit = true;
						break;
					default:
						System.out.println("Seleccione una opcion valida.");
					}
				}
				exit = false;
				while (exit != true) {
					System.out.println("Selecccione un material para la maceta:" + "\n1/Plastico" + "\n2/Arcilla"
							+ "\n3/Piedra" + "\n4/Madera" + "\n5/Cemento" + "\n6/Fibrocemento");
					select = scan.nextLine();
					switch (select) {
					case "1":
						material = "Plastico";
						exit = true;
						break;
					case "2":
						material = "Arcilla";
						exit = true;
						break;
					case "3":
						material = "Piedra";
						exit = true;
						break;
					case "4":
						material = "Madera";
						exit = true;
						break;
					case "5":
						material = "Cemento";
						exit = true;
						break;
					case "6":
						material = "Fibrocemneto";
						exit = true;
						break;
					default:
						System.out.println("Seleccione una opcion valida.");
					}
				}
				exit = false;
				while (exit != true) {
					System.out.println(
							"Seleccione el tipo de maceta" + "\n1/Maceta de exterior" + "\n2/Maceta de interior");
					select = scan.nextLine();
					switch (select) {
					case "1":
						exterior = true;
						exit = true;
						break;
					case "2":
						exterior = false;
						exit = true;
						break;
					default:
						System.out.println("Seleccione una opción válida.");
					}
				}
				exit = false;
				while (exit != true) {
					System.out.println("Introduzca el stock del articulo");
					stock = Integer.parseInt(scan.nextLine());
					if (stock < 0) {
						System.out.println("El stock no puede ser negativo");
					} else {
						exit = true;
					}
				}
				exit = false;
				while (exit != true) {
					System.out.println("Intorduzca el precio del articulo");
					precio = Double.parseDouble(scan.nextLine());
					if (precio < 0) {
						System.out.println("El precio no puede ser negativo");
					} else {
						exit = true;
					}
				}
				exit = false;
				while (exit != true) {
					System.out.println("Añadir siguiente articulo: " + "\nMaceta Altura: " + alto_cm + " cm Diametro: "
							+ diametro_cm + " Color: " + color + " Material: " + material + " Precio: " + precio
							+ " Stock: " + stock + "\n1/Confirmar operacion \n2/Cancelar");
					select = scan.nextLine();
					switch (select) {
					case "1":
						MacetaController.añadirMaceta(stock, precio, alto_cm, diametro_cm, color, material, exterior);
						exit = true;
						System.out.println("Articulo añadido correctamente.");
						break;
					case "2":
						System.out.println("Operación cancelada");
						exit = true;
						break;
					default:
						System.out.println("Seleccione una opcion valida.");
					}
				}
				break;
			default:
				System.out.println("Seleccione una opcion valida.");
			}

		} while (exit != true);
	}

	public static void borrarArticulo() throws SQLException {
		int codigo_articulo;
		boolean exit = false;
		while (exit != true) {
			System.out.println("Introduzca el codigo del articulo a eliminar");
			codigo_articulo = Integer.parseInt(scan.nextLine());
			if (codigo_articulo < 0) {
				System.out.println("El codigo no puede ser negativo.");
			} else {
				exit = true;
				ArticuloController.borrarArticulo(codigo_articulo);
			}
		}
	}

	public static void modificarArticulo() throws SQLException {
		ArticuloController.getArticulos();
		int codigo_articulo = -1;
		int stock = -1;
		double precio = -1;
		String select;
		boolean planta = false;
		boolean maceta = false;
		boolean exit = false;
		int p = 0;
		int m = 0;
		do {
			System.out.println("Introduzca el codigo del articulo a modificar");
			codigo_articulo = Integer.parseInt(scan.nextLine());
			if (codigo_articulo <= 0) {
				System.out.println("El codigo no puede ser negativo.");
			}
		} while (codigo_articulo < 0);
		for (p = 0; p < ArticuloController.plantas.size(); p++) {
			if (ArticuloController.plantas.get(p).getCodigo_articulo() == codigo_articulo) {
				planta = true;
				break;
			}
		}
		if (planta == false) {
			for (m = 0; m < ArticuloController.macetas.size(); m++) {
				if (ArticuloController.macetas.get(m).getCodigo_articulo() == codigo_articulo) {
					maceta = true;
					break;
				}
			}
		}
		if (planta == true) {
			String nombre_planta = "";
			String nombre_cientifico = "";
			boolean flor = false;
			String caracteristicas_regadio = "";
			while (exit != true) {
				System.out.println("Seleccione un apartado a modificar:"
						+ "\n1/Nombre de la planta\n2/Nombre cientifico\n3/Flor\n4/Caracteristicas de regadio\n5/Stock\n6/Precio\n0/Volver al menu principal");
				select = scan.nextLine();
				switch (select) {
				case "1":
					System.out.println("Introduzca el nombre de la planta:");
					nombre_planta = scan.nextLine();
					PlantaController.modificarNombre(nombre_planta, codigo_articulo);
					break;
				case "2":
					System.out.println("Introduzca el nombre cientifico:");
					nombre_cientifico = scan.nextLine();
					PlantaController.modificarNombreCientifico(nombre_cientifico, codigo_articulo);
					break;
				case "3":
					while (exit != true) {
						System.out.println("Indique si es o no una flor:" + "\n1/Es una flor " + "\n2/No es un a flor");
						select = scan.nextLine();
						switch (select) {
						case "1":
							exit = true;
							flor = true;
							break;
						case "2":
							exit = true;
							flor = false;
							break;
						default:
							System.out.println("Seleccione una opcion valida.");
						}
					}
					exit = false;
					PlantaController.modificarFlor(flor, codigo_articulo);
					break;
				case "4":
					while (exit != true) {
						System.out.println("Introduzca las caracteristicas de regadio:");
						caracteristicas_regadio = scan.nextLine();
						if (caracteristicas_regadio.length() > 100) {
							System.out.println("La longitud de la descripcion no debe rebasar los 100 caracteres.");
						} else {
							exit = true;
						}
					}
					exit = false;
					PlantaController.modificarCaracteristicasRegadio(caracteristicas_regadio, codigo_articulo);
					break;
				case "5":
					while (stock < 0) {
						System.out.println("Introduzca el stock del articulo:");
						stock = Integer.parseInt(scan.nextLine());
						if (stock < 0) {
							System.out.println("El stock debe ser positivo.");
						}
					}
					ArticuloController.modificarStock(stock, codigo_articulo);
					break;
				case "6":
					while (precio < 0) {
						System.out.println("Introduzca el precio del articulo:");
						precio = Double.parseDouble(scan.nextLine());
						if (precio < 0) {
							System.out.println("El stock debe ser positivo.");
						}
					}
					ArticuloController.modificarPrecio(precio, codigo_articulo);
					break;
				case "0":
					exit = true;
					break;
				default:
					System.out.println("Seleccione un opción valida");
				}
			}
		}
		if (maceta == true) {
			int alto_cm = -1;
			int diametro_cm = -1;
			String color = "";
			String material = "";
			boolean exterior = false;
			while (exit != true) {
				System.out.println("Seleccione el apartado a modificar:"
						+ "\n1/Altura de la maceta \n2/Diametro de la maceta \n3/Color de la maceta \n4/Material de la maceta "
						+ "\5/Maceta de exterior/interior \n6/Stock \n7/Precio \n0/Volver al menu principal");
				select = scan.nextLine();
				switch (select) {
				case "1":
					while (alto_cm < 0) {
						System.out.println("Introduzca la nueva altura de la maceta:");
						alto_cm = Integer.parseInt(scan.nextLine());
						if (alto_cm < 0) {
							System.out.println("La altura no puede ser negativa");
						}
					}
					MacetaController.modificarAltura(alto_cm, codigo_articulo);
					break;
				case "2":
					while (diametro_cm < 0) {
						System.out.println("Introduzca el nuevo diametro de la maceta:");
						diametro_cm = Integer.parseInt(scan.nextLine());
						if (diametro_cm < 0) {
							System.out.println("El diametro no puede ser negativo");
						}
					}
					MacetaController.modificarDiametro(diametro_cm, codigo_articulo);
					break;
				case "3":
					while (exit != true) {
						System.out.println("Selecccione el nuevo color de la maceta:" + "\n1/Blanco" + "\n2/Negro"
								+ "\n3/Gris" + "\n4/Verde" + "\n5/Rojo" + "\n6/Azul" + "\n7/Amarillo" + "\n8/Violeta"
								+ "\n9/Naranja");
						select = scan.nextLine();
						switch (select) {
						case "1":
							color = "Blanco";
							exit = true;
							break;
						case "2":
							color = "Negro";
							exit = true;
							break;
						case "3":
							color = "Gris";
							exit = true;
							break;
						case "4":
							color = "Verde";
							exit = true;
							break;
						case "5":
							color = "Rojo";
							exit = true;
							break;
						case "6":
							color = "Azul";
							exit = true;
							break;
						case "7":
							color = "Amarillo";
							exit = true;
							break;
						case "8":
							color = "Violeta";
							exit = true;
							break;
						case "9":
							color = "Naranja";
							exit = true;
							break;
						default:
							System.out.println("Seleccione una opcion valida.");
						}
					}
					exit = false;
					MacetaController.modificarColor(color, codigo_articulo);
					break;
				case "4":
					while (exit != true) {
						System.out.println("Seleccione el nuevo material de la maceta:" + "\n1/Plastico" + "\n2/Arcilla"
								+ "\n3/Piedra" + "\n4/Madera" + "\n5/Cemento" + "\n6/Fibrocemento");
						select = scan.next();
						switch (select) {
						case "1":
							material = "Plastico";
							exit = true;
							break;
						case "2":
							material = "Arcilla";
							exit = true;
							break;
						case "3":
							material = "Piedra";
							exit = true;
							break;
						case "4":
							material = "Madera";
							exit = true;
							break;
						case "5":
							material = "Cemento";
							exit = true;
							break;
						case "6":
							material = "Fibrocemneto";
							exit = true;
							break;
						default:
							System.out.println("Seleccione una opcion valida.");
						}
					}
					exit = false;
					MacetaController.modificarMaterial(material, codigo_articulo);
					break;
				case "5":
					while (exit != true) {
						System.out.println(
								"Seleccione el tipo de maceta" + "\n1/Maceta de exterior" + "\n2/Maceta de interior");
						select = scan.nextLine();
						switch (select) {
						case "1":
							exterior = true;
							exit = true;
							break;
						case "2":
							exterior = false;
							exit = false;
							break;
						default:
							System.out.println("Seleccione una opción válida.");
						}
					}
					exit = false;
					MacetaController.modificarExterior(exterior, codigo_articulo);
					break;
				case "6":
					while (stock < 0) {
						System.out.println("Introduzca el nuevo stock del articulo:");
						stock = Integer.parseInt(scan.nextLine());
						if (stock < 0) {
							System.out.println("El stock debe ser positivo.");
						}
					}
					ArticuloController.modificarStock(stock, codigo_articulo);
					break;
				case "7":
					while (precio < 0) {
						System.out.println("Introduzca el nuevo precio del articulo");
						precio = Double.parseDouble(scan.nextLine());
						if (precio < 0) {
							System.out.println("El precio no puede ser negativo");
						}
					}
					ArticuloController.modificarPrecio(precio, codigo_articulo);
					break;
				case "0":
					exit = true;
					break;
				default:
					System.out.println("Seleccione una opción válida:");
				}
			}
		}
		if (planta == false && maceta == false) {
			System.out.println("Articulo no encontrado");
		}
	}
}
