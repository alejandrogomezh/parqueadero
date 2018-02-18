package co.ceiba.parking.dominio;

import java.util.Date;

public class Tiempos implements TiemposInterface{
	private Condiciones condicion;
	private Registro registro;

	private int horasTotal;
	private int horas;
	private int dias;
	
	public Tiempos(Condiciones condicion, Registro registro) {
		this.condicion = condicion;
		this.registro = registro;
	}

	public Tiempos calcular() {
		Date ingreso = registro.getIngreso();
		Date salida = registro.getSalida();

		int horasDiaMinimo = condicion.getHorasDiaMinimo();
		int horasDiaMaximo = condicion.getHorasDiaMaximo();
		
		long segundosTotal = (salida.getTime() - ingreso.getTime()) / 1000;
		int minutosTotal = (int) (segundosTotal / 60);
		horasTotal = (int) (minutosTotal / 60); //cuantos minutos o segundos de mas incrementa la hora
		if((minutosTotal % 60) > 1) {
			horasTotal++; //temporal se incrementa la hora si se pasa de un minuto ejemplo 1 minuto de parqueo equivale a 1 hora
		}
		dias = (horasTotal / horasDiaMaximo);
		horas = (horasTotal % horasDiaMaximo);
		if(horas >= horasDiaMinimo) {
			dias++;
			horas = 0;
		}
		return this;
	}

	@Override
	public Condiciones getCondicion() {
		return condicion;
	}

	@Override
	public Registro getRegistro() {
		return registro;
	}

	@Override
	public int getHorasTotal() {
		return horasTotal;
	}

	@Override
	public int getHoras() {
		return horas;
	}

	@Override
	public int getDias() {
		return dias;
	}

}
