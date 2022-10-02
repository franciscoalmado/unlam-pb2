package ar.edu.unlam.pb2.tableroKanban.dominio;

public class Tarea {

	static int contador = 0;
	private int id;
	private String tarea;
	private EstadoDeTarea estado;
	private Usuario usuario;
	
	public Tarea(String tarea, EstadoDeTarea estado) {
		Tarea.contador++;
		this.id = contador;
		this.tarea = tarea;
		this.estado = estado;
	}
	
	public Tarea(String tarea, EstadoDeTarea estado, Usuario usuario) {
		Tarea.contador++;
		this.id = contador;
		this.tarea = tarea;
		this.estado = estado;
		this.usuario = usuario;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getTarea() {
		return this.tarea;
	}
	
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	
	public EstadoDeTarea getEstado() {
		return this.estado;
	}
	
	public void setEstado(EstadoDeTarea estado) {
		this.estado = estado;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Tarea [Id: " + this.id + ", Nombre: " + this.tarea + ", Estado: " + this.estado + ", Usuario: " + this.getUsuario() + "]";
	}	
}