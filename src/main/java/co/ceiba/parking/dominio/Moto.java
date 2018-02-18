package co.ceiba.parking.dominio;

public class Moto extends Vehiculo{
	public static final String TIPO = "moto";

	public Moto(String placa, int cilindraje) {
		super(TIPO, placa, cilindraje);
	}

	public static boolean esMoto(Vehiculo vehiculo) {
		return vehiculo.getTipo().equals(TIPO);
	}
}
