package co.ceiba.parqueadero.domain;

public class Vehiculo {
	private String tipo;
	private String placa;
	private int cilindraje;
	
	public Vehiculo(String tipo, String placa, int cilindraje) {
		this.tipo = tipo;
		this.placa = placa;
		this.cilindraje = cilindraje;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}

	public String getTipo() {
		return tipo;
	}
	
}
