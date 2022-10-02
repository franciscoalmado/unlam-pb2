package ar.edu.unlam.pb2.futsal.jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.futsal.dominio.EquipoDeFutbol;
import ar.edu.unlam.pb2.futsal.dominio.Evento;
import ar.edu.unlam.pb2.futsal.dominio.Jugador;
import ar.edu.unlam.pb2.futsal.dominio.PartidoDeFutbol;
import ar.edu.unlam.pb2.futsal.dominio.TipoDeEvento;

public class TestFutsal {

	@Test
	public void queSePuedaCrearUnNuevoJugador() {
		Jugador nuevo = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		
		assertNotNull(nuevo);
	}
	
	@Test
	public void queSePuedaCrearUnEquipoDeFutbol() {
		EquipoDeFutbol nuevo = new EquipoDeFutbol("F.C. Barcelona");
	
		assertNotNull(nuevo);
	}
	
	@Test
	public void queSePuedaAgregarUnNuevoJugadorAlEquipo() {
		EquipoDeFutbol nuevo = new EquipoDeFutbol("F.C. Barcelona");
		Jugador jugador1 = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		Jugador jugador2 = new Jugador(21, "Didác Plana", 32, 22000000.0);
		Jugador jugador3 = new Jugador(4, "André Coelho", 29, 21700000.0);
		Jugador jugador4 = new Jugador(8, "Adolfo", 29, 19000000.0);
		Jugador jugador5 = new Jugador(11, "Ferrao", 32, 21500000.0);
		
		assertTrue(nuevo.agregarJugador(jugador1));
		assertTrue(nuevo.agregarJugador(jugador2));
		assertTrue(nuevo.agregarJugador(jugador3));
		assertTrue(nuevo.agregarJugador(jugador4));
		assertTrue(nuevo.agregarJugador(jugador5));
		assertFalse(nuevo.agregarJugador(jugador1));
	}
	
	@Test
	public void queSePuedaBuscarUnJugadorPorSuNombre() {
		EquipoDeFutbol nuevo = new EquipoDeFutbol("F.C. Barcelona");
		Jugador jugador1 = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		Jugador jugador2 = new Jugador(21, "Didác Plana", 32, 22000000.0);
		Jugador jugador3 = new Jugador(4, "André Coelho", 29, 21700000.0);
		Jugador jugador4 = new Jugador(8, "Adolfo", 29, 19000000.0);
		Jugador jugador5 = new Jugador(11, "Ferrao", 32, 21500000.0);
		
		assertTrue(nuevo.agregarJugador(jugador1));
		assertTrue(nuevo.agregarJugador(jugador2));
		assertTrue(nuevo.agregarJugador(jugador3));
		assertTrue(nuevo.agregarJugador(jugador4));
		assertTrue(nuevo.agregarJugador(jugador5));
		
		assertNotNull(nuevo.buscar("Adolfo"));
	}
	
	@Test
	public void queSePuedaBuscarUnJugadorPorSuNumero() {
		EquipoDeFutbol nuevo = new EquipoDeFutbol("F.C. Barcelona");
		Jugador jugador1 = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		Jugador jugador2 = new Jugador(21, "Didác Plana", 32, 22000000.0);
		Jugador jugador3 = new Jugador(4, "André Coelho", 29, 21700000.0);
		Jugador jugador4 = new Jugador(8, "Adolfo", 29, 19000000.0);
		Jugador jugador5 = new Jugador(11, "Ferrao", 32, 21500000.0);
		
		assertTrue(nuevo.agregarJugador(jugador1));
		assertTrue(nuevo.agregarJugador(jugador2));
		assertTrue(nuevo.agregarJugador(jugador3));
		assertTrue(nuevo.agregarJugador(jugador4));
		assertTrue(nuevo.agregarJugador(jugador5));
		
		assertNotNull(nuevo.getJugadores());
		
		assertNotNull(nuevo.buscar(8));
	}
	
