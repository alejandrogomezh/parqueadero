package co.ceiba.parking.dominio;

public class CondicionesIniciales {
	private static final int HORAS_DIA_MINIMO = 9;
	private static final int HORAS_DIA_MAXIMO = 24;
	private static final int CARRO_CILINDRAJE_MAX_SIN_RECARGO = -1;
	private static final int CARRO_CUPO = 20;
	private static final double CARRO_VALOR_HORA = 1000;
	private static final double CARRO_VALOR_DIA = 8000;
	private static final double CARRO_VALOR_RECARGO = 0;
	
	private static final int MOTO_CILINDRAJE_RECARGO = 500;
	private static final int MOTO_CUPO = 10;
	private static final double MOTO_VALOR_HORA = 500;
	private static final double MOTO_VALOR_DIA = 4000;
	private static final double MOTO_VALOR_RECARGO = 2000;
	
	public static Condiciones get(Vehiculo vehiculo) {
		if(vehiculo.getTipo().equals(Moto.TIPO)) {
			return new Condiciones(
					Moto.TIPO,
					HORAS_DIA_MINIMO,
					HORAS_DIA_MAXIMO,
					MOTO_CILINDRAJE_RECARGO,
					MOTO_CUPO,
					MOTO_VALOR_HORA,
					MOTO_VALOR_DIA,
					MOTO_VALOR_RECARGO
					);
		}else {
			return new Condiciones(
					Carro.TIPO,
					HORAS_DIA_MINIMO,
					HORAS_DIA_MAXIMO,
					CARRO_CILINDRAJE_MAX_SIN_RECARGO,
					CARRO_CUPO,
					CARRO_VALOR_HORA,
					CARRO_VALOR_DIA,
					CARRO_VALOR_RECARGO
					);

		}
	}

}
