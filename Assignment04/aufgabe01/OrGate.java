package aufgabe01;

import aufgabe01.Gate;

/**
 * The OrGate class represents a logical OR gate.
 * It extends the Gate class and implements the evaluate method.
 * @author Anis Abdellatif
 * @version 28.04.2024
 */
public class OrGate extends Gate {
    /**
     * Constructs a new OrGate object with the symbol "+".
     * Calls the superclass constructor with the symbol parameter.
     */
    OrGate() {
        super("+");
    }
    
    /**
     * Evaluates the logical OR operation between two boolean values.
     * 
     * @param a the first boolean value
     * @param b the second boolean value
     * @return the result of the logical OR operation between a and b
     */
    @Override
    public boolean evaluate(boolean a, boolean b) {
        return a | b;
    }
}
