package algs.dp.coins_problem;

/**
 * 硬币不可重复使用，0-1背包
 */
public class CoinsMethodsII {
    public static int countWays1(int n) {
        int[] arr = {3, 3, 6, 25};
        int[][] dp = new int[4][n+1];
        for (int i = 0; i < 4; i++){
            dp[i][0] = 1;
        }
        if (arr[0] <= n){
            dp[0][arr[0]] = 1;
        }
        for (int i = 1; i < 4; i++){
            for (int j = 1; j <= n; j++){
                dp[i][j] = dp[i-1][j];
                dp[i][j] += j-arr[i] >= 0 ? dp[i-1][j-arr[i]] : 0;
            }
        }
        return dp[3][n];
    }

    public static int countWays2(int n) {
        int[] arr = {3, 3, 6, 25};
        int[] dp = new int[n+1];
        dp[0] = 1;
        if (arr[0] <= n){
            dp[arr[0]] = 1;
        }
        //从后往前更新
        for (int i = 1; i < 4; i++){
            for (int j = n; j > 0; j--){
                dp[j] += j-arr[i] >= 0 ? dp[j-arr[i]] : 0;
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.println(countWays1(6));
        System.out.println(countWays2(6));
    }
}
