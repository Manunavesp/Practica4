package src.fincaRMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
	
	public Server() {
		try {			
				System.setProperty("java.rmi.server.codebase","file:/C:/directorio/");
				LocateRegistry.createRegistry(8080);
				LocateRegistry.createRegistry(1099);
				LocateRegistry.createRegistry(8081);
				Trabajador t = new TrabajadorImpl();
				Huerto h = new HuertoImpl();
				Finca f = new FincaImpl();
				Naming.rebind("rmi://localhost:8080/FincaTrabService", t);
				Naming.rebind("rmi://localhost:1099/FincaHuService", h);
				Naming.rebind("rmi://localhost:8081/FincaService", f);
				
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

	public static void main(String args[]) {
		new Server();
	}
}
