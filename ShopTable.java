import java.util.Arrays;

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

    private int hashFunction(Weapon weapon){
        int value=0,weight=1;
        for (int x =0; x<weapon.getWeaponName().length();x++){
            value += (weapon.getWeaponName().charAt(x)-'a'+1)*weight;
            weight++;
        }
        return value%tableSize;
    }

    public int search(Weapon weapon){
        int count = 1;
        int loc = hashFunction(weapon);
        while (table[loc].weapon.getWeaponName().compareTo(weapon.getWeaponName())!=0 && table[loc] != null){
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
            int startLoc =hashFunction(shopItem.weapon);
            int loc = startLoc;
            while (table[loc] != null && table[loc].weapon.getWeaponName().compareTo("DELETED")!=0){
                loc = (loc+(count*count))%tableSize;
                count++;
            }
        if(search(shopItem.weapon) == -1){
            table[loc]=shopItem;
            numItems++;
            return true;
            }
        }
        return false;
    }

    public void delete(Weapon weapon){
        int loc = search(weapon);
        if(loc == -1) return;

        table[loc].weapon.setWeaponName("DELETED");
        numItems--;
    }

    public String printShopItems(){
        String s = "";
        for(ShopItem i : table){
            s += i.weapon.getWeaponName();
        }
        return s;
    }
}
