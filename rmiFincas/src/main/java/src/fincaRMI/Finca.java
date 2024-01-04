package src.fincaRMI;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Finca extends java.rmi.Remote{
	
	public void altaFinca(int idFinca, String nombreFinca) 
			throws java.rmi.RemoteException;
	
	public int getIdFinca()
			throws java.rmi.RemoteException;
	
	public void setIdFinca(int idFinca)
			throws java.rmi.RemoteException;
	
	public String getNombreFinca()
			throws java.rmi.RemoteException;
	
	public void setNombreFinca(String nombreFinca)
			throws java.rmi.RemoteException;
	
	
	/** FINCAS */
	public ArrayList<Finca> getFincas() 
			throws java.rmi.RemoteException;

	/** HUERTOS */ 
	public ArrayList<Huerto> getHuertos()
			throws java.rmi.RemoteException;

	public void setHuertos(ArrayList<Huerto> huertos)
			throws java.rmi.RemoteException;

	
	/**TRABAJADORES*/
	public ArrayList<Trabajador> getTrabajadores()
			throws java.rmi.RemoteException;

	public void setTrabajadores(ArrayList<Trabajador> trabajadores)
			throws java.rmi.RemoteException;
	
	public void borrarFinca(int idFinca)
			throws java.rmi.RemoteException;
	
}
