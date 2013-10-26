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
	
	public void equipItem(int index) throws InvalidClassPlayerForEquipItem {
		Item itemToEquip = inventario.get(index);
		
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

}
