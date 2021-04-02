public class ShopItem {
    public Weapon weapon;
    public int quantity;

    public ShopItem(Weapon weapon, int quantity){
        this.weapon = weapon;
        this.quantity = quantity;
    }
    public ShopItem(String name, int range, int damage, double weight, double cost, int quantity) {
        weapon = new Weapon(name, range, damage, weight, cost);
        this.quantity = quantity;
    }

    public void decreaseQuantity() {
        quantity--;
    }

}
