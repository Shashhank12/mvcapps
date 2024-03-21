package life;

import CALab.*;
import mvc.*;

public class LifePanel extends GridPanel {
	
	public LifePanel(AppFactory factory) { super(factory); }
	
	public static void main(String[] args) {
		// Runnable once all classes are implemented
		AppFactory factory = new LifeFactory(); // changed GridFactory to AppFactory
		AppPanel panel = new LifePanel(factory); // changed GridPanel to AppPa el
		panel.display();
	}
}