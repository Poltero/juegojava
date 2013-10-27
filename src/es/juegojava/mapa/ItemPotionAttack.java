/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.ItemsType;
import es.juegojava.logics.Usable;
import es.juegojava.players.Player;

/**
 * @author pablo.fernandez
 *
 */
public class ItemPotionAttack extends Item implements Usable {
	
	private int attackPoints;
	
	public ItemPotionAttack(String nombre, int id, int attackPoints, String desc) {
		super(nombre, id, ItemsType.POCION, desc);
		
		this.attackPoints = attackPoints;
		super.desc = desc;
	}

	@Override
	public void use(Player player) {
		player.setAttack(player.getAttack() + attackPoints);
	}
}
