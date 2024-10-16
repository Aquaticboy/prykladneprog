package labThree;
import components.BattleSystems;
import units.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Menu {

	public static Droid choseDroidForDuel(ArrayList<ArrayList<Droid>>teams){
		Scanner scanner = new Scanner(System.in);

		System.out.printf("Enter team number to chose the droid: ");
		int enteredMenuCommand2 = Integer.valueOf(scanner.nextLine());
		ArrayList<Droid> firstTeamForDuel = teams.get(enteredMenuCommand2-1);
		System.out.println("Picked team: \n" + firstTeamForDuel);

		System.out.printf("Enter droid number to chose the droid: ");
		enteredMenuCommand2 = Integer.valueOf(scanner.nextLine());
		Droid DroidForDuel = firstTeamForDuel.get(enteredMenuCommand2-1);
		return DroidForDuel;
	}

	public static ArrayList<Droid> choseTeamFroBattle(ArrayList<ArrayList<Droid>>teams){
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Enter team number to chose: ");
		int enteredMenuCommand2 = Integer.valueOf(scanner.nextLine());
		ArrayList<Droid> teamToReturn = teams.get(enteredMenuCommand2-1);
		return teamToReturn;
	}

	public static void main(String[] args) {

		ArrayList<Droid> defaultTeamRed = new ArrayList<>();
		defaultTeamRed.add(new Assasin("r2d2", 100, 10, 0, 0));
		defaultTeamRed.add(new Droid("r32d25", 70, 15, "Droid", 0, 0));
		defaultTeamRed.add(new Droid("rss", 200, 5, "Droid", 0, 0));

		ArrayList<Droid> defaultTeamBlue = new ArrayList<>();
		defaultTeamBlue.add(new Tank("r2111d2", 88, 8, 10));
		defaultTeamBlue.add(new Droid("dds22", 71, 5, "Droid", 0, 0));
		defaultTeamBlue.add(new Droid("2ds25", 210, 6, "Droid", 0, 0));

		ArrayList<ArrayList<Droid>> teams = new ArrayList<>();
		teams.add(defaultTeamRed);
		teams.add(defaultTeamBlue);




		System.out.print("\t\tDroid battle\t\t\n");
		System.out.println("\nTo see all commands type /help");
		System.out.println("To exit the program type /exit");
		String enteredMenuCommand = "";
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.print("Enter command: ");
			enteredMenuCommand = scanner.nextLine();
			switch (enteredMenuCommand){
				case "/exit":
					System.exit(0);
				case "/help":
					System.out.println("\nTo see all commands type /help");
					System.out.println("To see all teams with droids type /teams");
					System.out.println("To begin a duel battle between droids type /duel");
					System.out.println("To begin a team battle between droids type /3v3");
					System.out.println("To create a new team type /createTeam (3 droids)");
					System.out.println("To exit the program type /exit");
					break;
				case "/teams":
					for (int i = 0; i < teams.size(); i++) {
						System.out.println("Team №" + (i+1) + teams.get(i));
					}
					break;
				case "/duel":
					Droid firstDroid = choseDroidForDuel(teams);
					Droid secondDroid = choseDroidForDuel(teams);
					BattleSystems.duelBattle(firstDroid, secondDroid);
					break;
				case "/3v3":
					System.out.println("First chosen team will be set as team Blue, second chosen as team Red");
					ArrayList<Droid> firstTeam = choseTeamFroBattle(teams);
					ArrayList<Droid> secondTeam = choseTeamFroBattle(teams);

					BattleSystems.threevsthree(firstTeam, secondTeam);
					break;
				case "/createTeam":
					ArrayList<Droid> teamToCreate = new ArrayList<>();
					for (int i = 0; i < 3; i++) {
						System.out.println("Please, chose what type your first droid will be created\n" +
								"\tType 1 if: Assasin (Special Ability: 'runs fast behind enemy's back \nand stabs them 3 times')\n" +
								"\tType 2 if: Tank (Special characteristic: has 0% evation rate \nSpecial Ability: 'increases it's outer defence layer \nand becomes twice armored \nbut loses half of atack power')\n" +
								"\tType 3 if: Summoner (Special Ability: summons companion that atacks enemy with half atack power')\n)");
						System.out.print("Enter command: ");
						enteredMenuCommand = scanner.nextLine();
						String droidName;
						int health;
						int damage;
						int rate;
						int armorValue;
						switch (enteredMenuCommand){
							case "1":
								System.out.println("\tCreating new Assasin\n");
								System.out.println("Enter droid's name: ");
								droidName = scanner.nextLine();
								System.out.println("Enter droid's health: ");
								health = Integer.valueOf(scanner.nextLine());
								System.out.println("Enter droid's atack damage: ");
								damage = Integer.valueOf(scanner.nextLine());
								System.out.println("Enter droid's evation rate: ");
								rate = Integer.valueOf(scanner.nextLine());
								System.out.println("Enter droid's armor value: ");
								armorValue = Integer.valueOf(scanner.nextLine());

								teamToCreate.add(new Assasin(droidName, health, damage, rate, armorValue));

								break;
							case "2":
								System.out.println("\tCreating new Tank\n");
								System.out.println("Enter droid's name: ");
								droidName = scanner.nextLine();
								System.out.println("Enter droid's health: ");
								health = Integer.valueOf(scanner.nextLine());
								System.out.println("Enter droid's atack damage: ");
								damage = Integer.valueOf(scanner.nextLine());
								System.out.println("Enter droid's armor value: ");
								armorValue = Integer.valueOf(scanner.nextLine());

								teamToCreate.add(new Tank(droidName, health, damage, armorValue));

								break;
							case "3":
								System.out.println("\tCreating new Summoner\n");
								System.out.println("Enter droid's name: ");
								droidName = scanner.nextLine();
								System.out.println("Enter droid's health: ");
								health = Integer.valueOf(scanner.nextLine());
								System.out.println("Enter droid's atack damage: ");
								damage = Integer.valueOf(scanner.nextLine());
								System.out.println("Enter droid's evation rate: ");
								rate = Integer.valueOf(scanner.nextLine());
								System.out.println("Enter droid's armor value: ");
								armorValue = Integer.valueOf(scanner.nextLine());

								teamToCreate.add(new Summoner(droidName, health, damage, rate, armorValue));

								break;

						}

						
					}
					teams.add(teamToCreate);
					break;

			}
		}while(enteredMenuCommand != "/exit");



	}

}
