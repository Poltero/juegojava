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
	
	ItemArma(String nombre, int id, WeaponsType wpType, ClassType wpClass, int atackPoints) {
		super(nombre, id, ItemsType.ARMA);
		
		weaponsType = wpType;
		weaponClass = wpClass;
		atack = atackPoints;
	}
	
	
	
}
