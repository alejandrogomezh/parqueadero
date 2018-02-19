package co.ceiba.parking.persistencia.constructor;

import co.ceiba.parking.dominio.Factura;
import co.ceiba.parking.dominio.Registro;
import co.ceiba.parking.persistencia.entidad.FacturaEntity;
import co.ceiba.parking.persistencia.entidad.RegistroEntity;

public class FacturaConstructor {

	private FacturaConstructor() {
		
	}
	
	public static Factura aDominio(FacturaEntity facturaEntity) {
		Factura factura = null;
		if(facturaEntity != null) {
			Registro registro = RegistroConstructor.aDominio(facturaEntity.getRegistro());
			factura = new Factura(
					facturaEntity.getGeneracion(),
					registro,
					facturaEntity.getHorasTotal(),
					facturaEntity.getDias(),
					facturaEntity.getHoras(),
					facturaEntity.getValorDias(),
					facturaEntity.getValorHoras(),
					facturaEntity.getValorRecargo(),
					facturaEntity.getValorTotal()
					);
			factura.setSelfEntity(facturaEntity);
		}
		return factura;
	}
	
	public static FacturaEntity aEntidad(Factura factura) {
		RegistroEntity registro = factura.getRegistro().getSelfEntity();
		FacturaEntity facturaEntity = new FacturaEntity();
		facturaEntity.setGeneracion(factura.getGeneracion());
		facturaEntity.setRegistro(registro);
		facturaEntity.setHorasTotal(factura.getHorasTotal());
		facturaEntity.setDias(factura.getDias());
		facturaEntity.setHoras(factura.getHoras());
		facturaEntity.setValorDias(factura.getValorDias());
		facturaEntity.setValorHoras(factura.getValorHoras());
		facturaEntity.setValorRecargo(factura.getValorRecargo());
		facturaEntity.setValorTotal(factura.getValorTotal());

		return facturaEntity;
	}
	
}
