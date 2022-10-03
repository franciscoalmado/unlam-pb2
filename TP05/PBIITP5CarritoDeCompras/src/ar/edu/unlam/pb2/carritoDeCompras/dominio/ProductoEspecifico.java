package ar.edu.unlam.pb2.carritoDeCompras.dominio;

public class ProductoEspecifico extends Producto {

	private CategoriaDeProducto categoria;
	
	public ProductoEspecifico(String nombre, double precio) {
		super(nombre, precio);
		this.categoria = this.getCategoriaDeProducto();
	}
	
	public void setCategoriaDeProducto(CategoriaDeProducto categoria) {		
		this.categoria = categoria;
	}
	
	public CategoriaDeProducto getCategoriaDeProducto() {
		return this.categoria;
	}
	
	public String toString() {
		return "" + this.getCodigo() + ", Nombre: " + this.getNombre() + 
				", Precio: " + this.getPrecio() + ", Categoría: " + this.categoria + "";
	}
}