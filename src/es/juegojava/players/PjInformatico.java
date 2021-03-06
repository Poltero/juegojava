/**
 * 
 */
package es.juegojava.players;

import es.juegojava.common.ClassType;
import es.juegojava.common.Raza;
import es.juegojava.common.WeaponsType;
import es.juegojava.mapa.Item;
import es.juegojava.mapa.ItemArma;
import es.juegojava.mapa.ItemArmadura;

// TODO: Auto-generated Javadoc
/**
 * The Class PjInformatico.
 *
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 * 
 */
public class PjInformatico extends Player {

	/**
	 * Instantiates a new pj informatico.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 * @param raza the raza
	 */
	public PjInformatico(Integer id, String nombre, Raza raza) {		
		super(id, nombre, raza, ClassType.INFORMATICO, 30, 10, 100, 1,
				null);
		
		String desc = "Arma peligrosa y puntiaguda, puedes matar dependiendo del color con que se escriba.";
		ItemArma defaultWeapon = new ItemArma("Boligrafo Multicolor", 50, WeaponsType.GADGET, ClassType.INFORMATICO, 15, desc);
		super.currentWeapon = defaultWeapon;
		
		desc = "Camiseta con bonitos motivos de Star Wars, si la llevas te acompa�a la fuerza.";
		ItemArmadura defaultArmor = new ItemArmadura("Camiseta Star Wars", 30, 10, desc);
		super.currentArmor = defaultArmor;
				//TODO Auto-generated constructor stub
	}

}
