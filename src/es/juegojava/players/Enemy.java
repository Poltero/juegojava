/**
 * 
 */
package es.juegojava.players;

import es.juegojava.common.ClassType;
import es.juegojava.common.Raza;
import es.juegojava.mapa.Item;
import es.juegojava.mapa.ItemArma;

/**
 * @author pablo.fernandez
 *
 */
public class Enemy extends PjWithClass {

	private Item drop;
	
	public Enemy(Integer id, String nombre, Raza raza, ClassType classPj,
			int attack, int defense, int life, int initiative, ItemArma currentWeapon, Item drop) {
		
		super(id, nombre, raza, classPj, attack, defense, life, initiative, currentWeapon);
		
		this.drop = drop;
	}
		
	
}
