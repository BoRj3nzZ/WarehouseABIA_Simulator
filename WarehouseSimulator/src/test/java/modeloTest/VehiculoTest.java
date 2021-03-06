/** @file VehiculoTest.java
 *  @brief Class to test the Articulos class
 *  @authors
 *  Name          | Surname        | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Ander	      | Olaso          | ander.olaso@alumni.mondragon.edu     |
 *  Borja	      | Garcia         | borja.garciag@alumni.mondragon.edu   |
 *  @date 3/12/2018
 *  
 */

/** @brief package modeloTest
 */
package modeloTest;

/** @brief Libraries
 */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import modelo.Parking;
import modelo.Posicion;
import modelo.Segmentos;
import modelo.Vehiculo;
import modelo.WorkStation;

/**
* @brief Class VehiculoTest
*/
public class VehiculoTest {
	
	/**
	 * @brief Attributes
	 */
	private Vehiculo vehiculo;
	private Parking parking;
	private WorkStation ws;
	
	/**
	 * @brief Method to create objects
	 */
	@Before
	public void crearVehiculo()
	{
		parking = new Parking(10, "Parking 1");
		vehiculo = new Vehiculo(1, "Quieto", parking);
		ws = new WorkStation(101, "WorkStation 1");
	}
	
	/**
	 * @brief method that tests the method getEstado
	 */
	@Test
	public void getEstadoTest() {
	    String result = vehiculo.getEstado();
	    assertEquals("Estado debe ser Quieto", "Quieto",(Object)result);
	}
	
	/**
	 * @brief method that tests the method setEstado
	 */
	@Test
	public void setEstadoTest() {
		vehiculo.setEstado("Esperando");
	    String result = vehiculo.getEstado();
	    assertEquals("Estado debe ser Esperando", "Esperando",(Object)result);
	}
	
	/**
	 * @brief method that tests the method getPosicion
	 */
	@Test
	public void getActualPosicionTest() {
	    Posicion result = vehiculo.getActualPosicion();
	    assertEquals("posocion debe ser parking", parking,(Object)result);
	}
	
	/**
	 * @brief method that tests the method getNombre
	 */
	@Test
	public void getNombreTest() {
	    String result = vehiculo.getNombre();
	    assertEquals("posocion debe ser Vehiculo 1", "Vehiculo 1",(Object)result);
	}
	
	/**
	 * @brief method that tests the method mover
	 */
	@Test
	public void moverTest() {
		Segmentos pos2 = new Segmentos(2, "Segmento 2");
		vehiculo.moveToSegment(pos2);
		Posicion result = vehiculo.getActualPosicion();
	    assertEquals("posocion debe ser pos2", pos2,(Object)result);
	    vehiculo.enterWorkStation(ws);
	    Posicion result2 = vehiculo.getActualPosicion();
	    assertEquals("posocion debe ser workstation", ws,(Object)result2);
	    
	}
}
