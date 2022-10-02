package ar.edu.unlam.pb2.reproductorDeMusica.dominio;

public class ListaDeReproduccion {

	private String nombreDeLaLista;
	private final int CANTIDAD_MAXIMA_DE_CANCIONES;
	private Cancion[] canciones;
	private int cantidadDeCancionesAgregadas;
	private Duracion duracion;
	
	public ListaDeReproduccion(String nombreDeLaLista, int cantidadDeCancionesPorDefecto) {
		this.nombreDeLaLista = nombreDeLaLista;
		this.CANTIDAD_MAXIMA_DE_CANCIONES = cantidadDeCancionesPorDefecto;
		this.canciones = new Cancion[this.CANTIDAD_MAXIMA_DE_CANCIONES];
		this.cantidadDeCancionesAgregadas = 0;
		this.duracion = null;
	}
	
	public boolean agregarCancionesALaLista(Cancion nueva) {
		boolean seAgrego = false;
		
		if(verificarQueNoExistaUnaCancionEnLaLista(nueva) == null && obtenerCantidadDeCancionesAgregadas() < this.CANTIDAD_MAXIMA_DE_CANCIONES) {
			this.canciones[this.cantidadDeCancionesAgregadas++] = nueva;
			seAgrego = true;
		}
		
		return seAgrego;
	}
	
	private Cancion verificarQueNoExistaUnaCancionEnLaLista(Cancion nueva) {
		
		for(int i=0; i < this.canciones.length; i++) {
			if(this.canciones[i] != null && this.canciones[i].getTitulo().compareToIgnoreCase(nueva.getTitulo()) == 0 && this.canciones[i].getAutor().compareToIgnoreCase(nueva.getAutor()) == 0) {
				return this.canciones[i];
			}
		}
		
		return null;
	}
	
	public String obtenerDuracionTotalDeLaLista() {
		int totalMinutos = 0;
		int totalSegundos = 0;
		String resultado = "";
		
		for(int i=0; i < this.canciones.length; i++) {
			if(this.canciones[i] != null) {
				totalMinutos += this.canciones[i].getMinutos();
				totalSegundos += this.canciones[i].getSegundos();
			}
		}
			
		duracion = new Duracion(totalMinutos, totalSegundos);
		
		resultado = duracion.calcularMinutosYSegundos(totalMinutos, totalSegundos);
		
		return resultado;
	}
	
	public int obtenerCantidadDeCancionesAgregadas() {
		return this.cantidadDeCancionesAgregadas;
	}
	
	public Cancion[] getCanciones() {
		return this.canciones;
	}
	
	public String getNombreDeLaLista() {
		return this.nombreDeLaLista;
	}

	@Override
	public String toString() {
		return "Playlist [ " + this.nombreDeLaLista + " " + this.cantidadDeCancionesAgregadas + " canciones" + "]";
	}	
}