package CALab;

import mvc.*;
public class RunCommand extends Command {
	public String runNumber;
    public RunCommand(Model model) {
        super(model);
        runNumber = null;
    }

    public void execute() {
    	Grid grid = (Grid)model;
    	// Maybe add else for edge cases?
    	if (runNumber.equals("RUN1")) {
    		grid.updateLoop(1);
    	} else if (runNumber.equals("RUN50")) {
    		grid.updateLoop(50);
    	}
        
    }
}
