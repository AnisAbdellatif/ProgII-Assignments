package aufgabe01;

import aufgabe01.Gate;

/**
 * The NotGate class represents a logical NOT gate.
 * It extends the Gate class and implements the evaluate method.
 * @author Anis Abdellatif
 * @version 28.04.2024
 */
public class NotGate extends Gate {
    /**
     * Constructs a NotGate object.
     * It calls the superclass constructor with the symbol "-" to represent the NOT gate.
     */
    public NotGate() {
        super("-");
    }

    /**
     * Evaluates the NOT gate with the given input.
     * It negates the value of the input and returns the result.
     * 
     * @param a the input value
     * @param b not used in this implementation
     * @return the result of the NOT gate evaluation
     */
    @Override
    public boolean evaluate(boolean a, boolean b) {
        return !a;
    }

    /**
     * Evaluates the NOT gate with the given input.
     * It negates the value of the input and returns the result.
     * 
     * @param a the input value
     * @return the result of the NOT gate evaluation
     */
    public boolean evaluate(boolean a) {
        return !a;
    }
}
