package co.ceiba.parking.persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.ceiba.parking.dominio.Parqueadero;
import co.ceiba.parking.dominio.repositorio.ParqueaderoRepositorio;
import co.ceiba.parking.persistencia.constructor.ParqueaderoConstructor;
import co.ceiba.parking.persistencia.entidad.ParqueaderoEntity;

public class ParqueaderoRepositorioPersistente implements ParqueaderoRepositorio {
	private static final String OBTENER_POR_NIT = "Parqueadero.obtenerPorNit";

	private EntityManager entityManager;

	public ParqueaderoRepositorioPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Parqueadero obtener(Parqueadero parqueadero) {
		if(parqueadero == null) return null;
		
		Query query = entityManager.createNamedQuery(OBTENER_POR_NIT);
		query.setParameter("nit", parqueadero.getNit());
		
		List<ParqueaderoEntity> resultList = query.getResultList();
		return resultList.isEmpty() ? null : ParqueaderoConstructor.aDominio(resultList.get(0));

	}	

	@Override
	public Parqueadero agregar(Parqueadero parqueadero) {
		ParqueaderoEntity parqueaderoEntity = ParqueaderoConstructor.aEntidad(parqueadero);
		entityManager.persist(parqueaderoEntity);
		return parqueadero.setSelfEntity(parqueaderoEntity);
	}

}
