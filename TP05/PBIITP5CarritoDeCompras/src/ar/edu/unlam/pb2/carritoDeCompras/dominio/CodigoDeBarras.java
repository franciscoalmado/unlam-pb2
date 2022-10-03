package ar.edu.unlam.pb2.carritoDeCompras.dominio;

public class CodigoDeBarras {

	private final int LONGITUD;
	private String codigoDeBarras;
	
	public CodigoDeBarras() {
		this.LONGITUD = 20;
		this.codigoDeBarras = "";
		this.generarCodigoDeBarrasDeFormaAleatoria();
	}
	
	private String generarCodigoDeBarrasDeFormaAleatoria() {
		int comienzoASCII = 48;
		int finASCII = 57;
		int valorRandom;
		int contador = 0;
	
		while(contador < this.LONGITUD){
			do {
				valorRandom = (int) ((Math.random() * finASCII) + comienzoASCII);
			}while(!(isNumero(valorRandom)));

			valorRandom = (char) valorRandom;
			this.codigoDeBarras += String.valueOf((char) valorRandom);
			contador++;
		}	
		
		return this.codigoDeBarras;
	}

	private boolean isNumero(int valorATestear) {
		return ((valorATestear > 47) && (valorATestear < 58));
	}	
	
	public String getCodigoDeBarras() {
		return this.codigoDeBarras;
	}	
}