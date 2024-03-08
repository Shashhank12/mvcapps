package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;

public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {

    protected AppFactory factory;
    protected Model model;
    protected View view;
    protected ControlPanel controlPanel;
    private JFrame frame;
    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 300;
    public AppPanel(AppFactory factory) {
        this.factory = factory;
        this.model = factory.makeModel();
        this.view = factory.makeView(model);
        this.controlPanel = new ControlPanel();
        this.add(controlPanel);
        setLayout(new GridLayout(1, 2));
        this.add(view);
        if (model != null)
            model.addPropertyChangeListener(this);

        frame = new JFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(createMenuBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(factory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public void display() {
        frame.setVisible(true);
    }
    
    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        // add file, edit, and help menus
        JMenu fileMenu = Utilities.makeMenu("File", new String[] {"New",  "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);

        JMenu editMenu =
                Utilities.makeMenu("Edit", factory.getEditCommands(), this);
        result.add(editMenu);

        JMenu helpMenu =
                Utilities.makeMenu("Help", new String[] {"About", "Help"}, this);
        result.add(helpMenu);

        return result;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
        view.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String cmmd = ae.getActionCommand();

        if (cmmd.equals("Save")) {
            Utilities.save(model, false);
        } else if (cmmd.equals("SaveAs")) {
            Utilities.save(model, true);
        } else if (cmmd.equals("Open")) {
            Model newModel = Utilities.open(model);
            if (newModel != null) setModel(newModel);
        } else if (cmmd.equals("New")) {
            Utilities.saveChanges(model);
            setModel(factory.makeModel());
            model.setUnsavedChanges(false);
        } else if (cmmd.equals("Quit")) {
            Utilities.saveChanges(model);
            System.exit(1);
        } else if (cmmd.equals("About")) {
            Utilities.inform(factory.about());
        } else if (cmmd.equals("Help")) {
            Utilities.inform(factory.getHelp());
        } else {
            Command command = factory.makeEditCommand(model, cmmd, ae.getSource());
            try {
                command.execute();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    protected class ControlPanel extends JPanel {
        public ControlPanel() {}
    }
}