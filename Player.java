public class Player {
    private String name;
    private double coins;
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

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public double getCoins() {
        return coins;
    }

    public boolean deposit(int amount) {
        if(amount > 0) {
            coins += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if(coins - amount >= 0) {
            coins -= amount;
            return true;
        }
        return false;
    }

    public void printBackPack() {
        backpack.printBackpack();
    }

    // wrapper for backpack methods
    public boolean addWeapon(Weapon w) {
        return backpack.addWeapon(w);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", coins=" + coins +
                '}';
    }
}
