/**
 * 
 */
package es.juegojava.players;

import java.util.ArrayList;
import java.util.List;

import es.juegojava.common.Raza;
import es.juegojava.mapa.Item;
import es.juegojava.mapa.ItemArma;
import es.juegojava.mapa.ItemArmadura;


/**
 * @author pablo.fernandez
 *
 */
public class Player extends Personaje
{
	ItemArma currentWeapon;
	ItemArmadura currentArmor;
	List<Item> inventario;

	public Player(Integer id, String nombre, Raza raza) {
		super(id, nombre, raza);
		
		inventario = new ArrayList<Item>();
	}
	
	@Override
	public String toString() {
		return ("Nombre: " + nombre +", raza: " + raza + "\n");
	}
	
}
