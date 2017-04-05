package algs.dp.coins_problem;

/**
 * 硬币可重复使用
 */
public class CoinsMethodsI {
    public int countWays(int n) {
        int[] arr = {1, 5, 10, 25};
        int[] dp = new int[n+1];
        for (int i = 0; i * arr[0] <= n; i++){
            dp[i*arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; i++){
            for (int j = 1; j <= n; j++){
                dp[j] += j-arr[i] >= 0 ? dp[j-arr[i]] : 0;
            }
        }
        return dp[n];
    }
}
