package algs.dp.pack_problem;

import java.util.Scanner;

/**
 * Created by lxh on 2017/3/29.
 */
public class ZeroOnePack {
    public static int maxValue(int[] weight, int[] value, int V){
        int[] dp = new int[V+1];
        //初始化第一行
        for (int j = 0; j < V+1; j++){
            dp[j] = weight[0] <= j ? value[0] : 0;
        }
        //0-1背包，从后往前更新
        for (int i = 1; i < weight.length; i++){
            for (int j = V; j >= weight[i]; j--){
                //if (weight[i] <= j){
                    dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
                //}
            }
        }
        return dp[V];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int V = sc.nextInt();
            int[] weight = new int[n];
            int[] value = new int[n];
            for (int i = 0; i < n; i++){
                weight[i] = sc.nextInt();
                value[i] = sc.nextInt();
            }
            System.out.println(maxValue(weight,value,V));
        }
    }
}
