package de.uni_hannover.task2.auth;

import de.uni_hannover.task2.offerings.Category;
import de.uni_hannover.task2.offerings.Item;

/**
 * Class to represent a User in the Marketplace.
 * @author Anis Abdellatif
 * @version 23.04.2024
 */
public class User {
    /**
     * String to store user's username.
     */
    private String username;

    /**
     * String to store user's password.
     */
    private String password;

    /**
     * Array of items that the user offers.
     */
    private Item[] items;

    /**
     * Maximum number of items a User can have.
     */
    private final int MAX_ITEMS = 10;

    /**
     * Constructor for the User class.
     * @author Anis Abdellatif
     * @param username 
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.items = new Item[MAX_ITEMS];
    }

    /**
     * Gets username of the User.
     * @author Anis Abdellatif
     * @return String containing user's username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets username of the User.
     * @author Anis Abdellatif
     * @param String containing new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password of the User.
     * @author Anis Abdellatif
     * @return String containing user's password.
     */
    public String getPassword() {
        return this.password;
    } 

    /**
     * Sets password of the User.
     * @author Anis Abdellatif
     * @param String containing new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets items possessed by User.
     * @author Anis Abdellatif
     * @return Array containing items offered by User.
     */
    public Item[] getItems() {
        return this.items;
    }

    /**
     * Removes item from the User offers.
     * This will not automatically trim the array, i.e. There will be holes in the array.
     * @author Anis Abdellatif
     * @param item The item to be removed
     * @return boolean true if the item was succsessfully removed, otherwise false.
     */
    public boolean removeItem(Item item) {
        // There will be 'holes' in the array
        
        for (int i = 0; i < this.items.length; i++) {
            if(item == this.items[i]) {
                this.items[i] = null;
                return true;
            }
        }

        return false;
    }

    /**
     * Adds item to the User offers.
     * This will not automatically trim the array, i.e. There will be holes in the array.
     * @author Anis Abdellatif
     * @param item The item to be added
     * @return boolean true if the item was succsessfully added, otherwise false.
     */
    public boolean addItem(Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if(this.items[i] == null) {
                this.items[i] = item;
                return true;
            }
            
        }

        return false;
    }

    // wasnt required but good solution for marketplace str()
    /**
     * Writes username and he's offerings to a string.
     * @author Anis Abdellatif
     * @return String containing user data: username and offerings(items).
     */
    public String str() {
        // password probably shouldnt be printed
        String res = this.username + " offers:\n";

        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                continue;
            }

            res += this.items[i].str();
        }

        return res;
    }
    
    /**
     * Writes username and he's offerings to a string.
     * @author Anis Abdellatif
     * @return String containing user data: username and offerings(items).
     */
    public String filterMarket(Category category) {
        // password probably shouldnt be printed
        String res = this.username + " offers:\n";
        boolean flag = false; // found at least one of this user's items that mmuch category.

        for(int i = 0; i < this.items.length; i++) {
            if(this.items[i] == null || this.items[i].getCategory() != category) {
                continue;
            }
            flag = true;
            res += this.items[i].str();
        }

        return flag ? res : "";
    }
}