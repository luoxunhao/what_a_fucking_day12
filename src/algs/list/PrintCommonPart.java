package algs.list;

/**
 * Created by lxh on 2017/3/26.
 */
public class PrintCommonPart {
    static class ListNode{
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void printCommonPart(ListNode head1, ListNode head2){
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                cur1 = cur1.next;
            }else if(cur1.val > cur2.val){
                cur2 = cur2.next;
            }else {
                System.out.print(cur1.val + " ");
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
    }
}
