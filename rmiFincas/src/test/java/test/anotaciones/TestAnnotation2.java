package test.anotaciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import src.fincaRMI.*;

public class TestAnnotation2 {

	
	static FincaImpl finca;
	static FincaImpl finca1;
	static FincaImpl finca2;
	static ArrayList<Finca> listaFincas;
	
	
	@BeforeClass
	public static void testBeforeClass()throws RemoteException {
		System.out.println("Ejecucion de la etiqueta BeforeClass ");
		
    	FincaImpl.fincas = new ArrayList<Finca>();
		
        listaFincas = new ArrayList<Finca>();
		
	}
	
	
	@Before 
	public  void tstBefore() throws RemoteException{
		System.out.println("Ejecucion de Before");
		
        finca1 = new FincaImpl();
        finca2 = new FincaImpl();
        finca  = new FincaImpl(); 
	}
	
	@After
	public  void testAfter() throws RemoteException{
		System.out.println("Ejecucion de AFTER");
		finca1 = null;
        finca2 = null;
        finca  = null;
		
	}
	
	@AfterClass
	public static void testAfterClass()throws RemoteException {
		System.out.println("Ejecucion de la etiqueta AFTERCLASS");
		
		if (FincaImpl.fincas != null) {
	        FincaImpl.fincas.clear();
	        FincaImpl.fincas = null; 
	    }
	}
	
	@Ignore
	public void testIgnorado() {
	    System.out.println("Este print no se vera en la consola de comandos");
	}
	
	
	@Test
    public void testGetIdFinca() throws RemoteException {
        System.out.println("Prueba testGetIdFinca");
        finca.setIdFinca(1);
        assertEquals(1, finca.getIdFinca());
        System.out.println("Prueba testGetIdFinca realizada con exito - Id de finca recuperada");
    }

	@Ignore
    @Test
    public void testGetNombreFinca() throws RemoteException {
        System.out.println("Prueba testGetIdFinca");
        finca.setNombreFinca("FincaTest");
        assertEquals("FincaTestt", finca.getNombreFinca());
        System.out.println("Prueba testGetNombreFinca realizada con exito - Nombre de finca recuperado");
    }
	 @Ignore
	    @Test
	    public void testAssertTrue() throws RemoteException {
	    	System.out.println("Prueba testAssertTrue");

	        finca.setFincas(new ArrayList<Finca>());
	        finca.altaFinca(1, "Finca1");
	        assertTrue(finca.getFincas().size() > 0);
	        System.out.println("Prueba testAssertTrue realizada con exito");
	    }
	@Ignore
    @Test
    public void testGetFincas() throws RemoteException {
        System.out.println("Prueba testGetFincas");
        finca.setFincas(null);
        assertNotNull(finca.getFincas());
        System.out.println("Prueba testGetFincas realizada con exito - Existe un array <fincas>");
    }

    @Test
    public void testGetHuertos() throws RemoteException {
    	System.out.println("Prueba testGetHuertos");

        assertNotNull(finca.getHuertos());
        System.out.println("Prueba testGetHuertos realizada con exito - Existe un array <huertos>");
    }

    @Test
    public void testGetTrabajadores() throws RemoteException {
    	System.out.println("Prueba testGetTrabajadores");

        assertNotNull(finca.getTrabajadores());
        System.out.println("Prueba testGetTrabajadores realizada con exito - Existe un array <trabajadores>");
    }
    
   

    @Ignore
    @Test
    public void testAssertFalse() throws RemoteException {
    	System.out.println("Prueba testAssertFalse");
        //FincaImpl.fincas = new ArrayList<Finca>();
        //FincaImpl finca = new FincaImpl();
        assertFalse(finca.getFincas().size() > 0);
        System.out.println("Prueba testAssertFalse realizada con exito");
    }
	
	
	
	
}
