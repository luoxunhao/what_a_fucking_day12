package test;

import java.util.Scanner;

/**
 * Created by lxh on 2017/3/27.
 */
public class SumIsK {
    public static long methods(int[] arr, int m){
        /*
        int[][] dp = new int[arr.length][m+1];
        dp[0][arr[0]] = 1;
        for (int i = 0; i < arr.length; i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
             for (int j = 1; j <= m; j++){
                 dp[i][j] = j - arr[i] >= 0 ? dp[i-1][j] + dp[i-1][j-arr[i]] : dp[i-1][j];
             }
        }
        return dp[arr.length-1][m];
        */
        long[] dp = new long[m+1];
        dp[0] = 1;
        for(int i = 0; i < arr.length; i++){
            for(int j = m; j >= arr[i]; j--){
                dp[j] = dp[j] + dp[j-arr[i]];
            }
        }
        return dp[m];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            if (n <= 0){
                break;
            }
            int sum = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(methods(arr,sum));
        }
    }
}
