package algs.list;

/**
 * Created by lxh on 2017/3/30.
 */
public class Review_FindFirstIntersectNode {
    static class Node{
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    //获得链表入环结点
    public static Node getLoopNode(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node slow = head.next, fast = head.next.next;
        while (slow != fast){
            if (slow.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //获得两无环链表的第一个相交结点
    public static Node getNoLoop(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1, cur2 = head2;
        int len1 = 0, len2 = 0;
        while (cur1 != null){
            len1++;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            len2++;
            cur2 = cur2.next;
        }
        if (cur1 != cur2){//不相交
            return null;
        }
        int n = len1 > len2 ? len1 - len2 : len2 - len1;
        cur1 = len1 > len2 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        while (n != 0){
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
