/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.ItemsType;

/**
 * @author pablo.fernandez
 *
 */
public class ItemPotionLife extends Item {

	private int lifePoints;
	
	ItemPotionLife(String nombre, int id, int lifePoints) {
		super(nombre, id, ItemsType.POCION);
		
		this.lifePoints = lifePoints;
		
	}
	
}
