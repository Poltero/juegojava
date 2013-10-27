/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.ItemsType;

/**
 * @author pablo.fernandez
 *
 */
public class ItemArmadura extends Item {

	private int defense;
	
	public ItemArmadura(String nombre, int id, int defense, String desc) {
		super(nombre, id, ItemsType.ARMADURA, desc);
		
		this.defense = defense;
	}
	
}
