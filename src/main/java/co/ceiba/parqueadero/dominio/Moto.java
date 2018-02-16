package co.ceiba.parqueadero.dominio;

public class Moto extends Vehiculo{
	private static final String TIPO = "moto";

	public Moto(String placa, int cilindraje) {
		super(TIPO, placa, cilindraje);
	}

	public static boolean esMoto(Vehiculo vehiculo) {
		return vehiculo.getTipo().equals(TIPO);
	}
}
