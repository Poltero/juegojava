/**
 * 
 */
package es.juegojava.logics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import es.juegojava.players.Enemy;
import es.juegojava.players.ListPjWithClassOrdered;
import es.juegojava.players.PjWithClass;
import es.juegojava.players.Player;
import es.juegojava.ui.UIManager;

// TODO: Auto-generated Javadoc
/**
 * The Class CombatEngine.
 *
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 * 
 * Clase encargada de manejar las batallas entre los PjWithClass
 */
public class CombatEngine 
{
	
	/** The turns. */
	private ListPjWithClassOrdered turns;
	
	/** The player num selected. */
	private int playerNumSelected;
	
	/** The number of players. */
	private int numberOfPlayers;
	
	/** The number of enemies. */
	private int numberOfEnemies;
	
	/** The attacker. */
	private PjWithClass attacker;
	
	/** The defender. */
	private PjWithClass defender;
	
	
	/**
	 * Instantiates a new combat engine.
	 *
	 * @param players the players
	 * @param enemies the enemies
	 */
	public CombatEngine(List<Player> players, List<Enemy> enemies) {
		
		numberOfPlayers = players.size();
		numberOfEnemies = enemies.size();
		
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
	
	/**
	 * Select candidates.
	 *
	 * @param actions the actions
	 * @return the hash map
	 */
	public HashMap<String, String> selectCandidates(List<Object> actions) {
		attacker = turns.get(0);
		HashMap<String, String> data = new HashMap<String, String>();
		
		int sizeTurns = turns.size();
		
		if(attacker instanceof Enemy) {
			playerNumSelected = (int)Math.random()*numberOfPlayers+1;
			int count = 1;
			
			for(int i = 0; i < sizeTurns; i++) {
				PjWithClass pj = turns.get(i);
				
				if(pj instanceof Player) {
			
					if(count == playerNumSelected) {
						//Guardamos el indice del player
						defender = pj;
						data.put("state", "attackerbyenemy");
						break;
					}
					
					count++;
				}
			}
			
		} else if(attacker instanceof Player) {
			int count = 1;
			String str = "";
			
			data.put("state", "attackerbyplayer");
			
			//Mostrar atacantes a los que atacar
			for(int i = 0; i < sizeTurns; i++) {
				PjWithClass pj = turns.get(i);
				
				if(pj instanceof Enemy) {
					str += count + "- " + pj.getNombre() + "\n";
					
					actions.add(count);
					
					count++;
				}
			}
			
			data.put("actionsToPrint", str);
		}
		
		return data;
	}
	
	
	/**
	 * Select enemy to attack.
	 *
	 * @param numEnemy the num enemy
	 */
	public void selectEnemyToAttack(int numEnemy) {
		int sizeTurns = turns.size();
		int count = 1;
		
		for(int i = 0; i < sizeTurns; i++) {
			PjWithClass pj = turns.get(i);
			
			if(pj instanceof Enemy) {
				if(count == numEnemy) {
					//Guardamos el indice del player
					defender = pj;
					break;
				}
				
				count++;
			}
		}
	}
	
	/**
	 * Start.
	 *
	 * @return the int[]
	 */
	public int[] start() {
		int[] dataAttack = attacker.attack(defender);
		
		
		if(defender.getLife() == 0) {
			turns.remove(defender);
			if(defender instanceof Player) {
				this.numberOfPlayers--;
			} else {
				this.numberOfEnemies--;
			}
		
		} else {
			//Eliminamos al atacante
			turns.remove(0);
			
			//Lo metemos al final
			turns.add(attacker);
		}
		
		return dataAttack;
	}
	
	
	/**
	 * Gets the state combat.
	 *
	 * @return the state combat
	 */
	public String getStateCombat() {
		if(this.numberOfPlayers == 0) {
			return "loseplayer";
		} else if(this.numberOfEnemies == 0) {
			return "loseenemies";
		} else {
			return "continue";
		}
	}

	/**
	 * Gets the attacker.
	 *
	 * @return the attacker
	 */
	public PjWithClass getAttacker() {
		return attacker;
	}

	/**
	 * Gets the defender.
	 *
	 * @return the defender
	 */
	public PjWithClass getDefender() {
		return defender;
	}
}
