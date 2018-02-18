package co.ceiba.parking.persistencia.entidad;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name="ingresados")

@NamedQueries({
	@NamedQuery(name = "Ingresados.cantidadPorTipoVehiculo", query = "SELECT COUNT(*) from ingresados where ingresados.tipo = :tipo"),
	@NamedQuery(name = "Ingresados.obtenerPorPlaca", query = "SELECT from ingresados where ingresados.vehiculo.placa = :placa")
}) 
public class IngresadosEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private VehiculoEntity vehiculo;
	private Date ingreso;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Date getIngreso() {
		return ingreso;
	}
	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
	}
}
