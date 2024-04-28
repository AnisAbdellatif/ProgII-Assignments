package aufgabe01;

import aufgabe01.Gate;

/**
 * Represents an AND gate that extends the Gate class.
 * @author Anis Abdellatif
 * @version 28.04.2024
 */
public class AndGate extends Gate {
    /**
     * Constructs a new AndGate object.
     * Sets the symbol of the gate to "." using the superclass constructor.
     */
    public AndGate() {
        super(".");
    }

    /**
     * Evaluates the AND gate operation on two boolean inputs.
     * @param a the first input value
     * @param b the second input value
     * @return the result of the AND operation on the inputs
     */
    @Override
    public boolean evaluate(boolean a, boolean b) {
        return a & b;
    }
}