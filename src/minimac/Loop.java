package minimac;

class Loop implements Instruction {
    Instruction body;
    int count;
    public Loop(Instruction body, int count) {
        this.body = body;
        this.count = count;
    }

    public void execute(MiniMac mac) {
        for (int i = 0; i < count; i++) {
            body.execute(mac);
        }
    }
}

