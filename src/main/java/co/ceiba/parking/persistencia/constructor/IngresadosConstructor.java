package co.ceiba.parking.persistencia.constructor;

import co.ceiba.parking.dominio.Ingresados;
import co.ceiba.parking.dominio.Vehiculo;
import co.ceiba.parking.persistencia.entidad.IngresadosEntity;
import co.ceiba.parking.persistencia.entidad.VehiculoEntity;

public class IngresadosConstructor {

	private IngresadosConstructor() {
		
	}
	
	public static Ingresados aDominio(IngresadosEntity ingresadosEntity) {
		Ingresados ingresados = null;
		if(ingresadosEntity != null) {
			Vehiculo vehiculo = VehiculoConstructor.aDominio(ingresadosEntity.getVehiculo());
			ingresados = new Ingresados(
					vehiculo,
					ingresadosEntity.getIngreso()
					);
			ingresados.setSelfEntity(ingresadosEntity);
		}
		return ingresados;
	}

	public static IngresadosEntity aEntidad(Ingresados ingresados) {
		VehiculoEntity vehiculo = ingresados.getVehiculo().getSelfEntity();
		IngresadosEntity ingresadosEntity = new IngresadosEntity();
		ingresadosEntity.setVehiculo(vehiculo);
		ingresadosEntity.setIngreso(ingresados.getIngreso());
		return ingresadosEntity;
	}
}
