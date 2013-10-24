package es.juegojava.mapa;

import es.juegojava.common.*;


public class Item extends Element
{
	private ItemsType tipo;
	
	
	/**
	 * 
	 */
	public Item() {
		super(1, "nameDefault");
		tipo = ItemsType.NINGUNO;
	}
	
	/**
	 * @param nombre
	 * @param id
	 * @param tipo
	 */
	public Item(String nombre, int id, ItemsType tipo) {
		super(id, nombre);
		this.tipo = tipo;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (nombre + " tipo: " + tipo);
	}
	
	
	/**
	 * @return the tipo
	 */
	public ItemsType getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(ItemsType tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
