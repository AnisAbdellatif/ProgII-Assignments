package endlisher_automat;

/**
 * The State interface represents a state in the Endlisher Automat.
 * It defines methods for transitioning to a new state based on an action,
 * getting a string representation of the state, and getting additional information about the state.
 * 
 * @author Anis Abdellatif
 * @version 15.04.2024
 */
public interface State {

    /**
     * Transitions to a new state based on the given action.
     *
     * @param action the action to perform
     * @return the new state after the transition
     */
    public State transition(Action action);


    /**
     * Gets a string representation of the state.
     *
     * @return the string representation of the state
     */
    public String str();

    
    /**
     * Gets additional information about the state.
     *
     * @return additional information about the state
     */
    public String info();
}
