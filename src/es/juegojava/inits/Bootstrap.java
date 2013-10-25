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
import es.juegojava.mapa.ItemArma;
import es.juegojava.mapa.ItemArmadura;
import es.juegojava.mapa.ItemPotionAttack;
import es.juegojava.mapa.ItemPotionDefense;
import es.juegojava.mapa.ItemPotionInitiative;
import es.juegojava.mapa.ItemPotionLife;
import es.juegojava.mapa.Room;
import es.juegojava.players.Enemy;
import es.juegojava.common.ClassType;
import es.juegojava.common.ItemsType;
import es.juegojava.common.Raza;
import es.juegojava.common.WeaponsType;



/**
 * @author pablo.fernandez
 *
 */
public class Bootstrap 
{
	private String jsonSource;
	private Integer IdRoomFinale;
	
	
	
	/**
	 * @return the idRoomFinale
	 */
	public Integer getIdRoomFinale() {
		return IdRoomFinale;
	}

	public Bootstrap() {
		loadJsonFile("mapa.json");
	}
	
	public HashMap<Integer, Room> loadRooms() {
		try (JsonReader jsonReader = Json.createReader(new FileReader(jsonSource))) {
			
			HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
			JsonArray arrayData = jsonReader.readArray();
			
			
			int size = arrayData.size();
			
			//Crear habitaciones
			
			for(int i = 0; i < size; i++) {
				JsonObject obj = arrayData.getJsonObject(i);
				
				Room room = new Room(obj.getInt("id"), obj.getString("name"));
				
				rooms.put(obj.getInt("id"), room);
				
				if(obj.containsValue("finale")) {
					IdRoomFinale = room.getId();
				}
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
						String type = itemsJson.getJsonObject(j).getString("type");
						
						
						Item item = loadItemForType(itemsJson.getJsonObject(j), name, id, type);
						
						if(null != item)  {
							r.getItems().add(item);
						}
						
					}
				}
				
				
				//Enemies
				itemsJson = arrayData.getJsonObject(i).getJsonArray("enemies");
				
				int sizeEnemies = itemsJson.size();
				
				if(sizeEnemies > 0) {
					for(int j = 0; j < sizeEnemies; j++) {
						Integer id = itemsJson.getJsonObject(j).getInt("id");
						String name = itemsJson.getJsonObject(j).getString("name");
						Integer razaInt = itemsJson.getJsonObject(j).getInt("raza");
						Integer classInt = itemsJson.getJsonObject(j).getInt("class");
						Integer attack = itemsJson.getJsonObject(j).getInt("attack");
						Integer defense = itemsJson.getJsonObject(j).getInt("defense");
						Integer life = itemsJson.getJsonObject(j).getInt("life");
						Integer initiative = itemsJson.getJsonObject(j).getInt("initiative");
						
						//Weapon Item
						JsonObject weaponItem = itemsJson.getJsonObject(j).getJsonObject("weapon");
						Integer idWeaponItem = weaponItem.getInt("id");
						String nameWeaponItem = weaponItem.getString("name");
						String typeWeaponItem = weaponItem.getString("type");
						
						//Siempre va a ser un arma lo que se le equipe al enemigo
						ItemArma weapon = (ItemArma)loadItemForType(weaponItem, nameWeaponItem, idWeaponItem, typeWeaponItem);
						
						
						//Drop item
						JsonObject dropItem = itemsJson.getJsonObject(j).getJsonObject("itemDrop");
						Integer idDropItem = dropItem.getInt("id");
						String nameDropItem = dropItem.getString("name");
						String typeDropItem = dropItem.getString("type");
						
						Item itemToDrop =  loadItemForType(dropItem, nameDropItem, idDropItem, typeDropItem);
						
						Enemy enemy = new Enemy(id, name, Raza.values()[razaInt-1], ClassType.values()[classInt-1], attack, defense, life, initiative, weapon, itemToDrop);
						
						r.getEnemies().add(enemy);
						
						
						
						
						
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
	
	private Item loadItemForType(JsonObject itemsJson, String name, Integer id, String type) {
		
		Item item = null;
		
		switch(type) {
			case "weapon":
				Integer typeWeaponItem = itemsJson.getInt("weaponType");
				Integer classItem = itemsJson.getInt("weaponClass");
				Integer attackPoints = itemsJson.getInt("attack");
				item = new ItemArma(name, id, WeaponsType.values()[typeWeaponItem-1], ClassType.values()[classItem-1], attackPoints);
				
				break;
			case "armor":
				Integer defensePoints = itemsJson.getInt("defense");
				item = new ItemArmadura(name, id, defensePoints);
				
				break;
			case "potionLife":
				Integer lifePointsFromPotion = itemsJson.getInt("life");
				item = new ItemPotionLife(name, id, lifePointsFromPotion);
				
				break;
			case "potionAttack":
				Integer attackPointsFromPotion = itemsJson.getInt("attack");
				item = new ItemPotionAttack(name, id, attackPointsFromPotion);
				
				break;
			case "potionDefense":
				Integer defensePointsFromPotion = itemsJson.getInt("defense");
				item = new ItemPotionDefense(name, id, defensePointsFromPotion);
				
				break;
			case "potionIniiative":
				Integer initiativePointsFromPotion = itemsJson.getInt("initiative");
				item = new ItemPotionInitiative(name, id, initiativePointsFromPotion);
				
				break;
		}
		
		return item;
	}
	
	private void loadJsonFile(String jsonfile) {
		this.jsonSource = jsonfile;
	}
	
}
