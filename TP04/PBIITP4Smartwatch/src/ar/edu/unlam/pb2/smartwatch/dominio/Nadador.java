package ar.edu.unlam.pb2.smartwatch.dominio;

public class Nadador extends Deportista {

	private Disciplina disciplina;

	public Nadador(String nombre, int edadActual, double pesoActual, double alturaActual) {
		super(nombre, edadActual, pesoActual, alturaActual);
		this.disciplina = Disciplina.NATACION;
	}
	
	public Disciplina getDisciplina() {
		return this.disciplina;
	}
		
	public String toString() {
		return "[Distancia: " + this.getDistanciaRecorrida() + " m" + ", Tiempo: " + this.getTiempoTranscurrido() + ", Ritmo: " + this.getRitmo() + " min/100 m" + "]";
	}		
}