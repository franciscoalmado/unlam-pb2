package ar.edu.unlam.pb2.callCenter.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb2.callCenter.dominio.Contacto;
import ar.edu.unlam.pb2.callCenter.dominio.Empresa;
import ar.edu.unlam.pb2.callCenter.dominio.Llamada;
import ar.edu.unlam.pb2.callCenter.dominio.Provincia;

public class InterfazCallCenter {
	
	static Scanner teclado = new Scanner(System.in);
	private static Empresa oesteCableColor = new Empresa ("Oeste Cable Color", 2, 5);
	private static Contacto contacto = new Contacto("","","","","",0,"",Provincia.BUENOS_AIRES);
	private static Llamada llamada = new Llamada(false, "");
	
	public static void main(String args[]) {
			
		int opcion = 0;
		int salir = 9;
		
		do {
			System.out.println("\nBienvenido al callcenter");
			System.out.println("OESTE CABLE COLOR");
			System.out.println("************************");
			System.out.println("Menú de opciones\n");
			System.out.println("1 - Incorporar zona de cobertura");
			System.out.println("2 - Dar de alta un nuevo contacto");
			System.out.println("3 - Realizar nueva llamada");
			System.out.println("4 - Ver información del contacto");
			System.out.println("9 - Salir");
			System.out.println("************************\n");
			
			opcion = teclado.nextInt();
			
				switch (opcion) {
				case 1: 
					incorporarZonaDeCobertura();
					break;
				case 2: 
					darDeAltaNuevoContacto();
					break;
				case 3:
					realizarNuevaLlamada();
					break;
				case 4:
					verInformacionDelContacto();
					break;
				case 9:
					System.out.println("Muchas gracias por preferirnos. ¡Hasta pronto!");
					break;
				default:
					System.out.println("Opcion inválida. Ingrese una opción nuevamente.");
				}
		}while (opcion != salir);
		
		teclado.close();
	}
	
	private static void incorporarZonaDeCobertura() {

		System.out.println("Ingrese el código postal");
		int codigoPostal = teclado.nextInt();
		
		if(oesteCableColor.agregarNuevaZonaDeCobertura(codigoPostal) == true) {
			System.out.println("Ingreso satisfactorio.");
		}else {
			System.out.println("El código postal ya existe. Ingrese uno nuevo.");
		}
	}
	
	private static void darDeAltaNuevoContacto() {
		
		if(oesteCableColor.agregarNuevoContacto(crearContacto(teclado)) == true) {
			System.out.println("Ingreso satisfactorio");
		}else {
			System.out.println("No se pudo ingresar. Inténtelo de nuevo.");
		}
	}
	
	private static Contacto crearContacto(Scanner teclado) { 
		
		System.out.println("Ingrese el nombre:");
		String nombre = teclado.next();
		
		System.out.println("Ingrese el apellido:");
		String apellido = teclado.next();
		
		String telefono = ingresarTelefono(teclado);
		
		String eMail = ingresarEMail(teclado);
		
		System.out.println("Ingrese la dirección:");
		String direccion = teclado.next();
		
		System.out.println("Ingrese el código postal:");
		int codigoPostal = teclado.nextInt();
		
		System.out.println("Ingrese la localidad:");
		String localidad = teclado.next();	
		
		Provincia provincia = elegirProvincia(teclado);
		
		contacto = new Contacto (nombre, apellido, telefono, eMail, direccion, codigoPostal, localidad, provincia);
		
		return contacto;
	}
	
	private static String ingresarTelefono(Scanner teclado){
		String telefonoIngresado = "";
		String telefono = "";
		
		do{
			System.out.println("Ingrese telefono (Ejemplo: +5411-12345678):");
			telefonoIngresado = teclado.next();
			
			if(contacto.esTelefonoValido(telefonoIngresado) == true) {
				System.out.println("Número de teléfono satisfactorio.");
			}else {
				System.out.println("Número de teléfono inválido. Inténtelo de nuevo.");
			}
		}while(contacto.esTelefonoValido(telefonoIngresado) == false);
		
		telefono = telefonoIngresado.replace('+', '0');
		
		return telefono;
	}
	
	private static String ingresarEMail(Scanner teclado){
		String eMail = "";
		
		do{
			System.out.println("Ingrese email (Ejemplos: email@email.com | e.mail@email.com | e_mail@email.com | email123@email.com):");
			eMail = teclado.next();
			
			if(contacto.esEmailValido(eMail) == true) {
				System.out.println("Email satisfactorio.");
			}else {
				System.out.println("Email inválido. Inténtelo de nuevo.");
			}
		}while(contacto.esEmailValido(eMail) == false);
		
		return eMail;
	}
	
