package de.uni_hannover.task2;

import java.util.Scanner;

public class CustomScanner {
    public Scanner rawScanner;

    public CustomScanner() {
        this.rawScanner = new Scanner(System.in);
    }
    
    public String nextLine() {
        return this.rawScanner.nextLine();
    }

    public int nextInt() {
        int value = this.rawScanner.nextInt();
        this.rawScanner.nextLine(); // Consume the newline character
        return value;
    }

    public float nextFloat() {
        float value = this.rawScanner.nextFloat();
        this.rawScanner.nextLine(); // Consume the newline character
        return value;
    }

    public void close() {
        this.rawScanner.close();
    }
}