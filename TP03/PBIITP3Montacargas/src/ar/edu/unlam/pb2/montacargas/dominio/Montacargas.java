package ar.edu.unlam.pb2.montacargas.dominio;

public class Montacargas {
	
	private int pesoMaximo;
	private int sumaDeCargas;
	
	public Montacargas(int pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
		this.sumaDeCargas = 0;
	}
	
	public void incorporarCargas(int carga) throws Exception{
	
		if(this.sumaDeCargas + carga > this.pesoMaximo)
			throw new Exception("Sobrepeso");
		
		this.sumaDeCargas += carga;
	}
	
	public int getSumaDeCargas() {
		return this.sumaDeCargas;
	}
	
	public int getPesoMaximo() {
		return this.pesoMaximo;
	}
}