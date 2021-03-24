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
        table = new WeaponLinkedList[30];
        for(int i = 0; i < maxItems; i++) {
            table[i] = new WeaponLinkedList();
        }
    }

    public int hashFunction(String weaponName) {
        int value = 0;
        for(int i = 0; i < weaponName.length(); i++) {
            value += (weaponName.charAt(i) * i);
        }
        return value % maxItems;
    }

    public boolean addWeapon(Weapon weapon) {
        if(numItems < maxItems && currWeight + weapon.getWeight() < maxWeight){
            int loc = hashFunction(weapon.getName());
            table[loc].insert(weapon);
            currWeight += weapon.getWeight();
            numItems++;
            return true;
        }
        return false;
    }

    public void printBackpack() {
        for(int i = 0; i < maxItems; i++) {
            table[i].print();
        }
    }
}
