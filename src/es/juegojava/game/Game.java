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
					break;
					
				case "init":
					this.calculateEnemyFinale();
					states = "splashscreen";
					break;
					
				case "splashscreen":
					ui.imprimirPorPantalla("Bienvenido al juego");
					this.showPJs();
					
					states = "endgame";
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
		
		epj.createPJs(3);
		
		PJs = epj.getPlayers();
		
		states = "init";
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
