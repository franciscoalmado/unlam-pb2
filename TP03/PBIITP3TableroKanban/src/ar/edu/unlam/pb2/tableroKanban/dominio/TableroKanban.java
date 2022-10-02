package ar.edu.unlam.pb2.tableroKanban.dominio;

public class TableroKanban {

	private Tarea[] tareasPendientes;
	private Tarea[] tareasEnCurso;
	private Tarea[] tareasFinalizadas;
	private int cantidadDeTareas;
	private int cantidadDeTareasPendientes;
	private int cantidadDeTareasEnCurso;
	private int cantidadDeTareasFinalizadas;
	private Tarea tareaNula;
	private Usuario[] usuarios;
	private int cantidadDeUsuarios;
	private int cantidadDeUsuariosRegistrados;
	
	public TableroKanban(int cantidadDeTareas, int cantidadDeUsuarios) {
		this.cantidadDeTareas = cantidadDeTareas;
		this.tareasPendientes = new Tarea[this.cantidadDeTareas];
		this.tareasEnCurso = new Tarea[this.tareasPendientes.length];
		this.tareasFinalizadas = new Tarea[this.tareasEnCurso.length];
		this.cantidadDeTareasPendientes = 0;
		this.cantidadDeTareasPendientes = 0;
		this.cantidadDeTareasFinalizadas = 0;
		this.tareaNula = null;
		this.cantidadDeUsuarios = cantidadDeUsuarios;
		this.usuarios = new Usuario[this.cantidadDeUsuarios];
		this.cantidadDeUsuariosRegistrados = 0;
	}
		
	public boolean registrarUsuario(Usuario usuario) {
		boolean seRegistro = false;
		
		for(int i=0; i < this.usuarios.length; i++) {
			if(this.usuarios[i] == null && this.cantidadDeUsuariosRegistrados < this.cantidadDeUsuarios && verificarSiUnUsuarioEstaRegistrado(usuario) == null) {
				this.usuarios[this.cantidadDeUsuariosRegistrados++] = usuario;
				seRegistro = true;
			}	
		}
		
		return seRegistro;
	}
	
	private Usuario verificarSiUnUsuarioEstaRegistrado(Usuario usuario) {
		
		for(int i=0; i < this.usuarios.length; i++) {
			if(this.usuarios[i] != null && this.cantidadDeUsuariosRegistrados < this.cantidadDeUsuarios && this.usuarios[i].getUsuario().compareTo(usuario.getUsuario()) == 0) {
				return this.usuarios[i];
			}
		}
		
		return null;
	}
	
	public boolean crearTarea(Tarea tarea, Usuario usuario) {
		
		for(int i=0; i < this.tareasPendientes.length; i++) {
			if(this.tareasPendientes[i] == null && this.cantidadDeTareasPendientes < this.cantidadDeTareas && verificarSiUnUsuarioEstaRegistrado(usuario) != null) {
				this.tareasPendientes[i] = tarea;
				this.cantidadDeTareasPendientes++;
				this.tareasPendientes[i].setUsuario(usuario);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean comenzarTarea(int idTarea, Usuario usuario) {
		
		for(int i=0; i < this.tareasPendientes.length; i++) {
			if(this.tareasPendientes[i] != null && this.tareasPendientes[i].getId() == idTarea && verificarSiUnUsuarioEstaRegistrado(usuario) != null) {
				this.tareasPendientes[i].setEstado(EstadoDeTarea.EN_CURSO);
				this.tareasEnCurso[this.cantidadDeTareasEnCurso++] = this.tareasPendientes[i];
				this.tareasEnCurso[i].setUsuario(usuario);
				eliminarTarea(this.tareasPendientes, this.cantidadDeTareasPendientes--);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean finalizarTarea(int idTarea) {
		
		for(int i=0; i < this.tareasEnCurso.length; i++) {
			if(this.tareasEnCurso[i] != null && this.tareasEnCurso[i].getId() == idTarea) {
				this.tareasEnCurso[i].setEstado(EstadoDeTarea.FINALIZADA);
				this.tareasFinalizadas[this.cantidadDeTareasFinalizadas++] = this.tareasEnCurso[i];
				eliminarTarea(this.tareasEnCurso, this.cantidadDeTareasEnCurso--);
				return true;
			}
		}
		
		return false;
	}
	
	private void eliminarTarea(Tarea[] tarea, int cantidadDeTareas) {
		
		for(int i=0; i < cantidadDeTareas - 1; i++) {
			tarea[i] = tarea[i+1];
		}		
		tarea[cantidadDeTareas -1] = this.tareaNula;
	}
	
	public Tarea[] getTareasPendientes() {
		return this.tareasPendientes;
	}
	
	public Tarea[] getTareasEnCurso() {
		return this.tareasEnCurso;
	}
	
	public Tarea[] getTareasFinalizadas() {
		return this.tareasFinalizadas;
	}
	
	public Usuario[] getUsuarios() {
		return this.usuarios;
	}
}