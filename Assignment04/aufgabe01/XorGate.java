package aufgabe01;

import aufgabe01.Gate;
import aufgabe01.AndGate;
import aufgabe01.OrGate;
import aufgabe01.NotGate;

/**
 * Represents an XOR gate, which is a type of logic gate.
 * It extends the abstract class Gate.
 * @author Anis Abdellatif
 * @version 28.04.2024
 */
public class XorGate extends Gate {
    private AndGate and;
    private OrGate or;
    private NotGate not;

    /**
     * Constructs a new XorGate object.
     * Initializes the AndGate, OrGate, and NotGate objects.
     */
    XorGate() {
        super("^");
        this.and = new AndGate();
        this.or = new OrGate();
        this.not = new NotGate();
    }

    /**
     * Evaluates the XOR gate based on the input values.
     * @param a the first input value
     * @param b the second input value
     * @return the output value of the XOR gate
     */
    @Override
    public boolean evaluate(boolean a, boolean b) {
        return this.or.evaluate(this.and.evaluate(a, this.not.evaluate(b)), this.and.evaluate(b, this.not.evaluate(a)));
    }
}
