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

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
