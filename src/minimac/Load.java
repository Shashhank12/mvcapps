package minimac;

class Load implements Instruction {
    int loc;
    int val;
    
    public Load(int loc, int val) {
        this.loc = loc;
        this.val = val;
    }

    public void execute(MiniMac mac) {
        mac.memory[loc] = val;
    }
}