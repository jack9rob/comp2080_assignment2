public class Weapon {
    // change to public?
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

    public String getName() { return weaponName;}
    public int getRange() { return range;}
    public int getDamage() { return damage;}
    public double getWeight() { return weight;}
    public double getCost() { return cost;}
}
