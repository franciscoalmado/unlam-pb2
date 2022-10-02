package ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio;

public class AlimentoBase extends Preparacion{

	private String nombre;
	private float energia;
	private float carbohidratos;
	private float proteinas;
	private float lipidos;
	private GrupoDeAlimentos grupo;
	private float cantidad;
	private UnidadDeMedida unidad;
	private float contenidoDeAzucar;
	private float cantidadDeSodio;
	private TipoDePreparacion tipoDePreparacion;
	private float totalCarbohidratos;
	private float totalProteinas;
	private float totalLipidos;
	
	public AlimentoBase(String nombre, float carbohidratos, float proteinas, float lipidos,
			GrupoDeAlimentos grupo, float cantidad, UnidadDeMedida unidad, float indiceGlucemico,
			float cantidadDeSodio, TipoDePreparacion tipoDePreparacion) {
		super();
		this.nombre = nombre;
		this.energia = this.getEnergia();
		this.carbohidratos = carbohidratos;
		this.proteinas = proteinas;
		this.lipidos = lipidos;
		this.grupo = grupo;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.contenidoDeAzucar = indiceGlucemico;
		this.cantidadDeSodio = cantidadDeSodio;
		this.tipoDePreparacion = tipoDePreparacion;
		this.totalCarbohidratos = 0.0f;
		this.totalProteinas = 0.0f;
		this.totalLipidos = 0.0f;
	}
		
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getEnergia() {
		return this.energia;
	}

	public void setEnergia(float energia) {
		this.energia = energia;
	}

	public float getCarbohidratos() {
		return this.carbohidratos;
	}

	public void setCarbohidratos(float carbohidratos) {
		this.carbohidratos = carbohidratos;
	}

	public float getProteinas() {
		return this.proteinas;
	}

	public void setProteinas(float proteinas) {
		this.proteinas = proteinas;
	}

	public float getLipidos() {
		return this.lipidos;
	}

	public void setLipidos(float lipidos) {
		this.lipidos = lipidos;
	}

	public GrupoDeAlimentos getGrupo() {
		return this.grupo;
	}

	public void setGrupo(GrupoDeAlimentos grupo) {
		this.grupo = grupo;
	}

	public float getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public UnidadDeMedida getUnidad() {
		return this.unidad;
	}

	public void setUnidad(UnidadDeMedida unidad) {
		this.unidad = unidad;
	}

	public float getContenidoDeAzucar() {
		return this.contenidoDeAzucar;
	}

	public void setContenidoDeAzucar(float contenidoDeAzucar) {
		this.contenidoDeAzucar = contenidoDeAzucar;
	}
	
	public float getContenidoDeSodio() {
		return this.cantidadDeSodio;
	}

	public void setContenidoDeSodio(float contenidoDeSal) {
		this.cantidadDeSodio = contenidoDeSal;
	}
		
	public void calcularEnergia() {	
		this.energia = this.carbohidratos + this.proteinas + this.lipidos;	
	}

	public void calcularCarbohidratos() {
		float kcal = 4.0f;
		
		this.totalCarbohidratos = this.carbohidratos * kcal;
	}

	public void calcularProteinas() {
		float kcal = 4.0f;
		
		this.totalProteinas = this.proteinas * kcal;
	}

	public void calcularLipidos() {
		float kcal = 9.0f;
		
		this.totalLipidos = this.lipidos * kcal;				
	}
	
	public float getTotalCarbohidratos() {
		return this.totalCarbohidratos;
	}

	public float getTotalProteinas() {
		return this.totalProteinas;
	}

	public float getTotalLipidos() {
		return this.totalLipidos;
	}
		
	public TipoDePreparacion getTipoDePreparacion() {
		return this.tipoDePreparacion;
	}

	public void setTipoDePreparacion(TipoDePreparacion tipoDePreparacion) {
		this.tipoDePreparacion = tipoDePreparacion;
	}

	@Override
	public String toString() {
		return "AlimentoBase [Nombre: " + this.getNombre() + ", Cantidad de energía que aporta: " + this.getEnergia() + " kcal" + ", Grupo de Alimento: " + this.getGrupo() + 
				", Contenido de azúcar que aporta: " + this.getContenidoDeAzucar() + ", Contenido de sal: " + this.getContenidoDeSodio() + ", Tipo de Preparación: " + this.getTipoDePreparacion() + "]";
	}
}