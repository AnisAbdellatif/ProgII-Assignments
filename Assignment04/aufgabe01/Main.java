package aufgabe01;

import java.util.Scanner;

import aufgabe01.HalfAdder;
import aufgabe01.XorGate;

/**
 * The Main class is the entry point of the program.
 * It prompts the user to enter two boolean values, performs addition using a HalfAdder object,
 * and displays the sum and carry values.
 * @author Anis Abdellatif
 * @version 28.04.2024
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie den ersten boolean Wert an: ");
        boolean a = scanner.nextBoolean();
        System.out.print("Geben sie den zweiten boolean Wert an: ");
        boolean b = scanner.nextBoolean();
        // System.out.println(String.format("a: %b, b: %b", a, b));
        scanner.close();

        HalfAdder ha = new HalfAdder();
        boolean[] result = ha.add(a, b);
        boolean s = result[0];
        boolean c = result[1];
        System.out.println(String.format("Die Summe lautet %b, der Übertrag beträgt %b", s, c));

        ha.info();
    }
}
