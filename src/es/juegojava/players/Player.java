/**
 * 
 */
package es.juegojava.players;

import java.util.ArrayList;
import java.util.List;

import es.juegojava.common.ClassType;
import es.juegojava.common.Raza;
import es.juegojava.mapa.Item;
import es.juegojava.mapa.ItemArma;
import es.juegojava.mapa.ItemArmadura;


/**
 * @author pablo.fernandez
 *
 */
public class Player extends PjWithClass
{
	ItemArmadura currentArmor;
	List<Item> inventario;

	public Player(Integer id, String nombre, Raza raza, ClassType classPj, int attack, 
			int defense,  int life, int initiative, ItemArma currentWeapon) {
		
		super(id, nombre, raza, classPj, attack, defense, life, initiative, currentWeapon);
		
		inventario = new ArrayList<Item>();
	}
	
	@Override
	public String toString() {
		return ("Nombre: " + nombre +", raza: " + raza + "\n");
	}

	public List<Item> getInventario() {
		return inventario;
	}

}
