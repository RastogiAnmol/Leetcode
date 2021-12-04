package Cycle;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class SinglyLinkedList {
    int size;
    ListNode head;  // sentinel node as pseudo-head
    public SinglyLinkedList(int x) {
        size = x;
        head = new ListNode(0);
    }

    public boolean hasCycle() {
        ListNode slowPointer = head, fastPointer = head.next;
        while (slowPointer != fastPointer){
            if(fastPointer == null || fastPointer.next == null){
                return false;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return true;
    }

    private ListNode getIntersect() {
        ListNode tortoise = head;
        ListNode hare = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }

        return null;
    }

    public ListNode detectCycle() {
        if (head == null) {
            return null;
        }

        // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an entrance to
        // a cycle.
        ListNode intersect = getIntersect();
        if (intersect == null) {
            return null;
        }

        // To find the entrance to the cycle, we have two pointers traverse at
        // the same speed -- one from the front of the list, and the other from
        // the point of intersection.
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }

    public void initializeLinkedList(){
        ListNode prev = head;
        for (int i = 1; i <= size; i++) {
            var tobeAdded = new ListNode(i);
            prev.next = tobeAdded;
            prev = tobeAdded;
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList lst = new SinglyLinkedList(7);
        lst.initializeLinkedList();
        // create cycle
        lst.head.next.next.next.next.next.next.next.next = lst.head.next.next.next.next;
//        if (lst.hasCycle()){
//            System.out.println("the linked list has a cycle");
//        }
//        else{
//            System.out.println("no cycle");
//        }
        lst.detectCycle();
    }
}
