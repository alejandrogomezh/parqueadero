package co.ceiba.parqueadero.dominio;

import java.util.Date;

public class Control {
	private static String MSG_NO_AUTORIZADO_INGRESO = "�no est� autorizado a ingresar!";
	
	public Control() {
		
	}
	
	public void ingreso(Vehiculo vehiculo) {
		Ingreso ingreso = new Ingreso(fechaActual(), vehiculo);
	}
	
	public void salida(Vehiculo vehiculo) {
		Salida salida = new Salida(fechaActual(), vehiculo);
	}
	
	protected Date fechaActual() {
		return new Date();
	}
}