	@Test
	public void queSePuedaCalcularLaEdadPromedioDelEquipo() {
		EquipoDeFutbol nuevo = new EquipoDeFutbol("F.C. Barcelona");
		Jugador jugador1 = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		Jugador jugador2 = new Jugador(21, "Didác Plana", 32, 22000000.0);
		Jugador jugador3 = new Jugador(4, "André Coelho", 29, 21700000.0);
		Jugador jugador4 = new Jugador(8, "Adolfo", 29, 19000000.0);
		Jugador jugador5 = new Jugador(11, "Ferrao", 32, 21500000.0);
		
		int sumatoriaEdad = 0;
		double edadPromedio = 0.0;
		
		assertTrue(nuevo.agregarJugador(jugador1));
		assertTrue(nuevo.agregarJugador(jugador2));
		assertTrue(nuevo.agregarJugador(jugador3));
		assertTrue(nuevo.agregarJugador(jugador4));
		assertTrue(nuevo.agregarJugador(jugador5));
		
		for(int i=0; i < nuevo.getJugadores().length; i++) {
			sumatoriaEdad += nuevo.getJugadores()[i].getEdad();
		}
		
		edadPromedio = (double) sumatoriaEdad / nuevo.getJugadores().length;
		
		assertEquals(edadPromedio, nuevo.calcularLaEdadPromedioDelEquipo(), 0.01);
	}
	
	@Test
	public void queSePuedaCalcularElValorDelEquipo() {
		EquipoDeFutbol nuevo = new EquipoDeFutbol("F.C. Barcelona");
		Jugador jugador1 = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		Jugador jugador2 = new Jugador(21, "Didác Plana", 32, 22000000.0);
		Jugador jugador3 = new Jugador(4, "André Coelho", 29, 21700000.0);
		Jugador jugador4 = new Jugador(8, "Adolfo", 29, 19000000.0);
		Jugador jugador5 = new Jugador(11, "Ferrao", 32, 21500000.0);
		
		double valorDelEquipo = 0;
		
		assertTrue(nuevo.agregarJugador(jugador1));
		assertTrue(nuevo.agregarJugador(jugador2));
		assertTrue(nuevo.agregarJugador(jugador3));
		assertTrue(nuevo.agregarJugador(jugador4));
		assertTrue(nuevo.agregarJugador(jugador5));
		
		for(int i=0; i < nuevo.getJugadores().length; i++) {
			valorDelEquipo += nuevo.getJugadores()[i].getPrecio();
		}
		
		assertEquals(valorDelEquipo, nuevo.calcularElValorDelEquipo(), 0.01);
	}
	
	@Test
	public void queSePuedanCrearLosDiferentesEventosAsociadosAUnPartido() {
		EquipoDeFutbol nuevo = new EquipoDeFutbol("F.C. Barcelona");
		Jugador jugador1 = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		Jugador jugador2 = new Jugador(21, "Didác Plana", 32, 22000000.0);
		Jugador jugador3 = new Jugador(4, "André Coelho", 29, 21700000.0);
		Jugador jugador4 = new Jugador(8, "Adolfo", 29, 19000000.0);
		Jugador jugador5 = new Jugador(11, "Ferrao", 32, 21500000.0);
		assertTrue(nuevo.agregarJugador(jugador1));
		assertTrue(nuevo.agregarJugador(jugador2));
		assertTrue(nuevo.agregarJugador(jugador3));
		assertTrue(nuevo.agregarJugador(jugador4));
		assertTrue(nuevo.agregarJugador(jugador5));
		
		Evento golAFavor = new Evento(10, jugador1, TipoDeEvento.GOL_A_FAVOR);
		Evento golEnContra = new Evento(15, jugador2, TipoDeEvento.GOL_EN_CONTRA);
		Evento amonestacion = new Evento(21, jugador4, TipoDeEvento.AMONESTACION);
		Evento expulsion = new Evento(35, jugador3, TipoDeEvento.EXPULSION);
		
		assertNotNull(golAFavor);
		assertNotNull(golEnContra);
		assertNotNull(amonestacion);
		assertNotNull(expulsion);
	}
	
