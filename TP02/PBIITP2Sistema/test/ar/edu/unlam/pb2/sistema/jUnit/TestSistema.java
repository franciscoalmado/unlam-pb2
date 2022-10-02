package ar.edu.unlam.pb2.sistema.jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.sistema.dominio.Sistema;
import ar.edu.unlam.pb2.sistema.dominio.Usuario;

public class TestSistema {

	@Test
	public void queSePuedaCrearUnUsuario() {
		Usuario usuario = new Usuario("goat_2022", "Mi-Cuenta8", "Leonardo", "Belloti", 16470134, 35);
		
		assertNotNull(usuario);
	}
	
	@Test
	public void queSePuedaVerificarQueLaContraseniaDelUsuarioSeaValida() {
		Usuario usuario = new Usuario("goat_2022", "Mi-Cuenta8", "Leonardo", "Belloti", 16470134, 35);
		
		assertNotNull(usuario);
		assertTrue(usuario.laContraseniaEsValida());
	}
	
	@Test
	public void queSePuedaVerificarQueElUsuarioSeaMayorDeEdad() {
		Usuario usuario = new Usuario("goat_2022", "Mi-Cuenta8", "Leonardo", "Belloti", 16470134, 35);
		
		assertNotNull(usuario);
		assertTrue(usuario.isMayorDeEdad());
	}
	
	@Test
	public void queSePuedaCrearElSistema() {
		Sistema lab = new Sistema("Laboratorios Farma", 100);
	
		assertNotNull(lab);
	}
	
	@Test
	public void queSePuedaIncorporarUnUsuarioAlSistema() {
		Sistema lab = new Sistema("Laboratorios Farma", 100);
		Usuario usuario = new Usuario("goat_2022", "Mi-Cuenta8", "Leonardo", "Belloti", 16470134, 35);
	
		assertNotNull(usuario);
		assertNotNull(lab);
		assertTrue(lab.ingresarUsuario(usuario));
	}
	
	@Test
	public void queSePuedaLoguearUnUsuarioEnElSistema() {
		Sistema lab = new Sistema("Laboratorios Farma", 3);
		Usuario usuario = new Usuario("goat_2022", "Mi-Cuenta8", "Leonardo", "Belloti", 16470134, 35);
	
		assertNotNull(usuario);
		assertNotNull(lab);
		
		assertTrue(lab.ingresarUsuario(usuario));
		
		assertTrue(lab.loguearUsuario(usuario.getUsuario(), usuario.getContrasenia()));
	}
	
	@Test
	public void queSePuedaObtenerLaCantidadDeUsuariosLogueados() {
		Sistema lab = new Sistema("Laboratorios Farma", 3);
		Usuario usuario = new Usuario("goat_2022", "Mi-Cuenta8", "Leonardo", "Belloti", 16470134, 35);
		
		assertNotNull(usuario);		
		assertNotNull(lab);
		
		assertTrue(lab.ingresarUsuario(usuario));
		
		assertTrue(lab.loguearUsuario(usuario.getUsuario(), usuario.getContrasenia()));
		
		lab.agregarUsuarioALaCantidadDeUsuariosLogueados(usuario);
		
		lab.getCantidadDeUsuariosLogueados();
	}
	
	@Test
	public void queSePuedaObtenerLaCantidadDeUsuariosBloqueados() {
		Sistema lab = new Sistema("Laboratorios Farma", 3);
		Usuario usuario = new Usuario("goat", "micuenta", "Leonardo", "Belloti", 16470134, 35);
		
		assertNotNull(usuario);		
		assertNotNull(lab);
		
		assertTrue(lab.ingresarUsuario(usuario));
		
		assertFalse(lab.loguearUsuario(usuario.getUsuario().toUpperCase(), usuario.getContrasenia().toUpperCase()));
				
		for(int i=0; i < lab.getUsuarios().length; i++) {
			if(!lab.verificarSiUnUsuarioHaSidoBloqueado(usuario)) {
				lab.getCantidadDeUsuariosBloqueados();				
			}
		}
	}
	
	@Test
	public void queSePuedaCalcularLaEdadPromedioDeLosUsuarios() {
		Sistema lab = new Sistema("Laboratorios Farma", 3);
		Usuario usuario1 = new Usuario("goat_2022", "Mi-Cuenta8", "Leonardo", "Belloti", 16470134, 35);
		Usuario usuario2 = new Usuario("macabercovic", "maca_bercovic22", "Macarena", "Bercovich", 22456123, 17);
		Usuario usuario3 = new Usuario("lauti-lezama", "lezama_mixture", "Lautaro", "Lezama", 24367899, 17);
		
		int sumatoriaDeEdades = 0;
		double promedioDeEdad = 0.0;
		
		assertNotNull(usuario1);
		assertNotNull(usuario2);
		assertNotNull(usuario3);
		assertNotNull(lab);

		assertTrue(lab.ingresarUsuario(usuario1));
		assertTrue(lab.ingresarUsuario(usuario2));
		assertTrue(lab.ingresarUsuario(usuario3));
		
		for(int i=0; i < lab.getUsuarios().length; i++) {
			sumatoriaDeEdades += lab.getUsuarios()[i].getEdad();
		}
		
		promedioDeEdad = (double) sumatoriaDeEdades / lab.getCantidadDeUsuarios();
		
		assertEquals(promedioDeEdad, lab.calcularEdadPromedio(), 0.01);
	}
	
	@Test
	public void queSePuedaCalcularELPorcentajeDeUsuariosLogueadosEnELSistema() {
		Sistema lab = new Sistema("Laboratorios Farma", 3);
		
		Usuario usuario1 = new Usuario("goat_2022", "Mi-Cuenta8", "Leonardo", "Belloti", 16470134, 35);
		Usuario usuario2 = new Usuario("macabercovic", "maca_bercovic22", "Macarena", "Bercovich", 22456123, 17);
		Usuario usuario3 = new Usuario("lauti-lezama", "lezama_mixture", "Lautaro", "Lezama", 24367899, 17);
		
		int contador = 0;
		int cantidadDeUsuarios = 0;
		double porcentaje = 0.0;
		
		assertNotNull(usuario1);
		assertNotNull(usuario2);
		assertNotNull(usuario3);
		assertNotNull(lab);

		assertTrue(lab.ingresarUsuario(usuario1));
		assertTrue(lab.ingresarUsuario(usuario2));
		assertTrue(lab.ingresarUsuario(usuario3));
		
		cantidadDeUsuarios = lab.getCantidadDeUsuarios();
		
		if(lab.loguearUsuario(usuario1.getUsuario(), usuario1.getContrasenia())) {
			contador++;
		}

		if(lab.loguearUsuario(usuario2.getUsuario(), usuario2.getContrasenia())) {
			contador++;
		}

		if(lab.loguearUsuario(usuario3.getUsuario().toUpperCase(), usuario3.getContrasenia().toUpperCase())) {
			contador++;	
		}
		
		porcentaje = (double) (contador / cantidadDeUsuarios) * 100;
		
		assertEquals(porcentaje, lab.calcularElPorcentajeDeUsuariosLogueados(), 0.01);
	}
}