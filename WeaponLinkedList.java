public class WeaponLinkedList {

    // node class
    private class WNode{
        public Weapon data;
        public WNode next;
        public WNode(Weapon data) {
            this.data = data;
            next=null;
        }
    }

    private WNode head;

    public WeaponLinkedList() {
        head = null;
    }

    public void insert(Weapon item) {
        WNode newNode = new WNode(item);
        if(head == null) {
            head = newNode;
            return;
        }
        WNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public Weapon getWeapon(String weaponName) {
        WNode curr = head;
        while(curr != null) {
            if(curr.data.getWeaponName().equals(weaponName)) {
                return curr.data;
            }
        }
        return null;
    }

    public boolean search(String weaponName) {
        WNode curr = head;
        while(curr != null) {
            if(curr.data.getWeaponName().equals(weaponName)) {
                return true;
            }
        }
        return false;
    }

    // need a string method
    public String print() {
        WNode curr = head;
        String value = "";
        while(curr != null) {
            value += curr.data.getWeaponName() + " " + curr.data.getRange() + " " + curr.data.getDamage() + " " + curr.data.getWeight() + " " + curr.data.getCost() + "\n";
            curr = curr.next;
        }
        return value;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
