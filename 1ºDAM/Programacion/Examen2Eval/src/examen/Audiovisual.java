package examen;

import java.util.Random;
public abstract class Audiovisual {
	public enum plataformas {NETFLIX, HBO, MOVISTAR, AMAZON, DISNEY, OTROS};
	private plataformas plataforma;
	private String titulo, director;
	private int anhoPubli;
	
	public Audiovisual(plataformas plataforma, String titulo, String director, int anhoPubli) {
		super();
		this.plataforma = plataforma;
		this.titulo = titulo;
		this.director = director;
		this.anhoPubli = anhoPubli;
	}

	public plataformas getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(plataformas plataforma) {
		this.plataforma = plataforma;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getAnhoPubli() {
		return anhoPubli;
	}

	public void setAnhoPubli(int anhoPubli) {
		this.anhoPubli = anhoPubli;
	}
	
	//Editar el toString para reaprovecharlo en las clases hijas

	@Override
	public String toString() {
		String string;
		string = "Pelicula : " + getTitulo() + ", dirigida por " + getDirector() + "\n"
				+ "A�o de publicacion : " + getAnhoPubli() + "\n" + "Plataforma: " + getPlataforma() + "\n";
		return string;
	}
	
	public abstract int duracionTotal();
	
	public static plataformas randomPlataforma() {
		plataformas plataforma = plataformas.AMAZON;
		int aux;
		Random random = new Random();
		aux = random.nextInt(6 + 1);
		switch(aux) {
		case 1: 
			plataforma = plataformas.AMAZON;
			break;
		case 2: 
			plataforma = plataformas.NETFLIX;
			break;
		case 3:
			plataforma = plataformas.HBO;
			break;
		case 4: 
			plataforma = plataformas.MOVISTAR;
			break;
		case 5: 
			plataforma = plataformas.DISNEY;
			break;
		case 6: 
			plataforma = plataformas.OTROS;
		}
		return plataforma;
	}
}
