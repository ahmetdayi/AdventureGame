
public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player, "Safe House");//I dont want to entered by users
		
	}
	
	public boolean getLoc() {
		player.setHealty(player.getRealHealthy());
		System.out.println();
		System.out.println("You have recovered. Health : " + player.getRealHealthy());
		System.out.println("You are in the safe house now.");
		return true;
	}
}
