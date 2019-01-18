/** @file TaskManager.java
 *  @brief Class to create the TaskManager object
 *  @authors
 *  Name          | Surname        | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Borja	      | Garcia         | borja.garciag@alumni.mondragon.edu   |
 *  @date 11/01/2019
 */

/** @brief package controlador
 */
package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Almacen;
import modelo.Articulos;
import modelo.Order;
import modelo.Posicion;
import modelo.Task;
import modelo.Vehiculo;
import modelo.WorkStation;

public class TaskManager extends Thread {
	/**
	 * @brief Attributes
	 */
	Almacen almacen;
	List<Order> listaOrdenes = new ArrayList<Order>();

	/**
	 * @brief Constructor
	 * @param almacen
	 *            The warehouse
	 */
	public TaskManager(Almacen almacen) {
		this.almacen = almacen;
		listaOrdenes = almacen.getListaOrdenes();
	}

	/**
	 * @brief Method for getting the workstation which has a unique item inside
	 * @param itemId
	 *            The item that needs to be found
	 * @return Posicion
	 */
	public Posicion getWorkStationWithItemInside(int itemId) {
		Posicion ws = null;
		for (Posicion p : almacen.getListaPosicion()) {
			if (p instanceof WorkStation) {
				for (Articulos a : ((WorkStation) p).getListProductos()) {
					if (a.getId() == itemId)
						ws = p;
				}
			}
		}
		return ws;
	}

	/**
	 * @brief Method for starting next available, not started task.
	 * @param task
	 *            The task to be started
	 * @return boolean If a car has been assigned (and the task started), true
	 *         is returned.
	 */
	public boolean startNextTask(Task task) {
		Vehiculo assignedCar;
		Posicion destination, itemWS;
		Articulos item;
		Boolean started = false;

		assignedCar = almacen.getAdminCoches().getFirstFreeCar();
		if (assignedCar != null) {
			started = true;
			item = task.getArticulo();
			destination = task.getPosicionFinal();
			itemWS = getWorkStationWithItemInside(item.getId());

			System.out.println("car: " + assignedCar.getIdal() + "item: " + item.getId() + ", destination: "
					+ destination.getId() + ", itemWS: " + itemWS.getId());

			assignedCar.setTask(task);

			Almacen.cambiarAsignacionCocheTaskDB(task.getId(), task.getArticulo().getId(), assignedCar.getIdal());
			almacen.getAdminCoches().setCarData(assignedCar, assignedCar.getActualPosicion(), itemWS, destination,
					item.getId());
		}
		return started;
	}

	public void startNextOrder() {

	}

	/**
	 * @brief Method to run the thread
	 */
	@Override
	public void run() {
		while (true) {
			almacen.leerOrdenesNuevasDesdeDB();
			listaOrdenes = almacen.getListaOrdenes();
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				this.interrupt();
				e.printStackTrace();
			}
			if (!listaOrdenes.isEmpty()) {
				for (Order o : listaOrdenes) {
					almacen.leerNewTasksDeOrdenDesdeDB(o.getId());
					for (Task t : o.getListaTask()) {
						System.out.println("Articulo " + t.getArticulo().getId() + " en order: " + o.getId());
						if (startNextTask(t)) {
							o.getListaTask().remove(t);
							Almacen.cambiarEstadoOrderDB(o, "in process");
							Almacen.cambiarEstadoTaskDB(o.getId(), t.getArticulo().getId(), "doing");
						}
					}
					if (o.getListaTask().isEmpty()) {
						Almacen.cambiarEstadoOrderDB(o, "checked");
					}
				}
			}
		}
	}

}
