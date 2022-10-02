package ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio;

public abstract class Preparacion extends AporteEnergetico{

	private TipoDePreparacion tipoDePreparacion;
	private ComidaDelDia comidaDelDia;
	private String nombre;
	private String presentacion;
	
	public Preparacion() {
		super();
		this.tipoDePreparacion = this.getTipoDePreparacion();
		this.comidaDelDia = this.getComidaDelDia();
	}

	public TipoDePreparacion getTipoDePreparacion() {
		return tipoDePreparacion;
	}

	public void setTipoDePreparacion(TipoDePreparacion tipoDePreparacion) {
		this.tipoDePreparacion = tipoDePreparacion;
	}

	public ComidaDelDia getComidaDelDia() {
		return this.comidaDelDia;
	}

	public void setComidaDelDia(ComidaDelDia comidaDelDia) {
		this.comidaDelDia = comidaDelDia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	@Override
	public String toString() {
		return "Preparacion [Tipo de preparación: " + this.tipoDePreparacion + ", Comida del día: " + this.comidaDelDia + ", Nombre: "
				+ this.nombre + ", Presentación: " + this.presentacion + "]";
	}		
}