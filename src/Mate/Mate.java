package Mate;

public class Mate {
	protected float production;
	protected float speed;

	public Mate(float production, float speed) {
		this.production = production;
		this.speed = speed;
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

}
