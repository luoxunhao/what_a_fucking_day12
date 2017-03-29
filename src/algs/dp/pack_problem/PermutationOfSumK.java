package algs.dp.pack_problem;

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
        int[][] dp = new int[n+1][m+1];
        dp[0][0]=1;
        //第一列。第一行除了第一列，其他全为0
        for (int i = 1; i < n+1; i++){
            dp[i][0]=1;
        }
        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < m+1; j++){
                dp[i][j] = dp[i-1][j];
                dp[i][j] += j - i >= 0 ? dp[i-1][j-i] : 0;
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
        int n = 5, m = 5;
        permutationOfSumK(n, m);
    }
}
