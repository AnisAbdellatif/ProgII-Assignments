package de.uni_hannover.task2;

import de.uni_hannover.task2.auth.*;
import de.uni_hannover.task2.offerings.*;

/**
 * This class represents a digital marketplace.
 * 
 * Items are offered on this marketplace by user,
 * which can be added to this marketplace.
 * 
 * @author Kevin Schumann
 * @version 03/05/2023
 */
public class Marketplace {
    // users of this marketplace
    private User[] users;

    /**
     * Constructs a marketplace object with 
     * maximum 10 users.
     * 
     * @author Kevin Schumann
     */
    public Marketplace() {
        this.users = new User[10];
    }

    /**
     * Returns a string representation of the marketplace
     * 
     * @author Kevin Schumann
     * @return String representation of the item.
     */
    public String str() {
        String res = "";
        
        for(int i = 0; i < this.users.length; i++) {
            if(this.users[i] == null) {
                continue;
            }
            
            res += this.users[i].str();
            res += "\n\n";
        }

        return res;
    }

    /**
     * Removes an user with all offered items from the 
     * marketplace.
     * 
     * @author Kevin Schumann
     * @param user User that shall be removed
     * @return False if user could not be found, else true.
     */
    public boolean removeUser(User user) {
        for (int i = 0; i < this.users.length; i++) {
            if(user == this.users[i]) {
                this.users[i] = null;
                return true;
            }
        }

        return false;
    }

    /**
     * Adds an user to the marketplace.
     * 
     * @author Kevin Schumann
     * @param user User that shall be added.
     * @return False if user limit has been reached, else true.
     */
    public boolean addUser(User user) {
        for (int i = 0; i < this.users.length; i++) {
            if(this.users[i] == null) {
                this.users[i] = user;
                return true;
            }
            
        }

        return false;
    }

    /**
     * Returns string of all items that belong to as the given category.
     * Iff category is null all items will be printed like
     * in the str() function.
     * 
     * @author Kevin Schumann
     * @param category Category that shall be printed. Can be null. If null all items will be printed.
     * @return String of all the items that belong to the given category.
     */
    public String filterMarket(Category category) {
        if(category == null) {
            return this.str();
        }

        String res = "";
        for (int i = 0; i < users.length; i++) {
            if(this.users[i] == null) {
                continue;
            }

            Item[] items = this.users[i].getItems();
            for (int j = 0; j < items.length; j++) {
                if (items[j] == null) {
                    continue;
                }

                if (category.isSameCategory(items[j])) {
                    res += items[j].str();
                }
            }

            res += "\n";
        }

        return res;
    }
    
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
            Category.CLOTHES
        );

        Item two = new Item(
            "Hut",
            100,
            second,
            "Toller Hut. Keine Anfragen, wie 'was letzter Preis'.",
            Category.CLOTHES
        );

        first.addItem(one);
        second.addItem(two);
        
        market.addUser(first);
        market.addUser(second);

        System.out.println(market.filterMarket(Category.CLOTHES));
        System.out.println(market.filterMarket(Category.ELECTRONICS));
        System.out.println(market.filterMarket(null));
    }
}

