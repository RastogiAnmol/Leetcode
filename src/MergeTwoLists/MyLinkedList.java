package MergeTwoLists;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MyLinkedList {
    int size;
    ListNode head;  // sentinel node as pseudo-head
    public MyLinkedList(int x) {
        size = x;
        head = new ListNode(0);
    }
    public void initializeLinkedList(){
        ListNode prev = head;
        for (int i = 1; i <= size; i++) {
            var tobeAdded = new ListNode(i);
            prev.next = tobeAdded;
            prev = tobeAdded;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        MyLinkedList lst1 = new MyLinkedList(4);
        lst1.initializeLinkedList();
        MyLinkedList lst2 = new MyLinkedList(8);
        lst2.initializeLinkedList();
        ListNode mergedLists = mergeTwoLists(lst1.head, lst2.head);
    }
}

