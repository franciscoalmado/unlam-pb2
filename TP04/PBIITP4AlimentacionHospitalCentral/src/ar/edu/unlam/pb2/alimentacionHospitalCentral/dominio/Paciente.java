package ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio;

public abstract class Paciente{

	private String nombre;
	private String apellido;
	private Genero genero;
	private int edad;
	private int estatura;
	private double peso;
	private TipoDeActividad tipoDeActividad;
	private TipoDePaciente tipoDePaciente;
	private int numeroDeHabitacion;
	private double gastoDeEnergiaTotal;
	private double gastoDeEnergiaBasal;

	public Paciente(String nombre, String apellido, Genero genero, int edad, int estatura, double peso, TipoDeActividad tipoDeActividad, TipoDePaciente tipoDePaciente, int numeroDeHabitacion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.edad = edad;
		this.estatura = estatura;
		this.peso = peso;
		this.tipoDeActividad = tipoDeActividad;
		this.tipoDePaciente = tipoDePaciente;
		this.numeroDeHabitacion = numeroDeHabitacion;
		this.calcularGastoDeEnergiaBasal();
		this.calcularGastoDeEnergiaTotal();
	}
	
	/*
	 * Determina el Gasto de Energía Total de cada paciente en base a la edad, sexo, peso (kg), estatura (cm) y nivel de actividad que realiza. 
	 * La Ecuación es:
	 *      GET = GEB x FA
	 * GEB: Gasto de Energía Basal
	 * FA: Nivel de actividad del individuo. 
	 * 		30% - Sedentaria.
	 * 		50% - Moderada.
	 * 		100% - Extrema.
	 */
	public void calcularGastoDeEnergiaTotal() {
		
		if(tipoDeActividad.equals(TipoDeActividad.SEDENTARIA)) {
			this.gastoDeEnergiaTotal = TipoDeActividad.SEDENTARIA.getValor();
		}

		if(tipoDeActividad.equals(TipoDeActividad.MODERADA)) {
			this.gastoDeEnergiaTotal = TipoDeActividad.MODERADA.getValor();
		}
		
		if(tipoDeActividad.equals(TipoDeActividad.EXTREMA)) {
			this.gastoDeEnergiaTotal = TipoDeActividad.EXTREMA.getValor();
		}
	}
	
	/*
	 * Gasto de Energía Basal según Ecuación de Harris Benedict:
	 * 
	 *  Para mujer:
	 *  	GEB = 655 + 9.6 * peso + 1.8 * estatura - 4.7 * edad
	 *  
	 *  Para hombre:
	 *  	GEB = 66 + 13.7 * peso + 5.0 * estatura - 6.8 * edad	
	 */
	public void calcularGastoDeEnergiaBasal() {
		int valor1 = 655;
		double valor2 = 9.6;
		double valor3 = 1.8;
		double valor4 = 4.7;
		int valor5 = 66;
		double valor6 = 13.7;
		double valor7 = 5.0;
		double valor8 = 6.8;
		
		if(this.genero.equals(Genero.FEMENINO)) {
			this.gastoDeEnergiaBasal = valor1 + valor2 * this.peso + valor3 * this.estatura - valor4 * this.edad;
		}
		if(this.genero.equals(Genero.MASCULINO)) {
			this.gastoDeEnergiaBasal = valor5 + valor6 * this.peso + valor7 * this.estatura - valor8 * this.edad;
		}	
	}
	
	/*
	 * Métodos Getters and Setters con los datos del paciente.
	 */
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getNumeroDeHabitacion() {
		return this.numeroDeHabitacion;
	}

	public void setNumeroDeHabitacion(int numeroDeHabitacion) {
		this.numeroDeHabitacion = numeroDeHabitacion;
	}
	
	public double getGastoDeEnergiaTotal() {
		return this.gastoDeEnergiaTotal;
	}
	
	public double getGastoDeEnergiaBasal() {
		return this.gastoDeEnergiaBasal;
	}
	
	public TipoDePaciente getTipoDePaciente() {
		return this.tipoDePaciente;
	}

	@Override
	public abstract String toString();
}