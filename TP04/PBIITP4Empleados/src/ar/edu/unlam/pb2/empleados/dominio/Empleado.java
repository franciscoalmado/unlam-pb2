package ar.edu.unlam.pb2.empleados.dominio;

import java.time.LocalDate;

public abstract class Empleado {

	private String nombre;
	private String apellido;
	private double salario;
	private LocalDate fechaDeNacimiento;

	public Empleado(String nombre, String apellido, double salario, LocalDate fechaDeNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public LocalDate getFechaDeNacimiento() {
		return this.fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	@Override
	public abstract String toString();
}