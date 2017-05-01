package test.baidu;

/*
import java.util.*;

public class Main1 {
    public static int n;
    public static int[] p = new int[1000];

    private static class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MyComparator myComparator = new MyComparator();
        PriorityQueue<Integer> queue = new PriorityQueue<>(myComparator);
        while (sc.hasNext()){
            n = sc.nextInt();
            for (int i = 0; i < n; i++){
                p[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++){
                if (queue.size() == 3){
                    if (p[i] < queue.peek()){
                        queue.poll();
                        queue.add(p[i]);
                    }
                }else {
                    if (queue.isEmpty() || p[i] != queue.peek()){
                        queue.add(p[i]);
                    }
                }
            }
            System.out.println(queue.peek());
        }
    }
}
*/
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by lxh on 2017/5/1.
 */
public class Main1 {
    public static int n;
    public static int[] p = new int[1000];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<Integer>();
        while (sc.hasNext()){
            n = sc.nextInt();
            for (int i = 0; i < n; i++){
                p[i] = sc.nextInt();
                set.add(p[i]);
            }
            for (int i = 1; i <= 2; i++){
                if (!set.isEmpty()){
                    set.pollFirst();
                }
            }
            if (!set.isEmpty()){
                System.out.println(set.pollFirst());
            }
        }
    }
}
