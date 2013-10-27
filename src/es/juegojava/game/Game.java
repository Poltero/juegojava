/**
 * 
 */
package es.juegojava.game;

import es.juegojava.exceptions.EnemiesFromRoomNullException;
import es.juegojava.exceptions.InvalidClassPlayerForEquipItem;
import es.juegojava.exceptions.InventarioEmptyException;
import es.juegojava.exceptions.OptionInvalidException;
import es.juegojava.game.EditPJ;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import es.juegojava.logics.Logic;
import es.juegojava.mapa.*;
import es.juegojava.players.Enemy;
import es.juegojava.players.Player;
import es.juegojava.ui.UIManager;
import es.juegojava.inits.Bootstrap;

/**
 * @author pablo.fernandez
 *
 */
public class Game 
{
	private UIManager ui;
	
	private String states;
	private HashMap<Integer, Room> rooms;
	private List<Player> PJs;
	private Bootstrap bs;
	private Logic lg;
	
	private int enemyFinaleIndex;
	private Room roomFinale;
	private Room currentRoom;
	private Player currentPlayer;
	
	private int currentRoomId;
	private int currentPlayerIndex;
	
	public Game() {
		states = "createPJs";
		
		ui = new UIManager();
		bs = new Bootstrap();
		lg = new Logic(ui);
		
		init();
		
	}
	
	public void run() {
		while(states != "endgame") {
			switch(states)
			{
				case "createPJs":
					this.createPJs();
					break;
					
				case "init":
					this.calculateEnemyFinale();
					currentRoomId = 1;
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
					ui.imprimirPorPantalla("Empiezas el juego y entras en la primera habitacion de muchas..");
					
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
						lg.showInventario(currentPlayer);
					} catch (InventarioEmptyException e) {
						ui.imprimirPorPantalla(e.getMessage());
						states = "roomscreen";
					}
					
					try {
						int indexItemInInventario = (int)lg.selectActions();
						
						Item itemToEquip = currentPlayer.getInventario().get(indexItemInInventario);
						
						
						if(itemToEquip instanceof ItemArma || itemToEquip instanceof ItemArmadura) {
							try {
								currentPlayer.equipItem(itemToEquip);
								
								ui.imprimirPorPantalla("Item equipado!");
							} catch (InvalidClassPlayerForEquipItem e) {
								ui.imprimirPorPantalla(e.getMessage());
							}
						} else {
							//To use item
						}
						
						//Saco el item del inventario
						currentPlayer.getInventario().remove(indexItemInInventario);
						
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
					
					currentPlayer.addItemToInventario(itemFromRoom);
					
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
	
	public void init() {
		try {
			rooms = bs.loadRooms();
		} catch (EnemiesFromRoomNullException e) {
			ui.imprimirPorPantalla(e.getMessage());
			System.exit(0);
		}
	}
	
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
	
	private void calculateEnemyFinale() {
		Integer idRoomFinale = bs.getIdRoomFinale();
		
		roomFinale = rooms.get(idRoomFinale);
		
		enemyFinaleIndex = (int)Math.random()*(roomFinale.getEnemies().size());
	}
	
	private void showPJs() {
		Iterator<Player> it = PJs.iterator();
		
		ui.imprimirPorPantalla("Tus PJs son:");
		
		while(it.hasNext()) {
			ui.imprimirPorPantalla(it.next().toString());
		}
	}
	
	private void nextTurn() {
		if(currentPlayerIndex < PJs.size()-1) {
			currentPlayerIndex++;
		} else {
			currentPlayerIndex = 0;
		}
		
		currentPlayer = PJs.get(currentPlayerIndex);
	}
	
	
}
