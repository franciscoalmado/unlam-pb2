package ar.edu.unlam.pb2.domotica.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import ar.edu.unlam.pb2.domotica.dominio.Ascensor;
import ar.edu.unlam.pb2.domotica.dominio.Edificio;
import ar.edu.unlam.pb2.domotica.dominio.Persona;
import ar.edu.unlam.pb2.domotica.dominio.SistemaDomotico;
import ar.edu.unlam.pb2.domotica.dominio.TipoDeIdentificacion;

public class TestDomotica {

	@Test
	public void queSePuedaActivarElSistemaDomotico() {
		SistemaDomotico alexa = new SistemaDomotico();
		Edificio torreSamsung = new Edificio("Torre Samsung", 0, 10, 5);
		Ascensor ascensor1 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor2 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor3 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor4 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor5 = new Ascensor(10, 0, 6, 1200.0);
		
		alexa.configurarSistema(torreSamsung);
		alexa.activarSistema();
		
		assertTrue(alexa.getIsActivado());
		assertNotNull(torreSamsung.getAscensores());
		assertNotNull(ascensor1);
		assertNotNull(ascensor2);
		assertNotNull(ascensor3);
		assertNotNull(ascensor4);
		assertNotNull(ascensor5);	
	}
	
	@Test
	public void queSePuedaRegistrarIngresoDePersonasAlEdificio() {
		SistemaDomotico alexa = new SistemaDomotico();
		Edificio torreSamsung = new Edificio("Torre Samsung", 0, 10, 5);
		Ascensor ascensor1 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor2 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor3 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor4 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor5 = new Ascensor(10, 0, 6, 1200.0);
		Persona persona1 = new Persona("Sofía", "Ramírez", 9867265, TipoDeIdentificacion.CLIENTE, 75);
		Persona persona2 = new Persona("Leonardo", "Belotti", 14234167, TipoDeIdentificacion.CLIENTE, 95);
		Persona persona3 = new Persona("Pablo", "González", 11345623, TipoDeIdentificacion.CLIENTE, 100);
		Persona persona4 = new Persona("Martina", "Escobar", 16543098, TipoDeIdentificacion.CLIENTE, 80);
		Persona persona5 = new Persona("María", "Silvera", 12983109, TipoDeIdentificacion.CLIENTE, 69);
		
		assertNotNull(ascensor1);
		assertNotNull(ascensor2);
		assertNotNull(ascensor3);
		assertNotNull(ascensor4);
		assertNotNull(ascensor5);
		
		LocalDate fecha;
		fecha = LocalDate.now();
		
		alexa.configurarSistema(torreSamsung);
		alexa.activarSistema();
		
		assertTrue(alexa.getIsActivado());
		assertNotNull(torreSamsung.getAscensores());
		
		alexa.ingresarPersona(persona1);
		alexa.ingresarPersona(persona2);
		alexa.ingresarPersona(persona3);
		alexa.ingresarPersona(persona4);
		alexa.ingresarPersona(persona5);
		
		alexa.registrarIngresoDePersonas(persona1, fecha);
		alexa.registrarIngresoDePersonas(persona2, fecha);
		alexa.registrarIngresoDePersonas(persona3, fecha);
		alexa.registrarIngresoDePersonas(persona4, fecha);
		alexa.registrarIngresoDePersonas(persona5, fecha);
	
		assertEquals(5, alexa.getPersonasQueIngresan().size());
	}
	
