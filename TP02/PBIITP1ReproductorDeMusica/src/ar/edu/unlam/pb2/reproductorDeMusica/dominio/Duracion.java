package ar.edu.unlam.pb2.reproductorDeMusica.dominio;

public class Duracion {

	private int minutos;
	private int segundos;
	
	public Duracion(int minutos, int segundos) {
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	public String calcularMinutosYSegundos(int minutos, int segundos) {
		int segundosCalculados = 0;
		int minutosCalculados = 0;
		int segundosRecibidos = segundos;
		int minutosRecibidos = minutos;
		int segundosEnUnMinuto = 60;
		int minutosEnUnaHora = 60;
		int contador = 0;
		int limiteInferior = 0;
		int limiteSuperior = 10;
		String resultado = "";
		
		if(minutosEnUnaHora > minutos && segundosEnUnMinuto > segundos) {
			resultado = "" + minutos + ":" +segundos + " ";	
		}else {
			do {
				if(segundosRecibidos >= segundosEnUnMinuto) {
					segundosCalculados = segundosRecibidos - segundosEnUnMinuto;
					contador++;
					segundosRecibidos -= segundosEnUnMinuto;
				}
				
				minutosCalculados = minutosRecibidos + contador;
			}while(segundosCalculados >= segundosEnUnMinuto);
			
			if(segundosCalculados >= limiteInferior && segundosCalculados < limiteSuperior) {
				resultado = "" + minutosCalculados + ":0" +segundosCalculados + " ";
			}
		}
		
		if(segundosCalculados >= limiteSuperior) {
			resultado = "" + minutosCalculados + ":" +segundosCalculados + " ";	
		}
			
		return resultado;
	}
	
	public boolean validarMinutosYSegundos(int minutos , int segundos) {
		boolean isValido = false;
		int limiteInferior = 0;
		int limiteSuperior = 60;
		
		if(minutos >= limiteInferior || minutos < limiteSuperior && segundos >= limiteInferior || segundos < limiteSuperior) {
			isValido = true;
		}
		
		return isValido;
	}
	
	public int getMinutos() {
		return this.minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return this.segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	
	@Override
	public String toString() {
		return "" + this.minutos + ":" + this.segundos + "";
	}	
}