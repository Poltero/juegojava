package es.juegojava.logics;
import es.juegojava.mapa.Room;
import es.juegojava.ui.*;

public class Logic {

	UIManager ui;
	
	
	public Logic(UIManager ui) {
		super();
		this.ui = ui;
	}

	public void printRoomDesc(Room roomToDesc){
		String desc ="";
		desc = roomToDesc.toString();
		ui.imprimirPorPantalla(desc);
	}
	
	
	
	
	
}
