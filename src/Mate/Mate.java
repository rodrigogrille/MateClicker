package Mate;

public class Mate {
	protected float production;
	protected float speed;
	protected String name;

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

}
