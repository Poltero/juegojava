package es.juegojava.logics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.juegojava.common.ClassType;
import es.juegojava.common.Element;
import es.juegojava.common.GameStatus;
import es.juegojava.common.ItemsType;
import es.juegojava.exceptions.OptionInvalidException;
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
	List<Object> actions;
	String[] doors;
	
	
	public Logic(UIManager ui) {
		super();
		this.ui = ui;
		
		doors = new String[4];
		doors[0] = "Arriba";
		doors[1] = "Derecha";
		doors[2] = "Abajo";
		doors[3] = "Izquierda";
	}

	public void printRoomDesc(Room roomToDesc){
		String desc = "";
		desc = roomToDesc.toString();
		ui.imprimirPorPantalla(desc);
	}
	
	public void printActions(Room currentRoom, String state){
		
		String desc = "";
		
		actions = new ArrayList<Object>();
		
		if(state == "roomscreen") {
		
			if(currentRoom.getEnemies().size() != 0){
				desc = "1- Atacar\n" +
						"2- Cambiar de sala\n";
				
				actions.add("attackstate");
				actions.add("changeroom");
				
			}else{
				desc = "1- Hablar con el NPC\n" +
						"2- Ver inventario\n" + 
						"3- Coger un item\n" +
						"4- Tirar un item al suelo\n" +
						"5- Cambiar de sala\n";
				
				actions.add("speakscreen");
				actions.add("inventarioscreen");
				actions.add("takeitemscreen");
				actions.add("dropitemscreen");
				actions.add("changeroom");
			}
		
		} else if(state == "changeroom") {
			ui.imprimirPorPantalla("Elige una de las siguientes puertas: ");
			
			List<Integer> connections = currentRoom.getConnections();
			
			int sizeConnections = connections.size();
			
			for(int i = 0; i < sizeConnections; i++) {
				int option = i+1;
				desc += option + "- " + doors[i];
				
				actions.add(connections.get(i));
		
			}	
		} else if(state == "takeitemscreen") {
			ui.imprimirPorPantalla("Al explorar la habitacion encuentras los siguientes items: ");
			
			List<Item> items = currentRoom.getItems();
			
			int	sizeItems = items.size();
			
			for(int i = 0; i < sizeItems; i++) {
				int option = i+1;
				desc += option + "- " + items.get(i).getNombre() + "\n";
				
				actions.add(i);
		
			}	
		}
		
	
		desc += "\nSelecciona una opcion: \n";
		ui.imprimirPorPantalla(desc);
	}
	
	public Object selectActions() throws OptionInvalidException {
		
		int sizeActions = actions.size();
		
		if(sizeActions > 0) {
		
			int option = ui.leerNumeroTeclado();
			
			if(option > 0 && option <= sizeActions) {
				return actions.get(option-1);
			} else {
				throw new OptionInvalidException("Opcion no valida!");
			}
		} else {
		
			throw new NullPointerException();
		}
		
	}
	
	public void showInventario(Player currentPlayer) {
		List<Item> inventario = currentPlayer.getInventario();	
		actions = new ArrayList<Object>();
		
		int sizeInventario = inventario.size();
		
		if(sizeInventario > 0) {	
			for(int i = 0; i < sizeInventario; i++) {
				int count = i + 1;
				ui.imprimirPorPantalla(count + "- " + inventario.get(i).getNombre() + "[" + inventario.get(i).getTipo() + "]");
				actions.add(i);
			}
			
			ui.imprimirPorPantalla("\nEquipar/Usar\n");
		} else {
			ui.imprimirPorPantalla("El inventario del PJ actual está vacio");
		}
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
