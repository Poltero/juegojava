/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.ItemsType;
import es.juegojava.logics.Usable;
import es.juegojava.players.Player;


public class ItemPotionInitiative extends Item implements Usable {
	
	private int initiativePoints;
	
	public ItemPotionInitiative(String nombre, int id, int initiativePoints) {
		super(nombre, id, ItemsType.POCION);
		this.initiativePoints = initiativePoints;
	}

	@Override
	public void use(Player player) {
		player.setAttack(player.getAttack() + initiativePoints);
	}
}
