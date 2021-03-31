public class Player {
    private String name;
    private int coins;
    private Backpack backpack;

<<<<<<< HEAD
    public Player(){
        coins = 100;

=======
    public Player(String name) {
        this.name = name;
        coins = 45;
        backpack = new Backpack();
    }

    public boolean buy(Weapon weapon) {
        // check price
        return backpack.addWeapon(weapon);
    }

    public String getName() {
        return name;
    }

    public int getCoins() {
        return coins;
    }

    public boolean deposit(int amount) {
        if(amount > 0) {
            coins += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(int amount) {
        if(coins - amount >= 0) {
            coins -= amount;
            return true;
        }
        return false;
    }

    public void printBackPack() {

    }

    // wrapper for backpack methods
    public boolean addWeapon(Weapon w) {
        return backpack.addWeapon(w);
>>>>>>> cc5c3c5869a6c8d6fe541cdd35f9e07b65c49c8b
    }
}
