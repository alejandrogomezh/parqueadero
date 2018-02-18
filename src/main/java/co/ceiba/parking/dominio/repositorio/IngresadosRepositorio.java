package co.ceiba.parking.dominio.repositorio;

import co.ceiba.parking.dominio.Ingresados;
import co.ceiba.parking.dominio.Vehiculo;

public interface IngresadosRepositorio {
	int obtenerCantidadPorTipoVehiculo(Vehiculo vehiculo);
	Ingresados obtenerPorVehiculo(Vehiculo vehiculo);
	Ingresados agregar(Ingresados ingresar);
}
