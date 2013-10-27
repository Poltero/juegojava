/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.ItemsType;
import es.juegojava.logics.Usable;
import es.juegojava.players.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemPotionLife.
 *
 * @author pablo.fernandez
 */
public class ItemPotionLife extends Item implements Usable {

	/** The life points. */
	private int lifePoints;
	
	/**
	 * Instantiates a new item potion life.
	 *
	 * @param nombre the nombre
	 * @param id the id
	 * @param lifePoints the life points
	 * @param desc the desc
	 */
	public ItemPotionLife(String nombre, int id, int lifePoints, String desc) {
		super(nombre, id, ItemsType.POCION, desc);
		
		this.lifePoints = lifePoints;
		super.desc = desc;
		
	}

	/* (non-Javadoc)
	 * @see es.juegojava.logics.Usable#use(es.juegojava.players.Player)
	 */
	@Override
	public void use(Player player) {
		player.setLife(player.getLife() + lifePoints);
	}
	
}
