package depositosSubterraneos;

public class LlenarDepositos {
	private Deposito[] depositos;
	private int cantDepositos;
	private int volumenAllenar;
	private String inputPath;
	private String outputPath;
	private int depositosUtilizados;
	private int profundiadDelSuelo;
	private int espacioTotalEnM3;
	private int rebalsa;

	public LlenarDepositos(String inputPath, String outputPath) {
		this.inputPath = inputPath;
		this.outputPath = outputPath;
		this.depositosUtilizados = 0;
		this.profundiadDelSuelo = 0;
		this.espacioTotalEnM3 = 0;
		this.rebalsa = 0;
	}

	public void llenadoDepositos() {
		LeerEscribir l = new LeerEscribir();
		boolean seguir = true;
		l.leerArchivo(this);
		if (volumenAllenar > this.espacioTotalEnM3) {
			rebalsa = volumenAllenar - this.espacioTotalEnM3;
			seguir = false;
		} else if (volumenAllenar == this.espacioTotalEnM3) {
			depositosUtilizados = cantDepositos;
			profundiadDelSuelo = 0;
			seguir = false;
		}
		if (seguir == true) {
			int profBase = depositos[0].getProfundidad();
			int volumenLlenado = 0;
			int i = 0;
			while (this.volumenAllenar > volumenLlenado) {

				while (this.volumenAllenar > volumenLlenado && depositos[i].getProfundidad() == profBase
						&& i < depositos.length) {
					volumenLlenado += depositos[i].getSuperficie();
					depositos[i].setProfundidad(depositos[i].getProfundidad() - 1);
					depositos[i].setUsado(true);
					if (i + 1 < depositos.length)
						i++;
				}
				if (this.volumenAllenar > volumenLlenado) {
					profBase--;
				}
				i = 0;
			}
			for (Deposito d : depositos) {
				if (d.isUsado() == true)
					this.depositosUtilizados++;
			}
			this.profundiadDelSuelo = profBase - 1;
		}
		l.escribirArchivo(this);
	}

	public String getInputPath() {
		return inputPath;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setDepositos(Deposito[] depositos) {
		this.depositos = depositos;
	}

	public void setCantDepositos(int cantDepositos) {
		this.cantDepositos = cantDepositos;
	}

	public void setVolumenAllenar(int volumenAllenar) {
		this.volumenAllenar = volumenAllenar;
	}

	public void setEspacioTotalEnM3(int espacioTotalEnM3) {
		this.espacioTotalEnM3 = espacioTotalEnM3;
	}

	public int getEspacioTotalEnM3() {
		return espacioTotalEnM3;
	}

	public int getDepositosUtilizados() {
		return depositosUtilizados;
	}

	public int getProfundiadDelSuelo() {
		return profundiadDelSuelo;
	}

	public int getRebalsa() {
		return rebalsa;
	}

}
