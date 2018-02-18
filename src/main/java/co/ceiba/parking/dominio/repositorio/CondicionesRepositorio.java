package co.ceiba.parking.dominio.repositorio;

import co.ceiba.parking.dominio.Condiciones;
import co.ceiba.parking.dominio.Vehiculo;

public interface CondicionesRepositorio {
	Condiciones obtenerPorTipoVehiculo(Vehiculo vehiculo);
	Condiciones obtener(Condiciones condicion);
	Condiciones agregar(Condiciones condicion);
}
