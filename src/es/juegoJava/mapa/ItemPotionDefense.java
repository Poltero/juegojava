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
	
	ItemPotionDefense(String nombre, int id, int defensePoints) {
		super(nombre, id, ItemsType.ARMADURA);
		
		this.defensePoints = defensePoints;
	}

	@Override
	public void use(Player player) {
		// TODO Auto-generated method stub
		
	}
}
