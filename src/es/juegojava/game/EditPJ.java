/**
 * 
 */
package es.juegojava.game;

import java.util.ArrayList;
import java.util.List;

import es.juegojava.ui.UIManager;
import es.juegojava.common.ClassType;
import es.juegojava.common.Raza;
import es.juegojava.players.*;

/**
 * @author pablo.fernandez
 *
 */
public class EditPJ 
{
	List<Player> players;
	UIManager ui;
	
	EditPJ(UIManager ui) {
		this.ui = ui;
	}
	
	public void createPJs(int numPJsToCreate) {
		players = new ArrayList<Player>();
		
		ui.imprimirPorPantalla("Bienvenido al editor de PJs del juego");
		
		for(int i = 0; i < numPJsToCreate; i++) {
			ui.imprimirPorPantalla("Crear nuevo PJ:");
			ui.imprimirPorPantalla("-------------\n");
			ui.imprimirPorPantalla("Introduce el nombre de tu PJ: ");
			
			String nombrePJ = ui.leerCadenaTeclado();
			
			ui.imprimirPorPantalla("Elige la raza de tu PJ: ");
			
			Raza[] razas = Raza.values();
			int sizeRazas = razas.length;
			
			for(int j = 0; j < sizeRazas; j++) {
				ui.imprimirPorPantalla("\t"+(j+1) +"- " + razas[j]);
			}
			
			int optionRaza = ui.leerNumeroTeclado();
			
			ui.imprimirPorPantalla("Elige la clase de tu PJ: ");
			
			ClassType[] classPjs = ClassType.values();
			int sizeClassPjs = classPjs.length;
			
			for(int j = 0; j < sizeClassPjs-1; j++) {
				ui.imprimirPorPantalla("\t"+(j+1) +"- " + classPjs[j]);
			}
			
			int optionClassPj = ui.leerNumeroTeclado();
			
			Player p = null;
			
			switch (classPjs[optionClassPj-1]) {
				case MAGO:
					p = new PjMago(i+1, nombrePJ, razas[optionRaza-1]);
					break;
	
				case GUERRERO:
					p = new PjGuerrero(i+1, nombrePJ, razas[optionRaza-1]);
					break;
				default:
					break;
			}
			
			if(null != p) {
				players.add(p);
			}
			
		}
	}

	/**
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}
}
