/**
 * 
 */
package es.juegojava.game;

import java.util.HashMap;

import es.juegojava.inits.Bootstrap;
import es.juegojava.mapa.Room;

/**
 * @author pfranco
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bootstrap bp = new Bootstrap();
		
		HashMap<Integer, Room> rooms = bp.generateRooms();
		
		System.out.println(rooms.get(1).getNombre());
		System.out.println(rooms.get(1).getItems().get(0).getNombre());
		
		
		

	}

}
