package co.ceiba.parking.dominio;

import java.util.Date;

import co.ceiba.parking.dominio.Ingresados;
import co.ceiba.parking.dominio.repositorio.CondicionesRepositorio;
import co.ceiba.parking.dominio.repositorio.FacturaRepositorio;
import co.ceiba.parking.dominio.repositorio.IngresadosRepositorio;
import co.ceiba.parking.dominio.repositorio.RegistroRepositorio;
import co.ceiba.parking.dominio.repositorio.RepositorioAdministrador;
import co.ceiba.parking.mensajes.Mensajes;

public class Salida {
	
	private IngresadosRepositorio ingresadosRepositorio;
	private CondicionesRepositorio condicionesRepositorio;
	private RegistroRepositorio registroRepositorio;
	private FacturaRepositorio facturaRepositorio;
	private String msg;
	
	
	public Salida(RepositorioAdministrador repositorioAdministrador) {
		ingresadosRepositorio = repositorioAdministrador.getIngresadosRepositorio();
		condicionesRepositorio = repositorioAdministrador.getCondicionesRepositorio();
		facturaRepositorio = repositorioAdministrador.getFacturaRepositorio();
		registroRepositorio = repositorioAdministrador.getRegistroRepositorio();
		msg = "";
	}
	
	public Factura salir(Date salida, Vehiculo vehiculo) {
		Ingresados ingresado = ingresadosRepositorio.obtenerPorVehiculo(vehiculo);
		if(ingresado != null) {
			Condiciones condicion = condicionesRepositorio.obtenerPorTipoVehiculo(vehiculo);
			Registro registro = new Registro(
					vehiculo,
					ingresado.getIngreso(),
					salida
					).persistente(registroRepositorio);
			Tiempos tiempos = new Tiempos(condicion, registro).calcular();
			Costos costos = new Costos(tiempos).calcular();
			
			return new Factura(
					new Date(),
					registro,
					tiempos.getHorasTotal(),
					tiempos.getDias(),
					tiempos.getHoras(),
					costos.getValorDias(),
					costos.getValorHoras(),
					costos.getValorRecargo(),
					costos.getValorTotal()
					).persistente(facturaRepositorio);
		}else {
			msg = Mensajes.NO_A_INGRESADO;
		}
		return null;
	}
	
	public String getMsg() {
		return msg;
	}
	
}
