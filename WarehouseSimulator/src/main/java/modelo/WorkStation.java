/** @file WorkStation.java
 *  @brief Class to create the WorkStation 
 *  @authors
 *  Name          | Surname        | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Ander	      | Olaso          | ander.olaso@alumni.mondragon.edu     |
 *  Borja	      | Garcia         | borja.garciag@alumni.mondragon.edu   |
 *  @date 11/01/2019
 */

/** @brief package modelo
 */
package modelo;

import java.util.ArrayList;
/** @brief Libraries
 */
import java.util.List;

/**
 * @brief Class WorkStation extends Posicion
 */
public class WorkStation extends Posicion {

	/**
	 * @brief Attributes
	 */
	List<Articulos> listProductos;

	/**
	 * @brief Constructor
	 * @param nombre
	 *            position name
	 * @param pos
	 *            Position ID or position
	 */
	public WorkStation(int pos, String nombre) {
		super(pos, nombre);
		listProductos = new ArrayList<Articulos>();
		full = false;
	}

	/**
	 * @brief Method for entering the workstation, only one thread can access at
	 *        a time
	 */
	public synchronized void enterWorkStation() {
		full = true;
	}

	/**
	 * @brief Method for exiting the workstation, only one thread can access at
	 *        a time
	 */
	public synchronized void exitWorkStation() {
		full = false;
	}

	/**
	 * @brief Method for waiting at the final workstation, only one thread can
	 *        access at a time
	 */
	public synchronized void waitAtWorkStation() {
		full = true;
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @brief Method for waking up from the workstation, only one thread can
	 *        access at a time
	 */
	public synchronized void wakeUpFromWorkStation() {
		notify();
	}

	/**
	 * @brief Method for determine which positions you can go to
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
	 * @brief Method for add an Articulos to the listProductos
	 * @param new
	 *            Article
	 */
	public void addArticulo(Articulos a) {
		listProductos.add(a);
	}

	/**
	 * @brief Method for delete an product to the listProductos
	 * @param delete
	 *            product index
	 */
	public void deleteArticulo(int index) {
		listProductos.remove(index);
	}

	/**
	 * @brief Method for delete an product to the listProductos
	 * @param delete
	 *            product
	 */
	public void deleteArticulo(Articulos a) {
		listProductos.remove(a);
	}

	/**
	 * @brief Method for getting an item searching by its id
	 * @return Articulos
	 */
	public Articulos getArticulo(int index) {
		Articulos a = listProductos.get(index - 1);
		listProductos.remove(index - 1);
		return a;
	}

	/**
	 * @brief Method for get the List of the listProductos
	 * @return List<Articulos>
	 */
	public List<Articulos> getListProductos() {
		List<Articulos> copia = new ArrayList<Articulos>();
		copia.addAll(listProductos);
		return copia;
	}

	/**
	 * @brief Method for getting an article knowing its id
	 * @param itemId
	 *            The id of the item that needs to be found
	 * @return Articulos
	 */
	public Articulos getArticuloWithId(int itemId) {
		Articulos neededArticle = null;
		for (Articulos a : listProductos) {
			if (a.getId() == itemId)
				neededArticle = a;
		}
		return neededArticle;
	}

	/**
	 * @brief Method for printing the workstation in a custom way
	 * @return String
	 */
	@Override
	public String toString() {
		String cadena;
		cadena = "Workstation " + this.id + " - Full: " + this.full;
		cadena += "\nItems: \n";
		for (Articulos a : listProductos) {
			cadena += a + "\n";
		}
		return cadena;
	}

}
