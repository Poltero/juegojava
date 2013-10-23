package es.juegojava.logics;
import es.juegojava.common.GameStatus;
import es.juegojava.mapa.Room;
import es.juegojava.players.PersonajeNeutro;
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
					"2- Cambiar de sala\n";
			
		}else{
			desc = "1- Hablar con el NPC\n" +
					"2- Explorar la sala\n" +
					"3- Equipar Item\n" + 
					"4- Cambiar de sala\n";
		}
	
		desc += "Que quieres hacer?\n";
		ui.imprimirPorPantalla(desc);
	}
	
	public void imprimirDialogo(PersonajeNeutro npc, int numeroDeFrase){
		ui.imprimirPorPantalla(npc.toString(numeroDeFrase));
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
}
