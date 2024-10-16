package units;

/**
 * The Summoner class represents a type of Droid with the ability to summon a pet that assists in battle.
 * The summoned pet attacks alongside the Summoner but with reduced damage.
 */
public class Summoner extends Droid {

    /**
     * Indicates whether the Summoner's pet has been summoned.
     */
    private boolean petSummoned = false;

    /**
     * Default constructor that initializes the Summoner droid with predefined attributes.
     */
    public Summoner() {
        name = "Tank";
        healthPoints = 70;
        atackDamage = 10;
        droidType = "Tank";
        evationRate = 0;
        armorValue = 10;
        specialAbilityIsUsed = false;
        petSummoned = false;
    }

    /**
     * Parametrized constructor that initializes the Summoner droid with custom attributes.
     *
     * @param name          the name of the droid
     * @param health        the health points of the droid
     * @param damage        the attack damage of the droid
     * @param evationRate   the evasion rate of the droid
     * @param armorValue    the armor value of the droid
     */
    public Summoner(String name, int health, int damage, int evationRate, int armorValue) {
        this.name = name;
        this.healthPoints = health;
        this.atackDamage = damage;
        this.droidType = "Tank";
        this.evationRate = evationRate;
        this.armorValue = armorValue;
        this.specialAbilityIsUsed = false;
        this.petSummoned = false;
    }

    /**
     * Sets whether the Summoner's pet has been summoned.
     *
     * @param petSummoned true if the pet is summoned, false otherwise
     */
    public void setPetSummoned(boolean petSummoned) {
        this.petSummoned = petSummoned;
    }

    /**
     * Executes the Summoner's special ability, summoning a pet that assists in attacks.
     * The pet attacks with half of the Summoner's damage until the end of the battle.
     */

    protected void specialAbility() {
        specialAbilityIsUsed = true;
        System.out.println(this.getDroidType() + " " + this.getName() + " used special ability");

        // Summons a pet that attacks each round with half the Summoner's damage
        this.setPetSummoned(true);
    }

    /**
     * Attacks the enemy droid and applies damage. If a pet has been summoned, it also attacks for half damage.
     *
     * @param enemyDroid  the enemy droid to attack
     * @param outputLogs  whether to output logs for the attack
     * @return the total damage dealt to the enemy droid
     */
    @Override
    public int atackEnemy(Droid enemyDroid, boolean outputLogs) {

        // Regular damage
        int damageGiven = rand.nextInt(this.getAtackDamage());

        // Calculate critical hit chance and apply critical damage
        if (rand.nextInt(1, 100) <= enemyDroid.getEvationRate()) {
            damageGiven *= 2;
            damageGiven = Droid.calculateDamageAffectedByArmor(damageGiven, enemyDroid.getArmorValue());
            if (outputLogs) {
                System.out.println("Droid " + this.getName() + " deals crit damage " + damageGiven + " to the enemy: " + enemyDroid.getName());
            }
        } else if (outputLogs) {
            damageGiven = Droid.calculateDamageAffectedByArmor(damageGiven, enemyDroid.getArmorValue());
            System.out.println("Droid " + this.getName() + " deals " + damageGiven + " damage to the droid: " + enemyDroid.getName());
        }

        // Apply damage to enemy
        enemyDroid.setHealthPoints(enemyDroid.getHealthPoints() - damageGiven);

        // If pet is summoned, pet also attacks with half damage
        if (this.petSummoned) {
            enemyDroid.setHealthPoints(enemyDroid.getHealthPoints() - damageGiven / 2);
        }

        return damageGiven;
    }
}
