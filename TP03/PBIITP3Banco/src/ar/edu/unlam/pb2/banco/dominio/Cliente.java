package ar.edu.unlam.pb2.banco.dominio;

import java.util.Arrays;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private int dni;
	private TipoDeCliente tipoDeCliente;
	private Cuenta[] cuentas;
	private int cantidadDeCuentas;
	private double saldoConsolidado;
 	
	public Cliente(String nombre, String apellido, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.tipoDeCliente = TipoDeCliente.CONVENCIONAL;
		this.cuentas = new Cuenta[3];
		this.cantidadDeCuentas = 0;
		this.saldoConsolidado = 0.0;
	}

	public void agregarCuenta(Cuenta nueva) {
		
		if(this.cantidadDeCuentas < this.cuentas.length) {
			this.cuentas[this.cantidadDeCuentas++] = nueva;
		}
	}
	
	public boolean verificarSiExisteUnaCuentaConSaldoNegativo() {
		boolean isSaldoNegativo = false;
		
		for(int i=0; i < this.cuentas.length; i++) {
			if(this.cuentas[i] != null && (this.cuentas[i].getSaldoCuentaSueldo() < 0 ||
					this.cuentas[i].getSaldoCajaDeAhorro() < 0 || 
					this.cuentas[i].getSaldoCuentaCorriente() < 0)) {
				isSaldoNegativo = true;
			}
		}
		
		return isSaldoNegativo;
	}
	
	public double consolidarSaldoDeCuenta() {
		
		for(int i=0; i < this.cuentas.length; i++) {
			if(this.cuentas[i] != null) {
				this.saldoConsolidado += this.cuentas[i].getSaldoCuentaSueldo() +
						this.cuentas[i].getSaldoCajaDeAhorro() +
						this.cuentas[i].getSaldoCuentaCorriente();
			}	
		}
		
		return this.saldoConsolidado;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public int getDni() {
		return this.dni;
	}

	public TipoDeCliente getTipoDeCliente() {
		return this.tipoDeCliente;
	}

	public void setTipoDeCliente(TipoDeCliente tipoDeCliente) {
		this.tipoDeCliente = tipoDeCliente;
	}
	
	public Cuenta[] getCuentas() {
		return this.cuentas;
	}

	@Override
	public String toString() {
		return "Cliente [Nombre: " + this.nombre + ", Apellido: " + this.apellido + ", DNI: " + this.dni + ", Tipo de Cliente: "
				+ this.tipoDeCliente + ", Cuentas que posee: " + Arrays.toString(this.cuentas) + "]";
	}
}