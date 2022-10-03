package ar.edu.unlam.pb2.carritoDeCompras.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.carritoDeCompras.dominio.CarritoDeCompras;
import ar.edu.unlam.pb2.carritoDeCompras.dominio.CategoriaDeProducto;
import ar.edu.unlam.pb2.carritoDeCompras.dominio.Item;
import ar.edu.unlam.pb2.carritoDeCompras.dominio.Producto;
import ar.edu.unlam.pb2.carritoDeCompras.dominio.ProductoEspecifico;

public class TestCarritoDeCompras {

	@Test
	public void queSePuedaCrearUnCarritoDeCompras() {
		CarritoDeCompras carritoDeCompras = new CarritoDeCompras();
		
		assertNotNull(carritoDeCompras);
	}
	
	@Test
	public void queSePuedaCrearUnProducto() {
		Producto producto1 = new ProductoEspecifico("Zapatillas Nike", 23999.0);
		producto1.setCodigo();
		producto1.setNombre("Zapatillas Nike");
		producto1.setPrecio(23999.0);
		
		Producto producto2 = new ProductoEspecifico("TV LG 45 pulgadas", 115999.0);
		producto2.setCodigo();
		producto2.setNombre("TV LG 45 pulgadas");
		producto2.setPrecio(115999.0);

		Producto producto3 = new ProductoEspecifico("Smartphone Moto G7", 76522.0);
		producto3.setCodigo();
		producto3.setNombre("Smartphone Moto G7");
		producto3.setPrecio(76522.0);
		
		assertNotNull(producto1);
		assertNotNull(producto2);
		assertNotNull(producto3);
	}
	
	@Test
	public void queSePuedaCrearuUnItemDeCompra() {
		CarritoDeCompras carritoDeCompras = new CarritoDeCompras();
		
		Producto producto1 = new ProductoEspecifico("Zapatillas Nike", 23999.0);
		if(producto1 instanceof ProductoEspecifico) {
			((ProductoEspecifico) producto1).setCategoriaDeProducto(CategoriaDeProducto.CALZADO);
			((ProductoEspecifico) producto1).setCodigo();
			((ProductoEspecifico) producto1).getCategoriaDeProducto();
			Item item1 = new Item(((ProductoEspecifico) producto1), 5);
			carritoDeCompras.ingresarItem(item1);
		}
		
		Producto producto2 = new ProductoEspecifico("TV LG 45 pulgadas", 115999.0);
		if(producto2 instanceof ProductoEspecifico) {
			((ProductoEspecifico) producto2).setCategoriaDeProducto(CategoriaDeProducto.TELEVISORES);
			((ProductoEspecifico) producto2).setCodigo();
			Item item2 = new Item(((ProductoEspecifico) producto2), 1);
			carritoDeCompras.ingresarItem(item2);
		}

		Producto producto3 = new ProductoEspecifico("Smartphone Moto G7", 76522.0);
		if(producto3 instanceof ProductoEspecifico) {
			((ProductoEspecifico) producto3).setCategoriaDeProducto(CategoriaDeProducto.CELULARES_Y_SMARTPHONES);
			((ProductoEspecifico) producto3).setCodigo();
			Item item3 = new Item(((ProductoEspecifico) producto3), 1);
			carritoDeCompras.ingresarItem(item3);
		}
	}
}