package ar.edu.unlam.pb2.empleados.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.edu.unlam.pb2.empleados.dominio.Departamento;
import ar.edu.unlam.pb2.empleados.dominio.Director;
import ar.edu.unlam.pb2.empleados.dominio.Gerente;
import ar.edu.unlam.pb2.empleados.dominio.Ingeniero;

public class TestEmpleados {

	@Test
	public void queSePuedaAsignarBonoPorProductividadAUnEmpleadoDeCategoriaIngeniero() {
		LocalDate fecha;
		fecha = LocalDate.of(1990, 10, 12);
		Ingeniero empleado = new Ingeniero("Matías", "Fernández", 200000.0, fecha);
		double bonoPorProduccion = 25000.0;
		double totalSalario = empleado.getSalario() + bonoPorProduccion;
		
		assertNotNull(empleado);
		
		empleado.asignarBonificacion(bonoPorProduccion);
		
		assertEquals(totalSalario, empleado.getSalario(), 0.00);		
	}
	
	@Test
	public void queSePuedaAsignarUnaCocheraAUnEmpleadoDeCategoriaGerente() {
		LocalDate fecha;
		fecha = LocalDate.of(1978, 5, 23);
		Gerente empleado = new Gerente("Leonardo", "Rodríguez", 250000.0, fecha);
		Boolean seAsignoCochera = true;
		
		assertNotNull(empleado);		
		
		empleado.asignarCochera();
		
		assertEquals(seAsignoCochera, empleado.isTieneCochera());
	}

	@Test
	public void queSePuedaAsignarCategoriaAUnEmpleadoDirector() {
		LocalDate fecha;
		fecha = LocalDate.of(1981, 2, 19);
		Director empleado = new Director("Sofía", "Villafañe", 300000.0, fecha);
		Departamento jefatura = Departamento.DIRECCION_GENERAL;
		
		assertNotNull(empleado);
		
		empleado.asignarJefaturaDeDepartamento(jefatura);
		
		assertEquals(jefatura, Departamento.DIRECCION_GENERAL);	
	}
	
	@Test
	public void queSePuedaAsignarSalarioExtraAUnEmpleadoDeCategoriaDirector() {
		LocalDate fecha;
		fecha = LocalDate.of(1981, 2, 19);
		Director empleado = new Director("Sofía", "Villafañe", 300000.0, fecha);
		double salarioExtra = 30000.0;
		double totalSalario = empleado.getSalario() + salarioExtra;
		
		assertNotNull(empleado);
		
		empleado.asignarSalarioExtra(salarioExtra);
		
		assertEquals(totalSalario, empleado.getSalario(), 0.00);		
	}
}