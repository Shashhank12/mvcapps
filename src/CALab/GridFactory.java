package CALab;

import mvc.*;
public abstract class GridFactory implements AppFactory {
    @Override
    public abstract Model makeModel();

    @Override
    public abstract View makeView(Model model);

    @Override
    public String getTitle() {
        return "CA Lab";
    }

    @Override
    public String[] getHelp() {
        // Implement this method
        return new String[] {"Click a cell to toggle its state.",
                "Click Run1 to advance the simulation by 1 step.",
                "Click Run50 to advance the simulation by 50 steps.",
                "Click Populate to randomly populate the grid.",
                "Click Clear to clear the grid."};
    }

    @Override
    public String about() {
        // Implement this method
        return "CA Lab";
    }

    @Override
    public String[] getEditCommands() {
        // Implement this method
        return new String[] {"RUN1", "RUN50", "POPULATE", "CLEAR"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        Command cmmd = null;
        if (type.equals("RUN1")) {
            cmmd = new RunCommand(model);
            ((RunCommand)cmmd).runNumber = type;
        }
        else if (type.equals("RUN50")) {
            cmmd = new RunCommand(model);
            ((RunCommand)cmmd).runNumber = type;
        }
        else if (type.equals("POPULATE")) {
            cmmd = new PopulateCommand(model);
        }
        else if (type.equals("CLEAR")) {
            cmmd = new ClearCommand(model);
        }
        return cmmd;
    }
}
