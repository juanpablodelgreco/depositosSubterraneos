package depositosSubterraneos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerEscribir {


	public void leerArchivo(LlenarDepositos ld) {
		try {
			Scanner sc = new Scanner(new File(ld.getInputPath()));
			int cantDep = sc.nextInt();
			ld.setCantDepositos(cantDep);
			Deposito[] dep = new Deposito[cantDep];
			for(int i=0; i<dep.length; i++) {
				Deposito d = new Deposito(sc.nextInt(), sc.nextInt());
				dep[i] = d;
			}
			ld.setVolumenAllenar(sc.nextInt());
			ld.setDepositos(dep);
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el archivo "+ld.getInputPath());
		}
		
		
	}

}
