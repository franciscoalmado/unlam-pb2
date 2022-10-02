package ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AdministracionDeAlimentacion {

	private ArrayList<AlimentoBase> alimentos;
	private ArrayList<Paciente> pacientes;
	
	private ArrayList<Paciente> pacientesGeneral;
	private ArrayList<Paciente> pacientesDiabeticosTipo1;
	private ArrayList<Paciente> pacientesDiabeticosTipo2;
	private ArrayList<Paciente> pacientesOncologicos;
	private ArrayList<Paciente> pacientesCeliacos;
	private ArrayList<Paciente> pacientesHipertensos; 
	
	private ArrayList<AlimentoBase> alimentosParaPacientesGeneral;
	private ArrayList<AlimentoBase> alimentosParaPacientesDiabeticosTipo1;
	private ArrayList<AlimentoBase> alimentosParaPacientesDiabeticosTipo2;
	private ArrayList<AlimentoBase> alimentosParaPacientesOncologicos;
	private ArrayList<AlimentoBase> alimentosParaPacientesCeliacos;
	private ArrayList<AlimentoBase> alimentosParaPacientesHipertensos; 
	
	private HashMap<String, ArrayList<AlimentoBase>> menuPacientesGeneral;
	private HashMap<String, ArrayList<AlimentoBase>> menuPacientesDiabeticosTipo1;
	private HashMap<String, ArrayList<AlimentoBase>> menuPacientesDiabeticosTipo2;
	private HashMap<String, ArrayList<AlimentoBase>> menuPacientesCeliacos;
	private HashMap<String, ArrayList<AlimentoBase>> menuPacientesOncologicos;
	private HashMap<String, ArrayList<AlimentoBase>> menuPacientesHipertensos;
	
	public AdministracionDeAlimentacion() {
		this.alimentos = new ArrayList<AlimentoBase>();
		this.pacientes = new ArrayList<Paciente>();
		this.pacientesGeneral = new ArrayList<Paciente>();
		this.pacientesCeliacos = new ArrayList<Paciente>();
		this.pacientesDiabeticosTipo1 = new ArrayList<Paciente>();
		this.pacientesDiabeticosTipo2 = new ArrayList<Paciente>();
		this.pacientesHipertensos = new ArrayList<Paciente>();
		this.pacientesOncologicos = new ArrayList<Paciente>();
		this.alimentosParaPacientesDiabeticosTipo1 = new ArrayList<AlimentoBase>();
		this.alimentosParaPacientesDiabeticosTipo2 = new ArrayList<AlimentoBase>();
		this.alimentosParaPacientesOncologicos = new ArrayList<AlimentoBase>();
		this.alimentosParaPacientesCeliacos = new ArrayList<AlimentoBase>();
		this.alimentosParaPacientesHipertensos = new ArrayList<AlimentoBase>();
		this.menuPacientesGeneral = new HashMap<String, ArrayList<AlimentoBase>>();
		this.menuPacientesDiabeticosTipo1 = new HashMap<String, ArrayList<AlimentoBase>>();
		this.menuPacientesDiabeticosTipo2 = new HashMap<String, ArrayList<AlimentoBase>>();
		this.menuPacientesCeliacos = new HashMap<String, ArrayList<AlimentoBase>>();
		this.menuPacientesOncologicos = new HashMap<String, ArrayList<AlimentoBase>>();
		this.menuPacientesHipertensos = new HashMap<String, ArrayList<AlimentoBase>>();
	}
	
	public void agregarAlimento(AlimentoBase alimento) {
		
		this.alimentos.add(alimento);	
	}
	
	public void agregarPaciente(Paciente paciente) {
		
		this.pacientes.add(paciente);
		
		if(paciente.getTipoDePaciente().equals(TipoDePaciente.GENERAL)) {
			this.pacientesGeneral.add(paciente);
		}
		if(paciente.getTipoDePaciente().equals(TipoDePaciente.CELIACO)) {
			this.pacientesCeliacos.add(paciente);
		}
		if(paciente.getTipoDePaciente().equals(TipoDePaciente.HIPERTENSO)) {
			this.pacientesHipertensos.add(paciente);
		}
		if(paciente.getTipoDePaciente().equals(TipoDePaciente.DIABETICO_TIPO_1)) {
			this.pacientesDiabeticosTipo1.add(paciente);
		}
		if(paciente.getTipoDePaciente().equals(TipoDePaciente.DIABETICO_TIPO_2)) {
			this.pacientesDiabeticosTipo2.add(paciente);
		}
		if(paciente.getTipoDePaciente().equals(TipoDePaciente.ONCOLOGICO)) {
			this.pacientesOncologicos.add(paciente);
		}	
	}
		
	public void registrarAlimentosSegunTipoDePaciente(TipoDePaciente paciente) {
		float indiceGlucemico = 0.0f;
		float indiceGlucemicoRecomendado = 55.0f;
		float cantidadDeSodioRecomendada = 0.25f;
		
		switch(paciente) {
			case GENERAL:
				this.alimentosParaPacientesGeneral = new ArrayList<AlimentoBase>(alimentos);
			break;
			case DIABETICO_TIPO_1:
				for(AlimentoBase alimentoAptoParaPacienteDiabeticoTipo1 : this.alimentos) {
					if(alimentoAptoParaPacienteDiabeticoTipo1.getContenidoDeAzucar() == indiceGlucemico) {
						this.alimentosParaPacientesDiabeticosTipo1.add(alimentoAptoParaPacienteDiabeticoTipo1);
					}
				}	
			break;
			case DIABETICO_TIPO_2:
				for(AlimentoBase alimentoAptoParaPacienteDiabeticoTipo2 : this.alimentos) {
					if(alimentoAptoParaPacienteDiabeticoTipo2.getContenidoDeAzucar() >= indiceGlucemico && alimentoAptoParaPacienteDiabeticoTipo2.getContenidoDeAzucar() <=  indiceGlucemicoRecomendado) {
						this.alimentosParaPacientesDiabeticosTipo2.add(alimentoAptoParaPacienteDiabeticoTipo2);
					}
				}
			break;
			case ONCOLOGICO:	
				for(AlimentoBase alimentoAptoParaPacienteOncologico : this.alimentos) {
					if(!alimentoAptoParaPacienteOncologico.getTipoDePreparacion().equals(TipoDePreparacion.SIN_COCCION)) {
						this.alimentosParaPacientesOncologicos.add(alimentoAptoParaPacienteOncologico);
					}
				}
			break;
			case CELIACO:
				for(AlimentoBase alimentoAptoParaPacienteCeliaco : this.alimentos) {
					if(!alimentoAptoParaPacienteCeliaco.getGrupo().equals(GrupoDeAlimentos.CEREAL_TRIGO) && !alimentoAptoParaPacienteCeliaco.getGrupo().equals(GrupoDeAlimentos.CEREAL_AVENA) && !alimentoAptoParaPacienteCeliaco.getGrupo().equals(GrupoDeAlimentos.CEREAL_CEBADA) && !alimentoAptoParaPacienteCeliaco.getGrupo().equals(GrupoDeAlimentos.CEREAL_CENTENO)) {
						this.alimentosParaPacientesCeliacos.add(alimentoAptoParaPacienteCeliaco);
					}
				}
			break;
			case HIPERTENSO:
				for(AlimentoBase alimentoParaPacienteHipertenso : this.alimentos) {
					if(alimentoParaPacienteHipertenso.getContenidoDeSodio() <= cantidadDeSodioRecomendada) {
						this.alimentosParaPacientesHipertensos.add(alimentoParaPacienteHipertenso);
					}
				}
			break;
			default:
			break;
		}
	}
	
	private AlimentoBase generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos grupo, ArrayList<AlimentoBase> listaDeAlimentos){
		AlimentoBase alimento = null;
		Random alimentoRandom = new Random();
		int posicion = 0;
		
		for(int i=0; i < listaDeAlimentos.size(); i++) {
			do {
				posicion = alimentoRandom.nextInt(listaDeAlimentos.size());
				alimento = listaDeAlimentos.get(posicion);	
			}while(!alimento.getGrupo().equals(grupo));
		}
		return alimento;
	} 
	
	public void agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDeTipoGeneral(ComidaDelDia comidaDelDia) {
		ArrayList<AlimentoBase> alimentosAgregados = new ArrayList<AlimentoBase>();
		AlimentoBase alimento1 = null;
		AlimentoBase alimento2 = null;
		AlimentoBase alimento3 = null;
		
		if(comidaDelDia.equals(ComidaDelDia.DESAYUNO)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento3);
			this.menuPacientesGeneral.put("Desayuno - Paciente General ", alimentosAgregados);	
		}
		
		if(comidaDelDia.equals(ComidaDelDia.MERIENDA_MANIANA)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento2);
			this.menuPacientesGeneral.put("Merienda mañana - Paciente General ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.ALMUERZO)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.VERDURAS, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.PROTEINAS, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento3);
			this.menuPacientesGeneral.put("Almuerzo - Paciente General ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.MERIENDA_TARDE)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento2);
			this.menuPacientesGeneral.put("Merienda tarde - Paciente General ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.CENA)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.VERDURAS, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.PROTEINAS, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesGeneral);
			alimentosAgregados.add(alimento3);
			this.menuPacientesGeneral.put("Cena - Paciente General ", alimentosAgregados);
		}
	}
	
	public void agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo1(ComidaDelDia comidaDelDia) {
		ArrayList<AlimentoBase> alimentosAgregados = new ArrayList<AlimentoBase>();
		AlimentoBase alimento1 = null;
		AlimentoBase alimento2 = null;
		AlimentoBase alimento3 = null;
		
		if(comidaDelDia.equals(ComidaDelDia.DESAYUNO)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento3);
			this.menuPacientesDiabeticosTipo1.put("Desayuno - Paciente Diabético tipo 1 ", alimentosAgregados);	
		}
		
		if(comidaDelDia.equals(ComidaDelDia.MERIENDA_MANIANA)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento2);
			this.menuPacientesDiabeticosTipo1.put("Merienda mañana - Paciente Diabético tipo 1 ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.ALMUERZO)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.VERDURAS, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.PROTEINAS, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento3);
			this.menuPacientesDiabeticosTipo1.put("Almuerzo - Paciente Diabético tipo 1 ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.MERIENDA_TARDE)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento2);
			this.menuPacientesDiabeticosTipo1.put("Merienda tarde - Paciente Diabético tipo 1 ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.CENA)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.VERDURAS, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.PROTEINAS, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesDiabeticosTipo1);
			alimentosAgregados.add(alimento3);
			this.menuPacientesDiabeticosTipo1.put("Cena - Paciente Diabético tipo 1 ", alimentosAgregados);
		}
	}
	
	public void agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo2(ComidaDelDia comidaDelDia) {
		ArrayList<AlimentoBase> alimentosAgregados = new ArrayList<AlimentoBase>();
		AlimentoBase alimento1 = null;
		AlimentoBase alimento2 = null;
		AlimentoBase alimento3 = null;
		
		if(comidaDelDia.equals(ComidaDelDia.DESAYUNO)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento3);
			this.menuPacientesDiabeticosTipo2.put("Desayuno - Paciente Diabético tipo 2 ", alimentosAgregados);	
		}
		
		if(comidaDelDia.equals(ComidaDelDia.MERIENDA_MANIANA)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento2);
			this.menuPacientesDiabeticosTipo2.put("Merienda mañana - Paciente Diabético tipo 2 ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.ALMUERZO)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.VERDURAS, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.PROTEINAS, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento3);
			this.menuPacientesDiabeticosTipo2.put("Almuerzo - Paciente Diabético tipo 2 ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.MERIENDA_TARDE)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento2);
			this.menuPacientesDiabeticosTipo2.put("Merienda tarde - Paciente Diabético tipo 2 ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.CENA)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.VERDURAS, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.PROTEINAS, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesDiabeticosTipo2);
			alimentosAgregados.add(alimento3);
			this.menuPacientesDiabeticosTipo2.put("Cena - Paciente Diabético tipo 2 ", alimentosAgregados);
		}
	}
	
	public void agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesCeliacos(ComidaDelDia comidaDelDia) {
		ArrayList<AlimentoBase> alimentosAgregados = new ArrayList<AlimentoBase>();
		AlimentoBase alimento1 = null;
		AlimentoBase alimento2 = null;
		AlimentoBase alimento3 = null;
		
		if(comidaDelDia.equals(ComidaDelDia.DESAYUNO)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento3);
			this.menuPacientesCeliacos.put("Desayuno - Paciente Celíaco ", alimentosAgregados);	
		}
		
		if(comidaDelDia.equals(ComidaDelDia.MERIENDA_MANIANA)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento2);
			this.menuPacientesCeliacos.put("Merienda mañana - Paciente Celíaco ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.ALMUERZO)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.VERDURAS, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.PROTEINAS, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento3);
			this.menuPacientesCeliacos.put("Almuerzo - Paciente Celíaco ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.MERIENDA_TARDE)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento2);
			this.menuPacientesCeliacos.put("Merienda tarde - Paciente Celíaco ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.CENA)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.VERDURAS, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.PROTEINAS, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesCeliacos);
			alimentosAgregados.add(alimento3);
			this.menuPacientesCeliacos.put("Cena - Paciente Celíaco ", alimentosAgregados);
		}
	}
	
	public void agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesOncologicos(ComidaDelDia comidaDelDia) {
		ArrayList<AlimentoBase> alimentosAgregados = new ArrayList<AlimentoBase>();
		AlimentoBase alimento1 = null;
		AlimentoBase alimento2 = null;
		AlimentoBase alimento3 = null;
		
		if(comidaDelDia.equals(ComidaDelDia.DESAYUNO)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento3);
			this.menuPacientesOncologicos.put("Desayuno - Pacientes Oncológico ", alimentosAgregados);	
		}
		
		if(comidaDelDia.equals(ComidaDelDia.MERIENDA_MANIANA)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento2);
			this.menuPacientesOncologicos.put("Merienda mañana - Pacientes Oncológico ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.ALMUERZO)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.VERDURAS, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.PROTEINAS, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento3);
			this.menuPacientesOncologicos.put("Almuerzo - Pacientes Oncológico ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.MERIENDA_TARDE)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento2);
			this.menuPacientesOncologicos.put("Merienda tarde - Pacientes Oncológico ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.CENA)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.VERDURAS, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.PROTEINAS, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesOncologicos);
			alimentosAgregados.add(alimento3);
			this.menuPacientesOncologicos.put("Cena - Pacientes Oncológico ", alimentosAgregados);
		}
	}
	
	public void agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesHipertensos(ComidaDelDia comidaDelDia) {
		ArrayList<AlimentoBase> alimentosAgregados = new ArrayList<AlimentoBase>();
		AlimentoBase alimento1 = null;
		AlimentoBase alimento2 = null;
		AlimentoBase alimento3 = null;
		
		if(comidaDelDia.equals(ComidaDelDia.DESAYUNO)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento3);
			this.menuPacientesHipertensos.put("Desayuno - Paciente Hipertenso ", alimentosAgregados);	
		}
		
		if(comidaDelDia.equals(ComidaDelDia.MERIENDA_MANIANA)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento2);
			this.menuPacientesHipertensos.put("Merienda mañana - Paciente Hipertenso ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.ALMUERZO)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.VERDURAS, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.PROTEINAS, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento3);
			this.menuPacientesHipertensos.put("Almuerzo - Paciente Hipertenso ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.MERIENDA_TARDE)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.FRUTAS, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.LACTEOS, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento2);
			this.menuPacientesHipertensos.put("Merienda tarde - Paciente Hipertenso ", alimentosAgregados);
		}
		
		if(comidaDelDia.equals(ComidaDelDia.CENA)) {
			alimento1 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.VERDURAS, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento1);
			alimento2 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.PROTEINAS, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento2);
			alimento3 = generarEleccionDeAlimentoAleatoriamente(GrupoDeAlimentos.CEREALES_EN_GENERAL, this.alimentosParaPacientesHipertensos);
			alimentosAgregados.add(alimento3);
			this.menuPacientesHipertensos.put("Cena - Paciente Hipertenso ", alimentosAgregados);
		}
	}
	
	public ArrayList<AlimentoBase> getAlimentos(){
		return this.alimentos;
	}
	
	public ArrayList<Paciente> getPacientes(){
		return this.pacientes;
	}
	
	public ArrayList<Paciente> getPacientesGeneral(){
		return this.pacientesGeneral;
	}
	
	public ArrayList<Paciente> getPacientesCelicos(){
		return this.pacientesCeliacos;
	}
	
	public ArrayList<Paciente> getPacientesHipertensos(){
		return this.pacientesHipertensos;
	}
	
	public ArrayList<Paciente> getPacientesOncologicos(){
		return this.pacientesOncologicos;
	}
	
	public ArrayList<Paciente> getPacientesDiabeticosTipo1(){
		return this.pacientesDiabeticosTipo1;
	}
	
	public ArrayList<Paciente> getPacientesDiabeticosTipo2(){
		return this.pacientesDiabeticosTipo2;
	}
	
	public ArrayList<AlimentoBase> getAlimentosParaPacientesGenerales(){
		return this.alimentosParaPacientesGeneral;
	}
	
	public ArrayList<AlimentoBase> getAlimentosParaPacientesHipertensos(){
		return this.alimentosParaPacientesHipertensos;
	}
	
	public ArrayList<AlimentoBase> getAlimentosParaPacientesCeliacos(){
		return this.alimentosParaPacientesCeliacos;
	}
	
	public ArrayList<AlimentoBase> getAlimentosParaPacientesOncologicos(){
		return this.alimentosParaPacientesOncologicos;
	}
	
	public ArrayList<AlimentoBase> getAlimentosParaPacientesDiabeticosTipo1(){
		return this.alimentosParaPacientesDiabeticosTipo1;
	}
	
	public ArrayList<AlimentoBase> getAlimentosParaPacientesDiabeticosTipo2(){
		return this.alimentosParaPacientesDiabeticosTipo2;
	}
		
	public HashMap<String, ArrayList<AlimentoBase>> getMenuParaPacientesGenerales(){
		return this.menuPacientesGeneral;
	}
	
	public HashMap<String, ArrayList<AlimentoBase>> getMenuParaPacientesDiabeticosTipo1(){
		return this.menuPacientesDiabeticosTipo1;
	}
	
	public HashMap<String, ArrayList<AlimentoBase>> getMenuParaPacientesDiabeticosTipo2(){
		return this.menuPacientesDiabeticosTipo2;
	}
	
	public HashMap<String, ArrayList<AlimentoBase>> getMenuParaPacientesCeliacos(){
		return this.menuPacientesCeliacos;
	}
	
	public HashMap<String, ArrayList<AlimentoBase>> getMenuParaPacientesOncologicos(){
		return this.menuPacientesOncologicos;
	}
	
	public HashMap<String, ArrayList<AlimentoBase>> getMenuParaPacientesHipertensos(){
		return this.menuPacientesHipertensos;
	}
}