/**
 * 
 */
package es.juegojava.players;

import es.juegojava.common.Element;
import es.juegojava.common.Raza;

// TODO: Auto-generated Javadoc
/**
 * The Class Personaje.
 *
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 * 
 */
public class Personaje extends Element
{
	
	/** The raza. */
	Raza raza;
	
	/**
	 * Instantiates a new personaje.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 * @param raza the raza
	 */
	public Personaje(Integer id, String nombre, Raza raza) {
		super(id, nombre);
		
		this.raza = raza;
	}

	/**
	 * Gets the raza.
	 *
	 * @return the raza
	 */
	public Raza getRaza() {
		return raza;
	}

	/**
	 * Sets the raza.
	 *
	 * @param raza the raza to set
	 */
	public void setRaza(Raza raza) {
		this.raza = raza;
	}
	
	
}
