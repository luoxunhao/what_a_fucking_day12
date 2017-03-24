package algs.string;

import java.util.Scanner;

/**
 * Created by lxh on 2017/3/24.
 */
public class LongestPalindromeSubsquence {

    public static int palindromeLength(String s){
        char[] s1 = s.toCharArray();
        char[] s2 = reverse(s);
        int len = s1.length;
        int[][] dp = new int[len][len];
        dp[0][0] = s1[0] == s2[0] ? 1 : 0;
        //first col
        for (int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0], s1[i] == s2[0] ? 1 : 0);
        }
        //first row
        for (int i = 1; i < len; i++){
            dp[0][i] = Math.max(dp[0][i-1], s1[0] == s2[i] ? 1 : 0);
        }
        //dp[i][j]
        for (int i = 1; i < len; i++){
            for (int j = 1; j < len; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (s1[i] == s2[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }
        return len - dp[len-1][len-1];
    }

    public static char[] reverse(String s){
        char[] s2 = s.toCharArray();
        int low = 0, high = s.length() - 1;
        while (low < high){
            char tmp = s2[low];
            s2[low++] = s2[high];
            s2[high--] = tmp;
        }
        return s2;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            //String s = "wabnpiydrsypubmmwcqmgzpzgvqwcecezpaajzyauiikxyaghuyhrkwguv";
            String s = sc.nextLine();
            System.out.println(palindromeLength(s));
        }
    }
}
