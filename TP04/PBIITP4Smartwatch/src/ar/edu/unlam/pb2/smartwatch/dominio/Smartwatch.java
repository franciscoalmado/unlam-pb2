package ar.edu.unlam.pb2.smartwatch.dominio;

import java.time.LocalTime;

public class Smartwatch{

	private boolean encendido;
	private boolean isSensorActivado;
	private double distanciaRecorrida;
	private LocalTime tiempoTranscurrido;
	private int pasosDiarios;
	private int VALOR_MAXIMO_DE_PULSACIONES;
	private double velocidad;
	private int cadencia;
	private LocalTime ritmo;
	private double frecuenciaCardiacaEnReposo;
	
	public Smartwatch() {
		this.apagar();
		this.encender();
		this.activarSensor();
		this.distanciaRecorrida = 0;
		this.tiempoTranscurrido = null;
		this.pasosDiarios = 0;
		this.VALOR_MAXIMO_DE_PULSACIONES = 220;
		this.velocidad = 0.0;
		this.cadencia = 0;
		this.ritmo = null;
		this.frecuenciaCardiacaEnReposo = 0;
	}
	
	public void encender() {
		this.encendido = true;
	}
	
	public void apagar() {
		if(this.isEncendido() == true) {
			this.encendido = false;
		}
	}
	
	public boolean isEncendido() {
		if(this.encendido == true) {
			return true;
		}
		return false;
	}
	
	public void activarSensor() {
		if(this.isEncendido() == true) {
			this.isSensorActivado = true;
		}
	}
	
	public boolean isSensorActivado() {
		if(this.isSensorActivado == true) {
			return true;
		}	
		return false;
	}

	public void registrarDistanciaRecorrida(double distanciaRecorrida) {
		if(this.isSensorActivado() == true) {
			this.distanciaRecorrida += distanciaRecorrida;	
		}
	}
	
	public double getDistanciaRecorrida() {
		return this.distanciaRecorrida;
	}
	
	public void registrarTiempoTranscurrido(LocalTime tiempoTranscurrido) {
		if(this.isSensorActivado() == true) {
			this.tiempoTranscurrido = tiempoTranscurrido;	
		}
	}
	
	public LocalTime getTiempoTranscurrido() {
		return this.tiempoTranscurrido;
	}
	
	public void registrarPasosDiarios(int cantidadDePasos) {
		if(this.isSensorActivado() == true) {
			this.pasosDiarios += cantidadDePasos;
		}
	}
	
	public int getPasosDiarios() {
		return this.pasosDiarios;
	}
	
	public int getVALOR_MAXIMO_DE_PULSACIONES() {
		return this.VALOR_MAXIMO_DE_PULSACIONES;
	}
	
	public void registrarVelocidad(double velocidad) {
		if(this.isSensorActivado() == true) {
			this.velocidad = velocidad;
		}	
	}
	
	public double getVelocidad() {
		return this.velocidad;
	}

	public void registrarCadencia(int revolucionesPorMinutos) {
		if(this.isSensorActivado() == true) {
			this.cadencia = revolucionesPorMinutos;
		}
	}
	
	public int getCadencia() {
		return this.cadencia;
	}
	
	public void registrarRitmo(LocalTime minutosYSegundosEnCompletarCienMetros) {
		if(this.isSensorActivado() == true) {
			this.ritmo = minutosYSegundosEnCompletarCienMetros;
		}
	}
	
	public LocalTime getRitmo() {
		return this.ritmo;
	}
	
	public double calcularFrecuenciaCardiacaEnReposo(int valor1, int valor2, int valor3) {
		int cantidadDeMedidas = 3;
		
		this.frecuenciaCardiacaEnReposo = (valor1 + valor2 + valor3) / cantidadDeMedidas;
		
		return this.frecuenciaCardiacaEnReposo;
	}
	
	public double getFrecuenciaCardiacaEnReposo() {
		return this.frecuenciaCardiacaEnReposo;
	}
}