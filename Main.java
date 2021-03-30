import java.util.Scanner;

public class Main {

    public static int getUserIntInput(Scanner sc, String message){
        System.out.println(message);
        while(!sc.hasNextInt()){
            sc.nextLine();
            System.out.println(message);
        }
        return sc.nextInt();
    }

    public static double getUserDoubleInput(Scanner sc, String message){
        System.out.println(message);
        while(!sc.hasNextDouble()){
            sc.nextLine();
            System.out.println(message);
        }
        return sc.nextDouble();
    }

    public static void addItemsToShop(Scanner sc, Shop shop, String message){
        System.out.println(message);
        System.out.println("Please enter the weapon name ('exit' to stop): ");
        sc.nextLine();
        String weaponName = sc.nextLine();
        while(weaponName.compareTo("exit") != 0) {
            // get weapon attributes
            int quantity = getUserIntInput(sc, "Please enter the quantity");
            int range = getUserIntInput(sc, "Please enter the range");
            int damage = getUserIntInput(sc, "Please enter the damage");
            double weight = getUserIntInput(sc, "Please enter the weight");
            double cost = getUserDoubleInput(sc, "Please enter the cost");
            // create and insert object
            Weapon weapon = new Weapon(weaponName,range,damage,weight,cost);
            ShopItem item = new ShopItem(weapon,quantity);
            if(shop.insert(item)){
                System.out.println("Item added");
            }
            else{
                System.out.println("Item already exist");
            }
            System.out.println("Please enter the weapon name ('exit' to stop): ");
            sc.nextLine();
            weaponName = sc.nextLine();
        }
        System.out.println(shop.printShopItems());

    }

    public static void deleteItemsFromShop(Scanner sc, Shop shop, String message){
        System.out.println(message);
        shop.printShopItems();
        String userInput = sc.next();
        if(shop.delete(new Weapon(userInput, -1, -1, -1, -1))) { // lol change delete to string
            System.out.println("Item deleted");
        } else {
            System.out.println("not deleted");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shopTable = new Shop();
        Player player = new Player("Jack");

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
                    // buy from shop method
                    break;
                case 4:
                    // print player backpack
                    break;
                case 5:
                    // print player info
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