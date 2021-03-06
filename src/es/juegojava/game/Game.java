/**
 * 
 */
package es.juegojava.game;

import es.juegojava.exceptions.EnemiesFromRoomNullException;
import es.juegojava.exceptions.InvalidClassPlayerForEquipItem;
import es.juegojava.exceptions.InventarioEmptyException;
import es.juegojava.exceptions.OptionInvalidException;
import es.juegojava.game.EditPJ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import es.juegojava.logics.CombatEngine;
import es.juegojava.logics.ConversationEngine;
import es.juegojava.logics.Logic;
import es.juegojava.mapa.*;
import es.juegojava.players.Enemy;
import es.juegojava.players.Player;
import es.juegojava.ui.UIManager;
import es.juegojava.inits.Bootstrap;

// TODO: Auto-generated Javadoc
/**
 * The Class Game.
 *
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 */
public class Game 
{
	
	/** The ui. */
	private UIManager ui;
	
	/** The states. */
	private String states;
	
	/** The rooms. */
	private HashMap<Integer, Room> rooms;
	
	/** The P js. */
	private List<Player> PJs;
	
	/** The bs. */
	private Bootstrap bs;
	
	/** The lg. */
	private Logic lg;
	
	/** The enemy finale index. */
	private int enemyFinaleIndex;
	
	/** The room finale. */
	private Room roomFinale;
	
	/** The current room. */
	private Room currentRoom;
	
	/** The current player. */
	private Player currentPlayer;
	
	/** The current room id. */
	private int currentRoomId;
	
	/** The current player index. */
	private int currentPlayerIndex;
	
	private ConversationEngine converEn;
	
	/**
	 * Instantiates a new game.
	 */

	private List<Item> inventario;
	

	public Game() {
		states = "createPJs";
		
		ui = new UIManager();
		bs = new Bootstrap();
		lg = new Logic(ui);
		converEn = new ConversationEngine(ui);
		inventario = new ArrayList<Item>();
		
		init();
		
	}
	
