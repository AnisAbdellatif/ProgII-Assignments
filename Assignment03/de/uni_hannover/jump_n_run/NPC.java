package de.uni_hannover.jump_n_run;

/**
 * This class represents a Non-Player Character (NPC) in a jump and run game.
 * @author Anis Abdellatif
 * @version 23.04.2024
 */
public class NPC {
    /**
     * x-coordinate of the NPC
     */
    private int xCoordinate;

    /**
     * bool for status of npc (crouching/standing)
     */
    private boolean isCrouching;

    /**
     * Constructor for the NPC class.
     * @author Anis Abdellatif
     * @param xCoordinate The initial x-coordinate of the NPC.
     */
    public NPC(int xCoordinate) {
        this.xCoordinate = xCoordinate;
        this.isCrouching = false;
    }

    /**
     * Gets the x-coordinate of the NPC.
     * @author Anis Abdellatif
     * @return The current x-coordinate of the NPC.
     */
    public int getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     * Sets the x-coordinate of the NPC.
     * @author             Anis Abdellatif
     * @param xCoordinate  The new x-coordinate of the NPC.
     */
    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Checks if the NPC is crouching.
     * @author Anis Abdellatif
     * @return true if the NPC is crouching, false otherwise.
     */
    public boolean isCrouching() {
        return this.isCrouching;
    }

    /**
     * Sets the crouching state of the NPC.
     * @author             Anis Abdellatif
     * @param isCrouching  The new crouching state of the NPC.
     */
    public void setCrouching(boolean isCrouching) {
        this.isCrouching = isCrouching;
    }

    /**
     * Makes the NPC stand up by setting its crouching state to false.
     * @author Anis Abdellatif
     */
    public void standUp() {
        setCrouching(false);
    }

    /**
     * Makes the NPC crouch by setting its crouching state to true.
     * @author Anis Abdellatif
     */
    public void crouch() {
        setCrouching(true);
    }

    /**
     * Moves the NPC one unit to the right by increasing its x-coordinate by 1.
     * @author Anis Abdellatif
     */
    public void walkRight() {
        setXCoordinate(getXCoordinate() + 1);
    }

    /**
     * Makes the NPC dash to the right by increasing its x-coordinate by 2, if it's not crouching.
     * If the npc is crouching do nothing. 
     * @author Anis Abdellatif
     */
    public void dashRight() {
        if (isCrouching()) {
            return;
        }
        setXCoordinate(getXCoordinate() + 2);
    }
}