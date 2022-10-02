package ar.edu.unlam.pb2.buscaminas.dominio;

import java.util.LinkedList;
import java.util.List;

public class Tablero {

	private Casilla[][] casillas;
	private int numeroDeFilas;
	private int numeroDeColumnas;
	private int numeroDeMinas;
	private int cantidadDeCasillasAbiertas;

	public Tablero(int numeroDeFilas, int numeroDeColumnas, int numeroDeMinas) {
		this.numeroDeFilas = numeroDeFilas;
		this.numeroDeColumnas = numeroDeColumnas;
		this.numeroDeMinas = numeroDeMinas;
		this.inicializarCasillas();
		this.cantidadDeCasillasAbiertas = 0;
	}
	
	//Se inicializan las casillas
	public void inicializarCasillas() {
		this.casillas = new Casilla[this.numeroDeFilas][this.numeroDeColumnas];
		for (int i = 0; i < this.casillas.length; i++) {
			for (int j = 0; j < this.casillas[i].length; j++) {
				this.casillas[i][j] = new Casilla(i, j);
			}
		}
		generarMinas();
	}
	
	//Se generan las minas aleatoriamente 
	public void generarMinas() {
		int minasGeneradas = 0;
		while (minasGeneradas != this.numeroDeMinas) {
			int posTmpFila = (int) (Math.random() * this.casillas.length);
			int posTmpColumna = (int) (Math.random() * this.casillas[0].length);
			if (!this.casillas[posTmpFila][posTmpColumna].isMina()) {
				this.casillas[posTmpFila][posTmpColumna].setMina(true);
				minasGeneradas++;
			}
		}
		actualizarNumeroMinasAlrededor();
	}

	/*
	 *Actualiza la cantidad de minas que tiene alrededor una casilla sin minas.
	 *Se usa el forEach para recorrer la lista de elementos.
	 *Como parámetro del forEach se usa una función Lambda en la que se incrementa 
	 *la cantidad de minas que se encuentran alrededor de dicha casilla. 
	 */
	public void actualizarNumeroMinasAlrededor() {
		for (int i = 0; i < this.casillas.length; i++) {
			for (int j = 0; j < this.casillas[i].length; j++) {
				if (this.casillas[i][j].isMina()) {
					List<Casilla> casillasAlrededor = obtenerCasillasAlrededor(i, j);
					casillasAlrededor.forEach((casilla) -> casilla.incrementarNumeroMinasAlrededor());
				}
			}
		}
	}
	
	/*
	 *Determina una lista de casillas que se encuentran alrededor de una casilla en específico.
	 *Se toma en cuenta, que en el interior del tablero existen casillas que tienen alrededor 
	 *un máximo de 8 casillas. Las de borde tienen 3 casillas alrededor y las de las esquinas 
	 *tienen 2 casillas alrededor. 
	 *Se usa el método .add() para ir añadiendo cada una de las casillas a la lista de casillas.
	 */
	public List<Casilla> obtenerCasillasAlrededor(int posicionFila, int posicionColumna) {
		List<Casilla> listaDeCasillas = new LinkedList<>();

		for (int i = 0; i < 8; i++) {
			int temporalPosicionFila = posicionFila;
			int temporalPosicionColumna = posicionColumna;
			switch (i) {
				case 0: // Arriba centro
					temporalPosicionFila--;
					break; 
				case 1: // Arriba derecha
					temporalPosicionFila--;
					temporalPosicionColumna++;
					break; 
				case 2: // Derecha
					temporalPosicionColumna++;
					break; 
				case 3: // Derecha abajo
					temporalPosicionColumna++;
					temporalPosicionFila++;
					break; 
				case 4: // Abajo centro
					temporalPosicionFila++;
					break; 
				case 5: // Abajo izquierda
					temporalPosicionFila++;
					temporalPosicionColumna--;
					break; 
				case 6: // Izquierda
					temporalPosicionColumna--;
					break; 
				case 7: // Izquierda arriba
					temporalPosicionFila--;
					temporalPosicionColumna--;
					break; 
			}

			if (temporalPosicionFila >= 0 && temporalPosicionFila < this.casillas.length && temporalPosicionColumna >= 0
					&& temporalPosicionColumna < this.casillas[0].length) {
				listaDeCasillas.add(this.casillas[temporalPosicionFila][temporalPosicionColumna]);
			}

		}
		return listaDeCasillas;
	}
	
	//Se marca una casilla como abierta cuando es seleccionada.
	public boolean marcarCasillaAbierta(int fila, int columna) {
		boolean seMarco = false;
		
		if(!this.casillas[fila][columna].isAbierta()) {
			cantidadDeCasillasAbiertas++;
			this.casillas[fila][columna].setAbierta(true);
			seMarco = true;
		}
		
		return seMarco;
	}
	
	public Casilla[][] getCasilleros(){
		return this.casillas;
	}
	
	public int getCantidadDeCasillasAbiertas() {
		return this.cantidadDeCasillasAbiertas;
	}
}