	@Test
	public void queSePuedaRegistrarLasPersonasQueUsanLosAscensores() throws Exception {
		SistemaDomotico alexa = new SistemaDomotico();
		Edificio torreSamsung = new Edificio("Torre Samsung", 0, 10, 5);
		Ascensor ascensor1 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor2 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor3 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor4 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor5 = new Ascensor(10, 0, 6, 1200.0);
		Persona persona1 = new Persona("Sofía", "Ramírez", 9867265, TipoDeIdentificacion.CLIENTE, 75);
		Persona persona2 = new Persona("Leonardo", "Belotti", 14234167, TipoDeIdentificacion.CLIENTE, 95);
		Persona persona3 = new Persona("Pablo", "González", 11345623, TipoDeIdentificacion.CLIENTE, 100);
		Persona persona4 = new Persona("Martina", "Escobar", 16543098, TipoDeIdentificacion.CLIENTE, 80);
		Persona persona5 = new Persona("María", "Silvera", 12983109, TipoDeIdentificacion.CLIENTE, 69);
		
		assertNotNull(ascensor1);
		assertNotNull(ascensor2);
		assertNotNull(ascensor3);
		assertNotNull(ascensor4);
		assertNotNull(ascensor5);
		
		LocalDate fecha;
		fecha = LocalDate.now();
		
		alexa.configurarSistema(torreSamsung);
		alexa.activarSistema();
		
		assertNotNull(torreSamsung.getAscensores());
		
		alexa.ingresarPersona(persona1);
		alexa.ingresarPersona(persona2);
		alexa.ingresarPersona(persona3);
		alexa.ingresarPersona(persona4);
		alexa.ingresarPersona(persona5);
		
		alexa.registrarIngresoDePersonas(persona1, fecha);
		alexa.registrarIngresoDePersonas(persona2, fecha);
		alexa.registrarIngresoDePersonas(persona3, fecha);
		alexa.registrarIngresoDePersonas(persona4, fecha);
		alexa.registrarIngresoDePersonas(persona5, fecha);
		
		alexa.registrarPersonaQueSubeAlAscensor(persona1, 3, 1);
		alexa.registrarPersonaQueSubeAlAscensor(persona2, 5, 1);
		alexa.registrarPersonaQueSubeAlAscensor(persona3, 6, 1);
		alexa.registrarPersonaQueSubeAlAscensor(persona4, 10, 1);
		alexa.registrarPersonaQueSubeAlAscensor(persona5, 10, 1);
		
		alexa.registrarPersonaQueBajaDelAscensor(persona1, 3, 1);
		alexa.registrarPersonaQueBajaDelAscensor(persona2, 5, 1);
		alexa.registrarPersonaQueBajaDelAscensor(persona3, 6, 1);
		alexa.registrarPersonaQueBajaDelAscensor(persona4, 10, 1);
		alexa.registrarPersonaQueBajaDelAscensor(persona5, 10, 1);
		
		assertEquals(5, alexa.getPersonasQueSuben().size());
		assertEquals(5, alexa.getPersonasQueBajan().size());
	}
	
