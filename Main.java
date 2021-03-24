public class Main {
    public static void main(String[] args) {
        Backpack b = new Backpack();
        Weapon w1 = new Weapon("Sword", 1, 10, 10, 15);
        Weapon w2 = new Weapon("Spear", 1, 10, 10, 15);
        Weapon w3 = new Weapon("Cannon", 10, 10, 100, 15);
        b.addWeapon(w1);
        b.addWeapon(w2);
        b.addWeapon(w3);
        b.addWeapon(w1);
        b.printBackpack();
    }
}
