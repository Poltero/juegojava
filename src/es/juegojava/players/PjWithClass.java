/**
 * 
 */
package es.juegojava.players;

import es.juegojava.common.ClassType;
import es.juegojava.common.Raza;
import es.juegojava.mapa.ItemArma;

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
	ItemArma currentWeapon;
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nombre + " [" + classPj + "] ("+ raza +"), Vida: "+ life;
	}

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
	
	
	/**
	 * @return the currentWeapon
	 */
	public ItemArma getCurrentWeapon() {
		return currentWeapon;
	}

	/**
	 * @param initiative the currentWeapon to set
	 */
	public void setCurrentWeapon(ItemArma currentWeapon) {
		this.currentWeapon = currentWeapon;
	}

	
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
	
	public void attack(Player tarjetPj){
		
		int realAtk = this.attack + this.currentWeapon.getAtack();
		int finalLife = (tarjetPj.getLife() - (realAtk - tarjetPj.getDefense()));
		
		tarjetPj.setLife(finalLife);
	}

}
