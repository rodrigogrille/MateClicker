package Mate;

import javax.swing.JLabel;

public class Mate {
	protected float production;
	static float initialProduction = (float) 0.01;
	protected float speed;
	protected String name;
	protected boolean upgrade = false;
	int upgrades = 0;
	float price = 2;

	public Mate(float production, float speed, String name) {
		this.production = production;
		this.speed = speed;
		this.name = name;
	}

	public float getProduction() {
		return production;
	}

	public void setProduction(float production) {
		this.production = production;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void upgrade(float upgrade) {
		production = (float) (upgrade * 1.5);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUpgrade(boolean upgrade) {
		this.upgrade = upgrade;
	}

	public boolean isUpgrade() {
		return upgrade;
	}

	public static float getInitialProduction() {
		return initialProduction;
	}

	public static void setInitialProduction(float initialProduction) {
		Mate.initialProduction = initialProduction;
	}

	public int getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(int upgrades) {
		this.upgrades = upgrades;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void upgrade(Mate mate, JLabel label) {
		if (mate.isUpgrade() == true) {
			upgrades++;
		}
		mate.setProduction(initialProduction);
		for (int x = 0; x < upgrades; x++) {
			mate.setProduction(mate.getProduction() * 1.5f);
		}
		label.setText("It will cost you " + Float.toString(mate.getPrice()) + " $");
	}
}
