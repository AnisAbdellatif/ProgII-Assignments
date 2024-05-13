package de.uni_hannover.task2.auth;


import java.util.*;
import de.uni_hannover.task2.offerings.Item;

/**
 * Represents a user in a marketplace setting.
 * 
 * Represents a user in a marketplace settings.
 * Users are able to offer items on the marketplace
 * A user is associated with a username and password.
 * 
 * @author Kevin Schumann
 * @version 03/05/2023
 */
public class User {
    private String username;
    private String password;
    private List<Item> items;

    /**
     * Constructs an user object with a given username
     * and password. User created with this method can
     * offer up to 10 items at a time.
     * 
     * @author Kevin Schumann
     * @param username Username of the user
     * @param password Password of the user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.items = new ArrayList<Item>();
    }

    /**
     * Returns the username.
     * 
     * @author Kevin Schumann
     * @return Username of the user
     */
	public String getUsername() {
		return this.username;
	}
    
    /**
     * Sets the username.
     * 
     * @author Kevin Schumann
     * @param username New username of the user
     */
	public void setUsername(String username) {
		this.username = username;
	}

    /**
     * Returns the password of the user
     * 
     * @author Kevin Schumann
     * @return String: Password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns the items offered by the user.
     * 
     * @author Kevin Schumann
     * @return Items that the user is offering
     */
	public List<Item> getItems() {
		return this.items;
	}

    /**
     * Removes an item from the offered items.
     * 
     * @author Kevin Schumann
     * @param item Item that shall be removed
     * @return False if the item was not found, true otherwise.
     */
    public boolean removeItem(Item item) {
        return this.items.remove(item);
    }
    
    /**
     * Adds an item from the offered items.
     * 
     * @author Kevin Schumann
     * @param item Item that shall be added
     * @return False if item could not be added, true otherwise.
     */
    public boolean addItem(Item item) {
        boolean test = this.items.add(item);
        return test;
    }

    /**
     * Returns a string representation of the object.
     * 
     * @author Kevin Schumann
     * @return String representation of the object.
     */
    public String str() {
        if(this.items.size() == 0) {
            return "";
        }
        
        // Password sollte vielleicht nicht ausgegeben werden.
        String res = this.username + " offers:\n";
        for(int i = 0; i < this.items.size(); i++) {
            res += this.items.get(i).str();
        }
        res += "\n";

        return res;
    }
}