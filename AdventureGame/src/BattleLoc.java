
public abstract class BattleLoc extends Location {
	protected Obstacle obs;
	protected String award;

	BattleLoc(Player player, String name, Obstacle obs , String award) {//constructordaký degerler alt sýnýflara ýnýyor extend ettýgýmmýz ýcýn
		super(player);
		this.obs = obs;
		this.name = name;
		this.award = award;
	}

	public boolean getLoc() {
		int obsCount = obs.obsCount();
		System.out.println("Now you here : " + this.getName());
		System.out.println("Be careful. there is " + obsCount + " " + obs.getName() + " here");
		System.out.print("<B>attle or <R>un");
		String selCase = scan.nextLine();

		if (selCase.equalsIgnoreCase("b")) {
			if (combat(obsCount)) {
				if(!equals()) {
					
					System.out.println("Congratulations. You won the battle in" + this.getName());

					if(this.award.equalsIgnoreCase("water") && player.getInven().isWater() == false) {
						System.out.println(this.award + " add the inventory.");
						player.getInven().setWater(true);
					}
					if(this.award.equalsIgnoreCase("firewood") && player.getInven().isFirewood() == false) {
						System.out.println(this.award + " add the inventory.");
						player.getInven().setFirewood(true);
					}
					if(this.award.equalsIgnoreCase("food") && player.getInven().isFood() == false) {
						System.out.println(this.award + " add the inventory.");
						player.getInven().setFood(true);
					}
					return true;
				}
				else {
					System.out.println("Succesful escape.");
					return true;
				}
			} else {
				System.out.println("Died !");
			return false;}
		}
		

		return true;
	}
	public boolean equals() {
		if(player.getHealty() == player.getRealHealthy())
		return true;
		else
		return false;
		
	}
	
	

	public boolean combat(int obsCount) {
		int defaultObsHealth = obs.getHealth();
		for (int i = 0; i < obsCount; i++) {

			playerStats();
			enemyStats();
		
			while (player.getHealty() > 0 && obs.getHealth() > 0) {
				System.out.print("<H>it or <R>un");
				String selCase = scan.nextLine();

				if (selCase.equalsIgnoreCase("h")) {
					afterHits();

				}				
				
				else {
					break;}
			}
			
			if (obs.getHealth() <= 0 && player.getHealty() > 0) {	

				System.out.println("Congratulations. You died the enemy !!");

				player.setMoney(obs.getAward() + player.getMoney());

				System.out.println("Money : " + player.getMoney());

				obs.setHealth(defaultObsHealth);

			}else if(equals()) {
				return true;
			}
			
			else {
				
				return false;
			}
			System.out.println("-----------------------------------");

		}
		

		
		return true;
	}

	public void afterHits() {
		System.out.println();
		System.out.println("You hit the enemy !");
		obs.setHealth(obs.getHealth() - player.getTotalDamage());
		System.out.println("Enemy Health : " + obs.getHealth());
		System.out.println("Player health : " + player.getHealty());
		System.out.println("------------------------------------------");

		if (obs.getHealth() > 0) {
			System.out.println("Enemy hits you !!");
			if (player.getInven().getArmor() <= obs.getDamage()) {
				player.setHealty(player.getHealty() - (obs.getDamage() - player.getInven().getArmor()));

			} else {
				player.getInven().setArmor((player.getInven().getArmor() - obs.getDamage()));
			}
			System.out.println("Enemy Health : " + obs.getHealth());
			System.out.println("Player health : " + player.getHealty());
		}
	}

	public void playerStats() {

		System.out.println("\nPlayer States :\n------------------------- ");
		System.out.println("Health : " + player.getHealty());
		System.out.println("Damage : " + player.getTotalDamage());
		System.out.println("Armor  : " + player.getInven().getArmor());
		System.out.println("Money  : " + player.getMoney());
		if (player.getDamage() > 0) {
			System.out.println("Weapon : " + player.getInven().getwName());
		}
		if (player.getInven().getArmor() > 0) {
			System.out.println("Armor : " + player.getInven().getaName());
		}

	}

	public void enemyStats() {
		System.out.println("\n" + obs.getName() + " States :\n------------------------- ");
		System.out.println("Health  : " + obs.getHealth());
		System.out.println("Damage  : " + obs.getDamage());
		System.out.println("Award   : " + obs.getAward());

	}

}
