package life;

import CALab.*;
import mvc.*;

public class SocietyFactory extends GridFactory {
	@Override
	public Model makeModel() { return new Society(); }
	
	@Override
	public View makeView(Model m) {
		return new SocietyView((Society)m);
	}
	
	@Override
	public String getTitle() {	return "Life Lab"; }
}
