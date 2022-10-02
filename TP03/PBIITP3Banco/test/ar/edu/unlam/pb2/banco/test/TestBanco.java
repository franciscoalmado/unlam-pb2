package ar.edu.unlam.pb2.banco.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.banco.dominio.Banco;
import ar.edu.unlam.pb2.banco.dominio.Cliente;
import ar.edu.unlam.pb2.banco.dominio.Cuenta;
import ar.edu.unlam.pb2.banco.dominio.TipoDeCliente;
import ar.edu.unlam.pb2.banco.dominio.TipoDeCuenta;
import ar.edu.unlam.pb2.banco.dominio.TipoDeOperacion;

public class TestBanco {

	@Test
	public void queSePuedaCrearUnaCuenta() {
		Cuenta cuentaSueldo = new Cuenta(TipoDeCuenta.SUELDO);
		Cuenta cajaDeAhorro = new Cuenta(TipoDeCuenta.CAJA_DE_AHORROS);
		Cuenta cuentaCorriente = new Cuenta(TipoDeCuenta.CORRIENTE);
	
		assertNotNull(cuentaSueldo);
		assertNotNull(cajaDeAhorro);
		assertNotNull(cuentaCorriente);
	}
	
	@Test
	public void queSePuedaCrearUnCliente() {
		Cliente cliente = new Cliente("Leonardo", "Belloti", 17432187);
		
		assertNotNull(cliente);
		assertTrue(cliente.getTipoDeCliente().equals(TipoDeCliente.CONVENCIONAL));
		assertFalse(cliente.getTipoDeCliente().equals(TipoDeCliente.VIP));
	}
	
	@Test
	public void queSePuedaCrearUnBanco() {
		Banco bbva = new Banco("BBVA", 100);
		
		assertNotNull(bbva);
	}

	@Test
	public void queSePuedaAgregarUnaCuentaAUnCliente() {
		Cuenta cuentaSueldo = new Cuenta(TipoDeCuenta.SUELDO);
		Cuenta cajaDeAhorro = new Cuenta(TipoDeCuenta.CAJA_DE_AHORROS);
		Cuenta cuentaCorriente = new Cuenta(TipoDeCuenta.CORRIENTE);
		Cliente cliente = new Cliente("Leonardo", "Belloti", 17432187);
		
		cliente.agregarCuenta(cuentaSueldo);
		cliente.agregarCuenta(cajaDeAhorro);
		cliente.agregarCuenta(cuentaCorriente);		
	}
	
