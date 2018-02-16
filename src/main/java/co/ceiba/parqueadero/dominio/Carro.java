package co.ceiba.parqueadero.dominio;

public class Carro extends Vehiculo{
	private static final String TIPO = "carro";

	public Carro(String placa, int cilindraje) {
		super(TIPO, placa, cilindraje);
	}
	
}
