package ar.edu.unlam.pb2.domotica.dominio;

public class HuellaDactilar {

	private final int LONGITUD;
	private String huellaDactilar;
	
	public HuellaDactilar() {
		this.LONGITUD = 20;
		this.huellaDactilar = "";
		this.generarHuellaDactilarDeFormaAleatoria();
	}
	
	private String generarHuellaDactilarDeFormaAleatoria() {
		int comienzoASCII = 48;
		int finASCII = 57;
		int valorRandom;
		int contador = 0;
	
		while(contador < this.LONGITUD){
			do {
				valorRandom = (int) ((Math.random() * finASCII) + comienzoASCII);
			}while(!(isNumero(valorRandom)));

			valorRandom = (char) valorRandom;
			this.huellaDactilar += String.valueOf((char) valorRandom);
			contador++;
		}	
		
		return this.huellaDactilar;
	}

	private boolean isNumero(int valorATestear) {
		return ((valorATestear > 47) && (valorATestear < 58));
	}	
	
	public String getHuellaDactilar() {
		return this.huellaDactilar;
	}	
}