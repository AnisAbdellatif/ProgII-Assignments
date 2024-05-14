package endlisher_automat.islands;

import endlisher_automat.Action;
import endlisher_automat.State;

/**
 * Represents the state of being on the Musket Hill in the Endlisher Automat.
 * Implements the State interface.
 * 
 * @author Anis Abdellatif
 * @version 15.04.2024
 */
public class Musket_Hill implements State {

    /**
     * Transitions to the next state based on the given action.
     *
     * @param action the action to perform
     * @return the next state after performing the action
     */
    @Override
    public State transition(Action action) {
        switch (action) {
            case A:
                return new Pirates_Island();
            
            case B:
                return new Mutineers_Island();
            
            default:
                return this;
        }
    }


    /**
     * Returns a string representation of the current state.
     *
     * @return a string representation of the state
     */
    @Override
    public String str() {
        return "Musket Hill";
    }
    
    
    /**
     * Returns additional information about the current state.
     *
     * @return additional information about the state
     */
    @Override
    public String info() {
        return "Action a -> Pirates' Island; Action b -> Mutineers' Island";
    }
}
