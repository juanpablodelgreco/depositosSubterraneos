package depositosSubterraneos;

public class Deposito {
	private int superficie;
	private int profundidad;
	
	public Deposito(int sup, int prof) {
		this.superficie = sup;
		this.profundidad = prof;
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

	@Override
	public String toString() {
		return "Deposito [superficie=" + superficie + ", profundidad=" + profundidad + "]";
	}
	
	
}
