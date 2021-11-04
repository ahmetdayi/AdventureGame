import java.util.Scanner;

public class Game {

	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {

		System.out.println("Welcome the Adventure game !");
		System.out.print("Before starting the game, enter the name : ");
		// String playerName = scan.nextLine();
		player = new Player("a");
		player.selectChar();
		start();
	}

	public void start() {
		int selLoc;
		while (true) {

			System.out.println("=======================================================================");
			System.out.println("Please select a place to go");
			System.out.println("1-Safe House --> 'No Enemy' ");
			System.out.println("2-Cave       --> 'Be careful ,there may be zombies here !!'");
			System.out.println("3-Forest     --> 'Be careful ,there may be vampires here !!'");
			System.out.println("4-River      --> 'Be careful ,there may be bears here !!'");
			System.out.println("5-Shop       --> 'If you have enough money,buy items'");
			System.out.print("You choose place to go : ");
			selLoc = scan.nextInt();
			if (selLoc >= 1 && selLoc <= 5) {
				switch (selLoc) {
				case 1:
					location = new SafeHouse(player);
					break;
				case 2:
					location = new Cave(player);
					break;
				case 3:
					location = new Forest(player);
					break;
				case 4: 
					location = new River(player);
					break;
				case 5:
					location = new ToolStore(player);
					break;
				default:
					location = new SafeHouse(player);
					break;

				}
				
				if(location.getClass().getName().equalsIgnoreCase("SafeHouse")) {
					if(player.getInven().isFirewood() && player.getInven().isFood() && player.getInven().isWater()) {
						System.out.println("Congratulations. You won the game :D");
						break;
					}
				}
				if (!location.getLoc()) {
					System.out.println("Game Over !!");
					break;
				}

			} else
				System.out.println("Please select current number !");

		}
	}
}
