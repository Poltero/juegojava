/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.ItemsType;
import es.juegojava.logics.Usable;
import es.juegojava.players.Player;


// TODO: Auto-generated Javadoc
/**
 * The Class ItemPotionInitiative.
 * 
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 * 
 * 
 */
public class ItemPotionInitiative extends Item implements Usable {
	
	/** The initiative points. */
	private int initiativePoints;
	
	/**
	 * Instantiates a new item potion initiative.
	 *
	 * @param nombre the nombre
	 * @param id the id
	 * @param initiativePoints the initiative points
	 * @param desc the desc
	 */
	public ItemPotionInitiative(String nombre, int id, int initiativePoints, String desc) {
		super(nombre, id, ItemsType.POCION, desc);
		
		this.initiativePoints = initiativePoints;
		super.desc = desc;
	}

	/* (non-Javadoc)
	 * @see es.juegojava.logics.Usable#use(es.juegojava.players.Player)
	 */
	@Override
	public void use(Player player) {
		player.setAttack(player.getAttack() + initiativePoints);
	}
}
