package ar.edu.unlam.pb2.alimentacionHospitalCentral.interfaz;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.AdministracionDeAlimentacion;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.AlimentoBase;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.Celiaco;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.ComidaDelDia;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.DiabeticoTipo1;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.DiabeticoTipo2;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.General;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.Genero;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.GrupoDeAlimentos;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.Hipertenso;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.Oncologico;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.Paciente;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.TipoDeActividad;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.TipoDePaciente;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.TipoDePreparacion;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.UnidadDeMedida;

public class InterfazAdministracionDeAlimentacion {

	static Scanner teclado = new Scanner(System.in);
	private static Hipertenso pacienteHipertenso;
	private static Celiaco pacienteCeliaco;
	private static General pacienteGeneral;
	private static DiabeticoTipo1 pacienteDiabeticoTipo1;
	private static DiabeticoTipo2 pacienteDiabeticoTipo2;
	private static Oncologico pacienteOncologico;
	private static AlimentoBase alimento;
	private static AdministracionDeAlimentacion empresaTercerizada = new AdministracionDeAlimentacion();
	
	public static void main(String[] args) {
		
		char opcion = '\u0000';
		
		do {
			opcion = seleccionarUnaOpcion();
			
			switch(opcion) {
				case 'A':
				case 'a':
					ingresarUnAlimentoAlSistema(empresaTercerizada);
				break;
				case 'B':
				case 'b':
					ingresarUnPacienteAlSistema(empresaTercerizada);
				break;
				case 'C':
				case 'c':
					mostrarRegistroDeAlimentos(empresaTercerizada.getAlimentos());
				break;
				case 'D':
				case 'd':
					mostrarRegistroDePacientes(empresaTercerizada.getPacientes());
				break;
				case 'E':
				case 'e':
					verOpcionDeMenuPacientesGenerales(empresaTercerizada);
				break;
				case 'F':
				case 'f':
					verOpcionDeMenuPacientesCeliacos(empresaTercerizada);
				break;
				case 'G':
				case 'g':
					verOpcionDeMenuPacientesHipertensos(empresaTercerizada);
				break;
				case 'H':
				case 'h':
					verOpcionDeMenuPacientesOncologicos(empresaTercerizada);
				break;
				case 'I':
				case 'i':
					verOpcionDeMenuPacientesDiabeticosTipo1(empresaTercerizada);
				break;
				case 'J':
				case 'j':
					verOpcionDeMenuPacientesDiabeticosTipo2(empresaTercerizada);					
				break;
				case 'S':
				case 's':
					System.out.println("Usted ha salido del sistema.");
				break;
			}
		}while(opcion != 'S' && opcion != 's');
	}
	
	private static char seleccionarUnaOpcion() {
		char opcion = '\u0000';
		
		System.out.println("Bienvenidos al Sistema de Gestión de Alimentación de Pacientes del Hospital General");
		System.out.println("A - Ingresar un alimento al sistema");
		System.out.println("B - Ingresar un paciente al sistema");
		System.out.println("C - Mostrar registro de alimentos");
		System.out.println("D - Mostrar registro de pacientes");
		System.out.println("E - Ver opciones de menú para paciente General");
		System.out.println("F - Ver opciones de menú para paciente Celíaco");
		System.out.println("G - Ver opciones de menú para paciente Hipertenso");
		System.out.println("H - Ver opciones de menú para paciente Oncológicos");
		System.out.println("I - Ver opciones de menú para paciente Diabético tipo 1");
		System.out.println("J - Ver opciones de menú para paciente Diabético tipo 2");
		System.out.println("S - Salir");
		
		opcion = teclado.next().charAt(opcion);
		
		return opcion;
	}
	
