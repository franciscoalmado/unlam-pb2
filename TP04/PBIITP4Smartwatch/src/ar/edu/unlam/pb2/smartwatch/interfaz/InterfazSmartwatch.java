package ar.edu.unlam.pb2.smartwatch.interfaz;

import java.time.LocalTime;

import ar.edu.unlam.pb2.smartwatch.dominio.Caminante;
import ar.edu.unlam.pb2.smartwatch.dominio.Ciclista;
import ar.edu.unlam.pb2.smartwatch.dominio.Disciplina;
import ar.edu.unlam.pb2.smartwatch.dominio.Nadador;
import ar.edu.unlam.pb2.smartwatch.dominio.Runner;

public class InterfazSmartwatch {

	public static void main(String[] args) {
		Caminante caminante = new Caminante("Leonardo", 25, 75.5, 175);
		Runner runner = new Runner("Matías", 33, 82.5, 185);
		Ciclista ciclista = new Ciclista("Francisco", 37, 75.5, 170);
		Nadador nadadora = new Nadador("Carolina", 30, 65, 168);
		
		System.out.println("-----------------------------------------------------------");
		caminante.registrarDistanciaRecorrida(0.1);
		caminante.registrarDistanciaRecorrida(0.1);
		caminante.registrarDistanciaRecorrida(0.05);
		caminante.registrarDistanciaRecorrida(0.12);
		caminante.registrarDistanciaRecorrida(0.13);
		caminante.registrarDistanciaRecorrida(0.08);
		LocalTime tiempo1;
		tiempo1 = LocalTime.of(5, 23);
		caminante.registrarTiempoTranscurrido(tiempo1);
		caminante.registrarPasosDiarios(3000);
		System.out.println(caminante.toString());
		System.out.println("-----------------------------------------------------------");
	
		System.out.println("-----------------------------------------------------------");
		runner.calcularFrecuenciaCardiacaEnReposo(62, 65, 63);
		runner.configurarZonasDeFrecuenciaCardiaca(Disciplina.CARRERA);
		runner.registrarDistanciaRecorrida(1);
		runner.registrarDistanciaRecorrida(1);
		runner.registrarDistanciaRecorrida(0.5);
		runner.registrarDistanciaRecorrida(1.2);
		runner.registrarDistanciaRecorrida(1.3);
		runner.registrarDistanciaRecorrida(0.8);
		LocalTime tiempo2;
		tiempo2 = LocalTime.of(5, 30);
		runner.registrarRitmo(tiempo2);
		LocalTime tiempo3;
		tiempo3 = LocalTime.of(1, 15, 16);
		runner.registrarTiempoTranscurrido(tiempo3);
		runner.registrarPasosDiarios(10000);
		runner.registrarFrecuenciaCardiaca(151);
		System.out.println(runner.toString());
		System.out.println("-----------------------------------------------------------");
		
		System.out.println("-----------------------------------------------------------");
		ciclista.calcularFrecuenciaCardiacaEnReposo(62, 65, 63);
		ciclista.configurarZonasDeFrecuenciaCardiaca(Disciplina.CICLISMO);
		ciclista.registrarDistanciaRecorrida(1);
		ciclista.registrarDistanciaRecorrida(1.5);
		ciclista.registrarDistanciaRecorrida(1.6);
		ciclista.registrarDistanciaRecorrida(2);
		ciclista.registrarDistanciaRecorrida(1);
		ciclista.registrarDistanciaRecorrida(1.1);
		ciclista.registrarCadencia(50);
		LocalTime tiempo4;
		tiempo4 = LocalTime.of(0, 30, 35);
		ciclista.registrarTiempoTranscurrido(tiempo4);
		ciclista.registrarVelocidad(22.5);
		ciclista.registrarFrecuenciaCardiaca(151);
		System.out.println(ciclista.toString());
		System.out.println("-----------------------------------------------------------");
	
		System.out.println("-----------------------------------------------------------");
		nadadora.registrarDistanciaRecorrida(50);
		nadadora.registrarDistanciaRecorrida(50);
		nadadora.registrarDistanciaRecorrida(50);
		nadadora.registrarDistanciaRecorrida(50);
		nadadora.registrarDistanciaRecorrida(50);
		nadadora.registrarDistanciaRecorrida(50);
		nadadora.registrarDistanciaRecorrida(50);
		nadadora.registrarDistanciaRecorrida(50);
		LocalTime tiempo5;
		tiempo5 = LocalTime.of(0, 12, 15);
		nadadora.registrarTiempoTranscurrido(tiempo5);
		nadadora.registrarPasosDiarios(2000);
		LocalTime tiempo6;
		tiempo6 = LocalTime.of(4, 03);
		nadadora.registrarRitmo(tiempo6);
		System.out.println(nadadora.toString());
		System.out.println("-----------------------------------------------------------");
	}
}