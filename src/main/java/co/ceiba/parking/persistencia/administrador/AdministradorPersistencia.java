package co.ceiba.parking.persistencia.administrador;

import javax.persistence.EntityManager;

import co.ceiba.parking.dominio.repositorio.CondicionesRepositorio;
import co.ceiba.parking.dominio.repositorio.FacturaRepositorio;
import co.ceiba.parking.dominio.repositorio.IngresadosRepositorio;
import co.ceiba.parking.dominio.repositorio.ParqueaderoRepositorio;
import co.ceiba.parking.dominio.repositorio.RegistroRepositorio;
import co.ceiba.parking.dominio.repositorio.RepositorioAdministrador;
import co.ceiba.parking.dominio.repositorio.VehiculoRepositorio;
import co.ceiba.parking.persistencia.conexion.ConexionJPA;
import co.ceiba.parking.persistencia.repositorio.CondicionesRepositorioPersistente;
import co.ceiba.parking.persistencia.repositorio.FacturaRepositorioPersistente;
import co.ceiba.parking.persistencia.repositorio.IngresadosRepositorioPersistente;
import co.ceiba.parking.persistencia.repositorio.ParqueaderoRepositorioPersistente;
import co.ceiba.parking.persistencia.repositorio.RegistroRepositorioPersistente;
import co.ceiba.parking.persistencia.repositorio.VehiculoRepositorioPersistente;

public class AdministradorPersistencia implements RepositorioAdministrador{
	private EntityManager entityManager;
	private CondicionesRepositorio condicionesRepositorio;
	private FacturaRepositorio facturaRepositorio;
	private IngresadosRepositorio ingresadosRepositorio;
	private ParqueaderoRepositorio parqueaderoRepositorio;
	private RegistroRepositorio registroRepositorio;
	private VehiculoRepositorio vehiculoRepositorio;
	
	public AdministradorPersistencia() {
		entityManager = new ConexionJPA().createEntityManager();
		condicionesRepositorio = new CondicionesRepositorioPersistente(entityManager);
		facturaRepositorio = new FacturaRepositorioPersistente(entityManager);
		ingresadosRepositorio = new IngresadosRepositorioPersistente(entityManager);
		parqueaderoRepositorio = new ParqueaderoRepositorioPersistente(entityManager);
		registroRepositorio = new RegistroRepositorioPersistente(entityManager);
		vehiculoRepositorio = new VehiculoRepositorioPersistente(entityManager);
	}
	
	@Override
	public CondicionesRepositorio getCondicionesRepositorio() {
		return condicionesRepositorio;
	}

	@Override
	public FacturaRepositorio getFacturaRepositorio() {
		return facturaRepositorio;
	}

	@Override
	public IngresadosRepositorio getIngresadosRepositorio() {
		return ingresadosRepositorio;
	}

	@Override
	public ParqueaderoRepositorio getParqueaderoRepositorio() {
		return parqueaderoRepositorio;
	}

	@Override
	public RegistroRepositorio getRegistroRepositorio() {
		return registroRepositorio;
	}

	@Override
	public VehiculoRepositorio getVehiculoRepositorio() {
		return vehiculoRepositorio;
	}

	public void iniciar() {
		entityManager.getTransaction().begin();
	}

	public void terminar() {
		entityManager.getTransaction().commit();
	}
}
