package aufgabe01;

import aufgabe01.Gate;
import aufgabe01.AndGate;
import aufgabe01.OrGate;
import aufgabe01.NotGate;

public class XorGate extends Gate {
    private AndGate and;
    private OrGate or;
    private NotGate not;

    XorGate() {
        super("^");
        this.and = new AndGate();
        this.or = new OrGate();
        this.not = new NotGate();
    }

    @Override
    public boolean evaluate(boolean a, boolean b) {
        return this.or.evaluate(this.and.evaluate(a, this.not.evaluate(b)), this.and.evaluate(b, this.not.evaluate(a)));
    }
}
