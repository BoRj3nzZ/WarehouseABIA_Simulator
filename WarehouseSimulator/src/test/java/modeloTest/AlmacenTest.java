/** @file AlmacenTest.java
 *  @brief Class to test the Order class
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Ander	      | Olaso          | ander.olaso@alumni.mondragon.edu     |
 *  @date 2/12/2018
 *  
 */

/** @brief package modeloTest
 */
package modeloTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelo.Almacen;
import modelo.Order;
import modelo.Posicion;
import modelo.Task;
import modelo.Vehiculo;
import modelo.WorkStation;

/** @brief Libraries
 */
/**
* @brief Class AlmacenTest
*/
public class AlmacenTest {

	/**
	 * @brief Attributes
	 */
	private Almacen almacen;
	
	/**
	 * @brief Method to create objects
	 */
	@Before
	public void crearAlmacen()
	{
		almacen = new Almacen();
	}
	
	/**
	 * @brief method that tests the method añadirOrden
	 */
	@Test
	public void añadirOrdenTest() {
		Posicion pos = new WorkStation(10, "Pos1");
		List<Task> lista = new ArrayList<Task>();
		Order orden = new Order(10, pos, lista, "Espera");
		almacen.añadirOrden(orden);
		List<Order> lista2 = almacen.getListaOrdenes();
		boolean result = false;
		for(Order a : lista2){
			if (a == orden) result = true;
		}
	    assertEquals("true", true, (Object)result);
	}
	
	/**
	 * @brief method that tests the method borrarOrden with article
	 */
	@Test
	public void borrarOrden1Test() {
		Posicion pos = new WorkStation(10, "Pos1");
		List<Task> lista = new ArrayList<Task>();
		Order orden = new Order(10, pos, lista, "Espera");
		almacen.añadirOrden(orden);
		almacen.borrarOrden(orden);
		List<Order> lista2 = almacen.getListaOrdenes();
		boolean result = false;
		for(Order a : lista2){
			if (a == orden) result = true;
		}
	    assertEquals("false", false,(Object)result);
	
	}
	/**
	 * @brief method that tests the method borrarOrden with index
	 */
	@Test
	public void borrarOrden2Test() {
		Posicion pos = new WorkStation(10, "Pos1");
		List<Task> lista = new ArrayList<Task>();
		Order orden = new Order(10, pos, lista, "Espera");
		almacen.añadirOrden(orden);
		almacen.borrarOrden(0);
		List<Order> lista2 = almacen.getListaOrdenes();
		boolean result = false;
		for(Order a : lista2){
			if (a == orden)result = true;
		}
	    assertEquals("false", false,(Object)result);
	}
	/**
	 * @brief method that tests the method getListaPosicionTest
	 */
	@Test
	public void getListaPosicionTest() {
		List<Vehiculo> result = almacen.getListaVehiculo();
	}
	/**
	 * @brief method that tests the method getListaPosicionTest
	 */
	@Test
	public void getListaVehiculoTest() {
		List<Posicion> result = almacen.getListaPosicion();
	}
	
}
