public class Menu {
    QuadHashTable storage;

    public void printMenu(){
        System.out.println("1)\tAdd Items to the shop");
        System.out.println("2)\tDelete Items from the shop");
        System.out.println("3)\tBuy from the Shop");
        System.out.println("4)\tView backpack");
        System.out.println("5)\tView Player");
        System.out.println("6)\tExit");
    }

    public void addItems(Weapon item){
        storage.insert(item);
    }

    public void deleteItems(Weapon item){

    }

    public void buyItems(){

    }

    public void viewBackpack(){

    }

    public void viewPlayer(){

    }

    public void quit(){

    }


    public void decision(int choice){
        switch (choice){
            case 1:
                addItems();
                break;
            case 2:
                deleteItems();
                break;
            case 3:
                buyItems();
                break;
            case 4:
                viewBackpack();
                break;
            case 5:
                viewPlayer();
                break;
            case 6:
                quit();
                break;
        }
    }
}
