public class ShopItem {
    public Weapon weapon;
    public int stock;

    public ShopItem(Weapon weapon, int stock) {
        this.weapon = weapon;
        this.stock = stock;
    }

    public ShopItem(String name, int range, int damage, double weight, double cost, int stock) {
        weapon = new Weapon(name, range, damage, weight, cost);
        this.stock = stock;
    }
}
