package life;

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

	

}
