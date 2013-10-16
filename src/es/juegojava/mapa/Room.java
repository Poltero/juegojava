/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.Element;

import java.util.*;

/**
 * @author pfranco
 *
 */
public class Room extends Element
{
	List<Element> connections;
	List<Item> items;
	
	public Room(Integer id, String nombre) {
		super(id, nombre);
		
		connections = new ArrayList<Element>();
		items = new ArrayList<Item>();
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @return the connections
	 */
	public List<Element> getConnections() {
		return connections;
	}

	/**
	 * @param connections the connections to set
	 */
	public void setConnections(List<Element> connections) {
		this.connections = connections;
	}
	
	
}
