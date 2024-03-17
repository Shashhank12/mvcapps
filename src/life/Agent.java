package life;

import java.awt.Color;

import CALab.*;

public class Agent extends Cell {
	private int status;
	private int ambience;
	
	public Agent() {
		status = 0;
		ambience = 8;
	}

	@Override
	public void observe() {
		// Each cell updates ambience
		
	}

	@Override
	public void update() {
		// Each cell updates status
		
	}
	
	// Unused
	@Override
	public void interact() {	}

	@Override
	public void nextState() {	}

	@Override
	public void reset(boolean randomly) {	}

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
