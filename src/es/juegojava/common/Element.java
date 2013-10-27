/**
 * 
 */
package es.juegojava.common;


/**
 * 
 * @author pablo.fernandez
 * @author Carlos.Belmonte
 * 
 * The Class Element.
 * 
 */
public abstract class Element 
{
	
	/** El id de los elementos del juego, cada elemento del juego se corresponde con un ID unco. */
	protected Integer id;
	
	/** The nombre del elemento del juego, todo elemento del juego necesita un nombre. */
	protected String nombre;
	
	/**
	 * Instantiates a new element.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 */
	public Element(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
