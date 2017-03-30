package algs.list;

/**
 * Created by lxh on 2017/3/29.
 */
public class PartitionList {
    static class Node{
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    public static void nodeArrPartition(Node[] nodeArr, int pivot){
        /*
        int low = 0, high = nodeArr.length-1;
        while (low < high){
            while (low < high && nodeArr[low].value < pivot){
                low++;
            }
            while (low < high && nodeArr[high].value > pivot){
                high--;
            }
            if (low < high){
                Node tmp = nodeArr[low];
                nodeArr[low++] = nodeArr[high];
                nodeArr[high--] = tmp;
            }
        }*/
        int i = 0, small = -1, big = nodeArr.length;
        while (i != big){
            if (nodeArr[i].value < pivot){
                swap(nodeArr,++small,i++);
            }else if (nodeArr[i].value == pivot){
                i++;
            }else {
                swap(nodeArr,--big,i++);
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b){
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        nodeArrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }


    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
         head1 = listPartition1(head1, 5);
        //head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }
}
