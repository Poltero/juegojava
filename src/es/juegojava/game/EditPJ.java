/**
 * 
 */
package es.juegojava.game;

import java.util.ArrayList;
import java.util.List;

import es.juegojava.ui.UIManager;
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
			
			int option = ui.leerNumeroTeclado();
			
			//players.add(new Player(i+1, nombrePJ, razas[option-1]));
			
		}
	}

	/**
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}
}
