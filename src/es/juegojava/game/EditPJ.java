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
import es.juegojava.exceptions.OptionInvalidException;

// TODO: Auto-generated Javadoc
/**
 * The Class EditPJ.
 * 
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 */
public class EditPJ 
{
	
	/** The players. */
	List<Player> players;
	
	/** The ui. */
	UIManager ui;
	
	/**
	 * Instantiates a new edits the pj.
	 *
	 * @param ui the ui
	 */
	EditPJ(UIManager ui) {
		this.ui = ui;
	}
	
	/**
	 * Creates the p js.
	 *
	 * @param numPJsToCreate the num p js to create
	 * @throws OptionInvalidException the option invalid exception
	 */
	public void createPJs(int numPJsToCreate) throws OptionInvalidException {
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
			
			if(optionRaza < 0 || optionRaza > sizeRazas) {
				players = null;
				throw new OptionInvalidException("No existe la opcion, [reset del editor]");
			}
			
			ui.imprimirPorPantalla("Elige la clase de tu PJ: ");
			
			ClassType[] classPjs = ClassType.values();
			int sizeClassPjs = classPjs.length;
			
			for(int j = 0; j < sizeClassPjs; j++) {
				ui.imprimirPorPantalla("\t"+(j+1) +"- " + classPjs[j]);
			}
			
			int optionClassPj = ui.leerNumeroTeclado();
			
			if(optionClassPj < 0 || optionClassPj > sizeClassPjs) {
				players = null;
				throw new OptionInvalidException("No existe la opcion, [reset del editor]");
			}
			
			Player p = null;
			
			switch (classPjs[optionClassPj-1]) {
				case INFORMATICO:
					p = new PjTeleco(i+1, nombrePJ, razas[optionRaza-1]);
					break;
	
				case TELECO:
					p = new PjInformatico(i+1, nombrePJ, razas[optionRaza-1]);
					break;
				case MATEMATICO:
					p = new PjMatematico(i+1, nombrePJ, razas[optionRaza-1]);
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
	 * Gets the players.
	 *
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}
}
