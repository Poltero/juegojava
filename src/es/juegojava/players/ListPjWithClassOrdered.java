/**
 * 
 */
package es.juegojava.players;

import java.util.ArrayList;


/**
 * @author pfranco
 *
 */
public class ListPjWithClassOrdered extends ArrayList<PjWithClass> {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
