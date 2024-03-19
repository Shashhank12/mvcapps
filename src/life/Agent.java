package life;

import java.awt.Color;
import java.util.Iterator;

import CALab.Cell;

public class Agent extends Cell {
	private int state; // dead or alive?
	private int ambience;

	public Agent() {
		this(true);
	}

	public Agent(boolean dead) {
		if (dead) {
			state = 0;
		} else {
			state = 1;
		}
		ambience = 0;
	}

	@Override
	public void observe() {
		// Each cell updates ambience
		int sum = 0;
		Iterator<Cell> it = super.neighbors.iterator();
		while (it.hasNext()) {
			Cell c = it.next();
			if (c.getStatus() == 1)
				sum++;
		}
        ambience = sum;
	}

	@Override
	public void update() {
		// Each cell updates status
		if (state == 1) {
			if (Society.death.contains(ambience)) // Society.death.contains(ambience)
				state = 0;
		} else {
			if (Society.rebirth.contains(ambience)) // Society.rebirth.contains(ambience)
				state = 1;
		}
	}

	@Override
	public int getStatus() {
		return state;
	}

	// Unused
	@Override
	public void interact() {}

	@Override
	public void nextState() {
		// Maybe ??
		if (state == 0) {
			state = 1;
		} else {
			state = 0;
		}
	}

	@Override
	public void reset(boolean randomly) {
		// 0 = dead, 1 = alive
		if (randomly) {
			state = (int) (Math.random() * 2);
		} else {
			state = 0;
			ambience = 0;
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
		return ambience;
	}

}
