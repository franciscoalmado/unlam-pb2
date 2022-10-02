package ar.edu.unlam.pb2.buscaminas.jUnit;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import ar.edu.unlam.pb2.buscaminas.dominio.Casilla;
import ar.edu.unlam.pb2.buscaminas.dominio.Tablero;

public class TestBuscaminas {

	@Test
	public void queSePuedaInicializarUnaCasillaEnElTablero() {
		Tablero tablero = new Tablero(10, 10, 5); 
		Casilla casillas = new Casilla(1, 2);
		
		assertNotNull(tablero);
		assertNotNull(casillas);
		
		tablero.inicializarCasillas();
	}
	
	@Test
	public void queSePuedanGenerarMinasAleatoriamenteEnElTablero() {
		Tablero tablero = new Tablero(10, 10, 5); 
		Casilla casillas = new Casilla(1, 2);
		
		assertNotNull(tablero);
		assertNotNull(casillas);
		
		tablero.generarMinas();
	}
	
	@Test
	public void queSePuedaMarcarUnaCasillaAbiertaEnElTablero() {
		Tablero tablero = new Tablero(10, 10, 5); 
		Casilla casillas = new Casilla(1, 2);
	
		assertNotNull(tablero);
		assertNotNull(casillas);
		casillas.setAbierta(true);
		
		assertTrue(tablero.marcarCasillaAbierta(casillas.getPosFila(), casillas.getPosColumna()));
		assertTrue(casillas.isAbierta());
	}
	
	@Test
	public void queSePuedanObtenerLasCasillasQueEstanAlrededorDeOtraCasilla() {
		Tablero tablero = new Tablero(10, 10, 5); 
		Casilla casillas = new Casilla(1, 2);
		List<Casilla> casilla = new LinkedList<>();
		
		assertNotNull(tablero);
		assertNotNull(casillas);
			
		for(int i=0; i < 8; i++){
			assertTrue(i < tablero.getCasilleros().length);
			assertTrue(i < tablero.getCasilleros()[i].length);
			assertNotNull(casilla.addAll(tablero.obtenerCasillasAlrededor(casillas.getPosFila(), casillas.getPosColumna())));
		}
	}
	
	@Test
	public void queSePuedaActualizarElNumeroDeMinasQueSeEncuentranAlrededorDeUnaCasilla() {
		Tablero tablero = new Tablero(10, 10, 5); 
		Casilla casillas = new Casilla(1, 2);
		List<Casilla> casillasAlrededor = new LinkedList<>();
		
		assertNotNull(tablero);
		assertNotNull(casillas);
		
		for(int i=0; i < tablero.getCasilleros().length; i++) {
			for(int j=0; j < tablero.getCasilleros()[i].length; j++) {
				assertNotNull(tablero.getCasilleros()[i][j]);
				if(tablero.getCasilleros()[i][j].isMina()) {
					assertTrue(tablero.getCasilleros()[i][j].isMina());	
				}
				casillasAlrededor = tablero.obtenerCasillasAlrededor(i, j);
				assertNotNull(casillasAlrededor);
				casillasAlrededor.forEach((casilla)->casilla.incrementarNumeroMinasAlrededor());
			}
		}
	}
}