package units;

/**
 * The Assasin class represents a specialized type of Droid with unique attributes and abilities.
 * This droid has the ability to attack its enemy multiple times in a row using its special ability.
 */
public class Assasin extends Droid {

    /**
     * Default constructor that initializes the Assasin droid with predefined attributes.
     */
    public Assasin() {
        name = "Assasin";
        healthPoints = 70;
        atackDamage = 10;
        droidType = "Assasin";
        evationRate = 0;
        armorValue = 10;
        specialAbilityIsUsed = false;
    }

    /**
     * Parametrized constructor that initializes the Assasin droid with custom attributes.
     *
     * @param name          the name of the droid
     * @param health        the health points of the droid
     * @param damage        the attack damage of the droid
     * @param evationRate   the evasion rate of the droid
     * @param armorValue    the armor value of the droid
     */
    public Assasin(String name, int health, int damage, int evationRate, int armorValue) {
        this.name = name;
        this.healthPoints = health;
        this.atackDamage = damage;
        this.droidType = "Assasin";
        this.evationRate = evationRate;
        this.armorValue = armorValue;
        this.specialAbilityIsUsed = false;
    }

    /**
     * Executes the Assasin's special ability, which attacks the enemy droid three times in a row.
     *
     * @param enemyDroid the enemy droid to attack
     */
    @Override
    protected void specialAbility(Droid enemyDroid) {
        specialAbilityIsUsed = true;
        System.out.println(this.getDroidType() + " " + this.getName() + " used special ability");

        // Attacks enemy 3 times in a row
        for (int i = 0; i < 3; i++) {
            this.atackEnemy(enemyDroid, true);
        }
    }
}
