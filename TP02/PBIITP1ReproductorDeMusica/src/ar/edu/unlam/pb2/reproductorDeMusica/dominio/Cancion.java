package ar.edu.unlam.pb2.reproductorDeMusica.dominio;

public class Cancion {

	private String titulo;
	private String autor;
	private String album;
	private int minutos;
	private int segundos;
	
	public Cancion(String titulo, String autor, String album, int minutos, int segundos) {
		this.titulo = titulo;
		this.autor = autor;
		this.album = album;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAlbum() {
		return this.album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getMinutos() {
		return this.minutos;
	}

	public int getSegundos() {
		return this.segundos;
	}
	
	public void setMinutos(int minutos) {		
		this.minutos = minutos;
	}
	
	public void setSegundos(int segundos) {		
		this.segundos = segundos;
	}

	@Override
	public String toString() {
		return "Canción [Título: " + this.titulo + ", Autor: " + this.autor + ", Album: " + this.album + ", Duración: " + this.minutos + ": " + this.segundos + "]";
	}	
}