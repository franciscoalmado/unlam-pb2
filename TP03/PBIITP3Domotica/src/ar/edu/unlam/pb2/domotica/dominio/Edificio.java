package ar.edu.unlam.pb2.domotica.dominio;

public class Edificio {

	private String nombre;
	private final int PISO_MINIMO;
	private final int PISO_MAXIMO;
	private Ascensor[][] ascensores;
	private int cantidadDeAscensores;
	
	public Edificio(String nombre, int pisoMinimo, int pisoMaximo, int cantidadDeAscensores) {
		this.nombre = nombre;
		this.PISO_MINIMO = pisoMinimo;
		this.PISO_MAXIMO = pisoMaximo;
		this.cantidadDeAscensores = cantidadDeAscensores;
		this.ascensores = new Ascensor[this.PISO_MAXIMO - this.PISO_MINIMO][this.cantidadDeAscensores];
	}
	
	public void usarAscensorParaSubir(Persona usuarioQueSube, int piso, int numeroDeAscensor) throws Exception {
		
		for(int i=0; i < this.ascensores.length; i++) {
			for(int j=0; i < this.ascensores[i].length; i++) {
				if(this.ascensores[i][j] != null && piso <= this.PISO_MAXIMO && piso >= this.PISO_MINIMO) {
					this.ascensores[piso][numeroDeAscensor].ingresar(usuarioQueSube);
					this.ascensores[piso][numeroDeAscensor].irAlPiso(piso);
					this.ascensores[piso][numeroDeAscensor].setIsPisoActual(true);
				}	
			}
		}
	}
	
	public void usarAscensorParaBajar(Persona usuarioQueBaja, int piso, int numeroDeAscensor) throws Exception {
		
		for(int i=0; i < this.ascensores.length; i++) {
			for(int j=0; i < this.ascensores[i].length; i++) {
				if(this.ascensores[i][j] != null && piso <= this.PISO_MAXIMO && piso >= this.PISO_MINIMO) {
					this.ascensores[piso][numeroDeAscensor].salir(usuarioQueBaja);
					this.ascensores[piso][numeroDeAscensor].irAlPiso(piso);
					this.ascensores[piso][numeroDeAscensor].setIsPisoActual(true);
				}	
			}
		}
	}
		
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadDeAscensores() {
		return this.cantidadDeAscensores;
	}

	public void setCantidadDeAscensores(int cantidadDeAscensores) {
		this.cantidadDeAscensores = cantidadDeAscensores;
	}
	
	public Ascensor[][] getAscensores() {
		return this.ascensores;
	}
	
	public int getPISO_MAXIMO() {
		return this.PISO_MAXIMO;
	}
	
	public int getPISO_MINIMO() {
		return this.PISO_MINIMO;
	}
}