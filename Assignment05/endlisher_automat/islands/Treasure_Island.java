package endlisher_automat.islands;

import endlisher_automat.Action;
import endlisher_automat.State;

/**
 * Represents the state of being on the Treasure Island in the Endlisher Automat.
 * Implements the State interface.
 * 
 * @author Anis Abdellatif
 * @version 15.04.2024
 */
public class Treasure_Island implements State {

    /**
     * Transitions to the next state based on the given action.
     *
     * @param action The action to perform.
     * @return The next state after performing the action.
     */
    @Override
    public State transition(Action action) {
        switch (action) {
            case A:
                return new Musket_Hill();

            case B:
                return new Shipwreck_Bay();

            default:
                return this;
        }
    }
    

    /**
     * Returns a string representation of the state.
     *
     * @return The string representation of the state.
     */
    @Override
    public String str() {
        return "Treasure Island";
    }

    
    /**
     * Returns additional information about the state and available actions.
     *
     * @return The additional information about the state.
     */
    @Override
    public String info() {
        return "Action a -> Treasure Island; Action b -> Treasure Island";
    }
}
