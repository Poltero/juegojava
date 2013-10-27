/**
 * 
 */
package es.juegojava.exceptions;

/**The Class OptionInvalidException.
 *
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 * 
 * The Class OptionInvalidException.
 * Ecepcion que salta cuando la opcion elegida no es valida
 */
public class OptionInvalidException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new option invalid exception.
	 *
	 * @param message the message
	 */
	public OptionInvalidException(String message) {
		super(message);
	}
	
}
