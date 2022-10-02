package ar.edu.unlam.pb2.domotica.dominio;

public class Ascensor {

	private final int PISO_MAXIMO;
	private final int PISO_MINIMO;
	private final double PESO_MAXIMO;
	private final int CAPACIDAD_MAXIMA;
	private boolean puertaAbierta;
	private boolean sobrecarga;
	private int pisoActual;
	private double pesoActual;
	private int capacidadActual;
	private int contadorDeUsuarios;
	private int contadorDeVecesConSobrecarga;
	private boolean isPisoActual;

	public Ascensor(int pisoMaximo, int pisoMinimo, int capacidadMaxima, double pesoMaximo) {
		this.PISO_MAXIMO = pisoMaximo;
		this.PISO_MINIMO = pisoMinimo;
		this.CAPACIDAD_MAXIMA = capacidadMaxima;
		this.PESO_MAXIMO = pesoMaximo;
		this.sobrecarga = false;
		this.puertaAbierta = false;
		this.contadorDeUsuarios = 0;
		this.pisoActual = pisoMaximo;
		this.contadorDeVecesConSobrecarga = 0;
	}

	public void ingresar(Persona usuarioQueSube) throws Exception {	

		this.ingresar(usuarioQueSube.getPeso());
		this.verificarPesoYCapacidad();
	}
	
	public void salir(Persona usuarioQueBaja) throws Exception {	
		
		this.salir(usuarioQueBaja.getPeso());
		this.verificarPesoYCapacidad();
	}
	
	public void ingresar(double peso) {	
		if(this.isPuertaAbierta() == true) {
			this.pesoActual += peso;
			this.contadorDeUsuarios++;			
		}
	}
	
	public void salir(double peso) {	
		if(this.isPuertaAbierta() == true) {
			this.pesoActual -= peso;	
			this.contadorDeUsuarios--;
		}
	}
		
	public void abrirPuerta() {		
		if(this.puertaAbierta == false) {
			this.puertaAbierta = true;
		}
	}
	
	public void cerrarPuerta() {	
		if(this.puertaAbierta == true) {
			this.puertaAbierta = false;
		}
	}
	
	public boolean isPuertaAbierta() {	
		if(this.isSobrecarga() == true || this.puertaAbierta == true) {
			return true;
		}
		return false;
	}
	
	public void subir() {	
		if(this.pisoActual < this.PISO_MAXIMO && this.isPuertaAbierta() == false && this.isSobrecarga() == false) {
			this.pisoActual++;
			this.isPisoActual();
		}
	}
	
	public void bajar() {	
		if(this.pisoActual > this.PISO_MINIMO && this.isPuertaAbierta() == false && this.isSobrecarga() == false) {
			this.pisoActual--;
			this.isPisoActual();
		}
	}
	
	public int getPisoActual() {	
		return this.pisoActual;
	}
	
	public void  irAlPiso(int pisoDeseado){
    	if (pisoDeseado >= PISO_MINIMO && pisoDeseado <= PISO_MAXIMO && this.isPuertaAbierta() == false) {
	    	while (pisoDeseado < this.pisoActual) {
	    		this.pisoActual--;
	    		this.isPisoActual();
			}
			while (pisoDeseado > this.pisoActual) {
				this.pisoActual++;
				this.isPisoActual();
			}
		}
    }
	
	public void verificarPesoYCapacidad() throws Exception{		
		if(this.isSobrecarga() == true)
			throw new Exception("Atención: Hay sobrecarga! Debe salir algún usuario.");
		this.contadorDeVecesConSobrecarga++;
	}
	
	private boolean isSobrecarga() {	
		if(this.pesoActual > this.PESO_MAXIMO || this.capacidadActual > this.CAPACIDAD_MAXIMA) {
			this.sobrecarga = true;
		}
		return this.sobrecarga;
	}
	
	public double getPesoActual() {
		return this.pesoActual;
	}

	public int getCapacidadActual() {				
		this.capacidadActual = this.contadorDeUsuarios;		
		return this.capacidadActual;
	}
	
	public int getCAPACIDAD_MAXIMA() {
		return this.CAPACIDAD_MAXIMA;
	}
	
	public double getPESO_MAXIMO() {
		return this.PESO_MAXIMO;
	}
	
	public int getPISO_MAXIMO() {
		return this.PISO_MAXIMO;
	}
	
	public int getPISO_MINIMO() {
		return this.PISO_MINIMO;
	}
	
	public int getContadorDeVecesConSobrecarga() {
		return this.contadorDeVecesConSobrecarga;
	}
	
	public boolean isPisoActual() {
		return this.isPisoActual;
	}
	
	public void setIsPisoActual(boolean isPisoActual) {
		this.isPisoActual = isPisoActual;
	}
}