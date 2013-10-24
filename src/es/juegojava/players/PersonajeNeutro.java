package es.juegojava.players;

import java.util.ArrayList;

import es.juegojava.common.Raza;

public class PersonajeNeutro extends Personaje {
	
	ArrayList<String> dialogo;


	public PersonajeNeutro(Integer id, String nombre, Raza raza) {
		super(id, nombre, raza);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(int numeroDialogo){
		return dialogo.get(numeroDialogo);
	}

}
