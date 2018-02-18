package co.ceiba.parking.dominio;

import java.util.Date;

import co.ceiba.parking.dominio.repositorio.RepositorioAdministrador;

public class Vigilante {
	private Ingreso ingreso;
	private Salida salida;
	
	public Vigilante(RepositorioAdministrador repositorioAdministrador) {
		ingreso = new Ingreso(repositorioAdministrador);
		salida = new Salida(repositorioAdministrador);
	}
	
	public Ingresados ingreso(Vehiculo vehiculo) {
		return ingreso.ingresar(fechaActual(), vehiculo);
	}
	
	public void salida(Vehiculo vehiculo) {
		salida.salir(fechaActual(), vehiculo);
	}
	
	protected Date fechaActual() {
		return new Date();
	}
}
