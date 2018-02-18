package co.ceiba.parking.persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.ceiba.parking.dominio.Condiciones;
import co.ceiba.parking.dominio.CondicionesIniciales;
import co.ceiba.parking.dominio.Vehiculo;
import co.ceiba.parking.dominio.repositorio.CondicionesRepositorio;
import co.ceiba.parking.persistencia.constructor.CondicionesConstructor;
import co.ceiba.parking.persistencia.entidad.CondicionesEntity;

public class CondicionesRepositorioPersistente implements CondicionesRepositorio {
	public static final String BUSCAR_POR_TIPO_VEHICULO = "Condiciones.buscarPorTipoVehiculo";

	private EntityManager entityManager;

	public CondicionesRepositorioPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	
	
	@SuppressWarnings("unchecked")
	private Condiciones obtenerPorTipo(String tipo) {
		Query query = entityManager.createNamedQuery(BUSCAR_POR_TIPO_VEHICULO);
		query.setParameter("tipo", tipo);

		List<CondicionesEntity> resultList = query.getResultList();
		return resultList.isEmpty() ? null : CondicionesConstructor.aDominio(resultList.get(0));
	}
	
	@Override
	public Condiciones obtenerPorTipoVehiculo(Vehiculo vehiculo) {
		if(vehiculo == null) return null;
		Condiciones condicion = obtenerPorTipo(vehiculo.getTipo());
		if(condicion == null) {
			condicion = agregar(CondicionesIniciales.get(vehiculo));
		}
		return condicion;
	}

	@Override
	public Condiciones agregar(Condiciones condicion) {
		CondicionesEntity condicionesEntity = CondicionesConstructor.aEntidad(condicion);
		entityManager.persist(condicionesEntity);
		return condicion.setSelfEntity(condicionesEntity);
	}

	@Override
	public Condiciones obtener(Condiciones condicion) {
		if(condicion == null) return null;
		return obtenerPorTipo(condicion.getTipo());
	}

}
