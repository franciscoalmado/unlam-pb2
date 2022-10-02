package ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio;

public abstract class AporteEnergetico {
	
	public AporteEnergetico() {

	}
	
	public abstract void calcularEnergia();
	
	public abstract void calcularCarbohidratos();
	
	public abstract void calcularProteinas();
	
	public abstract void calcularLipidos();	
}