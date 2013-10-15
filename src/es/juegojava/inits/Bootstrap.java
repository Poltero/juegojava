/**
 * 
 */
package es.juegojava.inits;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import es.juegojava.mapa.Room;



/**
 * @author pablo.fernandez
 *
 */
public class Bootstrap 
{
	String jsonSource;
	
	
	
	public Bootstrap() {
		loadJsonFile("E:/workspace/GamePracticas/mapa.json");
	}
	
	public HashMap<Integer, Room> generateRooms() {
		try (JsonReader jsonReader = Json.createReader(new FileReader(jsonSource))) {
			
			HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
			JsonArray arrayData = jsonReader.readArray();
			
			
			int size = arrayData.size();
			
			//Crear habitaciones
			
			for(int i = 0; i < size; i++) {
				JsonObject obj = arrayData.getJsonObject(i);
				
				Room room = new Room(obj.getInt("id"), obj.getString("name"));
				
				rooms.put(obj.getInt("id"), room);
			}
			
			  									
			//Crear conexiones entre habitaciones
			
			for(int i = 0; i < size; i++) {
				Object[] connections = arrayData.getJsonObject(i).getJsonArray("connections").toArray();
				
				int sizeConnections = connections.length;
				
				
				if(sizeConnections > 0) {
					for(int j = 0; j < sizeConnections; j++) {
						Room r = rooms.get(arrayData.getJsonObject(i).getInt("id"));
						
						r.getConnections().add(rooms.get(connections[j]));
					}
				}
			}
			
			return rooms;
			
			   			  			  
			  
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				return null;
			}
	}
	
	private void loadJsonFile(String jsonfile) {
		this.jsonSource = jsonfile;
	}
	
}
