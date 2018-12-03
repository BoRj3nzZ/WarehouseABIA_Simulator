/** @file Posicion.java
 *  @brief Class to create the Positions
 *  @authors
 *  Name          | Suname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Ander	      | Olaso          | ander.olaso@alumni.mondragon.edu     |
 *  @date 28/11/2018
 */

/** @brief package modelo
 */
package modelo;

/** @brief Libraries
 */
import java.util.ArrayList;
import java.util.List;

/**
 * @brief Class Posicion
 */
public abstract class Posicion {
	
	/**
	 * @brief Attributes
	 */
	int id;
	boolean lleno;
	String nombre;
	List<Posicion> nextPosition;
	
	/**
	 * @brief Constructor
	 * @param nombre position name
	 * @param pos Position ID or position
	 */
	public Posicion(int id, String nombre){
		this.id = id;
		this.nombre = nombre;
		nextPosition = new ArrayList<Posicion>();
		lleno = false;
	}
	
	/**
	 * @brief Method for get the value of the id variable
	 * @return int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @brief Method for get the value of the lleno variable
	 * @return boolean
	 */
	public boolean isLleno() {
		return lleno;
	}
	
	/**
	 * @brief Method for determine the state of the position 
	 * @param lleno state of the position
	 */
	public void setLleno(boolean lleno) {
		this.lleno = lleno;
	}
	
	/**
	 * @brief Method for get the value of the nombre variable
	 * @return String
	 */
	public String getNombre() {
		return nombre; 
	}
	
	/**
	 * @brief Method for determine which positions you can go to
	 * @param pos list of next positions
	 */
	public abstract void addNextPosition(Posicion...pos);

}
