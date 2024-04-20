package de.uni_hannover.task2;

import de.uni_hannover.task2.auth.User;
import de.uni_hannover.task2.offerings.Item;

public class Marketplace {
    private User[] users = new User[10];

    public boolean addUser(User user) {
        // Assume that there are no empty spots (-1)
        int emptySpot = -1;
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] == null) { // if there is an empty spot
                emptySpot = i;           // save empty spot index
            } else if (this.users[i] != null && this.users[i].getUsername().equals(user.getUsername())) { // user already exist
                return false;
            }
        }
        if (emptySpot == -1) { // if there are no empty spots i.e. list is full
            return false;
        }
        this.users[emptySpot] = user;
        return true;
    }

    public String str() {
        String result = "";
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] != null && this.users[i].getItems() != null) {
                User user = this.users[i];
                for (int j = 0; j < user.getItems().length; j++) {
                    Item item = this.users[i].getItems()[j];
                    result += String.format("[Item: %s; Preis: %.2f; Verkäufer: %s; Beschreibung: %s]\n",
                                                        item.getName(),
                                                        item.getPrice(),
                                                        item.getSeller().getUsername(),
                                                        item.getDescription());
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Create a new marketplace
        Marketplace marketplace = new Marketplace();
        // Create a new user
        User user = new User("userA", "password");
        // Create a new item
        Item item = new Item("item", 1.0, user, "description");
        // Add the item to the user
        user.addItem(item);
        // Add the user to the marketplace
        marketplace.addUser(user);
        // Print the marketplace
        System.out.println(marketplace.str());
    }
}
