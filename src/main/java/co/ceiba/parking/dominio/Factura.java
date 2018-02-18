package co.ceiba.parking.dominio;

import java.util.Date;

import co.ceiba.parking.dominio.repositorio.FacturaRepositorio;
import co.ceiba.parking.persistencia.entidad.FacturaEntity;

public class Factura {
	private Date generacion;
	private Registro registro;
	private int horasTotal;
	private int dias;
	private int horas;
	private double valorDias;
	private double valorHoras;
	private double valorRecargo;
	private double valorTotal;
	
	public Factura(Date generacion, Registro registro, int horasTotal, int dias, int horas, double valorDias,
			double valorHoras, double valorRecargo, double valorTotal) {
		super();
		this.generacion = generacion;
		this.registro = registro;
		this.horasTotal = horasTotal;
		this.dias = dias;
		this.horas = horas;
		this.valorDias = valorDias;
		this.valorHoras = valorHoras;
		this.valorRecargo = valorRecargo;
		this.valorTotal = valorTotal;
	}
	public Date getGeneracion() {
		return generacion;
	}
	public Registro getRegistro() {
		return registro;
	}
	public int getHorasTotal() {
		return horasTotal;
	}
	public int getDias() {
		return dias;
	}
	public int getHoras() {
		return horas;
	}
	public double getValorDias() {
		return valorDias;
	}
	public double getValorHoras() {
		return valorHoras;
	}
	public double getValorRecargo() {
		return valorRecargo;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	
	
	private FacturaEntity selfEntity;
	public FacturaEntity getSelfEntity() {
		return selfEntity;
	}
	public Factura setSelfEntity(FacturaEntity selfEntity) {
		this.selfEntity = selfEntity;
		return this;
	}
	
	public Factura persistente(FacturaRepositorio facturaRepositorio) {
		Factura self = facturaRepositorio.agregar(this);
		if(self != null) this.selfEntity = self.selfEntity;
		return this;
	}
}
