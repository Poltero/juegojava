/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.Element;
import es.juegojava.players.Enemy;
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
	List<Enemy> enemies;

	String descripcion;
	
	public Room(Integer id, String nombre) {
		super(id, nombre);
		
		connections = new ArrayList<Element>();
		items = new ArrayList<Item>();
		enemies = new ArrayList<Enemy>();
	}

	/**
	 * @return the enemies
	 */
	public List<Enemy> getEnemies() {
		return enemies;
	}

	/**
	 * @param enemies the enemies to set
	 */
	public void setEnemies(List<Enemy> enemies) {
		this.enemies = enemies;
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
