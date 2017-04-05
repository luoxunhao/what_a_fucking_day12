package algs.dp.coins_problem;

/**
 * 硬币可重复使用，完全背包
 */
public class CoinsMethodsI {

    public static int countWays1(int n) {
        int[] arr = {1, 5, 10, 25};
        int[][] dp = new int[4][n+1];
        for (int i = 0; i < 4; i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i * arr[0] <= n; i++){
            dp[0][i*arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; i++){
            for (int j = 1; j <= n; j++){
                dp[i][j] = dp[i-1][j];
                if (j-arr[i] >= 0){
                    dp[i][j] += dp[i][j-arr[i]];
                }
            }
        }
        return dp[3][n];
    }

    public static int countWays2(int n) {
        int[] arr = {1, 5, 10, 25};
        int[] dp = new int[n+1];
        for (int i = 0; i * arr[0] <= n; i++){
            dp[i*arr[0]] = 1;
        }
        //从前往后更新
        for (int i = 1; i < arr.length; i++){
            for (int j = 1; j <= n; j++){
                dp[j] += j-arr[i] >= 0 ? dp[j-arr[i]] : 0;
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.println(countWays1(10));
        System.out.println(countWays2(10));
    }
}
