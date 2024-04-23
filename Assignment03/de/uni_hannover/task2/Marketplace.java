package de.uni_hannover.task2;

import de.uni_hannover.task2.auth.*;
import de.uni_hannover.task2.offerings.*;

/**
 * Class to represent a Marketplace, where users can buy and sell items.
 * @author Anis Abdellatif
 * @version 23.04.2024
 */
public class Marketplace {
    /**
     * Users array to store users.
     */
    private User[] users;

    /**
     * Maximum number of users.
     */
    private final int MAX_USERS = 10;

    /**
     * Constructor for Marketplace.
     * Initiates the empty users array.
     * @author Anis Abdellatif
     */
    public Marketplace() {
        this.users = new User[MAX_USERS];
    }

    /**
     * Writes all users offerings alog with their usernames to a String.
     * @author Anis Abdellatif
     * @return String containing Marketplace data: each username along with the offered items.
     */
    public String str() {
        String res = "";

        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] == null) {
                continue;
            }

            res += this.users[i].str();
            res += "\n\n";
        }

        return res;
    }
    
    /**
     * Writes all users offerings alog with their usernames to a String.
     * @author Anis Abdellatif
     * @return String containing Marketplace data: each username along with the offered items.
     */
    public String filterMarket(Category category) {
        String res = "";

        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] == null) {
                continue;
            }

            res += this.users[i].filterMarket(category);
            res += "\n\n";
        }

        return res;
    }

    /**
     * Adds user to Marketplace.
     * @author Anis Abdellatif
     * @param user The user to be added.
     * @return boolean true if the user was successfully added, otherwise false.
     */
    public boolean addUser(User user) {
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] == null) {
                this.users[i] = user;
                return true;
            }

        }

        return false;
    }
    
    /**
     * Removes user from Marketplace.
     * @author Anis Abdellatif
     * @param  user The user to be removed.
     * @return boolean true if the user was successfully removed, otherwise false.
     */
    public boolean removeUser(User user) {
        for (int i = 0; i < this.users.length; i++) {
            if(this.users[i] == user) {
                this.users[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Main-Method to demonstrate the functionality of the Marketplace class.
     * @author Anis Abdellatif
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Main Methode darf auch in Main-Klasse sein.
        Marketplace market = new Marketplace();

        User first = new User("Max", "1234");
        User second = new User("Maxine", "4321");

        Item one = new Item(
            "Sandalen",
            10,
            first,
            "Neue Sandalen schwarz. Festpreis!",
            Category.OTHER
        );

        Item two = new Item(
            "Hut",
            100,
            second,
            "Toller Hut. Keine Anfragen, wie 'was letzter Preis'.",
            Category.OTHER
        );

        first.addItem(one);
        second.addItem(two);
        
        market.addUser(first);
        market.addUser(second);
        market.removeUser(second);

        System.out.println(market.str());

        one.setPrice(50, first);

        System.out.println(market.str());
        
    }
}

