<<<<<<< HEAD
package es.juegoJava.logics;
import es.juegojava.common.GameStatus;
=======
package es.juegojava.logics;
>>>>>>> 1519246cc8109ddf303a766cd619f3e4f7243dbc
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
	
	
	
	
}
