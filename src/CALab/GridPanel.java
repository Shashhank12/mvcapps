package CALab;

import mvc.*;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends AppPanel {
    private JButton runOne;
    private JButton runFifty;
    private JButton populate;
    private JButton clear;
    public GridPanel(AppFactory factory) {
        super(factory);
        runOne = new JButton("RUN1");
        runFifty = new JButton("RUN50");
        populate = new JButton("POPULATE");
        clear = new JButton("CLEAR");
        JButton[] buttons = {runOne, runFifty, populate, clear};
        controlPanel.setLayout(new GridLayout(2, 2));

        JPanel p;
        for (JButton b : buttons) {
            b.addActionListener(this);
            p = new JPanel();
            p.add(b);
            controlPanel.add(p);
        }
    }

    public static void main(String[] args) {}
}
