package co.ceiba.parking.persistencia.constructor;

import co.ceiba.parking.dominio.Condiciones;
import co.ceiba.parking.persistencia.entidad.CondicionesEntity;

public class CondicionesConstructor {
	
	public static Condiciones aDominio(CondicionesEntity condicionesEntity) {
		Condiciones condiciones = null;
		if(condicionesEntity != null) {
			condiciones = new Condiciones(
					condicionesEntity.getTipo(),
					condicionesEntity.getHorasDiaMinimo(),
					condicionesEntity.getHorasDiaMaximo(),
					condicionesEntity.getCilindrajeMaxSinRecargo(),
					condicionesEntity.getCupo(),
					condicionesEntity.getValorHora(),
					condicionesEntity.getValorDia(),
					condicionesEntity.getValorRecargo()
					);
			condiciones.setSelfEntity(condicionesEntity);
		}
		return condiciones;
	}
	
	public static CondicionesEntity aEntidad(Condiciones condiciones) {
		CondicionesEntity condicionesEntity = new CondicionesEntity();
		condicionesEntity.setTipo(condiciones.getTipo());
		condicionesEntity.setHorasDiaMinimo(condiciones.getHorasDiaMinimo());
		condicionesEntity.setHorasDiaMaximo(condiciones.getHorasDiaMaximo());
		condicionesEntity.setCilindrajeMaxSinRecargo(condiciones.getCilindrajeMaxSinRecargo());
		condicionesEntity.setCupo(condiciones.getCupo());
		condicionesEntity.setValorHora(condiciones.getValorHora());
		condicionesEntity.setValorDia(condiciones.getValorDia());
		condicionesEntity.setValorRecargo(condiciones.getValorRecargo());
		return condicionesEntity;
	}
	
	
}
