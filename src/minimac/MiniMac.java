package minimac;

import tools.*;

import java.io.File;
import java.io.Serializable;
import java.util.Scanner;
import java.util.List;

public class MiniMac extends Publisher implements Serializable {
    int ip = 0;
    boolean halt = false;
    int size = 32;
    Integer[] memory = new Integer[size];
    String programStr = "";
    
    List<Instruction> program;
    
    public MiniMac() {
        clear();
    }
    
    public void parse(String fileName) {
        ip = 0;
        halt = false;
        programStr = "";
        try {
            File file = new File(fileName + ".txt");
            Scanner scnr = new Scanner(file);
            while (scnr.hasNextLine())
                programStr += scnr.nextLine() + "\n";
        } catch (Exception ex) {
            halt = true;
            Utilities.error(ex);
        }
        
        try {
            if (!halt)
                this.program = MiniMacParser.parse(programStr);
        } catch (Exception ex) {
            Utilities.error(ex);
        }
        notifySubscribers();
    }
    
    public void execute() {
        while (ip < program.size() && !halt) {
            Instruction next = program.get(ip++);
            next.execute(this);
        }
        notifySubscribers();
    }

    public void clear() {
        for (int i = 0; i < size; ++i) {
            memory[i] = 0;
        }
        notifySubscribers();
    }

}