	private static void ingresarUnPacienteAlSistema(AdministracionDeAlimentacion empresa) {
		String nombre = "";
		String apellido = "";
		Genero genero = null;
		int edad = 0;
		int estatura = 0;
		double peso = 0.0;
		TipoDeActividad tipoDeActividad = null;
		TipoDePaciente tipoDePaciente = null;
		int numeroDeHabitacion = 0;
		
		System.out.println("Ingrese nombre: ");
		nombre = teclado.next();
		
		System.out.println("Ingrese apellido: ");
		apellido = teclado.next();
		
		genero = seleccioneUnGenero();
		
		System.out.println("Ingrese edad: ");
		edad = teclado.nextInt(); 
		
		System.out.println("Ingrese estatura: ");
		estatura = teclado.nextInt(); 
		
		System.out.println("Ingrese peso: ");
		peso = teclado.nextDouble(); 
		
		tipoDeActividad = seleccionarTipoDeActividadQueRealiza();
		
		tipoDePaciente = seleccionarUnTipoDePaciente();
		
		System.out.println("Ingrese número de habitación: ");
		numeroDeHabitacion = teclado.nextInt();
		
		if(tipoDePaciente.equals(TipoDePaciente.GENERAL)) {
			pacienteGeneral = new General(nombre, apellido, genero, edad, estatura, peso, tipoDeActividad, tipoDePaciente, numeroDeHabitacion);
			empresa.agregarPaciente(pacienteGeneral);
			empresa.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.GENERAL);
		}
		
