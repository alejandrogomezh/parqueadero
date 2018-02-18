package co.ceiba.parking.dominio;

import co.ceiba.parking.dominio.repositorio.CondicionesRepositorio;
import co.ceiba.parking.persistencia.entidad.CondicionesEntity;

public class Condiciones {	
	private String tipo;
	private int horasDiaMinimo;
	private int horasDiaMaximo;
	private int cilindrajeMaxSinRecargo;
	private int cupo;
	private double valorHora;
	private double valorDia;
	private double valorRecargo;
	
	public Condiciones(String tipo, int horasDiaMinimo, int horasDiaMaximo, int cilindrajeMaxSinRecargo, int cupo, double valorHora, double valorDia,
			double valorRecargo) {
		super();
		this.tipo = tipo;
		this.horasDiaMinimo = horasDiaMinimo;
		this.horasDiaMaximo = horasDiaMaximo;
		this.cilindrajeMaxSinRecargo = cilindrajeMaxSinRecargo;
		this.cupo = cupo;
		this.valorHora = valorHora;
		this.valorDia = valorDia;
		this.valorRecargo = valorRecargo;
	}

	public String getTipo() {
		return tipo;
	}

	public int getHorasDiaMinimo() {
		return horasDiaMinimo;
	}

	public int getHorasDiaMaximo() {
		return horasDiaMaximo;
	}

	public int getCilindrajeMaxSinRecargo() {
		return cilindrajeMaxSinRecargo;
	}

	public int getCupo() {
		return cupo;
	}

	public double getValorHora() {
		return valorHora;
	}

	public double getValorDia() {
		return valorDia;
	}

	public double getValorRecargo() {
		return valorRecargo;
	}
		
	private CondicionesEntity selfEntity;
	public CondicionesEntity getSelfEntity() {
		return selfEntity;
	}
	public Condiciones setSelfEntity(CondicionesEntity selfEntity) {
		this.selfEntity = selfEntity;
		return this;
	}
	
	public Condiciones persistente(CondicionesRepositorio condicionesRepositorio) {
		Condiciones self = condicionesRepositorio.obtener(this);
		if(self.selfEntity == null) {
			self = condicionesRepositorio.agregar(this);
		}
		if(self != null) this.selfEntity = self.selfEntity;
		return this;
	}

}
