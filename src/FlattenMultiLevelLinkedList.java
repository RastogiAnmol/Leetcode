class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

public class FlattenMultiLevelLinkedList {
    /*Global variable pre to track the last node we visited */
    Node pre = null;
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        /*Connect last visted node with current node */
        if (pre != null) {
            pre.next = head;
            head.prev = pre;
        }

        pre = head;
        /*Store head.next in a next pointer in case recursive call to flatten head.child overrides head.next*/
        Node next = head.next;

        flatten(head.child);
        head.child = null;

        flatten(next);
        return head;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        one.next = two;
        two.prev = one;
        two.next = three;
        three.prev = two;
        three.next = four;
        four.prev = three;
        two.child = five;
        five.next = six;
        six.prev = five;
        six.next = seven;
        seven.prev = six;
        six.child = eight;
        eight.next = nine;
        nine.prev = eight;
        FlattenMultiLevelLinkedList obj = new FlattenMultiLevelLinkedList();
        obj.flatten(one);
    }
}