package ar.edu.unlam.pb2.futsal.dominio;

import java.util.Arrays;

public class PartidoDeFutbol {
	private EquipoDeFutbol local;
	private EquipoDeFutbol visitante;
	private Evento goles[];
	private Evento amonestados[];
	private Evento expulsados[];
	private int cantidadDeGoles;
	private int cantidadMaximaDeGoles;
	private int cantidadDeGolesEquipoLocal;
	private int cantidadDeGolesEquipoVisitante;
	private int cantidadDeJugadoresAmonestados;
	private int cantidadDeJugadoresAmonestadosEquipoLocal;
	private int cantidadDeJugadoresAmonestadosEquipoVisitante;
	private int cantidadMaximaDeAmonestaciones;
	private int cantidadDeJugadoresExpulsados;
	private int cantidadDeJugadoresExpulsadosEquipoLocal;
	private int cantidadDeJugadoresExpulsadosEquipoVisitante;	
	private int cantidadMaximaDeExpulsiones;
	
	public PartidoDeFutbol(EquipoDeFutbol local, EquipoDeFutbol visitante) {
		this.local = local;
		this.visitante = visitante;
		this.cantidadDeGoles = 0;
		this.cantidadMaximaDeGoles = 20;
		this.cantidadDeGolesEquipoLocal = 0;
		this.cantidadDeGolesEquipoVisitante = 0;
		this.cantidadDeJugadoresAmonestados = 0;
		this.cantidadMaximaDeAmonestaciones = 20;
		this.cantidadDeJugadoresAmonestadosEquipoLocal = 0;
		this.cantidadDeJugadoresAmonestadosEquipoVisitante = 0;
		this.cantidadDeJugadoresExpulsados = 0;
		this.cantidadDeJugadoresExpulsadosEquipoLocal = 0;
		this.cantidadDeJugadoresExpulsadosEquipoVisitante = 0;
		this.cantidadMaximaDeExpulsiones = 10;
		this.goles = new Evento[cantidadMaximaDeGoles];
		this.amonestados = new Evento[cantidadMaximaDeAmonestaciones];
		this.expulsados = new Evento[cantidadMaximaDeExpulsiones];
	}
	
	/*
	 * Se marca un nuevo Gol. 
	 * Se contabiliza si es a favor o en contra, según el juegador que haya anotado.
	 * */
	public void marcar(Evento gol) {
		
		for(int i=0; i < this.goles.length; i++) {
			if(this.goles[i] == null && this.cantidadDeGoles < this.cantidadMaximaDeGoles) {
				if(gol.getTipo().equals(TipoDeEvento.GOL_A_FAVOR) && verificarNumeroDelJugadorAutorDelEvento(local, gol) == true) {
					this.goles[i] = gol;
					this.cantidadDeGolesEquipoLocal++;
				}
				if(gol.getTipo().equals(TipoDeEvento.GOL_A_FAVOR) && verificarNumeroDelJugadorAutorDelEvento(visitante, gol) == true) {
					this.goles[i] = gol;
					this.cantidadDeGolesEquipoVisitante++;
				}
				if(gol.getTipo().equals(TipoDeEvento.GOL_EN_CONTRA) && verificarNumeroDelJugadorAutorDelEvento(local, gol) == true) {
					this.goles[i] = gol;
					this.cantidadDeGolesEquipoVisitante++;
				}
				if(gol.getTipo().equals(TipoDeEvento.GOL_EN_CONTRA) && verificarNumeroDelJugadorAutorDelEvento(visitante, gol) == true) {
					this.goles[i] = gol;
					this.cantidadDeGolesEquipoLocal++;
				}
				this.cantidadDeGoles++;
			}
		}
	}
	
	private boolean verificarNumeroDelJugadorAutorDelEvento(EquipoDeFutbol equipo, Evento evento) {
		
		boolean isElNumero = false;
		
		if(this.local.equals(equipo) && this.local.buscar(evento.getAutor().getNumero()) != null) {
			isElNumero = true;
		}
		
		if(this.visitante.equals(equipo) && this.visitante.buscar(evento.getAutor().getNumero()) != null) {
			isElNumero = true;
		}
		
		return isElNumero;	
	}
	
