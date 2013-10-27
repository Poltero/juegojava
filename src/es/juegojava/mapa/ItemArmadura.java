/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.ItemsType;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemArmadura.
 *
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 * 
 * 
 */
public class ItemArmadura extends Item {

	/** The defense. */
	private int defense;
	
	/**
	 * Instantiates a new item armadura.
	 *
	 * @param nombre the nombre
	 * @param id the id
	 * @param defense the defense
	 * @param desc the desc
	 */
	public ItemArmadura(String nombre, int id, int defense, String desc) {
		super(nombre, id, ItemsType.ARMADURA, desc);
		
		this.defense = defense;
		super.desc = desc;
	}
	
}
