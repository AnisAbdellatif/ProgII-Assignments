package de.uni_hannover.task2;

import java.util.Scanner;

/**
 * The CustomScanner class provides custom methods for reading input from the standard input stream.
 * @author Anis Abdellatif
 * @version 28.04.2024
 */
public class CustomScanner {
    public Scanner rawScanner;

    /**
     * Constructs a new CustomScanner object.
     * Initializes the rawScanner with the standard input stream.
     */
    public CustomScanner() {
        this.rawScanner = new Scanner(System.in);
    }
    
    /**
     * Reads the next line of input from the standard input stream.
     * 
     * @return the next line of input as a String
     */
    public String nextLine() {
        return this.rawScanner.nextLine();
    }

    /**
     * Reads the next integer value from the standard input stream.
     * 
     * @return the next integer value
     */
    public int nextInt() {
        int value = this.rawScanner.nextInt();
        this.rawScanner.nextLine(); // Consume the newline character
        return value;
    }

    /**
     * Reads the next float value from the standard input stream.
     * 
     * @return the next float value
     */
    public float nextFloat() {
        float value = this.rawScanner.nextFloat();
        this.rawScanner.nextLine(); // Consume the newline character
        return value;
    }

    /**
     * Closes the underlying Scanner object.
     */
    public void close() {
        this.rawScanner.close();
    }
}