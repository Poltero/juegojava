/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.*;

/**
 * @author pablo.fernandez
 *
 */
public class ItemArma extends Item 
{
	private int atack;
	private WeaponsType weaponsType;
	private ClassType weaponClass;
	
	public ItemArma(String nombre, int id, WeaponsType wpType, ClassType wpClass, int atackPoints, String desc) {
		super(nombre, id, ItemsType.ARMA, desc);
		
		weaponsType = wpType;
		weaponClass = wpClass;
		atack = atackPoints;
	}

	public int getAtack() {
		return atack;
	}

	public void setAtack(int atack) {
		this.atack = atack;
	}

	public WeaponsType getWeaponsType() {
		return weaponsType;
	}

	public void setWeaponsType(WeaponsType weaponsType) {
		this.weaponsType = weaponsType;
	}

	public ClassType getWeaponClass() {
		return weaponClass;
	}

	public void setWeaponClass(ClassType weaponClass) {
		this.weaponClass = weaponClass;
	}
	
}
