package ar.edu.unlam.pb2.montacargas.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.montacargas.dominio.Montacargas;

public class TestMontacargas {

	@Test
	public void queSePuedaCrearUnMontacargas() {
		Montacargas cat = new Montacargas(5000);
	
		assertNotNull(cat);
	}
	
	@Test
	public void queSePuedanIncrementarSuCarga() throws Exception {
		Montacargas cat = new Montacargas(5000);
	
		assertNotNull(cat);
		
		cat.incorporarCargas(500);
	}
}