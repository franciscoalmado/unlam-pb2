package ar.edu.unlam.pb2.buscaminas.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb2.buscaminas.dominio.Casilla;
import ar.edu.unlam.pb2.buscaminas.dominio.NivelDeJuego;
import ar.edu.unlam.pb2.buscaminas.dominio.Tablero;

public class Buscaminas {

	static Scanner teclado = new Scanner(System.in);
	private static Tablero tablero;
	private static int contador = 0;
	
	public static void main(String[] args) {
		
		seleccionarNivelDeDificultad();
		System.out.println("---");
		imprimirPistas(tablero.getCasilleros());
		System.out.println("---");
		jugar(tablero.getCasilleros());
	}
	
	private static void seleccionarNivelDeDificultad() {
		int opcion = 0;
		NivelDeJuego nivelElegido = null;

		do {
			System.out.println("Seleccione el nivel:\n1. Principiante\n2. Intermedio\n3. Experto");
			opcion = teclado.nextInt();
		} while (opcion < 1 || opcion > 3);

		switch (opcion) {
		case 1:
			nivelElegido = NivelDeJuego.FACIL;
			break;
		case 2:
			nivelElegido = NivelDeJuego.INTERMEDIO;
			break;
		case 3:
			nivelElegido = NivelDeJuego.EXPERTO;
			break;
		}

		if (nivelElegido.equals(NivelDeJuego.FACIL)) {
			tablero = new Tablero(3, 3, 1);
			contador = (3 * 3) - (1);
		}

		if (nivelElegido.equals(NivelDeJuego.INTERMEDIO)) {
			tablero = new Tablero(6, 6, 10);
			contador = (6 * 6) - (10);
		}

		if (nivelElegido.equals(NivelDeJuego.EXPERTO)) {
			tablero = new Tablero(10, 10, 30);
			contador = (10 * 10) - (30);
		}
	}
	
	private static void imprimirTablero(Casilla[][] casillas) {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				System.out.print(casillas[i][j].isMina() ? "*" : "X");	
			}
			System.out.println("");
		}
	}
	
	private static void imprimirPistas(Casilla[][] casillas) {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				System.out.print(casillas[i][j].getNumMinasAlrededor() + "");
			}
			System.out.println("");
		}
	}
	
	private static Casilla buscarCasilla(Casilla[][] casillas) {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if(!casillas[i][j].isMina() && !casillas[i][j].isAbierta()) {
					return casillas[i][j];
				}
			}	
		}
		return null;
	}
	
	private static void jugar(Casilla[][] casillas){
		boolean perdido = false;
		
		do {
			System.out.println("Ingrese el número de fila y columna que desea explorar:");
			System.out.print("Ingrese el número de la fila: ");
			int fila = 0; fila = teclado.nextInt();
			int columna = 0; System.out.print("Ingrese el número de la columna: ");
			columna = teclado.nextInt();	
			
			if(buscarCasilla(casillas) != null) {	
				tablero.marcarCasillaAbierta(fila, columna);
				contador--;	
			}
		
			if(contador == 0) {
				imprimirTablero(casillas);
				System.out.println("GANASTE!!!" + " Muchas felicidades. Fue un gran juego!!!");
			}else {
				if(casillas[fila][columna].isMina()) {
					imprimirTablero(casillas);
					System.out.println("BOOOOOOOOM!!!!!" + " Perdiste el juego!!!");
					perdido = true;
				}	
			}			
		}
		while(contador > 0 && !perdido);	
	}
}