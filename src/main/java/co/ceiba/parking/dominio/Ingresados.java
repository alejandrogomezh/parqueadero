package co.ceiba.parking.dominio;

import java.util.Date;

import co.ceiba.parking.dominio.repositorio.IngresadosRepositorio;
import co.ceiba.parking.persistencia.entidad.IngresadosEntity;

public class Ingresados {
	private Vehiculo vehiculo;
	private Date ingreso;
	
	public Ingresados(Vehiculo vehiculo, Date ingreso) {
		this.vehiculo = vehiculo;
		this.ingreso = ingreso;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public Date getIngreso() {
		return ingreso;
	}
	
	private IngresadosEntity selfEntity;
	public IngresadosEntity getSelfEntity() {
		return selfEntity;
	}
	public Ingresados setSelfEntity(IngresadosEntity entity) {
		this.selfEntity = entity;
		return this;
	}
	
	public Ingresados persistente(IngresadosRepositorio ingresadosRepositorio) {
		Ingresados self = ingresadosRepositorio.agregar(this);
		if(self != null) this.selfEntity = self.selfEntity;
		return this;
	}
}
