package co.ceiba.parqueadero.domain;

import java.util.Date;

public class Registro {
	private Vehiculo vehiculo;
	private Date ingreso;
	private Date salida;
	
	public Registro(Vehiculo vehiculo, Date ingreso, Date salida) {
		this.vehiculo = vehiculo;
		this.ingreso = ingreso;
		this.salida = salida;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public Date getIngreso() {
		return ingreso;
	}
	
	public Date getSalida() {
		return salida;
	}
	
}
