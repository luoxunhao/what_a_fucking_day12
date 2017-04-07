package algs.dp.pack_problem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lxh on 2017/3/29.
 */
public class ZeroOnePack {
    private static int[] weight;
    private static int[] value;
    private static int N;
    private static int V;
    private static int[][] memo;
    private static int[][] dp;

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
            N = sc.nextInt();
            V = sc.nextInt();
            weight = new int[N];
            value = new int[N];
            memo = new int[N][V+1];
            Arrays.fill(memo,-1);
            for (int i = 0; i < N; i++){
                weight[i] = sc.nextInt();
                value[i] = sc.nextInt();
            }
            System.out.println(maxValue(weight,value,V));
        }
    }

    public static int solve1(int i, int j){
        int res;
        if (i == N){
            res = 0;
        }else if (weight[i] > j){
            res = solve1(i+1,j);
        }else {
            res = Math.max(solve1(i+1,j),solve1(i+1,j-weight[i])+value[i]);
        }
        return res;
    }

    public static int solve2(int i, int j){
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        int res;
        if (i == N){
            res = 0;
        }else if (weight[i] > j){
            res = solve2(i+1,j);
        }else {
            res = Math.max(solve2(i+1,j),solve2(i+1,j-weight[i])+value[i]);
        }
        return memo[i][j] = res;
    }


}
