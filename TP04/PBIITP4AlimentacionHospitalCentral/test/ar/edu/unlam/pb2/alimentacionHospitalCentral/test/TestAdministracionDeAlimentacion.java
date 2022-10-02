package ar.edu.unlam.pb2.alimentacionHospitalCentral.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.AdministracionDeAlimentacion;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.AlimentoBase;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.Celiaco;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.ComidaDelDia;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.DiabeticoTipo1;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.DiabeticoTipo2;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.General;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.Genero;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.GrupoDeAlimentos;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.Hipertenso;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.Oncologico;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.TipoDeActividad;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.TipoDePaciente;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.TipoDePreparacion;
import ar.edu.unlam.pb2.alimentacionHospitalCentral.dominio.UnidadDeMedida;

public class TestAdministracionDeAlimentacion {

	@Test
	public void queSePuedaIngresarUnAlimentoAlSistema() {
		AlimentoBase alimento1 = new AlimentoBase("Papa", 17.6f, 2.0f, 2.0f, GrupoDeAlimentos.VERDURAS, 1, UnidadDeMedida.KG, 4.0f, 2.0f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento2 = new AlimentoBase("Arroz integral", 23.0f, 2.6f, 0.4f, GrupoDeAlimentos.CEREALES_EN_GENERAL, 1, UnidadDeMedida.KG, 66.0f, 5.0f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento3 = new AlimentoBase("Manzana verde", 10.13f, 0.17f, 0.0f, GrupoDeAlimentos.FRUTAS, 1, UnidadDeMedida.PIEZA, 39.0f, 2.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento4 = new AlimentoBase("Pollo", 0.6f, 20.0f, 9.7f, GrupoDeAlimentos.PROTEINAS, 1, UnidadDeMedida.KG, 0.0f, 91.0f, TipoDePreparacion.HORNO);
		AlimentoBase alimento5 = new AlimentoBase("Queso", 1.3f, 25.0f, 25.0f, GrupoDeAlimentos.LACTEOS, 1, UnidadDeMedida.KG, 0.0f, 621.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento6 = new AlimentoBase("Mermelada de frutas", 68.0f, 0.50f, 0.10f, GrupoDeAlimentos.OTROS, 1, UnidadDeMedida.PIEZA, 65.0f, 32.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento7 = new AlimentoBase("Harina trigo", 70.6f, 9.86f, 1.08f, GrupoDeAlimentos.CEREAL_TRIGO, 1, UnidadDeMedida.KG, 85.0f, 2.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento8 = new AlimentoBase("Avena", 12.0f, 2.46f, 7.5f, GrupoDeAlimentos.CEREAL_AVENA, 1, UnidadDeMedida.KG, 53.0f, 49.0f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento9 = new AlimentoBase("Pan blanco", 49.0f, 9.0f, 9.0f, GrupoDeAlimentos.CEREAL_CEBADA, 100, UnidadDeMedida.GR, 76.0f, 491.0f, TipoDePreparacion.HORNO);
		AlimentoBase alimento10 = new AlimentoBase("Galletas saladas", 61.0f, 7.0f, 12.5f, GrupoDeAlimentos.CEREAL_CENTENO, 100, UnidadDeMedida.GR, 85.0f, 252.0f, TipoDePreparacion.SIN_COCCION);
		AdministracionDeAlimentacion administracion = new AdministracionDeAlimentacion();
		
		assertNotNull(alimento1);
		assertNotNull(alimento2);
		assertNotNull(alimento3);
		assertNotNull(alimento4);
		assertNotNull(alimento5);
		assertNotNull(alimento6);
		assertNotNull(alimento7);
		assertNotNull(alimento8);
		assertNotNull(alimento9);
		assertNotNull(alimento10);
		assertNotNull(administracion);
		
		administracion.agregarAlimento(alimento1);
		administracion.agregarAlimento(alimento2);
		administracion.agregarAlimento(alimento3);
		administracion.agregarAlimento(alimento4);
		administracion.agregarAlimento(alimento5);
		administracion.agregarAlimento(alimento6);
		administracion.agregarAlimento(alimento7);
		administracion.agregarAlimento(alimento8);
		administracion.agregarAlimento(alimento9);
		administracion.agregarAlimento(alimento10);
		
		assertNotNull(administracion.getAlimentos());
		
		assertEquals(10, administracion.getAlimentos().size());		
	}
	
	@Test
	public void queSePuedaAgregarUnPacienteAlSistema() {
		Hipertenso pacienteHipertenso = new Hipertenso("Pedro", "Pérez", Genero.MASCULINO, 55, 175, 80.5, TipoDeActividad.MODERADA, TipoDePaciente.HIPERTENSO, 301);
		Celiaco pacienteCeliaco = new Celiaco("Leonardo", "Cucittini", Genero.MASCULINO, 40, 176, 75.0, TipoDeActividad.EXTREMA, TipoDePaciente.CELIACO, 116);
		Oncologico pacienteOncologico = new Oncologico("Luis", "Martínez", Genero.MASCULINO, 67, 168, 65.0, TipoDeActividad.SEDENTARIA, TipoDePaciente.ONCOLOGICO, 231);
		General pacienteGeneral = new General("María", "Fernández", Genero.FEMENINO, 33, 169, 63.5, TipoDeActividad.MODERADA, TipoDePaciente.GENERAL, 412);
		DiabeticoTipo1 pacienteDiabeticoTipo1 = new DiabeticoTipo1("Matilde", "Gutiérrez", Genero.FEMENINO, 49, 165, 72.3, TipoDeActividad.MODERADA, TipoDePaciente.DIABETICO_TIPO_1, 226);
		DiabeticoTipo2 pacienteDiabeticoTipo2 = new DiabeticoTipo2("Leonara", "Páez", Genero.FEMENINO, 61, 163, 69.3, TipoDeActividad.SEDENTARIA, TipoDePaciente.DIABETICO_TIPO_2, 240);
		AdministracionDeAlimentacion administracion = new AdministracionDeAlimentacion();
		
		assertNotNull(pacienteHipertenso);
		assertNotNull(pacienteCeliaco);
		assertNotNull(pacienteOncologico);
		assertNotNull(pacienteGeneral);
		assertNotNull(pacienteDiabeticoTipo1);
		assertNotNull(pacienteDiabeticoTipo2);
		assertNotNull(administracion);
		
		administracion.agregarPaciente(pacienteHipertenso);
		administracion.agregarPaciente(pacienteCeliaco);
		administracion.agregarPaciente(pacienteOncologico);
		administracion.agregarPaciente(pacienteGeneral);
		administracion.agregarPaciente(pacienteDiabeticoTipo1);
		administracion.agregarPaciente(pacienteDiabeticoTipo2);
		
		assertNotNull(administracion.getPacientes());
		
		assertEquals(6, administracion.getPacientes().size());	
		
		assertNotNull(administracion.getPacientesGeneral());
		assertEquals(1, administracion.getPacientesGeneral().size());
		
		assertNotNull(administracion.getPacientesCelicos());
		assertEquals(1, administracion.getPacientesCelicos().size());

		assertNotNull(administracion.getPacientesDiabeticosTipo1());
		assertEquals(1, administracion.getPacientesDiabeticosTipo1().size());

		assertNotNull(administracion.getPacientesDiabeticosTipo2());
		assertEquals(1, administracion.getPacientesDiabeticosTipo2().size());
		
		assertNotNull(administracion.getPacientesHipertensos());
		assertEquals(1, administracion.getPacientesHipertensos().size());
		
		assertNotNull(administracion.getPacientesOncologicos());
		assertEquals(1, administracion.getPacientesOncologicos().size());
	}
	
	@Test
	public void queSePuedeRegistrarUnAlimentoSegunElTipoDePaciente() {
		Hipertenso pacienteHipertenso = new Hipertenso("Pedro", "Pérez", Genero.MASCULINO, 55, 175, 80.5, TipoDeActividad.MODERADA, TipoDePaciente.HIPERTENSO, 301);
		Celiaco pacienteCeliaco = new Celiaco("Leonardo", "Cucittini", Genero.MASCULINO, 40, 176, 75.0, TipoDeActividad.EXTREMA, TipoDePaciente.CELIACO, 116);
		Oncologico pacienteOncologico = new Oncologico("Luis", "Martínez", Genero.MASCULINO, 67, 168, 65.0, TipoDeActividad.SEDENTARIA, TipoDePaciente.ONCOLOGICO, 231);
		General pacienteGeneral = new General("María", "Fernández", Genero.FEMENINO, 33, 169, 63.5, TipoDeActividad.MODERADA, TipoDePaciente.GENERAL, 412);
		DiabeticoTipo1 pacienteDiabeticoTipo1 = new DiabeticoTipo1("Matilde", "Gutiérrez", Genero.FEMENINO, 49, 165, 72.3, TipoDeActividad.MODERADA, TipoDePaciente.DIABETICO_TIPO_1, 226);
		DiabeticoTipo2 pacienteDiabeticoTipo2 = new DiabeticoTipo2("Leonara", "Páez", Genero.FEMENINO, 61, 163, 69.3, TipoDeActividad.SEDENTARIA, TipoDePaciente.DIABETICO_TIPO_2, 240);
				
		AlimentoBase alimento1 = new AlimentoBase("Papa", 17.6f, 2.0f, 2.0f, GrupoDeAlimentos.VERDURAS, 1, UnidadDeMedida.KG, 4.0f, 0.15f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento2 = new AlimentoBase("Arroz integral", 23.0f, 2.6f, 0.4f, GrupoDeAlimentos.CEREALES_EN_GENERAL, 1, UnidadDeMedida.KG, 66.0f, 5.0f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento3 = new AlimentoBase("Manzana verde", 10.13f, 0.17f, 0.0f, GrupoDeAlimentos.FRUTAS, 1, UnidadDeMedida.PIEZA, 39.0f, 2.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento4 = new AlimentoBase("Pollo", 0.6f, 20.0f, 9.7f, GrupoDeAlimentos.PROTEINAS, 1, UnidadDeMedida.KG, 0.0f, 91.0f, TipoDePreparacion.HORNO);
		AlimentoBase alimento5 = new AlimentoBase("Queso", 1.3f, 25.0f, 25.0f, GrupoDeAlimentos.LACTEOS, 1, UnidadDeMedida.KG, 0.0f, 621.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento6 = new AlimentoBase("Mermelada de frutas", 68.0f, 0.50f, 0.10f, GrupoDeAlimentos.OTROS, 1, UnidadDeMedida.PIEZA, 65.0f, 32.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento7 = new AlimentoBase("Harina trigo", 70.6f, 9.86f, 1.08f, GrupoDeAlimentos.CEREAL_TRIGO, 1, UnidadDeMedida.KG, 85.0f, 2.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento8 = new AlimentoBase("Avena", 12.0f, 2.46f, 7.5f, GrupoDeAlimentos.CEREAL_AVENA, 1, UnidadDeMedida.KG, 53.0f, 49.0f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento9 = new AlimentoBase("Pan blanco", 49.0f, 9.0f, 9.0f, GrupoDeAlimentos.CEREAL_CEBADA, 100, UnidadDeMedida.GR, 76.0f, 491.0f, TipoDePreparacion.HORNO);
		AlimentoBase alimento10 = new AlimentoBase("Galletas saladas", 61.0f, 7.0f, 12.5f, GrupoDeAlimentos.CEREAL_CENTENO, 100, UnidadDeMedida.GR, 85.0f, 252.0f, TipoDePreparacion.SIN_COCCION);
		
		AdministracionDeAlimentacion administracion = new AdministracionDeAlimentacion();
		
		administracion.agregarPaciente(pacienteHipertenso);
		administracion.agregarPaciente(pacienteCeliaco);
		administracion.agregarPaciente(pacienteOncologico);
		administracion.agregarPaciente(pacienteGeneral);
		administracion.agregarPaciente(pacienteDiabeticoTipo1);
		administracion.agregarPaciente(pacienteDiabeticoTipo2);
		
		administracion.agregarAlimento(alimento1);
		administracion.agregarAlimento(alimento2);
		administracion.agregarAlimento(alimento3);
		administracion.agregarAlimento(alimento4);
		administracion.agregarAlimento(alimento5);
		administracion.agregarAlimento(alimento6);
		administracion.agregarAlimento(alimento7);
		administracion.agregarAlimento(alimento8);
		administracion.agregarAlimento(alimento9);
		administracion.agregarAlimento(alimento10);
		
		administracion.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.CELIACO);
		administracion.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.DIABETICO_TIPO_1);
		administracion.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.DIABETICO_TIPO_2);
		administracion.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.GENERAL);
		administracion.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.HIPERTENSO);
		administracion.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.ONCOLOGICO);
		
		assertNotNull(administracion.getAlimentosParaPacientesGenerales());
		assertNotNull(administracion.getAlimentosParaPacientesCeliacos());
		assertNotNull(administracion.getAlimentosParaPacientesDiabeticosTipo1());
		assertNotNull(administracion.getAlimentosParaPacientesDiabeticosTipo2());
		assertNotNull(administracion.getAlimentosParaPacientesHipertensos());
		assertNotNull(administracion.getAlimentosParaPacientesOncologicos());
		
		assertEquals(10, administracion.getAlimentosParaPacientesGenerales().size());
		assertEquals(2, administracion.getAlimentosParaPacientesDiabeticosTipo1().size());
		assertEquals(5, administracion.getAlimentosParaPacientesDiabeticosTipo2().size());
		assertEquals(5, administracion.getAlimentosParaPacientesOncologicos().size());
		assertEquals(6, administracion.getAlimentosParaPacientesCeliacos().size());
		assertEquals(1, administracion.getAlimentosParaPacientesHipertensos().size());		
	}
	
	@Test
	public void queSePuedanGenerarOpcionesDeMenuParaCadaTipoPaciente() {
		Hipertenso pacienteHipertenso = new Hipertenso("Pedro", "Pérez", Genero.MASCULINO, 55, 175, 80.5, TipoDeActividad.MODERADA, TipoDePaciente.HIPERTENSO, 301);
		Celiaco pacienteCeliaco = new Celiaco("Leonardo", "Cucittini", Genero.MASCULINO, 40, 176, 75.0, TipoDeActividad.EXTREMA, TipoDePaciente.CELIACO, 116);
		Oncologico pacienteOncologico = new Oncologico("Luis", "Martínez", Genero.MASCULINO, 67, 168, 65.0, TipoDeActividad.SEDENTARIA, TipoDePaciente.ONCOLOGICO, 231);
		General pacienteGeneral = new General("María", "Fernández", Genero.FEMENINO, 33, 169, 63.5, TipoDeActividad.MODERADA, TipoDePaciente.GENERAL, 412);
		DiabeticoTipo1 pacienteDiabeticoTipo1 = new DiabeticoTipo1("Matilde", "Gutiérrez", Genero.FEMENINO, 49, 165, 72.3, TipoDeActividad.MODERADA, TipoDePaciente.DIABETICO_TIPO_1, 226);
		DiabeticoTipo2 pacienteDiabeticoTipo2 = new DiabeticoTipo2("Leonara", "Páez", Genero.FEMENINO, 61, 163, 69.3, TipoDeActividad.SEDENTARIA, TipoDePaciente.DIABETICO_TIPO_2, 240);
				
		AlimentoBase alimento1 = new AlimentoBase("Papa", 17.6f, 2.0f, 2.0f, GrupoDeAlimentos.VERDURAS, 1, UnidadDeMedida.KG, 4.0f, 0.15f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento2 = new AlimentoBase("Arroz integral", 23.0f, 2.6f, 0.4f, GrupoDeAlimentos.CEREALES_EN_GENERAL, 1, UnidadDeMedida.KG, 66.0f, 5.0f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento3 = new AlimentoBase("Manzana verde", 10.13f, 0.17f, 0.0f, GrupoDeAlimentos.FRUTAS, 1, UnidadDeMedida.PIEZA, 39.0f, 2.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento4 = new AlimentoBase("Pollo", 0.6f, 20.0f, 9.7f, GrupoDeAlimentos.PROTEINAS, 1, UnidadDeMedida.KG, 0.0f, 91.0f, TipoDePreparacion.HORNO);
		AlimentoBase alimento5 = new AlimentoBase("Queso", 1.3f, 25.0f, 25.0f, GrupoDeAlimentos.LACTEOS, 1, UnidadDeMedida.KG, 0.0f, 621.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento6 = new AlimentoBase("Mermelada de frutas", 68.0f, 0.50f, 0.10f, GrupoDeAlimentos.OTROS, 1, UnidadDeMedida.PIEZA, 65.0f, 32.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento7 = new AlimentoBase("Harina trigo", 70.6f, 9.86f, 1.08f, GrupoDeAlimentos.CEREAL_TRIGO, 1, UnidadDeMedida.KG, 85.0f, 2.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento8 = new AlimentoBase("Avena", 12.0f, 2.46f, 7.5f, GrupoDeAlimentos.CEREAL_AVENA, 1, UnidadDeMedida.KG, 53.0f, 49.0f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento9 = new AlimentoBase("Pan blanco", 49.0f, 9.0f, 9.0f, GrupoDeAlimentos.CEREAL_CEBADA, 100, UnidadDeMedida.GR, 76.0f, 491.0f, TipoDePreparacion.HORNO);
		AlimentoBase alimento10 = new AlimentoBase("Galletas saladas", 61.0f, 7.0f, 12.5f, GrupoDeAlimentos.CEREAL_CENTENO, 100, UnidadDeMedida.GR, 85.0f, 252.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento11 = new AlimentoBase("Pechuga de pollo", 0.6f, 20.0f, 9.7f, GrupoDeAlimentos.PROTEINAS, 1, UnidadDeMedida.KG, 0.0f, 0.0f, TipoDePreparacion.HORNO);
		AlimentoBase alimento12 = new AlimentoBase("Arroz integral", 23.0f, 2.6f, 0.4f, GrupoDeAlimentos.CEREALES_EN_GENERAL, 1, UnidadDeMedida.KG, 0.0f, 0.05f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento13 = new AlimentoBase("Mandarina", 10.13f, 3.56f, 0.0f, GrupoDeAlimentos.FRUTAS, 1, UnidadDeMedida.PIEZA, 0.0f, 0.02f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento14 = new AlimentoBase("Yogurt natural", 5.5f, 2.0f, 0.0f, GrupoDeAlimentos.LACTEOS, 1, UnidadDeMedida.L, 0.0f, 0.0f, TipoDePreparacion.SIN_COCCION);
		AlimentoBase alimento15 = new AlimentoBase("Avena integral", 8.32f, 2.67f, 0.0f, GrupoDeAlimentos.CEREAL_AVENA, 1, UnidadDeMedida.L, 0.0f, 0.0f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento16 = new AlimentoBase("Arroz con leche", 7.87f, 1.8f, 0.0f, GrupoDeAlimentos.CEREALES_EN_GENERAL, 1, UnidadDeMedida.ML, 0.0f, 0.0f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento17 = new AlimentoBase("Leche descremada", 5.2f, 0.24f, 0.0f, GrupoDeAlimentos.LACTEOS, 1, UnidadDeMedida.ML, 0.0f, 0.0f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento18 = new AlimentoBase("Ensalada de frutas", 8.6f, 6.9f, 0.0f, GrupoDeAlimentos.FRUTAS, 1, UnidadDeMedida.GR, 0.0f, 0.0f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento19 = new AlimentoBase("Zanahoria", 17.6f, 2.0f, 2.0f, GrupoDeAlimentos.VERDURAS, 1, UnidadDeMedida.KG, 0.0f, 0.15f, TipoDePreparacion.AL_VAPOR);
		AlimentoBase alimento20 = new AlimentoBase("Pimentón", 17.6f, 2.0f, 2.0f, GrupoDeAlimentos.VERDURAS, 1, UnidadDeMedida.KG, 0.0f, 0.15f, TipoDePreparacion.AL_VAPOR);
		
		
		AdministracionDeAlimentacion administracion = new AdministracionDeAlimentacion();
		
		administracion.agregarPaciente(pacienteHipertenso);
		administracion.agregarPaciente(pacienteCeliaco);
		administracion.agregarPaciente(pacienteOncologico);
		administracion.agregarPaciente(pacienteGeneral);
		administracion.agregarPaciente(pacienteDiabeticoTipo1);
		administracion.agregarPaciente(pacienteDiabeticoTipo2);
		
		administracion.agregarAlimento(alimento1);
		administracion.agregarAlimento(alimento2);
		administracion.agregarAlimento(alimento3);
		administracion.agregarAlimento(alimento4);
		administracion.agregarAlimento(alimento5);
		administracion.agregarAlimento(alimento6);
		administracion.agregarAlimento(alimento7);
		administracion.agregarAlimento(alimento8);
		administracion.agregarAlimento(alimento9);
		administracion.agregarAlimento(alimento10);
		administracion.agregarAlimento(alimento11);
		administracion.agregarAlimento(alimento12);
		administracion.agregarAlimento(alimento13);
		administracion.agregarAlimento(alimento14);
		administracion.agregarAlimento(alimento15);
		administracion.agregarAlimento(alimento16);
		administracion.agregarAlimento(alimento17);
		administracion.agregarAlimento(alimento18);
		administracion.agregarAlimento(alimento19);
		administracion.agregarAlimento(alimento20);
		
		administracion.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.CELIACO);
		administracion.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.DIABETICO_TIPO_1);
		administracion.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.DIABETICO_TIPO_2);
		administracion.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.GENERAL);
		administracion.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.HIPERTENSO);
		administracion.registrarAlimentosSegunTipoDePaciente(TipoDePaciente.ONCOLOGICO);
		
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesCeliacos(ComidaDelDia.DESAYUNO);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesCeliacos(ComidaDelDia.MERIENDA_MANIANA);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesCeliacos(ComidaDelDia.ALMUERZO);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesCeliacos(ComidaDelDia.MERIENDA_TARDE);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesCeliacos(ComidaDelDia.CENA);
		
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo1(ComidaDelDia.DESAYUNO);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo1(ComidaDelDia.MERIENDA_MANIANA);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo1(ComidaDelDia.ALMUERZO);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo1(ComidaDelDia.MERIENDA_TARDE);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo1(ComidaDelDia.CENA);
		
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDeTipoGeneral(ComidaDelDia.DESAYUNO);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDeTipoGeneral(ComidaDelDia.MERIENDA_MANIANA);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDeTipoGeneral(ComidaDelDia.ALMUERZO);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDeTipoGeneral(ComidaDelDia.MERIENDA_TARDE);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDeTipoGeneral(ComidaDelDia.CENA);
		
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo2(ComidaDelDia.DESAYUNO);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo2(ComidaDelDia.MERIENDA_MANIANA);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo2(ComidaDelDia.ALMUERZO);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo2(ComidaDelDia.MERIENDA_TARDE);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesDiabeticosTipo2(ComidaDelDia.CENA);
		
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesHipertensos(ComidaDelDia.DESAYUNO);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesHipertensos(ComidaDelDia.MERIENDA_MANIANA);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesHipertensos(ComidaDelDia.ALMUERZO);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesHipertensos(ComidaDelDia.MERIENDA_TARDE);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesHipertensos(ComidaDelDia.CENA);
		
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesOncologicos(ComidaDelDia.DESAYUNO);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesOncologicos(ComidaDelDia.MERIENDA_MANIANA);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesOncologicos(ComidaDelDia.ALMUERZO);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesOncologicos(ComidaDelDia.MERIENDA_TARDE);
		administracion.agregarOpcionesAlMenuParaUnaDietaBalanceadaEnPacientesOncologicos(ComidaDelDia.CENA);
		
		assertNotNull(administracion.getMenuParaPacientesCeliacos());
		assertNotNull(administracion.getMenuParaPacientesDiabeticosTipo1());
		assertNotNull(administracion.getMenuParaPacientesDiabeticosTipo2());
		assertNotNull(administracion.getMenuParaPacientesGenerales());
		assertNotNull(administracion.getMenuParaPacientesHipertensos());
		assertNotNull(administracion.getMenuParaPacientesOncologicos());
		
		assertEquals(5, administracion.getMenuParaPacientesCeliacos().size());
		assertEquals(5, administracion.getMenuParaPacientesDiabeticosTipo1().size());
		assertEquals(5, administracion.getMenuParaPacientesDiabeticosTipo2().size());
		assertEquals(5, administracion.getMenuParaPacientesGenerales().size());
		assertEquals(5, administracion.getMenuParaPacientesHipertensos().size());
		assertEquals(5, administracion.getMenuParaPacientesOncologicos().size());
	}
}