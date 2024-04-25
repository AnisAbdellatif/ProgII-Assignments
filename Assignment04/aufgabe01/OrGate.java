package aufgabe01;

import aufgabe01.Gate;

public class OrGate extends Gate {
    OrGate() {
        super("+");
    }
    
    @Override
    public boolean evaluate(boolean a, boolean b) {
        return a | b;
    }
}
