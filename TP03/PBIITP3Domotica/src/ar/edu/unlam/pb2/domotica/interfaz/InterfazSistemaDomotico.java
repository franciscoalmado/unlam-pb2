package ar.edu.unlam.pb2.domotica.interfaz;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unlam.pb2.domotica.dominio.Ascensor;
import ar.edu.unlam.pb2.domotica.dominio.Edificio;
import ar.edu.unlam.pb2.domotica.dominio.Persona;
import ar.edu.unlam.pb2.domotica.dominio.SistemaDomotico;
import ar.edu.unlam.pb2.domotica.dominio.TipoDeIdentificacion;

public class InterfazSistemaDomotico {

	static Scanner teclado = new Scanner(System.in);
	private static SistemaDomotico domotica = new SistemaDomotico();
	private static Persona persona;
	private static Edificio edificio;
	private static Ascensor ascensor;
	
	public static void main(String[] args) throws Exception{
		
		int opcion = 0;
		int salir = 9;
		
		do {
			opcion = seleccionarOpcion();
			edificio = crearUnEdificio();
			ascensor = crearAscensor(edificio);
			persona = crearUnaPersona();
			
			switch(opcion) {				
				case 1:
					inicializarSistemaDomotico(edificio); 
				break;
				case 2:
					registrarMovimientoDePersonas(persona, ascensor);
				break;
				case 3:
					mostrarEmpleadosEnSuAreaDeTrabajo(domotica.getEmpleadosQueIngresanASuAreaDeTrabajo());
				break;
				case 4:
					mostrarClientesEnElAreaDeAtencion(domotica.getPersonasQueEgresan());
				break;
				case 5:
					mostrarEmpleadosAusentes(domotica);
				break;
				case 6:
					mostrarInformeSobreElFuncionamientoDeAscensores(ascensor);
				break;
				case 9:
					System.out.println("Usted ha salido del sistema");
				break;
			}		
		}while(opcion != salir);
		
	}
	
	private static int seleccionarOpcion() {
	
		int opcion = 0;
		
		System.out.println("Bienvenidos al Sistema Domotico");
		System.out.println("1 - Inicializar el sistema");
		System.out.println("2 - Registrar movimientos de personas");
		System.out.println("3 - Mostrar el tiempo en que cada empleado se encontró en su piso");
		System.out.println("4 - Mostrar el tiempo promedio en el que los clientes se encuentran dentro del edificio");
		System.out.println("5 - Mostrar el El listado de los empleados ausentes en un día determinado");
		System.out.println("6 - Generar informe sobre el funcionamiento de los ascensores");
		System.out.println("9 - Salir");
		
		opcion = teclado.nextInt();
		
		return opcion;
	}
	
	private static Edificio crearUnEdificio() {
		
		String nombre = "";
		int pisoMinimo = 0;
		int pisoMaximo = 0;
		int cantidadDeAscensores = 0;
		Edificio edificioNuevo = null;
		
		System.out.println("Ingrese el nombre del edificio: ");
		nombre = teclado.next();

		System.out.println("Ingrese el número de piso mínimo que posee: ");
		pisoMinimo = teclado.nextInt();
		
		System.out.println("Ingrese el número de piso máximo que posee: ");
		pisoMaximo = teclado.nextInt();
		
		System.out.println("Ingrese la cantidad de ascensores que posee: ");
		cantidadDeAscensores = teclado.nextInt();
		
		edificioNuevo = new Edificio(nombre, pisoMinimo, pisoMaximo, cantidadDeAscensores);
	
		return edificioNuevo;
	}
	
	private static void inicializarSistemaDomotico(Edificio edificio) {
		
		domotica.configurarSistema(edificio);
		
		domotica.activarSistema();	
		
		if(domotica.getIsActivado()) {
			System.out.println("Se ha inicializado el sistema");
		}else {
			System.out.println("No se ha podido inicializar. Inténtelo de nuevo.");
		}
	}
	
	private static Ascensor crearAscensor(Edificio edificio) {
	
		int capacidadMaxima = 0;
		double pesoMaximo = 0.0;
		Ascensor ascensorNuevo = null;
		
		System.out.println("Ingrese la capacidad máxima de los ascensores: ");
		capacidadMaxima = teclado.nextInt();
		
		System.out.println("Ingrese el peso máximo de los ascensores");
		pesoMaximo = teclado.nextDouble();
		
		ascensorNuevo = new Ascensor(edificio.getPISO_MAXIMO(), edificio.getPISO_MINIMO(), capacidadMaxima, pesoMaximo);
	
		return ascensorNuevo;
	}

