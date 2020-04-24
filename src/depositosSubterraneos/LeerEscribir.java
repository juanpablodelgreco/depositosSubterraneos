package depositosSubterraneos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LeerEscribir {


	public void leerArchivo(LlenarDepositos ld) {
		try {
			Scanner sc = new Scanner(new File(ld.getInputPath()));
			int sup, prof;
			int cantDep = sc.nextInt();
			ld.setCantDepositos(cantDep);
			Deposito[] dep = new Deposito[cantDep];
			for (int i = 0; i < dep.length; i++) {
				sup = sc.nextInt();
				prof = sc.nextInt();
				Deposito d = new Deposito(sup, prof);
				dep[i] = d;
				ld.setEspacioTotalEnM3(ld.getEspacioTotalEnM3() + (sup * prof));

			}
			ld.setVolumenAllenar(sc.nextInt());
			ld.setDepositos(dep);
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el archivo " + ld.getInputPath());
		}

	}
	
	public void escribirArchivo(LlenarDepositos ld) {
		try {
			PrintWriter pw = new PrintWriter(new File(ld.getOutputPath()));
			if(ld.getRebalsa() > 0)
				pw.print("Rebasan: "+ld.getRebalsa());
			else {
			pw.println(ld.getDepositosUtilizados());
			pw.println(ld.getProfundiadDelSuelo());
			}
			pw.close();
			System.out.println(ld.getOutputPath()+" generado con exito!");
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo crear el archivo "+ld.getOutputPath());
		}
		
	}

}
