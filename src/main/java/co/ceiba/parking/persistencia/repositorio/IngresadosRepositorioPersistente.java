package co.ceiba.parking.persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.ceiba.parking.dominio.Ingresados;
import co.ceiba.parking.dominio.Vehiculo;
import co.ceiba.parking.dominio.repositorio.IngresadosRepositorio;
import co.ceiba.parking.persistencia.constructor.IngresadosConstructor;
import co.ceiba.parking.persistencia.entidad.IngresadosEntity;

public class IngresadosRepositorioPersistente implements IngresadosRepositorio{
	private static final String CANTIDAD_POR_TIPO_VEHICULO = "Ingresados.cantidadPorTipoVehiculo";
	private static final String OBTENER_POR_VEHICULO = "Ingresados.cantidadPorTipoVehiculo";
	
	private EntityManager entityManager;

	public IngresadosRepositorioPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	

	@SuppressWarnings("unchecked")
	@Override
	public int obtenerCantidadPorTipoVehiculo(Vehiculo vehiculo) {
		if(vehiculo == null) return -1;
		
		Query query = entityManager.createNamedQuery(CANTIDAD_POR_TIPO_VEHICULO);
		query.setParameter("tipo", vehiculo.getTipo());

		List<Integer> resultList = query.getResultList();
		return resultList.isEmpty() ? -1 : resultList.get(0);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Ingresados obtenerPorVehiculo(Vehiculo vehiculo) {
		if(vehiculo == null) return null;
		
		Query query = entityManager.createNamedQuery(OBTENER_POR_VEHICULO);
		query.setParameter("placa", vehiculo.getPlaca());

		List<IngresadosEntity> resultList = query.getResultList();
		return resultList.isEmpty() ? null : IngresadosConstructor.aDominio(resultList.get(0));
	}

	@Override
	public Ingresados agregar(Ingresados ingresar) {
		IngresadosEntity ingresadosEntity = IngresadosConstructor.aEntidad(ingresar);
		entityManager.persist(ingresadosEntity);
		return ingresar.setSelfEntity(ingresadosEntity);
	}

}
