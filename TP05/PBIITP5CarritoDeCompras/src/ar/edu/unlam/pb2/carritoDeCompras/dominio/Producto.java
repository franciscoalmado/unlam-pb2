package ar.edu.unlam.pb2.carritoDeCompras.dominio;

public abstract class Producto {

	private String codigo;
	private String nombre;
	private double precio;
	
	public Producto(String nombre, double precio) {
		this.codigo = this.getCodigo();
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo() {
		
		CodigoDeBarras codigoDeBarras = new CodigoDeBarras();
		
		this.codigo = codigoDeBarras.getCodigoDeBarras();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public abstract String toString();
}