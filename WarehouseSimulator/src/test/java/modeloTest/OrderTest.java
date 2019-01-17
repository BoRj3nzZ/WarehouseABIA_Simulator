/** @file OrderTest.java
 *  @brief Class to test the Order class
 *  @authors
 *  Name          | Surname        | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Ander	      | Olaso          | ander.olaso@alumni.mondragon.edu     |
 *  @date 2/12/2018
 *  
 */

/** @brief package modeloTest
 */
package modeloTest;

/** @brief Libraries
 */
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelo.Articulos;
import modelo.Order;
import modelo.Posicion;
import modelo.Task;
import modelo.WorkStation;

/**
* @brief Class OrderTest
*/
public class OrderTest {
	
	/**
	 * @brief Attributes
	 */
	private List<Task> lista;
	private Order orden;
	private Posicion pos;
	
	/**
	 * @brief Method to create objects
	 */
	@Before
	public void crearOrder(){
		pos = new WorkStation(10, "Pos1");
		orden = new Order(10, pos, "Espera");
	}
	
	@Before
	public void insertarTaskEnOrder(){
		Articulos art = new Articulos(99, "prueba", "articulo prueba");
		System.out.println(art.getNombre());
		Task task = new Task(10, art, "to do",pos);
		System.out.println(task.getId());
		orden.getListaTask().add(task);
	}
	
	/**
	 * @brief method that tests the method getEstado
	 */
	@Test
	public void getEstadoTest() {
	    String result = orden.getEstado();
	    assertEquals("result debe ser Espera", "Espera",(Object)result);
	}
	
	/**
	 * @brief method that tests the method setEstado
	 */
	@Test
	public void setEstadoTest() {
		orden.setEstado("Listo");;
	    String result = orden.getEstado();
	    assertEquals("result debe ser Listo", "Listo",(Object)result);
	}
	
	/**
	 * @brief method that tests the method getId
	 */
	@Test
	public void getIdTest() {
	    int result = orden.getId();
	    assertEquals("result debe ser 10", 10,(Object)result);
	}
	
	/**
	 * @brief method that tests the method getPosicionFinal
	 */
	@Test
	public void getPosFinalTest() {
	    Posicion result = orden.getPosicionFinal();
	    assertEquals("result debe ser pos", pos,(Object)result);
	}
	
	/**
	 * @brief method that tests the method getListaTask
	 */
	@Test
	public void getListaTest() {
		List<Task> result = orden.getListaTask();
	    assertEquals("result debe ser lista", lista,(Object)result);
	}
	
}
