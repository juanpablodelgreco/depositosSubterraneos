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
		l.leerArchivo(this);
		int volumen = 0;
		int rebalsa = 0;
		for(Deposito dp:depositos) {
		volumen +=	dp.getSuperficie() * dp.getProfundidad();
		}
		if(volumenAllenar > volumen ) {
			rebalsa = volumenAllenar - volumen;
			System.out.println(rebalsa);
		}else if(volumenAllenar == volumen) {
			depositosUtilizados = cantDepositos;
			profundiadDelSuelo = 0;
			System.out.println(cantDepositos);
			System.out.println(profundiadDelSuelo);
		}
		int profBase;
		int volumenLlenado = 0;
		for(int i=0; i<cantDepositos; i++) {
			profBase = depositos[i].getProfundidad();
			for(int j=i; j<cantDepositos; j++) {
				if(depositos[j].getProfundidad() == profBase) {
					volumenLlenado += depositos[j].getSuperficie();
				}
			}
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

	
	
	
}
