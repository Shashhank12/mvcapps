package life;

import java.awt.Color;

import CALab.*;

public class Agent extends Cell {
	private int status;
	private int ambience;
	
	public Agent() {
		status = 0;
		ambience = 8;
		notifySubscribers();
	}

	@Override
	public void observe() {
		// Each cell updates ambience
		ambience = super.neighbors.size();
		notifySubscribers();
	}

	@Override
	public void update() {
		// Each cell updates status
		if (status == 1) {
			if (ambience < 2 || ambience > 3)
				status = 0;
		} else {
			if (ambience == 3)
				status = 1;
		}
		notifySubscribers();
	}

	@Override
	public int getStatus() {
		return status;
	}
	
	// Unused
	@Override
	public void interact() {

	}

	@Override
	public void nextState() {
		// Maybe ??
		if (status == 0) {
			status = 1;
		} else {
			status = 0;
		}
		notifySubscribers();
	}

	@Override
	public void reset(boolean randomly) {
		// 0 = dead, 1 = alive
		if (randomly) {
			status = (int) (Math.random() * 2);
		} else {
			status = 0;
		}
	}

	@Override
	public Color getColor() {
		// 0 = dead, 1 = alive
		if (status == 0) {
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
