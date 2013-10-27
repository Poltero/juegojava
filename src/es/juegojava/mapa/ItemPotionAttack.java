/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.ItemsType;
import es.juegojava.logics.Usable;
import es.juegojava.players.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemPotionAttack.
 *
 * @author pablo.fernandez
 */
public class ItemPotionAttack extends Item implements Usable {
	
	/** The attack points. */
	private int attackPoints;
	
	/**
	 * Instantiates a new item potion attack.
	 *
	 * @param nombre the nombre
	 * @param id the id
	 * @param attackPoints the attack points
	 * @param desc the desc
	 */
	public ItemPotionAttack(String nombre, int id, int attackPoints, String desc) {
		super(nombre, id, ItemsType.POCION, desc);
		
		this.attackPoints = attackPoints;
		super.desc = desc;
	}

	/* (non-Javadoc)
	 * @see es.juegojava.logics.Usable#use(es.juegojava.players.Player)
	 */
	@Override
	public void use(Player player) {
		player.setAttack(player.getAttack() + attackPoints);
	}
}
