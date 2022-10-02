package ar.edu.unlam.pb2.empleados.dominio;

import java.time.LocalDate;

public class Ingeniero extends Empleado {
	
	private double salario;
	
	public Ingeniero(String nombre, String apellido, double salario, LocalDate fechaDeNacimiento) {
		super(nombre, apellido, salario, fechaDeNacimiento);
		this.salario = salario;
	}
	
	public void asignarBonificacion(double porLaProductividad) {
		this.salario += porLaProductividad;
	}
	
	public String toString() {
		return "Empleado [Nombre: " + this.getNombre() + ", Apellido: " + this.getApellido() + ", Salario: " + this.salario + ", Fecha de Nacimiento: "
				+ this.getFechaDeNacimiento() + "]";
	}
}