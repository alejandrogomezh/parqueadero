package co.ceiba.parking.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import co.ceiba.parking.dominio.Condiciones;
import co.ceiba.parking.dominio.Registro;
import co.ceiba.parking.dominio.Tiempos;
import testdatabuilder.CarroCondicionesTestDataBuilder;
import testdatabuilder.RegistroTestDataBuilder;
import testutilidades.FechaTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TiemposTest {
	
	@Test public void unDiaMasTresHoras() {
		// arrange
		Date ingreso = FechaTest.crearFechaConHora(24, Calendar.MAY, 2018, 12, 0);
		Date salida = FechaTest.crearFechaConHora(25, Calendar.MAY, 2018, 15, 0);
		
		Condiciones condicion = new CarroCondicionesTestDataBuilder().build();
		Registro registro = new RegistroTestDataBuilder()
				.conIngreso(ingreso)
				.conSalida(salida)
				.build();
		Tiempos tiempos = new Tiempos(condicion, registro);
		// act
		tiempos.calcular();
		// assert
		assertEquals(tiempos.getDias(), 1);
		assertEquals(tiempos.getHoras(), 3);
		assertEquals(tiempos.getHorasTotal(), 27);
	}
	
	@Test public void unDiaDesde10Horas() {
		// arrange
		Date ingreso = FechaTest.crearFechaConHora(24, Calendar.MAY, 2018, 7, 0);
		Date salida = FechaTest.crearFechaConHora(24, Calendar.MAY, 2018, 17, 0);
		
		Condiciones condicion = new CarroCondicionesTestDataBuilder().build();
		Registro registro = new RegistroTestDataBuilder()
				.conIngreso(ingreso)
				.conSalida(salida)
				.build();
		Tiempos tiempos = new Tiempos(condicion, registro);
		// act
		tiempos.calcular();
		// assert
		assertEquals(tiempos.getDias(), 1);
		assertEquals(tiempos.getHoras(), 0);
		assertEquals(tiempos.getHorasTotal(), 10);
	}

	@Test public void unDiaDesde9Horas() {
		// arrange
		Date ingreso = FechaTest.crearFechaConHora(24, Calendar.MAY, 2018, 7, 0);
		Date salida = FechaTest.crearFechaConHora(24, Calendar.MAY, 2018, 16, 0);
		
		Condiciones condicion = new CarroCondicionesTestDataBuilder().build();
		Registro registro = new RegistroTestDataBuilder()
				.conIngreso(ingreso)
				.conSalida(salida)
				.build();
		Tiempos tiempos = new Tiempos(condicion, registro);
		// act
		tiempos.calcular();
		// assert
		assertEquals(tiempos.getDias(), 1);
		assertEquals(tiempos.getHoras(), 0);
		assertEquals(tiempos.getHorasTotal(), 9);
	}

	@Test public void ochoHoras() {
		// arrange
		Date ingreso = FechaTest.crearFechaConHora(24, Calendar.MAY, 2018, 7, 0);
		Date salida = FechaTest.crearFechaConHora(24, Calendar.MAY, 2018, 15, 0);
		
		Condiciones condicion = new CarroCondicionesTestDataBuilder().build();
		Registro registro = new RegistroTestDataBuilder()
				.conIngreso(ingreso)
				.conSalida(salida)
				.build();
		Tiempos tiempos = new Tiempos(condicion, registro);
		// act
		tiempos.calcular();
		// assert
		assertEquals(tiempos.getDias(), 0);
		assertEquals(tiempos.getHoras(), 8);
		assertEquals(tiempos.getHorasTotal(), 8);
	}

}
