package ar.edu.unlam.pb2.vuelo.dominio;

public class Vuelo {

	private final int CANTIDAD_DE_FILAS = 32;
	private final int CANTIDAD_DE_ASIENTOS_POR_FILA = 6;
	private String origen;
	private String destino;
	private Pasajero[] pasajeros;
	private Pasajero[][] asientos;
	private int cantidadActualDePasajeros;
	
	public Vuelo(String origen, String destino, int cantidadPasajero) {
		this.origen = origen;
		this.destino = destino;
		this.pasajeros = new Pasajero[cantidadPasajero];
		this.asientos = new Pasajero[CANTIDAD_DE_FILAS][CANTIDAD_DE_ASIENTOS_POR_FILA];
		this.cantidadActualDePasajeros = 0;
	}

	/*
	* Agrega un nuevo pasajero a la lista de pasajeros del vuelo.
	*/
	public boolean agregarPasajero(Pasajero pasajero) {	

		boolean seAgregoPasajero = false;
		
		if(this.cantidadActualDePasajeros < this.asientos.length && verificarQueDNIDelPasajeroNoEsteRepetido(pasajero) == false) {
			this.pasajeros[this.cantidadActualDePasajeros++] = pasajero;
			seAgregoPasajero = true;
		}
		
		return seAgregoPasajero;
	}
	
	private boolean verificarQueDNIDelPasajeroNoEsteRepetido(Pasajero pasajero) {
		boolean esDniRepetido = false;
		
		for(int i=0; i < this.pasajeros.length; i++) {
			if(this.pasajeros[i] != null && this.pasajeros[i].getDni() == pasajero.getDni()) {
				esDniRepetido = true;
				break;
			}
		}
		
		return esDniRepetido;
	}

	/*
	* Verifica si un asiento indicado se encuentra disponible.
	*/
	public boolean verificarDisponibilidadAsiento(int fila, int columna) {		

		boolean isDisponible = false;
		
		for(int i=0; i < this.asientos.length; i++){
			for(int j=0; j < this.asientos.length; j++) {
				if(this.asientos[i][j] == null){
					isDisponible = true;
					break;
				}
			}
		}
	
		return isDisponible;
	}
	
	/*
	* Busca un pasajero en la lista de pasajeros a partir del DNI
	*/
	public Pasajero buscarPasajero(int dni) {
		
		for(int i=0; i < this.pasajeros.length; i++){
			if(this.pasajeros[i] != null && this.pasajeros[i].getDni() == dni){
				return this.pasajeros[i];
			}	
		}
		
		return null;
	}
	
	/*
	* Asigna el asiento al pasajero recibido por parámetro.
	*/
	
	public boolean asignarAsiento(Pasajero pasajero, int fila, int columna) {	

		boolean sePudoAsignar = false;
		
		if(verificarDisponibilidadAsiento(fila, columna) == true){
			this.asientos[fila][columna] = pasajero;
			sePudoAsignar = true;
		}
		
		return sePudoAsignar;
	}

	/*
	* Ordena la lista de pasajeros por DNI.
	*/
	public void ordenarListaDePasajerosPorDNI() {

		Pasajero auxiliar = null;
		
		for(int i=1; i < this.pasajeros.length; i++) {
			for(int j=0; j < this.pasajeros.length-1; j++){
				if(this.pasajeros[i] != null && pasajeros[j].getDni() > this.pasajeros[j+1].getDni()) {
					auxiliar = this.pasajeros[j+1];
					this.pasajeros[j+1] = this.pasajeros[j];
					this.pasajeros[j] = auxiliar;		
				}	
			}	
		}
	}
	
	public Pasajero[] getPasajeros() {		
		return this.pasajeros;
	}

	/*
	* Se obtiene un mapa de los asientos del vuelo indicando por cada uno
	si se encuentra libre "L" u ocupado "O".
	*/
	public String toString() {		

		String mapaDeAsientos = "";
		
		for(int i=0; i < this.asientos.length; i++){
			for(int j=0; j < this.asientos[i].length; j++){
				if(this.asientos[i][j] == null){
					mapaDeAsientos += ("L"+"\t");
				}
				else{
					mapaDeAsientos += ("O"+"\t");
				}
			}
			mapaDeAsientos += "\n";
		}

		return mapaDeAsientos;
	}
	
	public String getOrigen() {
		return this.origen;
	}
	
	public String getDestino() {
		return this.destino;
	}
	
	public int getCantidadActualDePasajeros() {
		return this.cantidadActualDePasajeros;
	}
}