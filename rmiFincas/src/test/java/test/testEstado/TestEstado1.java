package test.testEstado;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import src.fincaRMI.*;

/*
 * Clase a probar: FincaImpl.java
 * Metodos que cambian el estado de la clase:
 * 
 * 	-FincaImpl() (Constructor de la clase)
 * 	-altaFinca()
 * 	-setIdFinca()
 * 	-setNombreFinca()
 * 	-setFincas()
 * 	-setHuertos()
 * 	-setTrabajadores()
 * 	-borrarFinca()
 * 	
 * */


public class TestEstado1 {
	  	@Test
	    public void testConstructor() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        assertNotNull(finca);
	        System.out.println("Prueba testConstructor realizada con exito");
	    }

	    @Test
	    public void testAltaFinca() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        finca.altaFinca(1, "Finca1");
	        assertEquals(1, finca.getFincas().size());
	        System.out.println("Prueba testAltaFinca realizada con exito - Finca añadida");
	    }

	    @Test
	    public void testSetIdFinca() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        finca.setIdFinca(2);
	        assertEquals(2, finca.getIdFinca());
	        System.out.println("Prueba testSetIdFinca realizada con exito - Id de finca modificada");
	    }

	    @Test
	    public void testSetNombreFinca() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        finca.setNombreFinca("FincaModificada");
	        assertEquals("FincaModificada", finca.getNombreFinca());
	        System.out.println("Prueba testSetNombreFinca realizada con exito - Nombre de finca modificado");
	    }

	    @Test
	    public void testArrays() throws RemoteException {
	    	FincaImpl.fincas = new ArrayList<Finca>();
	    	FincaImpl finca = new FincaImpl();
	    	finca.altaFinca(1, "Finca1");
	        ArrayList<Finca> array = new ArrayList<Finca>();
	        assertArrayEquals(finca.getFincas().toArray(), array.toArray());
	        System.out.println("Prueba testArrays realizada con exito - Los 2 arrays son iguales");
	    }
	    
	    @Test
	    public void testSetFincas() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        finca.setFincas(null);
	        assertNull(finca.getFincas());
	        System.out.println("Prueba testSetFincas realizada con exito - Ya no hay fincas");
	    }

	    @Test
	    public void testSetHuertos() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        finca.setHuertos(null);
	        assertNull(finca.getHuertos());
	        System.out.println("Prueba testSetHuertos realizada con exito - Ya no hay huertos");
	    }

	    @Test
	    public void testSetTrabajadores() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        finca.setTrabajadores(null);
	        assertNull(finca.getTrabajadores());
	        System.out.println("Prueba testSetTrabajadores realizada con exito - Ya no hay trabajadores");
	    }

	    @Test
	    public void testBorrarFinca() throws RemoteException {
	        FincaImpl finca = new FincaImpl();
	        finca.altaFinca(3, "Finca3");
	        finca.borrarFinca(3);
	        assertEquals(0, finca.getFincas().size());
	        System.out.println("Prueba testBorrarFinca realizada con exito - La finca se ha borrado");
	    }
	    
	    @Test
	    public void testFincasIguales() throws RemoteException {
	        FincaImpl finca1 = new FincaImpl();
	        FincaImpl finca2 = finca1;
	        assertSame(finca1, finca2);
	        System.out.println("Prueba testFincasIguales realizada con exito - Las fincas son iguales");
	    }

	    @Test
	    public void testFincasDistintas() throws RemoteException {
	        FincaImpl finca1 = new FincaImpl();
	        FincaImpl finca2 = new FincaImpl();
	        assertNotSame(finca1, finca2);
	        System.out.println("Prueba testFincasDistintas realizada con exito - Las fincas son distintas");
	    }

}
