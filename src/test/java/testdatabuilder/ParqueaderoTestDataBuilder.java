package testdatabuilder;

import co.ceiba.parking.dominio.Parqueadero;

public class ParqueaderoTestDataBuilder {
	private static final String NIT = "8101239832-2";
	private static final String RAZONSOCIAL = "Parqueadero la 30";
	private static final String DIRECCION = "Carrera 30 #30-26 ";
	private static final String TELEFONO = "0348945678";
	
	private String nit;
	private String razonSocial;
	private String direccion;
	private String telefono;

	public ParqueaderoTestDataBuilder() {
		this.nit = NIT;
		this.razonSocial = RAZONSOCIAL;
		this.direccion = DIRECCION;
		this.telefono = TELEFONO;
	}

	public ParqueaderoTestDataBuilder conNit(String nit) {
		this.nit = nit;
		return this;
	}

	public ParqueaderoTestDataBuilder conRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
		return this;
	}

	public ParqueaderoTestDataBuilder conDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}

	public ParqueaderoTestDataBuilder conTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}

	public Parqueadero build() {
		return new Parqueadero(nit, razonSocial, direccion, telefono);
	}
}
