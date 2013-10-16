/**
 * 
 */
package es.juegojava.inits;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import es.juegojava.mapa.Item;
import es.juegojava.mapa.Room;

import es.juegojava.common.ItemsType;



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
			
			  									
			//Crear conexiones entre habitaciones y items
			
			for(int i = 0; i < size; i++) {
				Object[] connections = arrayData.getJsonObject(i).getJsonArray("connections").toArray();
				
				int sizeConnections = connections.length;
				
				//Current Room
				Room r = rooms.get(arrayData.getJsonObject(i).getInt("id"));
				
				//Connections
				
				if(sizeConnections > 0) {
					for(int j = 0; j < sizeConnections; j++) {
						r.getConnections().add(rooms.get(connections[j]));
					}
				}
				
				//Items
				JsonArray itemsJson = arrayData.getJsonObject(i).getJsonArray("items");
				
				int sizeItems = itemsJson.size();
				
				if(sizeItems > 0) {
					for(int j = 0; j < sizeItems; j++) {
						Integer id = itemsJson.getJsonObject(j).getInt("id");
						String name = itemsJson.getJsonObject(j).getString("name");
						Integer typeInt = itemsJson.getJsonObject(j).getInt("type");
						
						ItemsType type = ItemsType.NINGUNO;
						
						switch(typeInt) {
							case 1:
								type = ItemsType.ARMA;
							case 2:
								type = ItemsType.ARMADURA;
							case 3:
								type = ItemsType.POCION;
						}
						
						
						r.getItems().add(new Item(name, id, type));
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
