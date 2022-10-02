package ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio;

public enum TipoDeActividad {

	SEDENTARIA(0.30),
	MODERADA(0.50),
	EXTREMA(1.0);
	
	double valor;
	
	TipoDeActividad(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return this.valor;
	}
}