package co.ceiba.parqueadero.domain;

import java.util.Date;

public class Salida {
	private Vehiculo vehiculo;
	private Date fecha;

	public Salida(Date fecha, Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		this.fecha = fecha;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Date getFecha() {
		return fecha;
	}
	
	
	
}
