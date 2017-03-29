package algs.list;

/**
 * Created by lxh on 2017/3/29.
 */
public class Josephus {
    static class Node{
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    public static Node josephus(Node head, int m){
        if (head == null || head.next == head || m < 1){
            return head;
        }
        Node last = head;
        while (last.next != head){
            last = last.next;
        }
        int count = 0;
        while (head != last){
            if (++count == m){
                last.next = head.next;
                count = 0;
            }else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    public static int josephus1(int n, int m){
        boolean[] live = new boolean[n];
        for (int i = 0; i < live.length; i++){
            live[i] = true;
        }
        int count = 0;//计数
        int num = 0;//出环的个数
        int i = 0;
        for (; ;i++){
            if (live[i]){
                if (++count == m){
                    live[i] = false;
                    count = 0;
                    num++;
                }
                if (num == n){
                    break;
                }
            }
            if(i == n-1){
                i = -1;
            }
        }
        return i+1;
    }

    public static void main(String[] args){
        System.out.println(josephus1(5,3));
    }
}
