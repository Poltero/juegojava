/**
 * 
 */
package es.juegojava.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


import es.juegojava.common.Element;
import es.juegojava.mapa.Item;
import es.juegojava.mapa.Room;

// TODO: Auto-generated Javadoc
/**
 * The Class UIManager.
 *
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 * 
 */

public class UIManager {
	
	/** The pw. */
	static PrintWriter pw = null;
	
	/** The sc. */
	static Scanner sc = null;	
	
	/** The archivo. */
	static File archivo = null;
    
    /** The fr. */
    static FileReader fr = null;
    
    /** The br. */
    static BufferedReader br = null;

	/**
	 * Instantiates a new uI manager.
	 */
	public UIManager() {
		super();
		pw = new PrintWriter(System.out, true);
		
	}
	
	/**
	 * Destruir ui.
	 */
	public static void destruirUI(){
		pw.flush();
		pw.close();
		sc.close();
	}
	
	/**
	 * Imprimir por pantalla.
	 *
	 * @param salida the salida
	 */
	public void imprimirPorPantalla(String salida){
		pw.println(salida);	
	}
	
	/**
	 * Imprimir por pantalla.
	 *
	 * @param salida the salida
	 */
	public void imprimirPorPantalla(int salida){
		PrintWriter pw = new PrintWriter(System.out, true);
		String cadena = "";
		cadena += salida;
		pw.println(cadena);
	}
	
	/**
	 * Leer numero teclado.
	 *
	 * @return the int
	 */
	public int leerNumeroTeclado(){
		int salida = -1;
		try{
			salida = sc.nextInt();
		}catch(InputMismatchException e){
			imprimirPorPantalla("El valor introducido no es un entero");
			sc.nextLine();
		}
		return salida;
	}
	
	/**
	 * Leer cadena teclado.
	 *
	 * @return the string
	 */
	public String leerCadenaTeclado(){
		sc = new Scanner(System.in);
		String salida = "";
		
		try{
			salida = sc.nextLine();
		}catch(InputMismatchException e){
			imprimirPorPantalla("El valor introducido no es una cadena");
			sc.nextLine();
		}
		return salida;
	}
	
	/**
	 * Leer fichero.
	 *
	 * @param path the path
	 * @return the array list
	 */
	public static ArrayList<String> leerFichero(String path){
		ArrayList<String> salida = new ArrayList<String>();
		
		try {
			archivo = new File(path);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea;
			while((linea=br.readLine())!=null)
				salida.add(linea);
		  	}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{                    
				if( null != fr ){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}	
		}
		return salida;
	}
	
	
	

		
	
	/**
	 * Describir habitacion.
	 *
	 * @param habitacionADescribir the habitacion a describir
	 */
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
}
