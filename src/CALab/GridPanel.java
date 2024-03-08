package CALab;

import mvc.*;
public class GridPanel extends AppPanel {
    public GridPanel(AppFactory factory) {
        super(factory);
        // Add buttons, action listeners, and add to panel
    }

    public static void main(String[] args) {
        // Runnable once all classes are implemented
        AppFactory factory = new GridFactory();
        AppPanel panel = new GridPanel(factory);
        panel.display();
    }
}
