package algs.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定整数a1,a2,...,an,判断是否可以从中选出若干数，使他们的和恰好为k.
 *
 */
public class SumIsK {
    private static int n;
    private static int k;
    private static int[] a = new int[10001];

    /*
    暴力搜索
     */
    public static boolean dfs(int i, int j){
        if (i == n){
            return j == k;
        }
        if (j > k){
            return false;
        }
        if (dfs(i+1, j + a[i])){
            return true;
        }
        if (dfs(i+1, j)){
            return true;
        }
        return false;
    }

    /*
    记忆化搜索
     */
    /*
    private static boolean[][] memo = new boolean[10001][10001];
    public static boolean solve(int i, int j){
        if (i == n){
            return j == k;
        }
        if (memo[i][j]){
            return memo[i][j];
        }
        boolean res = false;
        res |= solve(i+1, j) || solve(i+1, j+a[i]);
        return memo[i][j] = res;
    }*/

    /*
    动态规划
     */
    private static boolean[][] dp = new boolean[10001][10001];
    public static boolean dp(){
        dp[0][0] = true;
        for (int i = 1; i <= n; i++){
            dp[i][0] = true;
            for (int j = 1; j <= k; j++){
                dp[i][j] = dp[i-1][j];
                dp[i][j] |= j-a[i-1] >= 0 ? dp[i-1][j-a[i-1]] : false;
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args){
        //Arrays.fill(memo, false);
        //Arrays.fill(dp, false);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            k = sc.nextInt();
            for (int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            System.out.println(dfs(0,0));
            System.out.println(dp());
        }
    }
}
