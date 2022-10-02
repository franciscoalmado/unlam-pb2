package ar.edu.unlam.pb2.vuelo.interfaz;

import java.util.Arrays;
import java.util.Scanner;

import ar.edu.unlam.pb2.vuelo.dominio.Pasajero;
import ar.edu.unlam.pb2.vuelo.dominio.Vuelo;

public class Checkin {
	
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Bienvenido ");
		int CantidadPasajero = 192;
		Vuelo vuelo = new Vuelo("Buenos Aires", "Bariloche", CantidadPasajero);
	
		int opcion = 0;
		
		do {
			opcion = seleccionarOpcion();
			switch (opcion) {
				case 1:
					registrarPasajero(vuelo);
					break;
				case 2:
					elegirAsiento(vuelo);
					mostrarMapaDeAsientos(vuelo);
					break;
				case 3:
					listarPasajeros(vuelo);
					break;
				case 9:
					System.out.println("Muchas gracias por preferirnos. ¡Hasta la próxima!");
					break;
				default:
					System.out.println("Opción Inválida");
					break;
				}
		} while (opcion != 9);
	}

	private static int seleccionarOpcion() {
		
		int opcionSeleccionada=0;
		
		System.out.println("************************");
		System.out.println("Menú de opciones\n");
		System.out.println("1 - Registrar pasajero");
		System.out.println("2 - Elegir Asiento");
		System.out.println("3 - Listar pasajeros");
		System.out.println("9 - Salir");
		System.out.println("************************");
		System.out.println("Ingrese una opción");
		opcionSeleccionada = teclado.nextInt();
		
		return opcionSeleccionada;
	}

	public static void registrarPasajero(Vuelo actual) {
		/*
		* Interfaz de usuario encargada de cargar un pasajero al vuelo. Debe
		ingresar los datos necesarios e informar por pantalla el resultado de la operación
		*/
		int dni = 0;
		String nombre = "";
		String apellido = "";
		boolean registrarPasajero = false;
		
		System.out.println("Ingrese el DNI:");
		dni = teclado.nextInt();
		
		System.out.println("Ingrese el nombre:");
		nombre = teclado.next();
		
		System.out.println("Ingrese el apellido:");
		apellido = teclado.next();
		
		Pasajero pasajero = new Pasajero(dni, nombre, apellido);
		
		registrarPasajero = actual.agregarPasajero(pasajero);
		
		if(registrarPasajero == true) {
			System.out.println("Pasajero registrado exitosamente.");
		}else {
			System.out.println("No se pudo registrar al pasajero. Inténtelo de nuevo.");
		}
	}
	
	private static void elegirAsiento(Vuelo actual) {
		/*
		* Interfaz de usuario encargada de gestionar la asignación de asientos en
		el vuelo. Debe permitir el ingreso de los datos y mostrar por pantalla el
		resultado de la operación
		*/
		int dni, fila, columna;
		Pasajero pasajeroASentar;

		System.out.println("Ingrese el DNI: ");
		dni = teclado.nextInt();
		
		pasajeroASentar = actual.buscarPasajero(dni);
		
		if(pasajeroASentar != null){
			System.out.println("Ingrese fila: ");
			fila = teclado.nextInt();
			
			System.out.println("Ingrese columna: ");
			columna = teclado.nextInt();
			
			if(actual.asignarAsiento(pasajeroASentar, fila, columna)){
				System.out.println("Asiento asignado exitosamente.");
			}else{
				System.out.println("No se pudo asignar un asiento. Inténtelo de nuevo.");
			}
		}else{
			System.out.println("El pasajero no existe. Registre uno nuevo.");
		}
	}
	
	private static void listarPasajeros(Vuelo actual) {
		/*
		* Se debe mostrar la lista de pasajeros registrados para éste vuelo
		ordenados por DNI
		*/
		System.out.println("Lista de pasajeros ordenada de forma ascendente por su número de DNI:");
		
		Pasajero[] listaDePasajerosOrdenadaPorDNI = actual.getPasajeros();
		Pasajero auxiliar = null;
		
		for(int i=1; i < listaDePasajerosOrdenadaPorDNI.length; i++) {
			for(int j=0; j < listaDePasajerosOrdenadaPorDNI.length-1; j++){
				if(listaDePasajerosOrdenadaPorDNI[i] != null && listaDePasajerosOrdenadaPorDNI[j].getDni() > listaDePasajerosOrdenadaPorDNI[j+1].getDni()) {
					auxiliar = listaDePasajerosOrdenadaPorDNI[j+1];
					listaDePasajerosOrdenadaPorDNI[j+1] = listaDePasajerosOrdenadaPorDNI[j];
					listaDePasajerosOrdenadaPorDNI[j] = auxiliar;		
				}	
			}	
		}
		System.out.println(Arrays.toString(listaDePasajerosOrdenadaPorDNI));
	}
	
	private static void mostrarMapaDeAsientos(Vuelo actual) {
		
		System.out.println("Mapa de asientos: ");
		System.out.println(actual.toString());
	}
}