	/**
	 * Run.
	 */
	public void run() {
		while(states != "endgame") {
			switch(states)
			{
				case "createPJs":
					this.createPJs();
					break;
					
				case "init":
					this.calculateEnemyFinale();
					currentRoomId = 100;
					currentRoom = rooms.get(currentRoomId);
					currentPlayerIndex = -1;
					states = "splashscreen";
					break;
					
				case "splashscreen":
					ui.imprimirPorPantalla("Bienvenido al juego");
					this.showPJs();
					
					states = "gamestart";
					break;
				
				case "gamestart":
					ui.imprimirPorPantalla("Nuestro grupo de 3 amigos (un inform�tico, un teleco y un matem�tico) " +
							"han aparecido en una sala y apenas recuerdan lo sucedido, lo �ltimo que hac�an era " +
							"desarrollar una m�quina que les permit�a adentrarse en el juego como si de Tron " +
							"hablasemos pero algo sali� mal� ");
					
					states = "nextturn";
					break;
				
				case "roomscreen":		
					ui.imprimirPorPantalla("Es el turno de: " + currentPlayer.getNombre());
					ui.imprimirPorPantalla(currentPlayer.toString());
					ui.imprimirPorPantalla(currentRoom.toString());
					
					lg.printActions(currentRoom, "roomscreen");
					
					try {
						states = (String)lg.selectActions();
					} catch (OptionInvalidException e) {
						ui.imprimirPorPantalla(e.getMessage());
					}
					
					break;
					
				case "speakscreen":
					
					converEn.imprimirDialogos(currentRoom.getPjns().get(0));
					//ui.imprimirPorPantalla("Vamos a iniciar una conversacion");
					break;
				
				case "changeroom":
					lg.printActions(currentRoom, "changeroom");
					
					//El metodo devuelve el id de la nueva room tras aplicar la accion
				try {
					currentRoomId = (int)lg.selectActions();
					currentRoom = rooms.get(currentRoomId);
					states = "nextturn";
				} catch (OptionInvalidException e) {
					ui.imprimirPorPantalla(e.getMessage());
				}
					break;
					
				case "inventarioscreen":
					try {
						lg.showInventario(inventario);
					} catch (InventarioEmptyException e) {
						ui.imprimirPorPantalla(e.getMessage());
						states = "roomscreen";
					}
					
					try {
						int indexItemInInventario = (int)lg.selectActions();
						
						Item itemToEquip = inventario.get(indexItemInInventario);
						
						
						if(itemToEquip instanceof ItemArma || itemToEquip instanceof ItemArmadura) {
							try {
								currentPlayer.equipItem(itemToEquip);
								
								ui.imprimirPorPantalla("Item equipado!");
							} catch (InvalidClassPlayerForEquipItem e) {
								ui.imprimirPorPantalla(e.getMessage());
							}
						} else {
							if(itemToEquip instanceof ItemPotionAttack) {
								ItemPotionAttack item = (ItemPotionAttack)itemToEquip;
								
								item.use(currentPlayer);
							} else if(itemToEquip instanceof ItemPotionDefense) {
								ItemPotionDefense item = (ItemPotionDefense)itemToEquip;
								
								item.use(currentPlayer);
							} else if(itemToEquip instanceof ItemPotionInitiative) {
								ItemPotionInitiative item = (ItemPotionInitiative)itemToEquip;
								
								item.use(currentPlayer);
							} else if(itemToEquip instanceof ItemPotionLife) {
								ItemPotionLife item = (ItemPotionLife)itemToEquip;
								
								item.use(currentPlayer);
							}
						}
						
						//Saco el item del inventario
						inventario.remove(indexItemInInventario);
						
						states = "nextturn";
							
						
						
					} catch (OptionInvalidException e) {
						ui.imprimirPorPantalla(e.getMessage());
					} catch(NullPointerException e) {
						states = "roomscreen";
					}
					
					
					break;
					
				case "takeitemscreen":
					lg.printActions(currentRoom, "takeitemscreen");
					
				try {
					int indexItemFromRoom = (int) lg.selectActions();
					
					Item itemFromRoom = currentRoom.getItems().get(indexItemFromRoom);
					
					inventario.add(itemFromRoom);
					
					//Elimino el item de la room
					currentRoom.getItems().remove(indexItemFromRoom);
					
					ui.imprimirPorPantalla("Item guardado en el inventario");
					
					//Vuelve a la pantalla de room
					states = "nextturn";
					
				} catch (OptionInvalidException e) {
					ui.imprimirPorPantalla(e.getMessage());
				} catch(NullPointerException e) {
					states = "roomscreen";
				}
					
					break;
				
				case "attackstate":
					lg.initCombat(PJs, currentRoom.getEnemies());
					states = "attackingstate";
					break;
					
				case "attackingstate":
					states = lg.startCombat();
					break;
					
				case "loseplayer":
					ui.imprimirPorPantalla("Todos tus personajes han muerto (You lose)");
					states = "endgame";
					
				case "loseenemies":
					ui.imprimirPorPantalla("Has matado a todos los enemigos de la habitacion");
					states = "nextturn";
					break;
					
				case "nextturn":
					nextTurn();
					states = "roomscreen";
					break;
			}
		}
	}
	
	/**
	 * Inits the.
	 */
	public void init() {
		try {
			rooms = bs.loadRooms();
		} catch (EnemiesFromRoomNullException e) {
			ui.imprimirPorPantalla(e.getMessage());
			System.exit(0);
		}
	}
	
	/**
	 * Creates the p js.
	 */
	private void createPJs() {
		EditPJ epj = new EditPJ(ui);
		
		try {
			epj.createPJs(3);
			
			PJs = epj.getPlayers();
			
			states = "init";
			
		} catch (OptionInvalidException e) {
			ui.imprimirPorPantalla(e.getMessage());
		}
	}
	
	/**
	 * Calculate enemy finale.
	 */
	private void calculateEnemyFinale() {
		Integer idRoomFinale = bs.getIdRoomFinale();
		
		roomFinale = rooms.get(idRoomFinale);
		
		enemyFinaleIndex = (int)Math.random()*(roomFinale.getEnemies().size());
	}
	
	/**
	 * Show p js.
	 */
	private void showPJs() {
		Iterator<Player> it = PJs.iterator();
		
		ui.imprimirPorPantalla("Tus PJs son:");
		
		while(it.hasNext()) {
			ui.imprimirPorPantalla(it.next().toString());
		}
	}
	
	/**
	 * Next turn.
	 */
	private void nextTurn() {
		if(currentPlayerIndex < PJs.size()-1) {
			currentPlayerIndex++;
		} else {
			currentPlayerIndex = 0;
		}
		
		currentPlayer = PJs.get(currentPlayerIndex);
	}
	
	private Item dropItem(int index) {
		Item itemToRoom = inventario.get(index);
		inventario.remove(index);
		
		return itemToRoom;
	}
	
	
}
