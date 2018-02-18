package co.ceiba.parking.persistencia.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name="condiciones")
@NamedQuery(name = "Condiciones.buscarPorTipoVehiculo", query = "SELECT* from condiciones where condiciones.tipo = :tipo")
public class CondicionesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tipo;
	private int horasDiaMinimo;
	private int horasDiaMaximo;
	private int cilindrajeMaxSinRecargo;
	private int cupo;
	private double valorHora;
	private double valorDia;
	private double valorRecargo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getHorasDiaMinimo() {
		return horasDiaMinimo;
	}
	public void setHorasDiaMinimo(int horasDiaMinimo) {
		this.horasDiaMinimo = horasDiaMinimo;
	}
	public int getHorasDiaMaximo() {
		return horasDiaMaximo;
	}
	public void setHorasDiaMaximo(int horasDiaMaximo) {
		this.horasDiaMaximo = horasDiaMaximo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCilindrajeMaxSinRecargo() {
		return cilindrajeMaxSinRecargo;
	}
	public void setCilindrajeMaxSinRecargo(int cilindrajeMaxSinRecargo) {
		this.cilindrajeMaxSinRecargo = cilindrajeMaxSinRecargo;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	public double getValorDia() {
		return valorDia;
	}
	public void setValorDia(double valorDia) {
		this.valorDia = valorDia;
	}
	public double getValorRecargo() {
		return valorRecargo;
	}
	public void setValorRecargo(double valorRecargo) {
		this.valorRecargo = valorRecargo;
	}
}
