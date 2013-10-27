/**
 * 
 */
package es.juegojava.exceptions;

// TODO: Auto-generated Javadoc
/**
 *
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 * 
 * The Class InvalidClassPlayerForEquipItem.
 * Excepcion producida cuando la clase del jugador no se corresponde con la clase del objeto que se va a equipar
 */
public class InvalidClassPlayerForEquipItem extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new invalid class player for equip item.
	 *
	 * @param message the message
	 */
	public InvalidClassPlayerForEquipItem(String message) {
		super(message);
	}
	
}
