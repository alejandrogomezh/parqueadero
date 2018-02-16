package co.ceiba.parqueadero.domain;

import java.util.Date;

public class Factura {
	private Date generacion;
	private Registro registro;
	private int tiempoTotal;
	private int dias;
	private int horas;
	private double recargoCilindraje;
	
	public Factura(Date generacion, Registro registro, int tiempoTotal, int dias, int horas, double recargoCilindraje) {
		this.generacion = generacion;
		this.registro = registro;
		this.tiempoTotal = tiempoTotal;
		this.dias = dias;
		this.horas = horas;
		this.recargoCilindraje = recargoCilindraje;
	}
	
	public Date getGeneracion() {
		return generacion;
	}
	
	public Registro getRegistro() {
		return registro;
	}
	
	public int getTiempoTotal() {
		return tiempoTotal;
	}
	
	public int getDias() {
		return dias;
	}
	
	public int getHoras() {
		return horas;
	}
	
	public double getRecargoCilindraje() {
		return recargoCilindraje;
	}
	
	
}
