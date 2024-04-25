package aufgabe01;

import aufgabe01.Gate;

public class NotGate extends Gate {
    public NotGate() {
        super("-");
    }

    @Override
    public boolean evaluate(boolean a, boolean b) {
        return !a;
    }

    public boolean evaluate(boolean a) {
        return !a;
    }
}
