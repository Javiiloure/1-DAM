public class Libro {
	private String ISBN;
	private String titulo;
	private String autor;
	private int paginas;
	public Libro() {		//Se utiliza un constructor vacio cuando el valor de los atributos se asigna m?s adelante.
		this.ISBN = "";
		this.titulo = "";
		this.autor = "";
		this.paginas = 0;
	}
	
	public Libro(String ISBN, String titulo, String autor, int paginas) { //Este es el constructor
		this.ISBN = ISBN;
		this.autor = autor;
		this.titulo = titulo;
		this.paginas = paginas;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String gettitulo() {
		return titulo;
	}

	public void settitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getautor() {
		return autor;
	}

	public void setautor(String autor) {
		this.autor = autor;
	}

	public int getpaginas() {
		return paginas;
	}

	public void setpaginas(int paginas) {
		this.paginas = paginas;
	}

	public String toString() {
		String mensaje = "El libro con ISBN " + getISBN() + " creado por el autor " + getautor() + " tiene " + getpaginas()
				+ " paginas.";
		return mensaje;
	}
}