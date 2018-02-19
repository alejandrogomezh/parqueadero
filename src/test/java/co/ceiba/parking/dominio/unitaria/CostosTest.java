package co.ceiba.parking.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import co.ceiba.parking.dominio.Condiciones;
import co.ceiba.parking.dominio.Costos;
import co.ceiba.parking.dominio.Registro;
import co.ceiba.parking.dominio.TiemposInterface;
import co.ceiba.parking.dominio.Vehiculo;
import testdatabuilder.CarroCondicionesTestDataBuilder;
import testdatabuilder.CarroTestDataBuilder;
import testdatabuilder.MotoCondicionesTestDataBuilder;
import testdatabuilder.MotoTestDataBuilder;
import testdatabuilder.RegistroTestDataBuilder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CostosTest {
	
	@Test public void motoConRecargoUnDiaMasTresHoras() {
		// arrange
		int cilindraje = 650;
		Vehiculo vehiculo = new MotoTestDataBuilder().conCilindraje(cilindraje).build();
		Condiciones condiciones = new MotoCondicionesTestDataBuilder().build();
		Registro registro = new RegistroTestDataBuilder().conVehiculo(vehiculo).build();
		TiemposInterface tiempos = mock(TiemposInterface.class);
		
		when(tiempos.getCondicion()).thenReturn(condiciones);	
		when(tiempos.getRegistro()).thenReturn(registro);
		when(tiempos.getHoras()).thenReturn(3);
		when(tiempos.getDias()).thenReturn(1);
		
		Costos costos = new Costos(tiempos);
		double valorDia = condiciones.getValorDia()*1;
		double valorHora = condiciones.getValorHora()*3;
		double valorRecargo = condiciones.getValorRecargo();
		double valorTotal = valorDia + valorHora + valorRecargo;
		// act
		costos.calcular();
		// assert
		assertEquals(costos.getValorDias(), valorDia, 0);
		assertEquals(costos.getValorHoras(), valorHora, 0);
		assertEquals(costos.getValorRecargo(), valorRecargo, 0);
		assertEquals(costos.getValorTotal(), valorTotal, 0);
	}

	@Test public void motoSinRecargoUnDiaMasTresHoras() {
		// arrange
		int cilindraje = 250;
		Vehiculo vehiculo = new MotoTestDataBuilder().conCilindraje(cilindraje).build();
		Condiciones condiciones = new MotoCondicionesTestDataBuilder().build();
		Registro registro = new RegistroTestDataBuilder().conVehiculo(vehiculo).build();
		TiemposInterface tiempos = mock(TiemposInterface.class);
		
		when(tiempos.getCondicion()).thenReturn(condiciones);	
		when(tiempos.getRegistro()).thenReturn(registro);
		when(tiempos.getHoras()).thenReturn(3);
		when(tiempos.getDias()).thenReturn(1);
		
		Costos costos = new Costos(tiempos);
		double valorDia = condiciones.getValorDia()*1;
		double valorHora = condiciones.getValorHora()*3;
		double valorRecargo = 0;
		double valorTotal = valorDia + valorHora + valorRecargo;
		// act
		costos.calcular();
		// assert
		assertEquals(costos.getValorDias(), valorDia, 0);
		assertEquals(costos.getValorHoras(), valorHora, 0);
		assertEquals(costos.getValorRecargo(), valorRecargo, 0);
		assertEquals(costos.getValorTotal(), valorTotal, 0);
	}

	@Test public void carroSinRecargoUnDiaMasTresHoras() {
		// arrange
		int cilindraje = 1800;
		Vehiculo vehiculo = new CarroTestDataBuilder().conCilindraje(cilindraje).build();
		Condiciones condiciones = new CarroCondicionesTestDataBuilder().build();
		Registro registro = new RegistroTestDataBuilder().conVehiculo(vehiculo).build();
		TiemposInterface tiempos = mock(TiemposInterface.class);
		
		when(tiempos.getCondicion()).thenReturn(condiciones);	
		when(tiempos.getRegistro()).thenReturn(registro);
		when(tiempos.getHoras()).thenReturn(3);
		when(tiempos.getDias()).thenReturn(1);
		
		Costos costos = new Costos(tiempos);
		double valorDia = condiciones.getValorDia()*1;
		double valorHora = condiciones.getValorHora()*3;
		double valorRecargo = 0;
		double valorTotal = valorDia + valorHora;
		// act
		costos.calcular();
		// assert
		assertEquals(costos.getValorDias(), valorDia, 0);
		assertEquals(costos.getValorHoras(), valorHora, 0);
		assertEquals(costos.getValorRecargo(), valorRecargo, 0);
		assertEquals(costos.getValorTotal(), valorTotal, 0);
	}
	
}
