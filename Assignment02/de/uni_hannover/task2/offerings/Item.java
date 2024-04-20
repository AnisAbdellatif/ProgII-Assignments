package de.uni_hannover.task2.offerings;

import de.uni_hannover.task2.auth.User;

public class Item {
    private String name;
    private double price;
    private User seller;
    private String description;

    public Item(String name, double price, User seller, String description) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public User getSeller() {
        return this.seller;
    }

    public String getDescription() {
        return this.description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
