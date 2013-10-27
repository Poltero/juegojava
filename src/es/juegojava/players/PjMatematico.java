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
public class PjMatematico extends Player {

	public PjMatematico(Integer id, String nombre, Raza raza) {
		super(id, nombre, raza, ClassType.MATEMATICO, 18, 35, 100, 1,
				null);
		
		String desc = "Reloj Casio con mando a distancia, te otorga el ataque de una marabunta de futboleros enfurecidos cuando le cambias de canal mientras ven el partido en el bar.";
		ItemArma defaultWeapon = new ItemArma("Reloj Casio CMD-40", 52, WeaponsType.ARTEFACTO, ClassType.MATEMATICO, 15, desc);
		super.currentWeapon = defaultWeapon;
		
		desc = "Sudadera con la fórmula de la relatividad bordada en el pecho, aporta tanta energía como materia posea el cuerpo.";
		ItemArmadura defaultArmor = new ItemArmadura("Sudadera e = mc2", 32, 10, desc);
		super.currentArmor = defaultArmor;
		// TODO Auto-generated constructor stub
	}
	
}
