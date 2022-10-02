package ar.edu.unlam.pb2.reproductorDeMusica.jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.reproductorDeMusica.dominio.Cancion;
import ar.edu.unlam.pb2.reproductorDeMusica.dominio.Duracion;
import ar.edu.unlam.pb2.reproductorDeMusica.dominio.ListaDeReproduccion;

public class TestReproductorDeMusica {

	@Test
	public void queSePuedaCrearUnaCancion() {
		Cancion nueva = new Cancion("Nada es igual", "Franco De Vita", "Nada es igual", 5, 4);
		
		assertNotNull(nueva);
	}
	
	@Test
	public void queSePuedanCalcularLosMinutosYSegundos() {
		Cancion nueva = new Cancion("Nada es igual", "Franco De Vita", "Nada es igual", 5, 4);
		Duracion duracion = new Duracion(nueva.getMinutos(), nueva.getSegundos());
		
		assertNotNull(nueva);
		assertNotNull(duracion);
		
		duracion.calcularMinutosYSegundos(nueva.getMinutos(), nueva.getSegundos());
		
	}
	
	@Test
	public void queSePuedanValidarLosMinutosYSegundos() {
		Cancion nueva = new Cancion("Nada es igual", "Franco De Vita", "Nada es igual", 5, 4);
		Duracion duracion = new Duracion(nueva.getMinutos(), nueva.getSegundos());
		
		assertNotNull(nueva);
		assertNotNull(duracion);		
		
		duracion.validarMinutosYSegundos(nueva.getMinutos(), nueva.getSegundos());
	}
	
	@Test
	public void queSePuedanAgregarCancionesAUnaListaDeReproduccion() {
		Cancion nueva = new Cancion("Nada es igual", "Franco De Vita", "Nada es igual", 5, 4);
		Duracion duracion = new Duracion(nueva.getMinutos(), nueva.getSegundos());
		ListaDeReproduccion lista = new ListaDeReproduccion("GOAT", 10);
		
		assertNotNull(nueva);
		assertNotNull(duracion);
		assertNotNull(lista.getCanciones());
		
		assertTrue(lista.agregarCancionesALaLista(nueva));
	}
	
	@Test
	public void queSePuedaCalcularLaDuracionTotalDeUnaListaDeReproduccion() {
		Cancion nueva = new Cancion("Nada es igual", "Franco De Vita", "Nada es igual", 5, 4);
		Duracion duracion = new Duracion(nueva.getMinutos(), nueva.getSegundos());
		ListaDeReproduccion lista = new ListaDeReproduccion("GOAT", 10);
		
		assertNotNull(nueva);
		assertNotNull(duracion);
		assertNotNull(lista.getCanciones());
		
		lista.obtenerDuracionTotalDeLaLista();
	}	
}