	@Test
	public void queSePuedaRegistrarLosMovimientosDeLosEmpleados() throws Exception {
		SistemaDomotico alexa = new SistemaDomotico();
		Edificio torreSamsung = new Edificio("Torre Samsung", 0, 10, 5);
		Ascensor ascensor1 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor2 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor3 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor4 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor5 = new Ascensor(10, 0, 6, 1200.0);
		Persona persona1 = new Persona("Sofía", "Ramírez", 9867265, TipoDeIdentificacion.CLIENTE, 75);
		Persona persona2 = new Persona("Leonardo", "Belotti", 14234167, TipoDeIdentificacion.CLIENTE, 95);
		Persona persona3 = new Persona("Pablo", "González", 11345623, TipoDeIdentificacion.CLIENTE, 100);
		Persona persona4 = new Persona("Martina", "Escobar", 16543098, TipoDeIdentificacion.CLIENTE, 80);
		Persona persona5 = new Persona("María", "Silvera", 12983109, TipoDeIdentificacion.CLIENTE, 69);
		Persona persona6 = new Persona("Pablo", "Lanzini", 9867265, TipoDeIdentificacion.EMPLEADO, 75);
		Persona persona7 = new Persona("Soledad", "Martínez", 14234167, TipoDeIdentificacion.EMPLEADO, 95);
		Persona persona8 = new Persona("Matías", "Eleazar", 11345623, TipoDeIdentificacion.EMPLEADO, 100);
		Persona persona9 = new Persona("Jesús", "Rivero", 16543098, TipoDeIdentificacion.EMPLEADO, 80);
		Persona persona10 = new Persona("Lautaro", "Lezama", 12983109, TipoDeIdentificacion.EMPLEADO, 69);
		
		assertNotNull(ascensor1);
		assertNotNull(ascensor2);
		assertNotNull(ascensor3);
		assertNotNull(ascensor4);
		assertNotNull(ascensor5);
		
		LocalDate fecha;
		fecha = LocalDate.now();
		
		alexa.configurarSistema(torreSamsung);
		alexa.activarSistema();
		
		assertNotNull(torreSamsung.getAscensores());
		
		alexa.ingresarPersona(persona1);
		alexa.ingresarPersona(persona2);
		alexa.ingresarPersona(persona3);
		alexa.ingresarPersona(persona4);
		alexa.ingresarPersona(persona5);
		alexa.ingresarPersona(persona6);
		alexa.ingresarPersona(persona7);
		alexa.ingresarPersona(persona8);
		alexa.ingresarPersona(persona9);
		alexa.ingresarPersona(persona10);
		
		alexa.registrarIngresoDePersonas(persona1, fecha);
		alexa.registrarIngresoDePersonas(persona2, fecha);
		alexa.registrarIngresoDePersonas(persona3, fecha);
		alexa.registrarIngresoDePersonas(persona4, fecha);
		alexa.registrarIngresoDePersonas(persona5, fecha);
		alexa.registrarIngresoDePersonas(persona6, fecha);
		alexa.registrarIngresoDePersonas(persona7, fecha);
		alexa.registrarIngresoDePersonas(persona8, fecha);
		alexa.registrarIngresoDePersonas(persona9, fecha);
		alexa.registrarIngresoDePersonas(persona10, fecha);
		
		alexa.registrarPersonaQueSubeAlAscensor(persona1, 3, 1);
		alexa.registrarPersonaQueSubeAlAscensor(persona2, 5, 3);
		alexa.registrarPersonaQueSubeAlAscensor(persona3, 6, 2);
		alexa.registrarPersonaQueSubeAlAscensor(persona4, 10, 4);
		alexa.registrarPersonaQueSubeAlAscensor(persona5, 10, 1);
		alexa.registrarPersonaQueSubeAlAscensor(persona6, 3, 1);
		alexa.registrarPersonaQueSubeAlAscensor(persona7, 5, 3);
		alexa.registrarPersonaQueSubeAlAscensor(persona8, 6, 2);
		alexa.registrarPersonaQueSubeAlAscensor(persona9, 10, 4);
		alexa.registrarPersonaQueSubeAlAscensor(persona10, 10, 1);
		
		alexa.registrarPersonaQueBajaDelAscensor(persona1, 3, 1);
		alexa.registrarPersonaQueBajaDelAscensor(persona2, 5, 3);
		alexa.registrarPersonaQueBajaDelAscensor(persona3, 6, 2);
		alexa.registrarPersonaQueBajaDelAscensor(persona4, 10, 4);
		alexa.registrarPersonaQueBajaDelAscensor(persona5, 10, 1);
		alexa.registrarPersonaQueBajaDelAscensor(persona6, 3, 1);
		alexa.registrarPersonaQueBajaDelAscensor(persona7, 5, 3);
		alexa.registrarPersonaQueBajaDelAscensor(persona8, 6, 2);
		alexa.registrarPersonaQueBajaDelAscensor(persona9, 10, 4);
		alexa.registrarPersonaQueBajaDelAscensor(persona10, 10, 1);
		
		alexa.registarIngresoDeEmpleadosASuAreaDeTrabajo(persona6, 3);
		alexa.registarIngresoDeEmpleadosASuAreaDeTrabajo(persona7, 5);
		alexa.registarIngresoDeEmpleadosASuAreaDeTrabajo(persona8, 2);
		alexa.registarIngresoDeEmpleadosASuAreaDeTrabajo(persona9, 10);
		alexa.registarIngresoDeEmpleadosASuAreaDeTrabajo(persona10, 10);
		
		LocalTime tiempo;
		tiempo = LocalTime.now();
		
		alexa.registarEgresoDeEmpleadosASuAreaDeTrabajo(persona6, 3, tiempo);
		alexa.registarEgresoDeEmpleadosASuAreaDeTrabajo(persona7, 5, tiempo);
		alexa.registarEgresoDeEmpleadosASuAreaDeTrabajo(persona8, 2, tiempo);
		alexa.registarEgresoDeEmpleadosASuAreaDeTrabajo(persona9, 10, tiempo);
		alexa.registarEgresoDeEmpleadosASuAreaDeTrabajo(persona10, 10, tiempo);
		
		assertEquals(10, alexa.getPersonasQueSuben().size());
		assertEquals(10, alexa.getPersonasQueBajan().size());
		assertEquals(5, alexa.getEmpleadosQueIngresanASuAreaDeTrabajo().size());
		assertEquals(5, alexa.getEmpleadosQueSalenDeSuAreaDeTrabajo().size());
	}
	
