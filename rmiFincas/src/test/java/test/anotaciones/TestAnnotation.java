package test.anotaciones;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import src.fincaRMI.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestAnnotation {

	static FincaImpl finca;
	static FincaImpl finca1;
	static FincaImpl finca2;
	static ArrayList<src.fincaRMI.Finca> listaFincas;
	
	
	@BeforeClass /** Esto se ejecuta una sola vez, antes de todo */
	public static void testBeforeClass()throws RemoteException {
		System.out.println("Ejecucion de la etiqueta BeforeClass ");
		
		FincaImpl.fincas = new ArrayList<Finca>();
		
        listaFincas = new ArrayList<Finca>();
		
	}
	
	
	@Before  /** Esto se va a ejecutar antes de cada prueba */
	public  void tstBefore() throws RemoteException{
		System.out.println("Ejecucion de Before");
		
        finca1 = new FincaImpl();
        finca2 = new FincaImpl();
        finca  = new FincaImpl(); //se va a modificar, conviene tenerla bien en cada prueba
		
	}
	
	@After  /** Esto se va a ejecutar despues de cada prueba */
	public  void testAfter() throws RemoteException{
		System.out.println("Ejecucion de AFTER");
		finca1 = null;
        finca2 = null;
        finca  = null;
		
	}
	
	@AfterClass /** Esto se ejecuta una vez, Al final */
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
    public void testConstructor() throws RemoteException {
        assertNotNull(finca);
        System.out.println("Prueba testConstructor realizada con exito");
    }

    @Test
    public void testAltaFinca() throws RemoteException {
        finca.altaFinca(1, "Finca1");
        assertEquals(1, finca.getFincas().size());
        System.out.println("Prueba testAltaFinca realizada con exito - Finca aniadida");
    }

    @Test
    public void testSetIdFinca() throws RemoteException {

        finca.setIdFinca(2);
        assertEquals(2, finca.getIdFinca());
        System.out.println("Prueba testSetIdFinca realizada con exito - Id de finca modificada");
    }

    @Test
    public void testSetNombreFinca() throws RemoteException {

        finca.setNombreFinca("FincaModificada");
        assertEquals("FincaModificada", finca.getNombreFinca());
        System.out.println("Prueba testSetNombreFinca realizada con exito - Nombre de finca modificado");
    }

    @Ignore
    @Test
    public void testArrays() throws RemoteException {
    	System.out.println("PRueba de arrays ");
    	finca.altaFinca(1, "Finca1");
        assertArrayEquals(finca.getFincas().toArray(), listaFincas.toArray());
        System.out.println("Prueba testArrays realizada con exito - Los 2 arrays son iguales");
    }
    
    @Ignore
    @Test
    public void testSetFincas() throws RemoteException {
        
        finca.setFincas(null);
        assertNull(finca.getFincas());
        System.out.println("Prueba testSetFincas realizada con exito - Ya no hay fincas");
    }

    @Test
    public void testSetHuertos() throws RemoteException {
       
        finca.setHuertos(null);
        assertNull(finca.getHuertos());
        System.out.println("Prueba testSetHuertos realizada con exito - Ya no hay huertos");
    }

    @Test
    public void testSetTrabajadores() throws RemoteException {
        
        finca.setTrabajadores(null);
        assertNull(finca.getTrabajadores());
        System.out.println("Prueba testSetTrabajadores realizada con exito - Ya no hay trabajadores");
    }

    @Ignore
    @Test
    public void testBorrarFinca() throws RemoteException {
        System.out.println("Prueba de borrar fincaa");
        finca.altaFinca(3, "Finca3");
        finca.borrarFinca(3);
        assertEquals(0, finca.getFincas().size());
        System.out.println("Prueba testBorrarFinca realizada con exito - La finca se ha borrado");
    }
    
    @Test
    public void testFincasIguales() throws RemoteException {
        finca2 = finca1;
        assertSame(finca1, finca2);
        System.out.println("Prueba testFincasIguales realizada con exito - Las fincas son iguales");
    }

    @Test
    public void testFincasDistintas() throws RemoteException {

        assertNotSame(finca1, finca2);
        System.out.println("Prueba testFincasDistintas realizada con exito - Las fincas son distintas");
    }
    

}

/**
 * 
 * BEFORE  se ejecuta antes de cada prueba. Si tengo , por ejemplo que inicializar algo
 * La idea es que el before, por ejemplo se use para inicializar clases, que se van a tener que instanciar
 * cada vez que se haga algo, pues como no forma parte como tal de la prueba, sino que es algo que necesitamos
 * 
 * El AFTER se ejcuta despues de cada prueba, por ejemplo para limpiar las clases
 * 
 * BEFORECLASS
 * 
 * AFTERCLASS
 * 
 * Con el after se indica que este m�todo se ejecutara DESPUES de cada metodo de la prueba en la clase
 */
