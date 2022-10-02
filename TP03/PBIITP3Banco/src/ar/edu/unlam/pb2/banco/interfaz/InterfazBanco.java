package ar.edu.unlam.pb2.banco.interfaz;

import ar.edu.unlam.pb2.banco.dominio.Cuenta;
import ar.edu.unlam.pb2.banco.dominio.TipoDeCuenta;
import ar.edu.unlam.pb2.banco.dominio.TipoDeOperacion;

public class InterfazBanco {

	public static void main(String[] args) throws Exception {
		
		Cuenta cuentaCorriente = new Cuenta(TipoDeCuenta.CORRIENTE);

		try {
			cuentaCorriente.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CORRIENTE, 100);
			System.out.println("Saldo en cuenta: " + cuentaCorriente.getSaldoCuentaCorriente());
			System.out.println("Límite descubierto: " + cuentaCorriente.getLimiteDescubierto());
			System.out.println("Deuda: " + cuentaCorriente.getDeuda());
			System.out.println("--------------------------------------------------------------");
			cuentaCorriente.extraer(TipoDeOperacion.EXTRACCION, TipoDeCuenta.CORRIENTE, 200);
			System.out.println("Saldo en cuenta: " + cuentaCorriente.getSaldoCuentaCorriente());
			System.out.println("Límite descubierto: " + cuentaCorriente.getLimiteDescubierto());
			System.out.println("Deuda: " + cuentaCorriente.getDeuda());
			System.out.println("--------------------------------------------------------------");
			cuentaCorriente.depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CORRIENTE, 200);
			System.out.println("Saldo en cuenta: " + cuentaCorriente.getSaldoCuentaCorriente());
			System.out.println("Límite descubierto: " + cuentaCorriente.getLimiteDescubierto());
			System.out.println("Deuda: " + cuentaCorriente.getDeuda());
		}catch(Exception exception) {
            System.out.println(exception.getMessage());
		}
	}
}