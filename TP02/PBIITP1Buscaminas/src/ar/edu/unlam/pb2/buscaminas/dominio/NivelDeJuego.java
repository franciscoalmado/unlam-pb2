package ar.edu.unlam.pb2.buscaminas.dominio;

public enum NivelDeJuego {

	FACIL(1),
	INTERMEDIO(2),
	EXPERTO(3);
	
	int nivel;
	
	NivelDeJuego(int nivel){
		this.nivel = nivel;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}