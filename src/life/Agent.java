package life;

import java.awt.Color;
import java.util.Iterator;

import CALab.Cell;

public class Agent extends Cell {
	private int state; // dead or alive?
	private int ambience;

	public Agent() {
		state = 0;
		ambience = 0;
	}

	@Override
	public void observe() {
		// Each cell updates ambience
		int sum = 0;
		Iterator<Cell> it = super.neighbors.iterator();
		while (it.hasNext()) {
			sum++;
		}
		ambience += sum;
		// ambience = super.neighbors.size(); // #neighbors with state == 1
		notifySubscribers();
	}

	@Override
	public void update() {
		// Each cell updates status
		if (state == 1) {
			if (ambience < 2 || ambience > 3) // Society.death.contains(ambience)
				state = 0;
		} else {
			if (ambience == 3)
				state = 1;
		}
		notifySubscribers(); //needed?
	}

	@Override
	public int getStatus() {
		return ambience;
	}

	// Unused
	@Override
	public void interact() {

	}

	@Override
	public void nextState() {
		// Maybe ??
		if (state == 0) {
			state = 1;
		} else {
			state = 0;
		}
		notifySubscribers();
	}

	@Override
	public void reset(boolean randomly) {
		// 0 = dead, 1 = alive
		if (randomly) {
			state = (int) (Math.random() * 2);
		} else {
			state = 0;
		}
	}

	@Override
	public Color getColor() {
		// 0 = dead, 1 = alive
		if (this.state == 0) {
			return new Color(255, 0, 0);
		} else {
			return new Color(0, 255, 0);
		}
	}

	@Override
	public int getAmbience() {
		// TODO Auto-generated method stub
		return ambience;
	}

}
