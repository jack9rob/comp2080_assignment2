public class QuadHashTable {
    private Weapon[] table;
    private int tableSize;
    private double loadFactor; //0.80
    int numItems;

    public QuadHashTable(int max,double lf) {
        table = new Weapon[max];
        tableSize = max;
        loadFactor = lf;
        numItems = 0;
    }

    private int hashFunction(Weapon weapon){
        int value=0,weight=1;
        String weapon_name = weapon.getWeaponName();
        for (int x =0; x < weapon_name.length();x++){
            value += (weapon_name.charAt(x)-'a'+1)*weight;
            weight++;
        }
        return value%tableSize;
    }

    public void insert (Weapon weapon){
        if (numItems/tableSize < loadFactor){
            int count = 1;
            int startLoc =hashFunction(weapon);
            int loc = startLoc;
            //collusion
            while (table[loc] != null  && table[loc].getWeaponName().compareTo("DELETED")!=0){
                loc = (loc+(count^2))%tableSize;
                count++;
            }
            table[loc]=weapon;
            numItems++;
        }
    }

    public int search(Weapon weapon){
        int count = 1;
        String weapon_name = weapon.getWeaponName();
        int loc = hashFunction(weapon);
        while (table[loc].getWeaponName().compareTo(weapon_name)!=0 && table[loc].getWeaponName().compareTo("EMPTY")!=0){
            loc = (loc + (count^2))%tableSize;
            count++;
        }
        if (table[loc].getWeaponName().compareTo("EMPTY")==0)
            return -1;
        return loc;
    }

    public void delete(Weapon weapon){
        int loc = search(weapon);
        if(loc == -1){
            return;
        }
        table[loc].setWeaponName("DELETED");
        numItems--;
    }
}
