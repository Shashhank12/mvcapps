package minimac;

import javax.swing.*;

import java.awt.*;
import tools.*;

public class MiniMacView extends JPanel implements Subscriber {
    private MiniMac mac;
    private JList<Integer> memory;
    private JList<String> instruction;
    
    public MiniMacView(MiniMac mac) {
        this.mac = mac;
        mac.subscribe(this);
        setLayout(new GridLayout(2, 1));
        
        memory = new JList<Integer>();
        JScrollPane memoryScroll = new JScrollPane(memory);

        instruction = new JList<>();
        JScrollPane instructionScroll = new JScrollPane(instruction);
        
        add(memoryScroll);
        add(instructionScroll);
        setVisible(true);
        
        memory.setCellRenderer(new MemoryCellRenderer());
        memory.setListData(mac.memory);
        memory.setVisible(true);
        memory.setFont(new Font("Courier", Font.BOLD, 12)); 
    }
    
    public void update() { 
        instruction.setListData(mac.programStr.split("\n"));
        repaint();
    }
    
    public void setMiniMac(MiniMac newMac) {
        mac.unsubscribe(this);
        mac = newMac;
        mac.subscribe(this);
        memory.setListData(mac.memory);
        instruction.setListData(mac.programStr.split("\n"));
        repaint();
    }
}



class MemoryCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (value instanceof Integer) {
            setText("memory[" + index + "] = " + value);
        }
        
        return c;
    }
}
