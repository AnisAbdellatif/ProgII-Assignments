package de.uni_hannover.task2;

import java.util.*;
import de.uni_hannover.task2.auth.*;
import de.uni_hannover.task2.offerings.*;
import java.util.Scanner;

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
    private Scanner scanner = new Scanner(System.in);
    private List<User> users;
    private User loggedInUser;

    /**
     * Constructs a marketplace object with 
     * maximum 10 users.
     * 
     * @author Kevin Schumann
     */
    public Marketplace() {
        this.scanner = new Scanner(System.in);
        this.users = new ArrayList<User>();
    }

    /**
     * Returns a string representation of the marketplace
     * 
     * @author Kevin Schumann
     * @return String representation of the item.
     */
    public String str() {
        String res = "";
        
        for(int i = 0; i < this.users.size(); i++) {
            res += "\n" + this.users.get(i).str();
        }

        return res;
    }

    /**
     * Adds an user to the marketplace.
     * 
     * @author Kevin Schumann
     * @param user User that shall be added.
     * @return False if user limit has been reached, else true.
     */
    public boolean addUser(User user) {
        return this.users.add(user);
    }

    /**
     * Asks for name and password up to 3 times in the console.
     * Iff name and password matches one user, it returns said user
     * 
     * @author Kevin Schumann
     * @return User that matches the name/password or null
     */
    public User login() {
        int tries = 0;

        while(tries < 3){
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            for (User user : this.users) {
                int passwordMatch = user.getPassword().compareTo(password);
                int userMatch = user.getUsername().compareTo(username);
                
                if(passwordMatch == 0 && userMatch == 0){
                    this.loggedInUser = user;
                    return user;
                }
            }

            tries++;
        }

        System.exit(0);
        return null;
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
        for (User user : users) {
            for (Item item : user.getItems()) {
                if (category.isSameCategory(item)) {
                    res += item.str();
                }
            }

            res += "\n";
        }
        
        return res;
    }
    
    /**
     * Implements the submenu in which user
     * can add new items to the marketplace
     * 
     * @author Kevin Schumann
     */
    public void addItemMenu() {
        System.out.println("\nUm ein Item hinzufügen, geben Sie die folgenden Daten ein.\n");
        
        System.out.print("Name: ");
        String name = this.scanner.nextLine();

        System.out.print("Preis: ");
        Float price =Float.parseFloat(this.scanner.nextLine());
        
        System.out.print("Beschreibung: ");
        String description = this.scanner.nextLine();
        
        System.out.print("\nWähle aus den folgenden Kategorien und tippen Sie diese ein:\n\n");
        for(Category c : Category.values()){
            System.out.println(c);
        }
        
        System.out.print("\nKategory: ");
        String catString = scanner.nextLine();
        Category cat = Category.valueOf(catString.toUpperCase());
        
        // create item and add to current user
        Item item = new Item(name, price, this.loggedInUser, description, cat);
        this.loggedInUser.addItem(item);
    }

    /**
     * Implements the submenu in which user
     * can remove items from the marketplace
     * 
     * @author Kevin Schumann
     */
    public void removeItemMenu() {
        System.out.println("\nGeben Sie die Nummer des zu entfernden Items an:\n");
        
        int counter = 1;
        for (Item item : this.loggedInUser.getItems()) {
            System.out.println(counter + ".  " + item.str());
            counter++;
        }
        
        System.out.print("\nItem Nummer: ");
        int indexToRemove = Integer.parseInt(this.scanner.nextLine()) - 1;
        this.loggedInUser.getItems().remove(indexToRemove);
    }



    /**
     * Implements the submenu in which user
     * can edit their own items.
     * 
     * @author Kevin Schumann
     */
    public void editItemMenu() {
        System.out.println("\nGeben Sie die Nummer des zu ändernen Items an:\n");
        
        int counter = 1;
        for (Item item : this.loggedInUser.getItems()) {
            System.out.println(counter + ".  " + item.str());
            counter++;
        }

        System.out.print("\nItem Nummer: ");
        int index = Integer.parseInt(this.scanner.nextLine()) - 1;
        Item itemToChange = this.loggedInUser.getItems().get(index);

        System.out.println(
                "\nWählen Sie aus den folgenden Optionen:\n"
                + "1. Name ändern\n"
                + "2. Preis ändern\n"
                + "3. Beschreibung ändern\n"
                + "4. Category ändern\n"
        ); 

        index =  Integer.parseInt(this.scanner.nextLine());
        switch (index) {
            case 1:
                System.out.print("\nNeuer name: ");
                itemToChange.setName(this.scanner.nextLine());
                break;
            case 2:
                System.out.print("\nNeuer Preis: ");
                itemToChange.setPrice(
                    Float.parseFloat(this.scanner.nextLine())
                );
                break;
            case 3:
                System.out.print("\nNeue Beschreibung: ");
                itemToChange.setDescription(this.scanner.nextLine());
                break;
            case 4:
                for(Category c : Category.values()){
                    System.out.println(c);
                }

                System.out.println("\nBitte schreiben Sie die neue Kategory\n");
                Category category = Category.valueOf(this.scanner.nextLine().toUpperCase());
                itemToChange.setCategory(category);
                break;
            default:
                break;
        }

    }

    /**
     * Implements the submenu in which user
     * can filter the marketplace and print 
     * their selection.
     * 
     * @author Kevin Schumann
     */
    public void searchMarketplace() {
        System.out.println(
            "\nGeben Sie die Kategory ein, die Sie sehen möchten."
            + "Möchten Sie alle Items sehen, geben sie 'alle' ein\n"
        );

        for(Category c : Category.values()){
            System.out.println(c);
        }
        System.out.print("ALLE\n\n");

        
        String choice = this.scanner.nextLine().toUpperCase();
        if(choice.compareTo("ALLE") == 0) {
            System.out.println(this.filterMarket(null));
            return;
        }

        Category category = Category.valueOf(choice);
        System.out.println(this.filterMarket(category));

    }

    /**
     * Implements the main menu of
     * the command line interface.
     * 
     * @author Kevin Schumann
     */
    public void cli() {
        while(true) {
            System.out.println(
                "\nWählen Sie aus den folgenden Optionen:\n\n"
                + "1. Item hinzufügen\n"
                + "2. Item entfernen\n"
                + "3. Item editieren\n"
                + "4. Marketplace anssehen\n"
                + "5. Programm beenden\n"
            ); 

            int choice = Integer.parseInt(this.scanner.nextLine());
            
            switch (choice) {
                case 1:
                    addItemMenu();
                    break;
                case 2:
                    removeItemMenu();
                    break;
                case 3:
                    editItemMenu();
                    break;
                case 4:
                    searchMarketplace();
                    break;
                case 5:
                    System.exit(0);    
                    break;
                default:
                    break;
            }

        }

    }


    public static void main(String[] args) {
        Marketplace m = new Marketplace();
        m.addUser(new User("Max", "1234"));

        m.login();
        m.cli();
    }
}

