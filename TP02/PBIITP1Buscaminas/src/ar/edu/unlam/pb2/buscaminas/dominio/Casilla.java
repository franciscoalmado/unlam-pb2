package ar.edu.unlam.pb2.buscaminas.dominio;

public class Casilla {
	private int posicionFila;
    private int posicionColumna;
    private boolean isMina;
    private int cantidadDeMinasAlrededor;
    private boolean isAbierta;

    public Casilla(int posicionFila, int posicionColumna) {
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
    }

    public int getPosFila() {
        return this.posicionFila;
    }

    public void setPosFila(int posicionFila) {
        this.posicionFila = posicionFila;
    }

    public int getPosColumna() {
        return this.posicionColumna;
    }

    public void setPosColumna(int posicionColumna) {
        this.posicionColumna = posicionColumna;
    }

    public boolean isMina() {
        return this.isMina;
    }

    public void setMina(boolean isMina) {
        this.isMina = isMina;
    }

    public int getNumMinasAlrededor() {
        return this.cantidadDeMinasAlrededor;
    }

    public void setNumMinasAlrededor(int numMinasAlrededor) {
        this.cantidadDeMinasAlrededor = numMinasAlrededor;
    }
    
    public void incrementarNumeroMinasAlrededor(){
        this.cantidadDeMinasAlrededor++;
    }

    public boolean isAbierta() {
        return this.isAbierta;
    }

    public void setAbierta(boolean abierta) {
        this.isAbierta = abierta;
    }
}