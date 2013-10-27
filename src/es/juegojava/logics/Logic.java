package es.juegojava.logics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import es.juegojava.common.ClassType;
import es.juegojava.common.Element;
import es.juegojava.common.GameStatus;
import es.juegojava.common.ItemsType;
import es.juegojava.exceptions.InventarioEmptyException;
import es.juegojava.exceptions.OptionInvalidException;
import es.juegojava.mapa.Item;
import es.juegojava.mapa.Room;
import es.juegojava.players.Enemy;
import es.juegojava.players.PersonajeNeutro;
import es.juegojava.players.PjWithClass;
import es.juegojava.players.Player;
import es.juegojava.ui.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Logic.
 */
public class Logic {
	
	/** The estado juego. */
	GameStatus estadoJuego;
	
	/** The ui. */
	UIManager ui;
	
	/** The actions. */
	List<Object> actions;
	
	/** The doors. */
	String[] doors;
	
	/** The ce. */
	CombatEngine ce;

	/** The players. */
	List<Player> players;
	
	/** The enemies. */
	List<Enemy> enemies;
	
	
	/**
	 * Instantiates a new logic.
	 *
	 * @param ui the ui
	 */
	public Logic(UIManager ui) {
		super();
		this.ui = ui;
		
		doors = new String[4];
		doors[0] = "Arriba";
		doors[1] = "Derecha";
		doors[2] = "Abajo";
		doors[3] = "Izquierda";
		
		ce = null;
	}

	/**
	 * Prints the room desc.
	 *
	 * @param roomToDesc the room to desc
	 */
	public void printRoomDesc(Room roomToDesc){
		String desc = "";
		desc = roomToDesc.toString();
		ui.imprimirPorPantalla(desc);
	}
	
	/**
	 * Prints the actions.
	 *
	 * @param currentRoom the current room
	 * @param state the state
	 */
	public void printActions(Room currentRoom, String state){
		
		String desc = "";
		
		actions = new ArrayList<Object>();
		
		if(state == "roomscreen") {
		
			if(currentRoom.getEnemies().size() != 0){
				desc = "1- Atacar\n" +
						"2- Cambiar de sala\n" +
						"3- pasar turno\n";
				
				actions.add("attackstate");
				actions.add("changeroom");
				actions.add("nextturn");
				
			}else{
				desc = "1- Hablar con el NPC\n" +
						"2- Ver inventario\n" + 
						"3- Coger un item\n" +
						"4- Tirar un item al suelo\n" +
						"5- Cambiar de sala\n" +
						"6- Pasar turno\n";
				
				actions.add("speakscreen");
				actions.add("inventarioscreen");
				actions.add("takeitemscreen");
				actions.add("dropitemscreen");
				actions.add("changeroom");
				actions.add("nextturn");
			}
		
		} else if(state == "changeroom") {
			ui.imprimirPorPantalla("Elige una de las siguientes puertas: ");
			
			List<Integer> connections = currentRoom.getConnections();
			
			int sizeConnections = connections.size();
			
			for(int i = 0; i < sizeConnections; i++) {
				int option = i+1;
				desc += option + "- " + doors[i];
				
				actions.add(connections.get(i));
		
			}	
		} else if(state == "takeitemscreen") {
			ui.imprimirPorPantalla("Al explorar la habitacion encuentras los siguientes items: ");
			
			List<Item> items = currentRoom.getItems();
			
			int	sizeItems = items.size();
			
			for(int i = 0; i < sizeItems; i++) {
				int option = i+1;
				desc += option + "- " + items.get(i).getNombre() + "\n";
				
				actions.add(i);
		
			}	
		}
		
	
		desc += "\nSelecciona una opcion: \n";
		ui.imprimirPorPantalla(desc);
	}
	
	/**
	 * Select actions.
	 *
	 * @return the object
	 * @throws OptionInvalidException the option invalid exception
	 */
	public Object selectActions() throws OptionInvalidException {
		
		int sizeActions = actions.size();
		
		if(sizeActions > 0) {
		
			int option = ui.leerNumeroTeclado();
			
			if(option > 0 && option <= sizeActions) {
				return actions.get(option-1);
			} else {
				throw new OptionInvalidException("Opcion no valida!");
			}
		} else {
		
			throw new NullPointerException();
		}
		
	}
	
	/**
	 * Show inventario.
	 *
	 * @param currentPlayer the current player
	 * @throws InventarioEmptyException the inventario empty exception
	 */
	public void showInventario(Player currentPlayer) throws InventarioEmptyException {
		List<Item> inventario = currentPlayer.getInventario();	
		actions = new ArrayList<Object>();
		
		int sizeInventario = inventario.size();
		
		if(sizeInventario > 0) {	
			for(int i = 0; i < sizeInventario; i++) {
				int count = i + 1;
				ui.imprimirPorPantalla(count + "- " + inventario.get(i).getNombre() + "[" + inventario.get(i).getTipo() + "]");
				actions.add(i);
			}
			
			ui.imprimirPorPantalla("\nEquipar/Usar\n");
		} else {
			throw new InventarioEmptyException("El inventario del PJ actual está vacio");
		}
	}
	
	/**
	 * Inits the combat.
	 *
	 * @param players the players
	 * @param enemies the enemies
	 */
	public void initCombat(List<Player> players, List<Enemy> enemies) {
		if(null == ce) {
			this.players = players;
			this.enemies = enemies;
			
			ce = new CombatEngine(this.players, this.enemies);
		}
	}
	
