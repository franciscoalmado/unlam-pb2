package ar.edu.unlam.pb2.smartwatch.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.smartwatch.dominio.Caminante;
import ar.edu.unlam.pb2.smartwatch.dominio.Ciclista;
import ar.edu.unlam.pb2.smartwatch.dominio.Disciplina;
import ar.edu.unlam.pb2.smartwatch.dominio.Nadador;
import ar.edu.unlam.pb2.smartwatch.dominio.Runner;
import ar.edu.unlam.pb2.smartwatch.dominio.Smartwatch;
import ar.edu.unlam.pb2.smartwatch.dominio.ZonaDeFrecuenciaCardiaca;

public class TestSmartwatch {

	@Test
	public void queSePuedaCrearUnSmartwatch() {
		Smartwatch nuevo = new Smartwatch();
		
		assertNotNull(nuevo);
	}
	
	@Test
	public void queSePuedaActivarLosSensoresDelSmartwatch() {
		Smartwatch nuevo = new Smartwatch();
		
		assertNotNull(nuevo);
		
		nuevo.encender();
		
		assertTrue(nuevo.isEncendido());
		
		nuevo.apagar();
		
		assertFalse(nuevo.isEncendido());
		
		nuevo.encender();
		
		nuevo.activarSensor();
		
		assertTrue(nuevo.isSensorActivado());
		
	}
	
	@Test
	public void queSePuedaCrearUnPerfilDeportistaEnElSmartwatch() {
		Caminante caminante = new Caminante("Leonardo", 25, 75.5, 175);
		Runner runner = new Runner("Matías", 33, 82.5, 185);
		Ciclista ciclista = new Ciclista("Francisco", 37, 75.5, 170);
		Nadador nadadora = new Nadador("Carolina", 30, 65, 168);
		
		assertNotNull(caminante);
		assertNotNull(runner);
		assertNotNull(ciclista);
		assertNotNull(nadadora);
	}
	
	@Test
	public void queSePuedaConfigurarUnaZonaDeFrecuenciaCardiacaDeUnDeportistaCiclistaORunner() {
		Smartwatch nuevo = new Smartwatch();
		Caminante caminante = new Caminante("Leonardo", 25, 75.5, 175);
		Runner runner = new Runner("Matías", 33, 82.5, 185);
		Ciclista ciclista = new Ciclista("Francisco", 37, 75.5, 170);
		Nadador nadadora = new Nadador("Carolina", 30, 65, 168);
		
		assertNotNull(nuevo);
		assertNotNull(caminante);
		assertNotNull(runner);
		assertNotNull(ciclista);
		assertNotNull(nadadora);
		
		ciclista.configurarZonasDeFrecuenciaCardiaca(Disciplina.CICLISMO);
		runner.configurarZonasDeFrecuenciaCardiaca(Disciplina.CARRERA);	
	}
	
	@Test
	public void queSePuedaRegistrarLaFrecuenciaCardiacaDeUnDeportistaCiclistaORunner() {
		Smartwatch nuevo = new Smartwatch();
		Caminante caminante = new Caminante("Leonardo", 25, 75.5, 175);
		Runner runner = new Runner("Matías", 33, 82.5, 185);
		Ciclista ciclista = new Ciclista("Francisco", 37, 75.5, 170);
		Nadador nadadora = new Nadador("Carolina", 30, 65, 168);
		
		assertNotNull(nuevo);
		assertNotNull(caminante);
		assertNotNull(runner);
		assertNotNull(ciclista);
		assertNotNull(nadadora);
		
		ciclista.configurarZonasDeFrecuenciaCardiaca(Disciplina.CICLISMO);
		runner.configurarZonasDeFrecuenciaCardiaca(Disciplina.CARRERA);
		
		ciclista.registrarFrecuenciaCardiaca(140);
		runner.registrarFrecuenciaCardiaca(155);
		
		assertEquals(ZonaDeFrecuenciaCardiaca.UMBRAL, ciclista.getZonaFrecuenciaCardiacaActual());
		assertEquals(ZonaDeFrecuenciaCardiaca.AEROBICO, runner.getZonaFrecuenciaCardiacaActual());
	}
}