	/*
	 * Registra un nuevo jugador amonestado en el partido. 
	 * Si el jugador tenía una amonestación previa, se debe expulsar. 
	 * Retorna la cantidad de amonestaciones del jugador. 
	 * 1 - Si no tenía alguna amonestación y
	 * 2 - Si ya tenía una amonestación previa y debe ser expulsado
	 */
	public int amonestar(Evento amonestado) {

		int resultado = 0;		
		
		for(int i=0; i < this.amonestados.length; i++) {
			if(this.amonestados[i] == null && this.cantidadDeJugadoresAmonestados < this.cantidadMaximaDeAmonestaciones) {
				if(amonestado.getTipo().equals(TipoDeEvento.AMONESTACION) && verificarNumeroDelJugadorAutorDelEvento(local, amonestado) == true && verificarSiElJugadorEstaAmonestado(amonestado) == false) {
					this.amonestados[i] = amonestado;
					this.cantidadDeJugadoresAmonestadosEquipoLocal++;
					this.cantidadDeJugadoresAmonestados++;
					return resultado = 1;
				}
				if(amonestado.getTipo().equals(TipoDeEvento.AMONESTACION) && verificarNumeroDelJugadorAutorDelEvento(visitante, amonestado) == true && verificarSiElJugadorEstaAmonestado(amonestado) == false) {
					this.amonestados[i] = amonestado;
					this.cantidadDeJugadoresAmonestadosEquipoVisitante++;
					this.cantidadDeJugadoresAmonestados++;
					return resultado = 1;
				}
				if(amonestado.getTipo().equals(TipoDeEvento.AMONESTACION) && verificarNumeroDelJugadorAutorDelEvento(local, amonestado) == true && verificarSiElJugadorEstaAmonestado(amonestado) == true) {
					this.amonestados[i] = amonestado;
					this.cantidadDeJugadoresAmonestadosEquipoLocal++;
					this.cantidadDeJugadoresAmonestados++;
					this.amonestados[i].setTipo(TipoDeEvento.EXPULSION);
					return resultado = 2;
				}
				if(amonestado.getTipo().equals(TipoDeEvento.AMONESTACION) && verificarNumeroDelJugadorAutorDelEvento(visitante, amonestado) == true && verificarSiElJugadorEstaAmonestado(amonestado) == true) {
					this.amonestados[i] = amonestado;
					this.cantidadDeJugadoresAmonestadosEquipoVisitante++;
					this.cantidadDeJugadoresAmonestados++;
					this.amonestados[i].setTipo(TipoDeEvento.EXPULSION);
					return resultado = 2;
				}
			}
		}
		
		return resultado;
	}
	
	private boolean verificarSiElJugadorEstaAmonestado(Evento evento) {
		
		boolean isAmonestado = false;
		
		for(int i=0; i < this.amonestados.length; i++) {
			if(this.amonestados[i] != null && this.amonestados[i].getAutor().equals(evento.getAutor())) {
				isAmonestado = true;
			}
		}
		
		return isAmonestado;
	}
	
	/*
	 * Registra un nuevo jugador expulsado en el partido. 
	 */
	public void expulsar(Evento expulsado) {

		if(this.cantidadDeJugadoresExpulsados < this.cantidadMaximaDeExpulsiones) {
			if(expulsado.getTipo().equals(TipoDeEvento.EXPULSION) && verificarNumeroDelJugadorAutorDelEvento(local, expulsado) == true){
				this.expulsados[this.cantidadDeJugadoresExpulsadosEquipoLocal++] = expulsado;
			}
			if(expulsado.getTipo().equals(TipoDeEvento.EXPULSION) && verificarNumeroDelJugadorAutorDelEvento(visitante, expulsado) == true){
				this.expulsados[this.cantidadDeJugadoresExpulsadosEquipoVisitante++] = expulsado;
			}
			if(verificarSiElJugadorEstaExpulsadoPorDobleAmonestacion(local, expulsado) == true) {
				expulsados[this.cantidadDeJugadoresExpulsadosEquipoLocal++] = expulsado;
			}
			if(verificarSiElJugadorEstaExpulsadoPorDobleAmonestacion(visitante, expulsado) == true) {
				expulsados[this.cantidadDeJugadoresExpulsadosEquipoVisitante++] = expulsado;
			}
			this.cantidadDeJugadoresExpulsados++;
		}
	}
	
