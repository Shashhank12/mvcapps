package minimac;

class Halt implements Instruction {
    public void execute(MiniMac mac) {
        mac.halt = true;
    }
}
