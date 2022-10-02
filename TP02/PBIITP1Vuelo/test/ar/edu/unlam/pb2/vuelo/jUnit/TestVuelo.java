package ar.edu.unlam.pb2.vuelo.jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.vuelo.dominio.Pasajero;
import ar.edu.unlam.pb2.vuelo.dominio.Vuelo;

public class TestVuelo {

	@Test
	public void queSePuedaCrearUnPasajero() {
		Pasajero nuevo = new Pasajero(12345678, "Leonardo", "Belloti");
		
		assertNotNull(nuevo);
	}
	
	@Test
	public void queSePuedaCrearUnVuelo() {
		Vuelo vuelo = new Vuelo("Buenos Aires", "Miami", 192);
		
		assertNotNull(vuelo);
	}

	@Test
	public void queSePuedaAgregarUnPasajeroAUnVuelo() {
		Pasajero nuevo = new Pasajero(12345678, "Leonardo", "Belloti");
		Vuelo vuelo = new Vuelo("Buenos Aires", "Miami", 192); 
		
		assertNotNull(nuevo);
		assertNotNull(vuelo);
		
		assertTrue(vuelo.agregarPasajero(nuevo));
	}
	
	@Test
	public void queSePuedaVerificarSiUnAsientoEstaDisponible() {
		Pasajero nuevo = new Pasajero(12345678, "Leonardo", "Belloti");
		Vuelo vuelo = new Vuelo("Buenos Aires", "Miami", 192); 
		
		assertNotNull(nuevo);
		assertNotNull(vuelo);
		
		assertTrue(vuelo.verificarDisponibilidadAsiento(2, 3));	
	}
	
	@Test
	public void queSePuedaAsignarUnAsientoQueEstaDisponible() {
		Pasajero nuevo = new Pasajero(12345678, "Leonardo", "Belloti");
		Vuelo vuelo = new Vuelo("Buenos Aires", "Miami", 192); 
		
		assertNotNull(nuevo);
		assertNotNull(vuelo);
		
		assertTrue(vuelo.asignarAsiento(nuevo, 2, 3));	
	}
	
	@Test
	public void queSePuedaBuscarUnPasajeroPorSuNumeroDeDni() {
		Pasajero nuevo = new Pasajero(12345678, "Leonardo", "Belloti");
		Vuelo vuelo = new Vuelo("Buenos Aires", "Miami", 192); 
		
		assertNotNull(nuevo);
		assertNotNull(vuelo);
		
		vuelo.buscarPasajero(nuevo.getDni());
	}
	
	@Test
	public void queSePuedaOrdenarLaListaDePasajerosPorDni() {
		Pasajero nuevo1 = new Pasajero(12345678, "Leonardo", "Belloti");
		Pasajero nuevo2 = new Pasajero(11234567, "María", "Pérez");
		Pasajero nuevo3 = new Pasajero(8515678, "Carolina", "Amoroso");
		Pasajero nuevo4 = new Pasajero(14523456, "Jesús", "Delgado");
		Pasajero nuevo5 = new Pasajero(16734911, "Jorge", "García");
		Vuelo vuelo = new Vuelo("Buenos Aires", "Miami", 192); 
		
		assertNotNull(nuevo1);
		assertNotNull(nuevo2);
		assertNotNull(nuevo3);
		assertNotNull(nuevo4);
		assertNotNull(nuevo5);
		assertNotNull(vuelo);
		
		assertNotNull(vuelo.getPasajeros());
		vuelo.ordenarListaDePasajerosPorDNI();
	}
	
	@Test
	public void queSePuedaMostrarElMapaDeAsientos() {
		Pasajero nuevo1 = new Pasajero(12345678, "Leonardo", "Belloti");
		Pasajero nuevo2 = new Pasajero(11234567, "María", "Pérez");
		Pasajero nuevo3 = new Pasajero(8515678, "Carolina", "Amoroso");
		Pasajero nuevo4 = new Pasajero(14523456, "Jesús", "Delgado");
		Pasajero nuevo5 = new Pasajero(16734911, "Jorge", "García");
		Vuelo vuelo = new Vuelo("Buenos Aires", "Miami", 192); 
		
		assertNotNull(nuevo1);
		assertNotNull(nuevo2);
		assertNotNull(nuevo3);
		assertNotNull(nuevo4);
		assertNotNull(nuevo5);
		assertNotNull(vuelo);
		
		vuelo.toString();
		
	}	
}