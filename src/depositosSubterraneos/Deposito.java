package depositosSubterraneos;

public class Deposito {
	private int superficie;
	private int profundidad;
	private int maxCapacidad;
	private int llenado;
	private boolean usado;
	
	public Deposito(int sup, int prof) {
		this.superficie = sup;
		this.profundidad = prof;
		this.maxCapacidad = sup * prof;
		this.llenado = 0;
		this.usado = false;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}

	public int getMaxCapacidad() {
		return maxCapacidad;
	}

	public int getLlenado() {
		return llenado;
	}

	public void setLlenado(int llenado) {
		this.llenado = llenado;
	}
	
	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	@Override
	public String toString() {
		return "Deposito [superficie=" + superficie + ", profundidad=" + profundidad + "]";
	}
	
	
}