	/**
	 * Start combat.
	 *
	 * @return the string
	 */
	public String startCombat() {
		actions = new ArrayList<Object>();
		
		String stateCombat = ce.getStateCombat();
		
		if(stateCombat == "continue") {
			
			HashMap<String, String> dataFromCombat = ce.selectCandidates(actions);
			
			if(dataFromCombat.get("state") == "attackerbyenemy") {
				ui.imprimirPorPantalla("El turno es del enemigo");
							
			
			} else if(dataFromCombat.get("state") == "attackerbyplayer") {
				ui.imprimirPorPantalla("Tu turno (Pj: "+ ce.getAttacker().getNombre() +")\n");
				
				ui.imprimirPorPantalla(dataFromCombat.get("actionsToPrint"));
				ui.imprimirPorPantalla("Selecciona un enemigo para atacarle: ");
				
				try {
					int enemyNumToAttack = (int) selectActions();
					
					ce.selectEnemyToAttack(enemyNumToAttack);
					
				} catch (OptionInvalidException e) {
					ui.imprimirPorPantalla(e.getMessage());
				}
			}
			
			ui.imprimirPorPantalla("Se enfrentan en combate: ");
			
			ui.imprimirPorPantalla(ce.getAttacker().getNombre() + " vs " + ce.getDefender().getNombre());
			
			int[] dataCombat = ce.start();
			
			
			String weaponName = ce.getAttacker().getCurrentWeapon().getNombre();
			String attackName = "";
			ClassType claseAttacker = ce.getAttacker().getClassPj();
			
			switch (claseAttacker){
			case TELECO:
				attackName = "El " + ce.getAttacker().classToSring() + " lanza el " + weaponName + 
					" con una fuerza de " + dataCombat[1] + " julios sobre el enemigo.";
				break;
			case INFORMATICO:
				attackName = "El " + ce.getAttacker().classToSring() + " se acerca y golpea con el " + weaponName + 
				" con una fuerza de " + dataCombat[1] + " julios al enemigo.";
				break;
			case MATEMATICO:
				attackName = "El " + ce.getAttacker().classToSring() + " dispara con el " + weaponName + 
				" con una fuerza de " + dataCombat[1] + " julios al enemigo.";
				break;
				default:
				attackName = "Error al realizar el ataque";
				break;
			}
			
			ui.imprimirPorPantalla(attackName);
			
			ui.imprimirPorPantalla("Su armadura abasorbe " + dataCombat[2] + " puntos de daño");
			
			ui.imprimirPorPantalla("La vida del defensor tras el combate es: " + dataCombat[0]);
			
			if(dataCombat[0] == 0) {
				ui.imprimirPorPantalla("El defensor ha caido");
				if(ce.getDefender() instanceof Player) {
					players.remove(ce.getDefender());
				} else {
					enemies.remove(ce.getDefender());
				}
			}
			
			return "attackingstate";
		
		} else if(stateCombat == "loseplayer") {
			return "loseplayer";
		} else {
			return "loseenemies";
		}
		
	}

	
	
	/**
	 * Imprimir dialogo.
	 *
	 * @param npc the npc
	 * @param numeroDeFrase the numero de frase
	 */
	public void imprimirDialogo(PersonajeNeutro npc, int numeroDeFrase){
		ui.imprimirPorPantalla(npc.toString(numeroDeFrase));
	}
	
	/**
	 * Show items from room.
	 *
	 * @param items the items
	 */
	public void showItemsFromRoom(List<Item> items) {
		Iterator<Item> it = items.iterator();
		
		int count = 1;
		
		while(it.hasNext()) {
			ui.imprimirPorPantalla("[" + count + " ]" +  it.next().toString() + "\n");
			
			count++;
		}
	}
	
	/**
	 * Show enemies from room.
	 *
	 * @param enemies the enemies
	 */
	public void showEnemiesFromRoom(List<Enemy> enemies) {
		Iterator<Enemy> it = enemies.iterator();
		
		int count = 1;
		
		while(it.hasNext()) {
			ui.imprimirPorPantalla("[" + count + " ]" +  it.next().toString() + "\n");
			
			count++;
		}
	}
	
	/**
	 * Explorar habitacion.
	 *
	 * @param habitacionAExplorar the habitacion a explorar
	 */
	public void explorarHabitacion(Room habitacionAExplorar){
		
		int nItems = habitacionAExplorar.getItems().size();
		
		if(nItems!=0){
			ui.imprimirPorPantalla("Exploras la sala y encuentras...\n");
			for(int i = 0; i < nItems; i++){
				ui.imprimirPorPantalla(habitacionAExplorar.getItems().get(i).getNombre());
			}
		}else{
			ui.imprimirPorPantalla("No hay items en la sala\n");
		}
	}
	
	//Metodo para mostrar los items de la lista cuando selecciones la opcion "equipar item" o "usar pocion"
	/**
	 * Imprimir lista item usables.
	 *
	 * @param currentPlayer the current player
	 * @param tipoItem the tipo item
	 */
	public void imprimirListaItemUsables(Player currentPlayer, ItemsType tipoItem){
		
		Item itemAMostrar;
	
		for(int i = 0; i < currentPlayer.getInventario().size(); i++){
			
			itemAMostrar = currentPlayer.getInventario().get(i);
			
			if(tipoItem == itemAMostrar.getTipo()){
				ui.imprimirPorPantalla(itemAMostrar.toString());
			}
		}
	}
	
	
	
	
	/**
	 * Imprimir muerte pj.
	 *
	 * @param pjToDie the pj to die
	 */
	public void imprimirMuertePj(PjWithClass pjToDie){
		
		String dialogoMuerte = "";
				
		dialogoMuerte = "El " + pjToDie.classToSring() + " " + pjToDie.getNombre() + 
				" ha muerto.";
		
		ui.imprimirPorPantalla(dialogoMuerte);
	}

	
}
