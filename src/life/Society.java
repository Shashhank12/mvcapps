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
	
	

}
