package co.ceiba.parking.dominio;

import java.util.Calendar;
import java.util.Date;

import co.ceiba.parking.dominio.repositorio.CondicionesRepositorio;
import co.ceiba.parking.dominio.repositorio.IngresadosRepositorio;
import co.ceiba.parking.dominio.repositorio.RepositorioAdministrador;
import co.ceiba.parking.mensajes.Mensajes;

public class Ingreso {
	private IngresadosRepositorio ingresadosRepositorio;
	private CondicionesRepositorio condicionesRepositorio;
	
	private String msg;

	public Ingreso(RepositorioAdministrador repositorioAdministrador) {
		this.ingresadosRepositorio = repositorioAdministrador.getIngresadosRepositorio();
		this.condicionesRepositorio = repositorioAdministrador.getCondicionesRepositorio();
		msg = "";
	}

	public Ingresados ingresar(Date fecha, Vehiculo vehiculo) {
		msg = "";
		if (puedeIngresar(fecha, vehiculo)) {
			msg = Mensajes.INGRESO;
			return  new Ingresados(vehiculo, fecha).persistente(ingresadosRepositorio);
		}
		return null;
	}

	public boolean puedeIngresar(Date fecha, Vehiculo vehiculo) {
		Ingresados ingreso = ingresadosRepositorio.obtenerPorVehiculo(vehiculo);
		if(ingreso != null) {
			msg = Mensajes.YA_HABIA_INGRESADO;
			return false;
		}
		String placa = vehiculo.getPlaca().toLowerCase();
		if (placa.startsWith("a")) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fecha);
			int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
			if ((diaSemana == Calendar.SATURDAY) || (diaSemana == Calendar.SUNDAY)) {
				msg = Mensajes.INGRESO_NO_AUTORIZADO;
				return false;
			}
		}
		Condiciones condiciones = condicionesRepositorio.obtenerPorTipoVehiculo(vehiculo);
		if (ingresadosRepositorio.obtenerCantidadPorTipoVehiculo(vehiculo) >= condiciones.getCupo()) {
			msg = Mensajes.NO_HAY_CUPO;
			return false;
		}
		msg = Mensajes.PUEDE_INGRESAR;
		return true;
	}
	
	public String getMsg() {
		return msg;
	}

}