	private boolean verificarSiElJugadorEstaExpulsadoPorDobleAmonestacion(EquipoDeFutbol equipo, Evento evento) {
	
		boolean isExpulsado = false;
		
		if(this.local.equals(equipo) && this.local.buscar(evento.getAutor().getNumero()) != null && amonestar(evento) == 2) {
			isExpulsado = true;
		}
		
		if(this.visitante.equals(equipo) && this.visitante.buscar(evento.getAutor().getNumero()) != null && amonestar(evento) == 2) {
			isExpulsado = true;
		}
		
		return isExpulsado;
	}
	/*
	 * Se cuentan la cantidad de goles por equipo (Se debe considerar si el gol resultó a favor o en contra), y devuelve el equipo ganador (Si hubo un empate retorna null) 
	 */
	public EquipoDeFutbol getGanador() {
		
		if(getCantidadGolesEquipoLocal() > getCantidadGolesEquipoVisitante()) {
			return getLocal();
		}
		
		if(getCantidadGolesEquipoLocal() < getCantidadGolesEquipoVisitante()) {
			return getVisitante();
		}
				
		if(getCantidadGolesEquipoLocal() == getCantidadGolesEquipoVisitante()) {
			return null;
		}		

		return null;
	}
	
	/*
	 * Muestra la información del partido:
	 * Equipos que se enfrentan.
	 * Goles realizados.
	 * Jugadores amonestados y/o expulsados.
	 */
	public String toString() {
		String resultado = "Resultado del partido: " + getGanador() + "\n" +
							"Marcador: " + this.local + " " + this.cantidadDeGolesEquipoLocal + " - " + this.cantidadDeGolesEquipoVisitante + " "+ this.visitante + "\n" +
							"Goles: "+ Arrays.toString(goles) + "\n" +
							"Amonestados: "+ Arrays.toString(amonestados) + "\n" +
							"Expulsados: " + Arrays.toString(expulsados);
		return resultado;
	}

	public EquipoDeFutbol getLocal() {
		return this.local;
	}

	public EquipoDeFutbol getVisitante() {
		return this.visitante;
	}
	
	public int getCantidadDeGoles() {
		return this.cantidadDeGoles;
	}
	
	public int getCantidadGolesEquipoLocal() {
		return this.cantidadDeGolesEquipoLocal;
	}
	
	public int getCantidadGolesEquipoVisitante() {
		return this.cantidadDeGolesEquipoVisitante;
	}
	
	public int getCantidadDeJugadoresAmonestados() {
		return this.cantidadDeJugadoresAmonestados;
	}
	
	public int getCantidadDeJugadoresAmonestadosEquipoLocal() {
		return this.cantidadDeJugadoresAmonestadosEquipoLocal;
	}
	
	public int getCantidadDeJugadoresAmonestadosEquipoVisitante() {
		return this.cantidadDeJugadoresAmonestadosEquipoVisitante;
	}
	
	public int getCantidadDeJugadoresExpulsados() {
		return this.cantidadDeJugadoresExpulsados;
	}
	
	public int getCantidadDeJugadoresExpulsadosEquipoLocal() {
		return this.cantidadDeJugadoresExpulsadosEquipoLocal;
	}
	
	public int getCantidadDeJugadoresExpulsadosEquipoVisitante() {
		return this.cantidadDeJugadoresExpulsadosEquipoVisitante;
	}
}