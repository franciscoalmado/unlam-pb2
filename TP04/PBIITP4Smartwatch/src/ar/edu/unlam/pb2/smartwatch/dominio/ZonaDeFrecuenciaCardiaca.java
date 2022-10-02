package ar.edu.unlam.pb2.smartwatch.dominio;

public enum ZonaDeFrecuenciaCardiaca {
	
	DESCANSO(50, 60),
	CALENTAMIENTO(60, 70),
	AEROBICO(70, 80),
	UMBRAL(80, 90),
	MAXIMO(90, 100);
	
	private int zonaMinima;
	private int zonaMaxima;
	
	private ZonaDeFrecuenciaCardiaca(int zonaMinima, int zonaMaxima){
		this.zonaMinima = zonaMinima;
		this.zonaMaxima = zonaMaxima;
	}
	
	public int getZonaMinima() {
		return this.zonaMinima;
	}
	
	public void setZonaMinima(int zonaMinima) {
		this.zonaMinima = zonaMinima;
	}

	public int getZonaMaxima() {
		return this.zonaMaxima;
	}	
	
	public void setZonaMaxima(int zonaMaxima) {
		this.zonaMaxima = zonaMaxima;
	}
}