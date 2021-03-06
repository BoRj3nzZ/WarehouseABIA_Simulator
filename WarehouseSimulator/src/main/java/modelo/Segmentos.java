/** @file Segmentos.java
 *  @brief Class to create the segments object
 *  @authors
 *  Name          | Surname        | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Ander	      | Olaso          | ander.olaso@alumni.mondragon.edu     |
 *  Borja	      | Garcia         | borja.garciag@alumni.mondragon.edu   |
 *  @date 10/12/2018
 */

/** @brief package modelo
 */
package modelo;

import java.util.ArrayList;
/** @brief Libraries
 */
import java.util.List;

/**
 * @brief Class Segmentos extends Posicion
 */
public class Segmentos extends Posicion {

	/**
	 * @brief Attributes
	 */
	static int distancia = 200;

	/**
	 * @brief Constructor
	 * @param nombre
	 *            position name
	 * @param pos
	 *            Position ID or position
	 */
	public Segmentos(int pos, String nombre) {
		super(pos, nombre);
		full = false;
	}

	/**
	 * @brief Method for entering the segment, only one thread can access at a
	 *        time
	 */
	public synchronized void enterSegment() {
		while (full) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		full = true;
	}

	/**
	 * @brief Method for exiting the segment, only one thread can access at a
	 *        time
	 */
	public synchronized void exitSegment() {
		full = false;
		notify();
	}

	/**
	 * @brief Method for determining which positions you can go to
	 * @param pos
	 *            list of next positions
	 */
	@Override
	public void addNextPosition(Posicion... pos) {
		for (Posicion p : pos) {
			nextPositionList.add(p);
		}
	}

	/**
	 * @brief Method for getting the values of the nextPositionList variable
	 * @return List<Position>
	 */
	public List<Posicion> getNextPositionList() {
		List<Posicion> copia = new ArrayList<Posicion>();
		copia.addAll(nextPositionList);
		return copia;
	}

	/**
	 * @brief Method for getting the values of the distancia variable
	 * @return int
	 */
	public int getDistancia() {
		return distancia;
	}

}