	@Test
	public void queSePuedaCrearUnPartido() {
		EquipoDeFutbol equipoLocal = new EquipoDeFutbol("F.C. Barcelona");
		Jugador jugador1 = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		Jugador jugador2 = new Jugador(21, "Didác Plana", 32, 22000000.0);
		Jugador jugador3 = new Jugador(4, "André Coelho", 29, 21700000.0);
		Jugador jugador4 = new Jugador(8, "Adolfo", 29, 19000000.0);
		Jugador jugador5 = new Jugador(11, "Ferrao", 32, 21500000.0);
		
		EquipoDeFutbol equipoVisitante = new EquipoDeFutbol("Real Madrid C.F.");
		Jugador jugador6 = new Jugador(11, "Martín Persec", 34, 8000000.0);
		Jugador jugador7 = new Jugador(2, "Santi Ramos", 29, 8500000.0);
		Jugador jugador8 = new Jugador(1, "Dante Zocola", 28, 8000000.0);
		Jugador jugador9 = new Jugador(8, "Nicolás Rolon", 29, 9000000.0);
		Jugador jugador10 = new Jugador(7, "Gonzalo Lencina", 27, 10500000.0);
		
		PartidoDeFutbol partido = new PartidoDeFutbol(equipoLocal, equipoVisitante);
		
		assertTrue(equipoLocal.agregarJugador(jugador1));
		assertTrue(equipoLocal.agregarJugador(jugador2));
		assertTrue(equipoLocal.agregarJugador(jugador3));
		assertTrue(equipoLocal.agregarJugador(jugador4));
		assertTrue(equipoLocal.agregarJugador(jugador5));
		
		assertTrue(equipoVisitante.agregarJugador(jugador6));
		assertTrue(equipoVisitante.agregarJugador(jugador7));
		assertTrue(equipoVisitante.agregarJugador(jugador8));
		assertTrue(equipoVisitante.agregarJugador(jugador9));
		assertTrue(equipoVisitante.agregarJugador(jugador10));
		
		assertNotNull(partido);
	}
	
	@Test
	public void queSePuedaMarcarUnGol() {
		EquipoDeFutbol equipoLocal = new EquipoDeFutbol("F.C. Barcelona");
		Jugador jugador1 = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		Jugador jugador2 = new Jugador(21, "Didác Plana", 32, 22000000.0);
		Jugador jugador3 = new Jugador(4, "André Coelho", 29, 21700000.0);
		Jugador jugador4 = new Jugador(8, "Adolfo", 29, 19000000.0);
		Jugador jugador5 = new Jugador(11, "Ferrao", 32, 21500000.0);
		
		EquipoDeFutbol equipoVisitante = new EquipoDeFutbol("Real Madrid C.F.");
		Jugador jugador6 = new Jugador(11, "Martín Persec", 34, 8000000.0);
		Jugador jugador7 = new Jugador(2, "Santi Ramos", 29, 8500000.0);
		Jugador jugador8 = new Jugador(1, "Dante Zocola", 28, 8000000.0);
		Jugador jugador9 = new Jugador(8, "Nicolás Rolon", 29, 9000000.0);
		Jugador jugador10 = new Jugador(7, "Gonzalo Lencina", 27, 10500000.0);
		
		PartidoDeFutbol partido = new PartidoDeFutbol(equipoLocal, equipoVisitante);
		
		assertTrue(equipoLocal.agregarJugador(jugador1));
		assertTrue(equipoLocal.agregarJugador(jugador2));
		assertTrue(equipoLocal.agregarJugador(jugador3));
		assertTrue(equipoLocal.agregarJugador(jugador4));
		assertTrue(equipoLocal.agregarJugador(jugador5));
		
		assertTrue(equipoVisitante.agregarJugador(jugador6));
		assertTrue(equipoVisitante.agregarJugador(jugador7));
		assertTrue(equipoVisitante.agregarJugador(jugador8));
		assertTrue(equipoVisitante.agregarJugador(jugador9));
		assertTrue(equipoVisitante.agregarJugador(jugador10));
		
		Evento golAFavor = new Evento(10, jugador1, TipoDeEvento.GOL_A_FAVOR);
		Evento golEnContra = new Evento(15, jugador8, TipoDeEvento.GOL_EN_CONTRA);
		
		assertNotNull(partido);

		partido.marcar(golAFavor);
		partido.marcar(golEnContra);
	}
	
