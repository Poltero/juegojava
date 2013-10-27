package es.juegojava.logics;

import java.util.ArrayList;

import es.juegojava.players.PjWithClass;
import es.juegojava.players.Player;
import es.juegojava.ui.UIManager;

public class ConversationEngine {

	UIManager ui;
	ArrayList<String> dialogoPersonaje;
	ArrayList<String> dialogoNpc;
	
	//Player pj;
	//PjWithClass npc;
	
	public ConversationEngine(UIManager ui, ArrayList<String> dialogoNpc,
			ArrayList<String> dialogoPersonaje) {
		super();
		this.ui = ui;
		this.dialogoNpc = dialogoNpc;
		this.dialogoPersonaje = dialogoPersonaje;
	}

	
	public ArrayList<String> getDialogoNpc() {
		return dialogoNpc;
	}

	public void setDialogoNpc(ArrayList<String> dialogoNpc) {
		this.dialogoNpc = dialogoNpc;
	}

	public ArrayList<String> getDialogoPersonaje() {
		return dialogoPersonaje;
	}

	public void setDialogoPersonaje(ArrayList<String> dialogoPersonaje) {
		this.dialogoPersonaje = dialogoPersonaje;
	}
	
	
	public void loadPlayerDialog(int roomId){
		//Leemos del json el array con los dialogos del player dependiendo de la habitacion donde nos encontremos
	}
	
	public void startConver(ArrayList<String> dialogoNpc){
		
		//Imprimimos la conversacion por pantalla		
		
	}
	
	public void imprimirListaRespuesta(){
		//Imprimimos la lista de respuestas que puede dar el personaje
	}
	
	public void imprimirFrase(ArrayList<String> dialogoNpc){
		
	}
	
}
