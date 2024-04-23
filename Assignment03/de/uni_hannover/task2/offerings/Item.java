package de.uni_hannover.task2.offerings;

import de.uni_hannover.task2.auth.User;
import de.uni_hannover.task2.offerings.Category;

/**
 * Class for an item available for sale in the marketplace.
 * @author Anis Abdellatif
 * @version 23.04.2024
 */
public class Item {
    /* 
    Items sollten generell nur durch den Owner
    änderbar sein. Kann allerdings auch erst später
    durch die business logik realisiert werden
    
    Price darf nicht unter 0 liegen.
    */
    
    /**
     * String that contains item name.
     */
    private String name;

    /**
     * float that contains item price (should be > 0).
     */
    private float price;

    /**
     * Refrence to the item owner.
     */
    private User owner;

    /**
     * String that contains item description.
     */
    String description;

    /**
     * Category of the item.
     */
    Category category;

    /**
     * Constructor for Item class.
     * Sets all properties accordingly.
     * @author            Anis Abdellatif
     * @param name        name of the item
     * @param price       price of the item
     * @param owner       owner of the item
     * @param description description of the item
     * @param category    category of the item
     */
    public Item(String name, float price, User owner, String description, Category category) {
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.description = description;
        this.category = category;
    }

    /**
     * Returns a formatted string representation of the Item object.
     * @author Anis Abdellatif
     * @return a formatted string containing the name, price, owner's username,
     *         description and category of the item.
     */
    public String str() {
        return String.format(
            "Item: %s; Price: %.2f, User: %s, Description: %s, Category: %s",
            this.name,
            this.price,
            this.owner.getUsername(),
            this.description,
            this.category != null ? category.str() : ""
        );
    }

    /**
     * Returns the name of the item.
     * @author Anis Abdellatif
     * @return the name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the item.
     * @author       Anis Abdellatif
     * @param name   the new name of the item
     * @param callee the user attempting to set the name (must be the owner)
     */
    public void setName(String name, User callee) {
        if (callee != owner) {
            return;
        }

        this.name = name;
    }

    /**
     * Returns the price of the item.
     * @author Anis Abdellatif
     * @return the price of the item
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * Sets the price of the item.
     * @author       Anis Abdellatif
     * @param price  the new price of the item (price > 0)
     * @param callee the user attempting to set the price (must be the owner)
     */
    public void setPrice(float price, User callee) {
        if (callee != owner || price < 0.0) {
            return;
        }

        this.price = price;
    }

    /**
     * Returns the owner of the item.
     * @author Anis Abdellatif
     * @return the owner of the item
     */
    public User getUser() {
        return this.owner;
    }

    /**
     * Returns the description of the item.
     * @author Anis Abdellatif
     * @return the description of the item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the item.
     * @author            Anis Abdellatif
     * @param description the new description of the item
     * @param callee      the user attempting to set the description (must be the owner)
     */
    public void setDescription(String description, User callee) {
        if (callee != owner) {
            return;
        }

        this.description = description;
    }

    /**
     * Returns the category of the item.
     * @author Anis Abdellatif
     * @return the category of the item
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * Sets the category of the item.
     * @author            Anis Abdellatif
     * @param category    the new category of the item
     * @param callee      the user attempting to set the category (must be the owner)
     */
    public void setCategory(Category category, User callee) {
        if (callee != owner) {
            return;
        }

        this.category = category;
    }
}