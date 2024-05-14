package endlisher_automat.islands;

import endlisher_automat.Action;
import endlisher_automat.State;

/**
 * Represents the state of being in Smugglers' Cove in the game.
 * Implements the State interface.
 * 
 * @author Anis Abdellatif
 * @version 15.04.2024
 */
public class Smugglers_Cove implements State {

    /**
     * Transitions to the next state based on the given action.
     * @param action The action to be performed.
     * @return The next state after the transition.
     */
    @Override
    public State transition(Action action) {
        switch (action) {
            case A:
                return new Pirates_Island();
            
            case B:
                return new Treasure_Island();
            
            default:
                return this;
        }
    }


    /**
     * Returns a string representation of the state.
     * @return The string representation of the state.
     */
    @Override
    public String str() {
        return "Smugglers' Cove";
    }
    
    
    /**
     * Returns additional information about the state.
     * @return Additional information about the state.
     */
    @Override
    public String info() {
        return "Action a -> Pirates' Island; Action b -> Treasure Island";
    }
}
