package ar.edu.unlam.pb2.tableroKanban.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.tableroKanban.dominio.EstadoDeTarea;
import ar.edu.unlam.pb2.tableroKanban.dominio.TableroKanban;
import ar.edu.unlam.pb2.tableroKanban.dominio.Tarea;
import ar.edu.unlam.pb2.tableroKanban.dominio.Usuario;

public class TestTableroKanban {

	@Test
	public void queSePuedaCrearUnaTarea() {
		Usuario usuario = new Usuario("david", "David", "Martínez");
		Tarea tarea = new Tarea("Task 1", EstadoDeTarea.PENDIENTE, usuario);
		TableroKanban tableroKanban = new TableroKanban(10, 5);
		
		assertNotNull(tarea);
		assertNotNull(usuario);
		assertNotNull(tableroKanban);
		
		assertTrue(tableroKanban.registrarUsuario(usuario));
		assertTrue(tableroKanban.crearTarea(tarea, usuario));	
	}
	
	@Test
	public void queNoSePuedaAgregarUnUsuarioQueYaExista() {
		Usuario usuario1 = new Usuario("david", "David", "Martínez");
		Usuario usuario2 = new Usuario("david", "John", "Casteló");
		TableroKanban tableroKanban = new TableroKanban(10, 5);
		
		assertNotNull(usuario1);
		assertNotNull(usuario2);
		assertNotNull(tableroKanban);
				
		assertTrue(tableroKanban.registrarUsuario(usuario1));
		assertFalse(tableroKanban.registrarUsuario(usuario2));
	}
	
	@Test
	public void queSePuedaComenzarUnaTarea() {
		Usuario usuario1 = new Usuario("david", "David", "Martínez");
		Usuario usuario2 = new Usuario("john", "John", "Casteló");
		Tarea tarea1 = new Tarea("Task 1", EstadoDeTarea.PENDIENTE, usuario1);
		Tarea tarea2 = new Tarea("Task 2", EstadoDeTarea.PENDIENTE, usuario2);
		Tarea tarea3 = new Tarea("Task 3", EstadoDeTarea.PENDIENTE, usuario1);
		Tarea tarea4 = new Tarea("Task 4", EstadoDeTarea.PENDIENTE, usuario1);
		Tarea tarea5 = new Tarea("Task 5", EstadoDeTarea.PENDIENTE, usuario2);
		TableroKanban tableroKanban = new TableroKanban(10, 5);
		
		assertNotNull(tarea1);
		assertNotNull(tarea2);
		assertNotNull(tarea3);
		assertNotNull(tarea4);
		assertNotNull(tarea5);
		assertNotNull(usuario1);
		assertNotNull(usuario2);
		assertNotNull(tableroKanban);
		
		assertTrue(tableroKanban.registrarUsuario(usuario1));
		assertTrue(tableroKanban.registrarUsuario(usuario2));
		
		assertTrue(tableroKanban.crearTarea(tarea1, usuario1));
		assertTrue(tableroKanban.crearTarea(tarea2, usuario2));
		assertTrue(tableroKanban.crearTarea(tarea3, usuario1));
		assertTrue(tableroKanban.crearTarea(tarea4, usuario1));
		assertTrue(tableroKanban.crearTarea(tarea5, usuario2));
		
		assertTrue(tableroKanban.comenzarTarea(tarea1.getId(), usuario1));
		assertTrue(tableroKanban.comenzarTarea(tarea2.getId(), usuario2));
		assertTrue(tableroKanban.comenzarTarea(tarea3.getId(), usuario1));
		assertTrue(tableroKanban.comenzarTarea(tarea4.getId(), usuario1));
		assertTrue(tableroKanban.comenzarTarea(tarea5.getId(), usuario2));	
	}
	
	@Test
	public void queSePuedaFinalizarUnaTarea() {
		Usuario usuario1 = new Usuario("david", "David", "Martínez");
		Usuario usuario2 = new Usuario("john", "John", "Casteló");
		Tarea tarea1 = new Tarea("Task 1", EstadoDeTarea.PENDIENTE, usuario1);
		Tarea tarea2 = new Tarea("Task 2", EstadoDeTarea.PENDIENTE, usuario2);
		Tarea tarea3 = new Tarea("Task 3", EstadoDeTarea.PENDIENTE, usuario1);
		Tarea tarea4 = new Tarea("Task 4", EstadoDeTarea.PENDIENTE, usuario1);
		Tarea tarea5 = new Tarea("Task 5", EstadoDeTarea.PENDIENTE, usuario2);	
		TableroKanban tableroKanban = new TableroKanban(10, 5);
		
		assertNotNull(tarea1);
		assertNotNull(tarea2);
		assertNotNull(tarea3);
		assertNotNull(tarea4);
		assertNotNull(tarea5);
		assertNotNull(usuario1);
		assertNotNull(usuario2);
		assertNotNull(tableroKanban);
		
		assertTrue(tableroKanban.registrarUsuario(usuario1));
		assertTrue(tableroKanban.registrarUsuario(usuario2));
		
		assertTrue(tableroKanban.crearTarea(tarea1, usuario1));
		assertTrue(tableroKanban.crearTarea(tarea2, usuario2));
		assertTrue(tableroKanban.crearTarea(tarea3, usuario1));
		assertTrue(tableroKanban.crearTarea(tarea4, usuario1));
		assertTrue(tableroKanban.crearTarea(tarea5, usuario2));
		
		assertTrue(tableroKanban.comenzarTarea(tarea1.getId(), usuario1));
		assertTrue(tableroKanban.comenzarTarea(tarea2.getId(), usuario2));
		assertTrue(tableroKanban.comenzarTarea(tarea3.getId(), usuario1));
		assertTrue(tableroKanban.comenzarTarea(tarea4.getId(), usuario1));
		assertTrue(tableroKanban.comenzarTarea(tarea5.getId(), usuario2));	
		
		assertTrue(tableroKanban.finalizarTarea(tarea1.getId()));
		assertTrue(tableroKanban.finalizarTarea(tarea2.getId()));
		assertTrue(tableroKanban.finalizarTarea(tarea3.getId()));
		assertTrue(tableroKanban.finalizarTarea(tarea4.getId()));
		assertTrue(tableroKanban.finalizarTarea(tarea5.getId()));
	}
}