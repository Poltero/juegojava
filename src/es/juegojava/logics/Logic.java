package es.juegojava.logics;
import es.juegojava.common.GameStatus;
import es.juegojava.mapa.Room;
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
		
		if(currentRoom.enemies.size() != 0){
			desc = "meter opciones 1 y 2";
		}else{
			desc = "meter resto acciones";
		}
		
		
		ui.imprimirPorPantalla(desc);
	}
	
	
	
}
