package ar.edu.unlam.pb2.banco.dominio;

public class Banco {
	
	private String nombre;
	private Cliente[] clientes;
	private int cantidadDeClientes;
	private int cantidadDeClientesRegistrados;
	private int cantidadDeClientesVip;
	
	public Banco(String nombre, int cantidadDeClientes) {
		this.nombre = nombre;
		this.cantidadDeClientes = cantidadDeClientes;
		this.clientes = new Cliente[this.cantidadDeClientes];
		this.cantidadDeClientesRegistrados = 0;
		this.cantidadDeClientesVip = 0;
	}
	
	public boolean registrarCliente(Cliente nuevoCliente) {
		boolean seRegistro = false;
		
		if(this.cantidadDeClientesRegistrados < this.cantidadDeClientes && verificarSiUnClienteEstaRegistrado(nuevoCliente) == null) {
			this.clientes[this.cantidadDeClientesRegistrados++] = nuevoCliente;
			seRegistro = true;
		}
		
		return seRegistro;
	}
	
	private Cliente verificarSiUnClienteEstaRegistrado(Cliente nuevoCliente) {
		
		for(int i=0; i < this.clientes.length; i++) {
			if(this.clientes[i] != null && this.clientes[i].getDni() == nuevoCliente.getDni()) {
				return this.clientes[i];
			}
		}
		
		return null;
	}
	
	public void reasignarTipoDeClienteAUnClienteExistente() {
		double saldoMinimo = 1000000.0;
	
		for(int i=0; i < this.clientes.length; i++) {
			if(this.clientes[i] != null && this.clientes[i].verificarSiExisteUnaCuentaConSaldoNegativo() == false
					&& this.clientes[i].consolidarSaldoDeCuenta() >= saldoMinimo) {				
						this.clientes[i].setTipoDeCliente(TipoDeCliente.VIP);
						this.cantidadDeClientesVip++;
			}	
		}	
	}
	
	public Cliente[] obtenerLosClientesRecategorizadosComoVip() {
		
		for(int i=0; i < this.clientes.length; i++) {
			if(this.clientes[i] != null && this.clientes[i].getTipoDeCliente().equals(TipoDeCliente.VIP)) {				
				return this.clientes;
			}	
		}	
		
		return null;
	}	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Cliente[] getClientes() {
		return this.clientes;
	}
	
	public int getCantidadDeClientesRegistrados() {
		return this.cantidadDeClientesRegistrados;
	}
	
	public int getCantidadDeClientesVip() {
		return this.cantidadDeClientesVip;
	}
}