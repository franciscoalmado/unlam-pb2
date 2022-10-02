package ar.edu.unlam.pb2.futsal.dominio;

public class Jugador {

	private int numero;
	private String nombre;
	private int edad;
	private double precio;
	
	public Jugador(int numero, String nombre, int edad, double precio) {
		this.numero = numero;
		this.nombre = nombre;
		this.edad = edad;
		this.precio = precio;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
}