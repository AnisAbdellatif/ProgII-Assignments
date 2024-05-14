package de.uni_hannover.task2.offerings;


/**
 * This class represents an item that
 * can be offered on a digital marketplace.
 * 
 * Items are offered by an user. Stores 
 * attributes such as name, price, description
 * and the category
 * 
 * @author Kevin Schumann
 * @version 03/05/2023
 */
public class Item {
    private int itemId;
    private String name;
    private float price;
    // private User owner; -> Depricated! Use String owner instead.
    private String owner;  
    private String description;
    private Category category;

    /**
     * Constructs the object with all its attributes.
     * 
     * @author Kevin Schumann
     * @param name Name of the item
     * @param price Price of the item
     * @param owner Owner of the item
     * @param description Description of the item
     * @param category Category of the item.
     */
    public Item(String name, float price, String owner, String description, Category category) {
        this.itemId = -1;
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.description = description;
        this.category = category;
    }


    /**
     * Constructs the object with all its attributes.
     * 
     * @author Kevin Schumann
     * @param itemId Id of the item
     * @param name Name of the item
     * @param price Price of the item
     * @param owner Owner of the item
     * @param description Description of the item
     * @param category Category of the item.
     */
    public Item(int itemId, String name, float price, String owner, String description, Category category) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.description = description;
        this.category = category;
    }


     /**
     * Gets the id of the item.
     * 
     * @author Anis Abdellatif
     * @return int id of the item.
     */
    public int getItemId() {
        return this.itemId;
    }

    /**
     * Returns a string representation of the object.
     * 
     * @author Kevin Schumann
     * @return String representation of the object.
     */
    public String str() {
        return String.format(
            "Item: %s; Price: %.2f, User: %s, Description: %s, Category: %s",
            name,
            price,
            owner,
            description,
            category.str()
        );
    }

    /**
     * Gets the name of the item.
     * 
     * @author Kevin Schumann
     * @return Name of the item
     */
	public String getName() {
		return this.name;
	}

    /**
     * Sets the name of the item
     * 
     * @author Kevin Schumann
     * @param name New name of the item
     */
    public void setName(String name) {
        this.name = name;
	}

    /**
     * Gets the price of the item
     * 
     * @author Kevin Schumann 
     * @return Price of the item.
     */
	public float getPrice() {
		return this.price;
	}

    /**
     * Sets the price of the item
     * 
     * @author Kevin Schumann
     * @param price New price of the item
     */
	public void setPrice(float price) {
		this.price = price;
	}

    /**
     * Gets the owner of the item
     * 
     * @author Kevin Schumann 
     * @return Owner of the item.
     */
	public String getUser() {
		return this.owner;
	}

    /**
     * Gets the category of the item
     * 
     * @author Kevin Schumann 
     * @return Category of the item.
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * Sets the category of the item
     * 
     * @author Kevin Schumann
     * @param category New category of the item
     */
    public void setCategory(Category category) {
		this.category = category;
    }

    /**
     * Gets the description of the item
     * 
     * @author Kevin Schumann 
     * @return Description of the item.
     */
	public String getDescription() {
		return this.description;
	}

    /**
     * Sets the description of the item
     * 
     * @author Kevin Schumann
     * @param description New description of the item
     */
	public void setDescription(String description) {
		this.description = description;
	}

}