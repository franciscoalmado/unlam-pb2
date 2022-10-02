package ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio;

public class DiabeticoTipo2 extends Paciente{

	private TipoDePaciente tipoDePaciente;
	private boolean recibioSuDosisDiariaDeInsulina;

	public DiabeticoTipo2(String nombre, String apellido, Genero genero, int edad, int estatura, double peso,
			TipoDeActividad tipoDeActividad, TipoDePaciente tipoDePaciente, int numeroDeHabitacion) {
		super(nombre, apellido, genero, edad, estatura, peso, tipoDeActividad, tipoDePaciente, numeroDeHabitacion);
		this.tipoDePaciente = TipoDePaciente.DIABETICO_TIPO_2;
		this.getRecibioSuDosisDiariaDeInsulina();
	}

	public TipoDePaciente getTipoDePaciente() {
		return tipoDePaciente;
	}
	
	public void darDosisDiariaDeInsulina(boolean isDosisDiaria) {
		this.recibioSuDosisDiariaDeInsulina = isDosisDiaria;
	}
	
	public boolean getRecibioSuDosisDiariaDeInsulina() {
		return this.recibioSuDosisDiariaDeInsulina;
	}
	
	@Override
	public String toString() {
		return "Paciente [Nombre: " + this.getNombre() + ", Apellido: " + this.getApellido() + ", Nro. Habitación: " + this.getNumeroDeHabitacion() + 
				", Tipo de paciente: " + this.tipoDePaciente + ", Recibió su dosis diaria de insulina: " + this.recibioSuDosisDiariaDeInsulina +"]";
	}
}