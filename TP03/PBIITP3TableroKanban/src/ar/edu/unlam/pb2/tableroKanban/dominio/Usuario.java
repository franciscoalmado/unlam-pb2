package ar.edu.unlam.pb2.tableroKanban.dominio;

public class Usuario {

	private String usuario;
	private String nombre;
	private String apellido;
	
	public Usuario(String usuario, String nombre, String apellido) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getUsuario() {
		return this.usuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Override
	public String toString() {
		return "[" + this.usuario + "]";
	}	
}