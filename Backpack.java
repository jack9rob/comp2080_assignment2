import java.io.Console;

public class Backpack {
    private int numItems;
    private int maxItems;
    private double currWeight;
    private double maxWeight;
    private WeaponLinkedList[] table; // need to change to linked list

    public Backpack() {
        numItems = 0;
        maxItems = 30;
        currWeight = 0;
        maxWeight = 90;
        table = new WeaponLinkedList[maxItems];

        for(int i = 0; i < maxItems; i++) {
            table[i] = new WeaponLinkedList();
        }
    }

    // used weighted weapon name for hash
    public int hashFunction(String weaponName) {
        int value = 0;
        for(int i = 0; i < weaponName.length(); i++) {
            value += (weaponName.charAt(i) * i);
        }
        return value % maxItems;
    }

    // can use print to print if weapon can't be added
    public boolean addWeapon(Weapon weapon) {
        if(numItems < maxItems && currWeight + weapon.getWeight() < maxWeight){
            int loc = hashFunction(weapon.getWeaponName());
            table[loc].insert(weapon);
            currWeight += weapon.getWeight();
            numItems++;
            System.out.println(weapon.getWeaponName() + ' ' + loc);
            return true;
        }
        return false;
    }

    public String printBackpack() {
        String s = "Backpack: \n";
        s += "Name-Range-Damage-Weight-Value\n";
        for(int i = 0; i < maxItems; i++) {
            if(!table[i].isEmpty()) {
                s += table[i].print()  + "\n";
            }
        }
        return s;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getCurrWeight() {
        return currWeight;
    }

    public void setCurrWeight(double currWeight) {
        this.currWeight = currWeight;
    }

    public boolean inventoryFull() {
        return numItems >= maxItems;
    }
}
