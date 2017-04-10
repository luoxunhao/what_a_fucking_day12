package algs.dp;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/9.
 */
public class LCSubstring {
    private static int[][] dp;
    private static char[] s1;
    private static char[] s2;

    public static int getDP(){
        int N1 = s1.length;
        int N2 = s2.length;
        dp = new int[N1+1][N2+1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N1; i++){
            //dp[i][0]赋值
            for (int j = 1; j <= N2; j++){
                dp[i][j] = s1[i-1] == s2[j-1] ? dp[i-1][j-1]+1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            s1 = sc.nextLine().toCharArray();
            s2 = sc.nextLine().toCharArray();
            System.out.println(getDP());
        }
    }
}
