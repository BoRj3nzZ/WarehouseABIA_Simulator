/** @file AdministradorCaminos.java
 *  @brief Class to create the AdministradorCaminos object
 *  @authors
 *  Name          | Surname        | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Borja	      | Garcia         | borja.garciag@alumni.mondragon.edu   |
 *  @date 11/12/2018
 */

/** @brief package controlador
 */
package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Almacen;
import modelo.Posicion;
import modelo.Recorrido;

public class AdministradorCaminos {
	
	Almacen almacen;
	List<Recorrido> listaRecorridos = new ArrayList<Recorrido>();

	/**
	 * @brief Constructor
	 * @param almacen The warehouse
	 */
	public AdministradorCaminos(Almacen almacen) {
		this.almacen = almacen;
		listaRecorridos = almacen.getListaRecorridos();
	}
	
	/**
	 * @brief Method for getting the shortest route between two positions
	 * @param inicio Starting position of the route
	 * @param destino Final position of the route
	 */
	public List<Posicion> getShortestRoute(Posicion inicio, Posicion destino){
		List<Posicion> route = new ArrayList<Posicion>();
		for(Recorrido r:listaRecorridos){
			if(r.getInicio()==inicio && r.getFinal()==destino){
				route = r.getRecorrido();
			}
		}
		return route;
	}
	
}
