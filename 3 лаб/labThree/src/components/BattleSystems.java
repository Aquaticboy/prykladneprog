package components;

import units.Droid;
import java.util.ArrayList;

/**
 * The BattleSystems class provides methods to simulate battles between droids, either in a duel or team-based format.
 */
public class BattleSystems {

    /**
     * Simulates a duel battle between two droids. The battle continues until one droid is no longer alive.
     * Droids alternate between attacking and defending. Special abilities can be activated under certain conditions.
     *
     * @param defenderDroid the droid that defends in the initial round
     * @param atackerDroid  the droid that attacks in the initial round
     * @return the droid that won the battle
     */
    public static Droid duelBattle(Droid defenderDroid, Droid atackerDroid) {
        int round = 0;

        do {
            System.out.println("*============ROUND " + ++round + "=============*");
            // Droids switch roles between attacker and defender
            Droid temp = atackerDroid;
            atackerDroid = defenderDroid;
            defenderDroid = temp;

            // Check for special ability activation
            if (!atackerDroid.isSpecialAbilityIsUsed()) {
                if (atackerDroid.checkConditionsForSpecialAbilityUse(round)) {
                    atackerDroid.useSpecialAbility();
                }
            }

            System.out.print(atackerDroid.getName() + " has " + atackerDroid.getHealthPoints() + " health points");
            System.out.println(defenderDroid.getName() + " has " + defenderDroid.getHealthPoints() + " health points");
            int damageDelt = atackerDroid.atackEnemy(defenderDroid, true);

        } while (defenderDroid.isAlive());

        return atackerDroid;
    }

    /**
     * Simulates a 3vs3 battle between two teams of droids. Each droid on Team Blue fights the corresponding droid on Team Red.
     * The team with more victories wins the battle.
     *
     * @param droidTeamBlue an ArrayList of 3 droids representing Team Blue
     * @param droidTeamRed  an ArrayList of 3 droids representing Team Red
     * @return the winning team, either droidTeamBlue or droidTeamRed
     */
    public static ArrayList<Droid> threevsthree(ArrayList<Droid> droidTeamBlue, ArrayList<Droid> droidTeamRed) {
        if (droidTeamBlue.size() != 3 || droidTeamRed.size() != 3) {
            System.out.println("Either droidTeamBlue or droidTeamRed contains more or less than 3 Droids;");
            return null;
        }

        int teamBlueScore = 0;
        int teamRedScore = 0;

        // Loop through each droid and conduct one-on-one battles
        for (int i = 0; i < droidTeamRed.size(); i++) {
            if (droidTeamRed.get(i).equals(droidTeamRed.get(i).atackEnemy(droidTeamBlue.get(i), false))) {
                teamRedScore++;
            } else {
                teamBlueScore++;
            }
        }

        // Determine the winning team based on the score
        if (teamBlueScore > teamRedScore) {
            System.out.println("Team Blue won the 3vs3 battle!");
            return droidTeamBlue;
        } else {
            System.out.println("Team Red won the 3vs3 battle!");
            return droidTeamRed;
        }
    }
}
