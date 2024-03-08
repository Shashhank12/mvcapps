package CALab;

import mvc.*;
public class GridPanel extends AppPanel {
    public GridPanel(AppFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        AppFactory factory = new GridFactory();
        AppPanel panel = new GridPanel(factory);
        panel.display();
    }
}
