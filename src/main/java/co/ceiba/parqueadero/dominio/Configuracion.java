package co.ceiba.parqueadero.dominio;


public class Configuracion {	private int maximoCarros;
	private int maximoMotos;

	private double valorCarroDia;
	private double valorCarroHora;
	private double valorMotoDia;	private double valorMotoHora;
	private double valorImpuestoMoto;
	
	public Configuracion(int maximoCarros, int maximoMotos, double valorCarroDia, double valorCarroHora,
			double valorMotoDia, double valorMotoHora, double valorImpuestoMoto) {
		this.maximoCarros = maximoCarros;
		this.maximoMotos = maximoMotos;
		this.valorCarroDia = valorCarroDia;
		this.valorCarroHora = valorCarroHora;
		this.valorMotoDia = valorMotoDia;
		this.valorMotoHora = valorMotoHora;
		this.valorImpuestoMoto = valorImpuestoMoto;
	}
	
	public int getMaximoCarros() {
		return maximoCarros;
	}
	
	public int getMaximoMotos() {
		return maximoMotos;
	}
	
	public double getValorCarroDia() {
		return valorCarroDia;
	}
	public double getValorCarroHora() {
		return valorCarroHora;
	}
	
	public double getValorMotoDia() {
		return valorMotoDia;
	}
	
	public double getValorMotoHora() {
		return valorMotoHora;
	}
	
	public double getValorImpuestoMoto() {
		return valorImpuestoMoto;
	}
	
	;
}
