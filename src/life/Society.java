package life;

import java.util.*;
import CALab.*;

public class Society extends Grid {
	public static Set<Integer> rebirth = new HashSet<Integer>();
	public static Set<Integer> death = new HashSet<Integer>();
	public static int percentAlive = 50;
	
	/*
	static {
	     rebirth.add(3);
	     death.add(0);
	     death.add(1);
	     death.add(4);
	     death.add(5);
	     death.add(6);
	     death.add(7);
	     death.add(8);
	 } */


	@Override
	public Cell makeCell(boolean uniform) {
		// TODO Auto-generated method stub
		Agent agent = new Agent();
		return agent;
	}
	
	@Override
	public Set<Cell> getNeighbors(Cell asker, int radius) {
		ArrayList<Cell> neighborList = new ArrayList<Cell>(super.getNeighbors(asker, radius));

		for (int i = neighborList.size() - 1; i >= 0 ; i--) {
			if (neighborList.get(i).getStatus() == 0) {
				neighborList.remove(i);
			}
		}
		return new HashSet<Cell>(neighborList);
	}

}
