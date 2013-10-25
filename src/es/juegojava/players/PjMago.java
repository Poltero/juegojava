/**
 * 
 */
package es.juegojava.players;

import es.juegojava.common.ClassType;
import es.juegojava.common.Raza;
import es.juegojava.mapa.ItemArma;

/**
 * @author pfranco
 *
 */
public class PjMago extends Player {

	public PjMago(Integer id, String nombre, Raza raza) {
		super(id, nombre, raza, ClassType.MAGO, 20, 50, 100, 1,
				null);
		// TODO Auto-generated constructor stub
	}
	
}
