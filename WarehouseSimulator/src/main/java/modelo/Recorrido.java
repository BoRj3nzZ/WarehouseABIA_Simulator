/** @file Almacen.java
 *  @brief Class to create the WorkStation 
 *  @authors
 *  Name          | Surname        | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Ander	      | Olaso          | ander.olaso@alumni.mondragon.edu     |
 *  Borja	      | Garcia         | borja.garcia@alumni.mondragon.edu    |
 *  @date 08/01/2019
 */

/** @brief package modelo
*/
package modelo;

/** @brief Libraries
 */
import java.util.ArrayList;
import java.util.List;

/**
 * @brief Class Recorrido
 */
public class Recorrido {

	/**
	 * @brief Attributes
	 */
	List<Posicion> recorrido;
	Posicion inicio;

	/**
	 * @brief Constructor
	 */
	public Recorrido() {
		recorrido = new ArrayList<Posicion>();
	}

	/**
	 * @brief Constructor
	 */
	public Recorrido(Posicion inicio, Posicion... pos) {
		recorrido = new ArrayList<Posicion>();
		this.inicio = inicio;
		for (Posicion p : pos) {
			recorrido.add(p);
		}
	}

	/**
	 * @brief Method that adds positions to the route
	 * @param pos
	 *            Positions to be added to the route
	 */
	public void añadirPosiciones(Posicion... pos) {
		for (Posicion p : pos) {
			recorrido.add(p);
		}
	}

	/**
	 * @brief Method that adds position to the route
	 * @param pos
	 *            Position to be added to the route
	 */
	public void añadirPosicion(Posicion pos) {
		recorrido.add(pos);
	}

	/**
	 * @brief Method for getting the values of the recorrido variable
	 * @return List<Posicion>
	 */
	public List<Posicion> getRecorrido() {
		List<Posicion> copia = new ArrayList<Posicion>();
		copia.addAll(recorrido);
		return copia;
	}

	/**
	 * @brief Method that returns you the following position of the route
	 * @param pos
	 *            Position you are in
	 * @return Posicion
	 */
	public Posicion getSiguiente(Posicion pos) {
		Posicion siguiente = null;
		int i = 0;
		for (Posicion actual : recorrido) {
			i++;
			if (actual == pos) {
				siguiente = recorrido.get(i);
			}
		}
		return siguiente;
	}

	/**
	 * @brief Method that returns position in which the route begins
	 * @return Posicion
	 */
	public Posicion getInicio() {
		return this.inicio;
	}

	/**
	 * @brief Method that returns position in which the route ends
	 * @return Posicion
	 */
	public Posicion getFinal() {
		return recorrido.get(recorrido.size() - 1);
	}
}
