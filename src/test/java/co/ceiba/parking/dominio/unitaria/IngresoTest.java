package co.ceiba.parking.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import co.ceiba.parking.dominio.Moto;
import co.ceiba.parking.dominio.Carro;
import co.ceiba.parking.dominio.Condiciones;
import co.ceiba.parking.dominio.Ingresados;
import co.ceiba.parking.dominio.Ingreso;
import co.ceiba.parking.dominio.repositorio.CondicionesRepositorio;
import co.ceiba.parking.dominio.repositorio.IngresadosRepositorio;
import co.ceiba.parking.dominio.repositorio.RepositorioAdministrador;
import co.ceiba.parking.mensajes.Mensajes;
import testdatabuilder.CarroCondicionesTestDataBuilder;
import testdatabuilder.CarroTestDataBuilder;
import testdatabuilder.MotoCondicionesTestDataBuilder;
import testdatabuilder.MotoTestDataBuilder;
import testutilidades.FechaTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IngresoTest {

	@Test public void noIngresarPlacaADiaDomingo() {
		// arrange
		Date fecha = FechaTest.crearFecha(18, Calendar.FEBRUARY, 2018); // Domingo 18/febrero/2018
		Moto moto = new MotoTestDataBuilder().conPlaca("ABC21G").build();
		Condiciones motoCondiciones = new MotoCondicionesTestDataBuilder().build();

		RepositorioAdministrador repositorioAdministrador = mock(RepositorioAdministrador.class);
		IngresadosRepositorio ingresadosRepositorio = mock(IngresadosRepositorio.class);
		CondicionesRepositorio condicionesRepositorio = mock(CondicionesRepositorio.class);

		when(repositorioAdministrador.getIngresadosRepositorio()).thenReturn(ingresadosRepositorio);
		when(repositorioAdministrador.getCondicionesRepositorio()).thenReturn(condicionesRepositorio);

		when(ingresadosRepositorio.obtenerCantidadPorTipoVehiculo(moto)).thenReturn(motoCondiciones.getCupo()-1);
		when(ingresadosRepositorio.obtenerPorVehiculo(moto)).thenReturn(null);
		when(condicionesRepositorio.obtenerPorTipoVehiculo(moto)).thenReturn(motoCondiciones);

		Ingreso ingreso = new Ingreso(repositorioAdministrador);

		// act
		ingreso.ingresar(fecha, moto);

		// assert
		assertEquals(ingreso.getMsg(), Mensajes.INGRESO_NO_AUTORIZADO);
	}

	@Test public void noIngresarPlacaADiaSabado() {
		// arrange
		Date fecha = FechaTest.crearFecha(17, Calendar.FEBRUARY, 2018); // Sabado 18/febrero/2018
		Moto moto = new MotoTestDataBuilder().conPlaca("ABC21G").build();
		Condiciones motoCondiciones = new MotoCondicionesTestDataBuilder().build();

		RepositorioAdministrador repositorioAdministrador = mock(RepositorioAdministrador.class);
		IngresadosRepositorio ingresadosRepositorio = mock(IngresadosRepositorio.class);
		CondicionesRepositorio condicionesRepositorio = mock(CondicionesRepositorio.class);

		when(repositorioAdministrador.getIngresadosRepositorio()).thenReturn(ingresadosRepositorio);
		when(repositorioAdministrador.getCondicionesRepositorio()).thenReturn(condicionesRepositorio);

		when(ingresadosRepositorio.obtenerCantidadPorTipoVehiculo(moto)).thenReturn(motoCondiciones.getCupo()-1);
		when(ingresadosRepositorio.obtenerPorVehiculo(moto)).thenReturn(null);
		when(condicionesRepositorio.obtenerPorTipoVehiculo(moto)).thenReturn(motoCondiciones);

		Ingreso ingreso = new Ingreso(repositorioAdministrador);

		// act
		ingreso.ingresar(fecha, moto);

		// assert
		assertEquals(ingreso.getMsg(), Mensajes.INGRESO_NO_AUTORIZADO);
	}

	@Test public void ingresarPlacaNoADiaDomingo() {
		// arrange
		Date fecha = FechaTest.crearFecha(18, Calendar.FEBRUARY, 2018); // Domingo 18/febrero/2018
		Moto moto = new MotoTestDataBuilder().conPlaca("CBC21G").build();
		Condiciones motoCondiciones = new MotoCondicionesTestDataBuilder().build();

		RepositorioAdministrador repositorioAdministrador = mock(RepositorioAdministrador.class);
		IngresadosRepositorio ingresadosRepositorio = mock(IngresadosRepositorio.class);
		CondicionesRepositorio condicionesRepositorio = mock(CondicionesRepositorio.class);

		when(repositorioAdministrador.getIngresadosRepositorio()).thenReturn(ingresadosRepositorio);
		when(repositorioAdministrador.getCondicionesRepositorio()).thenReturn(condicionesRepositorio);

		when(ingresadosRepositorio.obtenerCantidadPorTipoVehiculo(moto)).thenReturn(motoCondiciones.getCupo()-1);
		when(ingresadosRepositorio.obtenerPorVehiculo(moto)).thenReturn(null);
		when(condicionesRepositorio.obtenerPorTipoVehiculo(moto)).thenReturn(motoCondiciones);

		Ingreso ingreso = new Ingreso(repositorioAdministrador);

		// act
		ingreso.ingresar(fecha, moto);

		// assert
		assertEquals(ingreso.getMsg(), Mensajes.INGRESO);
	}

	@Test public void ingresarPlacaADiaLunes() {
		// arrange
		Date fecha = FechaTest.crearFecha(19, Calendar.FEBRUARY, 2018); // Lunes 19/febrero/2018
		Moto moto = new MotoTestDataBuilder().conPlaca("ABC21G").build();
		Condiciones motoCondiciones = new MotoCondicionesTestDataBuilder().build();

		RepositorioAdministrador repositorioAdministrador = mock(RepositorioAdministrador.class);
		IngresadosRepositorio ingresadosRepositorio = mock(IngresadosRepositorio.class);
		CondicionesRepositorio condicionesRepositorio = mock(CondicionesRepositorio.class);

		when(repositorioAdministrador.getIngresadosRepositorio()).thenReturn(ingresadosRepositorio);
		when(repositorioAdministrador.getCondicionesRepositorio()).thenReturn(condicionesRepositorio);

		when(ingresadosRepositorio.obtenerCantidadPorTipoVehiculo(moto)).thenReturn(motoCondiciones.getCupo()-1);
		when(ingresadosRepositorio.obtenerPorVehiculo(moto)).thenReturn(null);
		when(condicionesRepositorio.obtenerPorTipoVehiculo(moto)).thenReturn(motoCondiciones);

		Ingreso ingreso = new Ingreso(repositorioAdministrador);

		// act
		ingreso.ingresar(fecha, moto);

		// assert
		assertEquals(ingreso.getMsg(), Mensajes.INGRESO);
	}

	@Test public void yaHabiaIngresado() {
		// arrange
		Date fecha = FechaTest.crearFecha(19, Calendar.FEBRUARY, 2018); // Lunes 19/febrero/2018
		Moto moto = new MotoTestDataBuilder().conPlaca("ABC21G").build();
		Condiciones motoCondiciones = new MotoCondicionesTestDataBuilder().build();
		Ingresados ingresado = new Ingresados(moto, fecha);

		RepositorioAdministrador repositorioAdministrador = mock(RepositorioAdministrador.class);
		IngresadosRepositorio ingresadosRepositorio = mock(IngresadosRepositorio.class);
		CondicionesRepositorio condicionesRepositorio = mock(CondicionesRepositorio.class);

		when(repositorioAdministrador.getIngresadosRepositorio()).thenReturn(ingresadosRepositorio);
		when(repositorioAdministrador.getCondicionesRepositorio()).thenReturn(condicionesRepositorio);

		when(ingresadosRepositorio.obtenerCantidadPorTipoVehiculo(moto)).thenReturn(motoCondiciones.getCupo()-1);
		when(ingresadosRepositorio.obtenerPorVehiculo(moto)).thenReturn(ingresado);
		when(condicionesRepositorio.obtenerPorTipoVehiculo(moto)).thenReturn(motoCondiciones);

		Ingreso ingreso = new Ingreso(repositorioAdministrador);

		// act
		ingreso.ingresar(fecha, moto);

		// assert
		assertEquals(ingreso.getMsg(), Mensajes.YA_HABIA_INGRESADO);
	}

	@Test public void sinCupoMoto() {
		// arrange
		Date fecha = FechaTest.crearFecha(19, Calendar.FEBRUARY, 2018); // Lunes 19/febrero/2018
		Moto moto = new MotoTestDataBuilder().conPlaca("ABC21G").build();
		Condiciones motoCondiciones = new MotoCondicionesTestDataBuilder().build();

		RepositorioAdministrador repositorioAdministrador = mock(RepositorioAdministrador.class);
		IngresadosRepositorio ingresadosRepositorio = mock(IngresadosRepositorio.class);
		CondicionesRepositorio condicionesRepositorio = mock(CondicionesRepositorio.class);

		when(repositorioAdministrador.getIngresadosRepositorio()).thenReturn(ingresadosRepositorio);
		when(repositorioAdministrador.getCondicionesRepositorio()).thenReturn(condicionesRepositorio);

		when(ingresadosRepositorio.obtenerCantidadPorTipoVehiculo(moto)).thenReturn(motoCondiciones.getCupo());
		when(ingresadosRepositorio.obtenerPorVehiculo(moto)).thenReturn(null);
		when(condicionesRepositorio.obtenerPorTipoVehiculo(moto)).thenReturn(motoCondiciones);

		Ingreso ingreso = new Ingreso(repositorioAdministrador);

		// act
		ingreso.ingresar(fecha, moto);

		// assert
		assertEquals(ingreso.getMsg(), Mensajes.NO_HAY_CUPO);
	}
	
	@Test public void sinCupoCarro() {
		// arrange
		Date fecha = FechaTest.crearFecha(19, Calendar.FEBRUARY, 2018); // Lunes 19/febrero/2018
		Carro carro = new CarroTestDataBuilder().conPlaca("ABC21G").build();
		Condiciones carroCondiciones = new CarroCondicionesTestDataBuilder().build();

		RepositorioAdministrador repositorioAdministrador = mock(RepositorioAdministrador.class);
		IngresadosRepositorio ingresadosRepositorio = mock(IngresadosRepositorio.class);
		CondicionesRepositorio condicionesRepositorio = mock(CondicionesRepositorio.class);

		when(repositorioAdministrador.getIngresadosRepositorio()).thenReturn(ingresadosRepositorio);
		when(repositorioAdministrador.getCondicionesRepositorio()).thenReturn(condicionesRepositorio);

		when(ingresadosRepositorio.obtenerCantidadPorTipoVehiculo(carro)).thenReturn(carroCondiciones.getCupo());
		when(ingresadosRepositorio.obtenerPorVehiculo(carro)).thenReturn(null);
		when(condicionesRepositorio.obtenerPorTipoVehiculo(carro)).thenReturn(carroCondiciones);

		Ingreso ingreso = new Ingreso(repositorioAdministrador);

		// act
		ingreso.ingresar(fecha, carro);

		// assert
		assertEquals(ingreso.getMsg(), Mensajes.NO_HAY_CUPO);
	}
	
}
