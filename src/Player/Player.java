package Player;

import java.util.ArrayList;

import javax.swing.JLabel;

import Mate.Mate;
public class Player {
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

}
