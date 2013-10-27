/**
 * 
 */
package es.juegojava.players;

import es.juegojava.common.ClassType;
import es.juegojava.common.Raza;
import es.juegojava.common.WeaponsType;
import es.juegojava.mapa.ItemArma;
import es.juegojava.mapa.ItemArmadura;

/**
 * @author pfranco
 *
 */
public class PjTeleco extends Player {

	public PjTeleco(Integer id, String nombre, Raza raza) {
		super(id, nombre, raza, ClassType.TELECO, 25, 15, 1, 1,
				null);
		
		String desc = "Taza del desayuno de Lost, nadie sabe de dónde ha salido ni cuales son sus poderes pero esta dura y es grande.";
		ItemArma defaultWeapon = new ItemArma("Taza de Lost", 51, WeaponsType.CHISME, ClassType.TELECO, 15, desc);
		super.currentWeapon = defaultWeapon;
		
		desc = "Capa de un color rojo brillante, tejida en seda y muy ligera, se dice que el que la lleve puesta obtendrá los poderes de superman.";
		ItemArmadura defaultArmor = new ItemArmadura("Capa de Superman", 31, 10, desc);
		super.currentArmor = defaultArmor;
		// TODO Auto-generated constructor stub
	}
	
}
