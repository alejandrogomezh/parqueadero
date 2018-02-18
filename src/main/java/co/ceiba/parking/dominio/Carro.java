package co.ceiba.parking.dominio;

public class Carro extends Vehiculo{
	public static final String TIPO = "carro";

	public Carro(String placa, int cilindraje) {
		super(TIPO, placa, cilindraje);
	}
	
}
