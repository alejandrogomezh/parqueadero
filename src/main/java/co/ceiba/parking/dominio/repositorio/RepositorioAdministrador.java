package co.ceiba.parking.dominio.repositorio;

public interface RepositorioAdministrador {
	CondicionesRepositorio getCondicionesRepositorio();
	FacturaRepositorio getFacturaRepositorio();
	IngresadosRepositorio getIngresadosRepositorio();
	ParqueaderoRepositorio getParqueaderoRepositorio();
	RegistroRepositorio getRegistroRepositorio();
	VehiculoRepositorio getVehiculoRepositorio();
}
