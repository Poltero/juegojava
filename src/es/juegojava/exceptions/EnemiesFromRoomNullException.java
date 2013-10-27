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
 * The Class EnemiesFromRoomNullException.
 * Excepcion producida cuando en la ultima sala del juego donde debe de estar el jefe final no hay nada y esta vacia
 */
public class EnemiesFromRoomNullException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new enemies from room null exception.
	 *
	 * @param message the message
	 */
	public EnemiesFromRoomNullException(String message) {
		super(message);
	}
}
