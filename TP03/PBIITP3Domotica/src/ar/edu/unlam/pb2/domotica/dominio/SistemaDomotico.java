package ar.edu.unlam.pb2.domotica.dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class SistemaDomotico {

	private boolean isConfigurado;
	private boolean isActivado;
	private Edificio edificio;
	private ArrayList<Persona> personas;
	private ArrayList<Persona> personasQueIngresan;
	private ArrayList<Persona> personasQueEgresan;
	private ArrayList<Persona> personasQueUsanAscensorParaSubir;
	private ArrayList<Persona> personasQueUsanAscensorParaBajar;
	private ArrayList<Persona> empleadosQueIngresanASuPisoDeTrabajo;
	private ArrayList<Persona> empleadosQueEgresanASuPisoDeTrabajo;
	
	public SistemaDomotico() {
		this.isConfigurado = false;
		this.isActivado = false;
		this.personas = new ArrayList<Persona>();
		this.personasQueIngresan = new ArrayList<Persona>();
		this.personasQueEgresan = new ArrayList<Persona>();
		this.personasQueUsanAscensorParaSubir = new ArrayList<Persona>();
		this.personasQueUsanAscensorParaBajar = new ArrayList<Persona>();
		this.empleadosQueIngresanASuPisoDeTrabajo = new ArrayList<Persona>();
		this.empleadosQueEgresanASuPisoDeTrabajo = new ArrayList<Persona>(); 
	}
	
	public void configurarSistema(Edificio edificioQueSirve) {
		
		this.edificio = new Edificio(edificioQueSirve.getNombre(), edificioQueSirve.getPISO_MINIMO(), edificioQueSirve.getPISO_MAXIMO(), edificioQueSirve.getCantidadDeAscensores());
		
		if(this.edificio != null) {
			this.isConfigurado = true;
		}		
	}
	
	public void activarSistema() {		
		if(this.isConfigurado) {
			this.isActivado = true;
		}	
	}
	
	public void ingresarPersona(Persona persona) {
		
		if(this.getIsActivado()) {
			this.personas.add(persona);		
		}
	}
		
	public void registrarIngresoDePersonas(Persona personaQueIngresa, LocalDate fecha) {
		
		if(this.getIsActivado()) {
			for(Persona personaBuscada : this.personas) {
				if(personaBuscada.getTipo().equals(TipoDeIdentificacion.EMPLEADO) && personaBuscada.equals(personaQueIngresa)) {
					personaBuscada.setFechaDeIngreso(fecha);
					this.personasQueIngresan.add(personaBuscada);
				}
				if(personaBuscada.getTipo().equals(TipoDeIdentificacion.CLIENTE) && personaBuscada.equals(personaQueIngresa)) {
					personaBuscada.setFechaDeIngreso(fecha);
					this.personasQueIngresan.add(personaBuscada);
				}
			}
		}		
	}
	
	public void registrarEgresoDePersonas(Persona personaQueEgresa, LocalTime tiempoRegistrado) {
		
		if(this.getIsActivado()) {
			for(Persona personaBuscada : this.personas) {
				if(personaBuscada.getTipo().equals(TipoDeIdentificacion.CLIENTE) && personaBuscada.equals(personaQueEgresa)) {
					personaBuscada.setTiempoRegistrado(tiempoRegistrado);
					this.personasQueEgresan.add(personaBuscada);
				}
			}	
		}		
	}
	
	public void registarIngresoDeEmpleadosASuAreaDeTrabajo(Persona empleadoQueIngresa, int piso) {
		
		if(this.getIsActivado()) {
			for(Persona personaBuscada : this.personas) {
				if(personaBuscada.getTipo().equals(TipoDeIdentificacion.EMPLEADO) && personaBuscada.equals(empleadoQueIngresa)) {
					personaBuscada.setPisoVisitado(piso);
					this.empleadosQueIngresanASuPisoDeTrabajo.add(personaBuscada);
				}
			}
		}		
	}
	
	public void registarEgresoDeEmpleadosASuAreaDeTrabajo(Persona empleadoQueEgresa, int piso, LocalTime tiempoRegistrado) {
		
		if(this.getIsActivado()) {
			for(Persona personaBuscada : this.personas) {
				if(personaBuscada.getTipo().equals(TipoDeIdentificacion.EMPLEADO) && personaBuscada.equals(empleadoQueEgresa)) {
					personaBuscada.setTiempoRegistrado(tiempoRegistrado);
					this.empleadosQueEgresanASuPisoDeTrabajo.add(personaBuscada);
				}
			}	
		}		
	}
	
	public void registrarPersonaQueSubeAlAscensor(Persona personaQueSube, int piso, int numeroDeAscensor) throws Exception {	

		if(this.getIsActivado()) {			
			this.edificio.usarAscensorParaSubir(personaQueSube, piso, numeroDeAscensor);
			this.personasQueUsanAscensorParaSubir.add(personaQueSube);
		}	
	}
	
	public void registrarPersonaQueBajaDelAscensor(Persona personaQueBaja, int piso, int numeroDeAscensor) throws Exception{	

		if(this.getIsActivado()) {
			this.edificio.usarAscensorParaBajar(personaQueBaja, piso, numeroDeAscensor);
			this.personasQueUsanAscensorParaBajar.add(personaQueBaja);
		}					
	}
	
	public ArrayList<Persona> listarEmpleadosAusentes(LocalDate fecha){
		ArrayList<Persona> empleadosAusentes = new ArrayList<Persona>();
		
		if(this.getIsActivado()) {
			for(Persona empleadoBuscado : this.empleadosQueIngresanASuPisoDeTrabajo) {
				if(!empleadoBuscado.getFechaDeIngreso().equals(fecha)) {
					empleadosAusentes.add(empleadoBuscado);
				}
			}
		}
		
		return empleadosAusentes;
	}
	
	public boolean getIsActivado() {
		return this.isActivado;
	}
	
	public ArrayList<Persona> getPersonasQueIngresan(){
		return this.personasQueIngresan;
	}
	
	public ArrayList<Persona> getPersonasQueEgresan(){
		return this.personasQueEgresan;
	}
	
	public ArrayList<Persona> getPersonasQueSuben(){
		return this.personasQueUsanAscensorParaSubir;
	}
	
	public ArrayList<Persona> getPersonasQueBajan(){
		return this.personasQueUsanAscensorParaBajar;
	}
	
	public ArrayList<Persona> getEmpleadosQueIngresanASuAreaDeTrabajo(){
		return this.empleadosQueIngresanASuPisoDeTrabajo;
	}
	
	public ArrayList<Persona> getEmpleadosQueSalenDeSuAreaDeTrabajo(){
		return this.empleadosQueEgresanASuPisoDeTrabajo;
	}
}