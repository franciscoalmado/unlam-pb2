package ar.edu.unlam.pb2.callCenter.jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.callCenter.dominio.Contacto;
import ar.edu.unlam.pb2.callCenter.dominio.Empresa;
import ar.edu.unlam.pb2.callCenter.dominio.Llamada;
import ar.edu.unlam.pb2.callCenter.dominio.Provincia;

public class TestCallCenter {

	@Test
	public void queSePuedaCrearUnaLlamada() {
		Llamada nueva = new Llamada(true, "Exitosa");
		
		assertNotNull(nueva);
		assertTrue(nueva.isFueExitosa());
		assertNotNull(nueva.getObservaciones());
	}
	
	@Test
	public void queSePuedaCrearUnContacto() {
		Contacto nuevo = new Contacto("Pedro", "López", "+5411-12345678", "pedro.lopez@email.com", "Av. Del Libertador 3675", 1750, "Recoleta", Provincia.CABA);
	
		assertNotNull(nuevo);
		assertTrue(nuevo.esEmailValido(nuevo.getEmail()));
		assertTrue(nuevo.esTelefonoValido(nuevo.getTelefono()));
		assertNotNull(nuevo.getProvincia().equals(Provincia.CABA));
	}
	
	@Test
	public void queSePuedaAgregarUnContactoAlRegistroDeLaEmpresa() {
		Contacto contacto1 = new Contacto("Pedro", "López", "+5411-12345678", "pedro.lopez@gmail.com", "Av. Del Libertador 3675", 1750, "Recoleta", Provincia.CABA);
		Contacto contacto2 = new Contacto("Pedro", "López", "+5411-12345678", "pedro.lopez@gmail.com", "Av. Del Libertador 3675", 1425, "Recoleta", Provincia.CABA);
		Empresa oesteCableColor = new Empresa("Oeste Cable Color", 100, 1000);
		
		assertNotNull(oesteCableColor);
		assertTrue(oesteCableColor.agregarNuevoContacto(contacto1));
		assertFalse(oesteCableColor.agregarNuevoContacto(contacto2));
		assertTrue(oesteCableColor.agregarNuevaZonaDeCobertura(contacto1.obtenerCodigoPostal()));
		assertTrue(oesteCableColor.agregarNuevaZonaDeCobertura(contacto2.obtenerCodigoPostal()));
		assertNotNull(oesteCableColor.getContactos());
		assertNotNull(oesteCableColor.getZonasDeCoberturas());
	}
	
	@Test
	public void queSePuedaBuscarUnContactoAleatoriamente() {
		Contacto contacto1 = new Contacto("Pedro", "López", "+5411-12345678", "pedro.lopez@email.com", "Av. Del Libertador 3675", 1750, "Recoleta", Provincia.CABA);
		Contacto contacto2 = new Contacto("Lucía", "Martínez", "+5411-87654321", "luciamartinez@yahoo.com", "Av. Pedro Goyena 61", 1425, "Caballito", Provincia.CABA);
		Contacto contacto3 = new Contacto("Tomás", "Bertolli", "+5411-12378456", "tbertolli@outlook.com", "Av. Corrientes 2320", 1375, "Balvanera", Provincia.CABA);
		Contacto contacto4 = new Contacto("Martina", "Rodríguez", "+5411-45678123", "marti_rod@gmail.com", "Florencio Varela 1903", 1754, "San Justo", Provincia.BUENOS_AIRES);
		Contacto contacto5 = new Contacto("Leandro", "Márquez", "+5411-53715600", "lea.marquezd@gmail.com", "Sarmiento 440", 1925, "Castillo", Provincia.CORDOBA);
		
		Empresa oesteCableColor = new Empresa("Oeste Cable Color", 100, 1000);
		
		assertNotNull(oesteCableColor.getContactos());
		
		assertTrue(oesteCableColor.agregarNuevoContacto(contacto1));
		assertTrue(oesteCableColor.agregarNuevoContacto(contacto2));
		assertTrue(oesteCableColor.agregarNuevoContacto(contacto3));
		assertTrue(oesteCableColor.agregarNuevoContacto(contacto4));
		assertTrue(oesteCableColor.agregarNuevoContacto(contacto5));
		assertTrue(oesteCableColor.agregarNuevaZonaDeCobertura(contacto1.obtenerCodigoPostal()));
		assertTrue(oesteCableColor.agregarNuevaZonaDeCobertura(contacto2.obtenerCodigoPostal()));
		assertTrue(oesteCableColor.agregarNuevaZonaDeCobertura(contacto3.obtenerCodigoPostal()));
		assertTrue(oesteCableColor.agregarNuevaZonaDeCobertura(contacto4.obtenerCodigoPostal()));
		assertTrue(oesteCableColor.agregarNuevaZonaDeCobertura(contacto5.obtenerCodigoPostal()));
		
		assertNotNull(oesteCableColor.buscarCandidato());
	}
	
	@Test
	public void queSePuedaRegistrarUnaLlamada() {
		Llamada nueva = new Llamada(true, "Exitosa");
		Contacto contacto = new Contacto("Pedro", "López", "+5411-12345678", "pedro.lopez@email.com", "Av. Del Libertador 3675", 1750, "Recoleta", Provincia.CABA);
		
		assertNotNull(nueva);
		assertTrue(nueva.isFueExitosa());
		assertNotNull(nueva.getObservaciones());
		
		assertTrue(contacto.registrarNuevaLlamada(nueva));
	}
}