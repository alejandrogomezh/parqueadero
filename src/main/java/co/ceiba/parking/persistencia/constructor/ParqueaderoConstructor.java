package co.ceiba.parking.persistencia.constructor;

import co.ceiba.parking.dominio.Parqueadero;
import co.ceiba.parking.persistencia.entidad.ParqueaderoEntity;

public class ParqueaderoConstructor {

	public static Parqueadero aDominio(ParqueaderoEntity parqueaderoEntity) {
		Parqueadero parqueadero = null;
		if(parqueaderoEntity != null) {
			parqueadero = new Parqueadero(
					parqueaderoEntity.getNit(),
					parqueaderoEntity.getRazonSocial(),
					parqueaderoEntity.getDireccion(),
					parqueaderoEntity.getTelefono()
					);
			parqueadero.setSelfEntity(parqueaderoEntity);
		}
		return parqueadero;
	}

	public static ParqueaderoEntity aEntidad(Parqueadero parqueadero) {
		ParqueaderoEntity parqueaderoEntity = null;
		parqueaderoEntity = new ParqueaderoEntity();
		parqueaderoEntity.setNit(parqueadero.getNit());
		parqueaderoEntity.setRazonSocial(parqueadero.getRazonSocial());
		parqueaderoEntity.setDireccion(parqueadero.getDireccion());
		parqueaderoEntity.setTelefono(parqueadero.getTelefono());
		return parqueaderoEntity;
	}
}
