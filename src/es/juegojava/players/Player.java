/**
 * 
 */
package es.juegojava.players;

import java.util.ArrayList;
import java.util.List;

import es.juegojava.common.ClassType;
import es.juegojava.common.Raza;
import es.juegojava.exceptions.InvalidClassPlayerForEquipItem;
import es.juegojava.mapa.Item;
import es.juegojava.mapa.ItemArma;
import es.juegojava.mapa.ItemArmadura;


// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 *
 * @author pablo.fernandez
 */
public class Player extends PjWithClass
{
	
	/** The current armor. */
	ItemArmadura currentArmor;
	
	/** The inventario. */
	List<Item> inventario;

	/**
	 * Instantiates a new player.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 * @param raza the raza
	 * @param classPj the class pj
	 * @param attack the attack
	 * @param defense the defense
	 * @param life the life
	 * @param initiative the initiative
	 * @param currentWeapon the current weapon
	 */
	public Player(Integer id, String nombre, Raza raza, ClassType classPj, int attack, 
			int defense,  int life, int initiative, ItemArma currentWeapon) {
		
		super(id, nombre, raza, classPj, attack, defense, life, initiative, currentWeapon);
		
		inventario = new ArrayList<Item>();
	}
	
	/* (non-Javadoc)
	 * @see es.juegojava.players.PjWithClass#toString()
	 */
	@Override
	public String toString() {
		return ("Nombre: " + nombre +", Raza: " + raza + ", Clase: " + classPj + "\n");
	}

	/**
	 * Gets the inventario.
	 *
	 * @return the inventario
	 */
	public List<Item> getInventario() {
		return inventario;
	}
	
	/**
	 * Equip item.
	 *
	 * @param itemToEquip the item to equip
	 * @throws InvalidClassPlayerForEquipItem the invalid class player for equip item
	 */
	public void equipItem(Item itemToEquip) throws InvalidClassPlayerForEquipItem {
		
		if(itemToEquip instanceof ItemArma) {
			ItemArma weapon = (ItemArma)itemToEquip;
			
			if(weapon.getWeaponClass() == this.getClassPj()) {
				this.currentWeapon = weapon; //fallo en diagrama de clases
			} else {
				throw new InvalidClassPlayerForEquipItem("[No se pudo equipar] La clase del player es incomplatible con la del item. Require ser '" + weapon.getWeaponClass() + "'");
			}
		} else if(itemToEquip instanceof ItemArmadura) {
			this.currentArmor = (ItemArmadura)itemToEquip;
		}
	}
	
	/**
	 * Drop item.
	 *
	 * @param index the index
	 * @return the item
	 */
	public Item dropItem(int index) {
		Item itemToRoom = inventario.get(index);
		inventario.remove(index);
		
		return itemToRoom;
	}
	
	/**
	 * Adds the item to inventario.
	 *
	 * @param item the item
	 */
	public void addItemToInventario(Item item) {
		inventario.add(item);
	}

}
