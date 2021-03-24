public class Player {
    private String name;
    private int coins;
    private Backpack backpack;

    public Player(String name) {
        this.name = name;
        coins = 45;

    }

    public boolean addWeapon(Weapon weapon) {
        return backpack.addWeapon(weapon);
    }

    public String getName() {
        return name;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void viewBackPack() {

    }
}
