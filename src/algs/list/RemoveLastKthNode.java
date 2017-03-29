package algs.list;

/**
 * Created by lxh on 2017/3/29.
 */
public class RemoveLastKthNode {
    static class Node{
        int val;
        Node next = null;
        public Node(int val) {
            this.val = val;
        }
    }
    public static Node removeLastKthNode(Node head, int k){
        if (head == null || k < 1){
            return null;
        }
        Node cur = head;
        while (cur != null){
            cur = cur.next;
            k--;
        }
        if (k == 0){
            head = head.next;
        }
        if (k < 0){
            cur = head;
            while (++k < 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }


    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        printLinkedList(head1);
        head1 = removeLastKthNode(head1, 3);
        printLinkedList(head1);
    }
}
