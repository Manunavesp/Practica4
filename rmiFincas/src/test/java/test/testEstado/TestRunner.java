package test.testEstado;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class TestRunner {
	public static void main(String[] args) {
		 Result result = JUnitCore.runClasses(TestEstado1.class,TestEstado2.class);
		 
		 for (Failure failure : result.getFailures()) {
			 System.out.println(failure.toString());
		 }
		 
		 if(result.wasSuccessful()) {
			 System.out.println("La prueba ha terminado con exito");
		 }else {
			 System.out.println("La prueba ha terminado con errores");
		 }
		 
	}
}