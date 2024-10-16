package units;
import java.util.Objects;
import java.util.Random;

/**
 * The Droid class represents a combat droid with various attributes like health, attack damage,
 * evasion rate, and armor. It also includes methods for attacking enemies and using special abilities.
 */
public class Droid {
	protected String name;
	protected int healthPoints;
	protected int atackDamage;
	protected String droidType;
	protected int evationRate;
	protected int armorValue;
	protected boolean specialAbilityIsUsed = false;

	static Random rand = new Random();

	/**
	 * Default constructor that initializes a droid with default values.
	 */
	public Droid() {
		this.name = "Nameless droid";
		this.healthPoints = 100;
		this.atackDamage = 10;
		this.droidType = "Droid";
		this.evationRate = 0;
		this.armorValue = 0;
	}

	/**
	 * Parametrized constructor that initializes a droid with specified values.
	 *
	 * @param name          the name of the droid
	 * @param healthPoints  the health points of the droid
	 * @param atackDamage   the attack damage of the droid
	 * @param droidType     the type of the droid
	 * @param evationRate   the evasion rate of the droid
	 * @param armorValue    the armor value of the droid
	 */
	public Droid(String name, int healthPoints, int atackDamage, String droidType, int evationRate, int armorValue) {
		this.name = name;
		this.healthPoints = healthPoints;
		this.atackDamage = atackDamage;
		this.droidType = droidType;
		this.evationRate = evationRate;
		this.armorValue = armorValue;
	}

	/**
	 * @return the name of the droid
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the droid.
	 *
	 * @param name the new name of the droid
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the health points of the droid
	 */
	public int getHealthPoints() {
		return healthPoints;
	}

	/**
	 * Sets the health points of the droid.
	 *
	 * @param healthPoints the new health points of the droid
	 */
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	/**
	 * @return the attack damage of the droid
	 */
	public int getAtackDamage() {
		return atackDamage;
	}

	/**
	 * Sets the attack damage of the droid.
	 *
	 * @param atackDamage the new attack damage of the droid
	 */
	public void setAtackDamage(int atackDamage) {
		this.atackDamage = atackDamage;
	}

	/**
	 * @return the type of the droid
	 */
	public String getDroidType() {
		return droidType;
	}

	/**
	 * Sets the type of the droid.
	 *
	 * @param droidType the new type of the droid
	 */
	public void setDroidType(String droidType) {
		this.droidType = droidType;
	}

	/**
	 * @return the evasion rate of the droid
	 */
	public int getEvationRate() {
		return evationRate;
	}

	/**
	 * Sets the evasion rate of the droid.
	 *
	 * @param evationRate the new evasion rate of the droid
	 */
	public void setEvationRate(int evationRate) {
		this.evationRate = evationRate;
	}

	/**
	 * @return the armor value of the droid
	 */
	public int getArmorValue() {
		return armorValue;
	}

	/**
	 * Sets the armor value of the droid.
	 *
	 * @param armorValue the new armor value of the droid
	 */
	public void setArmorValue(int armorValue) {
		this.armorValue = armorValue;
	}

	/**
	 * @return the random object used for attack calculations
	 */
	public static Random getRand() {
		return rand;
	}

	/**
	 * Sets the random object for attack calculations.
	 *
	 * @param rand the new random object
	 */
	public static void setRand(Random rand) {
		Droid.rand = rand;
	}

	/**
	 * @return true if the droid's special ability has been used
	 */
	public boolean isSpecialAbilityIsUsed() {
		return this.specialAbilityIsUsed;
	}

	/**
	 * Checks if the conditions for using the special ability are met, based on the current round.
	 *
	 * @param round the current round
	 * @return true if the special ability can be used, false otherwise
	 */
	public boolean checkConditionsForSpecialAbilityUse(int round){
		if (round == 10 || round == 11){ return true; }
		return false;
	}

