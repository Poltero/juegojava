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
public class PjGuerrero extends Player {

	public PjGuerrero(Integer id, String nombre, Raza raza) {
		super(id, nombre, raza, ClassType.GUERRERO, 32, 10, 20, 1,
				null);
		// TODO Auto-generated constructor stub
	}

}
