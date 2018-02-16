package co.ceiba.parqueadero.dominio;

import java.util.Date;

public class Estacionados {
	private Vehiculo vehiculo;
	private Date ingreso;
	
	public Estacionados(Vehiculo vehiculo, Date ingreso) {
		this.vehiculo = vehiculo;
		this.ingreso = ingreso;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public Date getIngreso() {
		return ingreso;
	}
	
}
