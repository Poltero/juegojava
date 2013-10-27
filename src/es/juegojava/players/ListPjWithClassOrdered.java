/**
 * 
 */
package es.juegojava.players;

import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class ListPjWithClassOrdered.
 *
 * @author pfranco
 */
public class ListPjWithClassOrdered extends ArrayList<PjWithClass> {
	
/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Insert.
	 *
	 * @param pj the pj
	 */
	public void insert(PjWithClass pj) {
		if(this.size() == 0) {
			this.add(pj);
		} else {
			
			int index = 0;
			
			for(int i = 0; i < size(); i++) {
				if(pj.getInitiative() <= listIterator().next().getInitiative()) {
					index++;
				}
			}
			
			add(index, pj);
			
		}
	}
}
