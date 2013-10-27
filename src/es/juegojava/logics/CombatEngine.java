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

/**
 * @author pfranco
 *
 */
public class CombatEngine 
{
	private ListPjWithClassOrdered turns;
	private int playerNumSelected;
	private int numberOfPlayers;
	private PjWithClass attacker;
	private PjWithClass defender;
	
	
	public CombatEngine(List<Player> players, List<Enemy> enemies) {
		
		numberOfPlayers = players.size();
		
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
	
	public int[] start() {
		int[] dataAttack = attacker.attack(defender);
		
		
		if(defender.getLife() == 0) {
			turns.remove(defender);
		
		} else {
			//Eliminamos al atacante
			turns.remove(0);
			
			//Lo metemos al final
			turns.add(attacker);
		}
		
		return dataAttack;
	}

	/**
	 * @return the attacker
	 */
	public PjWithClass getAttacker() {
		return attacker;
	}

	/**
	 * @return the defender
	 */
	public PjWithClass getDefender() {
		return defender;
	}
}
