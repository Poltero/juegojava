/**
 * 
 */
package es.juegojava.mapa;

import es.juegojava.common.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemArma.
 *
 * @author pablo.fernandez
 */
public class ItemArma extends Item 
{
	
	/** The atack. */
	private int atack;
	
	/** The weapons type. */
	private WeaponsType weaponsType;
	
	/** The weapon class. */
	private ClassType weaponClass;
	
	/**
	 * Instantiates a new item arma.
	 *
	 * @param nombre the nombre
	 * @param id the id
	 * @param wpType the wp type
	 * @param wpClass the wp class
	 * @param atackPoints the atack points
	 * @param desc the desc
	 */
	public ItemArma(String nombre, int id, WeaponsType wpType, ClassType wpClass, int atackPoints, String desc) {
		super(nombre, id, ItemsType.ARMA, desc);
		
		weaponsType = wpType;
		weaponClass = wpClass;
		atack = atackPoints;
		super.desc = desc;
	}

	/**
	 * Gets the atack.
	 *
	 * @return the atack
	 */
	public int getAtack() {
		return atack;
	}

	/**
	 * Sets the atack.
	 *
	 * @param atack the new atack
	 */
	public void setAtack(int atack) {
		this.atack = atack;
	}

	/**
	 * Gets the weapons type.
	 *
	 * @return the weapons type
	 */
	public WeaponsType getWeaponsType() {
		return weaponsType;
	}

	/**
	 * Sets the weapons type.
	 *
	 * @param weaponsType the new weapons type
	 */
	public void setWeaponsType(WeaponsType weaponsType) {
		this.weaponsType = weaponsType;
	}

	/**
	 * Gets the weapon class.
	 *
	 * @return the weapon class
	 */
	public ClassType getWeaponClass() {
		return weaponClass;
	}

	/**
	 * Sets the weapon class.
	 *
	 * @param weaponClass the new weapon class
	 */
	public void setWeaponClass(ClassType weaponClass) {
		this.weaponClass = weaponClass;
	}
	
}
