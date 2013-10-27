package es.juegojava.logics;

//import java.sql.Array;
/*import java.util.ArrayList;

import es.juegojava.players.PjWithClass;
import es.juegojava.players.Player;
import es.juegojava.ui.UIManager;*/

public class ConversationEngine {

	/*UIManager ui;
	ArrayList<ArrayList<String>> dialogoPersonaje;
	
	ArrayList<String> dialogoNpc;
	ArrayList<String> finalDialog;

	


	
	public ConversationEngine(UIManager ui) {
		super();
		this.ui = ui;
		this.dialogoPersonaje = dialogoPersonaje;
		this.dialogoNpc = dialogoNpc;
		this.finalDialog = finalDialog;
	}

	public ArrayList<String> getDialogoNpc() {
		return dialogoNpc;
	}

	public void setDialogoNpc(ArrayList<String> dialogoNpc) {
		this.dialogoNpc = dialogoNpc;
	}


	public ArrayList<ArrayList<String>> getDialogoPersonaje() {
		return dialogoPersonaje;
	}


	public void setDialogoPersonaje(ArrayList<ArrayList<String>> dialogoPersonaje) {
		this.dialogoPersonaje = dialogoPersonaje;
	}

	
	public void imprimirListaRespuestas(int numerodeLista){
		for(int i = 0; i < dialogoPersonaje.get(numerodeLista).size(); i++){
			ui.imprimirPorPantalla(dialogoPersonaje.get(numerodeLista).get(i));
		}
	}

	public void imprimirDialogo(){
		
		for(int i = 0; i < dialogoPersonaje.size(); i++){
			if(dialogoPersonaje.get(i).size() > 1){
				imprimirListaRespuestas(i);
			}else{
				ui.imprimirPorPantalla(dialogoPersonaje.get(i).get(0));
			}
		}
		
	}
	
	
	
	
	
	
	/*
	
	
	
	
	
	
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
	*/
	
}
