/** @file Parking.java
 *  @brief Class to create the Parking object
 *  @authors
 *  Name          | Suname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Ander	      | Olaso          | ander.olaso@alumni.mondragon.edu     |
 *  @date 28/11/2018
 */

/** @brief package modelo
 */
package modelo;

/**
 * @brief Class WorkStation extends Posicion
 */
public class Parking extends Posicion{
	
	/**
	 * @brief Constructor
	 * @param nombre position name
	 * @param pos Position ID or position
	 */
	public Parking(int pos, String nombre) {
		super(pos, nombre);
	}

	/**
	 * @brief Method for determine which positions you can go to
	 * @param pos list of next positions
	 */
	@Override
	public void addNextPosition(Posicion... pos) {
		for(Posicion p : pos){
			nextPositionList.add(p);
		}
	}
	
	/**
	 * @brief Method for get the value of the nextPosition variable
	 * @return Posicion
	 */
	public Posicion getNextPosition(){
		for(Posicion p : nextPositionList){
			return p;
		}
		return null;
	}

}
