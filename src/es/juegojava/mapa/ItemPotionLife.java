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
public class ItemPotionLife extends Item implements Usable {

	private int lifePoints;
	
	public ItemPotionLife(String nombre, int id, int lifePoints, String desc) {
		super(nombre, id, ItemsType.POCION, desc);
		
		this.lifePoints = lifePoints;
		super.desc = desc;
		
	}

	@Override
	public void use(Player player) {
		player.setLife(player.getLife() + lifePoints);
	}
	
}
