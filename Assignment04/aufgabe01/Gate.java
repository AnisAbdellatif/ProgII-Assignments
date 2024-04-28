package aufgabe01;

/**
 * The Gate class represents a logical gate with a symbol.
 * It provides methods to evaluate the gate's output and generate a truth table.
 * @author Anis Abdellatif
 * @version 28.04.2024
 */
public class Gate {

    private String symbol;

    /**
     * Constructs a Gate object with the specified symbol.
     * 
     * @param symbol the symbol representing the gate
     */
    public Gate(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the symbol representing the gate.
     * 
     * @return the symbol representing the gate
     */
    public String getSymbol() {
        return this.symbol;
    }

    /**
     * Evaluates the gate's output for the given input values.
     * 
     * @param a the first input value
     * @param b the second input value
     * @return the output value of the gate
     */
    public boolean evaluate(boolean a, boolean b) {
        return false;
    }

    /**
     * Generates a truth table for the gate.
     * The truth table displays the input values (A and B) and the corresponding output value (Y).
     */
    public void table() {
        System.out.println("--------------------");
        System.out.println("| A | B | Y = A " + this.symbol + " B |");
        System.out.println("--------------------");
        for (int i = 0; i < 4; i++) {
            boolean a = ((i & 2) >> 1) == 1;
            boolean b = (i & 1) == 1;
            boolean result = evaluate(a, b);
            System.out.println("| " + (a ? 1 : 0) + " | " + (b ? 1 : 0) + " |     " + (result ? 1 : 0) + "     |");
            System.out.println("--------------------");
        }
    }
}
