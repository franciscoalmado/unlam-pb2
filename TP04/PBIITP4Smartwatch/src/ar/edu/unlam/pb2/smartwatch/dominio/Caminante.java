package ar.edu.unlam.pb2.smartwatch.dominio;

public class Caminante extends Deportista{

	private Disciplina disciplina;
	
	public Caminante(String nombre, int edadActual, double pesoActual, double alturaActual) {
		super(nombre, edadActual, pesoActual, alturaActual);
		this.disciplina = Disciplina.CAMINATA;	
	}
	
	public Disciplina getDisciplina() {
		return this.disciplina;
	}
	
	public String toString() {
		return "[Distancia: " + this.getDistanciaRecorrida() + " km" + ", Tiempo: " + this.getTiempoTranscurrido() + ", Pasos: " + this.getPasosDiarios() + "]";	
	}
}