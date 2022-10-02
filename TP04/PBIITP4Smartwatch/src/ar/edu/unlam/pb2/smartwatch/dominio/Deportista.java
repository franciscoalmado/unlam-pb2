package ar.edu.unlam.pb2.smartwatch.dominio;

public abstract class Deportista extends Smartwatch{
	
	private String nombre;
	private int edadActual;
	private double pesoActual;
	private double alturaActual;
	
	public Deportista(String nombre, int edadActual, double pesoActual, double alturaActual) {
		super();
		this.nombre = nombre;
		this.edadActual = edadActual;
		this.pesoActual = pesoActual;
		this.alturaActual = alturaActual;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public int getEdadActual() {
		return this.edadActual;
	}

	public void setEdadActual(int edadActual) {
		this.edadActual = edadActual;
	}

	public double getPesoActual() {
		return this.pesoActual;
	}

	public void setPesoActual(double pesoActual) {
		this.pesoActual = pesoActual;
	}

	public double getAlturaActual() {
		return this.alturaActual;
	}

	public void setAlturaActual(double alturaActual) {
		this.alturaActual = alturaActual;
	}
	
	public abstract Disciplina getDisciplina();

	@Override
	public abstract String toString();
}