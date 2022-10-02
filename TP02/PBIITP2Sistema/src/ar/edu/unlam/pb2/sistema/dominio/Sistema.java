package ar.edu.unlam.pb2.sistema.dominio;

public class Sistema {

	private String nombreDelSistema;
	private Usuario[] usuarios;
	private int cantidadDeUsuarios;
	private int cantidadMaximaDeUsuarios;
	private int cantidadDeLogueados;
	private int cantidadDeUsuariosBloqueados;
	
	public Sistema(String nombreDelSistema, int cantidadMaximaDeUsuarios) {
		this.nombreDelSistema = nombreDelSistema;
		this.cantidadMaximaDeUsuarios = cantidadMaximaDeUsuarios;
		this.usuarios = new Usuario[this.cantidadMaximaDeUsuarios];
		this.cantidadDeUsuarios = 0;
		this.cantidadDeLogueados = 0;
		this.cantidadDeUsuariosBloqueados = 0;
	}
	
	/*
	 * Agrega un usuario al sistema.  
	 */
	public boolean ingresarUsuario(Usuario nuevoUsuario) {

		boolean seAgrego = false;
		
		if(this.cantidadDeUsuarios < this.cantidadMaximaDeUsuarios && verificarSiUnUsuarioYaExisteEnElSistema(nuevoUsuario) == false){
			this.usuarios[this.cantidadDeUsuarios++] = nuevoUsuario;
			seAgrego = true;
		}
	
		return seAgrego;
	}
	
	private boolean verificarSiUnUsuarioYaExisteEnElSistema(Usuario nuevoUsuario) {
		boolean estaEnElSistema = false;

		for (int i = 0; i < this.usuarios.length; i++) {
			if (this.usuarios[i] != null && (this.usuarios[i].getUsuario().compareTo(nuevoUsuario.getUsuario()) == 0
					|| this.usuarios[i].getDni() == nuevoUsuario.getDni())) {
				estaEnElSistema = true;
			}
		}
		return estaEnElSistema;
	}
	
	/*
	 * Loguea un usuario, teniendo encuenta su usuario y contraseña
	 * Si el usuario ha podido loguearse, se suma a la cantidad de usuarios logueados.
	 * Si no se pudo loguear, se disminuye su cantidad de intentos para loguearse y
	 * se verifica si dicho usuario ha superado la cantidad de intentos para hacerlo.
	 * Si no logra loguearse, superados los 3 intentos, su usuario se bloqueará y 
	 * se añadirá a la cantidad de usuarios bloqueados.
	 */	
	public boolean loguearUsuario (String usuario, String contrasenia) {
	
		boolean sePudoLoguear = false;
	
		for(int i=0; i < this.usuarios.length; i++) {
			if(this.usuarios[i] != null && this.usuarios[i].getUsuario().compareTo(usuario) == 0 && this.usuarios[i].getContrasenia().compareTo(contrasenia) == 0) {
				agregarUsuarioALaCantidadDeUsuariosLogueados(this.usuarios[i]);
				sePudoLoguear = true;
			}
			if(this.usuarios[i] != null && this.usuarios[i].getUsuario().compareTo(usuario) != 0 && this.usuarios[i].getContrasenia().compareTo(contrasenia) != 0) {
				this.usuarios[i].disminuirIntentosDeLoguearse();
				verificarSiUnUsuarioHaSidoBloqueado(this.usuarios[i]);
				sePudoLoguear = false;
			}
		}
	
		return sePudoLoguear;
	}
	
	public void agregarUsuarioALaCantidadDeUsuariosLogueados(Usuario usuario) {
		int intentosFallidos = 0;
		
		for(int i=0; i < this.usuarios.length; i++) {
			if(this.usuarios[i] != null && this.usuarios[i].equals(usuario) && this.usuarios[i].getCantidadDeIntentosFallidos() != intentosFallidos) {
				this.cantidadDeLogueados++;
			}
		}
	}
	
	public boolean verificarSiUnUsuarioHaSidoBloqueado(Usuario usuario) {
		int intentosFallidos = 0;
		boolean fueBloqueado = false;
		
		for(int i=0; i < this.usuarios.length; i++) {
			if(this.usuarios[i] != null && this.usuarios[i].equals(usuario) && this.usuarios[i].getCantidadDeIntentosFallidos() == intentosFallidos) {
				fueBloqueado = true;
				this.cantidadDeUsuariosBloqueados++;
			}
		}
		
		return fueBloqueado;
	}
	
	/*
	 * Calcula el procentaje de usuarios logueados en el sistema.
	 */
	public double calcularElPorcentajeDeUsuariosLogueados() {
		
		double porcentaje = 0.0;
		
		porcentaje = (double) (this.cantidadDeLogueados / this.cantidadDeUsuarios) * 100;
				
		return porcentaje;
	}
	
	/*
	 * Calcula la edad promedio de usuarios registrados en el sistema.
	 */
	public double calcularEdadPromedio() {

		double sumatoriaDeEdades = 0.0;
		double promedioDeEdad = 0.0;
		
		for(int i=0; i < this.usuarios.length; i++){
			if(this.usuarios[i] != null) {
				sumatoriaDeEdades += this.usuarios[i].getEdad();
			}	
		}
		
		promedioDeEdad = (double) sumatoriaDeEdades / this.cantidadDeUsuarios;

		return promedioDeEdad;
	}
	
	public Usuario[] getUsuarios() {
		return this.usuarios;
	}
	
	public int getCantidadDeUsuariosLogueados() {
		return this.cantidadDeLogueados;
	}
	
	public int getCantidadDeUsuariosBloqueados() {
		return this.cantidadDeUsuariosBloqueados;
	}
	
	public int getCantidadDeUsuarios() {
		return this.cantidadDeUsuarios;
	}

	@Override
	public String toString() {
		return "Nombre del Sistema=" + this.nombreDelSistema;
	}	
}