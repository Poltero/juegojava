/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.ItemsType;
import es.juegojava.logics.Usable;
import es.juegojava.players.Player;


public class ItemPotionInitiative extends Item implements Usable {
	
	private int initiativePoints;
	
	public ItemPotionInitiative(String nombre, int id, int initiativePoints, String desc) {
		super(nombre, id, ItemsType.POCION, desc);
		
		this.initiativePoints = initiativePoints;
		super.desc = desc;
	}

	@Override
	public void use(Player player) {
		player.setAttack(player.getAttack() + initiativePoints);
	}
}
