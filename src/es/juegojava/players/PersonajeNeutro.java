package es.juegojava.players;

import java.util.ArrayList;

import es.juegojava.common.Raza;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonajeNeutro.
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
	public PersonajeNeutro(Integer id, String nombre, Raza raza) {
		super(id, nombre, raza);
		// TODO Auto-generated constructor stub
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
