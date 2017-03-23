package algs.dp;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
 * 按字典顺序输出
 */
public class PermutationOfSumK {
    public static int[][] getDP (int n, int m){
        if (m <= 0){
            return null;
        }
        n = n > m ? m : n;
        int[][] dp = new int[n][m+1];
        //第一行只有dp[0][1] = 1，第一列全部为0
        dp[0][1] = 1;
        //dp[i][j]
        for (int i = 1; i < n ; i++){
            for (int j = 1; j < m + 1; j++){
                int extra = 0;
                if (i+1 == j){
                    extra = 1;
                }else if (i+1 < j){
                    extra = dp[i-1][j-i-1];
                }
                dp[i][j] = dp[i-1][j] + extra;
            }
        }
        return dp;
    }
    public static void permutationOfSumK(int n, int m) {
        int[][] dp = getDP(n, m);
        //根据DP矩阵回溯求组合
        for (int i = n-1; i > -1; i--){
            if (dp[i][m] == 0){
                break;
            }
            printPath(dp, i, m);
        }
    }

    public static void printPath(int[][] dp, int i, int j){
        System.out.print(i+1 + " ");
        if (i+1 == j){
            System.out.println();
            return;
        }
        while (dp[i][j] != 0){
            j = j - i - 1;
            if (j < 1){
                break;
            }
            i--;
            System.out.print(j  + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int n = 7, m = 7;
        permutationOfSumK(n, m);
    }
}
