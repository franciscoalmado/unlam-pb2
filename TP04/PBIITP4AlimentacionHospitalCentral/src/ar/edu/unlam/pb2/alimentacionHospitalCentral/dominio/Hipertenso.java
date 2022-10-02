package ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio;

public class Hipertenso extends Paciente {

	private TipoDePaciente tipoDePaciente;
	
	public Hipertenso(String nombre, String apellido, Genero genero, int edad, int estatura, double peso,
			TipoDeActividad tipoDeActividad, TipoDePaciente tipoDePaciente, int numeroDeHabitacion) {
		super(nombre, apellido, genero, edad, estatura, peso, tipoDeActividad, tipoDePaciente, numeroDeHabitacion);
		this.tipoDePaciente = TipoDePaciente.HIPERTENSO;
	}

	public TipoDePaciente getTipoDePaciente() {
		return tipoDePaciente;
	}
	
	@Override
	public String toString() {
		return "Paciente [Nombre: " + this.getNombre() + ", Apellido: " + this.getApellido() + ", Nro. Habitación: " + this.getNumeroDeHabitacion() + 
				", Tipo de paciente: " + this.getTipoDePaciente() + "]";
	}
}