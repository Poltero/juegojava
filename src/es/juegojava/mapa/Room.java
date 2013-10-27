/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.Element;
import es.juegojava.players.Enemy;
import es.juegojava.players.PersonajeNeutro;
import es.juegojava.ui.UIManager;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Room.
 *
 * @author pfranco
 */
public class Room extends Element
{
	
	/** The connections. */
	List<Integer> connections;
	
	/** The items. */
	List<Item> items;
	
	/** The enemies. */
	List<Enemy> enemies;
	
	/** The pjns. */
	List<PersonajeNeutro> pjns;

	/** The descripcion. */
	String descripcion;
	
	/**
	 * Instantiates a new room.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 */
	public Room(Integer id, String nombre) {
		super(id, nombre);
		
		connections = new ArrayList<Integer>();
		items = new ArrayList<Item>();
		enemies = new ArrayList<Enemy>();
		pjns = new ArrayList<PersonajeNeutro>();
	}

	/**
	 * Gets the enemies.
	 *
	 * @return the enemies
	 */
	public List<Enemy> getEnemies() {
		return enemies;
	}

	/**
	 * Sets the enemies.
	 *
	 * @param enemies the enemies to set
	 */
	public void setEnemies(List<Enemy> enemies) {
		this.enemies = enemies;
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * Gets the connections.
	 *
	 * @return the connections
	 */
	public List<Integer> getConnections() {
		return connections;
	}

	/**
	 * Sets the connections.
	 *
	 * @param connections the connections to set
	 */
	public void setConnections(List<Integer> connections) {
		this.connections = connections;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Nombre: "+ nombre +" ["+ descripcion +"] \nEnemigos: " + enemies.size() + " NPCs: " + pjns.size() + " Items: " + items.size() + " Puertas: " + connections.size() + "\n";
	}
	
}
