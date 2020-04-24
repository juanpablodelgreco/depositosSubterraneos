package depositosSubterraneos;

public class Deposito {
	private int superficie;
	private int profundidad;
	private boolean usado;

	public Deposito(int sup, int prof) {
		this.superficie = sup;
		this.profundidad = prof;
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

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

}
