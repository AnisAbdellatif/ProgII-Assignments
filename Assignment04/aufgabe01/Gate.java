package aufgabe01;

public class Gate {

    private String symbol;

    public Gate(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public boolean evaluate(boolean a, boolean b) {
        return false;
    }

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
