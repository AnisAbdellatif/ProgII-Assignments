package de.uni_hannover.task2.auth;
import de.uni_hannover.task2.offerings.Item;

public class User {
    private String username;
    private String password;
    private Item[] items;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.items = null;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Item[] getItems() {
        return this.items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public boolean addItem(Item item) {
        if (this.items == null) {       // if there is no items list
            this.items = new Item[1];   // define list of 1 item
            this.items[0] = item;
            return true;
        } else {
            Item[] newItems = new Item[this.items.length + 1]; // make new list with new_length = old_length + 1
            for (int i = 0; i < this.items.length; i++) {      // copy old items
                newItems[i] = this.items[i];
            }
            newItems[this.items.length] = item;
            this.items = newItems;
            return true;
        }
    }

    public boolean removeItem(Item item) {
        if (this.items == null) { // check if list exists
            return false;
        } else {
            for (int i = 0; i < this.items.length; i++) {
                if (this.items[i].equals(item)) {
                    Item[] newItems = new Item[this.items.length - 1]; // make a new list with new_length = old_length - 1
                    for (int j = 0; j < i; j++) {                      // copy items prior to the one removed
                        newItems[j] = this.items[j];
                    }
                    for (int j = i + 1; j < this.items.length; j++) {  // copy items after the one removed
                        newItems[j - 1] = this.items[j];
                    }
                    this.items = newItems;
                    return true;
                }
            }
            return false; // the item was not found
        }
    }
}