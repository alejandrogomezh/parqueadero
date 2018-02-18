package testdatabuilder;

import co.ceiba.parking.dominio.Condiciones;
import co.ceiba.parking.dominio.Moto;

public class MotoCondicionesTestDataBuilder {
	private static final String TIPO = Moto.TIPO;
	private static final int HORAS_DIA_MINIMO = 9;
	private static final int HORAS_DIA_MAXIMO = 24;
	private static final int CILINDRAJE_MAX_SIN_RECARGO = 500;
	private static final int CUPO = 10;
	private static final double VALOR_HORA = 500;
	private static final double VALOR_DIA = 4000;
	private static final double VALOR_RECARGO = 2000;

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
