/**
 * 
 */
package es.juegojava.players;

import es.juegojava.common.ClassType;
import es.juegojava.common.Raza;
import es.juegojava.common.WeaponsType;
import es.juegojava.mapa.ItemArma;
import es.juegojava.mapa.ItemArmadura;

// TODO: Auto-generated Javadoc
/**
 * The Class PjMatematico.
 *
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 * 
 */
public class PjMatematico extends Player {

	/**
	 * Instantiates a new pj matematico.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 * @param raza the raza
	 */
	public PjMatematico(Integer id, String nombre, Raza raza) {
		super(id, nombre, raza, ClassType.MATEMATICO, 18, 35, 90, 1,
				null);
		
		String desc = "Reloj Casio con mando a distancia, te otorga el ataque de una marabunta de futboleros enfurecidos cuando le cambias de canal mientras ven el partido en el bar.";
		ItemArma defaultWeapon = new ItemArma("Reloj Casio CMD-40", 52, WeaponsType.ARTEFACTO, ClassType.MATEMATICO, 15, desc);
		super.currentWeapon = defaultWeapon;
		
		desc = "Sudadera con la f�rmula de la relatividad bordada en el pecho, aporta tanta energ�a como materia posea el cuerpo.";
		ItemArmadura defaultArmor = new ItemArmadura("Sudadera e = mc2", 32, 10, desc);
		super.currentArmor = defaultArmor;
		// TODO Auto-generated constructor stub
	}
	
}
