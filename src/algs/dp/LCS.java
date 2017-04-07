package algs.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lxh on 2017/4/7.
 */
public class LCS {
    private static char[] str1;
    private static char[] str2;
    private static int[][] dp;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            str1 = sc.nextLine().toCharArray();
            str2 = sc.nextLine().toCharArray();
            System.out.println(lcs());
        }
    }

    public static int lcs(){
        int N = str1.length;
        int M = str2.length;
        dp = new int[N+1][M+1];
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (str1[i-1] == str2[j-1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
                }
            }
        }
        return dp[N][M];
    }
}
