package ar.edu.unlam.pb2.reproductorDeMusica.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb2.reproductorDeMusica.dominio.Cancion;
import ar.edu.unlam.pb2.reproductorDeMusica.dominio.Duracion;
import ar.edu.unlam.pb2.reproductorDeMusica.dominio.ListaDeReproduccion;
import ar.edu.unlam.pb2.reproductorDeMusica.dominio.ReproductorDeMusica;
import ar.edu.unlam.pb2.reproductorDeMusica.dominio.Usuario;

public class InterfazReprodutorDeMusica {
	
	static Scanner teclado = new Scanner(System.in);
	private static Usuario usuario;
	private static Cancion nueva;
	private static Duracion duracion;
	private static ListaDeReproduccion playlist;
	private static final int CANTIDAD_DE_CANCIONES_POR_DEFECTO = 5;
	private static final int CANTIDAD_DE_LISTAS_POR_DEFECTO = 5;
	private static ReproductorDeMusica reproductorDeMusica = new ReproductorDeMusica("Spotify", CANTIDAD_DE_LISTAS_POR_DEFECTO);
	
	public static void main(String[] args) {
		int opcion = 0;
		int salir = 9;
		
		do{
			opcion = seleccionarOpcion();
			
			switch(opcion) {
				case 1:
					usuario = guardarDatosDeUsuario();
					if(usuario != null) {
						System.out.println("Los datos se guardaron exitosamente");
					}else {
						System.out.println("Los datos no se guardaron. Por favor, inténtelo de nuevo.");
					}
					break;
				case 2:
					crearUnaListaDeReproduccion();
					mostrarListadoDePlaylist(reproductorDeMusica.getPlaylist());
					break;
				case 3:
					agregarCancionesAUnaListaDeReproduccion(reproductorDeMusica);
					break;
				case 4:
					reproducirUnaListaDeReproduccion(reproductorDeMusica);
					break;
				case 5:
					System.out.println("Listado de canciones: ");
					mostrarListadoCanciones(playlist.getCanciones());
					System.out.println(playlist.obtenerCantidadDeCancionesAgregadas()+" canciones");
					System.out.println("Duración: "+playlist.obtenerDuracionTotalDeLaLista());
					break;
				case 9:
					System.out.println("¡Gracias por preferirnos!");
					break;
				default:
					System.out.println("Opción inválida.");
					break;
			}
			
		}while(opcion != salir);
	}
	
	private static int seleccionarOpcion() {
		
		int opcionSeleccionada = 0;
		
		System.out.println("\tn"+"Bienvenido a "+reproductorDeMusica.getNombreDelReproductor()+"\tn");
		System.out.println("1 - Guardar datos personales");
		System.out.println("2 - Crear una lista de repoducción");
		System.out.println("3 - Agregar canciones a la lista");
		System.out.println("4 - Reproducir una lista de reproducción");
		System.out.println("5 - Información de la lista de reproducción");
		System.out.println("9 - Para salir");
		
		opcionSeleccionada = teclado.nextInt();
		
		return opcionSeleccionada;
	}
	
	private static Usuario guardarDatosDeUsuario() {
		String nombre = "";
		String apellido = "";
		
		System.out.println("Ingrese su nombre: ");
		nombre = teclado.next();
		
		System.out.println("Ingrese su apellido: ");
		apellido = teclado.next();
		
		usuario = new Usuario(nombre, apellido);
		
		return usuario;
	}
	
	private static boolean crearUnaListaDeReproduccion() {
		String nombreDeLaLista = "";
		boolean seCreoEnElReproductor = false;
		
		System.out.println("Ingrese un nombre para la Playlist: ");
		nombreDeLaLista = teclado.next();
		
		playlist = new ListaDeReproduccion(nombreDeLaLista, CANTIDAD_DE_CANCIONES_POR_DEFECTO);
		
		seCreoEnElReproductor = reproductorDeMusica.agregarUnaListaAlReproductor(playlist);
		
		if(seCreoEnElReproductor == true) {
			System.out.println("Lista creada exitosamente.");
		}else {
			System.out.println("Lista no creada. Por favor, inténtelo de nuevo.");
		}
		
		return seCreoEnElReproductor;
	}
	
	private static void agregarCancionesAUnaListaDeReproduccion(ReproductorDeMusica reproductor) {
		String nombreDeLaLista = "";
	
		do {
			System.out.println("Ingrese el nombre la lista: ");
			nombreDeLaLista = teclado.next();		
			playlist = reproductor.obtenerUnaListaDeReproduccionPorSuNombre(nombreDeLaLista);
		}while(playlist == null);
				
		nueva = crearUnaCancion();
		
		if(playlist.agregarCancionesALaLista(nueva)) {
			System.out.println("Ingreso satisfactorio");
		}else {
			System.out.println("No se pudo agregar");
		}
	}
	
	private static Cancion crearUnaCancion() {
		String titulo = "";
		String autor = "";
		String album = "";
		int minutos = 0;
		int segundos = 0;
		boolean validarDuracion = false;

		System.out.println("Ingrese el título de la canción: ");
		titulo = teclado.next();
		
		System.out.println("Ingrese el autor de la canción: ");
		autor = teclado.next();
		
		System.out.println("Ingrese el álbum al cual pertenece la canción: ");
		album = teclado.next();
		
		do {
			System.out.println("Ingrese los minutos de la canción: ");
			minutos = teclado.nextInt();
			
			System.out.println("Ingreso los segundos de la canción: ");
			segundos = teclado.nextInt();
			
			duracion = new Duracion(minutos, segundos);
			
			validarDuracion = duracion.validarMinutosYSegundos(minutos, segundos);
			
		}while(validarDuracion == false);

		nueva = new Cancion(titulo, autor, album, minutos, segundos);
		
		return nueva;
	}
	
	private static void reproducirUnaListaDeReproduccion(ReproductorDeMusica reproductor) {
		
		String nombreDeLaLista = "";
		
		do {
			System.out.println("Ingrese el nombre la lista: ");
			nombreDeLaLista = teclado.next();		
			playlist = reproductor.obtenerUnaListaDeReproduccionPorSuNombre(nombreDeLaLista);
		}while(playlist == null);
		
		mostrarListadoCanciones(playlist.getCanciones());
	}
	
	private static void mostrarListadoCanciones(Cancion[] canciones) {
		
		for(int i=0; i < canciones.length; i++) {
			if(canciones[i] != null) {
				System.out.println(canciones[i].toString() + " ");
			}
		}
	}
	
	private static void mostrarListadoDePlaylist(ListaDeReproduccion[] lista) {
		
		for(int i=0; i < lista.length; i++) {
			if(lista[i] != null) {
				System.out.println(lista[i].toString() + " ");
			}
		}
	}
}