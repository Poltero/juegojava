/**
 * 
 */
package es.juegojava.game;

import es.juegojava.game.EditPJ;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import es.juegojava.mapa.*;
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
					
				case "splashscreen":
					ui.imprimirPorPantalla("Bienvenido al juego");
					this.showPJs();
					
					states = "endgame";
					break;
			}
		}
	}
	
	public void init() {
		rooms = bs.loadRooms();
	}
	
	private void createPJs() {
		EditPJ epj = new EditPJ(ui);
		
		epj.createPJs(3);
		
		PJs = epj.getPlayers();
		
		states = "splashscreen";
	}
	
	private void showPJs() {
		Iterator<Player> it = PJs.iterator();
		
		ui.imprimirPorPantalla("Tus PJs son:");
		
		while(it.hasNext()) {
			ui.imprimirPorPantalla(it.next().toString());
		}
	}
	
	
}
