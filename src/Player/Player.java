package Player;

import java.util.ArrayList;

import javax.swing.JLabel;

import Mate.Mate;
public class Player {
	float dollar = 0;
	ArrayList<Mate> mate;
	ArrayList<JLabel> label;

	public Player() {
		mate = new ArrayList<Mate>();
	}

	public ArrayList<Mate> getMate() {
		return mate;
	}

	public void setMate(ArrayList<Mate> mate) {
		this.mate = mate;
	}

	public void addMate(Mate mate) {
		this.mate.add(mate);
	}

	public float getDollar() {
		return dollar;
	}

	public void setDollar(float dollar) {
		this.dollar = dollar;
	}

}
