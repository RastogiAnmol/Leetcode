package FlattenDoublyLinkedList;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

public class MyLinkedList {
    int size;
    Node head;  // sentinel node as pseudo-head

    public Node flatten(Node head) {
        if (head == null) return head;
        // pseudo head to ensure the `prev` pointer is never none
        Node pseudoHead = new Node(0, null, head, null);

        flattenDFS(pseudoHead, head);

        // detach the pseudo head from the real head
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }
    /* return the tail of the flatten list */
    public Node flattenDFS(Node prev, Node curr) {
        if (curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;

        // the curr.next would be tempered in the recursive function
        Node tempNext = curr.next;

        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, tempNext);
    }

    public Node CreateDummyList(){
        Node a1 = new Node(1,null,null,null), a2 = new Node(2,null,null,null),
             a3 = new Node(3,null,null,null), a4 = new Node(4,null,null,null),
             a5 = new Node(5,null,null,null), a6 = new Node(6,null,null,null),
             a7 = new Node(7,null,null,null), a8 = new Node(8,null,null,null),
             a9 = new Node(9,null,null,null);
        head = a1;
        a1.next = a2;
        a2.prev = a1;
        a2.next = a3;
        a3.prev = a2;
        a3.next = a4;
        a4.prev = a3;
        a2.child = a5;
        a5.next = a6;
        a6.prev = a5;
        a6.next = a7;
        a7.prev = a6;
        a6.child = a8;
        a8.next = a9;
        a9.prev = a8;
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList lst = new MyLinkedList();
        Node head = lst.CreateDummyList();
        Node cur = lst.flatten(head);
        while(cur != null){
            System.out.print(cur.val + " ------> ");
            cur = cur.next;
        }
    }
}

