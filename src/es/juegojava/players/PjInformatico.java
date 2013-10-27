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
public class PjInformatico extends Player {

	public PjInformatico(Integer id, String nombre, Raza raza) {
		super(id, nombre, raza, ClassType.INFORMATICO, 30, 10, 20, 1,
				null);
		// TODO Auto-generated constructor stub
	}

}
