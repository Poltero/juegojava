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
public class ItemPotionDefense extends Item implements Usable {
	
	private int defensePoints;
	
	public ItemPotionDefense(String nombre, int id, int defensePoints, String desc) {
		super(nombre, id, ItemsType.POCION, desc);
		
		this.defensePoints = defensePoints;
	}

	@Override
	public void use(Player player) {
		player.setDefense(player.getDefense() + defensePoints);
	}
}
