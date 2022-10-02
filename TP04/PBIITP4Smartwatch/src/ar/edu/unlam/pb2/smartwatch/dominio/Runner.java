package ar.edu.unlam.pb2.smartwatch.dominio;

public class Runner extends Deportista {

	private Disciplina disciplina;
	private int frecuenciaCardiacaMaxima;
	private ZonaDeFrecuenciaCardiaca zona;
	private double frecuenciaMinimaDescanso;
	private double frecuenciaMaximaDescanso;
	private double frecuenciaMinimaCalentamiento;
	private double frecuenciaMaximaCalentamiento;
	private double frecuenciaMinimaAerobico;
	private double frecuenciaMaximaAerobico;
	private double frecuenciaMinimaUmbral;
	private double frecuenciaMaximaUmbral;
	private double frecuenciaMinimaMaximo;
	private double frecuenciaMaximaMaximo;
	
	public Runner(String nombre, int edadActual, double pesoActual, double alturaActual) {
		super(nombre, edadActual, pesoActual, alturaActual);
		this.disciplina = Disciplina.CARRERA;
		this.calcularFrecuenciaCardiacaMaxima();
	}
	
	public Disciplina getDisciplina() {
		return this.disciplina;
	}
		
	private int calcularFrecuenciaCardiacaMaxima() {
		
		this.frecuenciaCardiacaMaxima = this.getVALOR_MAXIMO_DE_PULSACIONES() - this.getEdadActual();
		
		return this.frecuenciaCardiacaMaxima;
	}
	
	public void configurarZonasDeFrecuenciaCardiaca(Disciplina disciplina) {
		int valorMinimo;
		int valorMaximo;
		int conversion = 100;
		double frecuenciaCardiacaDeEntrenamiento = 0;
		
		frecuenciaCardiacaDeEntrenamiento = this.frecuenciaCardiacaMaxima - this.getFrecuenciaCardiacaEnReposo();
		
		if(disciplina.equals(Disciplina.CARRERA)) {	
			valorMinimo = 55;
			valorMaximo = 65;
			
			ZonaDeFrecuenciaCardiaca.DESCANSO.setZonaMinima(valorMinimo);
			ZonaDeFrecuenciaCardiaca.DESCANSO.setZonaMinima(valorMaximo);
			
			this.frecuenciaMinimaDescanso = Math.round((frecuenciaCardiacaDeEntrenamiento * valorMinimo / conversion) + this.getFrecuenciaCardiacaEnReposo());
			this.frecuenciaMaximaDescanso = Math.round((frecuenciaCardiacaDeEntrenamiento * valorMaximo / conversion) + this.getFrecuenciaCardiacaEnReposo());
		}
		
		if(disciplina.equals(Disciplina.CARRERA)) {	
			valorMinimo = 65;
			valorMaximo = 75;
			
			ZonaDeFrecuenciaCardiaca.CALENTAMIENTO.setZonaMinima(valorMinimo);
			ZonaDeFrecuenciaCardiaca.CALENTAMIENTO.setZonaMinima(valorMaximo);
			
			this.frecuenciaMinimaCalentamiento = Math.round((frecuenciaCardiacaDeEntrenamiento * valorMinimo / conversion) + this.getFrecuenciaCardiacaEnReposo());
			this.frecuenciaMaximaCalentamiento = Math.round((frecuenciaCardiacaDeEntrenamiento * valorMaximo / conversion) + this.getFrecuenciaCardiacaEnReposo());
		}
		
		if(disciplina.equals(Disciplina.CARRERA)) {	
			valorMinimo = 75;
			valorMaximo = 85;
			
			ZonaDeFrecuenciaCardiaca.AEROBICO.setZonaMinima(valorMinimo);
			ZonaDeFrecuenciaCardiaca.AEROBICO.setZonaMinima(valorMaximo);
			
			this.frecuenciaMinimaAerobico = Math.round((frecuenciaCardiacaDeEntrenamiento * valorMinimo / conversion) + this.getFrecuenciaCardiacaEnReposo());
			this.frecuenciaMaximaAerobico = Math.round((frecuenciaCardiacaDeEntrenamiento * valorMaximo / conversion) + this.getFrecuenciaCardiacaEnReposo());
		}
		
		if(disciplina.equals(Disciplina.CARRERA)) {	
			valorMinimo = 85;
			valorMaximo = 95;
			
			ZonaDeFrecuenciaCardiaca.UMBRAL.setZonaMinima(valorMinimo);
			ZonaDeFrecuenciaCardiaca.UMBRAL.setZonaMinima(valorMaximo);
			
			this.frecuenciaMinimaUmbral = Math.round((frecuenciaCardiacaDeEntrenamiento * valorMinimo / conversion) + this.getFrecuenciaCardiacaEnReposo());
			this.frecuenciaMaximaUmbral = Math.round((frecuenciaCardiacaDeEntrenamiento * valorMaximo / conversion) + this.getFrecuenciaCardiacaEnReposo());
		}
		if(disciplina.equals(Disciplina.CARRERA)) {	
			valorMinimo = 95;
			valorMaximo = 100;
			
			ZonaDeFrecuenciaCardiaca.MAXIMO.setZonaMinima(valorMinimo);
			ZonaDeFrecuenciaCardiaca.MAXIMO.setZonaMinima(valorMaximo);
			
			this.frecuenciaMinimaMaximo = Math.round((frecuenciaCardiacaDeEntrenamiento * valorMinimo / conversion) + this.getFrecuenciaCardiacaEnReposo());
			this.frecuenciaMaximaMaximo = Math.round((frecuenciaCardiacaDeEntrenamiento * valorMaximo / conversion) + this.getFrecuenciaCardiacaEnReposo());
		}
	}
	
	public void registrarFrecuenciaCardiaca(int frecuenciaCardiaca) {
		
		if(this.isSensorActivado() == true) {	
			
			if(this.frecuenciaMinimaDescanso <= frecuenciaCardiaca && frecuenciaCardiaca <= this.frecuenciaMaximaDescanso) {
				this.zona = ZonaDeFrecuenciaCardiaca.DESCANSO;	
			}
			if(this.frecuenciaMinimaCalentamiento < frecuenciaCardiaca && frecuenciaCardiaca <= this.frecuenciaMaximaCalentamiento) {
				this.zona = ZonaDeFrecuenciaCardiaca.CALENTAMIENTO;
			}
			if(this.frecuenciaMinimaAerobico < frecuenciaCardiaca && frecuenciaCardiaca <= this.frecuenciaMaximaAerobico) {
				this.zona = ZonaDeFrecuenciaCardiaca.AEROBICO;
			}
			if(this.frecuenciaMinimaUmbral < frecuenciaCardiaca && frecuenciaCardiaca <= this.frecuenciaMaximaUmbral) {
				this.zona = ZonaDeFrecuenciaCardiaca.UMBRAL;
			}
			if(this.frecuenciaMinimaMaximo < frecuenciaCardiaca && frecuenciaCardiaca <= this.frecuenciaMaximaMaximo) {
				this.zona = ZonaDeFrecuenciaCardiaca.MAXIMO;
			}
		}
	}
	
	public ZonaDeFrecuenciaCardiaca getZonaFrecuenciaCardiacaActual() {
		return this.zona;
	}
	
	public String toString() {
		return "[Distancia: " + this.getDistanciaRecorrida() + " km" +  ", Tiempo: " + this.getTiempoTranscurrido() + ", Ritmo: " + this.getRitmo()
				+ " min/km" +", Zona de frecuencia cardíaca: " + this.getZonaFrecuenciaCardiacaActual() + "]";	
	}
}