	@Test
	public void queSePuedaObtenerLaListaDeEmpleadosAusentesEnUnDiaDeterminado() throws Exception {
		SistemaDomotico alexa = new SistemaDomotico();
		Edificio torreSamsung = new Edificio("Torre Samsung", 0, 10, 5);
		Ascensor ascensor1 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor2 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor3 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor4 = new Ascensor(10, 0, 4, 400.0);
		Ascensor ascensor5 = new Ascensor(10, 0, 6, 1200.0);
		Persona persona1 = new Persona("Sofía", "Ramírez", 9867265, TipoDeIdentificacion.CLIENTE, 75);
		Persona persona2 = new Persona("Leonardo", "Belotti", 14234167, TipoDeIdentificacion.CLIENTE, 95);
		Persona persona3 = new Persona("Pablo", "González", 11345623, TipoDeIdentificacion.CLIENTE, 100);
		Persona persona4 = new Persona("Martina", "Escobar", 16543098, TipoDeIdentificacion.CLIENTE, 80);
		Persona persona5 = new Persona("María", "Silvera", 12983109, TipoDeIdentificacion.CLIENTE, 69);
		Persona persona6 = new Persona("Pablo", "Lanzini", 9867265, TipoDeIdentificacion.EMPLEADO, 75);
		Persona persona7 = new Persona("Soledad", "Martínez", 14234167, TipoDeIdentificacion.EMPLEADO, 95);
		Persona persona8 = new Persona("Matías", "Eleazar", 11345623, TipoDeIdentificacion.EMPLEADO, 100);
		Persona persona9 = new Persona("Jesús", "Rivero", 16543098, TipoDeIdentificacion.EMPLEADO, 80);
		Persona persona10 = new Persona("Lautaro", "Lezama", 12983109, TipoDeIdentificacion.EMPLEADO, 69);
		
		assertNotNull(ascensor1);
		assertNotNull(ascensor2);
		assertNotNull(ascensor3);
		assertNotNull(ascensor4);
		assertNotNull(ascensor5);
		
		LocalDate fecha;
		fecha = LocalDate.now();
		
		alexa.configurarSistema(torreSamsung);
		alexa.activarSistema();
		
		assertNotNull(torreSamsung.getAscensores());
		
		alexa.ingresarPersona(persona1);
		alexa.ingresarPersona(persona2);
		alexa.ingresarPersona(persona3);
		alexa.ingresarPersona(persona4);
		alexa.ingresarPersona(persona5);
		alexa.ingresarPersona(persona6);
		alexa.ingresarPersona(persona7);
		alexa.ingresarPersona(persona8);
		alexa.ingresarPersona(persona9);
		alexa.ingresarPersona(persona10);
		
		alexa.registrarIngresoDePersonas(persona1, fecha);
		alexa.registrarIngresoDePersonas(persona2, fecha);
		alexa.registrarIngresoDePersonas(persona3, fecha);
		alexa.registrarIngresoDePersonas(persona4, fecha);
		alexa.registrarIngresoDePersonas(persona5, fecha);
		alexa.registrarIngresoDePersonas(persona6, fecha);
		alexa.registrarIngresoDePersonas(persona7, fecha);
		alexa.registrarIngresoDePersonas(persona8, fecha);
		alexa.registrarIngresoDePersonas(persona9, fecha);
		alexa.registrarIngresoDePersonas(persona10, fecha);
		
		alexa.registrarPersonaQueSubeAlAscensor(persona1, 3, 1);
		alexa.registrarPersonaQueSubeAlAscensor(persona2, 5, 3);
		alexa.registrarPersonaQueSubeAlAscensor(persona3, 6, 2);
		alexa.registrarPersonaQueSubeAlAscensor(persona4, 10, 4);
		alexa.registrarPersonaQueSubeAlAscensor(persona5, 10, 1);
		alexa.registrarPersonaQueSubeAlAscensor(persona6, 3, 1);
		alexa.registrarPersonaQueSubeAlAscensor(persona7, 5, 3);
		alexa.registrarPersonaQueSubeAlAscensor(persona8, 6, 2);
		alexa.registrarPersonaQueSubeAlAscensor(persona9, 10, 4);
		alexa.registrarPersonaQueSubeAlAscensor(persona10, 10, 1);
		
		alexa.registrarPersonaQueBajaDelAscensor(persona1, 3, 1);
		alexa.registrarPersonaQueBajaDelAscensor(persona2, 5, 3);
		alexa.registrarPersonaQueBajaDelAscensor(persona3, 6, 2);
		alexa.registrarPersonaQueBajaDelAscensor(persona4, 10, 4);
		alexa.registrarPersonaQueBajaDelAscensor(persona5, 10, 1);
		alexa.registrarPersonaQueBajaDelAscensor(persona6, 3, 1);
		alexa.registrarPersonaQueBajaDelAscensor(persona7, 5, 3);
		alexa.registrarPersonaQueBajaDelAscensor(persona8, 6, 2);
		alexa.registrarPersonaQueBajaDelAscensor(persona9, 10, 4);
		alexa.registrarPersonaQueBajaDelAscensor(persona10, 10, 1);
		
		alexa.registarIngresoDeEmpleadosASuAreaDeTrabajo(persona6, 3);
		alexa.registarIngresoDeEmpleadosASuAreaDeTrabajo(persona7, 5);
		alexa.registarIngresoDeEmpleadosASuAreaDeTrabajo(persona8, 2);
		alexa.registarIngresoDeEmpleadosASuAreaDeTrabajo(persona9, 10);
		alexa.registarIngresoDeEmpleadosASuAreaDeTrabajo(persona10, 10);
		
		LocalTime tiempo;
		tiempo = LocalTime.now();
		
		alexa.registarEgresoDeEmpleadosASuAreaDeTrabajo(persona6, 3, tiempo);
		alexa.registarEgresoDeEmpleadosASuAreaDeTrabajo(persona7, 5, tiempo);
		alexa.registarEgresoDeEmpleadosASuAreaDeTrabajo(persona8, 2, tiempo);
		alexa.registarEgresoDeEmpleadosASuAreaDeTrabajo(persona9, 10, tiempo);
		alexa.registarEgresoDeEmpleadosASuAreaDeTrabajo(persona10, 10, tiempo);
		
		assertEquals(10, alexa.getPersonasQueSuben().size());
		assertEquals(10, alexa.getPersonasQueBajan().size());
		assertEquals(5, alexa.getEmpleadosQueIngresanASuAreaDeTrabajo().size());
		assertEquals(5, alexa.getEmpleadosQueSalenDeSuAreaDeTrabajo().size());
		
		assertNotNull(alexa.listarEmpleadosAusentes(fecha));
	}
	
