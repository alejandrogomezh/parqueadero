package testdatabuilder;

import co.ceiba.parking.dominio.Condiciones;
import co.ceiba.parking.dominio.Carro;

public class CarroCondicionesTestDataBuilder {
	private static final String TIPO = Carro.TIPO;
	private static final int HORAS_DIA_MINIMO = 9;
	private static final int HORAS_DIA_MAXIMO = 24;
	private static final int CILINDRAJE_MAX_SIN_RECARGO = -1;
	private static final int CUPO = 20;
	private static final double VALOR_HORA = 1000;
	private static final double VALOR_DIA = 8000;
	private static final double VALOR_RECARGO = 0;

	public Condiciones build() {
		return new Condiciones(
				TIPO,
				HORAS_DIA_MINIMO,
				HORAS_DIA_MAXIMO,
				CILINDRAJE_MAX_SIN_RECARGO,
				CUPO,
				VALOR_HORA,
				VALOR_DIA,
				VALOR_RECARGO
				);
		}
}
