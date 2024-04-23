package de.uni_hannover.jump_n_run;

import de.uni_hannover.jump_n_run.GameObject;
import de.uni_hannover.jump_n_run.NPC;

/**
 * GameView class represents the game board and handles the game logic.
 * 
 * @author Anis Abdellatif
 * @version 1.0.0
 */
public class GameView {
    /**
     * Game board height
     */
    final int HEIGHT = 3;

    /**
     * Game board width
     */
    final int WIDTH = 20;

    /**
     * 2D-Array of the board matrix. Each cell is of type GameObject.
     */
    GameObject[][] GameObjectArray = new GameObject[HEIGHT][WIDTH];

    /**
     * The npc to play the game.
     */
    final NPC npc = new NPC(0);

    /**
     * Constructor for the GameView class. Fill the GameObjectArray to create the initial game board.
     * @author Anis Abdellatif
     */
    public GameView() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i < HEIGHT - 3) { // Fill all lines prior to the third last line with empty spaces.
                                      // Allows to make the board game bigger in the future.
                    GameObjectArray[i][j++] = GameObject.EMPTY;
                } else if (i == (HEIGHT - 3)) { // Fill the third last line with the following pattern:
                                                // __O_ ( _ = EMPTY)
                    GameObjectArray[i][j++] = GameObject.EMPTY;
                    GameObjectArray[i][j++] = GameObject.EMPTY;
                    GameObjectArray[i][j++] = GameObject.AIROBSTACLE;
                    GameObjectArray[i][j] = GameObject.EMPTY;
                } else if (i == (HEIGHT - 2)) { // The second last line is all empty.
                    GameObjectArray[i][j] = GameObject.EMPTY;
                } else if (i == (HEIGHT - 1)) { // Fill the last line with the following pattern:
                                                // GGGL...
                                                // The first cell where the npc stands is always G.
                                                // The last 3 cells are GGZ.
                    if (j == 0) {
                        GameObjectArray[i][j] = GameObject.GROUND;
                    } else if (j == WIDTH - 3) {
                        GameObjectArray[i][j++] = GameObject.GROUND;
                        GameObjectArray[i][j++] = GameObject.GROUND;
                        GameObjectArray[i][j] = GameObject.GOAL;
                    } else {
                        GameObjectArray[i][j++] = GameObject.GROUND;
                        GameObjectArray[i][j++] = GameObject.GROUND;
                        GameObjectArray[i][j++] = GameObject.GROUND;
                        GameObjectArray[i][j] = GameObject.LAVA;
                    }
                }
            }
        }
    }

    /**
     * Writes the current game board state to a string.
     * 
     * @author Anis Abdellatif
     * @return The board state as a string.
     */
    public String str() {
        String board = "";
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                /*
                 * Two conditions to print the symbol P: - The cell index should match the npc
                 * xCoordinate && - This is the second last line OR it is the third last line
                 * and npc is not crouching
                 */
                if (this.npc.getXCoordinate() == j
                        && ((i == (HEIGHT - 3) && !this.npc.isCrouching()) || i == (HEIGHT - 2))) {
                    board += "P";
                } else { // otherwise print the cell content
                    board += GameObjectArray[i][j].getSymbol();
                }
            }
            board += '\n';
        }
        return board;
    }

    /**
     * Starts the game. Checks for game ending conditions otherwise play by the game
     * rules: - If the NPC is standing on lava or the target, the game is over. - If
     * the NPC is standing in front of an AIROBSTACLE , it should now crawl. - If
     * the NPC is standing in front of a LAVA object on the left, it should stand
     * there - If the NPC on the left is crawling in front of a LAVA object, it
     * should stand up. - Otherwise the NPC runs to the right.
     * 
     * @author Anis Abdellatif
     */
    public void play() {
        while (true) {
            System.out.println("Current state of the game:");
            System.out.print(str());
            System.out.println("###########################");

            if (
                    this.GameObjectArray[HEIGHT - 1][npc.getXCoordinate()] == GameObject.LAVA
                 || this.GameObjectArray[HEIGHT - 1][npc.getXCoordinate()] == GameObject.GOAL
                ) {
                System.out.println("Game ended!");
                break;
            }

            // Make sure the npc didn't reach the board edge (prevent overflow)
            assert (npc.getXCoordinate() + 1) < WIDTH;

            if (
                    this.GameObjectArray[HEIGHT - 3][npc.getXCoordinate() + 1] == GameObject.AIROBSTACLE
                 && !this.npc.isCrouching()
                ) {
                this.npc.crouch();
            } else if (this.GameObjectArray[HEIGHT - 1][npc.getXCoordinate() + 1] == GameObject.LAVA) {
                if (this.npc.isCrouching()) {
                    this.npc.standUp();
                } else {
                    this.npc.dashRight();
                }
            } else {
                this.npc.walkRight();
            }
        }
    }

    /**
     * Main-Method to test the game.
     * Creates new GameView instance and runs .play()
     * @author      Anis Abdellatif
     * @param args  command line arguments (not used)
     */
    public static void main(String[] args) {
        /*
         * Packagestruktur: umgekehrter Domainname
         *  - Einzigartigkeit: Risiko von Namenskonflikten minimieren.
         *  - Wiedererkennung: Entwickler können die Klassen schneller zuordnen.
         *  - Best Practice.
         */
        GameView gameView = new GameView();
        gameView.play();
    }
}