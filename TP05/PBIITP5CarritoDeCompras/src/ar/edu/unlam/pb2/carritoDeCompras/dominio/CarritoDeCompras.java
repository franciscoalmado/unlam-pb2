package ar.edu.unlam.pb2.carritoDeCompras.dominio;

import java.util.ArrayList;

public class CarritoDeCompras {

	private ArrayList<Item> items;
	
	public CarritoDeCompras() {
		this.items = new ArrayList<Item>();
	}
	
	public void ingresarItem(Item item) {
		
		this.items.add(item);
	}
	
	public void removerItem(Item item) {
		
		this.items.remove(item);
	}
	
	public ArrayList<Item> getItems(){
		return this.items;
	}
}