	@Test
	public void queSePuedaVerificarElFuncionamientoDeUnAscensor(){
		Ascensor ascensor = new Ascensor(10, 0, 4, 400.0);
		Persona persona1 = new Persona("Sofía", "Ramírez", 9867265, TipoDeIdentificacion.CLIENTE, 75);
		Persona persona2 = new Persona("Leonardo", "Belotti", 14234167, TipoDeIdentificacion.EMPLEADO, 95);
		Persona persona3 = new Persona("Pablo", "González", 11345623, TipoDeIdentificacion.CLIENTE, 100);
		Persona persona4 = new Persona("Martina", "Escobar", 16543098, TipoDeIdentificacion.EMPLEADO, 80);
		Persona persona5 = new Persona("María", "Silvera", 12983109, TipoDeIdentificacion.CLIENTE, 69);
		
		try {
			ascensor.abrirPuerta();
			System.out.println(ascensor.isPuertaAbierta());
			ascensor.cerrarPuerta();
			System.out.println(ascensor.isPuertaAbierta());
			ascensor.abrirPuerta();
			System.out.println(ascensor.isPuertaAbierta());
			ascensor.cerrarPuerta();
			System.out.println(ascensor.isPuertaAbierta());
			System.out.println(ascensor.getPisoActual());
			ascensor.bajar();
			ascensor.bajar();
			ascensor.bajar();
			ascensor.bajar();
			ascensor.bajar();
			ascensor.bajar();
			ascensor.bajar();
			ascensor.bajar();
			ascensor.bajar();
			ascensor.bajar();
			System.out.println(ascensor.getPisoActual());
			ascensor.abrirPuerta();
			System.out.println(ascensor.isPuertaAbierta());
			ascensor.ingresar(persona1);
			ascensor.ingresar(persona2);
			ascensor.ingresar(persona3);
			ascensor.ingresar(persona4);
			ascensor.ingresar(persona5);
			ascensor.cerrarPuerta();
			System.out.println(ascensor.isPuertaAbierta());
			ascensor.subir();
			ascensor.subir();
			System.out.println(ascensor.getPisoActual());	
			System.out.println(ascensor.isPuertaAbierta());
			ascensor.abrirPuerta();
			System.out.println(ascensor.isPuertaAbierta());
			ascensor.salir(persona2);
			ascensor.cerrarPuerta();
			System.out.println(ascensor.isPuertaAbierta());
			ascensor.irAlPiso(8);
			System.out.println(ascensor.getPisoActual());	
		}
		catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
		
		assertEquals(4, ascensor.getContadorDeVecesConSobrecarga());
	}
}