	@Test
	public void queSePuedaAmonestarAUnJugador() {
		EquipoDeFutbol equipoLocal = new EquipoDeFutbol("F.C. Barcelona");
		Jugador jugador1 = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		Jugador jugador2 = new Jugador(21, "Didác Plana", 32, 22000000.0);
		Jugador jugador3 = new Jugador(4, "André Coelho", 29, 21700000.0);
		Jugador jugador4 = new Jugador(8, "Adolfo", 29, 19000000.0);
		Jugador jugador5 = new Jugador(11, "Ferrao", 32, 21500000.0);
		
		EquipoDeFutbol equipoVisitante = new EquipoDeFutbol("Real Madrid C.F.");
		Jugador jugador6 = new Jugador(11, "Martín Persec", 34, 8000000.0);
		Jugador jugador7 = new Jugador(2, "Santi Ramos", 29, 8500000.0);
		Jugador jugador8 = new Jugador(1, "Dante Zocola", 28, 8000000.0);
		Jugador jugador9 = new Jugador(8, "Nicolás Rolon", 29, 9000000.0);
		Jugador jugador10 = new Jugador(7, "Gonzalo Lencina", 27, 10500000.0);
		
		PartidoDeFutbol partido = new PartidoDeFutbol(equipoLocal, equipoVisitante);
		
		assertTrue(equipoLocal.agregarJugador(jugador1));
		assertTrue(equipoLocal.agregarJugador(jugador2));
		assertTrue(equipoLocal.agregarJugador(jugador3));
		assertTrue(equipoLocal.agregarJugador(jugador4));
		assertTrue(equipoLocal.agregarJugador(jugador5));
		
		assertTrue(equipoVisitante.agregarJugador(jugador6));
		assertTrue(equipoVisitante.agregarJugador(jugador7));
		assertTrue(equipoVisitante.agregarJugador(jugador8));
		assertTrue(equipoVisitante.agregarJugador(jugador9));
		assertTrue(equipoVisitante.agregarJugador(jugador10));
		
		Evento amonestacion1 = new Evento(18, jugador3, TipoDeEvento.AMONESTACION);
		Evento amonestacion2 = new Evento(25, jugador9, TipoDeEvento.AMONESTACION);
		
		assertNotNull(partido);

		partido.amonestar(amonestacion1);
		partido.amonestar(amonestacion2);
	}
	
	@Test
	public void queSePuedaExpulsarAUnJugadorPorDobleAmonestacion() {
		EquipoDeFutbol equipoLocal = new EquipoDeFutbol("F.C. Barcelona");
		Jugador jugador1 = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		Jugador jugador2 = new Jugador(21, "Didác Plana", 32, 22000000.0);
		Jugador jugador3 = new Jugador(4, "André Coelho", 29, 21700000.0);
		Jugador jugador4 = new Jugador(8, "Adolfo", 29, 19000000.0);
		Jugador jugador5 = new Jugador(11, "Ferrao", 32, 21500000.0);
		
		EquipoDeFutbol equipoVisitante = new EquipoDeFutbol("Real Madrid C.F.");
		Jugador jugador6 = new Jugador(11, "Martín Persec", 34, 8000000.0);
		Jugador jugador7 = new Jugador(2, "Santi Ramos", 29, 8500000.0);
		Jugador jugador8 = new Jugador(1, "Dante Zocola", 28, 8000000.0);
		Jugador jugador9 = new Jugador(8, "Nicolás Rolon", 29, 9000000.0);
		Jugador jugador10 = new Jugador(7, "Gonzalo Lencina", 27, 10500000.0);
		
		PartidoDeFutbol partido = new PartidoDeFutbol(equipoLocal, equipoVisitante);
		
		assertTrue(equipoLocal.agregarJugador(jugador1));
		assertTrue(equipoLocal.agregarJugador(jugador2));
		assertTrue(equipoLocal.agregarJugador(jugador3));
		assertTrue(equipoLocal.agregarJugador(jugador4));
		assertTrue(equipoLocal.agregarJugador(jugador5));
		
		assertTrue(equipoVisitante.agregarJugador(jugador6));
		assertTrue(equipoVisitante.agregarJugador(jugador7));
		assertTrue(equipoVisitante.agregarJugador(jugador8));
		assertTrue(equipoVisitante.agregarJugador(jugador9));
		assertTrue(equipoVisitante.agregarJugador(jugador10));
		
		Evento amonestacion1 = new Evento(25, jugador9, TipoDeEvento.AMONESTACION);
		Evento amonestacion2 = new Evento(48, jugador9, TipoDeEvento.AMONESTACION);
		
		assertNotNull(partido);

		partido.amonestar(amonestacion1);
		partido.amonestar(amonestacion2);
	}
	
