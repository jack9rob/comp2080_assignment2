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
    }
}
