package ar.edu.unlam.pb2.carritoDeCompras.interfaz;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unlam.pb2.carritoDeCompras.dominio.CarritoDeCompras;
import ar.edu.unlam.pb2.carritoDeCompras.dominio.CategoriaDeProducto;
import ar.edu.unlam.pb2.carritoDeCompras.dominio.Item;
import ar.edu.unlam.pb2.carritoDeCompras.dominio.Producto;
import ar.edu.unlam.pb2.carritoDeCompras.dominio.ProductoEspecifico;

public class InterfazCarritoDeCompras {
	
	static Scanner teclado = new Scanner(System.in);
	private static CarritoDeCompras carritoDeCompras = new CarritoDeCompras();
	private static CategoriaDeProducto categoria;
	private static Producto producto;
	private static Item item;
	
	public static void main(String[] args) {
		
		int opcion = 0;
		int salir = 9;
		
		do {
			opcion = seleccionarUnaOpcion();
			
			switch(opcion) {
				case 1:
					agregarProductoAlCarrito();	
				break;
				case 2:
					mostrarVistaPreviaDeElementosAComprar(carritoDeCompras.getItems());	
				break;
				case 3:
					mostrarTicketDeCompra(carritoDeCompras.getItems(), categoria);	
				break;
				case 9:
					System.out.println("Usted ha salido del sistema");
				break;
				default:
					System.out.println("Opción inválida. Inténtelo de nuevo");
				break;
			}
			
		}while(opcion != salir);
	}
	
	private static int seleccionarUnaOpcion() {	
		int opcion = 0;
		
		System.out.println("\nBienvenidos al sistema de compras online: ");
		System.out.println("1 - Agregar producto al carrito");
		System.out.println("2 - Vista previa de elementos a comprar");
		System.out.println("3 - Mostrar ticket de compra");
		System.out.println("9 - Salir del sistema" + "\n");
		
		opcion = teclado.nextInt();
		
		return opcion;
	} 
	
	private static void agregarProductoAlCarrito() {	
		String nombre = "";
		double precio = 0.0;
		int cantidad = 0;
		
		System.out.println("Ingrese el nombre del producto: ");
		nombre = teclado.next();
		
		System.out.println("Ingrese el precio del producto: ");
		precio = teclado.nextDouble();
		
		categoria = elegirCategoriaDeProducto();
		
		System.out.println("Ingrese la cantidad de productos que desea: ");
		cantidad = teclado.nextInt();
		
		producto = new ProductoEspecifico(nombre, precio);
		
		((ProductoEspecifico) producto).setCategoriaDeProducto(categoria);
		((ProductoEspecifico) producto).setCodigo();
		((ProductoEspecifico) producto).setNombre(nombre);
		((ProductoEspecifico) producto).setPrecio(precio);
		((ProductoEspecifico) producto).getCategoriaDeProducto();
		item = new Item(((ProductoEspecifico) producto), cantidad);
		carritoDeCompras.ingresarItem(item);
		obtenerDescuento(categoria, precio, cantidad);
	}
	
	private static CategoriaDeProducto elegirCategoriaDeProducto() {
		CategoriaDeProducto categoriaElejida = null;
		int opcion = 0;
		
		do {
			System.out.println("Elija una categoría de producto: ");
			System.out.println("1 - Calzado");
			System.out.println("2 - Celulares y Smartphones");
			System.out.println("3 - Televisores");
			opcion = teclado.nextInt();
		}while(opcion < 1 && opcion > 12);
		
		switch(opcion) {
			case 1:
				categoriaElejida = CategoriaDeProducto.CALZADO;
			break;
			case 2:
				categoriaElejida = CategoriaDeProducto.CELULARES_Y_SMARTPHONES;
			break;
			case 3:
				categoriaElejida = CategoriaDeProducto.TELEVISORES;
			break;
			case 4:
				categoriaElejida = CategoriaDeProducto.AIRES_ACONDICIONADO;
			break;
			case 5:
				categoriaElejida = CategoriaDeProducto.CALEFACCION;
			break;
			case 6:
				categoriaElejida = CategoriaDeProducto.CAMARAS_Y_ACCESORIOS;
			break;
			case 7:
				categoriaElejida = CategoriaDeProducto.COCINAS;
			break;
			case 8:
				categoriaElejida = CategoriaDeProducto.COMPUTACION;
			break;
			case 9:
				categoriaElejida = CategoriaDeProducto.CONSOLAS_Y_VIDEOJUEGOS;
			break;
			case 10:
				categoriaElejida = CategoriaDeProducto.ELECTRONICA_AUDIO_VIDEO;
			break;
			case 11:
				categoriaElejida = CategoriaDeProducto.HELADERA;
			break;
			case 12:
				categoriaElejida = CategoriaDeProducto.LAVARROPAS;
			break;
		}
		
		return categoriaElejida;
	}
	
	private static double obtenerDescuento(CategoriaDeProducto categoria, double precioBase, int cantidadDeProductosAComprar) {
		double descuento = 0.0;
		double descuentoPorCantidad = 0.10;
		int cantidadAlPorMayor = 5;
		
		if(categoria.equals(CategoriaDeProducto.CALZADO) && cantidadDeProductosAComprar >= cantidadAlPorMayor){
			descuento = precioBase * descuentoPorCantidad;
		}else {
			descuento = precioBase;
		}
		
		return descuento;
	}
	
	private static void mostrarTicketDeCompra(ArrayList<Item> items, CategoriaDeProducto categoria) {
		String codigo = "";
		String producto = "";
		int cantidad = 0;
		double precioBase = 0.0;
		double precioFinal = 0.0;
		double montoTotal = 0;
		
		for(Item item : items) {	
			codigo = item.getProducto().getCodigo();
			producto = item.getProducto().getNombre();
			cantidad = item.getCantidad();
			precioBase = item.getProducto().getPrecio();
			precioFinal = precioBase - obtenerDescuento(categoria, item.getProducto().getPrecio(), cantidad);		
			
			System.out.println("Código: " + codigo);
			System.out.println("Nombre: " + producto);
			System.out.println("Precio base: " + "$ " + precioBase);
			System.out.println("Precio con descuento: " + "$ " + precioFinal);
			System.out.println("Cantidad: " + cantidad);
			
			if(precioFinal == 0) {
				precioFinal = precioBase;
				System.out.println("Subtotal: " + "$ " + precioFinal * cantidad);
			}else {
				System.out.println("Subtotal: " + "$ " + precioFinal * cantidad);	
			}
			
			System.out.println("------------------------------------------");
			
			montoTotal += precioFinal * cantidad;	
		}
		
		System.out.println("==========================================");
		
		System.out.println("Total: " + "$ " + montoTotal);
	}
	
	private static void mostrarVistaPreviaDeElementosAComprar(ArrayList<Item> items) {		
		for(Item item : items) {
			System.out.println(item.toString());
		}
	}
}