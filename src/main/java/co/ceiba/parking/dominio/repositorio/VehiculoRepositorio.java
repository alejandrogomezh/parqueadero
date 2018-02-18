package co.ceiba.parking.dominio.repositorio;

import co.ceiba.parking.dominio.Vehiculo;

public interface VehiculoRepositorio {
	Vehiculo obtener(Vehiculo vehiculo);
	Vehiculo agregar(Vehiculo vehiculo);
}
