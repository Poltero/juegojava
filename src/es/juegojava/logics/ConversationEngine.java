package es.juegojava.logics;

import java.util.ArrayList;

import es.juegojava.players.PersonajeNeutro;
import es.juegojava.players.PjWithClass;
import es.juegojava.players.Player;
import es.juegojava.ui.UIManager;

public class ConversationEngine {

	UIManager ui;
	ArrayList<String> listaDialogosFinal;

	ArrayList<String> dialogosPj = new ArrayList<String>();
	
	
	public ConversationEngine(UIManager ui) {
		super();
		this.ui = ui;
		
		dialogosPj.add("Si si, pero sabes donde esta el troll que se ha llevado nuestro condensador de fluzo?");
	}
	
	
	public void imprimirDialogos(PersonajeNeutro npc){
		for(int i = 0; i < npc.getDialogo().size(); i++){
			if(i % 2 == 0){
				ui.imprimirPorPantalla(dialogosPj.get(0));
			}else{
				ui.imprimirPorPantalla(npc.getDialogo().get(i));
			}
		}
	}	
}
	
	
	

