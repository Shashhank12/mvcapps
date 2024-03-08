package CALab;

import mvc.*;
public class GridFactory implements AppFactory {
    @Override
    public Model makeModel() {
        // Implement this method
        return null;
    }

    @Override
    public View makeView(Model model) {
        // Implement this method
        return null;
    }

    @Override
    public String getTitle() {
        // Implement this method
        return null;
    }

    @Override
    public String[] getHelp() {
        // Implement this method
        return new String[0];
    }

    @Override
    public String about() {
        // Implement this method
        return null;
    }

    @Override
    public String[] getEditCommands() {
        // Implement this method
        return new String[0];
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        // Implement this method
        return null;
    }
}
