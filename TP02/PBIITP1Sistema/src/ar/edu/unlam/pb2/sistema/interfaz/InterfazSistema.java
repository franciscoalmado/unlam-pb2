package ar.edu.unlam.pb2.sistema.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb2.sistema.dominio.Sistema;
import ar.edu.unlam.pb2.sistema.dominio.Usuario;

public class InterfazSistema {
	
	static Scanner teclado = new Scanner(System.in);
	private static Usuario usuario;
	private static Sistema sistema = new Sistema("BTC", 100);
	
	public static void main(String[] args) {		
		
		int opcion = 0;
		int salir = 9;
		
		do {
			opcion = seleccionarOpcion();
			switch(opcion) {
				case 1:
					registrarUnUsuarioEnELSistema();
				break;
				case 2:
					verLasEstadisticasDelSistema(sistema);
				break;
				case 3:
					probarElLogin();
				break;
				case 9:
					System.out.println("Usted ha salido del sistema.");	
				break;
				default:
					System.out.println("Opcion inválida. Por favor seleccione una opción correcta.");
				break;
			}
			
		}while(opcion != salir);
	}
	
	private static int seleccionarOpcion() {
		
		int opcionSeleccionada = 0;
		System.out.println("\nBienvenido al Sistema BTC\n");
		System.out.println("Seleccione una opción:");
		System.out.println("1 - Registrar nuevos usuarios en el Sistema.");
		System.out.println("2 - Ver las estadísticas del sistema");
		System.out.println("3 - Probar el login.");
		System.out.println("9 - Para salir.");
	
		opcionSeleccionada = teclado.nextInt();
		
		return opcionSeleccionada;
	}
	
	private static void registrarUnUsuarioEnELSistema() {
		
		String nombreDeUsuario = "";
		String contrasenia = "";
		String nombre = "";
		String apellido = "";
		int dni = 0;
		int edad = 0;
		
		System.out.println("Ingrese un nombre de usuario: ");
		nombreDeUsuario = teclado.next();
		
		System.out.println("Ingrese una contraseña: ");
		contrasenia = teclado.next();
		
		System.out.println("Ingrese su nombre: ");
		nombre = teclado.next();
		
		System.out.println("Ingrese su apellido: ");
		apellido = teclado.next();
		
		System.out.println("Ingrese su DNI: ");
		dni = teclado.nextInt();

		System.out.println("Ingrese su edad: ");
		edad = teclado.nextInt();
		
		usuario = new Usuario(nombreDeUsuario, contrasenia, nombre, apellido, dni, edad);

		if(sistema.ingresarUsuario(usuario) == true) {
			System.out.println("El ingreso ha sido exitoso");
		}else {
			System.out.println("No se pudo dar ingreso. Este usuario ya existe en el sistema.");
			System.out.println("Inténtelo de nuevo.");
		}
	}
	
	private static void verLasEstadisticasDelSistema(Sistema sistema) {
		
		System.out.println("Cantidad de usuarios logueados: " + sistema.getCantidadDeUsuariosLogueados());
		System.out.println("Cantidad de usuarios bloqueados: " + sistema.getCantidadDeUsuariosBloqueados());
		System.out.println("Porcentaje de usuarios logueados: " + sistema.calcularElPorcentajeDeUsuariosLogueados() + "%");
		System.out.println("Promedio de edad de usuarios registrados: " + sistema.calcularEdadPromedio() + " años");
	}
	
	private static void probarElLogin() {
		String nombreDeUsuario = "";
		String contrasenia = "";
		
		System.out.println("Ingrese usuario: ");
		nombreDeUsuario = teclado.next();
		
		System.out.println("Ingrese contraseña: ");
		contrasenia = teclado.next();
		
		if(sistema.loguearUsuario(nombreDeUsuario, contrasenia) == true) {
			System.out.println("Se inició sesión.");
		}else {
			System.out.println("No se pudo iniciar sesión. Inténtelo de nuevo.");
		}
	}
}