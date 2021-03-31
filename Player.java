public class Player {
    private String name;
    private int coins;
    private Backpack backpack;


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
    }
}
