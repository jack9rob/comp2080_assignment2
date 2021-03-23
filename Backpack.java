public class Backpack {
    private int numItems;
    private int maxItems;
    private double currWeight;
    private double maxWeight;
    private WeaponTable weaponsTable;

    public Backpack(){
        numItems = 0; currWeight = 0;
        maxItems = 30; maxWeight = 90;
    }
    public void findItem(Weapon item){

    }
    public String viewItems(){
        String s = "";
        for(weaponsTable i : weaponsTable.hashtable){
            s += i + "\n";
        }
        return s;
    }
}
