package es.juegojava.logics;
import java.util.Iterator;
import java.util.List;

import es.juegojava.common.ClassType;
import es.juegojava.common.GameStatus;
import es.juegojava.common.ItemsType;
import es.juegojava.mapa.Item;
import es.juegojava.mapa.Room;
import es.juegojava.players.Enemy;
import es.juegojava.players.PersonajeNeutro;
import es.juegojava.players.PjWithClass;
import es.juegojava.players.Player;
import es.juegojava.ui.*;

public class Logic {
	
	GameStatus estadoJuego;
	UIManager ui;
	
	
	public Logic(UIManager ui) {
		super();
		this.ui = ui;
	}

	public void printRoomDesc(Room roomToDesc){
		String desc = "";
		desc = roomToDesc.toString();
		ui.imprimirPorPantalla(desc);
	}
	
	public void imprimirListaAcciones(Room currentRoom){
		
		String desc = "";
		
		if(currentRoom.getEnemies().size() != 0){
			desc = "1- Atacar\n" +
					"2- Cambiar de sala\n" + 
					"3- Pasar turno\n";
			
		}else{
			desc = "1- Hablar con el NPC\n" +
					"2- Explorar la sala\n" +
					"3- Equipar item\n" + 
					"4- Tirar un item al suelo\n" +
					"4- Cambiar de sala\n" + 
					"5- Pasar turno\n";
		}
	
		desc += "Que quieres hacer?\n";
		ui.imprimirPorPantalla(desc);
	}
	
	public void imprimirDialogo(PersonajeNeutro npc, int numeroDeFrase){
		ui.imprimirPorPantalla(npc.toString(numeroDeFrase));
	}
	
	public void showItemsFromRoom(List<Item> items) {
		Iterator<Item> it = items.iterator();
		
		int count = 1;
		
		while(it.hasNext()) {
			ui.imprimirPorPantalla("[" + count + " ]" +  it.next().toString() + "\n");
			
			count++;
		}
	}
	
	public void showEnemiesFromRoom(List<Enemy> enemies) {
		Iterator<Enemy> it = enemies.iterator();
		
		int count = 1;
		
		while(it.hasNext()) {
			ui.imprimirPorPantalla("[" + count + " ]" +  it.next().toString() + "\n");
			
			count++;
		}
	}
	
	public void explorarHabitacion(Room habitacionAExplorar){
		
		int nItems = habitacionAExplorar.getItems().size();
		
		if(nItems!=0){
			ui.imprimirPorPantalla("Exploras la sala y encuentras...\n");
			for(int i = 0; i < nItems; i++){
				ui.imprimirPorPantalla(habitacionAExplorar.getItems().get(i).getNombre());
			}
		}else{
			ui.imprimirPorPantalla("No hay items en la sala\n");
		}
	}
	
	//Metodo para mostrar los items de la lista cuando selecciones la opcion "equipar item" o "usar pocion"
	public void imprimirListaItemUsables(Player currentPlayer, ItemsType tipoItem){
		
		Item itemAMostrar;
	
		for(int i = 0; i < currentPlayer.getInventario().size(); i++){
			
			itemAMostrar = currentPlayer.getInventario().get(i);
			
			if(tipoItem == itemAMostrar.getTipo()){
				ui.imprimirPorPantalla(itemAMostrar.toString());
			}
		}
	}
	
	
	
	
	public void imprimirMuertePj(PjWithClass pjToDie){
		
		String dialogoMuerte = "";
				
		dialogoMuerte = "El " + pjToDie.classToSring() + " " + pjToDie.getNombre() + 
				" ha muerto.";
		
		ui.imprimirPorPantalla(dialogoMuerte);
	}

	
}
