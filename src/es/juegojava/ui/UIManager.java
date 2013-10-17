/**
 * 
 */
package es.juegojava.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


import es.juegojava.common.Element;
import es.juegojava.mapa.Item;
import es.juegojava.mapa.Room;

/**
 * @author pablo.fernandez
 *
 */

public class UIManager {

	public void descripcion(Element elementoADescribir){
		//Descripcion generica de cualquier elemento
		//imprimimos el toString
		//To-do
	}
		
	
	public void describirHabitacion(Room habitacionADescribir){
		//To-do
		
		/*
		String roomPath = "Room" + habitacionADescribir.getId() + "Desc.txt";

		String descFichero = "";
		descFichero = leerFichero(roomPath).toString();
		String aspecto = "";
		String token = "####";
		String nombreHabitacion = habitacionADescribir.getNombre();
		aspecto = descFichero.replace(token, nombreHabitacion);
		aspecto += "\nEn la habitacion hay...\n";
		
		String contenidoHabitacion = "";
		contenidoHabitacion = habitacionADescribir.getNombre();
		*/
	}
	
	public void imprimirMenuAcciones(){
		//To-do
	}
	
	
	
	public void describirItem(Item itemADescribir){
		//To-do
	}
	
	public static void imprimirPorPantalla(String salida){
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(salida);
		pw.flush();
		pw.close();		
	}
	
	public static void imprimirPorPantalla(int salida){
		PrintWriter pw = new PrintWriter(System.out);
		String cadena = "";
		cadena += salida;
		pw.println(cadena);
		pw.flush();
		pw.close();	
	}
	
	public static int leerNumeroTeclado(){
		Scanner sc = new Scanner(System.in);
		int salida = -1;
		
		try{
			salida = sc.nextInt();
		}catch(InputMismatchException e){
			imprimirPorPantalla("El valor introducido no es un entero");
			sc.nextLine();
		}
		sc.close();
		return salida;
	}
	
	public static String leerCadenaTeclado(){
		Scanner sc = new Scanner(System.in);
		String salida = "";
		
		try{
			salida = sc.nextLine();
		}catch(InputMismatchException e){
			imprimirPorPantalla("El valor introducido no es una cadena");
			sc.nextLine();
		}
		sc.close();
		return salida;
	}
	
	public ArrayList leerFichero(String path){
		ArrayList salida = new ArrayList();
		File fichero = new File(path);
		Scanner sc;
		try {
			sc = new Scanner(fichero);
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				salida.add(linea);
			}
			sc.close();
		} catch (FileNotFoundException e) {
		   e.printStackTrace();
		}
		return salida;
	}
}
