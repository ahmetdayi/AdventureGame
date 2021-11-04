import java.util.Scanner;

public class Player {
	private int damage, healty, money , realHealthy;
	private String name, cName;
	private Inventory inven;

	Scanner scan = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
		this.inven = new Inventory();
	}

	public void selectChar() {
		switch (charMenu()) {

		case 1:
			initChar("Samurai", 5, 21, 15);
			break;
		case 2:
			initChar("Archer", 7, 18, 20);
			break;
		case 3:

			initChar("Knights", 8, 24, 5);
			break;
		default:
			initChar("Samurai", 5, 21, 15);
			break;

		}
		System.out.println("Character : " + getcName() + "\t Damage : " + getDamage() + "\t Health : " + getHealty()
				+ "\t Money : " + getMoney());
	}

	public void initChar(String name , int dam , int heal , int mon) {
		setcName(name);
		setDamage(dam);
		setHealty(heal);
		setMoney(mon);
		setRealHealthy(heal);
	}

	public int charMenu() {
		int charId;
		System.out.println();
		while (true) {
			System.out.println("Please select one of character : ");
			System.out.println("1- Samurai\t Damage : 5\t Health : 21\t Money : 15 ");
			System.out.println("2- Archer\t Damage : 7\t Health : 18\t Money : 20 ");
			System.out.println("3- Knights\t Damage : 8\t Health : 24\t Money : 5 ");
			System.out.print("Choose :");
			charId = scan.nextInt();
			if (charId >= 1 && charId <= 3) {
				break;
			} else
				System.out.println();
			System.out.println("Please enter the current character !");

		}
		return charId;
	}
	
	public int getTotalDamage() {
		return (this.getDamage() +this.getInven().getDamage());
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealty() {
		return healty;
	}

	public void setHealty(int healty) {
		this.healty = healty;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInven() {
		return inven;
	}

	public void setInven(Inventory inven) {
		this.inven = inven;
	}

	public int getRealHealthy() {
		return realHealthy;
	}

	public void setRealHealthy(int realHealthy) {
		this.realHealthy = realHealthy;
	}
}
