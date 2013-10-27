/**
 * 
 */
package es.juegojava.players;

import es.juegojava.common.ClassType;
import es.juegojava.common.Raza;
import es.juegojava.mapa.Item;
import es.juegojava.mapa.ItemArma;

// TODO: Auto-generated Javadoc
/**
 * The Class Enemy.
 *
 * @author pablo.fernandez
 */
public class Enemy extends PjWithClass {

	/** The drop. */
	private Item drop;
	
	/**
	 * Instantiates a new enemy.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 * @param raza the raza
	 * @param classPj the class pj
	 * @param attack the attack
	 * @param defense the defense
	 * @param life the life
	 * @param initiative the initiative
	 * @param currentWeapon the current weapon
	 * @param drop the drop
	 */
	public Enemy(Integer id, String nombre, Raza raza, ClassType classPj,
			int attack, int defense, int life, int initiative, ItemArma currentWeapon, Item drop) {
		
		super(id, nombre, raza, classPj, attack, defense, life, initiative, currentWeapon);
		
		this.drop = drop;
	}
}