	/**
	 * Sets whether the droid's special ability has been used.
	 *
	 * @param specialAbilityIsUsed the new special ability usage state
	 */
	public void setSpecialAbilityIsUsed(boolean specialAbilityIsUsed) {
		this.specialAbilityIsUsed = specialAbilityIsUsed;
	}

	/**
	 * Returns a string representation of the droid's attributes.
	 *
	 * @return a string containing the droid's attributes
	 */
	@Override
	public String toString() {
		return "Droid{" +
				"name='" + name + '\'' +
				", healthPoints=" + healthPoints +
				", atackDamage=" + atackDamage +
				", droidType=" + droidType +
				", evationRate=" + evationRate +
				", armorValue=" + armorValue +
				'}';
	}

	/**
	 * Checks if two droids are equal based on their attributes.
	 *
	 * @param o the object to compare to
	 * @return true if the droids are equal, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Droid droid = (Droid) o;
		return healthPoints == droid.healthPoints && atackDamage == droid.atackDamage && evationRate == droid.evationRate && armorValue == droid.armorValue && Objects.equals(name, droid.name) && Objects.equals(droidType, droid.droidType);
	}

	/**
	 * Generates a hash code for the droid based on its attributes.
	 *
	 * @return the hash code of the droid
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name, healthPoints, atackDamage, droidType, evationRate, armorValue);
	}

	/**
	 * Calculates the damage affected by the enemy droid's armor value.
	 *
	 * @param damageGiven the initial damage
	 * @param enemyDroidArmorValue the armor value of the enemy droid
	 * @return the final damage after armor reduction
	 */
	protected static int calculateDamageAffectedByArmor(int damageGiven, int enemyDroidArmorValue) {
		if (enemyDroidArmorValue != 0) {
			// Calculate the effective damage after applying armor reduction.
			double damageMultiplier = 1 - (enemyDroidArmorValue / 100.0);
			return (int) Math.round(damageGiven * damageMultiplier);
		} else {
			return damageGiven;
		}
	}

	/**
	 * Executes a special ability on an enemy droid. To be overridden in subclasses.
	 *
	 * @param enemyDroid the enemy droid
	 */
	protected void specialAbility(Droid enemyDroid){ }

	/**
	 * Sets the special ability as used.
	 */
	public void useSpecialAbility(){ this.specialAbilityIsUsed = true; }

	/**
	 * Attacks an enemy droid and calculates the damage based on the attack damage, critical hit, and armor.
	 *
	 * @param enemyDroid the enemy droid to attack
	 * @param outputLogs whether to output log messages about the attack
	 * @return the amount of damage dealt to the enemy droid
	 */
	public int atackEnemy(Droid enemyDroid, boolean outputLogs) {

		// regular damage
		int damageGiven = rand.nextInt(this.getAtackDamage());

		// calculates crit damage and chance
		// crit chance
		if (rand.nextInt(1, 100) <= enemyDroid.getEvationRate()) {
			// crit damage
			damageGiven *= 2;
			damageGiven = Droid.calculateDamageAffectedByArmor(damageGiven, enemyDroid.getArmorValue());
			// log output
			if (outputLogs) {
				System.out.println("Droid " + this.getName() +" deals crit damage "+ damageGiven +" to the enemy: "+enemyDroid.getName());
			}
		} else if (outputLogs) {
			damageGiven = Droid.calculateDamageAffectedByArmor(damageGiven, enemyDroid.getArmorValue());
			System.out.println("Droid " + this.getName() + " deals " + damageGiven + " damage to the droid: " + enemyDroid.getName());
		}
		enemyDroid.setHealthPoints( enemyDroid.getHealthPoints() - damageGiven);
		return damageGiven;
	}

	/**
	 * Checks if the droid is still alive based on its health points.
	 *
	 * @return true if the droid is alive, false otherwise
	 */
	public boolean isAlive(){ return this.getHealthPoints() > 0; }
}
