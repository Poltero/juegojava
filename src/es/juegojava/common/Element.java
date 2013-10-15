/**
 * 
 */
package es.juegojava.common;

/**
 * @author pfranco
 *
 */
public abstract class Element 
{
	protected Integer id;
	protected String nombre;
	
	public Element(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
