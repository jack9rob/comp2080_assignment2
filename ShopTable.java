import java.util.Locale;

public class ShopTable {
    private ShopItem[] table;
    private int tableSize;
    private double loadFactor;
    int numItems;

    public ShopTable(){
        tableSize= 100;
        table = new ShopItem[tableSize];
        loadFactor= 0.80;
        numItems=0;
    }

    private int hashFunction(String weaponName){
        int value=0,weight=1;
        for (int x =0; x<weaponName.length();x++){
            value += (weaponName.charAt(x))*weight;
            weight++;
        }
        return value%tableSize;
    }

    public int search(String weaponName){
        int count = 1;
        int loc = hashFunction(weaponName);
        while (table[loc] != null && table[loc].weapon.getWeaponName().compareTo(weaponName)!=0){
            loc = (loc + (count*count))%tableSize;
            count++;
        }
        if (table[loc] == null)
            return -1;
        return loc;
    }

    public boolean insert (ShopItem shopItem){
        if (numItems/tableSize < loadFactor){
            int count = 1;
            int startLoc = hashFunction(shopItem.weapon.getWeaponName());
            int loc = startLoc;
            while (table[loc] != null && table[loc].weapon.getWeaponName().compareTo("DELETED")!=0){
                loc = (loc+(count*count))%tableSize;
                count++;
            }

        if(search(shopItem.weapon.getWeaponName()) == -1){
            table[loc]=shopItem;
            numItems++;
            return true;
            }
        }
        return false;
    }

    public boolean delete(String weaponName){
        int loc = search(weaponName);
        if(loc == -1) return false;

        table[loc].weapon.setWeaponName("DELETED");
        numItems--;
        return true;
    }

    public String printShopItems(){
        String s = "Weapons:\n";
        for(ShopItem i : table){
            if(i != null && i.weapon.getWeaponName().compareTo("DELETED") != 0){
                s += i.weapon.getWeaponName().toUpperCase(Locale.ROOT) + " Quantity: " + i.quantity + " Weight: " +i.weapon.getWeight() + " Damage: " + i.weapon.getDamage() + "\n";
            }
        }
        return s;
    }

    public ShopItem getShopItem(String weaponName){
        int loc = search(weaponName);
        if(loc != -1){
            return table[loc];
        }
        return null;
    }

    // decrease quantity by 1, if quantity <= 0 delete item
    public void decreaseWeaponQuantity(String weaponName) {
        ShopItem item = getShopItem(weaponName);
        if(item != null) {
            item.decreaseQuantity();
            if(item.quantity <= 0) {
                delete(weaponName);
            }
        }
    }
}
