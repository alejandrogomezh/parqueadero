package co.ceiba.parqueadero.domain;

import java.util.Calendar;
import java.util.Date;

import co.ceiba.parqueadero.repositorio.RepositorioEstacionados;

public class Ingreso {
	private Vehiculo vehiculo;
	private Date fecha;
	
	private RepositorioEstacionados repositorioEstacionados;

	public Ingreso(Date fecha, Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		this.fecha = fecha;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Date getFecha() {
		return fecha;
	}

	public boolean puedeIngresar() {
		if(Moto.esMoto(vehiculo)) {
			String placa = vehiculo.getPlaca().toLowerCase();
			if(placa.startsWith("a")) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(fecha);
				int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
				if((diaSemana == Calendar.SATURDAY) || (diaSemana == Calendar.SUNDAY)) {
					return false;
				}
			}
			if(repositorioEstacionados.obtenerCantidadMotos() > 10) {
				return false;
			}
		}else {
			if(repositorioEstacionados.obtenerCantidadCarros() > 20) {
				return false;
			}
		}
		return true;
	}
		
}
