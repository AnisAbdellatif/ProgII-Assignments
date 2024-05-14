package endlisher_automat;

/**
 * The Action enum represents the possible actions in the Endlisher Automat.
 * It contains two actions: A and B.
 * 
 * @author Anis Abdellatif
 * @version 14.05.2024
 */
public enum Action {
    A, B;

    /**
     * Returns the first character of the action as a char.
     *
     * @return the first character of the action
     */
    public char str() {
        return this.toString().charAt(0);
    }
}