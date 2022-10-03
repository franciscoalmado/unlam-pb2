package ar.edu.unlam.pb2.carritoDeCompras.dominio;

public class Item {

	private ProductoEspecifico producto;
	private int cantidad;
	
	public Item(ProductoEspecifico producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(ProductoEspecifico producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Item [Producto: " + this.producto + ", Cantidad: " + this.cantidad + "]";
	}
}