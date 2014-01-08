/**
 * 
 */
package es.juegojava.game;

import es.juegojava.common.GameStatus;
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
	private GameStatus states;
	
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
		states = GameStatus.CREATEPJ;
		
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
		while(states != GameStatus.ENDGAME) {
			switch(states)
			{
				case CREATEPJ:
					this.createPJs();
					break;
					
				case INIT:
					this.calculateEnemyFinale();
					currentRoomId = 100;
					currentRoom = rooms.get(currentRoomId);
					currentPlayerIndex = -1;
					states = GameStatus.SPLASHSCREEN;
					break;
					
				case SPLASHSCREEN:
					ui.imprimirPorPantalla("Bienvenido al juego");
					this.showPJs();
					
					states = GameStatus.GAMESTART;
					break;
				
				case GAMESTART:
					ui.imprimirPorPantalla("Nuestro grupo de 3 amigos (un informático, un teleco y un matemático) " +
							"han aparecido en una sala y apenas recuerdan lo sucedido, lo último que hacían era " +
							"desarrollar una máquina que les permitía adentrarse en el juego como si de Tron " +
							"hablasemos pero algo salió mal… ");
					
					states = GameStatus.NEXTTURN;
					break;
				
				case ROOMSCREEN:		
					ui.imprimirPorPantalla("Es el turno de: ");
					ui.imprimirPorPantalla(currentPlayer.toString());
					ui.imprimirPorPantalla("\n");
					ui.imprimirPorPantalla("Te encuentras en: ");
					ui.imprimirPorPantalla(currentRoom.toString());
					
					states = lg.runActions(currentRoom, "roomscreen");
					
					break;
					
				case SPEAKSCREEN:
					
					converEn.imprimirDialogos(currentRoom.getPjns().get(0));
					//ui.imprimirPorPantalla("Vamos a iniciar una conversacion");
					break;
				
				case CHANGEROOM:
					GameStatus proxStateToChangeRoom = lg.runActions(currentRoom, "changeroom");
					
					//El metodo devuelve el id de la nueva room tras aplicar la accion
					
					if(proxStateToChangeRoom != null) {
						currentRoomId = Integer.parseInt(lg.getOptionSelected().toString());
						currentRoom = rooms.get(currentRoomId);
						states = proxStateToChangeRoom;
					}
				
					break;
					
				case INVENTARIOSCREEN:
					try {
						lg.showInventario(inventario);
					} catch (InventarioEmptyException e) {
						ui.imprimirPorPantalla(e.getMessage());
						states = GameStatus.ROOMSCREEN;
					}
					
					try {
						int indexItemInInventario = (int)lg.selectActions();
						
						Item itemToEquip = inventario.get(indexItemInInventario);
						
						
						if(itemToEquip instanceof ItemArma || itemToEquip instanceof ItemArmadura) {
							try {
								currentPlayer.equipItem(itemToEquip);
								
								ui.imprimirPorPantalla("Item ["+ itemToEquip.getNombre() +"] equipado!");
							} catch (InvalidClassPlayerForEquipItem e) {
								ui.imprimirPorPantalla(e.getMessage());
							}
						} else {
							if(itemToEquip instanceof ItemPotionAttack) {
								ItemPotionAttack item = (ItemPotionAttack)itemToEquip;
								
								ui.imprimirPorPantalla("Item ["+ itemToEquip.getNombre() +"] usado!");
								item.use(currentPlayer);
								ui.imprimirPorPantalla("+" + item.getAttackPoints() + " de ataque");
							} else if(itemToEquip instanceof ItemPotionDefense) {
								ItemPotionDefense item = (ItemPotionDefense)itemToEquip;
								
								ui.imprimirPorPantalla("Item ["+ itemToEquip.getNombre() +"] usado!");
								item.use(currentPlayer);
								ui.imprimirPorPantalla("+" + item.getDefensePoints() + " de defensa");
							} else if(itemToEquip instanceof ItemPotionInitiative) {
								ItemPotionInitiative item = (ItemPotionInitiative)itemToEquip;
								
								ui.imprimirPorPantalla("Item ["+ itemToEquip.getNombre() +"] usado!");
								item.use(currentPlayer);
								ui.imprimirPorPantalla("+" + item.getInitiativePoints() + " iniciativa");
							} else if(itemToEquip instanceof ItemPotionLife) {
								ItemPotionLife item = (ItemPotionLife)itemToEquip;
								
								ui.imprimirPorPantalla("Item ["+ itemToEquip.getNombre() +"] usado!");
								item.use(currentPlayer);
								ui.imprimirPorPantalla("+" + item.getLifePoints() + " de vida");
							}
						}
						
						//Saco el item del inventario
						inventario.remove(indexItemInInventario);
						
						states = GameStatus.NEXTTURN;
							
						
						
					} catch (OptionInvalidException e) {
						ui.imprimirPorPantalla(e.getMessage());
					} catch(NullPointerException e) {
						states = GameStatus.ROOMSCREEN;
					}
					
					
					break;
					
				case TAKEITEMSCREEN:
					GameStatus proxStateToTakeItemScreen = lg.runActions(currentRoom, "takeitemscreen");
					
				
					if(proxStateToTakeItemScreen != null) {
						int indexItemFromRoom = Integer.parseInt(lg.getOptionSelected().toString());
						
						if(indexItemFromRoom != -1) {
							Item itemFromRoom = currentRoom.getItems().get(indexItemFromRoom);
							
							//Agrego el item al inventario
							inventario.add(itemFromRoom);
							
							//Elimino el item de la room
							currentRoom.getItems().remove(indexItemFromRoom);
							
							ui.imprimirPorPantalla("Item guardado en el inventario");
						}
					}
					
					states = proxStateToTakeItemScreen;
					
					break;
				
				case ATTACKSCREEN:
					lg.initCombat(PJs, currentRoom.getEnemies());
					states = GameStatus.ATTAKING;
					break;
					
				case ATTAKING:
					states = lg.startCombat();
					break;
					
				case LOSEPLAYER:
					ui.imprimirPorPantalla("Todos tus personajes han muerto (You lose)");
					states = GameStatus.ENDGAME;
					
				case LOSEENEMIES:
					ui.imprimirPorPantalla("Has matado a todos los enemigos de la habitacion");
					states = GameStatus.NEXTTURN;
					break;
					
				case NEXTTURN:
					nextTurn();
					states = GameStatus.ROOMSCREEN;
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
			
			states = GameStatus.INIT;
			
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
