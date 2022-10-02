package ar.edu.unlam.pb2.domotica.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Persona {

	private String nombre;
	private String apellido;
	private int dni;
	private TipoDeIdentificacion tipoDeIdentificacion;
	private HuellaDactilar huellaDactilar;
	private int tarjeta;
	private double peso;
	private LocalDate fechaDeIngreso;
	private LocalTime tiempoRegistrado;
	private int pisoVisitado;
	
	public Persona(String nombre, String apellido, int dni, TipoDeIdentificacion tipoDeIdentificacion, double peso) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.tipoDeIdentificacion = tipoDeIdentificacion;
		this.tarjeta = 0;
		if(tipoDeIdentificacion.equals(TipoDeIdentificacion.EMPLEADO)) {
			HuellaDactilar nueva = new HuellaDactilar();
			huellaDactilar = nueva;
		}
		if(tipoDeIdentificacion.equals(TipoDeIdentificacion.CLIENTE)) {
			this.tarjeta++;
		}
		this.peso = peso;
		this.fechaDeIngreso = null;
		this.tiempoRegistrado = null;
		this.pisoVisitado = 0;
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

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public TipoDeIdentificacion getTipo() {
		return this.tipoDeIdentificacion;
	}
	
	public HuellaDactilar getHuella() {
		return this.huellaDactilar;
	}
	
	public int getTarjeta() {
		return this.tarjeta;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public LocalDate getFechaDeIngreso() {
		return this.fechaDeIngreso;
	}
	
	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
	public LocalTime getTiempoRegistrado() {
		return this.tiempoRegistrado;
	}
	
	public void setTiempoRegistrado(LocalTime tiempoRegistrado) {
		this.tiempoRegistrado = tiempoRegistrado;
	}
	
	public int getPisoVisitado() {
		return this.pisoVisitado;
	}
	
	public void setPisoVisitado(int piso) {
		this.pisoVisitado = piso;
	}

	//@Override
	public String toString() {
		
		return "Persona [Nombre: " + this.nombre + ", Apellido: " + this.apellido + ", DNI: " + this.dni +
				", Identificación: " + this.tipoDeIdentificacion + ", Fecha de ingreso: " + ", Tiempo registrado: " 
				+ this.tiempoRegistrado + ", Piso visitado: " + this.pisoVisitado + "]";
	}	
}