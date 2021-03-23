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

    public boolean contains(String weaponName) {
        WNode curr = head;
        while(curr != null) {
            if(curr.data.getName().equals(weaponName)) {
                return true;
            }
        }
        return false;
    }

    public Weapon getWeapon(String weaponName) {
        WNode curr = head;
        while(curr != null) {
            if(curr.data.getName().equals(weaponName)) {
                return curr.data;
            }
        }
        return null;
    }
}
