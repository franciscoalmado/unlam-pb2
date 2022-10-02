package ar.edu.unlam.pb2.banco.dominio;

public class Cuenta {
	
	private TipoDeCuenta cuenta;
	private double saldo;
	private double saldoCajaDeAhorro;
	private double saldoCuentaSueldo;
	private double saldoCuentaCorriente;
	private double comisionPorExtraccionEnCajaDeAhorro;
	private int contadorDeExtraccionesEnCajaDeAhorro;
	private final int MAXIMO_DESCUBIERTO; 
	private double limiteDescubierto;
	private double comisionCuentaCorrientePorSobregiro;
	private double deuda;
	
	public Cuenta(TipoDeCuenta cuenta) {
		this.cuenta = cuenta;
		this.inicializarUnaCuenta(this.cuenta);
		this.MAXIMO_DESCUBIERTO = 150;	
	}
	
	/*
	 * Registra las operaciones de depósito según el tipo de cuenta y su importe.
	 */
	public void depositar(TipoDeOperacion tipo, TipoDeCuenta cuenta, double importe) {
		double montoDeudaTotal = 0.0;
		double montoDescontado = 0.0;
		double montoDeDeuda = 0.0;

		if(TipoDeOperacion.DEPOSITO.equals(tipo) && TipoDeCuenta.CAJA_DE_AHORROS.equals(cuenta)) {
        	this.saldoCajaDeAhorro += importe;
        }

		if(TipoDeOperacion.DEPOSITO.equals(tipo) && TipoDeCuenta.SUELDO.equals(cuenta)) {
        	this.saldoCuentaSueldo += importe;
        }
		
		if(TipoDeOperacion.DEPOSITO.equals(tipo) && TipoDeCuenta.CORRIENTE.equals(cuenta)) {	
			
			if(this.deuda == 0) {
				this.saldoCuentaCorriente += importe;
			}
			
			if(this.deuda > 0) {
				montoDeudaTotal = this.deuda + this.limiteDescubierto;
				if(montoDeudaTotal < importe) {
					montoDescontado = importe - montoDeudaTotal;
					this.saldoCuentaCorriente = montoDescontado;
					montoDeDeuda = this.deuda;
					this.limiteDescubierto -= this.limiteDescubierto;
					this.deuda -= montoDeDeuda;
				}else {
					montoDeDeuda = this.deuda;
					this.limiteDescubierto -= importe - this.deuda;
					this.deuda -= montoDeDeuda;
				}	
			}
        }
	}

	/*
	 * Registra las operaciones de extracción según el tipo de cuenta y su importe.
	 * 1.- En la cuenta Sueldo, se puede extraer como máximo el monto disponible al momento de realizar la operación. 
	 * 2.- En la cuenta Caja de Ahorro, es igual a la cuenta Sueldo, con la diferencia que se le agrega una comisión
	 *     de $6 superada las 5 primeras extracciones. 
	 * 3.- En la cuenta Corriente, además del monto disponible en la cuenta se le agrega un monto como límite en
	 *     descubierto que permitirá que la cuenta pueda estar sobregirada hasta ese monto. Por cada extracción en
	 *     sobregiro se cobrará una comisión equivalente al 5% sobre el importe en extracción.
	 */
    public void extraer(TipoDeOperacion tipo, TipoDeCuenta cuenta, double importe) throws Exception{
    	double montoParaComision = 0.0;
        
    	if(TipoDeOperacion.EXTRACCION.equals(tipo) && TipoDeCuenta.SUELDO.equals(cuenta)) {
        	if (this.saldoCuentaSueldo < importe)
        		throw new Exception("Saldo insuficiente");
        	this.saldoCuentaSueldo -= importe;
    	}
    	
    	if(TipoDeOperacion.EXTRACCION.equals(tipo) && TipoDeCuenta.CAJA_DE_AHORROS.equals(cuenta)) {
    		if (this.saldoCajaDeAhorro < importe) 
    			throw new Exception("Saldo insuficiente");
    		
    		this.contadorDeExtraccionesEnCajaDeAhorro++;
    		
    		if(this.contadorDeExtraccionesEnCajaDeAhorro >= 6) {
    			this.saldoCajaDeAhorro -= importe + this.comisionPorExtraccionEnCajaDeAhorro;
    		}else {
    			this.saldoCajaDeAhorro -= importe;
    		}
    	}
    	
    	if(TipoDeOperacion.EXTRACCION.equals(tipo) && TipoDeCuenta.CORRIENTE.equals(cuenta)) {
    		if (this.saldoCuentaCorriente + this.MAXIMO_DESCUBIERTO < importe)
    			throw new Exception("Saldo insuficiente");
    		
    		if(this.saldoCuentaCorriente >= importe) {
    			this.saldoCuentaCorriente -= importe;
    		}
    		
    		if(this.saldoCuentaCorriente + this.MAXIMO_DESCUBIERTO >= importe) {
    			montoParaComision = importe - this.saldoCuentaCorriente; 
				this.saldoCuentaCorriente -= this.saldoCuentaCorriente; 
    			this.deuda += montoParaComision * this.comisionCuentaCorrientePorSobregiro;
				this.limiteDescubierto += montoParaComision;
    		}
    	}
    }
    
