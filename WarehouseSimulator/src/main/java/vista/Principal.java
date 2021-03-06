/** @file Principal.java
 *  @brief Class to create the Principal object
 *  @authors
 *  Name          | Surname        | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Borja	      | Garcia         | borja.garciag@alumni.mondragon.edu   |
 *  @date 15/01/2019
 */

/** @brief package vista
 */
package vista;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controlador.AdministradorCaminos;
import controlador.AdministradorCoches;
import controlador.TaskManager;
/** @brief Libraries
 */
import modelo.Almacen;
import modelo.Articulos;
import modelo.Parking;
import modelo.Posicion;
import modelo.Vehiculo;
import modelo.WorkStation;

/**
 * @brief Class Principal extends Thread
 */
public class Principal extends Thread {

	/**
	 * @brief Attributes
	 */
	Almacen almacen;
	Scanner teclado;
	TaskManager taskManager;

	/**
	 * @brief Constructor
	 */
	public Principal() {
		teclado = new Scanner(System.in);
		almacen = new Almacen();
		taskManager = new TaskManager(almacen);
		Parking p;
		for (Vehiculo v : almacen.getAdminCoches().getListaCoches()) {
			v.setAdminCaminos(almacen.getAdminCaminos());
			v.start();
		}
		taskManager.start();
	}

	/**
	 * @brief Method for printing the options of the menu
	 * @return int
	 */
	public int menu() {
		int opcion = 0;
		System.out.println("1.- View vehicles");
		System.out.println("2.- View workstations");
		System.out.println("3.- View parkings");
		System.out.println("0.- Exit");
		System.out.print("Select option: ");
		opcion = teclado.nextInt();
		teclado.nextLine();
		return opcion;

	}

	/**
	 * @brief Method for running the main thread
	 */
	@Override
	public void run() {
		int opcion = 0;
		do {
			try {
				opcion = menu();

				switch (opcion) {
				case 1:
					verCoches();
					break;
				case 2:
					verWorkStations();
					break;
				case 3:
					verParkings();
					break;

				case 0:
					break;
				default:
					System.out.println("Option not valid");
				}

			} catch (InputMismatchException e) {
				System.out.println("Select an opction with a correct number");
			}
		} while (opcion != 0);

	}

	/**
	 * @brief Method for getting the position by the id of it
	 * @return Posicion
	 */
	public Posicion getPositionById(int id) {
		Posicion posicion = null;
		for (Posicion p : almacen.getListaPosicion()) {
			if (p.getId() == id)
				posicion = p;
		}
		return posicion;
	}

	/**
	 * @brief Method for printing the cars in a custom way
	 */
	private void verCoches() {
		for (Vehiculo v : almacen.getAdminCoches().getListaCoches()) {
			System.out.println(v);
		}
		System.out.println("-------------------------------------------------");
	}

	/**
	 * @brief Method for printing the workstations in a custom way
	 */
	private void verWorkStations() {
		for (Posicion ws : almacen.getListaPosicion()) {
			if (ws instanceof WorkStation) {
				System.out.println(ws);
			}
		}
		System.out.println("-------------------------------------------------");
	}

	/**
	 * @brief Method for printing the parkings in a custom way
	 */
	private void verParkings() {
		for (Posicion pk : almacen.getListaPosicion()) {
			if (pk instanceof Parking) {
				System.out.println(pk);
			}
		}
		System.out.println("-------------------------------------------------");
	}

	/**
	 * @brief main
	 * @param args
	 *            String[]
	 */
	public static void main(String[] args) {
		Principal ariketa = new Principal();
		ariketa.start();
	}

}
