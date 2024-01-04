package src.fincaRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class TrabajadorImpl extends UnicastRemoteObject implements Trabajador{
	private int id;
	private String nombre;
	private String apellidos;
	private String puesto;
	private double sueldo;
	
	
	protected TrabajadorImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public void altaTrabajador(int idft, int idt, String nombre, String apellidos, String puesto, double sueldo) throws RemoteException {
		TrabajadorImpl trabajador = new TrabajadorImpl();
		trabajador.id=idt;
		trabajador.nombre=nombre;
		trabajador.apellidos=apellidos;
		trabajador.puesto=puesto;
		trabajador.sueldo=sueldo;
		
		Finca f = new FincaImpl();
		for(Finca finca: f.getFincas()) {
			if(idft==finca.getIdFinca()) {
				finca.getTrabajadores().add(trabajador);
			}
		}
	}

	@Override
	public void bajaTrabajador(int idft, int id) throws RemoteException {

		Finca f = new FincaImpl();
		for (Finca finca : f.getFincas()) {
			if (idft == finca.getIdFinca()) {
				for (Trabajador trabajador : finca.getTrabajadores()) {
					if (id == trabajador.getId()) {
						finca.getTrabajadores().remove(trabajador);
						break;
					}
				}
			}
		}

	}

	@Override
	public ArrayList<Trabajador> listarTrabajadores(int idft) throws RemoteException {
		Finca f = new FincaImpl();
		for(Finca finca: f.getFincas()) {
			if(idft==finca.getIdFinca()) {
				return finca.getTrabajadores();
			}
		}
		return null;
	}

	@Override
	public String getNombre() throws RemoteException {
		return nombre;
	}

	@Override
	public String getApellidos() throws RemoteException {
		return apellidos;
	}

	@Override
	public String getPuesto() throws RemoteException {
		return puesto;
	}

	@Override
	public double getSueldo() throws RemoteException {
		return sueldo;
	}

	@Override
	public int getId() throws RemoteException {
		return id;
	}

}
