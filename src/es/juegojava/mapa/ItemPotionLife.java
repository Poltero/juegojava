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
	
	ItemPotionLife(String nombre, int id, int lifePoints) {
		super(nombre, id, ItemsType.POCION);
		
		this.lifePoints = lifePoints;
		
	}

	@Override
	public void use(Player player) {
		// TODO Auto-generated method stub
		
	}
	
}
