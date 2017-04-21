package test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by lxh on 2017/4/21.
 */
public class PreOrderTopK {
    private static int N;
    private static int K;

    static class Node{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    private static Node[] arr = new Node[1000];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            N = sc.nextInt();
            K = sc.nextInt();
            for (int i = 0; i < N; i++){
                int val = sc.nextInt();
                arr[i] = new Node(i, val);
            }
            int[] res = solve();
            for (int i = 0; i < K; i++){
                System.out.println(res[i]);
            }
        }
    }

    public static int[] solve(){
        PriorityQueue<Node> queue1 = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value > o2.value ? -1 : o1.value < o2.value ? 1 : 0;
            }
        });
        for (int i = 0; i < K; i++){
            queue1.add(arr[i]);
        }
        for (int i = K; i < N; i++){
            if (arr[i].value < queue1.peek().value){
                queue1.poll();
                queue1.add(arr[i]);
            }
        }
        PriorityQueue<Node> queue2 = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.index > o2.index ? 1 : o1.index < o2.index ? -1 : 0;
            }
        });
        while (!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        int[] res = new int[K];
        int i = 0;
        while (!queue2.isEmpty()){
            res[i++] = queue2.poll().value;
        }
        return res;
    }
}
