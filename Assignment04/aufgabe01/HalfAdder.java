package aufgabe01;

import aufgabe01.Gate;
import aufgabe01.AndGate;
import aufgabe01.XorGate;

public class HalfAdder {
    private Gate[] GateArray = { new XorGate(), new AndGate() };
    
    public boolean[] add(boolean a, boolean b) {
        boolean[] result = new boolean[2];
        result[0] = GateArray[0].evaluate(a, b);
        result[1] = GateArray[1].evaluate(a, b);
        return result;
    }

    void info() {
        for (int i = 0; i < GateArray.length; i++) {
            GateArray[i].table();
        }
    }

    public static void main(String[] args) {
        Gate xor = new Gate("+");
        Gate and = new Gate("^");
        xor.table();
        and.table();
    }

}