import java.util.Random;

public class Obstacle {
	private String name;
	private int damage ,health , maxNumber , award;
	
	public Obstacle(String name, int damage, int health, int maxNumber, int award) {
		super();
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.maxNumber = maxNumber;
		this.award = award;
	}
	
	public int obsCount() {
		Random r = new Random();
		return r.nextInt(this.maxNumber) + 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}
	 
	
}
