import java.util.Scanner;

public class Main {

    public static int getUserIntInput(Scanner sc, String message){
        System.out.println(message);
        while(sc.hasNextInt()){
            sc.nextLine();
            System.out.println(message);
        }
        return sc.nextInt();
    }

    public static double getUserDoubleInput(Scanner sc, String message){
        System.out.println(message);
        while(sc.hasNextDouble()){
            sc.nextLine();
            System.out.println(message);
        }
        return sc.nextDouble();
    }

    public static void addItemsToShop(Scanner sc, ShopTable shopTable, String message){
        System.out.println(message);
        String weaponName = sc.next();
        int quantity = getUserIntInput(sc, "Please enter the quantity");
        int range = getUserIntInput(sc, "Please enter the range");
        int damage = getUserIntInput(sc, "Please enter the damage");
        double weight = getUserIntInput(sc, "Please enter the weight");
        double cost = getUserDoubleInput(sc, "Please enter the cost");

        Weapon weapon = new Weapon(weaponName,range,damage,weight,cost);
        ShopItem item = new ShopItem(weapon,quantity);

        if(shopTable.insert(item)){
            System.out.println("Item added");
        }
        else{
            System.out.println("Item already exist");
        }
    }

    public static void deleteItemsFromShop(Scanner sc, ShopTable shopTable, String message){
        System.out.println(message);
        shopTable.printShopItems();
        String userInput = sc.next();
        if(shopTable.search(userInput))
    }


    public static void main(String[] args) {
        System.out.println("1)\tAdd Items to the shop");
        System.out.println("2)\tDelete Items from the shop");
        System.out.println("3)\tBuy from the Shop");
        System.out.println("4)\tView backpack");
        System.out.println("5)\tView Player");
        System.out.println("6)\tExit");



        Scanner scanner = new Scanner(System.in);
        ShopTable shopTable = new ShopTable();


        int userInput = getUserIntInput(scanner, "Enter a number please");

        switch (userInput){
            case 1:
                addItemsToShop(scanner,shopTable,"Please enter the details");
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
        }

    }
}