	private static Persona crearUnaPersona() {
		
		String nombre = "";
		String apellido = "";
		int dni = 0;
		TipoDeIdentificacion tipoDeIdentificacion = null;
		double peso = 0.0;
		
		System.out.println("Ingrese el nombre de la persona: ");
		nombre = teclado.next();
		
		System.out.println("Ingrese el apellido de la persona: ");
		apellido = teclado.next();
		
		System.out.println("Ingrese el DNI: ");
		dni = teclado.nextInt();
		
		tipoDeIdentificacion = seleccionarUnTipoDeIdentificacion();
		
		System.out.println("Ingrese el peso de la persona: ");
		peso = teclado.nextDouble();
		
		persona = new Persona(nombre, apellido, dni, tipoDeIdentificacion, peso);
		
		return persona;
	}
	
	private static TipoDeIdentificacion seleccionarUnTipoDeIdentificacion() {
		
		TipoDeIdentificacion tipoDeIdentificacion = null;
		int opcion = 0;
		
		do {
			System.out.println("Elija una opción de identificación: ");
			System.out.println("1 - Empleado");
			System.out.println("2 - Cliente");
			opcion = teclado.nextInt();
		}while(opcion < 1 && opcion > 2);
		
		switch(opcion) {
			case 1:
				tipoDeIdentificacion = TipoDeIdentificacion.EMPLEADO;
			break;
			case 2:
				tipoDeIdentificacion = TipoDeIdentificacion.CLIENTE;
			break;
		}
		
		return tipoDeIdentificacion; 
	}
	
	private static void registrarMovimientoDePersonas(Persona persona, Ascensor ascensor) throws Exception {
		LocalDate fecha = null;
		LocalTime tiempo = null;
		int numeroDePiso = 0;
		int numeroDeAscensor = 0;
		int cantidadDeAscensores = 5;
		
		numeroDePiso = (int) (Math.random() * (ascensor.getPISO_MAXIMO() - ascensor.getPISO_MINIMO())) + ascensor.getPISO_MINIMO();

		numeroDeAscensor = (int) (Math.random() * (cantidadDeAscensores - 1) + 1);
		
		fecha = LocalDate.now();
		tiempo = LocalTime.now();
		
		domotica.ingresarPersona(persona);
		
		domotica.registrarIngresoDePersonas(persona, fecha);
		
		domotica.registrarEgresoDePersonas(persona, tiempo);
		
		domotica.registrarPersonaQueSubeAlAscensor(persona, numeroDePiso, numeroDeAscensor);
		
		domotica.registrarPersonaQueBajaDelAscensor(persona, numeroDePiso, numeroDeAscensor);

		domotica.registarIngresoDeEmpleadosASuAreaDeTrabajo(persona, numeroDePiso);
		
		domotica.registarEgresoDeEmpleadosASuAreaDeTrabajo(persona, numeroDePiso, tiempo);
	}
	
	public static void mostrarEmpleadosEnSuAreaDeTrabajo(ArrayList<Persona> empleados) {
		
		for(Persona empleado : empleados) {
			if(empleado.getTipo().equals(TipoDeIdentificacion.EMPLEADO)) {
				System.out.println(empleado + " ");
			}
		}
	}
	
	public static void mostrarClientesEnElAreaDeAtencion(ArrayList<Persona> clientes) {
		
		for(Persona cliente : clientes) {
			if(cliente.getTipo().equals(TipoDeIdentificacion.CLIENTE)) {
				System.out.println(cliente + " ");
			}
		}	
	}
	
	public static void mostrarEmpleadosAusentes(SistemaDomotico sistema) {
		LocalDate fecha;
		int dia = 0;
		int mes = 0;
		int anio = 0;

		System.out.println("Ingrese el dia: ");
		dia = teclado.nextInt();
		
		System.out.println("Ingrese el mes: ");
		mes = teclado.nextInt();
		
		System.out.println("Ingrese el año: ");
		anio = teclado.nextInt();
		
		fecha = LocalDate.of(anio, mes, dia);
		
		sistema.listarEmpleadosAusentes(fecha);		
	}
	
	public static void mostrarInformeSobreElFuncionamientoDeAscensores(Ascensor ascensor) {
		
		System.out.println("Cantidad de veces que se sobrecarga: " + ascensor.getContadorDeVecesConSobrecarga());
	}
}