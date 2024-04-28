package de.uni_hannover.task2;

import java.util.Scanner;

import de.uni_hannover.task2.auth.*;
import de.uni_hannover.task2.offerings.*;
import de.uni_hannover.task2.CustomScanner;

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

    private CustomScanner scanner = new CustomScanner();

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
        if (category == null) {
            return this.str();
        }

        String res = "";
        for (int i = 0; i < users.length; i++) {
            if (this.users[i] == null) {
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
    
    public User login() {
        for (int i = 0; i < 3; i++) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            for (int j = 0; j < this.users.length; j++) {
                if (this.users[j] == null) {
                    continue;
                }

                if (this.users[j].getUsername().equals(username) && this.users[j].getPassword().equals(password)) {
                    return this.users[j];
                }
            }
        }
        System.exit(1);
        return null;
    }

    private boolean cli_add_item(User user) {
        System.out.print("Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Item Price: ");
        int price = scanner.nextInt();
        System.out.print("Item Description: ");
        String description = scanner.nextLine();
        System.out.print("Item Category: ");
        Category category = Category.valueOf(scanner.nextLine());
        Item item = new Item(name, price, user, description, category);
        return user.addItem(item);
    }

    private boolean cli_remove_item(User user) {
        System.out.print("Item Name: ");
        String name = scanner.nextLine();
        Item item = user.getItem(name);
        return user.removeItem(item);
    }
    
    private boolean cli_edit_item(User user) {
        String name;
        float price;
        String description;

        System.out.print("Item Name: ");
        name = scanner.nextLine();
        Item item = user.getItem(name);
        if (item == null) {
            System.out.println("Item not found");
            return false;
        }
        System.out.print(String.format("Item Name (%s): ", item.getName()));
        name = scanner.nextLine();
        if (!name.equals("")) {
            item.setName(name, user);
        }

        System.out.print(String.format("Item Price (%s): ", item.getPrice()));
        String priceStr = scanner.nextLine();
        System.out.println("|" + priceStr + "|");
        if (!priceStr.equals("")) {
            price = (new Scanner(priceStr)).nextFloat();
            item.setPrice(price, user);
        }

        System.out.print(String.format("Item Description (%s): ", item.getDescription()));
        description = scanner.nextLine();
        if (!description.equals("")) {
            item.setDescription(description, user);
        }
        return true;
    }

    private void cli_print_market() {
        System.out.println("Welche Kategorie wollen Sie sich anschauen:");
        System.out.println("1. Alle");
        System.out.println("2. CLOTHES");
        System.out.println("3. ELECTRONICS");
        System.out.println("4. FURNITURE");
        System.out.println("5. SERVICES");
        System.out.println("6. ANIMALS");
        System.out.println("X. Programm beenden");
        System.out.print(">>");

        int choice = 0;
        if (scanner.rawScanner.hasNext("X")) {
            System.exit(0);
        } else if (scanner.rawScanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            System.out.println("Invalid choice");
            return;
        }
        switch (choice) {
            case 1:
                System.out.println(this.str());
                break;
            case 2:
                System.out.println(filterMarket(Category.CLOTHES));
                break;
            case 3:
                System.out.println(filterMarket(Category.ELECTRONICS));
                break;
            case 4:
                System.out.println(filterMarket(Category.FURNITURE));
                break;
            case 5:
                System.out.println(filterMarket(Category.SERVICES));
                break;
            case 6:
                System.out.println(filterMarket(Category.ANIMALS));
                break;
            default:
                break;
        }
    }
    
    public void cli() {
        User user = this.login();

        System.out.println("");
        System.out.println("Willkommen " + user.getUsername());
        while (true) {
            System.out.println("Wählen Sie aus den folgenden Optionen:");
            System.out.println("1. Item hinzufügen");
            System.out.println("2. Item entfernen");
            System.out.println("3. Marketplace ansehen");
            System.out.println("4. Item");
            System.out.println("5. Programm beenden");
            System.out.print(">>");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    cli_add_item(user);
                    break;
                case 2:
                    cli_remove_item(user);
                    break;

                case 3:
                    cli_print_market();
                    break;

                case 4:
                    cli_edit_item(user);
                    break;

                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
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

        market.cli();
    }
}

