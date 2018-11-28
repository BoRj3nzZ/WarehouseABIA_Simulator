/** @file Circuito.java
 *  @brief Class to create the vehicle object
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
 * @brief Class Vehiculo
 */
public class Vehiculo {

	/**
	 * @brief Attributes
	 */
	int id;
	String nombre, estado;
	Posicion posicion;
	
	/**
	 * @brief Constructor
	 * @param id vehicle ID
	 * @param estado vehicle state
	 * @param posicion vehicle position
	 */
	public Vehiculo(int id, String estado, Posicion posicion){
		this.id = id;
		nombre = "Vehiculo"+id;
		this.estado = estado;
		this.posicion = posicion;
	}

	/**
	 * @brief Method for get the value of the estado variable
	 * @return String
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @brief Method for determine the state of the vehicle 
	 * @param estado state of the vehicle
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @brief Method for get the value of the posicion variable
	 * @return Posicion
	 */
	public Posicion getPosicion() {
		return posicion;
	}

	/**
	 * @brief Method for determine the position of the vehicle 
	 * @param posicion position of the vehicle
	 */
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	/**
	 * @brief Method for get the value of the id variable
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * @brief Method for get the value of the nombre variable
	 * @return String
	 */
	public String getNombre() {
		return nombre;
	}
	
	
}