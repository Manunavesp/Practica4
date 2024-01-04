package src.fincaRMI;

import java.util.ArrayList;

public interface Trabajador extends java.rmi.Remote{
	
	
	public void altaTrabajador(int idft, int idt,String nombre, String apellidos, String puesto, double sueldo) 
			throws java.rmi.RemoteException;

	public void bajaTrabajador(int idft,int id)
			throws java.rmi.RemoteException;
	
	public ArrayList<Trabajador> listarTrabajadores(int idft) 
			throws java.rmi.RemoteException;
	
	public int getId()
			throws java.rmi.RemoteException;
	
	public String getNombre()
			throws java.rmi.RemoteException;
	
	public String getApellidos()
			throws java.rmi.RemoteException;
	
	public String getPuesto()
			throws java.rmi.RemoteException;
	
	public double getSueldo()
			throws java.rmi.RemoteException;
}

	