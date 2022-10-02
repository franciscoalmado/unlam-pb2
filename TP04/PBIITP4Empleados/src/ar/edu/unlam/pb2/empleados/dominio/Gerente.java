package ar.edu.unlam.pb2.empleados.dominio;

import java.time.LocalDate;

public class Gerente extends Empleado {
	
	private Departamento jefatura;
	private boolean tieneCochera;
	
	public Gerente(String nombre, String apellido, double salario, LocalDate fechaDeNacimiento) {
		super(nombre, apellido, salario, fechaDeNacimiento);
		this.tieneCochera = false;
		this.jefatura = null;
	}
	
	public void asignarJefaturaDeDepartamento(Departamento departamento) {
		this.jefatura = departamento;
	}
	
	public Departamento getDepartamento() {
		return this.jefatura;
	}
	
	public void asignarCochera() {	
		if(this.tieneCochera == false) {
			this.tieneCochera = true;
		}
	}
	
	public boolean isTieneCochera() {	
		if(this.tieneCochera == true) {
			return true;
		}		
		return false;
	}
		
	public boolean getTieneCochera() {
		return this.tieneCochera;
	}
	
	public String toString() {
		return "Empleado [Nombre: " + this.getNombre() + ", Apellido: " + this.getApellido() + ", Salario: " + this.getSalario() + ", Fecha de Nacimiento: "
				+ this.getFechaDeNacimiento() + ", Jefatura: " + this.getDepartamento() + ", ¿Tiene cochera?: " + this.getTieneCochera() + "]";
	}
}