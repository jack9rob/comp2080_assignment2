public class Weapon {
    private String weaponName;
    private int range;
    private int damage;
    private double weight;
    private double cost;

    public Weapon(String name, int range, int damage, double weight, double cost) {
        this.weaponName = name;
        this.range = range;
        this.damage = damage;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName() {
        return weaponName;
    }
}
