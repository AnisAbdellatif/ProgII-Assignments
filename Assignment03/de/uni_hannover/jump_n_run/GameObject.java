package de.uni_hannover.jump_n_run;

/**
 * Enum representing different types of game objects.
 * Each game object has a unique symbol associated with it.
 * @author Anis Abdellatif
 * @version 23.04.2024
 */
public enum GameObject {

    /**
     * Represents a ground game object.
     */
    GROUND('G'),

    /**
     * Represents a lava game object.
     */
    LAVA('L'),

    /**
     * Represents an air obstacle game object.
     */
    AIROBSTACLE('O'),

    /**
     * Represents an empty space game object.
     */
    EMPTY(' '),

    /**
     * Represents a goal game object.
     */
    GOAL('Z');

    /**
     * The symbol associated with each game object
     */
    private final char symbol;

    /**
     * Constructs a game object with the specified symbol.
     * @author        Anis Abdellatif
     * @param symbol  The symbol associated with the game object.
     */
    private GameObject(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the symbol associated with the game object.
     * @author Anis Abdellatif
     * @return The symbol associated with the game object.
     */
    public char getSymbol() {
        return this.symbol;
    }
}