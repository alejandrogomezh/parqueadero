package co.ceiba.parking.dominio;

public interface TiemposInterface {
	Condiciones getCondicion();
	Registro getRegistro();
	int getHorasTotal();
	int getHoras();
	int getDias();
}
