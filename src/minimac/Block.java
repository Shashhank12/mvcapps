package minimac;

import java.util.List;

class Block implements Instruction {
    List<Instruction> body;
    public Block(List<Instruction> body) {
        this.body = body;
    }

    public void execute(MiniMac mac) {
        for (Instruction instruction : body) {
            instruction.execute(mac);
        }
    }
}

