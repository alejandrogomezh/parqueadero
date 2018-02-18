package co.ceiba.parking.dominio.repositorio;

import co.ceiba.parking.dominio.Parqueadero;

public interface ParqueaderoRepositorio {
	Parqueadero obtener(Parqueadero parqueadero);
	Parqueadero agregar(Parqueadero parqueadero);
}
