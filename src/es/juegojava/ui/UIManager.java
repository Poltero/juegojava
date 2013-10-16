/**
 * 
 */
package es.juegojava.ui;

import java.io.PrintWriter;
import java.util.Scanner;


import es.juegojava.common.Element;
import es.juegojava.mapa.Item;
import es.juegojava.mapa.Room;

/**
 * @author pablo.fernandez
 *
 */

//To-do Excepcion
public class UIManager {

	public void descripcion(Element elementoADescribir){
		
	}
	
	public void describirHabitacion(Room habitacionADescribir){
				
	}
	
	public void describirItem(Item itemADescribir){
		
	}
	
	public static void imprimirPorPantalla(String salida){
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(salida);
		pw.flush();
		pw.close();		
	}
	
	public int leerNumeroTeclado(){
		Scanner sc = new Scanner(System.in);
		int salida = sc.nextInt();
		return salida;
	}
	
	public String leerCadenaTeclado(){
		Scanner sc = new Scanner(System.in);
		String salida = sc.nextLine();
		return salida;
	}
	
	public String leerFichero(){
		String datos = "";
		//To-do
		return datos;
	}
}
