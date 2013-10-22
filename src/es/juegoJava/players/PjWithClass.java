/**
 * 
 */
package es.juegojava.players;

import es.juegojava.common.ClassType;
import es.juegojava.common.Raza;

/**
 * @author pablo.fernandez
 *
 */
public class PjWithClass extends Personaje {

	protected ClassType classPj;
	protected int attack;
	protected int defense;
	protected int life;
	protected int initiative;
	
	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	/**
	 * @return the classPj
	 */
	public ClassType getClassPj() {
		return classPj;
	}

	/**
	 * @param classPj the classPj to set
	 */
	public void setClassPj(ClassType classPj) {
		this.classPj = classPj;
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @return the life
	 */
	public int getLife() {
		return life;
	}

	/**
	 * @param life the life to set
	 */
	public void setLife(int life) {
		this.life = life;
	}

	/**
	 * @return the initiative
	 */
	public int getInitiative() {
		return initiative;
	}

	/**
	 * @param initiative the initiative to set
	 */
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public PjWithClass(Integer id, String nombre, Raza raza, ClassType classPj, int attack, int life, int initiative) {
		super(id, nombre, raza);
		
		this.attack = attack;
		this.life = life;
		this.initiative = initiative;
		this.classPj = classPj;
	}

}
