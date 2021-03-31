public class Shop {
    private ShopItem[] table;
    private int tableSize;
    private double loadFactor;
    int numItems;

    public Shop(){
        tableSize= 100;
        table = new ShopItem[tableSize];
        loadFactor= 0.80;
        numItems=0;
    }

    private int hashFunction(Weapon weapon){
        int value=0,weight=1;
        for (int x =0; x<weapon.getWeaponName().length();x++){
            value += (weapon.getWeaponName().charAt(x) + 1)*weight;
            weight++;
        }
        return value%tableSize;
    }

    public int search(String weaponName){
        int count = 1;
        Weapon temp = new Weapon(weaponName, 0, 0, 0, 0);
        int loc = hashFunction(temp);
        while (table[loc] != null && table[loc].weapon.getWeaponName().compareTo(weaponName)!=0 ){
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
            if(search(shopItem.weapon.getWeaponName()) == -1){
                table[loc]=shopItem;
                numItems++;
                return true;
            }
        }
        return false;
    }

    public boolean delete(Weapon weapon){ // change to string plz
        int loc = search(weapon.getWeaponName());
        if(loc == -1) return false;

        table[loc].weapon.setWeaponName("DELETED");
        numItems--;
        return true;
    }

    public String printShopItems(){
        String s = "";
        for(ShopItem i : table){
            if(i != null) {
                s += i.weapon.getWeaponName() + "\n";
            }
        }
        return s;
    }
}