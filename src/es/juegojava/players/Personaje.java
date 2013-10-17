/**
 * 
 */
package es.juegojava.players;

import es.juegojava.common.Element;
import es.juegojava.common.Raza;

/**
 * @author pfranco
 *
 */
public class Personaje extends Element
{
	Raza raza;
	
	public Personaje(Integer id, String nombre, Raza raza) {
		super(id, nombre);
		
		this.raza = raza;
	}

	/**
	 * @return the raza
	 */
	public Raza getRaza() {
		return raza;
	}

	/**
	 * @param raza the raza to set
	 */
	public void setRaza(Raza raza) {
		this.raza = raza;
	}
	
	
}
