package ar.edu.unlam.pb2.callCenter.dominio;

public class Empresa {

	private int zonasDeCobertura[];
	private String nombreEmpresa;
	private Contacto[] contactos;
	private int cantidadMaximaDeContactos;
	private int cantidadDeContactos;
 	
	public Empresa(String nombreEmpresa, int cantidadDeZonasDeCobertura, int cantidadDeContactos) {
		this.nombreEmpresa = nombreEmpresa;
		this.zonasDeCobertura = new int[cantidadDeZonasDeCobertura];
		this.cantidadMaximaDeContactos = cantidadDeContactos;
		this.contactos = new Contacto[this.cantidadMaximaDeContactos];
		this.cantidadDeContactos = 0;
	}
	
	public String getNombreEmpresa() {		
		return this.nombreEmpresa;
	}
	
	/*
	 * Agrega un nuevo contacto al registro de la empresa
	 */
	public boolean agregarNuevoContacto(Contacto nuevo) {

		boolean contactoAgregado = false;
		
		if(this.cantidadDeContactos < this.cantidadMaximaDeContactos && verificarSiElContactoExiste(nuevo) == null) {
			this.contactos[this.cantidadDeContactos++] = nuevo;
			contactoAgregado = true;
		}
		
		return contactoAgregado;
	}
	
	private Contacto verificarSiElContactoExiste(Contacto nuevo) {
		
		for(int i=0; i < this.contactos.length; i++) {
			if(this.contactos[i] != null && this.contactos[i].getEmail().compareTo(nuevo.getEmail()) == 0) {
				return this.contactos[i];
			}
		}
		
		return null;
	}
	
	/*
	 * Agrega una nueva zona de cobertura, identificada por el código postal
	 */	
	public boolean agregarNuevaZonaDeCobertura(int codigoPostal) {

		boolean zonaAgregada = false;
		
		for(int i=0; i < this.zonasDeCobertura.length; i++) {
			if(this.zonasDeCobertura[i] == 0 && elCodigoPostalEstaDentroDeLaZonaDeCobertura(codigoPostal) == false) {
				this.zonasDeCobertura[i] = codigoPostal;
				zonaAgregada = true;
				break;
			}
		}		
		
		return zonaAgregada;
	}

	/*
	 * Determina si un código postal está dentro de la zona de cobertura
	 */
	private boolean elCodigoPostalEstaDentroDeLaZonaDeCobertura(int codigoPostal) {

		boolean isEnLaZonaDeCobertura = false;
		
		for(int i=0; i < this.zonasDeCobertura.length; i++) {
			if(this.zonasDeCobertura[i] != 0 && this.zonasDeCobertura[i] == codigoPostal) {
				isEnLaZonaDeCobertura = true;
				break;
			}
		}

		return isEnLaZonaDeCobertura;
	}

	/*
	 * Busca un contacto para poder ser llamado, mediante los siguientes criterios: 
	 * - No debe ser cliente aún.
	 * - Indica que desea ser llamado o al menos no informó lo contrario.
	 * - El código postal del contacto debe existir en las zonas de cobertura existente.
	 * - De los contactos que cumplan los 3 criterios anteriores, se debe seleccionar uno aleatoriamente.
	 */
	public Contacto buscarCandidato() {

		Contacto contacto = null;
		int candidato = 0;
		
		do {
			candidato = (int) (Math.random()*this.contactos.length);
			contacto = seleccionarUnContactoAleatoriamente(candidato);			
		}while(contacto == null);	
		
		return contacto;
	}
	
	private Contacto seleccionarUnContactoAleatoriamente(int posicion) {
		for(int i=0; i < this.contactos.length; i++) {
			if(this.contactos[posicion] != null && this.contactos[posicion].isCliente() == false && this.contactos[posicion].isDeseaSerLlamadoNuevamente() == true && elCodigoPostalEstaDentroDeLaZonaDeCobertura(this.contactos[posicion].obtenerCodigoPostal()) == true) {				
				return this.contactos[posicion];
			}		
		}
		return null;
	}
	
	public Contacto[] getContactos() {
		return this.contactos;
	}
	
	public int getCantidadDeContactos() {
		return this.cantidadDeContactos;
	}
	
	public int[] getZonasDeCoberturas() {
		return this.zonasDeCobertura;
	}
}