	@Test
	public void queSePuedaExpulsarUnJugadorPorRojaDirecta() {
		EquipoDeFutbol equipoLocal = new EquipoDeFutbol("F.C. Barcelona");
		Jugador jugador1 = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		Jugador jugador2 = new Jugador(21, "Didác Plana", 32, 22000000.0);
		Jugador jugador3 = new Jugador(4, "André Coelho", 29, 21700000.0);
		Jugador jugador4 = new Jugador(8, "Adolfo", 29, 19000000.0);
		Jugador jugador5 = new Jugador(11, "Ferrao", 32, 21500000.0);
		
		EquipoDeFutbol equipoVisitante = new EquipoDeFutbol("Real Madrid C.F.");
		Jugador jugador6 = new Jugador(11, "Martín Persec", 34, 8000000.0);
		Jugador jugador7 = new Jugador(2, "Santi Ramos", 29, 8500000.0);
		Jugador jugador8 = new Jugador(1, "Dante Zocola", 28, 8000000.0);
		Jugador jugador9 = new Jugador(8, "Nicolás Rolon", 29, 9000000.0);
		Jugador jugador10 = new Jugador(7, "Gonzalo Lencina", 27, 10500000.0);
		
		PartidoDeFutbol partido = new PartidoDeFutbol(equipoLocal, equipoVisitante);
		
		assertTrue(equipoLocal.agregarJugador(jugador1));
		assertTrue(equipoLocal.agregarJugador(jugador2));
		assertTrue(equipoLocal.agregarJugador(jugador3));
		assertTrue(equipoLocal.agregarJugador(jugador4));
		assertTrue(equipoLocal.agregarJugador(jugador5));
		
		assertTrue(equipoVisitante.agregarJugador(jugador6));
		assertTrue(equipoVisitante.agregarJugador(jugador7));
		assertTrue(equipoVisitante.agregarJugador(jugador8));
		assertTrue(equipoVisitante.agregarJugador(jugador9));
		assertTrue(equipoVisitante.agregarJugador(jugador10));
		
		Evento expulsion = new Evento(65, jugador2, TipoDeEvento.EXPULSION);
		
		assertNotNull(partido);

		partido.expulsar(expulsion);
	}
	
	@Test
	public void queSePuedaSaberElResultadoDelPartido() {
		EquipoDeFutbol equipoLocal = new EquipoDeFutbol("F.C. Barcelona");
		Jugador jugador1 = new Jugador(9, "Sergio Lozano", 30, 25000000.0);
		Jugador jugador2 = new Jugador(21, "Didác Plana", 32, 22000000.0);
		Jugador jugador3 = new Jugador(4, "André Coelho", 29, 21700000.0);
		Jugador jugador4 = new Jugador(8, "Adolfo", 29, 19000000.0);
		Jugador jugador5 = new Jugador(11, "Ferrao", 32, 21500000.0);
		
		EquipoDeFutbol equipoVisitante = new EquipoDeFutbol("Real Madrid C.F.");
		Jugador jugador6 = new Jugador(11, "Martín Persec", 34, 8000000.0);
		Jugador jugador7 = new Jugador(2, "Santi Ramos", 29, 8500000.0);
		Jugador jugador8 = new Jugador(1, "Dante Zocola", 28, 8000000.0);
		Jugador jugador9 = new Jugador(8, "Nicolás Rolon", 29, 9000000.0);
		Jugador jugador10 = new Jugador(7, "Gonzalo Lencina", 27, 10500000.0);
		
		PartidoDeFutbol partido = new PartidoDeFutbol(equipoLocal, equipoVisitante);
		
		assertTrue(equipoLocal.agregarJugador(jugador1));
		assertTrue(equipoLocal.agregarJugador(jugador2));
		assertTrue(equipoLocal.agregarJugador(jugador3));
		assertTrue(equipoLocal.agregarJugador(jugador4));
		assertTrue(equipoLocal.agregarJugador(jugador5));
		
		assertTrue(equipoVisitante.agregarJugador(jugador6));
		assertTrue(equipoVisitante.agregarJugador(jugador7));
		assertTrue(equipoVisitante.agregarJugador(jugador8));
		assertTrue(equipoVisitante.agregarJugador(jugador9));
		assertTrue(equipoVisitante.agregarJugador(jugador10));
		
		Evento golAFavor = new Evento(10, jugador1, TipoDeEvento.GOL_A_FAVOR);
		Evento golEnContra = new Evento(15, jugador8, TipoDeEvento.GOL_EN_CONTRA);
		Evento amonestacion1 = new Evento(18, jugador3, TipoDeEvento.AMONESTACION);
		Evento amonestacion2 = new Evento(25, jugador9, TipoDeEvento.AMONESTACION);
		Evento expulsion = new Evento(65, jugador2, TipoDeEvento.EXPULSION);
		
		assertNotNull(partido);
		
		partido.marcar(golAFavor);
		partido.marcar(golEnContra);
		partido.amonestar(amonestacion1);
		partido.amonestar(amonestacion2);
		partido.expulsar(expulsion);

		assertNotNull(partido.getGanador());
	}
}