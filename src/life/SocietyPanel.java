package life;

import CALab.*;
import mvc.*;

public class SocietyPanel extends GridPanel {
	
	public SocietyPanel(AppFactory factory) { super(factory); }
	
	public static void main(String[] args) {
		// Runnable once all classes are implemented
		AppFactory factory = new SocietyFactory();
		AppPanel panel = new SocietyPanel(factory);
		panel.display();
	}
}
