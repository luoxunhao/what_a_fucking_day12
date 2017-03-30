package algs.stack_and_queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**

 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大

 注意：牛客网的oj系统不支持comparator参数，所以刷题时要使用comparable接口
 */
public class MaxConsumeAmount {
    /*
    static class Customer implements Comparable<Customer>{
        int peopleCount;
        int moneyCount;

        public Customer(int peopleCount, int moneyCount) {
            this.peopleCount = peopleCount;
            this.moneyCount = moneyCount;
        }

        public int compareTo(Customer o) {
            if (o.moneyCount > this.moneyCount){
                return 1;
            }else if (o.moneyCount < this.moneyCount){
                return -1;
            }else {
                return 0;
            }
        }
    }*/
    static class Customer {
        int peopleCount;
        int moneyCount;
        public Customer(int peopleCount, int moneyCount) {
            this.peopleCount = peopleCount;
            this.moneyCount = moneyCount;
        }
    }

    public static int getMaxConsume(int[] desk, int[] people, int[] money, int n, int m){
        Arrays.sort(desk); //桌子大小顺序
        PriorityQueue<Customer> queue = new PriorityQueue<>(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                if (o1.moneyCount > o2.moneyCount){
                    return -1;
                }else if (o1.moneyCount < o2.moneyCount){
                    return 1;
                }else {
                    return 0;
                }
            }
        }); //消费金额降序
        for (int i = 0; i < m; i++){
            if (people[i] <= desk[n-1]){
                queue.add(new Customer(people[i], money[i]));
            }
        }
        boolean[] visit = new boolean[n]; //桌子是否被使用
        int res = 0;
        int count = 0;//已经使用的桌子数
        while (!queue.isEmpty() && count != n){
            Customer cur = queue.poll();
            for (int i = 0; i < n; i++){
                if (!visit[i] && cur.peopleCount <= desk[i]){
                    res += cur.moneyCount;
                    visit[i] = true;
                    count++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt(), m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            int[] c = new int[m];
            for (int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++){
                b[i] = sc.nextInt();
                c[i] = sc.nextInt();
            }
            System.out.println(getMaxConsume(a,b,c,n,m));
        }
    }
}