    /*
     * Inicializa una cuenta bancaria.
     */
    private void inicializarUnaCuenta(TipoDeCuenta cuenta) {

    	if(TipoDeCuenta.SUELDO.equals(cuenta)) {
    		depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.SUELDO, 0.0);
    	}
    	
    	if(TipoDeCuenta.CAJA_DE_AHORROS.equals(cuenta)) {
    		depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CAJA_DE_AHORROS, 0.0);
    		this.comisionPorExtraccionEnCajaDeAhorro = 6.0;
    		this.contadorDeExtraccionesEnCajaDeAhorro = 0;
    	}
    	    	
    	if(TipoDeCuenta.CORRIENTE.equals(cuenta)) {
    		depositar(TipoDeOperacion.DEPOSITO, TipoDeCuenta.CORRIENTE, 0.0);
    		this.comisionCuentaCorrientePorSobregiro = 0.05;
    		this.limiteDescubierto = 0;
    	}
    }
    
    /*
     * Muestra el saldo de cuenta dependiendo de su tipo.  
     */
    public double mostrarSaldoEnCuenta(TipoDeCuenta tipo) {
    	
    	if(TipoDeCuenta.SUELDO.equals(tipo)) {
    		this.saldo = getSaldoCuentaSueldo();
    	}
    	
    	if(TipoDeCuenta.CAJA_DE_AHORROS.equals(tipo)) {
    		this.saldo = getSaldoCajaDeAhorro();
    	}
    	
    	if(TipoDeCuenta.CORRIENTE.equals(tipo)) {
    		this.saldo = getSaldoCuentaCorriente();
    	}
    	
    	return this.saldo;
    }
    
    public double consolidarSaldo() {
    	
    	this.saldo = getSaldoCuentaSueldo() + getSaldoCajaDeAhorro() + getSaldoCuentaCorriente();
    	
    	return this.saldo;
    }
    
    public double getSaldoCuentaSueldo() {
		return this.saldoCuentaSueldo;
	}

	public double getSaldoCajaDeAhorro() {
		return this.saldoCajaDeAhorro;
	}
	
	public double getSaldoCuentaCorriente() {
		return this.saldoCuentaCorriente;
	}
	
	public double getDeuda() {
		return this.deuda;
	}
	
	public double getLimiteDescubierto() {
		return this.limiteDescubierto;
	}
	
	@Override
	public String toString() {
		return "[Cuenta: " + this.cuenta + ", saldo: " + consolidarSaldo() + ", deuda: " + getDeuda() + "]";
	}  		       		    
}