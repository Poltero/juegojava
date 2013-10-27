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
 * The Class InventarioEmptyException.
 * Excepcion cuando quieres ver el inventario y esta vacio
 */
public class InventarioEmptyException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new inventario empty exception.
	 *
	 * @param message the message
	 */
	public InventarioEmptyException(String message) {
		super(message);
	}

}
