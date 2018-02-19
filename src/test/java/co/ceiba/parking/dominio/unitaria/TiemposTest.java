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
		assertEquals(1, tiempos.getDias());
		assertEquals(3, tiempos.getHoras());
		assertEquals(27, tiempos.getHorasTotal());
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
		assertEquals(1, tiempos.getDias());
		assertEquals(0, tiempos.getHoras());
		assertEquals(10, tiempos.getHorasTotal());
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
		assertEquals(1, tiempos.getDias());
		assertEquals(0, tiempos.getHoras());
		assertEquals(9, tiempos.getHorasTotal());
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
		assertEquals(0, tiempos.getDias());
		assertEquals(8, tiempos.getHoras());
		assertEquals(8, tiempos.getHorasTotal());
	}

}
