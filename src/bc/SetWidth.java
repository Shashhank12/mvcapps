package bc;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class SetWidth extends Command {
    public Double newValue;

    public SetWidth(Model brick) {
        super(brick);
        newValue = null;
    }

    @Override
    public void execute() throws Exception {
        Brick brick = (Brick)model;
        if (newValue == null) {
            String resp = Utilities.ask("New Value?");
            newValue = Double.parseDouble(resp);
        }
        brick.setWidth(newValue);
    }
}
