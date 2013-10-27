package es.juegojava.players;

import java.util.ArrayList;

import es.juegojava.common.Raza;

public class PersonajeNeutro extends Personaje {
	
	ArrayList<String> dialogo;


	public PersonajeNeutro(Integer id, String nombre, Raza raza, ArrayList<String> dialog) {
		super(id, nombre, raza);
		
		this.dialogo = dialog;
		
	}
	
	public String toString(int numeroDialogo){
		return dialogo.get(numeroDialogo);
	}

}
