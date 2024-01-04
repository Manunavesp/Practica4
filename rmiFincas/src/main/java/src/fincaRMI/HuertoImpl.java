package src.fincaRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class HuertoImpl extends UnicastRemoteObject implements Huerto{
	
	
	private int id;
	private String alimentoPlantado;
	private double aguaConsumida;
	private double dimensionesM2;
	private float precioProducto;
	private int cantidadProducto;

	protected HuertoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void altaHuerto(int idh, String alimentoPlantadoh, double aguaConsumidah, double dimensionesM2h, 
						   int idFinca, float precioProducto, int cantidadProducto) throws RemoteException {
		Huerto huerto = new HuertoImpl();
		huerto.setId(idh);
		huerto.setAlimentoPlantado(alimentoPlantadoh);
		huerto.setAguaConsumida(aguaConsumidah);
		huerto.setDimensionesM2(dimensionesM2h);
		huerto.setPrecioProducto(precioProducto);
		huerto.setCantidadProducto(cantidadProducto);
		
		Finca f = new FincaImpl();
		for(Finca finca: f.getFincas()) {
			if(finca.getIdFinca()==idFinca) {
				finca.getHuertos().add(huerto);
			}
		}
		
	}

	@Override
	public void borrarHuerto(int idfh, int id) throws RemoteException {
		Finca f = new FincaImpl();
		for(Finca finca: f.getFincas()) {
			if(finca.getIdFinca()==idfh) {
				for(Huerto huerto: finca.getHuertos()) {
					if(huerto.getId()==id) {
						finca.getHuertos().remove(huerto);
						break;
					}
				}
			}
		}
		
	}
	
	public ArrayList<Huerto> getHuertos(int idfh) {
		Finca f;
		try {
			f = new FincaImpl();
			for(Finca finca: f.getFincas()) {
				if(finca.getIdFinca()==idfh) {
					return finca.getHuertos();
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getAlimentoPlantado() {
		return alimentoPlantado;
	}
	
	public void setAlimentoPlantado(String alimentoPlantado) {
		this.alimentoPlantado = alimentoPlantado;
	}
	
	public double getAguaConsumida() {
		return aguaConsumida;
	}
	
	public void setAguaConsumida(double aguaConsumida) {
		this.aguaConsumida = aguaConsumida;
	}
	
	public double getDimensionesM2() {
		return dimensionesM2;
	}
	
	public void setDimensionesM2(double dimensionesM2) {
		this.dimensionesM2 = dimensionesM2;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public float getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(float precioProducto) {
		this.precioProducto = precioProducto;
	}
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	
}
