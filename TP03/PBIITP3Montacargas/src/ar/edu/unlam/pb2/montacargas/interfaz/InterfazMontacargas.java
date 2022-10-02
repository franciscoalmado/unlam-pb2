package ar.edu.unlam.pb2.montacargas.interfaz;

import ar.edu.unlam.pb2.montacargas.dominio.Montacargas;

public class InterfazMontacargas {

	public static void main(String[] args) {
		
		Montacargas montacargaCatModeloDP55N = new Montacargas(5500);
		
		System.out.println("Peso máximo: " +montacargaCatModeloDP55N.getPesoMaximo() + " kg");
		System.out.println("Peso añadido: " +montacargaCatModeloDP55N.getSumaDeCargas() + " kg");
		
		try {
			montacargaCatModeloDP55N.incorporarCargas(300);
			montacargaCatModeloDP55N.incorporarCargas(600);
			montacargaCatModeloDP55N.incorporarCargas(500);
			montacargaCatModeloDP55N.incorporarCargas(800);
			montacargaCatModeloDP55N.incorporarCargas(700);
			montacargaCatModeloDP55N.incorporarCargas(1000);
			montacargaCatModeloDP55N.incorporarCargas(1000);
			montacargaCatModeloDP55N.incorporarCargas(700);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
		
		System.out.println("Peso añadido: " +montacargaCatModeloDP55N.getSumaDeCargas() + " kg");
	}
}