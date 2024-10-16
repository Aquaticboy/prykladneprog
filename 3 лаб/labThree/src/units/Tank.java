package units;

/**
 * The Tank class represents a specialized type of Droid with a focus on defense.
 * Its special ability doubles its armor but decreases its attack damage.
 */
public class Tank extends Droid {

    /**
     * Default constructor that initializes the Tank droid with predefined attributes.
     */
    public Tank() {
        name = "Tank";
        healthPoints = 70;
        atackDamage = 10;
        droidType = "Tank";
        evationRate = 0;
        armorValue = 10;
        specialAbilityIsUsed = false;
    }

    /**
     * Parametrized constructor that initializes the Tank droid with custom attributes.
     *
     * @param name          the name of the droid
     * @param health        the health points of the droid
     * @param damage        the attack damage of the droid
     * @param armorValue    the armor value of the droid
     */
    public Tank(String name, int health, int damage, int armorValue) {
        this.name = name;
        this.healthPoints = health;
        this.atackDamage = damage;
        this.droidType = "Tank";
        this.evationRate = 0;
        this.armorValue = armorValue;
        this.specialAbilityIsUsed = false;
    }

    /**
     * Executes the Tank's special ability, which doubles its armor value but halves its attack damage.
     *
     * @param enemyDroid the enemy droid (not directly affected by this ability, but passed for future use)
     */
    @Override
    protected void specialAbility(Droid enemyDroid) {
        specialAbilityIsUsed = true;
        System.out.println(this.getDroidType() + " " + this.getName() + " used special ability");

        // Doubles the droid's armor
        this.setArmorValue(this.getArmorValue() * 2);

        // Halves the droid's attack damage
        this.setAtackDamage(this.getAtackDamage() / 2);
    }
}
