package ar.edu.unlam.pb2.tableroKanban.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb2.tableroKanban.dominio.EstadoDeTarea;
import ar.edu.unlam.pb2.tableroKanban.dominio.TableroKanban;
import ar.edu.unlam.pb2.tableroKanban.dominio.Tarea;
import ar.edu.unlam.pb2.tableroKanban.dominio.Usuario;

public class InterfazTableroKanban {

	static Scanner teclado = new Scanner(System.in);
	private static Tarea tarea;
	private static Usuario usuario;
	private static TableroKanban tableroKanban = new TableroKanban(10, 5);
	
	public static void main(String[] args) {
	
		int opcion = 0;
		int salir = 9;
		
		do {
			opcion = seleccionarOpcion();
			
			switch(opcion) {
				case 1:
					registrarUnUsuario();
				break;
				case 2:
					crearUnaNuevaTarea(usuario);
				break;
				case 3:
					comenzarUnaNuevaTarea();
				break;
				case 4:
					finalizarUnaTareaEnEjecucion();
				break;
				case 5:
					mostrarTareasPendientes(tableroKanban.getTareasPendientes());
				break;
				case 6:
					mostrarTareasEnCurso(tableroKanban.getTareasEnCurso());
				break;
				case 7:
					mostrarTareasFinalizadas(tableroKanban.getTareasFinalizadas());
				break;
				case 8:
					mostrarUsuariosRegistrados(tableroKanban.getUsuarios());
				break;
				case 9:
					System.out.println("¡Gracias por usar nuestra herramienta de gestión de tareas!");
				break;
				default:
					System.out.println("Opción inválida. Elija otra nuevamente.");
				break;
			}
		}while(opcion != salir);
	}
	
	private static int seleccionarOpcion() {
		
		int opcion = 0;
		
		System.out.println("\nBienvenidos al Tablero Kanban\n");
		System.out.println("1.- Registrar un usuario.");
		System.out.println("2.- Crear una nueva tarea.");
		System.out.println("3.- Comenzar una tarea.");
		System.out.println("4.- Finalizar una tarea.");
		System.out.println("5.- Ver tareas pendientes.");
		System.out.println("6.- Ver tareas en curso.");
		System.out.println("7.- Ver tareas finalizadas.");
		System.out.println("8.- Ver usuarios registrados.");
		System.out.println("9.- Salir");
	
		opcion = teclado.nextInt();
		
		return opcion;
	}
	
	private static Usuario crearUsuario() {
		String nombreDeUsuario = "";
		String nombre = "";
		String apellido = "";
		
		System.out.println("Ingrese el usuario: ");
		nombreDeUsuario = teclado.next();
		
		System.out.println("Ingrese el nombre: ");
		nombre = teclado.next();
		
		System.out.println("Ingrese el apellido: ");
		apellido = teclado.next();
		
		usuario = new Usuario(nombreDeUsuario, nombre, apellido);
		
		return usuario;
	}
	
	private static void registrarUnUsuario() {
				
		Usuario nuevoUsuario = crearUsuario();
		
		if(tableroKanban.registrarUsuario(nuevoUsuario) == true) {
			System.out.println("Usuario registrado exitosamente.");
		}else {
			System.out.println("No se pudo completar el registro.");
		}
	}
	
	private static void crearUnaNuevaTarea(Usuario nuevoUsuario) {
		
		String nombreTarea = "";
		EstadoDeTarea estado = EstadoDeTarea.PENDIENTE;
		char consulta = '\000';
		
		System.out.println("Ingrese el nombre la tarea: ");
		nombreTarea = teclado.next();
		
		System.out.println("¿Quiere agregar el usuario que crea la tarea?");
		System.out.println("S ó N");
		consulta = teclado.next().charAt(0);
		
		do {
			if(consulta == 's' || consulta == 'S') {
				tarea = new Tarea(nombreTarea, estado, nuevoUsuario);
				if(tableroKanban.crearTarea(tarea, nuevoUsuario) == true) {
					System.out.println("Tarea creada exitosamente.");
				}else {
					System.out.println("No se pudo crear la tarea.");
				}	
			}
			if(consulta == 'n' || consulta == 'N') {
				tarea = new Tarea(nombreTarea, estado);
				if(tableroKanban.crearTarea(tarea, nuevoUsuario) == true) {
					System.out.println("Tarea creada exitosamente.");
				}else {
					System.out.println("No se pudo crear la tarea.");
				}	
			}
		}while(consulta != 's' || consulta != 'S' || consulta != 'n' || consulta != 'N');
	}
	
	private static void comenzarUnaNuevaTarea() {
		
		int idTarea = 0;
		
		System.out.println("Ingrese el id de la tarea a comenzar: ");
		idTarea = teclado.nextInt();
		
		if(tableroKanban.comenzarTarea(idTarea, usuario) == true) {
			System.out.println("Tarea iniciada exitosamente.");
		}else {
			System.out.println("No se pudo iniciar la tarea.");
		}
	}
	
	private static void finalizarUnaTareaEnEjecucion() {
	
		int idTarea = 0;
		
		System.out.println("Ingrese el id de la tarea a finalizar: ");
		idTarea = teclado.nextInt();		
		
		if(tableroKanban.finalizarTarea(idTarea) == true) {
			System.out.println("Tarea finalizada exitosamente.");
		}else {
			System.out.println("No se pudo finalizar la tarea.");
		}	
	}
	
	private static void mostrarTareasPendientes(Tarea[] tareasPendientes) {
		
		for(int i=0; i < tareasPendientes.length; i++) {
			if(tareasPendientes[i] != null) {
				System.out.println(tareasPendientes[i] + " ");
			}
		}
	}
	
	private static void mostrarTareasEnCurso(Tarea[] tareasEnCurso) {
		
		for(int i=0; i < tareasEnCurso.length; i++) {
			if(tareasEnCurso[i] != null) {
				System.out.println(tareasEnCurso[i] + " ");
			}
		}
	}
	
	private static void mostrarTareasFinalizadas(Tarea[] tareasFinalizadas) {
		
		for(int i=0; i < tareasFinalizadas.length; i++) {
			if(tareasFinalizadas[i] != null) {
				System.out.println(tareasFinalizadas[i] + " ");
			}
		}
	}
	
	private static void mostrarUsuariosRegistrados(Usuario[] usuariosRegistrados) {
		
		for(int i=0; i < usuariosRegistrados.length; i++) {
			if(usuariosRegistrados[i] != null) {
				System.out.println(usuariosRegistrados[i] + " ");
			}
		}
	}		
}