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
	
	private int atackPoints;
	
	ItemPotionAtack(String nombre, int id, int atackPoints) {
		super(nombre, id, ItemsType.POCION);
		
		this.atackPoints = atackPoints;
		
	}

	@Override
	public void use(Player player) {
		//player.
		
	}
}
