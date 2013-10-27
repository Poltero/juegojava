package es.juegojava.mapa;

import es.juegojava.common.*;


public class Item extends Element
{
	private ItemsType tipo;
	public String desc;
	
	
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
	public Item(String nombre, int id, ItemsType tipo, String desc) {
		super(id, nombre);
		this.desc = desc;
		this.tipo = tipo;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (nombre + " tipo: " + tipo + "\n" + desc);
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

	/**
	 * @return the desc
	 */	
	public String getDesc() {
		return desc;
	}

	/**
	 * @param tipo the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	
	
}