		if(tipoDePaciente.equals(TipoDePaciente.HIPERTENSO)) {
			pacienteHipertenso = new Hipertenso(nombre, apellido, genero, edad, estatura, peso, tipoDeActividad, tipoDePaciente, numeroDeHabitacion);
			empresa.agregarPaciente(pacienteHipertenso);
			empresa.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.HIPERTENSO);
		}
		
		if(tipoDePaciente.equals(TipoDePaciente.CELIACO)) {
			pacienteCeliaco = new Celiaco(nombre, apellido, genero, edad, estatura, peso, tipoDeActividad, tipoDePaciente, numeroDeHabitacion);
			empresa.agregarPaciente(pacienteCeliaco);
			empresa.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.CELIACO);
		}
		
		if(tipoDePaciente.equals(TipoDePaciente.DIABETICO_TIPO_1)) {
			pacienteDiabeticoTipo1 = new DiabeticoTipo1(nombre, apellido, genero, edad, estatura, peso, tipoDeActividad, tipoDePaciente, numeroDeHabitacion);
			empresa.agregarPaciente(pacienteDiabeticoTipo1);	
			empresa.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.DIABETICO_TIPO_1);
		}
		
		if(tipoDePaciente.equals(TipoDePaciente.DIABETICO_TIPO_2)) {
			pacienteDiabeticoTipo2 = new DiabeticoTipo2(nombre, apellido, genero, edad, estatura, peso, tipoDeActividad, tipoDePaciente, numeroDeHabitacion);
			empresa.agregarPaciente(pacienteDiabeticoTipo2);	
			empresa.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.DIABETICO_TIPO_2);
		}
		
		if(tipoDePaciente.equals(TipoDePaciente.ONCOLOGICO)) {
			pacienteOncologico = new Oncologico(nombre, apellido, genero, edad, estatura, peso, tipoDeActividad, tipoDePaciente, numeroDeHabitacion);
			empresa.agregarPaciente(pacienteOncologico);	
			empresa.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.ONCOLOGICO);
		}	
	}
	
	private static Genero seleccioneUnGenero() {
		
		Genero genero = null;
		int opcion = 0;
		
		do {
			System.out.println("Elija una opción de género: ");
			System.out.println("1 - Femenino");
			System.out.println("2 - Masculino");
			opcion = teclado.nextInt();
		}while(opcion < 1 && opcion > 2);
		
		switch(opcion) {
			case 1:
				genero = Genero.FEMENINO;
			break;
			case 2:
				genero = Genero.MASCULINO;
			break;
		}
		
		return genero;	
	}
	
	private static TipoDeActividad seleccionarTipoDeActividadQueRealiza() {
		
		TipoDeActividad tipoDeActividad = null;
		int opcion = 0;
		
		do {
			System.out.println("Elija una modalidad de actividad que acostumbra el paciente en su vida: ");
			System.out.println("1 - Sedentaria");
			System.out.println("2 - Moderada");
			System.out.println("3 - Extrema");
			opcion = teclado.nextInt();
		}while(opcion < 1 && opcion > 3);
		
		switch(opcion) {
			case 1:
				tipoDeActividad = TipoDeActividad.SEDENTARIA;
			break;
			case 2:
				tipoDeActividad = TipoDeActividad.MODERADA;
			break;
			case 3:
				tipoDeActividad = TipoDeActividad.EXTREMA;
			break;
		}
		
		return tipoDeActividad;
	}
	
	private static TipoDePaciente seleccionarUnTipoDePaciente() {
		
		TipoDePaciente tipoDePaciente = null;
		int opcion = 0;
		
		do {
			System.out.println("Elija una opción de tipo de paciente, según su patología: ");
			System.out.println("1 - General");
			System.out.println("2 - Hipertenso");
			System.out.println("3 - Celíaco");
			System.out.println("4 - Diabético tipo 1");
			System.out.println("5 - Diabético tipo 2");
			System.out.println("6 - Oncológico");
			opcion = teclado.nextInt();
		}while(opcion < 1 && opcion > 6);
	
		switch(opcion) {
			case 1:
				tipoDePaciente = TipoDePaciente.GENERAL;
			break;
			case 2:
				tipoDePaciente = TipoDePaciente.HIPERTENSO;
			break;
			case 3:
				tipoDePaciente = TipoDePaciente.CELIACO;
			break;
			case 4:
				tipoDePaciente = TipoDePaciente.DIABETICO_TIPO_1;
			break;
			case 5:
				tipoDePaciente = TipoDePaciente.DIABETICO_TIPO_2;
			break;
			case 6:
				tipoDePaciente = TipoDePaciente.ONCOLOGICO;
			break;
		}
		
		return tipoDePaciente;
	}
	
	private static AlimentoBase crearUnAlimento() {
		
		String nombre = "";
		float carbohidratos = 0.0f;
		float proteinas = 0.0f;
		float lipidos = 0.0f;
		GrupoDeAlimentos grupo = null;
		float cantidad = 0.0f;
		UnidadDeMedida unidadDeMedida = null;
		float contenidoDeAzucar = 0.0f;
		float contenidoDeSodio = 0.0f;
		TipoDePreparacion tipoDePreparacion = null;
	
		System.out.println("Ingrese el nombre del alimento: ");
		nombre = teclado.next();
		
		System.out.println("Ingrese la cantidad de carbohidratos que contiene: ");
		carbohidratos = teclado.nextFloat();
		
		System.out.println("Ingrese la cantidad de proteínas que contiene: ");
		proteinas = teclado.nextFloat();
		
		System.out.println("Ingrese la cantidad de lípidos que contiene: ");
		lipidos = teclado.nextFloat();
		
		grupo = seleccionarUnGrupoDeAlimentos();
		
		System.out.println("Ingrese cantidad: ");
		cantidad = teclado.nextFloat();
		
		unidadDeMedida = seleccionarUnaUnidadDeMedida();
				
		System.out.println("Ingrese el índice glucémico que contiene: ");
		contenidoDeAzucar = teclado.nextFloat();
		
		System.out.println("Ingrese la cantidad de sodio que contiene: ");
		contenidoDeSodio = teclado.nextFloat();
		
		tipoDePreparacion = seleccionarTipoDePreparacion();
		
		alimento = new AlimentoBase(nombre, carbohidratos, proteinas, lipidos, grupo, cantidad, unidadDeMedida, contenidoDeAzucar, contenidoDeSodio, tipoDePreparacion);	
		
		return alimento;
	}
	
	private static GrupoDeAlimentos seleccionarUnGrupoDeAlimentos() {
		
		GrupoDeAlimentos grupo = null;
		
		int opcion = 0;
		
		do {
			System.out.println("Elija un Grupo de Alimentos: ");
			System.out.println("1 - Frutas");
			System.out.println("2 - Verduras");
			System.out.println("3 - Cereales en general");
			System.out.println("4 - Cereal: Trigo");
			System.out.println("5 - Cereal: Avena");
			System.out.println("6 - Cereal: Cebada");
			System.out.println("7 - Cereal: Centeno");
			System.out.println("8 - Proteínas");
			System.out.println("9 - Lácteos");
			System.out.println("10 - Otros");
			opcion = teclado.nextInt();
		}while(opcion < 1 && opcion > 10);
		
		switch(opcion) {
			case 1:
				grupo = GrupoDeAlimentos.FRUTAS;
			break;
			case 2:
				grupo = GrupoDeAlimentos.VERDURAS;
			break;
			case 3:
				grupo = GrupoDeAlimentos.CEREALES_EN_GENERAL;
			break;
			case 4:
				grupo = GrupoDeAlimentos.CEREAL_TRIGO;
			break;
			case 5:
				grupo = GrupoDeAlimentos.CEREAL_AVENA;
			break;
			case 6:
				grupo = GrupoDeAlimentos.CEREAL_CEBADA;
			break;
			case 7:
				grupo = GrupoDeAlimentos.CEREAL_CENTENO;
			break;
			case 8:
				grupo = GrupoDeAlimentos.PROTEINAS;
			break;
			case 9:
				grupo = GrupoDeAlimentos.LACTEOS;
			break;
			case 10:
				grupo = GrupoDeAlimentos.OTROS;
			break;
		}
		
		return grupo;	
	}
	
	private static UnidadDeMedida seleccionarUnaUnidadDeMedida() {
		
		UnidadDeMedida unidadDeMedida = null;
		
		int opcion = 0;
		
		do {
			System.out.println("Elija una unidad de medida: ");
			System.out.println("1 - Pieza");
			System.out.println("2 - gr");
			System.out.println("3 - kg");
			System.out.println("4 - ml");
			System.out.println("5 - l");
			System.out.println("6 - Cucharadita");
			System.out.println("7 - Cucharadita sopera");
			System.out.println("8 - Oz");
			System.out.println("9 - lb");
			System.out.println("10 - Taza");
			System.out.println("11 - Pizca");
			opcion = teclado.nextInt();
		}while(opcion < 1 && opcion > 11);
		
		switch(opcion) {
			case 1:
				unidadDeMedida = UnidadDeMedida.PIEZA;
			break;
			case 2:
				unidadDeMedida = UnidadDeMedida.GR;
			break;
			case 3:
				unidadDeMedida = UnidadDeMedida.KG;
			break;
			case 4:
				unidadDeMedida = UnidadDeMedida.ML;
			break;
			case 5:
				unidadDeMedida = UnidadDeMedida.L;
			break;
			case 6:
				unidadDeMedida = UnidadDeMedida.CUCHARADITA;
			break;
			case 7:
				unidadDeMedida = UnidadDeMedida.CUCHARADITA_SOPERA;
			break;
			case 8:
				unidadDeMedida = UnidadDeMedida.OZ;
			break;
			case 9:
				unidadDeMedida = UnidadDeMedida.LB;
			break;
			case 10:
				unidadDeMedida = UnidadDeMedida.TAZA;
			break;
			case 11:
				unidadDeMedida = UnidadDeMedida.PIZCA;
			break;
		}
		
		return unidadDeMedida;	
	}
	
	private static TipoDePreparacion seleccionarTipoDePreparacion() {
		
		TipoDePreparacion tipo = null;
		
		int opcion = 0;
		
		do {
			System.out.println("Elija un tipo de preparación: ");
			System.out.println("1 - Horno");
			System.out.println("2 - Frito");
			System.out.println("3 - Al vapor");
			System.out.println("4 - Sin cocción");
			opcion = teclado.nextInt();
		}while(opcion < 1 && opcion > 4);
		
		switch(opcion) {
			case 1:
				tipo = TipoDePreparacion.HORNO;
			break;
			case 2:
				tipo = TipoDePreparacion.FRITO;
			break;
			case 3:
				tipo = TipoDePreparacion.AL_VAPOR;
			break;
			case 4:
				tipo = TipoDePreparacion.SIN_COCCION;
			break;
		}
		
		return tipo;
	}
	
	private static void ingresarUnAlimentoAlSistema(AdministracionDeAlimentacion empresa) {
		
		AlimentoBase nuevo = crearUnAlimento();
		
		empresa.agregarAlimento(nuevo);
	}
	
	private static void mostrarRegistroDeAlimentos(ArrayList<AlimentoBase> alimentos) {
		
		for(AlimentoBase alimento : alimentos) {
			System.out.println(alimento + " ");
		}
	}
	
	private static void mostrarRegistroDePacientes(ArrayList<Paciente> pacientes) {
		
		for(Paciente paciente : pacientes) {
			System.out.println(paciente + " ");
		}
	}
	
	private static void verOpcionDeMenuPacientesGenerales(AdministracionDeAlimentacion empresa) {
		
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDeTipoGeneral(ComidaDelDia.DESAYUNO);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDeTipoGeneral(ComidaDelDia.MERIENDA_MANIANA);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDeTipoGeneral(ComidaDelDia.ALMUERZO);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDeTipoGeneral(ComidaDelDia.MERIENDA_TARDE);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDeTipoGeneral(ComidaDelDia.CENA);
		
		System.out.println(empresa.getMenuParaPacientesGenerales());
	}
	
	private static void verOpcionDeMenuPacientesCeliacos(AdministracionDeAlimentacion empresa) {
		
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesCeliacos(ComidaDelDia.DESAYUNO);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesCeliacos(ComidaDelDia.MERIENDA_MANIANA);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesCeliacos(ComidaDelDia.ALMUERZO);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesCeliacos(ComidaDelDia.MERIENDA_TARDE);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesCeliacos(ComidaDelDia.CENA);
		
		System.out.println(empresa.getMenuParaPacientesCeliacos());
	}
	
	private static void verOpcionDeMenuPacientesHipertensos(AdministracionDeAlimentacion empresa) {
		
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesHipertensos(ComidaDelDia.DESAYUNO);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesHipertensos(ComidaDelDia.MERIENDA_MANIANA);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesHipertensos(ComidaDelDia.ALMUERZO);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesHipertensos(ComidaDelDia.MERIENDA_TARDE);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesHipertensos(ComidaDelDia.CENA);
		
		System.out.println(empresa.getMenuParaPacientesHipertensos());
	}
	
	private static void verOpcionDeMenuPacientesOncologicos(AdministracionDeAlimentacion empresa) {
		
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesOncologicos(ComidaDelDia.DESAYUNO);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesOncologicos(ComidaDelDia.MERIENDA_MANIANA);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesOncologicos(ComidaDelDia.ALMUERZO);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesOncologicos(ComidaDelDia.MERIENDA_TARDE);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesOncologicos(ComidaDelDia.CENA);
		
		System.out.println(empresa.getMenuParaPacientesOncologicos());
	}
	
	private static void verOpcionDeMenuPacientesDiabeticosTipo1(AdministracionDeAlimentacion empresa) {
		
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo1(ComidaDelDia.DESAYUNO);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo1(ComidaDelDia.MERIENDA_MANIANA);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo1(ComidaDelDia.ALMUERZO);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo1(ComidaDelDia.MERIENDA_TARDE);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo1(ComidaDelDia.CENA);
		
		System.out.println(empresa.getMenuParaPacientesDiabeticosTipo1());
	}
	
	private static void verOpcionDeMenuPacientesDiabeticosTipo2(AdministracionDeAlimentacion empresa) {
		
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo2(ComidaDelDia.DESAYUNO);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo2(ComidaDelDia.MERIENDA_MANIANA);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo2(ComidaDelDia.ALMUERZO);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo2(ComidaDelDia.MERIENDA_TARDE);
		empresa.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo2(ComidaDelDia.CENA);
		
		System.out.println(empresa.getMenuParaPacientesDiabeticosTipo2());
	}
}