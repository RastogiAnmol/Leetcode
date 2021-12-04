package ReverseLinkedList;
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

    public ListNode reverseList() {
        if (head == null) {
            return head;
        }
        ListNode currentHead = head;
        while (head.next != null) {
            ListNode p = head.next;
            head.next = p.next;
            p.next = currentHead;
            currentHead = p;
        }
        return currentHead;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
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
        MyLinkedList lst = new MyLinkedList(4);
        lst.initializeLinkedList();
        lst.reverseList();
    }
}

