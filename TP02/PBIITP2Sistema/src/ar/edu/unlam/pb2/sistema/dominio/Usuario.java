package ar.edu.unlam.pb2.sistema.dominio;

public class Usuario {

	private String usuario;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private int dni;
	private int edad;
	private int cantidadDeIntentosFallidosParaLoguearse;
	
	public Usuario(String usuario, String contrasenia, String nombre, String apellido, int dni, int edad) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.cantidadDeIntentosFallidosParaLoguearse = 3;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public String getContrasenia() {
		return this.contrasenia;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public void disminuirIntentosDeLoguearse() {
		this.cantidadDeIntentosFallidosParaLoguearse--;
	}
	
	public int getCantidadDeIntentosFallidos() {
		return this.cantidadDeIntentosFallidosParaLoguearse;
	}

	/*
	 * Verifica que una contraseña sea válida si cumple con lo siguiente: 
		1. Contiene al menos un carácter numérico. 
		2. Tiene una longitud de al menos 8 caracteres. 
	 */
	public boolean laContraseniaEsValida() {

		boolean isValida = false;
		int cantidadDeCaracteres = this.contrasenia.length();
		int longitudMinima = 8;
		int valor = 0;
		
		for(int i = 0; i < this.contrasenia.length(); i++) {
			valor = this.contrasenia.charAt(i);
			if((valor > 47 && valor < 58) && cantidadDeCaracteres >= longitudMinima){
				isValida = true;
			}
		}
		
		return isValida;
	}

	/*
	 * Determina si un usuario es mayor de edad.  
	 */
	public boolean isMayorDeEdad() {

		boolean isMayor = false;
		
		if(this.edad >= 18) {
			isMayor = true;
		}
		
		return isMayor;		
	}

	@Override
	public String toString() {
		return "Usuario " /*[Usuario: " */ + this.usuario; /*", Contraseña: " + this.contrasenia + ", Nombre: " + this.nombre + ", Apellido="
				+ this.apellido + ", Dni: " + this.dni + ", Edad: " + this.edad +*/ /*", intentos fallidos: " + this.cantidadDeIntentosFallidosParaLoguearse + "]";*/
	}
}