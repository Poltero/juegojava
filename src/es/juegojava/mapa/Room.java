/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.Element;
import es.juegojava.ui.UIManager;

import java.util.*;

/**
 * @author pfranco
 *
 */
public class Room extends Element
{
	List<Element> connections;
	List<Item> items;

	String descFilePath;
	String descripcion;
	
	public Room(Integer id, String nombre) {
		super(id, nombre);
		
		connections = new ArrayList<Element>();
		items = new ArrayList<Item>();
		descFilePath = "Room" + id + "Desc.txt";
		
		//Cuando creamos la habitacion leemos su descripcion desde el fichero
		//descripcion = leerFichero(descFilePath).toString();
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
	
	public String toString(){
		String descripcionFinal = "";
		
		String descContenido;
		
		descContenido = "Enemigos: " + "NUMEROENEMIGOS" + " NPCs: " + "NUMERONPC" + " Items: " + items.size() + " Puertas: " + connections.size() + "\n";
		
		
		
		return descripcionFinal;
	}
	
}
