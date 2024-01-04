package test.testEstado;

import static org.junit.Assert.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import src.fincaRMI.*;

/*
 * Clase a probar: FincaImpl.java
 * Metodos que NO cambian el estado de la clase:
 * 
 * 	-getIdFinca()
 * 	-getNombreFinca()
 * 	-getFincas()
 * 	-getHuertos()
 * 	-getTrabajadores()
 * 	
 **/
public class TestEstado2 {
	
	 	@Test
	    public void testGetIdFinca() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        finca.setIdFinca(1);
	        assertEquals(1, finca.getIdFinca());
	        System.out.println("Prueba testGetIdFinca realizada con exito - Id de finca recuperada");
	    }

	    @Test
	    public void testGetNombreFinca() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        finca.setNombreFinca("FincaTest");
	        assertEquals("FincaTest", finca.getNombreFinca());
	        System.out.println("Prueba testGetNombreFinca realizada con exito - Nombre de finca recuperado");
	    }

	    @Test
	    public void testGetFincas() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        finca.setFincas(null);
	        assertNotNull(finca.getFincas());
	        System.out.println("Prueba testGetFincas realizada con exito - Existe un array <fincas>");
	    }

	    @Test
	    public void testGetHuertos() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        assertNotNull(finca.getHuertos());
	        System.out.println("Prueba testGetHuertos realizada con exito - Existe un array <huertos>");
	    }

	    @Test
	    public void testGetTrabajadores() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        assertNotNull(finca.getTrabajadores());
	        System.out.println("Prueba testGetTrabajadores realizada con exito - Existe un array <trabajadores>");
	    }
	    
	    @Test
	    public void testAssertTrue() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        finca.setFincas(new ArrayList<Finca>());
	        finca.altaFinca(1, "Finca1");
	        assertTrue(finca.getFincas().size() > 1);
	        System.out.println("Prueba testAssertTrue realizada con exito");
	    }

	    @Test
	    public void testAssertFalse() throws RemoteException {
	        FincaImpl.fincas = new ArrayList<Finca>();
	        FincaImpl finca = new FincaImpl();
	        assertFalse(finca.getFincas().size() > 0);
	        System.out.println("Prueba testAssertFalse realizada con exito");
	    }
}
