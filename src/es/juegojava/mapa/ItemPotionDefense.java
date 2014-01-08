/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.ItemsType;
import es.juegojava.logics.Usable;
import es.juegojava.players.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemPotionDefense.
 *
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 * 
 */
public class ItemPotionDefense extends Item implements Usable {
	
	/** The defense points. */
	private int defensePoints;
	
	/**
	 * Instantiates a new item potion defense.
	 *
	 * @param nombre the nombre
	 * @param id the id
	 * @param defensePoints the defense points
	 * @param desc the desc
	 */
	public ItemPotionDefense(String nombre, int id, int defensePoints, String desc) {
		super(nombre, id, ItemsType.POCION, desc);
		
		this.defensePoints = defensePoints;
		super.desc = desc;
	}

	/**
	 * @return the defensePoints
	 */
	public int getDefensePoints() {
		return defensePoints;
	}

	/* (non-Javadoc)
	 * @see es.juegojava.logics.Usable#use(es.juegojava.players.Player)
	 */
	@Override
	public void use(Player player) {
		player.setDefense(player.getDefense() + defensePoints);
	}
}
