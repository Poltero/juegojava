package es.juegojava.players;

import java.util.ArrayList;

import es.juegojava.common.Raza;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonajeNeutro.
 * 
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 * 
 */
public class PersonajeNeutro extends Personaje {
	
	/** The dialogo. */
	ArrayList<String> dialogo;



/**
 * Instantiates a new personaje neutro.
 *
 * @param id the id
 * @param nombre the nombre
 * @param raza the raza
 */
	public PersonajeNeutro(Integer id, String nombre, Raza raza, ArrayList<String> dialog) {
		super(id, nombre, raza);
		
		this.dialogo = dialog;
		
	}
	
	/**
	 * To string.
	 *
	 * @param numeroDialogo the numero dialogo
	 * @return the string
	 */
	public String toString(int numeroDialogo){
		return dialogo.get(numeroDialogo);
	}

}
