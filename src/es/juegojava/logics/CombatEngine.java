/**
 * 
 */
package es.juegojava.logics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import es.juegojava.players.Enemy;
import es.juegojava.players.ListPjWithClassOrdered;
import es.juegojava.players.PjWithClass;
import es.juegojava.players.Player;
import es.juegojava.ui.UIManager;

/**
 * @author pfranco
 *
 */
public class CombatEngine 
{
	private ListPjWithClassOrdered turns;
	private int playerNumSelected;
	private int enemyNumSelected;
	private UIManager ui;
	
	public CombatEngine(List<Player> players, List<Enemy> enemies, UIManager ui) {
		this.ui = ui;
		
		turns = new ListPjWithClassOrdered();
		
		//Meto en la lista de turnos los jugadores
		int sizePlayers = players.size();
		
		for(int i = 0; i < sizePlayers; i++) {
			turns.insert(players.get(i));
		}
		
		//Meto en la lista de turnos a los enemigos
		int sizeEnemies = enemies.size();
		
		for (int i = 0; i < sizeEnemies; i++) {
			turns.insert(enemies.get(i));
		}
		
	}
}
