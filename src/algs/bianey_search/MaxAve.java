package algs.bianey_search;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/13.
 */
public class MaxAve {
    private static int n,k;
    private static int[] w = new int[100];
    private static int[] v = new int[100];
    public static double fun(int i, int k, int weight, int value){
        if (i == n){
            return 0.0;
        }
        if (k == 0){
            return value*1.0/weight;
        }
        return Math.max(fun(i+1, k, weight, value),
                        fun(i+1, k-1, weight+w[i], value+v[i]));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            k = sc.nextInt();
            for (int i = 0; i < n; i++){
                w[i] = sc.nextInt();
                v[i] = sc.nextInt();
            }
            System.out.println(fun(0,2,0,0));
        }
    }
}
