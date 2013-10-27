package es.juegojava.mapa;

import es.juegojava.common.*;


// TODO: Auto-generated Javadoc
/**
 * The Class Item.
 */
public class Item extends Element
{
	
	/** The tipo. */
	private ItemsType tipo;
	
	/** The desc. */
	public String desc;
	
	
	/**
	 * Instantiates a new item.
	 */
	public Item() {
		super(1, "nameDefault");
		tipo = ItemsType.NINGUNO;
	}
	
	/**
	 * Instantiates a new item.
	 *
	 * @param nombre the nombre
	 * @param id the id
	 * @param tipo the tipo
	 * @param desc the desc
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
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public ItemsType getTipo() {
		return tipo;
	}
	
	/**
	 * Sets the tipo.
	 *
	 * @param tipo the tipo to set
	 */
	public void setTipo(ItemsType tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the desc.
	 *
	 * @return the desc
	 */	
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the desc.
	 *
	 * @param desc the new desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	
	
}