	private static Provincia elegirProvincia(Scanner teclado) {
		Provincia provincia = null;
		int elegirProvincia, minimo = 1, maximo = 23;
		
		do {
			System.out.println("Elija la Provincia (Ejemplo: 1)");
			System.out.println("1. CABA - 2. Buenos Aires - 3. Catamarca - 4. Chaco - 5. Chubut - 6. Corrientes");
			System.out.println("7. Entre Ríos - 8. Formosa - 9. Jujuy - 10. La Pampa - 11. La Rioja - 12. Mendoza");
			System.out.println("13. Misiones - 14. Neuquén - 15. Río Negro - 16. Salta - 17. San Juan - 18. San Luis");
			System.out.println("19. Santa Cruz - 20. Santa Fe - 21. Santiago del Estero - 22. Tierra del Fuego - 23. Tucumán");
			elegirProvincia = teclado.nextInt();	
		}while(elegirProvincia < minimo || elegirProvincia > maximo);
		
			switch(elegirProvincia) {
				case 1:
					provincia = Provincia.CABA;
					break;
				case 2:
					provincia = Provincia.BUENOS_AIRES;
					break;
				case 3:
					provincia = Provincia.CATAMARCA;
					break;
				case 4:
					provincia = Provincia.CHACO;
					break;
				case 5:
					provincia = Provincia.CHUBUT;
					break;
				case 6:
					provincia = Provincia.CORRIENTES;
					break;
				case 7:
					provincia = Provincia.ENTRE_RIOS;
					break;
				case 8:
					provincia = Provincia.FORMOSA;
					break;
				case 9:
					provincia = Provincia.JUJUY;
					break;
				case 10:
					provincia = Provincia.LA_PAMPA;
					break;
				case 11:
					provincia = Provincia.LA_RIOJA;
					break;
				case 12:
					provincia = Provincia.MENDOZA;
					break;
				case 13:
					provincia = Provincia.MISIONES;
					break;
				case 14:
					provincia = Provincia.NEUQUEN;
					break;
				case 15:
					provincia = Provincia.RIO_NEGRO;
					break;
				case 16:
					provincia = Provincia.SALTA;
					break;
				case 17:
					provincia = Provincia.SAN_JUAN;
					break;
				case 18:
					provincia = Provincia.SAN_LUIS;
					break;
				case 19:
					provincia = Provincia.SANTA_CRUZ;
					break;
				case 20:
					provincia = Provincia.SANTA_CRUZ;
					break;
				case 21:
					provincia = Provincia.SANTIAGO_DEL_ESTERO;
					break;
				case 22:
					provincia = Provincia.TIERRA_DEL_FUEGO;
					break;
				case 23:
					provincia = Provincia.TUCUMAN;
					break;
		}
		return provincia;
	}
	
	private static void realizarNuevaLlamada() {
	
		Contacto candidato = null;
		
		candidato = buscarContacto(oesteCableColor.getContactos());
				
		candidato.registrarNuevaLlamada(iniciarUnaLlamada(llamada, oesteCableColor.getContactos()));
		
		System.out.println(candidato.toString());
	}

	private static Contacto buscarContacto(Contacto[] contacto) {
		Contacto contactoEncontrado = null;
		
		for(int i=0; i < contacto.length; i++) {
			if(contacto[i] != null && contacto[i].equals(oesteCableColor.buscarCandidato())){
				contactoEncontrado = contacto[i];
			}	
		}
		
		return contactoEncontrado;
	}
	
	private static Llamada iniciarUnaLlamada(Llamada nueva, Contacto[] contacto) {
		double numero = Math.random();
		double probabilidad = 0.5;
		
		if(numero <= probabilidad){
			llamada = new Llamada(true, "Llamada exitosa");
			for(int i=0; i < contacto.length; i++){
				if(contacto[i] != null && contacto[i].equals(oesteCableColor.buscarCandidato()) && contacto[i].isCliente() == false && contacto[i].isDeseaSerLlamadoNuevamente() == true){
					contacto[i].setEsCliente(true);
					contacto[i].setDeseaSerLlamadoNuevamente(false);
				}	
			}
		}else {
			llamada = new Llamada(false, "Se debe llamar más adelante");
			for(int i=0; i < contacto.length; i++){
				if(contacto[i] != null && contacto[i].equals(oesteCableColor.buscarCandidato())){
					contacto[i].setEsCliente(false);
					contacto[i].setDeseaSerLlamadoNuevamente(true);
				}	
			}
		}
		
		return llamada;
	}
		
	private static void verInformacionDelContacto() {

		mostrarContacto(oesteCableColor.getContactos());
	}
	
	private static void mostrarContacto(Contacto[] contacto) {
		
		System.out.println("Listado de contactos: \n");
		
		for(int i = 0; i < contacto.length; i++){
			if(contacto[i] != null){
				System.out.println(contacto[i].toString());
			}
		}
	}
}	