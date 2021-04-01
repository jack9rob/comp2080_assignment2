public class Player {
    private String name;
    private double coins;
    private Backpack backpack;

    public Player(String name) {
        this.name = name;
        coins = 45;
        backpack = new Backpack();
    }

    public String getName() {
        return name;
    }

    public double getCoins() {
        return coins;
    }

    public boolean deposit(double amount) {
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

    public String printBackPack() {
        return backpack.printBackpack();
    }

    public Backpack getBackpack() {
        return backpack;
    }

    // wrapper for backpack methods
    public boolean addWeapon(Weapon w) {
        return backpack.addWeapon(w);
    }

    public String toString() {
        String s = "Name: " + name + "\n";
        s += "Coins: " + coins + "\n";
        s += backpack.printBackpack();
        return s;
    }
}
