package ar.edu.unlam.pb2.empleados.interfaz;

import java.time.LocalDate;

import ar.edu.unlam.pb2.empleados.dominio.Departamento;
import ar.edu.unlam.pb2.empleados.dominio.Director;
import ar.edu.unlam.pb2.empleados.dominio.Gerente;
import ar.edu.unlam.pb2.empleados.dominio.Ingeniero;

public class InterfazEmpleado {

	public static void main(String[] args) {
		
		LocalDate fecha1;
		fecha1 = LocalDate.of(1978, 5, 23);
		Gerente empleado1 = new Gerente("Leonardo", "Rodríguez", 250000.0, fecha1);
		
		LocalDate fecha2;
		fecha2 = LocalDate.of(1981, 2, 19);
		Director empleado2 = new Director("Sofía", "Villafañe", 300000.0, fecha2);
		
		LocalDate fecha3;
		fecha3 = LocalDate.of(1990, 10, 12);
		Ingeniero empleado3 = new Ingeniero("Matías", "Fernández", 200000.0, fecha3);
		
		System.out.println("---");
		
		empleado1.asignarJefaturaDeDepartamento(Departamento.COMERCIAL);
		empleado2.asignarJefaturaDeDepartamento(Departamento.DIRECCION_GENERAL);
		
		System.out.println(empleado1.toString());
		System.out.println(empleado2.toString());
		System.out.println(empleado3.toString());

		System.out.println("---");
		
		empleado1.asignarCochera();
		empleado2.asignarCochera();
		empleado2.asignarSalarioExtra(50000);
		empleado3.asignarBonificacion(25000);
		
		System.out.println(empleado1.toString());
		System.out.println(empleado2.toString());
		System.out.println(empleado3.toString());
	}
}