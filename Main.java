import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static int getUserIntInput(Scanner sc, String message){
        System.out.println(message);
        int input;
        while(!sc.hasNextInt()){
            input = sc.nextInt();
            if(input < 0){
                continue;
            }
            System.out.println(message);
        }
        return sc.nextInt();
    }

    public static double getUserDoubleInput(Scanner sc, String message) {
        System.out.println(message);
        while (!sc.hasNextDouble()) {
            sc.nextDouble();
            System.out.println(message);
        }
        return sc.nextDouble();
    }

    public static void addItemsToShop (Scanner sc, ShopTable shop, String message){
        System.out.println(message);
        System.out.println("Please enter the weapon name ('exit' to stop): ");
        sc.nextLine();
        String weaponName = sc.nextLine().toLowerCase();
        while(weaponName.compareTo("exit") != 0) {
            // get weapon attributes
            int quantity = getUserIntInput(sc, "Please enter the quantity");
            int range = getUserIntInput(sc, "Please enter the range");
            int damage = getUserIntInput(sc, "Please enter the damage");
            double weight = getUserIntInput(sc, "Please enter the weight");
            double cost = getUserDoubleInput(sc, "Please enter the cost");
            // create and object
            Weapon weapon = new Weapon(weaponName,range,damage,weight,cost);
            ShopItem item = new ShopItem(weapon,quantity);
            // check if item can be added to shop, check if shop table method checks for duplicate
            if(shop.insert(item)){
                System.out.println("Item added");
            }
            else{
                System.out.println("Item already exist");
            }
            System.out.println("Please enter the weapon name ('exit' to stop): ");
            sc.nextLine();
            weaponName = sc.nextLine().toLowerCase();
        }
        System.out.println(shop.printShopItems());

    }

    public static void deleteItemsFromShop(Scanner sc, ShopTable shop, String message){ // add a loop
        System.out.println(message);
        System.out.println(shop.printShopItems());
        sc.nextLine();
        String userInput = sc.nextLine().toLowerCase();
        if(shop.delete(userInput)) {
            System.out.println("Item deleted");
        } else {
            System.out.println("not deleted");
        }
    }

    public static void buyItemsFromShop(Scanner sc, ShopTable shop, Player player , String message){
        System.out.println(message);
        // print shop items
        System.out.println(shop.printShopItems());
        // get user input for weapon name
        System.out.println("Please enter the weapon name ('exit' to stop): ");
        sc.nextLine();
        String weaponName = sc.nextLine().toLowerCase();
        while(weaponName.compareTo("exit") != 0) {
            // get shop item
            ShopItem shopItem = shop.getShopItem(weaponName);
            // check if shop item is valid
            if(shopItem != null) {
                // check if player has enough coins
                if(player.getCoins() >= shopItem.weapon.getCost()) {
                    // check if weapon can be added to backpack
                    if(player.addWeapon(shopItem.weapon)){
                        // remove coins from player
                        player.withdraw(shopItem.weapon.getCost());
                        // decrease quantity, add method to do it for shop
                        shop.decreaseWeaponQuantity(weaponName);
                        // send a message
                        System.out.println("You bought a " + shopItem.weapon.getWeaponName());
                    } else {
                        System.out.println("Unable to carry weapon");
                    }
                } else {
                    System.out.println("You don't have enough coins");
                }
            } else {
                System.out.println("Weapon DNE");
            }
            System.out.println("Please enter the weapon name ('exit' to stop): ");
            weaponName = sc.nextLine().toLowerCase();
        }
        System.out.println(shop.printShopItems());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShopTable shopTable = new ShopTable();
        Player player = new Player("Jack");

        // populate shop table with weapons
        shopTable.insert(new ShopItem(new Weapon("sword", 1, 10, 3, 10), 10));
        shopTable.insert(new ShopItem(new Weapon("spear", 3, 6, 3, 10), 20));
        shopTable.insert(new ShopItem(new Weapon("bow", 10, 4, 1, 10), 10));

        System.out.println("Welcome to our weapon shop! What is your name?");
        String username = scanner.nextLine();
        player = new Player(username);
        System.out.println("Welcome " + username +"! Here is your player:");
        System.out.println(player.toString());



        System.out.println("1)\tAdd Items to the shop");
        System.out.println("2)\tDelete Items from the shop");
        System.out.println("3)\tBuy from the Shop");
        System.out.println("4)\tView backpack");
        System.out.println("5)\tView Player");
        System.out.println("6)\tExit");


        int userInput = getUserIntInput(scanner, "Enter a number please");

        while(userInput != 6) {
            switch (userInput) {
                case 1:
                    addItemsToShop(scanner, shopTable, "Please enter the details");
                    break;
                case 2:
                    deleteItemsFromShop(scanner, shopTable, "Delete");
                    break;
                case 3:
                    buyItemsFromShop(scanner,shopTable,player,"Choose the items you want to buy");
                    break;
                case 4:
                    // print player backpack
                    System.out.println(player.printBackPack());
                    break;
                case 5:
                    // print player info
                    System.out.println(player.toString());
                    break;
            }
            System.out.println("1)\tAdd Items to the shop");
            System.out.println("2)\tDelete Items from the shop");
            System.out.println("3)\tBuy from the Shop");
            System.out.println("4)\tView backpack");
            System.out.println("5)\tView Player");
            System.out.println("6)\tExit");

            userInput = getUserIntInput(scanner, "Enter a number please");
        }
        System.out.println("Thank you, GOODBYE!");
    }
}