/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.ItemsType;

/**
 * @author pablo.fernandez
 *
 */
public class ItemPotionAtack extends Item {
	
	private int atackPoints;
	
	ItemPotionAtack(String nombre, int id, int atackPoints) {
		super(nombre, id, ItemsType.POCION);
		
		this.atackPoints = atackPoints;
		
	}
}
