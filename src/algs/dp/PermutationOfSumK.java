package algs.dp;


import java.util.LinkedList;

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
    public static void permutationOfSumK(int n, int m){
        int[][] dp = getDP(n, m);
        LinkedList<Integer> list = new LinkedList<>();
        path(m, n, list);
    }

    public static void path(int sum, int n, LinkedList<Integer> list){
        if (sum == 0){
            while (!list.isEmpty()){
                System.out.print(list.pollFirst()+" ");
            }
            System.out.println();
            return;
        }
        if (sum < 0 || n < 1){
            return;
        }
        list.addFirst(n);
        path(sum - n, n - 1, list);
        list.pollFirst();
        path(sum, n - 1, list);
    }

    public static void main(String[] args){
        int n = 7, m = 7;
        permutationOfSumK(n, m);
    }
}
