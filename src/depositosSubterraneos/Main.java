package depositosSubterraneos;

public class Main {
	public static void main(String[] args) {
		int numero = 5;
		LlenarDepositos ld = new LlenarDepositos("./lote_de_pruebas/Inputs/"+numero+".in", "./lote_de_pruebas/Outputs/"+numero+".out");
		ld.llenadoDepositos();
	}
}