	@Test
	public void queSeCobreCincoPorcientoDeComisionAlDepositarDineroLuegoDeHaberRealizadoUnaExtraccionMayorAlSaldo() throws Exception{
		Cuenta cuentaCorriente = new Cuenta(TipoDeCuenta.CORRIENTE);
		double importe1 = 100.0;
		double importe2 = 200.0;
		double importe3 = 200.0;
		double deuda = 0.00;
		double saldoCuentaCorriente = 95.0;
		double limiteDescubierto = 0.0;
		
		assertNotNull(cuentaCorriente);
		
		cuentaCorriente.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CORRIENTE, importe1);
		cuentaCorriente.extraer(TipoDeOperacion.EXTRACCION, TipoDeCuenta.CORRIENTE, importe2);
		cuentaCorriente.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CORRIENTE, importe3);
		
		assertEquals(deuda, cuentaCorriente.getDeuda(), 0.00);
		assertEquals(saldoCuentaCorriente, cuentaCorriente.getSaldoCuentaCorriente(), 0.00);
		assertEquals(limiteDescubierto, cuentaCorriente.getLimiteDescubierto(), 0.00);
	}
	
	@Test
	public void queSeCobreElCincoPorCientoDeComisionPorMasQueElProximoDepositoNoSeaSuficieteParaCubrirElDescubierto() throws Exception {
		Cuenta cuentaCorriente = new Cuenta(TipoDeCuenta.CORRIENTE);
		double importe1 = 100.0;
		double importe2 = 200.0;
		double importe3 = 100.0;
		double saldoCuentaCorriente = 0.0;
		double deuda = 0.00;
		double limiteDescubierto = 5.0;
		
		assertNotNull(cuentaCorriente);
		
		cuentaCorriente.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CORRIENTE, importe1);
		cuentaCorriente.extraer(TipoDeOperacion.EXTRACCION, TipoDeCuenta.CORRIENTE, importe2);
		cuentaCorriente.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CORRIENTE, importe3);
		
		assertEquals(saldoCuentaCorriente, cuentaCorriente.getSaldoCuentaCorriente(), 0.00);
		assertEquals(deuda, cuentaCorriente.getDeuda(), 0.00);
		assertEquals(limiteDescubierto, cuentaCorriente.getLimiteDescubierto(), 0.00);
	}
	
	@Test
	public void queUnaExtraccionCuandoYaSeTieneDeudaIncrementeLaDeuda() throws Exception {
		Cuenta cuentaCorriente = new Cuenta(TipoDeCuenta.CORRIENTE);
		double importe1 = 100.0;
		double importe2 = 200.0;
		double importe3 = 50.0;
		double saldoCuentaCorriente = 0.0;
		double deuda = 7.50;
		double limiteDescubierto = 150.0;
		
		assertNotNull(cuentaCorriente);
		
		cuentaCorriente.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CORRIENTE, importe1);
		cuentaCorriente.extraer(TipoDeOperacion.EXTRACCION, TipoDeCuenta.CORRIENTE, importe2);
		cuentaCorriente.extraer(TipoDeOperacion.EXTRACCION, TipoDeCuenta.CORRIENTE, importe3);
		
		assertEquals(saldoCuentaCorriente, cuentaCorriente.getSaldoCuentaCorriente(), 0.00);
		assertEquals(deuda, cuentaCorriente.getDeuda(), 0.00);
		assertEquals(limiteDescubierto, cuentaCorriente.getLimiteDescubierto(), 0.00);
	}
	
	@Test
	public void queVariasOperacionesDeDepositoYExtraccionGenerenElSaldoYLaDeudaCorrecto() throws Exception {
		Cuenta cuentaCorriente = new Cuenta(TipoDeCuenta.CORRIENTE);
		double importe1 = 100.0;
		double importe2 = 200.0;
		double importe3 = 50.0;
		double importe4 = 50.0;
		double importe5 = 40.0;
		double importe6 = 150.0;
		double saldoCuentaCorriente = 0.50;
		double deuda = 0.00;
		double limiteDescubierto = 0.0;
		
		assertNotNull(cuentaCorriente);
		
		cuentaCorriente.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CORRIENTE, importe1);
		cuentaCorriente.extraer(TipoDeOperacion.EXTRACCION, TipoDeCuenta.CORRIENTE, importe2);
		cuentaCorriente.extraer(TipoDeOperacion.EXTRACCION, TipoDeCuenta.CORRIENTE, importe3);
		cuentaCorriente.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CORRIENTE, importe4);
		cuentaCorriente.extraer(TipoDeOperacion.EXTRACCION, TipoDeCuenta.CORRIENTE, importe5);
		cuentaCorriente.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CORRIENTE, importe6);
	
		assertEquals(saldoCuentaCorriente, cuentaCorriente.getSaldoCuentaCorriente(), 0.00);
		assertEquals(deuda, cuentaCorriente.getDeuda(), 0.00);
		assertEquals(limiteDescubierto, cuentaCorriente.getLimiteDescubierto(), 0.00);
	}
	
	@Test
	public void queSePuedaObtenerLaCantidadDeClientesVip() {
		Cuenta cuentaSueldo = new Cuenta(TipoDeCuenta.SUELDO);
		Cuenta cajaDeAhorro = new Cuenta(TipoDeCuenta.CAJA_DE_AHORROS);
		Cuenta cuentaCorriente = new Cuenta(TipoDeCuenta.CORRIENTE);
		Cliente cliente = new Cliente("Leonardo", "Belloti", 17432187);
		Banco bbva = new Banco("BBVA", 100);		
		double importe1 = 300000.0;
		double importe2 = 300000.0;
		double importe3 = 500000.0;
			
		cliente.agregarCuenta(cuentaSueldo);
		cliente.agregarCuenta(cajaDeAhorro);
		cliente.agregarCuenta(cuentaCorriente);
		
		cuentaSueldo.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.SUELDO, importe1);
		cajaDeAhorro.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CAJA_DE_AHORROS, importe2);
		cuentaCorriente.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CORRIENTE, importe3);	
	
		bbva.registrarCliente(cliente);
		
		bbva.reasignarTipoDeClienteAUnClienteExistente();
			
		assertNotNull(bbva.obtenerLosClientesRecategorizadosComoVip());
		
		assertEquals(1, bbva.getCantidadDeClientesVip());
	}	
}