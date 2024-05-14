package endlisher_automat.islands;

import endlisher_automat.Action;
import endlisher_automat.State;

/**
 * Represents the state of being on the Mutineers' Island in the Endlisher Automat.
 * Implements the State interface.
 * 
 * @author Anis Abdellatif
 * @version 15.04.2024
 */
public class Mutineers_Island implements State {

    /**
     * Transitions to the next state based on the given action.
     *
     * @param action The action to perform.
     * @return The next state after the transition.
     */
    @Override
    public State transition(Action action) {
        switch (action) {
            case A:
                return new Smugglers_Cove();

            case B:
                return new Dead_Mans_Island();

            default:
                return this;
        }
    }
    

    /**
     * Returns a string representation of the Mutineers Island state.
     *
     * @return The string representation of the state.
     */
    @Override
    public String str() {
        return "Mutineers Island";
    }
    
    
    /**
     * Returns additional information about the Mutineers Island state.
     *
     * @return The additional information about the state.
     */
    @Override
    public String info() {
        return "Action a -> Smugglers' Cove; Action b -> Dead Mans's Island";
    }
}
