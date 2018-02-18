package testdatabuilder;

import java.util.Calendar;
import java.util.Date;

import co.ceiba.parking.dominio.Ingresados;
import co.ceiba.parking.dominio.Vehiculo;
import testutilidades.FechaTest;

public class IngresadosTestDataBuilder {
	private static final Date INGRESO = FechaTest.crearFecha(24, Calendar.MAY, 2018);
	
	private Vehiculo vehiculo;
	private Date ingreso;
	
	public IngresadosTestDataBuilder() {
		this.vehiculo = new MotoTestDataBuilder().build();
		this.ingreso = INGRESO;
	}
	
	public IngresadosTestDataBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	public IngresadosTestDataBuilder conIngreso(Date ingreso) {
		this.ingreso = ingreso;
		return this;
	}
	
	public Ingresados build() {
		return new Ingresados(vehiculo, ingreso);
	}
	
}
