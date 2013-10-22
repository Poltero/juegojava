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
public class ItemPotionAtack extends Item implements Usable {
	
	private int attackPoints;
	
	ItemPotionAtack(String nombre, int id, int attackPoints) {
		super(nombre, id, ItemsType.POCION);
		
		this.attackPoints = attackPoints;
		
	}

	@Override
	public void use(Player player) {
		player.setAttack(player.getAttack() + attackPoints);
	}
}
