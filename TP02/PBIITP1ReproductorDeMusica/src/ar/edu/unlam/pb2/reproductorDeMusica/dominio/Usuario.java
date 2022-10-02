package ar.edu.unlam.pb2.reproductorDeMusica.dominio;

public class Usuario {
	
	private int numeroDeUsuario;
	private String nombre;
	private String apellido;
	static int contador = 0;
		
	public Usuario(String nombre, String apellido) {
		contador++;
		this.numeroDeUsuario = contador; 
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public int getNumeroDeUsuario() {
		return this.numeroDeUsuario;
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
		return "Usuario [" + this.numeroDeUsuario + " " + this.nombre + " " + this.apellido + "]";
	}	
}