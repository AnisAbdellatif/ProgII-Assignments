package endlisher_automat.islands;

import endlisher_automat.Action;
import endlisher_automat.State;

/**
 * Represents the state of being on the Shipwreck Bay in the Endlisher Automat.
 * Implements the State interface.
 * 
 * @author Anis Abdellatif
 * @version 15.04.2024
 */
public class Shipwreck_Bay implements State {

    /**
     * Transitions to the next state based on the given action.
     * @param action The action to perform.
     * @return The next state after the transition.
     */
    @Override
    public State transition(Action action) {
        switch (action) {
            case A:
                return new Musket_Hill();
            
            case B:
                return new Dead_Mans_Island();
        
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
        return "Shipwreck Bay";
    }
    
    
    /**
     * Returns additional information about the state.
     * @return Additional information about the state.
     */
    @Override
    public String info() {
        return "Action a -> Musket Hill; Action b -> Dead Man's Island";
    }
}
