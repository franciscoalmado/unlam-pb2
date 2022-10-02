package ar.edu.unlam.pb2.empleados.dominio;

import java.time.LocalDate;

public class Director extends Gerente{

	private double salario;
	
	public Director(String nombre, String apellido, double salario, LocalDate fechaDeNacimiento) {
		super(nombre, apellido, salario, fechaDeNacimiento);
		this.salario = salario;
	}

	public void asignarSalarioExtra(double salarioExtra) {
		this.salario += salarioExtra;
	}
	
	public String toString() {
		return "Empleado [Nombre: " + this.getNombre() + ", Apellido: " + this.getApellido() + ", Salario: " + this.salario + ", Fecha de Nacimiento: "
				+ this.getFechaDeNacimiento() + ", Jefatura: " + this.getDepartamento() + ", ¿Tiene cochera?: " + this.getTieneCochera() + "]";
	}	
}