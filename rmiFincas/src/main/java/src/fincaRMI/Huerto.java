package src.fincaRMI;

import java.util.ArrayList;

public interface Huerto extends java.rmi.Remote{

	public void altaHuerto(int id, String alimentoPlantado, double aguaConsumida, double dimensionesM2, int idFinca,float precioProducto, int cantidadProducto)
			throws java.rmi.RemoteException;
	
	public void borrarHuerto(int idfh, int id)
			throws java.rmi.RemoteException;
	
	public String getAlimentoPlantado() 
			throws java.rmi.RemoteException;
	
	public void setAlimentoPlantado(String alimentoPlantado) 
			throws java.rmi.RemoteException;
	
	public double getAguaConsumida() 
			throws java.rmi.RemoteException;
	
	public void setAguaConsumida(double aguaConsumida) 
			throws java.rmi.RemoteException;
	
	public double getDimensionesM2()
			throws java.rmi.RemoteException;
	
	public void setDimensionesM2(double dimensionesM2) 
			throws java.rmi.RemoteException;
	
	public ArrayList<Huerto> getHuertos(int idfh) 
			throws java.rmi.RemoteException;
	
	public int getId()
			throws java.rmi.RemoteException;
	
	public void setId(int id) 
			throws java.rmi.RemoteException;
	
	public float getPrecioProducto() 
			throws java.rmi.RemoteException;
	
	public void setPrecioProducto(float precioProducto)
			throws java.rmi.RemoteException;
	
	public int getCantidadProducto()
			throws java.rmi.RemoteException;
	
	public void setCantidadProducto(int cantidadProducto) 
			throws java.rmi.RemoteException;
	
}
