/**
 * 
 */
package es.juegojava.players;

import es.juegojava.common.ClassType;
import es.juegojava.common.Raza;
import es.juegojava.mapa.ItemArma;

// TODO: Auto-generated Javadoc
/**
 * The Class PjWithClass.
 *
 * @author pablo.fernandez
 */
public class PjWithClass extends Personaje {

	/** The class pj. */
	protected ClassType classPj;
	
	/** The attack. */
	protected int attack;
	
	/** The defense. */
	protected int defense;
	
	/** The life. */
	protected int life;
	
	/** The initiative. */
	protected int initiative;
	
	/** The current weapon. */
	ItemArma currentWeapon;
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nombre + " [" + classPj + "] ("+ raza +"), Vida: "+ life;
	}

	/**
	 * Gets the defense.
	 *
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Sets the defense.
	 *
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	/**
	 * Gets the class pj.
	 *
	 * @return the classPj
	 */
	public ClassType getClassPj() {
		return classPj;
	}

	/**
	 * Sets the class pj.
	 *
	 * @param classPj the classPj to set
	 */
	public void setClassPj(ClassType classPj) {
		this.classPj = classPj;
	}

	/**
	 * Gets the attack.
	 *
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Sets the attack.
	 *
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * Gets the life.
	 *
	 * @return the life
	 */
	public int getLife() {
		return life;
	}

	/**
	 * Sets the life.
	 *
	 * @param life the life to set
	 */
	public void setLife(int life) {
		this.life = life;
	}

	/**
	 * Gets the initiative.
	 *
	 * @return the initiative
	 */
	public int getInitiative() {
		return initiative;
	}

	/**
	 * Sets the initiative.
	 *
	 * @param initiative the initiative to set
	 */
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	
	
	/**
	 * Gets the current weapon.
	 *
	 * @return the currentWeapon
	 */
	public ItemArma getCurrentWeapon() {
		return currentWeapon;
	}

	/**
	 * Sets the current weapon.
	 *
	 * @param currentWeapon the new current weapon
	 */
	public void setCurrentWeapon(ItemArma currentWeapon) {
		this.currentWeapon = currentWeapon;
	}

	
	/**
	 * Instantiates a new pj with class.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 * @param raza the raza
	 * @param classPj the class pj
	 * @param attack the attack
	 * @param defense the defense
	 * @param life the life
	 * @param initiative the initiative
	 * @param currentWeapon the current weapon
	 */
	public PjWithClass(Integer id, String nombre, Raza raza, ClassType classPj, 
			int attack, int defense, int life, int initiative, ItemArma currentWeapon) {
		
		super(id, nombre, raza);
		
		this.attack = 20 + attack;
		this.defense = 15 + defense;
		this.life = 100 + life;
		this.initiative = initiative;
		this.classPj = classPj;
		this.currentWeapon = currentWeapon;
	}
	
	/**
	 * Class to sring.
	 *
	 * @return the string
	 */
	public String classToSring(){
		String cadenaClase = "";
		
		ClassType claseAImprimir = this.classPj;
		
		switch (claseAImprimir){
		case TELECO:
			cadenaClase = "Teleco";
			break;
		case INFORMATICO:
			cadenaClase = "Informatico";
			break;
		case MATEMATICO:
			cadenaClase = "Matematico";
			break;
			default:
				cadenaClase = "Error";
				break;
		}
		return cadenaClase;
	}
	
	/**
	 * Attack.
	 *
	 * @param tarjetPj the tarjet pj
	 * @return the int[]
	 */
	public int[] attack(PjWithClass tarjetPj){
		
		int[] dataAtk = new int[3];
		
		int realAtk = this.attack + this.currentWeapon.getAtack();
		int mitigateAtk = realAtk - tarjetPj.getDefense();
		int finalLife = (tarjetPj.getLife() - mitigateAtk);
		
		if(finalLife < 0) {
			finalLife = 0;
		}
		
		tarjetPj.setLife(finalLife);
		
		dataAtk[0] = finalLife;
		dataAtk[1] = realAtk;
		dataAtk[2] = mitigateAtk;
		
		return dataAtk;
	}

}
