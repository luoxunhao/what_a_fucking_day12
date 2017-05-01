package algs.dp;

/**
 * Created by lxh on 2017/4/8.
 */
public class PassRate {
    private static int N;
    private static int[] P;

    private static double[][] dp;
    public static double solve1(){
        dp = new double[N+1][N+1];
        dp[0][0] = 1.0;
        for (int i = 1; i <= N; i++){
            dp[i][0] = dp[i-1][0] * (100-P[i-1])/100.0;
            for (int j = 1; j <= i; j++){
                dp[i][j] = dp[i-1][j-1]*P[i-1]/100.0 + dp[i-1][j]*(100-P[i])/100.0;
            }
        }
        int num = (int)Math.ceil(N*0.6);
        double ans = 0.0;
        for (int i = num; i <= N; i++){
            ans += dp[N][num];
        }
        return ans;
    }

    public static double solve2(int i, int j){
        if (i == N){
            return 0.0;
        }
        int num = (int)Math.ceil(N*0.6);
        if (j < num ){
            return 0.0;
        }else{
            return P[i]/100.0 * solve2(i+1,j+1) + (1-P[i])/100.0 * solve2(i+1,j);
        }
    }

    private static double[][] memo; //-1
    public static double solve3(int i, int j){
        if (i == N){
            return 0.0;
        }
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        int num = (int)Math.ceil(N*0.6);
        if (j < num ){
            return 0.0;
        }else{
            return memo[i][j] = P[i]/100.0 * solve3(i+1,j+1) + (1-P[i])/100.0 * solve3(i+1,j);
        }
    }
}
