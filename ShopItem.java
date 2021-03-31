public class ShopItem {
    public Weapon weapon;
    public int quantity;

<<<<<<< HEAD
    public ShopItem(Weapon weapon, int quantity){
        this.weapon = weapon;
        this.quantity = quantity;
    }
=======
    public ShopItem(Weapon weapon, int quantity) {
        this.weapon = weapon;
        this.quantity = quantity;
    }

    public ShopItem(String name, int range, int damage, double weight, double cost, int quantity) {
        weapon = new Weapon(name, range, damage, weight, cost);
        this.quantity = quantity;
    }
>>>>>>> cc5c3c5869a6c8d6fe541cdd35f9e07b65c49c8b
}
