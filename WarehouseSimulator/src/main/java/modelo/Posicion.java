/** @file Posicion.java
 *  @brief Class to create the Positions
 *  @authors
 *  Name          | Surname        | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Ander	      | Olaso          | ander.olaso@alumni.mondragon.edu     |
 *  Borja	      | Garcia         | borja.garciag@alumni.mondragon.edu   |
 *  @date 28/11/2018
 */

/** @brief package modelo
 */
package modelo;
import java.util.ArrayList;
/** @brief Libraries
 */
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @brief Class Posicion
 */
public abstract class Posicion {
	
	/**
	 * @brief Attributes
	 */
	int pos;
	boolean lleno;
	String nombre;
	List<Posicion> nextPositionList;
	Semaphore sMutEx;
	Semaphore sEntry;
	
	/**
	 * @brief Constructor
	 * @param nombre position name
	 * @param pos Position ID or position
	 */
	public Posicion(int pos, String nombre){
		this.pos = pos;
		this.nombre = nombre;
		nextPositionList = new ArrayList<Posicion>();
		lleno = false;
	}
	
	/**
	 * @brief Method for getting the value of the pos variable
	 * @return int
	 */
	public int getPos() {
		return pos;
	}
	
	/**
	 * @brief Method for getting the value of the lleno variable
	 * @return boolean
	 */
	public boolean isLleno() {
		return lleno;
	}
	
	/**
	 * @brief Method for setting the state of the position 
	 * @param lleno state of the position
	 */
	public void setLleno(boolean lleno) {
		this.lleno = lleno;
	}
	
	/**
	 * @brief Method for getting the value of the nombre variable
	 * @return String
	 */
	public String getNombre() {
		return nombre; 
	}

	/**
	 * @brief Method for determining if this position is connected to a destination
	 * @return boolean
	 */
	public boolean connectsTo(Posicion destino) {
		boolean isConnected = false;
		for(Posicion p:this.nextPositionList){
			if(p==destino) isConnected=true;
		}
		return isConnected;
	}
	
	/**
	 * @brief Method for determine which positions you can go to
	 * @param pos list of next positions
	 */
	public abstract void addNextPosition(Posicion...pos);

}
