package oldExample;

public class Pelicula {

	private String titulo;
	private String tituloOriginal;
	private double puntuacion;
	private int anyo;

	public Pelicula(String titulo, String tituloOriginal, double puntuacion, int anyo) {
		super();
		this.titulo = titulo;
		this.tituloOriginal = tituloOriginal;
		this.puntuacion = puntuacion;
		this.anyo = anyo;
	}

	public Pelicula() {
		super();
	}

	public String toString() {
		String text = "Titulo: " + this.titulo + " / " + this.tituloOriginal + "\nPuntuacion: " + this.puntuacion
				+ "\nAnyo: " + this.anyo;

		return text;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTituloOriginal() {
		return tituloOriginal;
	}

	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

}
