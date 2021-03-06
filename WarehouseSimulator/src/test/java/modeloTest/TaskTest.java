/** @file TaskTest.java
 *  @brief Class to test the Task class
 *  @authors
 *  Name          | Surname        | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Ander	      | Olaso          | ander.olaso@alumni.mondragon.edu     |
 *  Borja	      | Garcia         | borja.garciag@alumni.mondragon.edu   |
 *  @date 08/01/2019
 *  
 */

/** @brief package modeloTest
 */
package modeloTest;


/** @brief Libraries
 */
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import modelo.Articulos;
import modelo.Posicion;
import modelo.Task;
import modelo.Vehiculo;
import modelo.WorkStation;

/**
* @brief Class TaskTest
*/
public class TaskTest {
	
	/**
	 * @brief Attributes
	 */
	private Task task;
	private Articulos articulo;
	private Posicion pos;
	
	/**
	 * @brief Method to create objects
	 */
	@Before
	public void crearTask()
	{
		pos = new WorkStation(10, "Pos1");
		articulo = new Articulos(1, "Bota Soul", "Bota de monte marron y negro");
		task = new Task(120, articulo,"Espera",pos);
	}
	
	/**
	 * @brief method that tests the method getPosicionFinal
	 */
	@Test
	public void getPosFinalTest() {
	    Posicion result = task.getPosicionFinal();
	    assertEquals("result debe ser pos", pos,(Object)result);
	}
	
	/**
	 * @brief method that tests the method getVehiculo
	 */
	@Test
	public void getVehiculoTest() {
	    Vehiculo result = task.getVehiculo();
	    assertEquals("result debe ser null", null,(Object)result);
	}
	
	/**
	 * @brief method that tests the method setVehiculo
	 */
	@Test
	public void setVehiculoTest() {
		Vehiculo vehiculo = new Vehiculo(1, "Vehiculo 1", pos);
		task.setVehiculo(vehiculo);
	    Vehiculo result = task.getVehiculo();
	    assertEquals("result debe ser vehiculo", vehiculo,(Object)result);
	}
	
	/**
	 * @brief method that tests the method getFecha
	 */
	@Test
	public void getFechaTest() {
	    Date result = task.getFecha();
	    assertEquals("result debe ser null", null,(Object)result);
	}
	
	/**
	 * @brief method that tests the method setFecha
	 */
	@Test
	public void setFechaTest() {
		Date data = new Date();
		task.setFecha(data);
	    Date result = task.getFecha();
	    assertEquals("result debe ser data", data,(Object)result);
	}
	
	/**
	 * @brief method that tests the method getEstado
	 */
	@Test
	public void getEstadoTest() {
	    String result = task.getEstado();
	    assertEquals("result debe ser Espera", "Espera",(Object)result);
	}
	
	/**
	 * @brief method that tests the method setEstado
	 */
	@Test
	public void setEstadoTest() {
		task.setEstado("Listo");;
	    String result = task.getEstado();
	    assertEquals("result debe ser Listo", "Listo",(Object)result);
	}
	
	/**
	 * @brief method that tests the method getId
	 */
	@Test
	public void getIdTest() {
	    int result = task.getId();
	    assertEquals("result debe ser 120", 120,(Object)result);
	}
	
	/**
	 * @brief method that tests the method getArticulo
	 */
	@Test
	public void getArticuloTest() {
	    Articulos result = task.getArticulo();
	    assertEquals("result debe ser articulo", articulo,(Object)result);
	}

}
