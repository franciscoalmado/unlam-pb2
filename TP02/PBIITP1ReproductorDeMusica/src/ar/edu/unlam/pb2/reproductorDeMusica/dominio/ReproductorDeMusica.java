package ar.edu.unlam.pb2.reproductorDeMusica.dominio;

public class ReproductorDeMusica {

	private String nombreDelReproductor;
	private ListaDeReproduccion[] playlist;
	private final int CANTIDAD_DE_PLAYLIST_POR_DEFECTO;
	private int cantidadDePlaylistAgregadas;

	public ReproductorDeMusica(String nombreDelReproductor, int cantidadDePlaylistPorDefecto) {
		this.nombreDelReproductor = nombreDelReproductor;
		this.CANTIDAD_DE_PLAYLIST_POR_DEFECTO = cantidadDePlaylistPorDefecto;
		this.playlist = new ListaDeReproduccion[CANTIDAD_DE_PLAYLIST_POR_DEFECTO];
		this.cantidadDePlaylistAgregadas = 0;
	}
	
	public boolean agregarUnaListaAlReproductor(ListaDeReproduccion lista) {
		boolean seAgregoLaLista = false;
		
		if(verificarQueNoExistaUnaListaEnElReproductor(lista) == null && getCantidadDePlaylistAgregadas() < CANTIDAD_DE_PLAYLIST_POR_DEFECTO) {
			this.playlist[this.cantidadDePlaylistAgregadas++] = lista;
			seAgregoLaLista = true;
		}
		
		return seAgregoLaLista;
	}
	
	private ListaDeReproduccion verificarQueNoExistaUnaListaEnElReproductor(ListaDeReproduccion lista) {
	
		for(int i=0; i < this.playlist.length; i++) {
			if(this.playlist[i] != null && this.playlist[i].getNombreDeLaLista().compareTo(lista.getNombreDeLaLista()) == 0) {
				return this.playlist[i];
			}
		}
		
		return null;
	}
	
	public ListaDeReproduccion obtenerUnaListaDeReproduccionPorSuNombre(String nombre) {
		
		for(int i=0; i < this.playlist.length; i++) {
			if(this.playlist[i] != null && this.playlist[i].getNombreDeLaLista().compareTo(nombre) == 0) {
				return this.playlist[i];
			}
		}
		
		return null;
	}
	
	public String getNombreDelReproductor() {
		return this.nombreDelReproductor;
	}
	
	public ListaDeReproduccion[] getPlaylist() {
		return this.playlist;
	}
	
	public int getCantidadDePlaylistAgregadas() {
		return this.cantidadDePlaylistAgregadas;
	}
}