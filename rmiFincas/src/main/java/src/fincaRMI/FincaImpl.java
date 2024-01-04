package src.fincaRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class FincaImpl extends UnicastRemoteObject implements Finca{
	
	public FincaImpl() throws RemoteException {
		super();
	}
	
	public FincaImpl(int idFinca, String nombreFinca) throws RemoteException {
		this.idFinca = idFinca;
		this.nombreFinca = nombreFinca;
	}
	
	public static ArrayList<Finca> fincas = new ArrayList<Finca>();
	private ArrayList<Huerto> huertos = new ArrayList<Huerto>();
	private ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>(); 
	
	private int idFinca;
	private String nombreFinca;

	public void altaFinca(int idFinca, String nombreFinca) throws RemoteException{
		fincas.add(new FincaImpl(idFinca, nombreFinca));		
	}

	/** ID FINCA */
	public int getIdFinca() {
		return idFinca;
	}

	public void setIdFinca(int idFinca) {
		this.idFinca = idFinca;
	}

	
	/** NOMBRE FINCA */
	public String getNombreFinca() {
		return nombreFinca;
	}

	public void setNombreFinca(String nombreFinca) {
		this.nombreFinca = nombreFinca;
	}

	
	/** FINCAS */
	public ArrayList<Finca> getFincas(){
		return fincas;
	}
	
	public static void setFincas(ArrayList<Finca> fincas) {
		FincaImpl.fincas = fincas;
	}
	

	/** HUERTOS */ 
	public ArrayList<Huerto> getHuertos() {
		return huertos;
	}

	public void setHuertos(ArrayList<Huerto> huertos) {
		this.huertos = huertos;
	}

	
	/**TRABAJADORES*/
	public ArrayList<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public void borrarFinca(int idFinca){
		for (Finca finca : fincas) {
			try {
				if (finca.getIdFinca() == idFinca) {
					fincas.remove(finca);
					break;
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	
	

}
