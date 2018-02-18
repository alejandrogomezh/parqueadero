package co.ceiba.parking.dominio;

import co.ceiba.parking.dominio.repositorio.ParqueaderoRepositorio;
import co.ceiba.parking.persistencia.entidad.ParqueaderoEntity;

public class Parqueadero {
	private String nit;
	private String razonSocial;
	private String direccion;
	private String telefono;
	
	public Parqueadero(String nit, String razonSocial, String direccion, String telefono) {
		this.nit = nit;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public String getNit() {
		return nit;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	private ParqueaderoEntity selfEntity;
	public ParqueaderoEntity getSelfEntity() {
		return selfEntity;
	}
	public Parqueadero setSelfEntity(ParqueaderoEntity selfEntity) {
		this.selfEntity = selfEntity;
		return this;
	}
	
	public Parqueadero persistente(ParqueaderoRepositorio parqueaderoRepositorio) {
		Parqueadero self = parqueaderoRepositorio.obtener(this);
		if(self.selfEntity == null) {
			self = parqueaderoRepositorio.agregar(this);
		}
		if(self != null) this.selfEntity = self.selfEntity;
		return this;
	}
}
