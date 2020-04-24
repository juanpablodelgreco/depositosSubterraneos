package depositosSubterraneos;

import java.util.Arrays;

public class LlenarDepositos {
	private Deposito[] depositos;
	private int cantDepositos;
	private int volumenAllenar;
	private String inputPath;
	private String outputPath;
	private int depositosUtilizados;
	private int profundiadDelSuelo;

	public LlenarDepositos(String inputPath, String outputPath) {
		this.inputPath = inputPath;
		this.outputPath = outputPath;
	}

	public void llenadoDepositos() {
		LeerEscribir l = new LeerEscribir();
		boolean seguir = true;
		l.leerArchivo(this);
		int volumen = 0;
		int rebalsa = 0;
		for (Deposito dp : depositos) {
			volumen += dp.getMaxCapacidad();
		}
		if (volumenAllenar > volumen) {
			rebalsa = volumenAllenar - volumen;
			System.out.println("Rebalsa: "+rebalsa);
			seguir = false;
		} else if (volumenAllenar == volumen) {
			depositosUtilizados = cantDepositos;
			profundiadDelSuelo = 0;
			System.out.println(cantDepositos);
			System.out.println(profundiadDelSuelo);
			seguir = false;
		}
		if (seguir == true) {
			int profBase = depositos[0].getProfundidad();
			int volumenLlenado = 0;
			int i = 0;
			while (this.volumenAllenar > volumenLlenado) {
				
				while (this.volumenAllenar > volumenLlenado && depositos[i].getProfundidad() == profBase
						&& i < depositos.length) {
					System.out.println(i);
					volumenLlenado += depositos[i].getSuperficie();
					System.out.println("SUME " + depositos[i].getSuperficie());
					depositos[i].setProfundidad(depositos[i].getProfundidad() - 1);
					System.out.println("Profundidad->"+depositos[i].getProfundidad());
					System.out.println("Actual profundidad->" + profBase);
					System.out.println("Llenado->" + volumenLlenado);
					System.out.println("A llenar->" + this.volumenAllenar);
					System.out.println("---------------------");
					if(i+1<depositos.length)
						i++;
				}
				if (this.volumenAllenar > volumenLlenado) {
					profBase--;
				}
				i = 0;
			}
			System.out.println(profBase-1);
		}
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

	@Override
	public String toString() {
		return "LlenarDepositos [depositos=" + Arrays.toString(depositos) + ", cantDepositos=" + cantDepositos
				+ ", volumenAllenar=" + volumenAllenar + ", inputPath=" + inputPath + ", outputPath=" + outputPath
				+ "]";
	}
	
	public void mostrarDatos() {
		System.out.println(cantDepositos);
		for(Deposito d:depositos)
			System.out.println(d);
		System.out.println(volumenAllenar);
	}

	/*
	while(depositos[i].getProfundidad() == profBase && this.volumenAllenar > volumenLlenado && i<depositos.length) {
		//if(depositos[i].getMaxCapacidad() > depositos[i].getLlenado()) {}
			volumenLlenado += depositos[i].getSuperficie();
		i++;
	}
	if(depositos[i].getProfundidad() != profBase ) {
		i=0;
		profBase--;
	}*/
	
}
