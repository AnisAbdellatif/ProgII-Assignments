package aufgabe01;

import aufgabe01.Gate;
import aufgabe01.AndGate;
import aufgabe01.XorGate;

/**
 * The HalfAdder class represents a half adder circuit.
 * It performs addition of two boolean values and returns the sum and carry as a boolean array.
 * @author Anis Abdellatif
 * @version 28.04.2024
 */
public class HalfAdder {
    private Gate[] GateArray = { new XorGate(), new AndGate() };
    
    /**
     * Adds two boolean values and returns the sum and carry as a boolean array.
     * 
     * @param a the first boolean value
     * @param b the second boolean value
     * @return a boolean array containing the sum and carry
     */
    public boolean[] add(boolean a, boolean b) {
        boolean[] result = new boolean[2];
        result[0] = GateArray[0].evaluate(a, b);
        result[1] = GateArray[1].evaluate(a, b);
        return result;
    }

    /**
     * Prints the truth tables of the gates in the GateArray.
     */
    void info() {
        for (Gate gate : GateArray) {
            gate.table();
        }
    }

    /**
     * The main method of the HalfAdder class.
     * It creates instances of the Gate class, prints their truth tables, and demonstrates the HalfAdder functionality.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gate xor = new Gate("+");
        Gate and = new Gate("^");
        xor.table();
        and.table();
    }

}