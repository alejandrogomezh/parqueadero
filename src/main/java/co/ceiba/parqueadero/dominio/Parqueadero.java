package co.ceiba.parqueadero.dominio;

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
	
}
