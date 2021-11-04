import java.util.Scanner;

public class ToolStore extends NormalLoc {

	ToolStore(Player player) {
		super(player, "Store");

	}

	public boolean getLoc() {
		int selTools;
		System.out.println("Money : " + player.getMoney());
		System.out.println("1- Weapons");
		System.out.println("2- Armors");
		System.out.println("3- Exit");
		System.out.print("Your choose : ");
		selTools = scan.nextInt();
		int sellItemID;
		switch (selTools) {
		case 1: {

			sellItemID = weaponMenu();
			buyWeapon(sellItemID);

		}
		case 2:
			sellItemID = armorMenu();
			buyArmor(sellItemID);
			break;
		default:

		}
		return true;
	}
	
	public int armorMenu() {
		int selArm;
		System.out.println("1- Light\t Avoid : 1\t Money : 15 ");
		System.out.println("2- Middle\t Avoid : 3\t Money : 25");
		System.out.println("3- Heavy\t Avoid : 5\t Money : 40");
		System.out.println("4- Exit");
		System.out.print("Your choose : ");
		selArm = scan.nextInt();
		return selArm;	
		}
	public void buyArmor(int sellAR) {
			
		int avoid = 0, price = 0;
		String aName = null;

		switch (sellAR) {
		case 1:
			avoid = 1;
			price = 15;
			aName = "Light";
			break;
		case 2:
			avoid = 3;
			price = 25;
			aName = "Middle";
			break;
		case 3:
			avoid = 5;
			price = 40;
			aName = "Heavy";
			break;
		case 4:
			System.out.println("Exit was made ");
			break;
		default:
			System.out.println("Invalid request.");
			break;
		}
		if (price > 0) {

			if (player.getMoney() >= price) {
				player.getInven().setArmor(avoid);
				player.getInven().setaName(aName);
				player.setMoney(player.getMoney() - price);
				System.out
						.println("You bought that is called " + aName + " armor. Avoid : " + player.getInven().getArmor());
				System.out.println("The rest of money : " + player.getMoney());
			} else {
				System.out.println("Dont enough money !");
			}
		
	}}
	
	
	public int weaponMenu() {
		int selWeap;
		System.out.println("1- Pistol\t Damage : 2\t Money : 25 ");
		System.out.println("2- Sword\t Damage : 3\t Money : 35");
		System.out.println("3- Rifle\t Damage : 7\t Money : 45");
		System.out.println("4- Exit");
		System.out.print("Your choose : ");
		selWeap = scan.nextInt();
		return selWeap;
	}

	public void buyWeapon(int sellItemID) {
		int damage = 0, price = 0;
		String wName = null;

		switch (sellItemID) {
		case 1:
			damage = 2;
			price = 25;
			wName = "Pistol";
			break;
		case 2:
			damage = 3;
			price = 35;
			wName = "Sword";
			break;
		case 3:
			damage = 7;
			price = 45;
			wName = "Rifle";
			break;
		case 4:
			System.out.println("Exit was made ");
			break;
		default:
			System.out.println("Invalid request.");
			break;
		}
		if (price >= 0) {

			if (player.getMoney() > price) {
				player.getInven().setDamage(damage);
				player.getInven().setwName(wName);
				player.setMoney(player.getMoney() - price);
				System.out
						.println("You bought that is called " + wName + " weapon. Before damage : " + player.getDamage()
								+ " ,After damage : " + player.getTotalDamage());
				System.out.println("The rest of money : " + player.getMoney());
			} else {
				System.out.println("Dont enough money !");
			}
		}

	}

}
