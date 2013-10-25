/**
 * 
 */
package es.juegojava.game;

import es.juegojava.exceptions.EnemiesFromRoomNullException;
import es.juegojava.game.EditPJ;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
	
	private int enemyFinaleIndex;
	private Room roomFinale;
	private Room currentRoom;
	
	private int currentRoomId;
	
	public Game() {
		states = "createPJs";
		
		ui = new UIManager();
		bs = new Bootstrap();
		
		init();
	}
	
	public void run() {
		while(states != "endgame") {
			switch(states)
			{
				case "createPJs":
					this.createPJs();
					states = "init";
					break;
					
				case "init":
					this.calculateEnemyFinale();
					currentRoomId = 1;
					states = "splashscreen";
					break;
					
				case "splashscreen":
					ui.imprimirPorPantalla("Bienvenido al juego");
					this.showPJs();
					
					states = "gamestart";
					break;
				
				case "gamestart":
					ui.imprimirPorPantalla("Empiezas el juego y entras en la primera habitacion de muchas..");
					
					states = "roomscreen";
					break;
				
				case "roomscreen":
					currentRoom = rooms.get(currentRoomId);
					ui.imprimirPorPantalla(currentRoom.toString());
					
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
		
		epj.createPJs(1);
		
		PJs = epj.getPlayers();
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
	
	
}
