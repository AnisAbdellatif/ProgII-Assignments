package endlisher_automat;

import java.util.ArrayList;
import java.util.Scanner;

import endlisher_automat.islands.Pirates_Island;
import endlisher_automat.islands.Treasure_Island;

/**
 * The StateMachine class represents a state machine that navigates through different islands.
 * It allows the user to input actions and moves the current state accordingly until the goal state is reached.
 * 
 * @author Anis Abdellatif
 * @version 15.04.2024
 */
public class StateMachine {
    private State current_state = new Pirates_Island();
    private State goal_state = new Treasure_Island();
    private ArrayList<State> way = new ArrayList<State>();

    /**
     * Prints the way taken by the state machine.
     */
    private void printWay() {
        System.out.println("Your way:");
        for (State state : way) {
            System.out.println(state.str());
        }
    }

    /**
     * The main method of the StateMachine class.
     * It initializes the state machine, takes user input, and transitions the current state accordingly.
     */
    public static void main(String[] args) {
        StateMachine sm = new StateMachine();
        sm.way.add(sm.current_state);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (sm.current_state.str().equals(sm.goal_state.str())) {
                System.out.println("You have reached the treasure island!");
                sm.printWay();
                break;
            }
            
            System.out.println("You are in: " + sm.current_state.str());
            System.out.println(sm.current_state.info());
            System.out.println();

            System.out.print("Enter action: ");
            String action = scanner.nextLine();
            if (action.equals("exit")) {
                break;
            }

            else if (!(action.equals("A") || action.equals("B"))) {
                System.out.println("Invalid action");
                continue;
            }

            sm.current_state = sm.current_state.transition(Action.valueOf(action));
            sm.way.add(sm.current_state);
        }
        scanner.close();
    }
}
