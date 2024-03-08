package minimac;

import tools.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppPanel extends JPanel implements ActionListener {
    private MiniMac mac;
    private MiniMacView view;
    private ControlPanel controls;

    public AppPanel() {
        mac = new MiniMac();
        view = new MiniMacView(mac);
        controls = new ControlPanel();
        this.setLayout(new GridLayout(1, 2));
        this.add(controls);
        this.add(view);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("MiniMac");
        frame.setSize(1920, 1080);
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"Parse", "Run", "Clear"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"Help"}, this);
        result.add(helpMenu);
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
                case "Parse":
                    String input = JOptionPane.showInputDialog("Enter program file name");
                    mac.parse(input);
                    break;
                case "Run":
                    mac.execute();
                    break;
                case "Clear":
                    mac.clear();
                    break;
                case "Save": {
                    String fName = Utilities.getFileName((String) null, false);
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.mac);
                    os.close();
                    break;
                }
                case "Open": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        String fName = Utilities.getFileName((String) null, true);
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                        mac = (MiniMac) is.readObject();
                        view.setMiniMac(mac);;
                        is.close();
                    }

                    break;
                }
                case "New":
                    mac = new MiniMac();
                    view.setMiniMac(mac);
                    break;
                case "Quit": {
                    System.exit(0);
                    break;
                }
                case "Help": {
                    String[] cmmds = new String[]{
                            "Parse: Parse the assembly program file",
                            "Run: Run the parsed program",
                            "Clear: Reset all memory locations to zero"
                    };
                    Utilities.inform(cmmds);
                    break;

                }
                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }
        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }


    class ControlPanel extends JPanel {
        public ControlPanel() {
            JPanel p = new JPanel();
            p.setBackground(new Color(255, 240, 240));
            p.setLayout(new GridLayout(3, 1, 0, 300));
            
            JButton parse = new JButton("Parse");
            parse.addActionListener(AppPanel.this);
            p.add(parse);
            
            JButton run = new JButton("Run");
            run.addActionListener(AppPanel.this);
            p.add(run);
            
            JButton clear = new JButton("Clear");
            clear.addActionListener(AppPanel.this);
            p.add(clear);
            
            add(p);
            setBackground(new Color(255, 240, 240));
        }
    }
    
    public static void main(String[] args) {
        AppPanel app = new AppPanel();
    }
    
}